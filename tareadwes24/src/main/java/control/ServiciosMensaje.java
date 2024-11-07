package control;

import dao.MensajeDAO;
import utils.ConexBD;

public class ServiciosMensaje {
	private ConexBD con;
	private MensajeDAO mensajeDAO;

	public ServiciosMensaje() {
		con = ConexBD.getInstance();
		mensajeDAO = (MensajeDAO) con.getMensajeDAO();
	}
}
