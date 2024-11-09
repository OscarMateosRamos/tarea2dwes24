package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.MysqlDataSource;

import dao.CredencialesDAO;
import dao.EjemplarDAO;
import dao.MensajeDAO;
import dao.PersonaDAO;
import dao.PlantaDAO;

public class ConexBD {
<<<<<<< HEAD
	private static Connection con = ConexBD.realizaConexion();
=======
	private static Connection con;
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
	private static ConexBD f;

	public static Connection realizaConexion() {
		Properties prop = new Properties();
		MysqlDataSource m = new MysqlDataSource();
		FileInputStream fis;

		try {
			fis = new FileInputStream("src/main/resources/db.properties.txt");

			prop.load(fis);

			m.setUrl(prop.getProperty("url"));
			m.setPassword(prop.getProperty("password"));
			m.setUser(prop.getProperty("usuario"));

			con = m.getConnection();

		} catch (FileNotFoundException e) {
			System.out.println("Error al acceder al fichero properties " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error al leer las propiedades del fichero properties" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Error al conectar a la base de datos:usuario,password....");
		}
		return con;
	}

	public static void cerrarConexion() {
		try {
			if (con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static ConexBD getInstance() {
		if (f == null)
			f = new ConexBD();
		return f;
	}

	public PlantaDAO getPlantaDAO() {
		return new PlantaDAO(con);
	}

	public EjemplarDAO getEjemplarDAO() {
		return new EjemplarDAO(con);
	}

	public PersonaDAO getPersonaDAO() {
		return new PersonaDAO(con);
	}

	public MensajeDAO getMensajeDAO() {
		return new MensajeDAO(con);
	}

	public CredencialesDAO getCredencialesDAO() {
		return new CredencialesDAO(con);
	}
}
