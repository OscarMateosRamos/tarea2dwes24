package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Credenciales;
import utils.ConexBD;

public class CredencialesDAO implements OperacionesCrud<Credenciales> {

	
	static Connection conex = null;

	public CredencialesDAO() {
		super();
		conex = ConexBD.realizaConexion();
		if (conex == null) {
			System.out.println("Error al conectar a la BD");
		}
	}

	PreparedStatement ps;

	@Override
	public void insertar(Credenciales c) {
		String sql = "INSERT INTO credenciales(id,usuario,password) values (?,?,?)";
		ResultSet rs;
		Statement st;
		PreparedStatement ps;

		try {
			if (conex == null) {
				conex = ConexBD.realizaConexion();
				ps = conex.prepareStatement(sql);

				ps.setLong(1, c.getId());
				ps.setString(2, c.getUsuario());
				ps.setString(3, c.getPassword());

				ps.executeUpdate();
				System.out.println("Credenciales insertadas correctamente");

			}
			conex.close();
		} catch (SQLException e) {
			System.out.println("Error al insertar en planta");
		}
	}

	@Override
	public void borrar(Credenciales c) {
		try {
			if (conex == null) {
				conex = ConexBD.realizaConexion();
				String sql = ("DELETE FROM credenciales WHERE id =?");
				Statement stmt = conex.createStatement();

				ps.setLong(1, c.getId());

				int filasborradas = ps.executeUpdate();
				if (filasborradas > 0) {
					System.out.println("Credenciales borradas con exito");
				} else {
					System.out.println("No se encontró una credencial con ese id.");
				}
				conex.close();
			}
			conex.close();
		} catch (SQLException e) {
			System.out.println("Error al borrar en credenciales" + e.getMessage());
		}

	}

	@Override
	public void modificar(Credenciales c) {
		try {
			if (conex == null) {
				conex = ConexBD.realizaConexion();
			}
			String sql = "UPDATE credenciale SET usuario = ?, password = ? WHERE id = ?";
			Statement stmt = conex.createStatement();

			ps.setString(1, c.getUsuario());
			ps.setString(2, c.getPassword());
			ps.setLong(3, c.getId());

			int filasactualizadas = ps.executeUpdate();
			if (filasactualizadas > 0) {
				System.out.println("Modificado con éxito");
			} else {
				System.out.println("No se encontró una Credencial con el Id especificado.");
			}
			stmt.executeUpdate(sql);

			conex.close();
		} catch (SQLException e) {
			System.out.println("Error al modificar en Credenciales" + e.getMessage());
		}

	}

	@Override
	public void  Collection<Credenciales> vertodas(Credenciales c) {

		try {
			if (this.conex == null || this.conex.isClosed()) {
				this.conex = ConexBD.realizaConexion();
			}
			String sql = "SELECT * FROM credenciales";
			Statement stmt = conex.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				long id = rs.getLong("Id");
				String usuario = rs.getString("usuario");
				String password = rs.getString("email");

				System.out.println("Id: " + id + ", Usuario: " + usuario + ", Password: " + password);
			}
			conex.close();
		} catch (SQLException e) {
			System.out.println("Error al listar en credenciales" + e.getMessage());
		}

	}

	@Override
	public Credenciales buscarPorID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
