package control;

import dao.CredencialesDAO;
import dao.EjemplarDAO;
import modelo.Credenciales;
import modelo.Planta;
import utils.ConexBD;

public class ServiciosCredenciales {

	private ConexBD con;
	private CredencialesDAO credencialesDAO;

	public ServiciosCredenciales() {
		con = ConexBD.getInstance();
		credencialesDAO = (CredencialesDAO) con.getCredencialesDAO();
	}
	
	
	public long crearCredencial(Credenciales c) {
		return credencialesDAO.insertar(c);

	}
	
	public boolean validarCredencial(Credenciales c) {
		return credencialesDAO.validarCredenciales(c.getUsuario(), c.getPassword());

	}
	
	
}
