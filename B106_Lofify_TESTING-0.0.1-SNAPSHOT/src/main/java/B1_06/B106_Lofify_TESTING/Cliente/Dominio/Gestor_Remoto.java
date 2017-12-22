package B1_06.B106_Lofify_TESTING.Cliente.Dominio;

import B1_06.B106_Lofify_TESTING.Servidor.Dominio.*;

public class Gestor_Remoto {

	public static Usuario nuevoUsuarioManual(String user, String pass, String nombre, String apellidos, long cuenta,
			String email) {
		if (user != null && pass != null && nombre != null && apellidos != null && cuenta>=0 && cuenta<1000000) {
			return B1_06.B106_Lofify_TESTING.Servidor.Dominio.Gestor_Remoto.creadorUsuarios(user, pass, nombre,
					apellidos, cuenta, email);
		} else {
			return null;
		}
	}

	public static Usuario nuevoUsuarioGeneral() {
		return B1_06.B106_Lofify_TESTING.Servidor.Dominio.Gestor_Remoto.fabricaUsuarios();
	}

	public static Usuario_Logueado loginUsuario(String user, String pass) {
		
		Usuario u = null;
		Usuario_Logueado log = null;
		if(user != null && pass != null){
			u = B1_06.B106_Lofify_TESTING.Servidor.Dominio.Gestor_Remoto.buscarUsuario(user, pass);
		}
		if (u != null)
			log = new Usuario_Logueado(u.getUser(), u.getPass(), u.getNombre(), u.getApellidos(), u.getnCuenta(),
					u.getEmail());
		
		return log;
	}

}