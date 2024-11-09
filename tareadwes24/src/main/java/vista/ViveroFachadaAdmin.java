package vista;

import java.sql.Connection;
<<<<<<< HEAD
import java.time.LocalDateTime;
import java.util.Scanner;

import control.Controlador;
import control.ServiciosCredenciales;
import control.ServiciosEjemplar;
import control.ServiciosMensaje;
import control.ServiciosPersona;
import control.ServiciosPlanta;
import modelo.Ejemplar;
import modelo.Mensaje;
=======
import java.util.ArrayList;
import java.util.Scanner;

import control.Controlador;
import control.ServiciosEjemplar;
import control.ServiciosPersona;
import control.ServiciosPlanta;
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
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
<<<<<<< HEAD
	ServiciosCredenciales credencialesServ = factoriaServicios.getServiciosCredenciales();
	ServiciosMensaje mensajesServ = factoriaServicios.getServiciosMensaje();
=======
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb

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
<<<<<<< HEAD
			System.out.println("4.  Gestionar Ejemplares.");
=======
			System.out.println("4.  Gestionar Personas.");
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
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
<<<<<<< HEAD
				menuEjemplares();
=======
				// menuAdminPersonas();
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
				break;
			}

		} while (opcion != 5);

	}

<<<<<<< HEAD
	private void menuEjemplares() {
		int opcion = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("---Gestion de Ejemplares:---");
			System.out.println("1.  Crear ejemplar");
			System.out.println("2.  Crear un Mensaje.");
			System.out.println("3.  Ver Mensajes (FILTRADO).");
			System.out.println("4.  Salir");

			opcion = sc.nextInt();
			if (opcion < 1 || opcion > 4) {
				System.out.println("Opción incorrecta.");
				continue;
			}
			switch (opcion) {
			case 1:
				System.out.println("***Creando ejemplar");
				Ejemplar ej = new Ejemplar();
				System.out.print("Código de la planta del ejemplar: ");
				String codigo = sc.next().trim().toUpperCase();

				if (Controlador.getServicios().getServiciosPlanta().existePorCodigo(codigo)) {
					System.out.println("**Existe el codigo");
					ej.setIdPlanta(codigo);
					ej.setNombre(codigo);

					long idNuevo=Controlador.getServicios().getServiciosEjemplar().insertarEjemplar(ej);
					
					String nuevoNombre=codigo+"_"+idNuevo;
					Controlador.getServicios().getServiciosEjemplar().modificarNombreEjemplar(idNuevo, nuevoNombre);
					
					Mensaje m = new Mensaje();
					
					 LocalDateTime fechahora = LocalDateTime.now();
					 m.setFechahora(fechahora);
					 
					  String mensaje = "Añadido nuevo ejemplar " + ej.getNombre()+"por "+;
					  
				}else {
					System.out.println("--- NO Existe el codigo");
					
					
				}
				
				break;
			case 2:

				break;
			case 3:

				break;

			}

		} while (opcion != 4);

	}

=======
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
	private void menuMensajes() {
		int opcion = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("---Gestion de Mensajes:---");
<<<<<<< HEAD
			System.out.println("1.  Ver Mensajes (SIN FILTRAR).");
			System.out.println("2.  Crear un Mensaje.");
			System.out.println("3.  Ver Mensajes (FILTRADO).");
			System.out.println("4.  Salir");

			opcion = sc.nextInt();
			if (opcion < 1 || opcion > 4) {
=======
			System.out.println("1.  Ver Plantas.");
			System.out.println("2.  Crear una Planta.");
			System.out.println("3.  Modificar Plantas.");
			System.out.println("4.  Salir");

			opcion = sc.nextInt();
			if (opcion < 1 || opcion > 3) {
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
				System.out.println("Opción incorrecta.");
				continue;
			}
			switch (opcion) {
			case 1:
<<<<<<< HEAD
				mensajesServ.vertodosMensajes();
				break;
			case 2:

				break;
			case 3:
				menuFiltrarMensaje();

=======

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
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
				break;

			}

		} while (opcion != 4);

	}

	private void menuPlantas() {
<<<<<<< HEAD
=======

>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
		int opcion = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("---Gestion de plantas:---");
			System.out.println("1.  Ver Plantas.");
			System.out.println("2.  Crear una Planta.");
			System.out.println("3.  Modificar Plantas.");
			System.out.println("4.  Salir");

			opcion = sc.nextInt();
<<<<<<< HEAD
			if (opcion < 1 || opcion > 4) {
				System.out.println("Opción incorrecta.");
				continue;
			}
			switch (opcion) {
			case 1:
				plantaServ.verPlanta();
				break;
			case 2:
				boolean plantaValida = false;

				String codigo;
				Planta pl = new Planta();
				boolean formatoOK = false;
				do {
					sc = new Scanner(System.in);

					System.out.println("Dame el codigo de la nueva Planta");
					codigo = sc.nextLine();

					pl.setCodigo(codigo.trim().toUpperCase());

					System.out.println("Dame el nombre comun de la nueva Planta");
					String nombrecomun = sc.nextLine();
					pl.setNombrecomun(nombrecomun);

					System.out.println("Dame el nombre cientifico de la nueva Planta");
					String nombrecientifico = sc.nextLine();
					pl.setNombrecientifico(nombrecientifico);

					plantaValida = plantaServ.validarPlanta(pl);
					if (!plantaValida) {
						System.out.println("Planta invalida... Repita el proceso");
					}

				} while (!plantaValida);

				plantaServ.insertarPlanta(pl);

				break;
			case 3:
				menuModificarPlanta();

				break;

			}

		} while (opcion != 4);

	}

	private void menuModificarPlanta() {

		int opcion = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("---Modificar Planta:---");
			System.out.println("1.  Modificar nombre comun.");
			System.out.println("2.  Modificar nombre cientifico.");
			System.out.println("3.  Salir");

			opcion = sc.nextInt();
=======
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
			if (opcion < 1 || opcion > 3) {
				System.out.println("Opción incorrecta.");
				continue;
			}
			switch (opcion) {
			case 1:
<<<<<<< HEAD
				System.out.println("Introduce el codigo de la planta a modificar");
				String codigo = sc.next();

				if (plantaServ.buscarPorCodigo(codigo) != null) {
					System.out.println("Introduce el nuevo nombre comun");
					String nuevo = sc.next();

					plantaServ.modificarNombrecomun(codigo, nuevo);
				} else {
					System.out.println("El codigo no existe");
				}
				break;
			case 2:
				System.out.println("Introduce el codigo de la planta a modificar");
				codigo = sc.next();

				if (plantaServ.buscarPorCodigo(codigo) != null) {
					System.out.println("Introduce el nuevo nombre cientifico");
					String nuevo = sc.next();

					plantaServ.modificarNombrecientifico(codigo, nuevo);
				} else {
					System.out.println("El codigo no existe");
				}

				break;

			case 3:
				break;

			}

		} while (opcion != 3);

	}

	private void menuFiltrarMensaje() {

		int opcion = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("---Ver Mensaje:---");
			System.out.println("1.  Ver mensaje filtrado por rango de fechas.");
			System.out.println("2.  Ver mensaje filtrado por persona.");
			System.out.println("3.  Ver mensaje filtrado por tipo de planta.");
			System.out.println("4.  Salir");

			opcion = sc.nextInt();
			if (opcion < 1 || opcion > 4) {
				System.out.println("Opción incorrecta.");
				continue;
			}
			switch (opcion) {
			case 1:

				break;
			case 2:
				System.out.println("Introduce el id de persona");
				long idPersona = sc.nextLong();

				mensajesServ.verMensajeIdPersona(idPersona);
				break;

			case 3:
				System.out.println("Introduce el id de Ejemplar");
				long idEjemplar = sc.nextLong();

				// mensajesServ.verMensajeIdEjemplar();//* Sacar la planta con el id de Ejemplar

				break;

			case 4:
				break;
=======

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

>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
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
<<<<<<< HEAD
			if (opcion < 1 || opcion > 5) {
=======
			if (opcion < 1 || opcion > 4) {
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
				System.out.println("Opción incorrecta.");
				continue;
			}
			switch (opcion) {
			case 1:
				personaServ.verPersona();
<<<<<<< HEAD
				break;
			case 2:
				boolean personaValida = false;
				boolean formatoOK = false;

				Persona p = new Persona();
				sc = new Scanner(System.in);

				System.out.println("Dame el nombre de la nueva Persona");
				String nombre = sc.nextLine();

				System.out.println("Dame el email de la nueva Persona");
				String email = sc.nextLine();

				System.out.println("Introduce el nombre de usuario");
				String usuario = sc.nextLine();

				System.out.println("Introduce el password");
				String password = sc.nextLine();

				if (!credencialesServ.validarUsuario(usuario)) {
					System.out.println("Ya existe ese  usuario en credenciales: " + usuario);
				} else {

					personaValida = personaServ.validarEmail(email);
					if (!personaValida) {
						System.out.println(" Persona datos no validos... Repita el proceso");
					} else {
						credencialesServ.crearCredencial(usuario, password);
						p.setNombre(nombre);
						p.setEmail(email);
						p.setIdCredencial(credencialesServ.buscarIdPorUsuario(usuario));
						personaServ.insertarPersona(p);
					}

				}
=======

				break;
			case 2:
				Persona p = new Persona();
				personaServ.validarPersona(p.getId(), p);
				personaServ.insertarPersona(p);
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb

				break;
			case 3:
				p = new Persona();
				personaServ.modificarPersona(p);
				break;

			case 4:
<<<<<<< HEAD
=======
				p = new Persona();
				personaServ.eliminarPersona(p);
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb

			}

		} while (opcion != 5);

	}

}
