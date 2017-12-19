package B1_06.B106_Lofify_TESTING.Servidor.Dominio;

import java.util.LinkedList;

import B1_06.B106_Lofify_TESTING.Servidor.Persistencia.Agente;

public class Gestor_Remoto {

	public static Usuario fabricaUsuarios() {
		Usuario Usuario = new Usuario("Usuarioser", "Usuarioser", "DefaUsuariolt", "", (long) 213655987, "Usuarioser@Usuarioser.com");
		Agente a = new Agente();
		String[] search = { Usuario.getUser(), Usuario.getPass(), Usuario.getNombre(), Usuario.getApellidos(), String.valueOf(Usuario.getnCuenta()),
				Usuario.getEmail() };
		a.modificar(search, (short) 4, (short) 1);
		return Usuario;
	}

	public static Usuario creadorUsuarios(String Usuarioser, String pass, String nombre, String apellidos, long cUsuarioenta,
			String email) {
		Usuario Usuario = new Usuario(Usuarioser, pass, nombre, apellidos, cUsuarioenta, email);
		Agente a = new Agente();
		String[] search = { Usuario.getUser(), Usuario.getPass(), Usuario.getNombre(), Usuario.getApellidos(), String.valueOf(Usuario.getnCuenta()),
				Usuario.getEmail() };
		a.modificar(search, (short) 4, (short) 1);
		return Usuario;
	}

	public static LinkedList<Usuario> buscarUsuario(String Usuarioser, String pass) {
		Agente a = new Agente();
		LinkedList<Usuario> list = new LinkedList<Usuario>();
		String[] resUsuariolt = a.leer(Usuarioser, (short) 4);
		try {
			list.add(new Usuario(Usuarioser, pass, resUsuariolt[2], resUsuariolt[3], Long.valueOf(resUsuariolt[4]), resUsuariolt[5]));
		} catch (NullPointerException npe) {

		}
		return list;
	}

	/**
	 * 
	 * @param Usuario
	 * @param cantidad
	 */
	public Void cobrarPaypal(Usuario Usuario, double cantidad) {
		// TODO - implement Gestor_Remoto.cobrarPaypal
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Usuario
	 */
	public static void eliminarUsuario(Usuario Usuario) {
		Agente a = new Agente();
		String[] search = { Usuario.getUser(), Usuario.getPass(), Usuario.getNombre(), Usuario.getApellidos(), String.valueOf(Usuario.getnCuenta()),
				Usuario.getEmail() };
		a.modificar(search, (short) 4, (short) 3);
	}

}
