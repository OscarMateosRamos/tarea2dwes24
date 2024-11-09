package modelo;


public class Persona {
	private long id;
	private String nombre;
	private String email;
<<<<<<< HEAD
	private long idCredencial;
=======
	private long id_Credencial;
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb

	public Persona() {

	}

<<<<<<< HEAD
	public Persona(long id, String nombre, String email, long idCredencial) {
=======
	public Persona(long id, String nombre, String email, long id_Credencial) {
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
<<<<<<< HEAD
		this.idCredencial = idCredencial;
=======
		this.id_Credencial = id_Credencial;
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
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

<<<<<<< HEAD
	public long getIdCredencial() {
		return idCredencial;
	}

	public void setIdCredencial(long id_Credencial) {
		this.idCredencial = id_Credencial;
=======
	public long getId_Credencial() {
		return id_Credencial;
	}

	public void setId_Credencial(long id_Credencial) {
		this.id_Credencial = id_Credencial;
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		return "Persona [id=" + id + ", nombre=" + nombre + ", email=" + email + ", idCredencial=" + idCredencial
=======
		return "Persona [id=" + id + ", nombre=" + nombre + ", email=" + email + ", id_Credencial=" + id_Credencial
>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
				+ "]";
	}

}
