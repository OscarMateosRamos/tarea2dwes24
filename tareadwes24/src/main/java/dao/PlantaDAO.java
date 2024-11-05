package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;

import modelo.Planta;
import utils.ConexBD;

public class PlantaDAO implements OperacionesCrud<Planta> {
	Connection conex;
	ResultSet rs;
	Statement st;
	PreparedStatement ps;

	public PlantaDAO(Connection conex) {
		if (this.conex == null) {
			this.conex = conex;
		}
	}

	@Override
	public long insertar(Planta pl) {

		try {

			String sql = "INSERT INTO planta(codigo,nombrecomun,nombrecientifico) values (?,?,?)";
			ps = conex.prepareStatement(sql);

			ps.setString(1, pl.getCodigo());
			ps.setString(2, pl.getNombrecomun());
			ps.setString(3, pl.getNombrecientifico());

			return ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al insertar en planta");
		}
		return 0;

	}

	@Override
	public boolean modificar(Planta pl) {
		try {

			String sql = "UPDATE planta SET nombrecomun = ?, nombrecientifico = ? WHERE codigo = ?";
			PreparedStatement ps = conex.prepareStatement(sql);

			ps.setString(1, pl.getCodigo());
			ps.setString(2, pl.getNombrecomun());
			ps.setString(3, pl.getNombrecientifico());

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			System.out.println("Error al modificar en planta" + e.getMessage());
		}
		return false;

	}

	@Override
	public Collection<Planta> verTodas() {
		String sql = "SELECT * FROM plantas";
		HashSet<Planta> plantas = new HashSet<>();

		try {
			if (this.conex == null || this.conex.isClosed()) {
				this.conex = ConexBD.realizaConexion();
			}

			PreparedStatement ps = conex.prepareStatement(sql);

			ResultSet res = ps.executeQuery();
			while (res.next()) {
				Planta planta = new Planta(res.getString("codigo"), res.getString("nombrecomun"),
						res.getString("nombrecientifico"));
				plantas.add(planta);
			}
			conex.close();

		} catch (SQLException e) {
			System.out.println("Error al ver las plantas" + e.getMessage());
		}

		return plantas;
	}

	@Override
	public Planta buscarPorID(long id) {

		String sql = "SELECT * FROM plantas WHERE codigo = ?";
		Planta pl = null;
		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			ps.setLong(1, id);
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

	
	@Override
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

}
