package B1_06.B106_Lofify_TESTING;

import static org.junit.Assert.*;
import org.junit.Before;
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
	public void testAddArtist_IsStringString() {
		Artista expected = Gestor_Dominio.añadirArtista("Kinder Malo", "Artista de trap rollo sadboy");
		Artista actual = Gestor_Dominio.buscarArtista(expected.getNombre());
		assertEquals(expected.getNombre(), actual.getNombre());
	}

	@Test
	public void testAddArtist_NullString() {
		Artista expected = Gestor_Dominio.añadirArtista(null, "Descripcion");
		Artista actual = Gestor_Dominio.buscarArtista((String) null);
		assertNull(expected);
		assertNull(actual);

	}

	@Test
	public void testAddArtist_IsntStringString() {
		Artista expected = Gestor_Dominio.añadirArtista("Pablo López", "Descripcion");
		Artista actual = Gestor_Dominio.buscarArtista(expected.getNombre());
		assertEquals(expected.getNombre(), actual.getNombre());
	}

	@Test
	public void testAddArtist_NullNull() {
		Artista expected = Gestor_Dominio.añadirArtista(null, null);
		Artista actual = Gestor_Dominio.buscarArtista((String) null);
		assertNull(expected);
		assertNull(actual);
	}

	@Test
	public void testAddAlbumStringIsDoubleStringIsnt() {
		Album expected = Gestor_Dominio.añadirAlbum("Hit And Run", 2.0 * 10, "Pablo López");
		Album actual = Gestor_Dominio.buscarAlbum(expected.getNombre());
		assertEquals(expected.getNombre(), actual.getNombre());
	}

	@Test
	public void testAddAlbumNullDoubleNull() {
		Album expected = Gestor_Dominio.añadirAlbum(null, 260.0 * 10, null);
		Album actual = Gestor_Dominio.buscarAlbum((String) null);
		assertNull(expected);
		assertNull(actual);
	}

	@Test
	public void testAddAlbumStringIsntDoubleNull() {
		Album expected = Gestor_Dominio.añadirAlbum("Prometo", 0.1 * 10, null);
		Album actual = Gestor_Dominio.buscarAlbum((String) null);
		assertEquals(expected,actual);
	}

	@Test
	public void testAddSongStringIsStringIsDoubleStringIsNull() {
		Cancion expected = Gestor_Dominio.añadirCancion("El Banquero De Dios", "metapod", 1.0, "Kinder Malo", null);
		Cancion actual = Gestor_Dominio.buscarCancion((String) null);
		;
		assertNull(expected);
		assertNull(actual);
	}

	@Test
	public void testAddSongNullNullDoubleNullStringIsnt() {
		Cancion expected = Gestor_Dominio.añadirCancion(null, null, 1.0, null, "Thriller");
		Cancion actual = Gestor_Dominio.buscarCancion((String) null);
		;
		assertNull(expected);
		assertNull(actual);
	}

	@Test
	public void testAddSongNullNullDoubleNullNull() {
		Cancion expected = Gestor_Dominio.añadirCancion(null, null, 1500, null, null);
		Cancion actual = Gestor_Dominio.buscarCancion((String) null);
		;
		assertNull(expected);
		assertNull(actual);
	}

	@Test
	public void BuscarCancionStringIs() {
		String expected = "La Taberna Del Buda";
		Cancion actual = (Gestor_Dominio.buscarCancion(expected));
		assertEquals(expected, actual.getTitulo());
	}

	@Test
	public void BuscarCancionStringIsnt() {
		String expected = "Llueve";
		Cancion actual = (Gestor_Dominio.buscarCancion(expected));
		assertNotSame(expected, actual);
	}

	@Test
	public void BuscarCancionNull() {
		String expected = null;
		Cancion actual = (Gestor_Dominio.buscarCancion(expected));
		assertEquals(expected, actual);
	}
	
	@Test
	public void BuscarAlbumStringIs() {
		String expected = "Sad Boy";
		Album actual = (Gestor_Dominio.buscarAlbum(expected));
		assertEquals(expected, actual.getNombre());
	}

	@Test
	public void BuscarAlbumStringIsnt() {
		String expected = "Thriller";
		Album actual = (Gestor_Dominio.buscarAlbum(expected));
		assertNotSame(expected, actual);
	}

	@Test
	public void BuscarAlbumNull() {
		String expected = null;
		Album actual = (Gestor_Dominio.buscarAlbum(expected));
		assertEquals(expected, actual);
	}

	@Test
	public void BuscarArtistaStringIs() {
		String expected = "Kinder Malo";
		Artista actual = (Gestor_Dominio.buscarArtista(expected));
		assertEquals(expected, actual.getNombre());
	}

	@Test
	public void BuscarArtistaStringIsnt() {
		String expected = "Pablo López";
		Artista actual = (Gestor_Dominio.buscarArtista(expected));
		assertNotSame(expected, actual);
	}

	@Test
	public void BuscarArtistaNull() {
		String expected = null;
		Artista actual = (Gestor_Dominio.buscarArtista(expected));
		assertEquals(expected, actual);
	}

	@Test
	public void testModifySongSongIs() {
		Artista a = new Artista("Kinder Malo", "Artista de trap rollo sadboy");
		Album b = new Album(a, "Sad Boy", 10.0);
		Cancion actual = new Cancion(a, "El Banquero De Dios", "Modificacion", b, 0.99);
		Cancion expected = new Cancion(a, "El Banquero De Dios", "Modificacion", b, 0.99);
		Gestor_Dominio.modificarCancion(actual);
		actual = Gestor_Dominio.buscarCancion(actual.getTitulo());
		assertEquals(expected.getMeta(), actual.getMeta());
	}

	@Test
	public void testModifySongSongIsnt() {
		Artista a = new Artista("Kinder Malo", "Artista de trap rollo sadboy");
		Album b = new Album(a, "Sad Boy", 10.0);
		Cancion actual = new Cancion(a, "Perfect", "Modificacion", b, 0.99);
		Cancion expected = new Cancion(a, "Perfect", "Modificacion", b, 0.99);
		Gestor_Dominio.modificarCancion(actual);
		actual = Gestor_Dominio.buscarCancion(actual.getTitulo());
		assertNotEquals(expected.getMeta(), actual);
	}

	@Test
	public void testModifySongNull() {
		Cancion actual = null;
		Cancion expected = null;
		Gestor_Dominio.modificarCancion(actual);
		actual = Gestor_Dominio.buscarCancion((String) null);
		assertNull(actual);
		assertNull(expected);
	}

	@Test
	public void testRemoveSongIs() {
		Artista a = new Artista("Kinder Malo", "Artista de trap rollo sadboy");
		Album b = new Album(a, "Sad Boy", 10.0);
		Cancion actual = new Cancion(a, "El Banquero De Dios", "Metapod", b, 0.99);
		Gestor_Dominio.eliminarCancion(actual);
		assertNull(Gestor_Dominio.buscarCancion(actual.getTitulo()));
	}

	@Test
	public void testRemoveSongIsnt() {
		Artista a = new Artista("Cafe Quijano", "Merengueo a tope");
		Album b = new Album(a, "La Taberna Del Buda", 8.0);
		Cancion actual = new Cancion(a, "Saturno", "Blastoise", b, 0.99);
		Gestor_Dominio.eliminarCancion(actual);
		assertNull(Gestor_Dominio.buscarCancion(actual.getTitulo()));
	}

	@Test
	public void testRemoveSongNull() {
		Artista a = new Artista("Cafe Quijano", "Merengueo a tope");
		Album b = new Album(a, "La Taberna Del Buda", 8.0);
		Cancion actual = new Cancion(a, null, null, b, 0.0);
		Gestor_Dominio.eliminarCancion(actual);
		assertNull(Gestor_Dominio.buscarCancion(actual.getTitulo()));
	}

	@Test
	public void testRemoveAlbumIs() {
		Artista a = new Artista("Kinder Malo", "Artista de trap rollo sadboy");
		Album actual = new Album(a, "Prometo", 10.0);
		Gestor_Dominio.eliminarAlbum(actual);
		assertNull(Gestor_Dominio.buscarAlbum(actual.getNombre()));
	}

	@Test
	public void testRemoveAlbumIsnt() {
		Artista a = new Artista("Kinder Malo", "Artista de trap rollo sadboy");
		Album actual = new Album(a, "Prometo", 10.0);
		Gestor_Dominio.eliminarAlbum(actual);
		assertNull(Gestor_Dominio.buscarAlbum(actual.getNombre()));
	}

	@Test
	public void testRemoveAlbumNull() {
		Artista a = new Artista("Kinder Malo", "Artista de trap rollo sadboy");
		Album actual = new Album(a, null, 0.0);
		Gestor_Dominio.eliminarAlbum(actual);
		assertNull(Gestor_Dominio.buscarAlbum(actual.getNombre()));
	}

	@Test
	public void testRemoveArtistIs() {
		Artista actual = new Artista("Cafe Quijano", "Merengueo a tope");
		Gestor_Dominio.eliminarArtista(actual);
		assertNull(Gestor_Dominio.buscarArtista(actual.getNombre()));
	}

	@Test
	public void testRemoveArtistIsnt() {
		Artista actual = new Artista("Pablo Alborán", "Merengueo a tope");
		Gestor_Dominio.eliminarArtista(actual);
		assertNull(Gestor_Dominio.buscarArtista(actual.getNombre()));
	}
	
	@Test
	public void testRemoveArtistNull() {
		Artista actual = new Artista(null, null);
		Gestor_Dominio.eliminarArtista(actual);
		assertNull(Gestor_Dominio.buscarArtista(actual.getNombre()));

	}
}