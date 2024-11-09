package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

<<<<<<< HEAD
import modelo.Mensaje;
import utils.ConexBD;

public class MensajeDAO {
=======

import modelo.Mensaje;

import utils.ConexBD;

public class MensajeDAO implements OperacionesCrud<Mensaje> {
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb

	Connection conex;
	private PreparedStatement ps;
	private ResultSet rs;

<<<<<<< HEAD
	
=======
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
	public MensajeDAO(Connection conex) {

		if (this.conex == null) {
			this.conex = conex;
		}
	}

<<<<<<< HEAD

	
	public long insertar(Mensaje m) {
	
		try {

			String sql = "INSERT INTO mensajes(fechahora,mensaje,idEjemplar,idPersona) values (?,?,?,?)";
			ps = conex.prepareStatement(sql);

			ps.setTimestamp(1, Timestamp.valueOf(m.getFechahora()));
			ps.setString(2, m.getMensaje());
			ps.setLong(3, m.getIdEjemplar());
			ps.setLong(4, m.getIdPersona());
=======
	@Override
	public long insertar(Mensaje m) {

		try {

			String sql = "INSERT INTO mensajes(id,fechahora,mensaje,idEjemplar,idPersona) values (?,?,?,?,?)";
			ps = conex.prepareStatement(sql);

			ps.setLong(1, m.getId());
			ps.setTimestamp(2, Timestamp.valueOf(m.getFechahora()));
			ps.setString(3, m.getMensaje());
			ps.setLong(4, m.getIdEjemplar());
			ps.setLong(5, m.getIdPersona());
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb

			return ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al insertar en mensaje" + e.getMessage());
		}

		return 0;
	}

<<<<<<< HEAD
=======
	@Override
	public boolean eliminar(Mensaje elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificar(Mensaje elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
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
<<<<<<< HEAD
				Mensaje m = new Mensaje(rs.getLong("id"), rs.getTimestamp("fechahora").toLocalDateTime(),
						rs.getString("mensaje"), rs.getLong("idEjemplar"), rs.getLong("idPersona"));
				mensajes.add(m);
=======
				Mensaje mensaje = new Mensaje(rs.getLong("id"), rs.getTimestamp("fechahora").toLocalDateTime(),
						rs.getString("mensaje"),rs.getLong("idEjemplar"),rs.getLong("idPersona"));
				mensajes.add(mensaje);
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
			}
			ConexBD.cerrarConexion();

		} catch (SQLException e) {
			System.out.println("Error al ver los mensajes" + e.getMessage());
		}

		return mensajes;

	}

<<<<<<< HEAD
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

=======
	@Override
	public Mensaje buscarPorID(long id) {
		// TODO Auto-generated method stub
		return null;
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
	}

}
