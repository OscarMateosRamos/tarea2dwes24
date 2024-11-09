package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

import modelo.Mensaje;
import utils.ConexBD;

public class MensajeDAO {

	Connection conex;
	private PreparedStatement ps;
	private ResultSet rs;

	public MensajeDAO(Connection conex) {

		if (this.conex == null) {
			this.conex = conex;
		}
	}

	public long insertar(Mensaje m) {

		
	
		
		try {

			String sql = "INSERT INTO mensajes(fechahora,mensaje,idEjemplar,idPersona) values (?,?,?,?)";
			ps = conex.prepareStatement(sql);

			ps.setTimestamp(1, Timestamp.valueOf(m.getFechahora()));
			ps.setString(2, m.getMensaje());
			ps.setLong(3, m.getIdEjemplar());
			ps.setLong(4, m.getIdPersona());

			return ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al insertar en mensaje" + e.getMessage());
		}

		return 0;
	}

	public Collection<Mensaje> verTodas() {
		String sql = "SELECT * FROM mensajes";
		ArrayList<Mensaje> mensajes = new ArrayList<>();

		try {
			if (this.conex == null || this.conex.isClosed()) {
				this.conex = ConexBD.realizaConexion();
			}

			PreparedStatement ps = conex.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Mensaje m = new Mensaje(rs.getLong("id"), rs.getTimestamp("fechahora").toLocalDateTime(),
						rs.getString("mensaje"), rs.getLong("idEjemplar"), rs.getLong("idPersona"));
				mensajes.add(m);
			}
			ConexBD.cerrarConexion();

		} catch (SQLException e) {
			System.out.println("Error al ver los mensajes" + e.getMessage());
		}

		return mensajes;

	}

	public ArrayList<Mensaje> buscarPorIdPersona(long identificador) {
		String sql = "SELECT * FROM mensajes WHERE idPersona = ?";
		ArrayList<Mensaje> mensajes = new ArrayList();
		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			ps.setLong(1, identificador);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Mensaje m = new Mensaje();
				m.setId(rs.getLong("id"));
				m.setFechahora(rs.getTimestamp("fechahora").toLocalDateTime());
				m.setMensaje(rs.getString("mensaje"));
				m.setIdEjemplar(rs.getLong("idEjemplar"));
				m.setIdPersona(rs.getLong("idPersona"));

				mensajes.add(m);
			}
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Se ha producido una Exception: " + e.getMessage());
			e.printStackTrace();
		}

		return mensajes;

	}

	public ArrayList<Mensaje> buscarPorIdEjemplar(long identificador) {
		String sql = "SELECT * FROM mensajes WHERE idEjemplar = ?";
		ArrayList<Mensaje> mensajes = new ArrayList();
		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			ps.setLong(1, identificador);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Mensaje m = new Mensaje();
				m.setId(rs.getLong("id"));
				m.setFechahora(rs.getTimestamp("fechahora").toLocalDateTime());
				m.setMensaje(rs.getString("mensaje"));
				m.setIdEjemplar(rs.getLong("idEjemplar"));
				m.setIdPersona(rs.getLong("idPersona"));

				mensajes.add(m);
			}
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Se ha producido una Exception: " + e.getMessage());
			e.printStackTrace();
		}

		return mensajes;

	}

}
