package main;

import java.util.InputMismatchException;
import java.util.Scanner;

import control.Controlador;
import vista.ViveroFachadaAdmin;
import vista.ViveroFachadaInvitado;
import vista.ViveroFachadaPersonal;

public class principal {

	public static void main(String[] args) {

		menuLogin();
	}

	private static Controlador controlador = Controlador.getServicios();

	ViveroFachadaInvitado portalInvitado = ViveroFachadaInvitado.getPortal();

	public static void menuLogin() {
		int opcion = 0;

		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("---MENU PRINCIPAL---");
			System.out.println("1.  ENTRAR COMO INVITADO");
			System.out.println("2.  PERSONAL.");
			System.out.println("3.  ADMINISTRADOR.");
			System.out.println("4.  Salir");
			try {
				opcion = sc.nextInt();
				if (opcion < 1 || opcion > 4) {
					System.out.println("Opción incorrecta.");
					continue;
				}
				switch (opcion) {
				case 1:
					ViveroFachadaInvitado portalInvitado = ViveroFachadaInvitado.getPortal();
					portalInvitado.getPortal().mostrarMenuPrincipal();

					break;
				case 2:
					sc = new Scanner(System.in);
					System.out.println(" Introduce Usuario");
					String usuario = sc.nextLine();
					System.out.println("Introduce Contraseña");
					String password = sc.nextLine();

					boolean userOk = Controlador.getServicios().getServiciosCredenciales().validarCredencial(usuario,
							password);
					if (userOk) {
						controlador.setUsername(usuario);
						System.out.println("Usuario y password Correcto");

						ViveroFachadaPersonal portalPersonal = ViveroFachadaPersonal.getPortal();
						portalPersonal.getPortal().mostrarMenuPrincipal();
					} else {
						System.out.println("Usuario y password Erroneo");
					}
					break;

				case 3:
					sc = new Scanner(System.in);
					System.out.println(" Introduce Usuario");
					usuario = sc.nextLine();
					System.out.println("Introduce Contraseña");
					password = sc.nextLine();

					if (usuario.equals("admin") && password.equals("admin")) {
						System.out.println("--Bienvenido Admin--");
						controlador.setUsername("admin");

						ViveroFachadaAdmin portalAdmin = ViveroFachadaAdmin.getPortal();

						portalAdmin.getPortal().mostrarMenuPrincipal();

					} else {
						System.out.println("Usuario y Password erroneas");
					}

					break;

				case 4:
					Controlador.getServicios().setUsername("invitado");
					System.out.println("-----------------");
					System.out.println("Fin del programa");
					System.out.println("-----------------");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Tienes que introducir un numero....Repita el proceso");
				sc.nextLine();
				opcion = 0;
			}

		} while (opcion != 4);

	}
	/*
	 * public static void loginUsuario() {
	 * 
	 * Scanner sc = new Scanner(System.in);
	 * System.out.println(" Introduce Usuario"); String usuario = sc.nextLine();
	 * System.out.println("Introduce Contraseña"); String password = sc.nextLine();
	 * boolean usuarioOK =
	 * controlador.getServiciosCredenciales().validarUsuario(usuario);
	 * 
	 * if (usuarioOK) {
	 * 
	 * if (usuario.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin"))
	 * { System.out.println("Sesión iniciada como administrador ");
	 * ViveroFachadaAdmin portalAdmin = ViveroFachadaAdmin.getPortal();
	 * portalAdmin.mostrarMenuPrincipal(); } else if
	 * (usuario.equalsIgnoreCase("personal") &&
	 * password.equalsIgnoreCase("pesonal")) {
	 * 
	 * } } else { System.out.println("Error al introducir usuario y contraseña"); }
	 * }
	 */
}
