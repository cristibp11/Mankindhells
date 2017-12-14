package B1_06.B106_Lofify_TESTING.Servidor.Dominio;

import java.util.LinkedList;

import B1_06.B106_Lofify_TESTING.Servidor.Persistencia.Agente;

public class Gestor_Remoto {

	public static Usuario fabricaUsuarios() {
		Usuario u = new Usuario("user", "user", "Default", "", (long) 213655987, "user@user.com");
		Agente a = new Agente();
		String[] search = {u.getUser(), u.getPass(), u.getNombre(), u.getApellidos(), String.valueOf(u.getnCuenta()), u.getEmail()};
		a.modificar(search, (short) 4, (short) 1);
		return u;
	}

	public static Usuario creadorUsuarios(String user, String pass, String nombre, String apellidos, long cuenta, String email) {
		Usuario u =  new Usuario(user, pass, nombre, apellidos, cuenta, email);
		Agente a = new Agente();
		String[] search = {u.getUser(), u.getPass(), u.getNombre(), u.getApellidos(), String.valueOf(u.getnCuenta()), u.getEmail()};
		a.modificar(search, (short) 4, (short) 1);
		return u;
	}
	
	public static LinkedList<Usuario> buscarUsuario(String user, String pass){
		Agente a = new Agente();
		LinkedList<Usuario> list = new LinkedList<Usuario>();
		String[] result = a.leer(user,(short) 4);
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
	public static void eliminarUsuario(Usuario u) {
		Agente a = new Agente();
		String[] search = {u.getUser(), u.getPass(), u.getNombre(), u.getApellidos(), String.valueOf(u.getnCuenta()), u.getEmail()};
		a.modificar(search, (short) 4, (short) 3);
	}

}