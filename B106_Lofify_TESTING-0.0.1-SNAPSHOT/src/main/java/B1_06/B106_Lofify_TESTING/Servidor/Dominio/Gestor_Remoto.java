package B1_06.B106_Lofify_TESTING.Servidor.Dominio;

import java.util.LinkedList;

import B1_06.B106_Lofify_TESTING.Servidor.Persistencia.Agente;

public class Gestor_Remoto {

	public static Usuario fabricaUsuarios() {
		Usuario Usuario = new Usuario("Usuarioser", "Usuarioser", "DefaUsuariolt", "", (long) 213655987,
				"Usuarioser@Usuarioser.com");
		Agente a = new Agente();
		String[] search = { Usuario.getUser(), Usuario.getPass(), Usuario.getNombre(), Usuario.getApellidos(),
				String.valueOf(Usuario.getnCuenta()), Usuario.getEmail() };
		a.modificar(search, (short) 4, (short) 1);
		return Usuario;
	}

	public static Usuario creadorUsuarios(String Usuarioser, String pass, String nombre, String apellidos,
			long cUsuarioenta, String email) {
		Usuario Usuario = new Usuario(Usuarioser, pass, nombre, apellidos, cUsuarioenta, email);
		Agente a = new Agente();
		String[] search = { Usuario.getPass(), Usuario.getUser(), Usuario.getNombre(), Usuario.getApellidos(),
				String.valueOf(Usuario.getnCuenta()), Usuario.getEmail() };
		a.modificar(search, (short) 4, (short) 1);
		return Usuario;
	}

	public static Usuario buscarUsuario(String user, String pass) {
		Agente a = new Agente();
		Usuario u = null;
		String[] resUsuariolt = a.leer(user, (short) 4);
		if(resUsuariolt != null && resUsuariolt[0].equals(pass)){
			u = new Usuario(user, pass, resUsuariolt[2], resUsuariolt[3], Long.valueOf(resUsuariolt[4]), resUsuariolt[5]);
		}
		return u;
	}

	/**
	 * 
	 * @param Usuario
	 */
	public static void eliminarUsuario(Usuario Usuario) {
		if (Usuario.getUser() != null && Usuario.getPass() != null && Usuario.getNombre() != null
				&& Usuario.getApellidos() != null && Usuario.getnCuenta() >= 0 && Usuario.getnCuenta() < 1000000) {
			Agente a = new Agente();
			String[] search = { Usuario.getUser(), Usuario.getPass(), Usuario.getNombre(), Usuario.getApellidos(),
					String.valueOf(Usuario.getnCuenta()), Usuario.getEmail() };
			a.modificar(search, (short) 4, (short) 3);
		}
	}

}
