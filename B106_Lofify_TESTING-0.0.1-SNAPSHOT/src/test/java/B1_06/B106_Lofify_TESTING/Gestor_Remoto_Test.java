package B1_06.B106_Lofify_TESTING;

import static org.junit.Assert.fail;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import B1_06.B106_Lofify_TESTING.Servidor.Dominio.Usuario;

public class Gestor_Remoto_Test {

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testSigninUserGeneral() {
		Usuario expected = B1_06.B106_Lofify_TESTING.Cliente.Dominio.Gestor_Remoto.nuevoUsuarioGeneral();
		Usuario actual = B1_06.B106_Lofify_TESTING.Cliente.Dominio.Gestor_Remoto.loginUsuario(expected.getUser(),
				expected.getPass());
		assertArrayEquals(expected, actual);
	}

	private void assertArrayEquals(Usuario expected, Usuario actual) {
		boolean user = expected.getUser().equals(actual.getUser());
		boolean pass = expected.getPass().equals(actual.getPass());
		boolean nombre = expected.getNombre().equals(actual.getNombre());
		boolean apellidos = expected.getApellidos().equals(actual.getApellidos());
		boolean cuenta = expected.getnCuenta() == actual.getnCuenta();
		boolean email = expected.getEmail().equals(actual.getEmail());

		if (!(user && pass && nombre && apellidos && cuenta && email))
			throw new java.lang.AssertionError();

	}

	@Test
	public void testSigninUserManual() {
		Usuario expected = B1_06.B106_Lofify_TESTING.Cliente.Dominio.Gestor_Remoto.nuevoUsuarioManual("manualUser",
				"manualPass", "manualName", "firstName", (long) 236745632, "manual@manual.com");
		Usuario actual = B1_06.B106_Lofify_TESTING.Cliente.Dominio.Gestor_Remoto.loginUsuario(expected.getUser(),
				expected.getPass());
		assertArrayEquals(expected, actual);
	}

	@Test
	public void testRemoveUser() {
		try {
			Usuario expected = B1_06.B106_Lofify_TESTING.Cliente.Dominio.Gestor_Remoto.nuevoUsuarioGeneral();
			B1_06.B106_Lofify_TESTING.Servidor.Dominio.Gestor_Remoto.eliminarUsuario(expected);
			Usuario actual = B1_06.B106_Lofify_TESTING.Cliente.Dominio.Gestor_Remoto.loginUsuario(expected.getUser(),
					expected.getPass());
			assertArrayEquals(expected, actual);
			fail("Expected error");
		} catch (java.lang.AssertionError ase) {

		} catch (NoSuchElementException nse) {

		}
	}
}
