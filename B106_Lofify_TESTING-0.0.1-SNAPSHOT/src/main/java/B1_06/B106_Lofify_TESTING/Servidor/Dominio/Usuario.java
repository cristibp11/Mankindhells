package B1_06.B106_Lofify_TESTING.Servidor.Dominio;

public class Usuario {

	private String user;
	private String pass;
	private String nombre;
	private String apellidos;
	private long nCuenta;
	private String email;

	public Usuario(String user, String pass, String nombre, String apellidos, long nCuenta, String email) {
		super();
		this.user = user;
		this.pass = pass;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nCuenta = nCuenta;
		this.email = email;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public String getUser() {
		return user;
	}

	public String getPass() {
		return pass;
	}

	public long getnCuenta() {
		return nCuenta;
	}

	public String getEmail() {
		return email;
	}

}
