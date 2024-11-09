package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import modelo.Persona;
import modelo.Planta;
import utils.ConexBD;

public class PersonaDAO {

	Connection conex;
	private PreparedStatement ps;
	private ResultSet rs;

	public PersonaDAO(Connection conex) {

		if (this.conex == null) {
			this.conex = conex;
		}
	}

	public long insertar(Persona p) {

		try {
			if (this.conex == null || this.conex.isClosed()) {
				this.conex = ConexBD.realizaConexion();
			}

			ps = conex.prepareStatement("INSERT INTO personas(nombre,email,idCredencial) values (?,?,?)");

			ps.setString(1, p.getNombre());
			ps.setString(2, p.getEmail());
			ps.setLong(3, p.getIdCredencial());

			return ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al insertar en persona " + e.getMessage());
		}
		return 0;
	}

	public boolean modificar(Persona p) {
		try {

			String sql = "UPDATE personas SET email = ?, admin = ?,idCredencial=? WHERE id = ?";
			PreparedStatement ps = conex.prepareStatement(sql);

			ps.setString(1, p.getEmail());
			ps.setString(2, p.getNombre());
			ps.setLong(3, p.getIdCredencial());
			ps.setLong(4, p.getId());

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			System.out.println("Error al modificar en persona" + e.getMessage());
		}
		return false;

	}

	public Collection<Persona> verTodas() {
		ArrayList<Persona> personas = new ArrayList<>();

		try {
			if (this.conex == null || this.conex.isClosed()) {
				this.conex = ConexBD.realizaConexion();
			}

			PreparedStatement ps = conex.prepareStatement("SELECT * FROM personas");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Persona p = new Persona(rs.getLong("id"), rs.getString("nombre"), rs.getString("email"),
						rs.getLong("idCredencial"));
				personas.add(p);
			}

			for (Persona p : personas) {
				System.out.println(p);
			}
			ConexBD.cerrarConexion();
		} catch (SQLException e) {
			System.out.println("Error al ver las personas" + e.getMessage());
		}

		return personas;
	}

	public Persona buscarPorID(long identificador) {
		String sql = "SELECT * FROM personas WHERE id = ?";
		Persona p = null;
		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			ps.setLong(1, identificador);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("id");
				String admin = rs.getString("admin");
				String email = rs.getString("email");
				long idCredencial = rs.getLong("idCredencial");
				p = new Persona(id, admin, email, idCredencial);
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
	}

}
