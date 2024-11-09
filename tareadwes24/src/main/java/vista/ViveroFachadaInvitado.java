package vista;

import java.sql.Connection;
import java.util.Scanner;

import control.Controlador;
import control.ServiciosCredenciales;
import control.ServiciosPlanta;
import utils.ConexBD;

public class ViveroFachadaInvitado {

	private static ViveroFachadaInvitado portal;

	Connection con = ConexBD.realizaConexion();

	Controlador factoriaServicios = Controlador.getServicios();

	ServiciosPlanta plantaServ = factoriaServicios.getServiciosPlanta();

	private static Controlador controlador = Controlador.getServicios();

	public static ViveroFachadaInvitado getPortal() {
		if (portal == null)
			portal = new ViveroFachadaInvitado();
		return portal;
	}

	public void mostrarMenuPrincipal() {
		int opcion = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("--Menu Invitado--:");
			System.out.println("1.  Ver plantas.");
			System.out.println("2.  Salir.");

			opcion = sc.nextInt();
			if (opcion < 1 || opcion > 2) {
				System.out.println("Opción incorrecta.");
				continue;
			}
			switch (opcion) {
			case 1:
				plantaServ.verPlanta();
				break;

			case 2:

				break;

			}

		} while (opcion != 2);

	}

}
