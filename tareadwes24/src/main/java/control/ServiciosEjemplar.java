package control;

import dao.EjemplarDAO;
<<<<<<< HEAD
import modelo.Ejemplar;
=======
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
import utils.ConexBD;

public class ServiciosEjemplar {

	private ConexBD con;
	private EjemplarDAO ejemplarDAO;

	public ServiciosEjemplar() {
		con = ConexBD.getInstance();
		ejemplarDAO = (EjemplarDAO) con.getEjemplarDAO();
	}
	
<<<<<<< HEAD
	public long insertarEjemplar(Ejemplar ej) {
		return ejemplarDAO.insertar(ej);

	}
	
	public boolean modificarNombreEjemplar(long id, String nombreNuevo) {
		return ejemplarDAO.modificarNombre(id,nombreNuevo );

	}
	
=======
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
}
