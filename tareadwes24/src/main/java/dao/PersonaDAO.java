package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;

import modelo.Persona;
import modelo.Planta;
import utils.ConexBD;

public class PersonaDAO implements OperacionesCrud<Persona> {

	Connection conex;
	private PreparedStatement ps;
	private ResultSet rs;

	public PersonaDAO(Connection conex) {

		if (this.conex == null) {
			this.conex = conex;
		}
	}

	@Override
	public long insertar(Persona p) {

		try {

			String sql = "INSERT INTO persona(id,nombre,email,id_Credencial) values (?,?,?,?)";
			ps = conex.prepareStatement(sql);

			ps.setLong(1, p.getId());
			ps.setString(2, p.getNombre());
			ps.setString(3, p.getEmail());
			ps.setLong(3, p.getId_Credencial());

			return ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al insertar en persona" + e.getMessage());
		}
		return 0;
	}

	@Override
	public boolean modificar(Persona p) {
		try {

			String sql = "UPDATE persona SET email = ?, admin = ?,id_Credencial=? WHERE id = ?";
			PreparedStatement ps = conex.prepareStatement(sql);

			ps.setString(1, p.getEmail());
			ps.setString(2, p.getNombre());
			ps.setLong(3, p.getId_Credencial());
			ps.setLong(4, p.getId());

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			System.out.println("Error al modificar en persona" + e.getMessage());
		}
		return false;

	}

	@Override
	public Collection<Persona> verTodas() {
		String sql = "SELECT * FROM persona";
		HashSet<Persona> personas = new HashSet<>();

		try {
			if (this.conex == null || this.conex.isClosed()) {
				this.conex = ConexBD.realizaConexion();
			}

			PreparedStatement ps = conex.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Persona persona = new Persona(rs.getLong("id"), rs.getString("admin"), rs.getString("email"),
						rs.getLong("id_Credencial"));
				personas.add(persona);
			}
			ConexBD.cerrarConexion();
		} catch (SQLException e) {
			System.out.println("Error al ver las personas" + e.getMessage());
		}

		return personas;
	}

	@Override
	public Persona buscarPorID(long identificador) {
		String sql = "SELECT * FROM persona WHERE id = ?";
		Persona p = null;
		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			ps.setLong(1, identificador);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("id");
				String admin = rs.getString("admin");
				String email = rs.getString("email");
				long id_Credencial = rs.getLong("id_Credencial");
				p = new Persona(id, admin, email, id_Credencial);
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
	}

}
