package control;

import dao.EjemplarDAO;
import utils.ConexBD;

public class ServiciosEjemplar {

	private ConexBD con;
	private EjemplarDAO ejemplarDAO;

	public ServiciosEjemplar() {
		con = ConexBD.getInstance();
		ejemplarDAO = (EjemplarDAO) con.getEjemplarDAO();
	}
	
}
