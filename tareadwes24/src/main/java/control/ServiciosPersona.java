package control;

import java.util.Collection;

import dao.PersonaDAO;
import modelo.Persona;
import modelo.Planta;
import utils.ConexBD;

public class ServiciosPersona {
	private ConexBD con;
	private PersonaDAO personaDAO;

	public ServiciosPersona() {
		con = ConexBD.getInstance();
		personaDAO = (PersonaDAO) con.getPersonaDAO();
	}

	public long insertarPersona(Persona p) {
		return personaDAO.insertar(p);

	}

	public boolean modificarPersona(Persona p) {
		return personaDAO.modificar(p);

	}

	public Persona buscarIdPersona(long id) {
		return personaDAO.buscarPorID(id);

	}

	public Collection<Persona> verPersona() {
		return personaDAO.verTodas();

	}

	public boolean eliminarPersona(Persona p) {
		return personaDAO.eliminar(p);

	}

	public boolean validarPersona(long id, Persona p) {
		boolean salida = false;

		if (p.getId() == id) {
			return true;
		}

		return false;

	}

}
