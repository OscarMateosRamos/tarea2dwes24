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

public class MensajeDAO implements OperacionesCrud<Mensaje> {

	Connection conex;
	private PreparedStatement ps;
	private ResultSet rs;

	public MensajeDAO(Connection conex) {

		if (this.conex == null) {
			this.conex = conex;
		}
	}

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

			return ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al insertar en mensaje" + e.getMessage());
		}

		return 0;
	}

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
				Mensaje mensaje = new Mensaje(rs.getLong("id"), rs.getTimestamp("fechahora").toLocalDateTime(),
						rs.getString("mensaje"),rs.getLong("idEjemplar"),rs.getLong("idPersona"));
				mensajes.add(mensaje);
			}
			conex.close();

		} catch (SQLException e) {
			System.out.println("Error al ver los mensajes" + e.getMessage());
		}

		return mensajes;

	}

	@Override
	public Mensaje buscarPorID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
