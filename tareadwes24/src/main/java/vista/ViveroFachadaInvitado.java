package vista;

import java.sql.Connection;
import java.util.InputMismatchException;
import java.util.Scanner;

import control.Controlador;
import control.ServiciosPlanta;
import utils.ConexBD;

public class ViveroFachadaInvitado {

	private static ViveroFachadaInvitado portalInvitado;

	public ViveroFachadaInvitado() {

	}

	//Connection con = ConexBD.realizaConexion();

	Controlador factoriaServicios = Controlador.getServicios();

	ServiciosPlanta plantaServ = factoriaServicios.getServiciosPlanta();

	public static ViveroFachadaInvitado getPortal() {
		if (portalInvitado == null)
			portalInvitado = new ViveroFachadaInvitado();
		return portalInvitado;
	}

	public void mostrarMenuPrincipal() {
		int opcion = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("--Menu Invitado--:");
			System.out.println("1.  Ver plantas.");
			System.out.println("2.  Salir.");

			try {
				opcion = sc.nextInt();
				if (opcion < 1 || opcion > 2) {
					System.out.println("Opción incorrecta.");
					continue;
				}
				switch (opcion) {
				case 1:
					plantaServ.verTodas();
					break;

				case 2:
					Controlador.getServicios().setUsername("invitado");
					System.out.println("Salida del menu del menu invitado...");
					System.out.println("");
					break;
				}

			} catch (InputMismatchException e) {
				System.out.println("Introduce un numero.... Repita el proceso");
				sc.nextLine();
				opcion = 0;
			}

		} while (opcion != 2);

	}

}
