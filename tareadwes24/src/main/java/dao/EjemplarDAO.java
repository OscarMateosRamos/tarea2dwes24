package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import modelo.Ejemplar;
import modelo.Mensaje;
import modelo.Planta;
import utils.ConexBD;

public class EjemplarDAO {

	Connection conex;
	ResultSet rs;
	Statement st;
	PreparedStatement ps;

	public EjemplarDAO(Connection conex) {
		if (this.conex == null) {
			this.conex = conex;
		}
	}

	public long insertar(Ejemplar ej) {
		String sql = "INSERT INTO ejemplares (nombre, idPlanta) VALUES (?, ?)";
		long id = 0;
		try (PreparedStatement ps = conex.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, ej.getNombre());
			ps.setString(2, ej.getIdPlanta());
			int nFilas = ps.executeUpdate();

			if (nFilas > 0) {
				try (ResultSet rs = ps.getGeneratedKeys()) {
					if (rs.next()) {
						id = rs.getLong(1);
					}
				}
			}
		} catch (SQLException e) {
			System.out.println("Error al insertar el ejemplar: " + e.getMessage());
		}
		return id;
	}

	
	
	
	
	public boolean modificarNombre(long id, String nombreNuevo) {
	    String sql = "UPDATE ejemplares SET nombre = ? WHERE id = ?";
	    try (PreparedStatement ps = conex.prepareStatement(sql)) {
	        ps.setString(1, nombreNuevo);
	        ps.setLong(2, id);
	        return ps.executeUpdate()>0;
	    } catch (SQLException e) {
	        System.out.println("Error al actualizar el nombre del ejemplar: " + e.getMessage());
	    }
	    return false;
	}
	

	public boolean modificar(Ejemplar ej) {
		try {

			String sql = "UPDATE ejemplares SET nombre = ? WHERE id = ?";
			PreparedStatement ps = conex.prepareStatement(sql);

			ps.setLong(1, ej.getId());

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			System.out.println("Error al modificar en planta" + e.getMessage());
		}
		return false;
	}

	public Collection<Ejemplar> verTodas() {
		String sql = "SELECT * FROM ejemplares";
		ArrayList<Ejemplar> ejemplares = new ArrayList<>();

		try {
			if (this.conex == null || this.conex.isClosed()) {
				this.conex = ConexBD.realizaConexion();
			}

			PreparedStatement ps = conex.prepareStatement(sql);

			ResultSet res = ps.executeQuery();
			while (res.next()) {

				Ejemplar ejemplar = new Ejemplar(res.getLong("id"), res.getString("nombre"), res.getString("idPlanta"));

				ejemplares.add(ejemplar);

			}
			conex.close();

		} catch (SQLException e) {
			System.out.println("Error al ver los ejemplares" + e.getMessage());
		}

		return ejemplares;
	}

	public Ejemplar buscarPorID(long identificador) {

		String sql = "SELECT * FROM ejemplares WHERE codigo = ?";
		Ejemplar ej = null;
		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			ps.setLong(1, identificador);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

			}
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Se ha producido una Exception: " + e.getMessage());
			e.printStackTrace();
		}

		return ej;

	}

	public boolean eliminar(Ejemplar ej) {
		try {

			String sql = "DELETE FROM ejemplares WHERE codigo = ?";
			PreparedStatement ps = conex.prepareStatement(sql);

			ps.setLong(1, ej.getId());

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			System.out.println("Error al eliminar en ejemplar" + e.getMessage());
		}

		return false;
	}

}
