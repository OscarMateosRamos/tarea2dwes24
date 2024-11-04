package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import modelo.Credenciales;
import utils.ConexBD;

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

	@Override
	public Credenciales buscarPorID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
