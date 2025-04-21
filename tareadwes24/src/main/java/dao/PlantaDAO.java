package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import modelo.Planta;
import utils.ConexBD;

public class PlantaDAO {
	Connection conex;
	ResultSet rs;
	Statement st;
	PreparedStatement ps;

	public PlantaDAO(Connection conex) {
		if (this.conex == null) {
			this.conex = conex;
		}
	}

	public long insertar(Planta pl) {
		try {
			ps = conex.prepareStatement("INSERT INTO plantas(codigo,nombrecomun,nombrecientifico) values (?,?,?)");

			ps.setString(1, pl.getCodigo());
			ps.setString(2, pl.getNombrecomun());
			ps.setString(3, pl.getNombrecientifico());

			return ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al insertar en planta" + e.getMessage());
		}
		return 0;
	}

	public boolean modificarNombrecomun(String codigo, String nombrecomun) {
		try {
			ps = conex.prepareStatement("UPDATE plantas SET nombrecomun = ? WHERE codigo = ?");

			ps.setString(1, nombrecomun);
			ps.setString(2, codigo);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			System.out.println("Error al modificar en planta" + e.getMessage());
		}
		return false;
	}

	public boolean modificarNombrecientifico(String codigo, String nombrecientifico) {
		try {
			ps = conex.prepareStatement("UPDATE plantas SET nombrecientifico = ? WHERE codigo = ?");
			ps.setString(1, nombrecientifico);
			ps.setString(2, codigo);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			System.out.println("Error al modificar en planta" + e.getMessage());
		}
		return false;
	}

	public Collection<Planta> verTodas() {
		String sql = "SELECT * FROM plantas ORDER BY nombrecomun";
		ArrayList<Planta> plantas = new ArrayList<>();

		try {
			if (this.conex == null || this.conex.isClosed()) {
				this.conex = ConexBD.realizaConexion();
			}

			PreparedStatement ps = conex.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Planta pl = new Planta(rs.getString("codigo"), rs.getString("nombrecomun"),
						rs.getString("nombrecientifico"));
				plantas.add(pl);
			}

			for (Planta pl : plantas) {
				System.out.println(pl);
			}
		//	ConexBD.cerrarConexion();

		} catch (SQLException e) {
			System.out.println("Error al ver las plantas" + e.getMessage());
		}
		return plantas;
	}

	public Planta buscarPorCodigo(String id) {
		Planta pl = null;

		try {
			if (this.conex == null || this.conex.isClosed()) {
				this.conex = ConexBD.realizaConexion();
			}

			ps = conex.prepareStatement("SELECT * FROM plantas WHERE codigo = ?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String codigo = rs.getString("codigo");
				String nombreComun = rs.getString("nombrecomun");
				String nombreCientifico = rs.getString("nombrecientifico");
				pl = new Planta(codigo, nombreComun, nombreCientifico);

			}
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Se ha producido una Exception: " + e.getMessage());
			e.printStackTrace();
		}

		return pl;
	}

	public boolean eliminar(Planta pl) {
		try {

			String sql = "DELETE FROM plantas WHERE codigo = ?";
			PreparedStatement ps = conex.prepareStatement(sql);

			ps.setString(1, pl.getCodigo());

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			System.out.println("Error al eliminar en planta" + e.getMessage());
		}
		return false;
	}

	public boolean existePorCodigo(String id) {
		Planta pl = null;

		try {
			if (this.conex == null || this.conex.isClosed()) {
				this.conex = ConexBD.realizaConexion();
			}

			ps = conex.prepareStatement("SELECT * FROM plantas WHERE codigo = ?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				return true;

			}
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Se ha producido una Exception: " + e.getMessage());
			e.printStackTrace();
		}

		return false;
	}

}
