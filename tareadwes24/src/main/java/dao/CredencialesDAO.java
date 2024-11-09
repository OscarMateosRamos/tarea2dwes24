package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Collection;

import modelo.Credenciales;
import utils.ConexBD;

public class CredencialesDAO {

	
=======
import java.util.Collection;

import modelo.Credenciales;
import modelo.Planta;

public class CredencialesDAO implements OperacionesCrud<Credenciales> {

>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
	Connection conex;
	ResultSet rs;
	Statement st;
	PreparedStatement ps;

<<<<<<< HEAD
	
=======
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
	public CredencialesDAO(Connection conex) {
		if (this.conex == null) {
			this.conex = conex;
		}
	}

<<<<<<< HEAD
	public long insertar(String usuario, String password) {

		try {

			ps = conex.prepareStatement("INSERT INTO credenciales(usuario,password) values (?,?)");

			ps.setString(1, usuario);
			ps.setString(2, password);
=======
	@Override
	public long insertar(Credenciales c) {

		try {

			String sql = "INSERT INTO credenciales(id,usuario,password) values (?,?,?)";
			ps = conex.prepareStatement(sql);

			ps.setLong(1, c.getId());
			ps.setString(2, c.getUsuario());
			ps.setString(3, c.getPassword());
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb

			return ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al insertar en Credenciales");
		}
		return 0;

	}

<<<<<<< HEAD
//PARA VER ADMIN

=======
	@Override
	public boolean modificar(Credenciales elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
	public Collection<Credenciales> verTodas() {
		// TODO Auto-generated method stub
		return null;
	}

<<<<<<< HEAD
	public boolean usuarioExistente(String usuario) {
		String usuarioExistente = "SELECT usuario FROM crededenciales";
		ArrayList<String> usuariosExistentes = new ArrayList<String>();
		try {
			ps = conex.prepareStatement(usuarioExistente);
			rs = ps.executeQuery();
			while (rs.next()) {
				usuariosExistentes.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (usuarioExistente.contains(usuario)) {
			return true;
		} else {
			return false;
		}

	}

	public long buscarIdPorUsuario(String usuario) {
		long id = 0;
		try {

			ps = conex.prepareStatement("SELECT id FROM credenciales WHERE usuario=?");
			ps.setString(1, usuario);
			rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getLong("id");

			}
		} catch (SQLException e) {
			System.out.println("error al consultar por usuario " + e.getMessage());

		}
		return id;

	}

	public boolean validarUsuario(String usuario) {

		try {
			if (this.conex == null || this.conex.isClosed()) {
				this.conex = ConexBD.realizaConexion();
			}
			ps = conex.prepareStatement("SELECT COUNT(*) FROM credenciales WHERE usuario=?");
			ps.setString(1, usuario);
			rs = ps.executeQuery();
			while (rs.next()) {

				if (rs.getInt(1) != 0) {
					return false;
				}

			}
		} catch (SQLException e) {
			System.out.println("error al consultar por usuario " + e.getMessage());
		}
		return true;
	}

	
	
	public boolean validarCredenciales(String usuario, String password) {

		try (PreparedStatement ps = conex.prepareStatement("SELECT *  FROM credenciales   ")) {

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				if (rs.getString("usuario").equals(usuario)&& rs.getString("password").equals(password)) {
					return true;
				}

=======
	public Credenciales buscarPorUsuario(String username) {
		String sql = "SELECT * FROM  credenciales WHERE usuario = ?";
		Credenciales c = null;

		try {

			PreparedStatement ps = conex.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("id");
				String usuario = rs.getString("usuario");
				String password = rs.getString("password");
				c = new Credenciales(id, usuario, password);
			}
		} catch (SQLException e) {
			System.out.println("error al consultar por usuario " + e.getMessage());

		}
		return c;

	}

	public boolean validarCredenciales(String usuario, String password) {
		String sql = "SELECT COUNT(*)  FROM credenciales WHERE usuario =? AND password=? ";
		try (PreparedStatement ps = conex.prepareStatement(sql)) {
			ps.setString(1, usuario);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return true;
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
			}

		} catch (SQLException e) {
			System.out.println("error al validar credenciales " + e.getMessage() + e.getStackTrace());
		}
		return false;

	}

<<<<<<< HEAD
=======
	@Override
	public Credenciales buscarPorID(long id) {

		return null;
	}

	@Override
	public boolean eliminar(Credenciales elemento) {
		// TODO Auto-generated method stub
		return false;
	}

>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
}
