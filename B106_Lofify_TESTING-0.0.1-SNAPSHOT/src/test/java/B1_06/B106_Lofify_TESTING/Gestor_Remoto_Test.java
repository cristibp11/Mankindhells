package B1_06.B106_Lofify_TESTING;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import B1_06.B106_Lofify_TESTING.Servidor.Dominio.Usuario;

public class Gestor_Remoto_Test {

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testSigninUserManual_IncorrectBankAccount() {
		Usuario expected = B1_06.B106_Lofify_TESTING.Cliente.Dominio.Gestor_Remoto.nuevoUsuarioManual("", "",
				"Cristina", "Bolanos Perez", -300, "");
		assertNull(expected);
	}

	@Test
	public void testSigninUserManual_NullAtributtes() {
		Usuario expected = B1_06.B106_Lofify_TESTING.Cliente.Dominio.Gestor_Remoto.nuevoUsuarioManual("Erizo12", null,
				null, null, 1, "CrisDelegada@gmail.com");
		assertNull(expected);
	}

	@Test
	public void testSigninUserManual_IncorrectBankAccount2() {
		Usuario expected = B1_06.B106_Lofify_TESTING.Cliente.Dominio.Gestor_Remoto.nuevoUsuarioManual("Nuevo usuario",
				"Contraseña nueva", "Nombre", "Apellidos", (long) 1000000, null);
		assertNull(expected);
	}

	@Test
	public void loginUser_WrongLogin() {
		Usuario actual = B1_06.B106_Lofify_TESTING.Cliente.Dominio.Gestor_Remoto.loginUsuario("Erizo12",
				"New password");
		assertNull(actual);
	}

	@Test
	public void loginUser_WrongLogin2() {
		Usuario actual = B1_06.B106_Lofify_TESTING.Cliente.Dominio.Gestor_Remoto.loginUsuario("Pepe", "Pess");
		assertNull(actual);
	}

	@Test
	public void loginUser_NullAtributtes() {
		Usuario actual = B1_06.B106_Lofify_TESTING.Cliente.Dominio.Gestor_Remoto.loginUsuario(null, null);
		assertNull(actual);
	}

	@Test
	public void testRemoveUser_Exist() {
		Usuario expected = new Usuario("Piss", "CristiBolsas", "Cristina", "Bolanos Perez", (long) 123456788,
				"Cristibope@gmail.com");
		B1_06.B106_Lofify_TESTING.Servidor.Dominio.Gestor_Remoto.eliminarUsuario(expected);
		Usuario actual = B1_06.B106_Lofify_TESTING.Cliente.Dominio.Gestor_Remoto.loginUsuario(expected.getUser(),
				expected.getPass());
		assertNotNull(expected);
		assertNull(actual);
	}

	@Test
	public void testRemoveUser_NoExist() {
		Usuario expected = new Usuario("NoExist", "NoExist", "NoExist", "NoExist", (long) 123456788, "NoExist");
		B1_06.B106_Lofify_TESTING.Servidor.Dominio.Gestor_Remoto.eliminarUsuario(expected);
		Usuario actual = B1_06.B106_Lofify_TESTING.Cliente.Dominio.Gestor_Remoto.loginUsuario(expected.getUser(),
				expected.getPass());
		assertNotNull(expected);
		assertNull(actual);
	}

	@Test
	public void testRemoveUser_NullAtributes() {
		Usuario expected = new Usuario(null, null, null, null, (long) -8, null);
		B1_06.B106_Lofify_TESTING.Servidor.Dominio.Gestor_Remoto.eliminarUsuario(expected);
		Usuario actual = B1_06.B106_Lofify_TESTING.Cliente.Dominio.Gestor_Remoto.loginUsuario(expected.getUser(),
				expected.getPass());
		assertNotNull(expected);
		assertNull(actual);
	}
}