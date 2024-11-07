package modelo;


public class Ejemplar {
	private long id;
	private String nombre;
	private String idPlanta;

	public Ejemplar() {

	}

	public Ejemplar(long id, String nombre, String idPlanta) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.idPlanta = idPlanta;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdPlanta() {
		return idPlanta;
	}

	public void setIdPlanta(String idPlanta) {
		this.idPlanta = idPlanta;
	}

	@Override
	public String toString() {
		return "Ejemplar [id=" + id + ", nombre=" + nombre + ", idPlanta=" + idPlanta + "]";
	}

}
