package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import modelo.Credenciales;
import modelo.Planta;

public class CredencialesDAO implements OperacionesCrud<Credenciales> {

	Connection conex;
	ResultSet rs;
	Statement st;
	PreparedStatement ps;

	public CredencialesDAO(Connection conex) {
		if (this.conex == null) {
			this.conex = conex;
		}
	}

	@Override
	public long insertar(Credenciales c) {

		try {

			String sql = "INSERT INTO credenciales(id,usuario,password) values (?,?,?)";
			ps = conex.prepareStatement(sql);

			ps.setLong(1, c.getId());
			ps.setString(2, c.getUsuario());
			ps.setString(3, c.getPassword());

			return ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al insertar en Credenciales");
		}
		return 0;

	}

	@Override
	public boolean modificar(Credenciales elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Credenciales> verTodas() {
		// TODO Auto-generated method stub
		return null;
	}

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
		String sql = "SELECT COUNT(*) AS 'cantidad' FROM credenciales WHERE usuario =? AND password=? ";
		try (PreparedStatement ps = conex.prepareStatement(sql)) {
			ps.setString(1, usuario);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if (rs.getInt("cantidad") == 1) {
				return true;
			}

		} catch (SQLException e) {
			System.out.println("error al validar credenciales " + e.getMessage() + e.getStackTrace());
		}
		return false;

	}

	@Override
	public Credenciales buscarPorID(long id) {

		return null;
	}

	@Override
	public boolean eliminar(Credenciales elemento) {
		// TODO Auto-generated method stub
		return false;
	}

}
