package control;

import dao.CredencialesDAO;
import dao.EjemplarDAO;
import modelo.Credenciales;
import modelo.Persona;
import modelo.Planta;
import utils.ConexBD;

public class ServiciosCredenciales {

	private ConexBD con;
	private CredencialesDAO credencialesDAO;

	public ServiciosCredenciales() {
		con = ConexBD.getInstance();
		credencialesDAO = (CredencialesDAO) con.getCredencialesDAO();
	}

	public long crearCredencial(String usuario, String password) {
		return credencialesDAO.insertar(usuario, password);

	}

	public boolean validarCredencial(String usuario, String password) {
		return credencialesDAO.validarCredenciales(usuario, password);
	}

	public boolean validarUsuario(String usuario) {
		return credencialesDAO.validarUsuario(usuario);
	}

	public long buscarIdPorUsuario(String usuario) {
		return credencialesDAO.buscarIdPorUsuario(usuario);
	}

}
