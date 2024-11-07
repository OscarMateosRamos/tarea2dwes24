package vista;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import control.Controlador;
import control.ServiciosEjemplar;
import control.ServiciosPersona;
import control.ServiciosPlanta;
import modelo.Persona;
import modelo.Planta;
import utils.ConexBD;

public class ViveroFachadaAdmin {

	private static ViveroFachadaAdmin portal;

	Connection con = ConexBD.realizaConexion();

	Controlador factoriaServicios = Controlador.getServicios();

	ServiciosEjemplar ejServ = factoriaServicios.getServiciosEjemplar();
	ServiciosPlanta plantaServ = factoriaServicios.getServiciosPlanta();
	ServiciosPersona personaServ = factoriaServicios.getServiciosPersona();

	public static ViveroFachadaAdmin getPortal() {
		if (portal == null)
			portal = new ViveroFachadaAdmin();
		return portal;
	}

	public void mostrarMenuPrincipal() {
		int opcion = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Seleccione una opcion:");
			System.out.println("1.  Gestionar Plantas.");
			System.out.println("2.  Gestionar Personas.");
			System.out.println("3.  Gestionar Mensajes.");
			System.out.println("4.  Gestionar Personas.");
			System.out.println("5.  Salir");

			opcion = sc.nextInt();
			if (opcion < 1 || opcion > 5) {
				System.out.println("Opción incorrecta.");
				continue;
			}
			switch (opcion) {
			case 1:
				menuPlantas();
				break;
			case 2:
				menuPersonas();
				break;
			case 3:
				menuMensajes();
				break;
			case 4:
				// menuAdminPersonas();
				break;
			}

		} while (opcion != 5);

	}

	private void menuMensajes() {
		int opcion = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("---Gestion de Mensajes:---");
			System.out.println("1.  Ver Plantas.");
			System.out.println("2.  Crear una Planta.");
			System.out.println("3.  Modificar Plantas.");
			System.out.println("4.  Salir");

			opcion = sc.nextInt();
			if (opcion < 1 || opcion > 3) {
				System.out.println("Opción incorrecta.");
				continue;
			}
			switch (opcion) {
			case 1:

				plantaServ.verPlanta();

				break;
			case 2:
				Planta pl = new Planta();
				plantaServ.validarPlanta(pl);
				plantaServ.insertarPlanta(pl);

				break;
			case 3:
				pl = new Planta();
				plantaServ.modificarNombrecientifico(pl.getCodigo(), pl.getNombrecientifico());
				plantaServ.modificarNombrecomun(pl.getCodigo(), pl.getNombrecomun());
				break;

			}

		} while (opcion != 4);

	}

	private void menuPlantas() {

		int opcion = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("---Gestion de plantas:---");
			System.out.println("1.  Ver Plantas.");
			System.out.println("2.  Crear una Planta.");
			System.out.println("3.  Modificar Plantas.");
			System.out.println("4.  Salir");

			opcion = sc.nextInt();
			if (opcion < 1 || opcion > 3) {
				System.out.println("Opción incorrecta.");
				continue;
			}
			switch (opcion) {
			case 1:

				plantaServ.verPlanta();

				break;
			case 2:
				Planta pl = new Planta();
				plantaServ.insertarPlanta(pl);
				plantaServ.validarPlanta(pl);
				break;
			case 3:
				pl = new Planta();
				plantaServ.modificarNombrecientifico(pl.getCodigo(), pl.getNombrecientifico());
				plantaServ.modificarNombrecomun(pl.getCodigo(), pl.getNombrecomun());
				break;

			}

		} while (opcion != 4);

	}

	private void menuPersonas() {

		int opcion = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("---Gestion de personas:---");
			System.out.println("1.  Ver Personas.");
			System.out.println("2.  Añadir persona.");
			System.out.println("3.  Modificar persona.");
			System.out.println("4.  Eliminar persona.");
			System.out.println("5.  Salir");

			opcion = sc.nextInt();
			if (opcion < 1 || opcion > 4) {
				System.out.println("Opción incorrecta.");
				continue;
			}
			switch (opcion) {
			case 1:
				personaServ.verPersona();

				break;
			case 2:
				Persona p = new Persona();
				personaServ.validarPersona(p.getId(), p);
				personaServ.insertarPersona(p);

				break;
			case 3:
				p = new Persona();
				personaServ.modificarPersona(p);
				break;

			case 4:
				p = new Persona();
				personaServ.eliminarPersona(p);

			}

		} while (opcion != 5);

	}

}
