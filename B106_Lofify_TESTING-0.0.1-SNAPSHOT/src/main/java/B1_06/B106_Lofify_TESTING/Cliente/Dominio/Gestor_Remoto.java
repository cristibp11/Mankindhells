package B1_06.B106_Lofify_TESTING.Cliente.Dominio;

import B1_06.B106_Lofify_TESTING.Servidor.Dominio.*;

public class Gestor_Remoto {

	public Usuario nuevoUsuarioManual() {
		// TODO - implement Gestor_Remoto.nuevoUsuarioManual
		throw new UnsupportedOperationException();
	}

	public Usuario nuevoUsuarioGeneral() {
		// TODO - implement Gestor_Remoto.nuevoUsuarioGeneral
		throw new UnsupportedOperationException();
	}
	
	public Usuario_Logueado loginUsuario(String user, String pass){
		Usuario u = B1_06.B106_Lofify_TESTING.Servidor.Dominio.Gestor_Remoto.buscarUsuario(user, pass).get(0);
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