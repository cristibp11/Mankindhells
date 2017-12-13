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
			Cancion expecteds = Gestor_Dominio.añadirCancion("Potion Approaching", 
					"msdkjhsd7", 0.99, "Arctic Monkeys", "Humbug");
			Cancion actuals = Gestor_Dominio.buscarCancion(expecteds.getTitulo()).get(0);
			assertArrayEquals(expecteds, actuals);
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

	private void assertArrayEquals(Cancion expecteds, Cancion actuals) {
		boolean titulo = expecteds.getTitulo().equals(actuals.getTitulo());
		boolean metadatos = expecteds.getMeta().equals(actuals.getMeta());
		boolean precio = expecteds.getPrecio()==actuals.getPrecio();
		boolean autor = expecteds.getAutor().equals(actuals.getAutor());
		boolean album = expecteds.getAlbum().equals(actuals.getAlbum());
		
		if(!(titulo&&metadatos&&precio&&autor&&album))
			throw new java.lang.AssertionError();
	}

	@Test
	public void testAddAlbum() {
		Album expecteds;
		try {
			expecteds = Gestor_Dominio.añadirAlbum("Humbug", 0.99*10, "Arctic Monkeys");
			Album actuals = Gestor_Dominio.buscarAlbum("Humbug").get(0);
			assertArrayEquals(expecteds, actuals);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void assertArrayEquals(Album expecteds, Album actuals) {
		boolean nombre = expecteds.getNombre().equals(actuals.getNombre());
		boolean precio = expecteds.getPrecio()==actuals.getPrecio();
		boolean autor = expecteds.getAutor().equals(actuals.getAutor());
		
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
