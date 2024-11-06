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

	public boolean modificarPlanta(Planta pl) {
		return plantaDAO.modificar(pl);

	}

	public Planta buscarIdPlanta(long id) {
		return plantaDAO.buscarPorID(id);

	}

	public Collection<Planta> verPlanta() {
		return plantaDAO.verTodas();

	}

	public boolean eliminarPlanta(Planta pl) {
		return plantaDAO.eliminar(pl);

	}

	public boolean validarPlanta(Planta pl) {
		boolean salida = false;

		if (pl.getCodigo().isEmpty()) {
			return false;
		}

		if (pl.getCodigo().length() < 3 || pl.getCodigo().length() > 20) {
			return false;
		}
		return true;

	}

}
