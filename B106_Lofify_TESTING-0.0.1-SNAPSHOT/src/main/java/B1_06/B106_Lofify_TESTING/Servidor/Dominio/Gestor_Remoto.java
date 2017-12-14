package B1_06.B106_Lofify_TESTING.Servidor.Dominio;

import java.util.LinkedList;

import B1_06.B106_Lofify_TESTING.Servidor.Persistencia.Agente;

public class Gestor_Remoto {

	public Void fabricaUsuarios() {
		// TODO - implement Gestor_Remoto.fabricaUsuarios
		throw new UnsupportedOperationException();
	}

	public Usuario creadorUsuarios() {
		// TODO - implement Gestor_Remoto.creadorUsuarios
		throw new UnsupportedOperationException();
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
	
	public static LinkedList<Usuario> buscarUsuario(String user, String pass){
		Agente a = new Agente();
		LinkedList<Usuario> list = new LinkedList<Usuario>();
		String[] result = a.leer(user, pass, (short) 4);
		try{
			list.add(new Usuario(user, pass, result[2], result[3], Long.valueOf(result[4]), result[5]));
		}catch (NullPointerException npe){
			
		}
		return list;
	}

	/**
	 * 
	 * @param u
	 * @param cantidad
	 */
	public Void cobrarPaypal(Usuario u, double cantidad) {
		// TODO - implement Gestor_Remoto.cobrarPaypal
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param u
	 */
	public Void eliminarUsuario(Usuario u) {
		// TODO - implement Gestor_Remoto.eliminarUsuario
		throw new UnsupportedOperationException();
	}

}