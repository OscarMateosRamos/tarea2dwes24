package control;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import dao.MensajeDAO;
import modelo.Mensaje;
import utils.ConexBD;

public class ServiciosMensaje {

	private ConexBD con;
	private MensajeDAO mensajeDAO;

	public ServiciosMensaje() {
		con = ConexBD.getInstance();
		mensajeDAO = (MensajeDAO) con.getMensajeDAO();
	}

	public long insertarMensaje(Mensaje m) {
		return mensajeDAO.insertar(m);

	}

	public Collection<Mensaje> verMensajeIdPersona(long identificador) {
		return mensajeDAO.buscarPorIdPersona(identificador);

	}

	public ArrayList<Mensaje> mostrarMensajeIdEjemplar(long identificador) {
		return mensajeDAO.buscarPorIdEjemplar(identificador);

	}

	public Collection<Mensaje> vertodosMensajes() {
		return mensajeDAO.verTodas();

	}

	public ArrayList<Mensaje> mostrarMensajesPorCodigoPlanta() {
		return mensajeDAO.buscarMensajesPorCodigoPlanta();
	}
	
	public ArrayList<Mensaje> mostrarMensajesPorFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
	    return mensajeDAO.buscarMensajesEntreFechas(fechaInicio, fechaFin);
	}
	
	
	public ArrayList< Mensaje> mostrarMensajeTipoPlanta(String codigo) {
		return mensajeDAO.mostrarMensajeTipoPlanta(codigo);
	}
}
