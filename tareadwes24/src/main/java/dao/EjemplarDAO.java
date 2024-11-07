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

public class EjemplarDAO implements OperacionesCrud<Ejemplar> {

	Connection conex;
	ResultSet rs;
	Statement st;
	PreparedStatement ps;

	public EjemplarDAO(Connection conex) {
		if (this.conex == null) {
			this.conex = conex;
		}
	}

	@Override
	public long insertar(Ejemplar ej) {
		try {

			String sql = "INSERT INTO ejemplar(id,nombre,idPlanta) values (?,?,?)";
			ps = conex.prepareStatement(sql);

			ps.setLong(1, ej.getId());
			ps.setString(2, ej.getNombre());
			ps.setString(3, ej.getIdPlanta());

			return ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al insertar en ejemplar" + e.getMessage());
		}
		return 0;
	}

	@Override
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

	@Override
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

	@Override
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

	@Override
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
