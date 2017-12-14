package B1_06.B106_Lofify_TESTING.Cliente.Dominio;

import B1_06.B106_Lofify_TESTING.Servidor.Dominio.*;

public class Usuario_Logueado extends Usuario {

	public Usuario_Logueado(String user, String pass, String nombre, String apellidos, long nCuenta, String email) {
		super(user, pass, nombre, apellidos, nCuenta, email);
	}
}