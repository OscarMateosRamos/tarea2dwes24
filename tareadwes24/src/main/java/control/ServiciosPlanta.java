package control;

import java.util.ArrayList;
import java.util.Collection;

import dao.PlantaDAO;
import modelo.Mensaje;
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

		if (pl.getCodigo().isEmpty()) {

			return false;
		}

		if (pl.getCodigo().length() < 3 || pl.getCodigo().length() > 20) {
			return false;
		}

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

		return true;

	}

}
