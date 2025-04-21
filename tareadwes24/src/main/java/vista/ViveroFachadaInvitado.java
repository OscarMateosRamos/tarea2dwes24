package vista;

import java.util.List;

import control.Controlador;
import control.ServiciosPlanta;
import modelo.Planta;

public class ViveroFachadaInvitado {

	private static ViveroFachadaInvitado portalInvitado;

	public ViveroFachadaInvitado() {

	}

	// Connection con = ConexBD.realizaConexion();

	Controlador factoriaServicios = Controlador.getServicios();

	ServiciosPlanta plantaServ = factoriaServicios.getServiciosPlanta();

	public static ViveroFachadaInvitado getPortal() {
		if (portalInvitado == null)
			portalInvitado = new ViveroFachadaInvitado();
		return portalInvitado;
	}

	public void mostrarPlantasInvitado() {
		System.out.println("-- LISTADO DE PLANTAS --");
		List<Planta> plantas = (List<Planta>) plantaServ.verTodas();

//		int opcion = 0;
//		Scanner sc = new Scanner(System.in);
//		do {
//			System.out.println("--Menu Invitado--:");
//			System.out.println("1.  Ver plantas.");
//			System.out.println("2.  Salir.");
//
//			try {
//				opcion = sc.nextInt();
//				if (opcion < 1 || opcion > 2) {
//					System.out.println("Opción incorrecta.");
//					continue;
//				}
//				switch (opcion) {
//				case 1:
//					plantaServ.verTodas();
//					break;
//
//				case 2:
//					Controlador.getServicios().setUsername("invitado");
//					System.out.println("Salida del menu del menu invitado...");
//					System.out.println("");
//					break;
//				}
//
//			} catch (InputMismatchException e) {
//				System.out.println("Introduce un numero.... Repita el proceso");
//				sc.nextLine();
//				opcion = 0;
//			}
//
//		} while (opcion != 2);

	}

}
