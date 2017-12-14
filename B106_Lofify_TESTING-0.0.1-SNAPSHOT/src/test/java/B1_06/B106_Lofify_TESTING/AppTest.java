package B1_06.B106_Lofify_TESTING;

import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import B1_06.B106_Lofify_TESTING.Servidor.Dominio.Album;
import B1_06.B106_Lofify_TESTING.Servidor.Dominio.Artista;
import B1_06.B106_Lofify_TESTING.Servidor.Dominio.Cancion;
import B1_06.B106_Lofify_TESTING.Servidor.Dominio.Gestor_Dominio;
import B1_06.B106_Lofify_TESTING.Servidor.Dominio.Usuario;

public class AppTest {

	@Before
	public void setUp() throws Exception {

	}


	@Test
	public void testAddArtist() {
		Artista expecteds;
		expecteds = Gestor_Dominio.añadirArtista("Arctic Monkeys", "");
		Artista actuals = Gestor_Dominio.buscarArtista("Arctic Monkeys");
		assertArrayEquals(expecteds, actuals);
	}

	private void assertArrayEquals(Artista expecteds, Artista actuals) {
		boolean nombre = expecteds.getNombre().equals(actuals.getNombre());
		boolean descripcion = expecteds.getDescripcion().equals(actuals.getDescripcion());

		if (!(nombre && descripcion))
			throw new java.lang.AssertionError();
	}
	

	@Test
	public void testAddAlbum() {
		Album expected;
		expected = Gestor_Dominio.añadirAlbum("Humbug", 0.99 * 10, "Arctic Monkeys");
		Album actual = Gestor_Dominio.buscarAlbum("Humbug").get(0);
		assertArrayEquals(expected, actual);
	}

	private void assertArrayEquals(Album expected, Album actual) {
		boolean nombre = expected.getNombre().equals(actual.getNombre());
		boolean precio = expected.getPrecio() == actual.getPrecio();
		boolean autor = expected.getAutor().equals(actual.getAutor());

		if (!(nombre && precio && autor))
			throw new java.lang.AssertionError();
	}
	
	@Test
	public void testAddSong() {
		try {
			Cancion expected = Gestor_Dominio.añadirCancion("Potion Approaching", "msdkjhsd7", 0.99, "Arctic Monkeys",
					"Humbug");
			Cancion actuals = Gestor_Dominio.buscarCancion(expected.getTitulo()).get(0);
			assertArrayEquals(expected, actuals);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void assertArrayEquals(Cancion expected, Cancion actual) {
		boolean titulo = expected.getTitulo().equals(actual.getTitulo());
		boolean metadatos = expected.getMeta().equals(actual.getMeta());
		boolean precio = expected.getPrecio() == actual.getPrecio();
		boolean autor = expected.getAutor().equals(actual.getAutor());
		boolean album = expected.getAlbum().equals(actual.getAlbum());

		if (!(titulo && metadatos && precio && autor && album))
			throw new java.lang.AssertionError();
	}

	@Test
	public void testModifySong() {
		try {
			Cancion expected = Gestor_Dominio.buscarCancion("Potion Approaching").get(0);
			expected.setMetadatos("ncsacls8923");
			expected.setPrecio(0.56);
			Gestor_Dominio.modificarCancion(expected);
			Cancion actual = Gestor_Dominio.buscarCancion("Potion Approaching").get(0);
			assertArrayEquals(expected, actual);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testRemoveSong() {
		try {
			Cancion expected = Gestor_Dominio.buscarCancion("Potion Approaching").get(0);
			Gestor_Dominio.eliminarCancion(expected);
			Cancion actual = Gestor_Dominio.buscarCancion("Potion Approaching").get(0);
			assertArrayEquals(expected, actual);
			fail("Expected error");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (java.lang.AssertionError ase) {

		}
	}

	@Test
	public void testRemoveAlbum() {
		try {
			Album expected = Gestor_Dominio.buscarAlbum("Humbug").get(0);
			Gestor_Dominio.eliminarAlbum(expected);
			Album actual = Gestor_Dominio.buscarAlbum("Humbug").get(0);
			assertArrayEquals(expected, actual);
			fail("Expected error");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (java.lang.AssertionError ase) {

		}
	}

	@Test
	public void testRemoveArtist() {
		try {
			Artista expected = Gestor_Dominio.buscarArtista("Arctic Monkeys");
			Gestor_Dominio.eliminarArtista(expected);
			Artista actual = Gestor_Dominio.buscarArtista("Arctic Monkeys");
			assertArrayEquals(expected, actual);
			fail("Expected error");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (java.lang.AssertionError ase) {

		}
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
		Usuario expected = B1_06.B106_Lofify_TESTING.Cliente.Dominio.Gestor_Remoto.loginUsuario("user", "user");
		B1_06.B106_Lofify_TESTING.Servidor.Dominio.Gestor_Remoto.eliminarUsuario(expected);
		Usuario actual = B1_06.B106_Lofify_TESTING.Cliente.Dominio.Gestor_Remoto.loginUsuario(expected.getUser(),
				expected.getPass());
		try {
			assertArrayEquals(expected, actual);
			fail("Expected error");
		} catch (java.lang.AssertionError ase) {

		}
	}

}
