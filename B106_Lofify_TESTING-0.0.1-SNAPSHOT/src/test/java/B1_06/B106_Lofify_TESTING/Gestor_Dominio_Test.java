package B1_06.B106_Lofify_TESTING;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import B1_06.B106_Lofify_TESTING.Servidor.Dominio.Album;
import B1_06.B106_Lofify_TESTING.Servidor.Dominio.Artista;
import B1_06.B106_Lofify_TESTING.Servidor.Dominio.Cancion;
import B1_06.B106_Lofify_TESTING.Servidor.Dominio.Gestor_Dominio;

public class Gestor_Dominio_Test {

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testAddArtist_StringIsStringIs() {
		Artista expected;
		Artista actual;
		if((expected = Gestor_Dominio.añadirArtista("Kinder Malo", "Artista de trap rollo sadboy")) == null){
			actual = null;
			assertNull(expected);
			assertNull(actual);
		}else{ 
			actual = Gestor_Dominio.buscarArtista(expected.getNombre());
			assertEquals(expected.getNombre(), actual.getNombre());
		}
	}

	@Test
	public void testAddArtist_NullString() {
		Artista expected;
		Artista actual;
		if((expected = Gestor_Dominio.añadirArtista(null, "Descripcion")) == null){
			actual = null;
			assertNull(expected);
			assertNull(actual);
		}else{ 
			actual = Gestor_Dominio.buscarArtista(expected.getNombre());
			assertEquals(expected.getNombre(), actual.getNombre());
		}
		
	}

	@Test
	public void testAddArtist_StringIsntStringIsnt() {
		Artista expected;
		Artista actual;
		if((expected = Gestor_Dominio.añadirArtista("Pablo López","Descripcion")) == null){
			actual = null;
			assertNull(expected);
			assertNull(actual);
		}else{ 
			actual = Gestor_Dominio.buscarArtista(expected.getNombre());
			assertEquals(expected.getNombre(), actual.getNombre());
		}
	}

	@Test
	public void testAddArtist_NullNull() {
		Artista expected;
		Artista actual;
		if((expected = Gestor_Dominio.añadirArtista(null,null)) == null){
			actual = null;
			assertNull(expected);
			assertNull(actual);
		}else{ 
			actual = Gestor_Dominio.buscarArtista(expected.getNombre());
			assertEquals(expected.getNombre(), actual.getNombre());
		}
	}
	
	@Test
	public void testAddAlbumStringIsDoubleStringIsnt() {
		Album expected;
		Album actual;
		if((expected = Gestor_Dominio.añadirAlbum("Hit And Run", 2.0 * 10, "Pablo López")) == null){
			actual = null;
			assertNull(expected);
			assertNull(actual);
		}else{ 
			actual = Gestor_Dominio.buscarAlbum(expected.getNombre());
			assertEquals(expected.getNombre(), actual.getNombre());
		}
	}
		
	@Test
	public void testAddAlbumNullDoubleNull() {	
		Album expected;
		Album actual;
		if((expected = Gestor_Dominio.añadirAlbum(null, 260.0 * 10, null)) == null){
			actual = null;
			assertNull(expected);
			assertNull(actual);
		}else{ 
			actual = Gestor_Dominio.buscarAlbum(expected.getNombre());
			assertEquals(expected.getNombre(), actual.getNombre());
		}
	}

	@Test
	public void testAddAlbumStringDoubleNull() {
		Album expected;
		Album actual;
		if((expected = Gestor_Dominio.añadirAlbum("Prometo", 0.1 * 10, null)) == null){
			actual = null;
			assertNull(expected);
			assertNull(actual);
		}else{ 
			actual = Gestor_Dominio.buscarAlbum(expected.getNombre());
			assertEquals(expected.getNombre(), actual.getNombre());
		}
		
	}


 /*
	@Test
	public void testAddSongStringIsStringIsDoubleStringIsNull() {
		Cancion actuals = null;
		Gestor_Dominio.añadirArtista("Kinder Malo", "Artista de trap rollo sadboy");
		Gestor_Dominio.añadirAlbum(null, 1.0 * 10, "Kinder Malo");
		Cancion expected = Gestor_Dominio.añadirCancion("El Banquero De Dios", "metapod", 1.0, "Kinder Malo", null);
		actuals = Gestor_Dominio.buscarCancion("El Banquero De Dios");
		assertArrayEquals(expected, actuals);

	}

	@Test
	public void testAddSongNullNullDoubleNullStringIsnt() {
		Cancion actuals = null;
		Gestor_Dominio.añadirArtista(null, "Descripcion");
		Gestor_Dominio.añadirAlbum("Thriller", 1.0 * 10, null);
		Cancion expected = Gestor_Dominio.añadirCancion(null, null, 1.0, null, "Thriller");
		actuals = Gestor_Dominio.buscarCancion("Thriller");
		assertArrayEquals(expected, actuals);
	}

	@Test
	public void testAddSongNullNullDoubleNullNull() throws Exception {
		Cancion actuals = null;
		Cancion expected = null;
		try {
			if (Gestor_Dominio.añadirArtista(null, "Descripcion") == null)
				throw new Exception();
			if (Gestor_Dominio.añadirAlbum(null, 1500.0 * 10, null) == null)
				throw new Exception();
			if ((expected = Gestor_Dominio.añadirCancion(null, null, 1500, null, null)) == null)
				throw new Exception();
			actuals = Gestor_Dominio.buscarCancion(null);
			assertArrayEquals(expected, actuals);
		} catch (Exception e) {
		}
	}

	private void assertArrayEquals(Cancion expected, Cancion actual) {
		try {
			boolean titulo = expected.getTitulo().equals(actual.getTitulo());
			boolean metadatos = expected.getMeta().equals(actual.getMeta());
			boolean precio = expected.getPrecio() == actual.getPrecio();
			boolean autor = expected.getAutor().getID().equals(actual.getAutor().getID());
			boolean album = expected.getAlbum().getID().equals(actual.getAlbum().getID());

			if (!(titulo && metadatos && precio && autor && album))
				throw new java.lang.AssertionError();
		} catch (java.lang.NullPointerException npe) {

		}
	}

	@Test
	public void testModifySong() {
		try {
			Gestor_Dominio.añadirArtista("Arctic Monkeys", "Descripcion");
			Gestor_Dominio.añadirAlbum("Humbug", 0.99 * 10, "Arctic Monkeys");
			Gestor_Dominio.añadirCancion("Potion Approaching", "msdkjhsd7", 0.99, "Arctic Monkeys", "Humbug");
			Cancion expected = Gestor_Dominio.buscarCancion("Potion Approaching");
			expected.setMetadatos("ncsacls8923");
			expected.setPrecio(0.56);
			Gestor_Dominio.modificarCancion(expected);
			Cancion actual = Gestor_Dominio.buscarCancion("Potion Approaching");
			assertArrayEquals(expected, actual);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testRemoveSong() {
		try {
			Gestor_Dominio.añadirArtista("Arctic Monkeys", "Descripcion");
			Gestor_Dominio.añadirAlbum("Humbug", 0.99 * 10, "Arctic Monkeys");
			Gestor_Dominio.añadirCancion("Potion Approaching", "msdkjhsd7", 0.99, "Arctic Monkeys", "Humbug");
			Cancion expected = Gestor_Dominio.buscarCancion("Potion Approaching");
			Gestor_Dominio.eliminarCancion(expected);
			Cancion actual = Gestor_Dominio.buscarCancion("Potion Approaching");
			assertArrayEquals(expected, actual);
			fail("Expected error");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (java.lang.AssertionError ase) {

		} catch (Exception e) {

		}
	}

	@Test
	public void testRemoveAlbum() {
		try {
			Gestor_Dominio.añadirArtista("Arctic Monkeys", "Descripcion");
			Gestor_Dominio.añadirAlbum("Humbug", 0.99 * 10, "Arctic Monkeys");
			Album expected = Gestor_Dominio.buscarAlbum("Humbug");
			Gestor_Dominio.eliminarAlbum(expected);
			Album actual = Gestor_Dominio.buscarAlbum("Humbug");
			assertArrayEquals(expected, actual);
			fail("Expected error");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (java.lang.AssertionError ase) {

		} catch (Exception e) {

		}
	}

	@Test
	public void testRemoveArtist() {
		try {
			Artista expected = Gestor_Dominio.añadirArtista("Arctic Monkeys", "Descripcion");
			Gestor_Dominio.eliminarArtista(expected);
			Artista actual = Gestor_Dominio.buscarArtista("Arctic Monkeys");
			assertArrayEquals(expected, actual);
			fail("Expected error");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (java.lang.AssertionError ase) {

		} catch (Exception e) {

		}
	}
	*/

}
