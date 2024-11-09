package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Collection;
=======
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb

import modelo.Persona;
import modelo.Planta;
import utils.ConexBD;

<<<<<<< HEAD
public class PersonaDAO {
	
	
=======
public class PersonaDAO implements OperacionesCrud<Persona> {

>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
	Connection conex;
	private PreparedStatement ps;
	private ResultSet rs;

	public PersonaDAO(Connection conex) {

		if (this.conex == null) {
			this.conex = conex;
		}
	}

<<<<<<< HEAD
	public long insertar(Persona p) {

		try {
			if (this.conex == null || this.conex.isClosed()) {
				this.conex = ConexBD.realizaConexion();
			}

			ps = conex.prepareStatement("INSERT INTO personas(nombre,email,idCredencial) values (?,?,?)");

			ps.setString(1, p.getNombre());
			ps.setString(2, p.getEmail());
			ps.setLong(3, p.getIdCredencial());
=======
	@Override
	public long insertar(Persona p) {

		try {

			String sql = "INSERT INTO persona(id,nombre,email,id_Credencial) values (?,?,?,?)";
			ps = conex.prepareStatement(sql);

			ps.setLong(1, p.getId());
			ps.setString(2, p.getNombre());
			ps.setString(3, p.getEmail());
			ps.setLong(3, p.getId_Credencial());
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb

			return ps.executeUpdate();

		} catch (SQLException e) {
<<<<<<< HEAD
			System.out.println("Error al insertar en persona " + e.getMessage());
=======
			System.out.println("Error al insertar en persona" + e.getMessage());
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
		}
		return 0;
	}

<<<<<<< HEAD
	public boolean modificar(Persona p) {
		try {

			String sql = "UPDATE personas SET email = ?, admin = ?,idCredencial=? WHERE id = ?";
=======
	@Override
	public boolean modificar(Persona p) {
		try {

			String sql = "UPDATE persona SET email = ?, admin = ?,id_Credencial=? WHERE id = ?";
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
			PreparedStatement ps = conex.prepareStatement(sql);

			ps.setString(1, p.getEmail());
			ps.setString(2, p.getNombre());
<<<<<<< HEAD
			ps.setLong(3, p.getIdCredencial());
=======
			ps.setLong(3, p.getId_Credencial());
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
			ps.setLong(4, p.getId());

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			System.out.println("Error al modificar en persona" + e.getMessage());
		}
		return false;

	}

<<<<<<< HEAD
	public Collection<Persona> verTodas() {
		ArrayList<Persona> personas = new ArrayList<>();
=======
	@Override
	public Collection<Persona> verTodas() {
		String sql = "SELECT * FROM persona";
		HashSet<Persona> personas = new HashSet<>();
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb

		try {
			if (this.conex == null || this.conex.isClosed()) {
				this.conex = ConexBD.realizaConexion();
			}

<<<<<<< HEAD
			PreparedStatement ps = conex.prepareStatement("SELECT * FROM personas");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Persona p = new Persona(rs.getLong("id"), rs.getString("nombre"), rs.getString("email"),
						rs.getLong("idCredencial"));
				personas.add(p);
			}

			for (Persona p : personas) {
				System.out.println(p);
=======
			PreparedStatement ps = conex.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Persona persona = new Persona(rs.getLong("id"), rs.getString("admin"), rs.getString("email"),
						rs.getLong("id_Credencial"));
				personas.add(persona);
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
			}
			ConexBD.cerrarConexion();
		} catch (SQLException e) {
			System.out.println("Error al ver las personas" + e.getMessage());
		}

		return personas;
	}

<<<<<<< HEAD
	public Persona buscarPorID(long identificador) {
		String sql = "SELECT * FROM personas WHERE id = ?";
=======
	@Override
	public Persona buscarPorID(long identificador) {
		String sql = "SELECT * FROM persona WHERE id = ?";
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
		Persona p = null;
		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			ps.setLong(1, identificador);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("id");
				String admin = rs.getString("admin");
				String email = rs.getString("email");
<<<<<<< HEAD
				long idCredencial = rs.getLong("idCredencial");
				p = new Persona(id, admin, email, idCredencial);
=======
				long id_Credencial = rs.getLong("id_Credencial");
				p = new Persona(id, admin, email, id_Credencial);
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
			}
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Se ha producido una Exception: " + e.getMessage());
			e.printStackTrace();
		}

		return p;
	}

<<<<<<< HEAD
	public Persona buscarPorEmail(String identificador) {
		String sql = "SELECT * FROM personas WHERE email = ?";
		Persona p = null;
		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			ps.setString(1, identificador);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("id");
				String nombre = rs.getString("nombre");
				String email = rs.getString("email");
				long idCredencial = rs.getLong("idCredencial");
				p = new Persona(id, nombre, email, idCredencial);
			}
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Se ha producido una Exception: " + e.getMessage());
			e.printStackTrace();
		}

		return p;
=======
	@Override
	public boolean eliminar(Persona p) {
		try {

			String sql = "DELETE FROM plantas WHERE codigo = ?";
			PreparedStatement ps = conex.prepareStatement(sql);

			ps.setLong(1, p.getId());

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			System.out.println("Error al eliminar en persona" + e.getMessage());
		}
		return false;
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
	}

}
