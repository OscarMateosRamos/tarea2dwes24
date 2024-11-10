package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import modelo.Credenciales;
import utils.ConexBD;

public class CredencialesDAO {

	Connection conex;
	ResultSet rs;
	Statement st;
	PreparedStatement ps;

	public CredencialesDAO(Connection conex) {
		if (this.conex == null) {
			this.conex = conex;
		}
	}

	public long insertar(String usuario, String password) {

		try {

			ps = conex.prepareStatement("INSERT INTO credenciales(usuario,password) values (?,?)");

			ps.setString(1, usuario);
			ps.setString(2, password);

			return ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al insertar en Credenciales");
		}
		return 0;

	}



	public Collection<Credenciales> verTodas() {
		// TODO Auto-generated method stub
		return null;
	}

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

			}

		} catch (SQLException e) {
			System.out.println("error al validar credenciales " + e.getMessage() + e.getStackTrace());
		}
		return false;

	}

}
