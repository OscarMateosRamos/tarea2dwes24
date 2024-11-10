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

	public Persona buscarPorEmail(String identificador) {
		return personaDAO.buscarPorEmail(identificador);

	}

	public Collection<Persona> verPersona() {
		return personaDAO.verTodas();

	}
	
	public Persona buscarPorIDCredencial(long identificador) {
		return personaDAO.buscarPorIDCredencial(identificador);

	}

	public boolean validarEmail(String email) {

		if (personaDAO.buscarPorEmail(email) != null) {
			System.out.println("Ya existe el email");
			return false;
		}

		return true;

	}

}
