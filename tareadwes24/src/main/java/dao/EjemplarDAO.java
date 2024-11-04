package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import modelo.Ejemplar;
import utils.ConexBD;

public class EjemplarDAO implements OperacionesCrud<Ejemplar> {

	
	Connection conex;
	ResultSet rs;
	Statement st;
	PreparedStatement ps;

	public EjemplarDAO(Connection conex) {
		if (this.conex == null) {
			this.conex = conex;
		}
	}

	@Override
	public long insertar(Ejemplar ej) {
		try {

			String sql = "INSERT INTO ejemplar(id,nombre) values (?,?)";
			ps = conex.prepareStatement(sql);

			ps.setLong(1, ej.getId());
			ps.setString(2, ej.getNombre());

			return ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al insertar en ejemplar" + e.getMessage());
		}
		return 0;
	}

	@Override
	public boolean eliminar(Ejemplar ej) {
		try {

			String sql = "DELETE FROM persona WHERE id=?";
			ps = conex.prepareStatement(sql);

			ps.setLong(1, ej.getId());

		} catch (SQLException e) {
			System.out.println("Error al borrar en ejemplar" + e.getMessage());
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean modificar(Ejemplar elemento) {
		
		return false;
	}

	@Override
	public Collection<Ejemplar> verTodas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ejemplar buscarPorID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
