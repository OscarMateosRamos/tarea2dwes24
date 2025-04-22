package main;

import java.util.InputMismatchException;
import java.util.Scanner;

import control.Controlador;
import control.ServiciosPlanta;
import vista.ViveroFachadaAdmin;
import vista.ViveroFachadaInvitado;
import vista.ViveroFachadaPersonal;

public class Principal {

	public static void main(String[] args) {

		menuLogin();
	}

	private static Controlador controlador = Controlador.getServicios();

	private static ViveroFachadaInvitado portalInvitado;

	public static void menuLogin() {
		int opcion = 0;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("\n--- BIENVENIDO AL VIVERO ---");
			System.out.println("1. VER PLANTAS EXISTENTES");
			System.out.println("2. LOGIN (PERSONAL O ADMIN)");
			System.out.println("3. SALIR");
			System.out.print("Selecciona una opción: ");

			try {
				opcion = sc.nextInt();
				sc.nextLine();

				switch (opcion) {
				case 1: // Ver Plantas directamente

					ViveroFachadaInvitado portalInvitado = ViveroFachadaInvitado.getPortal();
					portalInvitado.mostrarPlantasInvitado();
					break;

				case 2:
					System.out.print("Introduce Usuario: ");
					String usuario = sc.nextLine();

					System.out.print("Introduce Contraseña: ");
					String password = sc.nextLine();

					if (usuario.equals("admin") && password.equals("admin")) {
						System.out.println("-- Bienvenido Admin --");
						controlador.setUsername("admin");
						ViveroFachadaAdmin portalAdmin = ViveroFachadaAdmin.getPortal();
						portalAdmin.mostrarMenuPrincipal();
					} else {
						boolean userOk = Controlador.getServicios().getServiciosCredenciales()
								.validarCredencial(usuario, password);

						if (userOk) {
							System.out.println("Usuario y contraseña correctos.");
							controlador.setUsername(usuario);
							ViveroFachadaPersonal portalPersonal = ViveroFachadaPersonal.getPortal();
							portalPersonal.mostrarMenuPrincipal();
						} else {
							System.out.println("Usuario o contraseña incorrectos.");
						}
					}
					break;

				case 3:
					System.out.println("-----------------");
					System.out.println("Fin del programa has salido del vivero.");
					System.out.println("-----------------");
					break;

				default:
					System.out.println("Opción incorrecta. Intenta de nuevo.");
				}

			} catch (InputMismatchException e) {
				System.out.println("Debes introducir un número. Intenta de nuevo.");
				sc.nextLine();
			}

		} while (opcion != 3);
	}



}
