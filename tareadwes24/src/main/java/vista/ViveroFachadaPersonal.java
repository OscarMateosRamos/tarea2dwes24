package vista;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import control.Controlador;
import control.ServiciosEjemplar;
import control.ServiciosPlanta;
import modelo.Ejemplar;
import modelo.Mensaje;

public class ViveroFachadaPersonal {

	private static ViveroFachadaPersonal portalPersonal;

	private ViveroFachadaPersonal() {

	}

	// Connection con = ConexBD.realizaConexion();

	Controlador factoriaServicios = Controlador.getServicios();

	ServiciosPlanta plantaServ = factoriaServicios.getServiciosPlanta();
	ServiciosEjemplar ejemplarServ = factoriaServicios.getServiciosEjemplar();

	private static Controlador controlador = Controlador.getServicios();

	public static ViveroFachadaPersonal getPortal() {
		if (portalPersonal == null)
			portalPersonal = new ViveroFachadaPersonal();
		return portalPersonal;
	}

	public void mostrarMenuPrincipal() {
		int opcion = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("--Menu Personal--");
			System.out.println("Seleccione una opcion:");
			System.out.println("1.  Plantas. Ver todas las Plantas");
			System.out.println("2.  Gestionar Ejemplares.");
			System.out.println("3.  Gestionar Mensajes.");
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

					menuEjemplares();
					break;
				case 3:
					menuMensajes();
					break;
				case 4:
					Controlador.getServicios().setUsername("invitado");
					System.out.println("Salida del menu del menu personal...");
					System.out.println("");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Introduce un numero.... Repita el proceso");
				sc.nextLine();
				opcion = 0;
			}

		} while (opcion != 4);

	}

	public void menuEjemplares() {
		int opcion = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("---Gestion de Ejemplares:---");
			System.out.println("1.  Crear ejemplar");
			System.out.println("2.  Ver ejemplares por tipo de planta.");
			System.out.println("3.  Ver mensajes de un ejemplar.");
			System.out.println("4.  Salir");
			try {
				opcion = sc.nextInt();
				if (opcion < 1 || opcion > 4) {
					System.out.println("Opción incorrecta.");
					continue;
				}
				switch (opcion) {
				case 1:
					crearEjemplar();
					break;
				case 2:
					ViveroFachadaPersonal.getPortal().mostrarMensajeTipoPlanta();
					break;
				case 3:
					mostrarMensajePorEjemplar();
					break;

				}
			} catch (InputMismatchException e) {
				System.out.println("Introduce un numero.... Repita el proceso");
				sc.nextLine();
				opcion = 0;

			}

		} while (opcion != 4);

	}

	public void crearEjemplar() {
		Scanner sc = new Scanner(System.in);
		System.out.println("***Creando ejemplar");
		System.out.println("-- PLANTAS EXISTENTES EN LA BASE DE DATOS");
		plantaServ.verTodas();
		Ejemplar ej = new Ejemplar();
		System.out.print("Código de la planta del ejemplar: ");
		String codigo = sc.next().trim().toUpperCase();

		if (Controlador.getServicios().getServiciosPlanta().existePorCodigo(codigo)) {
			/// System.out.println("Existe el codigo");
			ej.setIdPlanta(codigo);
			ej.setNombre(codigo);

			long idNuevo = Controlador.getServicios().getServiciosEjemplar().insertarEjemplar(ej);

			String nuevoNombre = codigo + "_" + idNuevo;
			Controlador.getServicios().getServiciosEjemplar().modificarNombreEjemplar(idNuevo, nuevoNombre);

			LocalDateTime fechahora = LocalDateTime.now();
			String username = Controlador.getServicios().getUsername();
			String mensaje = "Añadido nuevo ejemplar " + ej.getNombre() + " por " + username + " (" + fechahora + " ).";
			long idCredencial = Controlador.getServicios().getServiciosCredenciales().buscarIdPorUsuario(username);
			long idPersona = Controlador.getServicios().getServiciosPersona().buscarPorIDCredencial(idCredencial)
					.getId();

			Mensaje m = new Mensaje(fechahora, mensaje, idNuevo, idPersona);

			Controlador.getServicios().getServiciosMensaje().insertarMensaje(m);
		} else {
			System.out.println("--- NO Existe el codigo:" + codigo);

		}

	}

	public void mostrarMensajeTipoPlanta() {
		try {
			Scanner sc = new Scanner(System.in);
			plantaServ.verTodas();
			System.out.println("Introduce el código de la planta");
			String codigo = sc.next().trim().toUpperCase();

			boolean codigoOk = Controlador.getServicios().getServiciosPlanta().existePorCodigo(codigo);
			if (codigoOk) {
				if (ejemplarServ.ejemplaresPorTipoPlanta(codigo).isEmpty()) {
					System.out.println("No hay ejemplares con el codigo: " + codigo);

				} else {
					ArrayList<Mensaje> mensajes = Controlador.getServicios().getServiciosMensaje()
							.mostrarMensajeTipoPlanta(codigo);

					if (mensajes.isEmpty()) {
						System.out.println("No hay mensajes con código: " + codigo);
					} else {
						System.out.println("---- Mensajes con código: " + codigo);
						for (Mensaje m : mensajes) {
							System.out.println(m);
						}
					}
				}
			} else {
				System.out.println("El codigo: " + codigo + " no es  correcto");

			}
		} catch (Exception e) {
			System.out.println("Error al  mostar mensajes por codigo planta " + e.getMessage());
		}

	}

	public void mostrarMensajePorEjemplar() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("-LISTADO DE LOS EJEMPLARES EN LA BASE DE DATOS");
			ejemplarServ.verTodas();
			System.out.println("Introduce el nombre del Ejemplar");
			String nombre = sc.next().trim();

			boolean nombreOk = Controlador.getServicios().getServiciosEjemplar().existePorNombre(nombre);
			if (nombreOk) {
				Ejemplar ej = controlador.getServiciosEjemplar().buscarEjemplarPorNombre(nombre);
				long id = (ej != null ? ej.getId() : 0);

				ArrayList<Mensaje> mensajes = Controlador.getServicios().getServiciosMensaje()
						.mostrarMensajeIdEjemplar(id);

				if (mensajes.isEmpty()) {
					System.out.println("No hay mensajes con el nombre: " + nombre);
				} else {
					System.out.println("---- Mensajes del ejemlar : " + nombre);
					for (Mensaje m : mensajes) {
						System.out.println(m);
					}
				}

			} else {
				System.out.println("No hay ejemplares con el nombre: " + nombre);

			}
		} catch (Exception e) {
			System.out.println("Error al  mostar mensajes por codigo planta " + e.getMessage());
		}

	}

	public void menuMensajes() {
		int opcion = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("---Gestion de Mensajes:---");
			System.out.println("1.  Crear Mensaje");
			System.out.println("2.  Ver todos los Mensajes (SIN FILTRAR).");
			System.out.println("3.  Ver Mensajes (FILTRADO).");
			System.out.println("4.  Salir");
			try {
				opcion = sc.nextInt();
				if (opcion < 1 || opcion > 4) {
					System.out.println("Opción incorrecta.");
					continue;
				}
				switch (opcion) {
				case 1:
					crearMensaje();
					break;
				case 2:
					Controlador.getServicios().getServiciosMensaje().vertodosMensajes();
					break;
				case 3:
					menuFiltrarMensaje();

					break;

				}
			} catch (InputMismatchException e) {
				System.out.println("Introduce un numero.... Repita el proceso");
				sc.nextLine();
				opcion = 0;

			}

		} while (opcion != 4);

	}

	public void crearMensaje() {
		Scanner sc = new Scanner(System.in);
		Mensaje nuevoMensaje = new Mensaje();
		String nombreEj = null;
		String texto = null;

		try {
			System.out.println("Introduce el nombre del ejemplar");
			nombreEj = sc.next();

			boolean nombreOk = Controlador.getServicios().getServiciosEjemplar().existePorNombre(nombreEj);
			if (nombreOk) {
				sc.nextLine();
				System.out.println("Introduce el mensaje: ");
				texto = sc.nextLine();
				LocalDateTime fechahora = LocalDateTime.now();
				String username = Controlador.getServicios().getUsername();
				long idCredencial = Controlador.getServicios().getServiciosCredenciales().buscarIdPorUsuario(username);
				long idPersona = Controlador.getServicios().getServiciosPersona().buscarPorIDCredencial(idCredencial)
						.getId();
				Ejemplar ej = Controlador.getServicios().getServiciosEjemplar().buscarEjemplarPorNombre(nombreEj);

				long idEjemplar = (ej != null ? ej.getId() : 0);

				Mensaje m = new Mensaje(fechahora, texto, idEjemplar, idPersona);
				Controlador.getServicios().getServiciosMensaje().insertarMensaje(m);

			} else {
				System.out.println("No existe el nombre de ejemplar: " + nombreEj);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

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

					// mensajesServ.verMensajeIdPersona(idPersona);
					break;

				case 3:
					sc.nextLine();
					System.out.println("Introduce el id de Ejemplar");
					long idEjemplar = sc.nextLong();

					Controlador.getServicios().getServiciosMensaje().mostrarMensajeIdEjemplar(idEjemplar);

					break;

				case 4:
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Introduce un numero.... Repita el proceso");
				sc.nextLine();
				opcion = 0;

			}

		} while (opcion != 4);

	}

}
