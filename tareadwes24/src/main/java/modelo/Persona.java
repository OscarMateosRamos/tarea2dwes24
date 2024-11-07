package modelo;


public class Persona {
	private long id;
	private String nombre;
	private String email;
	private long id_Credencial;

	public Persona() {

	}

	public Persona(long id, String nombre, String email, long id_Credencial) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.id_Credencial = id_Credencial;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getId_Credencial() {
		return id_Credencial;
	}

	public void setId_Credencial(long id_Credencial) {
		this.id_Credencial = id_Credencial;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", email=" + email + ", id_Credencial=" + id_Credencial
				+ "]";
	}

}
