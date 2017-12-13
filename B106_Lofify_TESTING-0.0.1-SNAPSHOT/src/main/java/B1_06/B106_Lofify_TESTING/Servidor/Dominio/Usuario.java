package B1_06.B106_Lofify_TESTING.Servidor.Dominio;

public class Usuario {

	private String user;
	private String pass;
	private String nombre;
	private String apellidos;
	private long nCuenta;
	private String email;

	public String getNombre() {
		return this.nombre;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public long getNCuenta() {
		return this.nCuenta;
	}

}
