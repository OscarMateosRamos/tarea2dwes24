package control;

import java.util.ArrayList;

import dao.EjemplarDAO;
import modelo.Ejemplar;
import utils.ConexBD;

public class ServiciosEjemplar {

	private ConexBD con;
	private EjemplarDAO ejemplarDAO;

	public ServiciosEjemplar() {
		con = ConexBD.getInstance();
		ejemplarDAO = (EjemplarDAO) con.getEjemplarDAO();
	}

	public long insertarEjemplar(Ejemplar ej) {
		return ejemplarDAO.insertar(ej);

	}

	public boolean modificarNombreEjemplar(long id, String nombreNuevo) {
		return ejemplarDAO.modificarNombre(id, nombreNuevo);

	}

	public ArrayList<Ejemplar> ejemplaresPorTipoPlanta(String codigo) {
		return ejemplarDAO.ejemplaresPorTipoPlanta(codigo);

	}

	public boolean existePorNombre(String nombre) {
		return ejemplarDAO.existePorNombre(nombre);

	}

	public long buscarIDPorNombre(String nombre) {
		return ejemplarDAO.buscarIDPorNombre(nombre);
	}

}
