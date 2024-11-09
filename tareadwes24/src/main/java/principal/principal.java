package principal;

import vista.ViveroFachadaAdmin;

public class principal {

	public static void main(String[] args) {

		ViveroFachadaAdmin portalAdmin = ViveroFachadaAdmin.getPortal() ;

		portalAdmin.mostrarMenuPrincipal();
		
		
		
		
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

}
