package main;

import java.util.Scanner;

import control.Controlador;
import vista.ViveroFachadaAdmin;
import vista.ViveroFachadaInvitado;

public class principal {

	public static void main(String[] args) {

		menuLogin();
	}

	private static Controlador controlador = Controlador.getServicios();

	public static void menuLogin() {

		int opcion = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("---MENU PRINCIPAL---");
			System.out.println("1.  ENTRAR COMO INVITADO");
			System.out.println("2.  PERSONAL.");
			System.out.println("3.  ADMINISTRADOR.");
			System.out.println("4.  Salir");

			opcion = sc.nextInt();
			if (opcion < 1 || opcion > 4) {
				System.out.println("Opción incorrecta.");
				continue;
			}
			switch (opcion) {
			case 1:
				ViveroFachadaInvitado portalInvitado = ViveroFachadaInvitado.getPortal();
				portalInvitado.getPortal().mostrarMenuPrincipal();
				;
				break;
			case 2:
				sc = new Scanner(System.in);
				System.out.println(" Introduce Usuario");
				String  usuario = sc.nextLine();
				System.out.println("Introduce Contraseña");
				String password = sc.nextLine();
				
				boolean userOk=Controlador.getServicios().getServiciosCredenciales().validarCredencial(usuario, password);
				if (userOk) {
					System.out.println("Usuario y password Correcto");
					//fachada usuario personal 
				}else {
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
					ViveroFachadaAdmin portalAdmin = ViveroFachadaAdmin.getPortal();
					portalAdmin.getPortal().mostrarMenuPrincipal();
				}else {
					System.out.println("Usuario y Password erroneas");
				}

				break;

			case 4:
				break;
			}

		} while (opcion != 4);

	}

	public static void loginUsuario() {

		Scanner sc = new Scanner(System.in);
		System.out.println(" Introduce Usuario");
		String usuario = sc.nextLine();
		System.out.println("Introduce Contraseña");
		String password = sc.nextLine();
		boolean usuarioOK = controlador.getServiciosCredenciales().validarUsuario(usuario);

		if (usuarioOK) {

			if (usuario.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
				System.out.println("Sesión iniciada como administrador ");
				ViveroFachadaAdmin portalAdmin = ViveroFachadaAdmin.getPortal();
				portalAdmin.mostrarMenuPrincipal();
			} else if (usuario.equalsIgnoreCase("personal") && password.equalsIgnoreCase("pesonal")) {

			}
		} else {
			System.out.println("Error al introducir usuario y contraseña");
		}
	}

	/*
	 * Scanner sc = new Scanner(System.in);
	 * 
	 * System.out.println("INI");
	 * 
	 * System.out.println("Dame el codigo de la nueva Planta"); String codigo =
	 * sc.next().trim().toUpperCase();
	 * 
	 * System.out.println("Dame el nombre comun de la nueva planta"); String
	 * nombre_comun = sc.nextLine();
	 * 
	 * System.out.println("Dame el nombre cientifico de la nueva planta"); String
	 * nombre_cientifico = sc.nextLine();
	 * 
	 * Planta nueva = new Planta(codigo, nombre_comun, nombre_cientifico);
	 * 
	 * 
	 * if (!Controlador.getServicios().validarPlanta(nueva)) { System.out.
	 * println("Los valores introducidos para la planta son incorrectos.Repita el proceso"
	 * ); }
	 * 
	 * int resultado = Controlador.getServicios().validarPlanta(nueva);
	 * 
	 * 
	 * System.out.println("INI");
	 * 
	 * System.out.println("Dame el codigo de la nueva Planta:"); String codigo =
	 * sc.nextLine().trim().toUpperCase();
	 * System.out.println("Dame el nombre común de la nueva planta"); String
	 * nombre_comun = sc.nextLine();
	 * System.out.println("Dame el nombre cientifico de la nueva planta"); String
	 * nombre_cientifico = sc.nextLine();
	 * 
	 * Planta nueva = new Planta(codigo, nombre_comun, nombre_cientifico);
	 * 
	 * Connection con; MysqlDataSource m = new MysqlDataSource(); Properties prop =
	 * null; FileInputStream fis;
	 * 
	 * 
	 * String url; String usuario; String password;
	 * 
	 * try {
	 * 
	 * fis = new FileInputStream("src/main/resources/db.properties");
	 * prop.load(fis); url = prop.getProperty("url"); usuario =
	 * prop.getProperty("usuario"); password = prop.getProperty("password");
	 * m.setUrl(url); m.setUser(usuario); m.setPassword(password);
	 * 
	 * con = m.getConnection();
	 * 
	 * String sql =
	 * "INSERT INTO plantas(codigo, nombrecomun, nombrecientifico) VALUES ('" +
	 * nueva.getCodigo() + "' , '" + nueva.getNombrecomun() + "', '" +
	 * nueva.getNombrecientifico() + "')";
	 * 
	 * String sql2 =
	 * "INSERT INTO plantas(codigo,nombrecomun,nombrecientifico)VALUES(?,?,?)";
	 * 
	 * PreparedStatement ps = con.prepareStatement(sql2); ps.setString(1,
	 * nueva.getCodigo()); ps.setString(2, nueva.getNombrecomun()); ps.setString(3,
	 * nueva.getNombrecientifico());
	 * 
	 * ps.executeUpdate(); ps.close(); con.close();
	 * 
	 * } catch (SQLException e) {
	 * System.out.println("Se ha producido una SQLException : " +
	 * e.getLocalizedMessage()); e.printStackTrace(); } catch (FileNotFoundException
	 * e) { System.out.println("Se ha producido una FileNotFoundException : " +
	 * e.getLocalizedMessage()); e.printStackTrace(); } catch (IOException e) {
	 * System.out.println("Se ha producido una IOException : " +
	 * e.getLocalizedMessage()); e.printStackTrace(); }
	 * 
	 * System.out.println("FIN");
	 */

}
