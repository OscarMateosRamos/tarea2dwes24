package modelo;


public class Credenciales {
	private long id;
	private String usuario;
	private String password;
<<<<<<< HEAD
=======

>>>>>>> 320b9b70541e663618ee62afd5c4a65839f5d3eb
	public Credenciales() {

	}

	public Credenciales(long id, String usuario, String password) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Credenciales [id=" + id + ", usuario=" + usuario + ", password=" + password + "]";
	}

}
