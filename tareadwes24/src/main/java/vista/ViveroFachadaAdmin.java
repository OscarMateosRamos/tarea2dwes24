package vista;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

import control.Controlador;
import control.ServiciosCredenciales;
import control.ServiciosEjemplar;
import control.ServiciosMensaje;
import control.ServiciosPersona;
import control.ServiciosPlanta;
import modelo.Ejemplar;
import modelo.Mensaje;
import modelo.Persona;
import modelo.Planta;
import utils.ConexBD;

public class ViveroFachadaAdmin {

	private static ViveroFachadaAdmin portalAdmin;

	private ViveroFachadaAdmin() {

	}

	Connection con = ConexBD.realizaConexion();

	Controlador factoriaServicios = Controlador.getServicios();

	ServiciosEjemplar ejServ = factoriaServicios.getServiciosEjemplar();
	ServiciosPlanta plantaServ = factoriaServicios.getServiciosPlanta();
	ServiciosPersona personaServ = factoriaServicios.getServiciosPersona();
	ServiciosCredenciales credencialesServ = factoriaServicios.getServiciosCredenciales();
	ServiciosMensaje mensajesServ = factoriaServicios.getServiciosMensaje();

	public static ViveroFachadaAdmin getPortal() {
		if (portalAdmin == null)
			portalAdmin = new ViveroFachadaAdmin();
		return portalAdmin;
	}

	public void mostrarMenuPrincipal() {
		ViveroFachadaPersonal portalPersonal = ViveroFachadaPersonal.getPortal();
		int opcion = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Seleccione una opcion:");
			System.out.println("1.  Gestionar Plantas.");
			System.out.println("2.  Gestionar Personas.");
			System.out.println("3.  Gestionar Mensajes.");
			System.out.println("4.  Gestionar Ejemplares.");
			System.out.println("5.  Salir");
			try {
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

					portalPersonal.getPortal().menuMensajes();
					break;
				case 4:

					portalPersonal.getPortal().menuEjemplares();
					break;

				case 5:
					Controlador.getServicios().setUsername("invitado");
					System.out.println("Salida del menu de Administrador...");
					break;
				}
			} catch (InputMismatchException e) {

				System.out.println("Introduce un número.... Repita el proceso");
				sc.nextLine();
				opcion = 0;
			}

		} while (opcion != 5);

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
			try {
				opcion = sc.nextInt();
				if (opcion < 1 || opcion > 4) {
					System.out.println("Opción incorrecta.");
					continue;
				}
				switch (opcion) {
				case 1:
					plantaServ.verTodas();
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
			} catch (InputMismatchException e) {

				System.out.println("Introduce un número.... Repita el proceso");
				sc.nextLine();
				opcion = 0;
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
			try {
				opcion = sc.nextInt();
				if (opcion < 1 || opcion > 3) {
					System.out.println("Opción incorrecta.");
					continue;
				}
				switch (opcion) {
				case 1:
					System.out.println("Introduce el codigo de la planta a modificar");
					String codigo = sc.next();

					if (plantaServ.buscarPorCodigo(codigo) != null) {
						sc.nextLine();
						System.out.println("Introduce el nuevo nombre comun");
						String nuevo = sc.nextLine();

						plantaServ.modificarNombrecomun(codigo, nuevo);
					} else {
						System.out.println("El codigo no existe");
					}
					break;
				case 2:
					System.out.println("Introduce el codigo de la planta a modificar");
					codigo = sc.next();

					if (plantaServ.buscarPorCodigo(codigo) != null) {
						sc.nextLine();
						System.out.println("Introduce el nuevo nombre cientifico");
						String nuevo = sc.nextLine();

						plantaServ.modificarNombrecientifico(codigo, nuevo);
					} else {
						System.out.println("El codigo no existe");
					}

					break;

				case 3:
					break;

				}
			} catch (InputMismatchException e) {

				System.out.println("Introduce un número.... Repita el proceso");
				sc.nextLine();
				opcion = 0;
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
			try {
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
				}
			} catch (InputMismatchException e) {

				System.out.println("Introduce un número.... Repita el proceso");
				sc.nextLine();
				opcion = 0;
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
			System.out.println("3.  Salir");
			try {
				opcion = sc.nextInt();
				if (opcion < 1 || opcion > 3) {
					System.out.println("Opción incorrecta.");
					continue;
				}
				switch (opcion) {
				case 1:
					personaServ.verPersona();
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

					break;
				case 3:

					break;

				}
			} catch (InputMismatchException e) {

				System.out.println("Introduce un número.... Repita el proceso");
				sc.nextLine();
				opcion = 0;
			}

		} while (opcion != 3);

	}

}
