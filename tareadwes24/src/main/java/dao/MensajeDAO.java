package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Mensaje;
import utils.ConexBD;

public class MensajeDAO implements OperacionesCrud<Mensaje> {

	
	static Connection conex = null;

	public MensajeDAO() {
		super();
		conex = ConexBD.realizaConexion();
		if (conex == null) {
			System.out.println("Error al conectar a la BD");
		}
	}

	PreparedStatement ps;

	@Override
	public void insertar(Mensaje m) {
		String sql = "INSERT INTO mensaje(id,fechahora,mensaje) values (?,?,?)";
		ResultSet rs;
		Statement st;
		PreparedStatement ps;

		try {
			if (conex == null) {
				conex = ConexBD.realizaConexion();
				ps = conex.prepareStatement(sql);

				ps.setLong(1, m.getId());
				/* ps.set(2, m.getFechahora()); */
				ps.setString(3, m.getMensaje());

				ps.executeUpdate();
				System.out.println("Mendaje insertado correctamente");

			}
			conex.close();
		} catch (SQLException e) {
			System.out.println("Error al insertar en mensaje");
		}
	}

	@Override
	public void borrar(Mensaje m) {
		try {
			if (conex == null) {
				conex = ConexBD.realizaConexion();
				String sql = ("DELETE FROM mensaje WHERE id =?");
				Statement stmt = conex.createStatement();

				ps.setLong(1, m.getId());

				int filasborradas = ps.executeUpdate();
				if (filasborradas > 0) {
					System.out.println("Mensaje  borrado con éxito.");
				} else {
					System.out.println("No se encontró un mensaje con ese id.");
				}
				conex.close();
			}
			conex.close();
		} catch (SQLException e) {
			System.out.println("Error al borrar en mensaje" + e.getMessage());
		}
	}

	@Override
	public void modificar(Mensaje m) {
		try {
			if (conex == null) {
				conex = ConexBD.realizaConexion();
			}
			String sql = "UPDATE mensaje SET fechahora = ?,mensaje=? WHERE  id = ?";
			Statement stmt = conex.createStatement();

			/*
			 * ps.setString(1, ej.getNombre()); ps.setLong(2, ej.getId());
			 */

			int filasactualizadas = ps.executeUpdate();
			if (filasactualizadas > 0) {
				System.out.println("Modificado con éxito");
			} else {
				System.out.println("No se encontró el mensaje con el Id especificado.");
			}
			stmt.executeUpdate(sql);
			conex.close();
		} catch (SQLException e) {
			System.out.println("Error al modificar el mensaje" + e.getMessage());
		}

	}

	@Override
	public void vertodas(Mensaje m) {

	}

}
