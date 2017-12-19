package B1_06.B106_Lofify_TESTING.Cliente.Dominio;

import B1_06.B106_Lofify_TESTING.Servidor.Dominio.*;

public class Gestor_Remoto {

	public static Usuario nuevoUsuarioManual(String user, String pass, String nombre, 
			String apellidos, long cuenta, String email) {
		return B1_06.B106_Lofify_TESTING.Servidor.Dominio.Gestor_Remoto.creadorUsuarios(
				user, pass, nombre, apellidos, cuenta, email);
	}

	public static Usuario nuevoUsuarioGeneral() {
		return B1_06.B106_Lofify_TESTING.Servidor.Dominio.Gestor_Remoto.fabricaUsuarios();
	}
	
	public static Usuario_Logueado loginUsuario(String user, String pass){
		Usuario u = B1_06.B106_Lofify_TESTING.Servidor.Dominio.Gestor_Remoto.buscarUsuario(user, pass);
		Usuario_Logueado log = null;
		try{
			log = new Usuario_Logueado(u.getUser(), u.getPass(), u.getNombre(), u.getApellidos(), u.getnCuenta(), u.getEmail());
		}catch (NullPointerException npe){
			
		}
		return log;
	}

	/**
	 * 
	 * @param artista
	 * @param album
	 * @param titulo
	 */
	public Cancion buscar(String artista, String album, String titulo) {
		// TODO - implement Gestor_Remoto.buscar
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param cantidad
	 */
	public void cobrar(double cantidad) {
		// TODO - implement Gestor_Remoto.cobrar
		throw new UnsupportedOperationException();
	}

}