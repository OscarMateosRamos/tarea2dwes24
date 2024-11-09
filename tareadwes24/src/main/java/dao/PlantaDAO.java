package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Collection;
=======
import java.util.Collection;
import java.util.HashSet;
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb

import modelo.Planta;
import utils.ConexBD;

<<<<<<< HEAD
public class PlantaDAO {
	
=======
public class PlantaDAO implements OperacionesCrud<Planta> {
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
	Connection conex;
	ResultSet rs;
	Statement st;
	PreparedStatement ps;

	public PlantaDAO(Connection conex) {
		if (this.conex == null) {
			this.conex = conex;
		}
	}

<<<<<<< HEAD
	public long insertar(Planta pl) {
		try {
			ps = conex.prepareStatement("INSERT INTO plantas(codigo,nombrecomun,nombrecientifico) values (?,?,?)");
=======
	@Override
	public long insertar(Planta pl) {

		try {

			ps = conex.prepareStatement("INSERT INTO planta(codigo,nombrecomun,nombrecientifico) values (?,?,?)");
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb

			ps.setString(1, pl.getCodigo());
			ps.setString(2, pl.getNombrecomun());
			ps.setString(3, pl.getNombrecientifico());

			return ps.executeUpdate();

		} catch (SQLException e) {
<<<<<<< HEAD
			System.out.println("Error al insertar en planta" + e.getMessage());
		}
		return 0;

	}

	/*
	 * public boolean modificar(Planta pl) { try {
	 * 
	 * String sql = "UPDATE planta SET nombrecomun = ?WHERE codigo = ?";
	 * PreparedStatement ps = conex.prepareStatement(sql);
	 * 
	 * ps.setString(1, pl.getCodigo()); ps.setString(2, pl.getNombrecomun());
	 * ps.setString(3, pl.getNombrecientifico());
	 * 
	 * return ps.executeUpdate() > 0; } catch (SQLException e) {
	 * System.out.println("Error al modificar en planta" + e.getMessage()); } return
	 * false;
	 * 
	 * }
	 */

	public boolean modificarNombrecomun(String codigo, String nombrecomun) {
		try {
			ps = conex.prepareStatement("UPDATE plantas SET nombrecomun = ? WHERE codigo = ?");

			ps.setString(1, nombrecomun);
			ps.setString(2, codigo);
=======
			System.out.println("Error al insertar en planta"+e.getMessage());
		}
		return 0;

	} 

	@Override
	public boolean modificar(Planta pl) {
		try {

			String sql = "UPDATE planta SET nombrecomun = ?WHERE codigo = ?";
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

	public boolean modificarNombrecomun(String codigo, String nombrecomun) {
		try {

			String sql = "UPDATE planta SET nombrecomun = ?WHERE codigo = ?";
			PreparedStatement ps = conex.prepareStatement(sql);

			ps.setString(1, codigo);
			ps.setString(2, nombrecomun);
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			System.out.println("Error al modificar en planta" + e.getMessage());
		}

		return false;
	}

	public boolean modificarNombrecientifico(String codigo, String nombrecientifico) {
		try {

<<<<<<< HEAD
			ps = conex.prepareStatement("UPDATE plantas SET nombrecientifico = ? WHERE codigo = ?");

			ps.setString(1, nombrecientifico);
			ps.setString(2, codigo);
=======
			String sql = "UPDATE planta SET nombrecientifico = ?WHERE codigo = ?";
			PreparedStatement ps = conex.prepareStatement(sql);

			ps.setString(1, codigo);
			ps.setString(2, nombrecientifico);
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			System.out.println("Error al modificar en planta" + e.getMessage());
		}

		return false;
	}

<<<<<<< HEAD
	public Collection<Planta> verTodas() {
		String sql = "SELECT * FROM plantas ORDER BY nombrecomun";
		ArrayList<Planta> plantas = new ArrayList<>();
=======
	@Override
	public Collection<Planta> verTodas() {
		String sql = "SELECT * FROM plantas";
		HashSet<Planta> plantas = new HashSet<>();
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb

		try {
			if (this.conex == null || this.conex.isClosed()) {
				this.conex = ConexBD.realizaConexion();
			}

			PreparedStatement ps = conex.prepareStatement(sql);

<<<<<<< HEAD
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Planta pl = new Planta(rs.getString("codigo"), rs.getString("nombrecomun"),
						rs.getString("nombrecientifico"));
				plantas.add(pl);
			}

			for (Planta pl : plantas) {
				System.out.println(pl);
=======
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				Planta planta = new Planta(res.getString("codigo"), res.getString("nombrecomun"),
						res.getString("nombrecientifico"));
				plantas.add(planta);
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
			}
			ConexBD.cerrarConexion();

		} catch (SQLException e) {
			System.out.println("Error al ver las plantas" + e.getMessage());
		}

		return plantas;
	}

<<<<<<< HEAD
	public Planta buscarPorCodigo(String id) {
		Planta pl = null;

		try {
			if (this.conex == null || this.conex.isClosed()) {
				this.conex = ConexBD.realizaConexion();
			}

			ps = conex.prepareStatement("SELECT * FROM plantas WHERE codigo = ?");
			ps.setString(1, id);
=======
	@Override
	public Planta buscarPorID(long id) {
		String sql = "SELECT * FROM plantas WHERE codigo = ?";
		Planta pl = null;
		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			ps.setLong(1, id);
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String codigo = rs.getString("codigo");
				String nombreComun = rs.getString("nombrecomun");
				String nombreCientifico = rs.getString("nombrecientifico");
				pl = new Planta(codigo, nombreComun, nombreCientifico);
<<<<<<< HEAD

=======
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
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

<<<<<<< HEAD
=======
	@Override
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
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

<<<<<<< HEAD
	
	
	
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

=======
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
}
