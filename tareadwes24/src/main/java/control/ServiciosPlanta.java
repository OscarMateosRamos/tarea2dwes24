package control;

import java.util.Collection;

import dao.PlantaDAO;
import modelo.Planta;
import utils.ConexBD;

public class ServiciosPlanta {
	private ConexBD con;
	private PlantaDAO plantaDAO;

	public ServiciosPlanta() {
		con = ConexBD.getInstance();
		plantaDAO = (PlantaDAO) con.getPlantaDAO();
	}

	public long insertarPlanta(Planta pl) {
		return plantaDAO.insertar(pl);

	}

	public boolean modificarNombrecientifico(String codigo, String nombrecientifico) {
		return plantaDAO.modificarNombrecientifico(codigo, nombrecientifico);

	}

	public boolean modificarNombrecomun(String codigo, String nombrecomun) {
		return plantaDAO.modificarNombrecomun(codigo, nombrecomun);

	}

<<<<<<< HEAD
	public Planta buscarPorCodigo(String id) {
		return plantaDAO.buscarPorCodigo(id);

	}
	
	
	public boolean existePorCodigo(String id) {
		return plantaDAO.existePorCodigo(id);
=======
	public Planta buscarIdPlanta(long id) {
		return plantaDAO.buscarPorID(id);
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb

	}

	public Collection<Planta> verPlanta() {
		return plantaDAO.verTodas();

	}

	public boolean eliminarPlanta(Planta pl) {
		return plantaDAO.eliminar(pl);

	}

	public boolean validarPlanta(Planta pl) {
<<<<<<< HEAD

		if (pl.getCodigo().isEmpty()) {

=======
		boolean salida = false;

		if (pl.getCodigo().isEmpty()) {
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
			return false;
		}

		if (pl.getCodigo().length() < 3 || pl.getCodigo().length() > 20) {
			return false;
		}
<<<<<<< HEAD

		if (plantaDAO.buscarPorCodigo(pl.getCodigo()) != null) {
			System.out.println("Ya existe el codigo");
			return false;
		}

		if (pl.getNombrecientifico().length() > 45) {
			return false;
		}

		if (pl.getNombrecomun().length() > 40) {
			return false;
		}

=======
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
		return true;

	}

}
