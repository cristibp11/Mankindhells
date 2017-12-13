package B1_06.B106_Lofify_TESTING;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import B1_06.B106_Lofify_TESTING.Servidor.Dominio.Album;
import B1_06.B106_Lofify_TESTING.Servidor.Dominio.Artista;
import B1_06.B106_Lofify_TESTING.Servidor.Dominio.Cancion;
import B1_06.B106_Lofify_TESTING.Servidor.Dominio.Gestor_Dominio;

public class AppTest {

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testAddSong() {
		try {
			Cancion expected = Gestor_Dominio.añadirCancion("Potion Approaching", 
					"msdkjhsd7", 0.99, "Arctic Monkeys", "Humbug");
			Cancion actuals = Gestor_Dominio.buscarCancion(expected.getTitulo()).get(0);
			assertArrayEquals(expected, actuals);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void assertArrayEquals(Cancion expected, Cancion actual) {
		boolean titulo = expected.getTitulo().equals(actual.getTitulo());
		boolean metadatos = expected.getMeta().equals(actual.getMeta());
		boolean precio = expected.getPrecio()==actual.getPrecio();
		boolean autor = expected.getAutor().equals(actual.getAutor());
		boolean album = expected.getAlbum().equals(actual.getAlbum());
		
		if(!(titulo&&metadatos&&precio&&autor&&album))
			throw new java.lang.AssertionError();
	}

	@Test
	public void testAddAlbum() {
		Album expected;
		try {
			expected = Gestor_Dominio.añadirAlbum("Humbug", 0.99*10, "Arctic Monkeys");
			Album actual = Gestor_Dominio.buscarAlbum("Humbug").get(0);
			assertArrayEquals(expected, actual);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void assertArrayEquals(Album expected, Album actual) {
		boolean nombre = expected.getNombre().equals(actual.getNombre());
		boolean precio = expected.getPrecio()==actual.getPrecio();
		boolean autor = expected.getAutor().equals(actual.getAutor());
		
		if(!(nombre&&precio&&autor))
			throw new java.lang.AssertionError();
	}

	@Test
	public void testAddArtist() {
		Artista expecteds;
		try {
			expecteds = Gestor_Dominio.añadirArtista("Arctic Monkeys", "");
			Artista actuals = Gestor_Dominio.buscarArtista("Arctic Monkeys").get(0);
			assertArrayEquals(expecteds, actuals);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void assertArrayEquals(Artista expecteds, Artista actuals) {
		boolean nombre = expecteds.getNombre().equals(actuals.getNombre());
		boolean descripcion = expecteds.getDescripcion().equals(actuals.getDescripcion());
		
		if(!(nombre&&descripcion))
			throw new java.lang.AssertionError();
	}

	@Test
	public void testRemoveSong() {
		try {
			Cancion expected = Gestor_Dominio.buscarCancion("Potion Approaching").get(0);
			Gestor_Dominio.eliminarCancion(expected);
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
	public void testRemoveAlbum() {

	}

	@Test
	public void testRemoveArtist() {

	}

	@Test
	public void testModifySong() {

	}
}
