package control;

<<<<<<< HEAD
import java.util.Collection;

import dao.MensajeDAO;
import modelo.Mensaje;
=======
import dao.MensajeDAO;
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
import utils.ConexBD;

public class ServiciosMensaje {
	private ConexBD con;
	private MensajeDAO mensajeDAO;

	public ServiciosMensaje() {
		con = ConexBD.getInstance();
		mensajeDAO = (MensajeDAO) con.getMensajeDAO();
	}
<<<<<<< HEAD

	public long insertarMensaje(Mensaje m) {
		return mensajeDAO.insertar(m);

	}

	public Collection<Mensaje> verMensajeIdPersona(long identificador) {
		return mensajeDAO.buscarPorIdPersona(identificador);

	}

	public Collection<Mensaje> verMensajeIdEjemplar(long identificador) {
		return mensajeDAO.buscarPorIdEjemplar(identificador);

	}
	
	public Collection<Mensaje> vertodosMensajes() {
		return mensajeDAO.verTodas();

	}

=======
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
}
