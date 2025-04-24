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

	public Planta buscarPorCodigo(String id) {
		return plantaDAO.buscarPorCodigo(id);

	}

	public boolean existePorCodigo(String id) {
		return plantaDAO.existePorCodigo(id);

	}

	public Collection<Planta> verTodas() {
		return plantaDAO.verTodas();

	}

	public boolean eliminarPlanta(Planta pl) {
		return plantaDAO.eliminar(pl);

	}

	public boolean validarPlanta(Planta pl) {

		if (pl.getCodigo().isEmpty() || pl.getCodigo().matches(".*\\s.*")) {
			System.out.println(" Codigo no introducido o con esapcios");
			return false;
		}

		if (pl.getCodigo().length() < 3 || pl.getCodigo().length() > 20) {
			System.out.println("Longitud del codigo de la planta invalida minimo 3 caracteres y maximo 20");
			return false;
		}

		if (plantaDAO.buscarPorCodigo(pl.getCodigo()) != null) {
			System.out.println("Ya existe el codigo");
			return false;
		}

		if (pl.getNombrecientifico().length() > 45) {
			System.out.println("El nombre cientifico excede de 45 caracteres");
			return false;
		}

		if (pl.getNombrecomun().length() > 40) {
			System.out.println("El nombre comun excede de 40 caracteres");
			return false;
		}

		return true;

	}

}
