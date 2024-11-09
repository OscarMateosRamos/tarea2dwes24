package modelo;


public class Persona {
	private long id;
	private String nombre;
	private String email;
	private long idCredencial;

	public Persona() {

	}

	public Persona(long id, String nombre, String email, long idCredencial) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.idCredencial = idCredencial;
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

	public long getIdCredencial() {
		return idCredencial;
	}

	public void setIdCredencial(long id_Credencial) {
		this.idCredencial = id_Credencial;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", email=" + email + ", idCredencial=" + idCredencial
				+ "]";
	}

}
