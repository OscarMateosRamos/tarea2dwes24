package control;

import dao.CredencialesDAO;
import dao.EjemplarDAO;
import modelo.Credenciales;
<<<<<<< HEAD
import modelo.Persona;
=======
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
import modelo.Planta;
import utils.ConexBD;

public class ServiciosCredenciales {

	private ConexBD con;
	private CredencialesDAO credencialesDAO;

	public ServiciosCredenciales() {
		con = ConexBD.getInstance();
		credencialesDAO = (CredencialesDAO) con.getCredencialesDAO();
	}
<<<<<<< HEAD

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

=======
	
	
	public long crearCredencial(Credenciales c) {
		return credencialesDAO.insertar(c);

	}
	
	public boolean validarCredencial(Credenciales c) {
		return credencialesDAO.validarCredenciales(c.getUsuario(), c.getPassword());

	}
	
	
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
}
