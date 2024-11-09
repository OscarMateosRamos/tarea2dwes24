package control;

public class Controlador {
	private static Controlador servicios;
	private ServiciosPlanta servPlanta;
	private ServiciosEjemplar servEjemplar;
	private ServiciosPersona servPersona;
	private ServiciosMensaje servMensaje;
<<<<<<< HEAD
	private ServiciosCredenciales servCredenciales;
	;
=======
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
	
	public static Controlador getServicios() {
		if (servicios == null) {
			servicios = new Controlador();
		}
		return servicios;
	}

	private Controlador() {
		servPlanta = new ServiciosPlanta();
		servEjemplar = new ServiciosEjemplar();
		servPersona = new ServiciosPersona();
		servMensaje = new ServiciosMensaje();
<<<<<<< HEAD
		servCredenciales= new ServiciosCredenciales();
=======
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
	}

	public ServiciosPlanta getServiciosPlanta() {
		return servPlanta;
	}
	
	public ServiciosEjemplar getServiciosEjemplar() {
		return servEjemplar;
	}
	
	public ServiciosPersona getServiciosPersona() {
		return servPersona;
	}
	
	public ServiciosMensaje getServiciosMensaje() {
		return servMensaje;
	}
<<<<<<< HEAD
	
	public ServiciosCredenciales getServiciosCredenciales() {
		return servCredenciales;
	}
=======
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
}
