package B1_06.B106_Lofify_TESTING.Servidor.Dominio;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import B1_06.B106_Lofify_TESTING.Servidor.Persistencia.Agente;

public class Gestor_Dominio {

	public static Cancion añadirCancion(String titulo, String metadatos, double precio, String nombre_artista,
			String nombre_album) {
		Cancion c = null;
		if (nombre_artista != null && titulo != null && nombre_album != null) {
			Artista ar = buscarArtista(nombre_artista);
			Album al = buscarAlbum(nombre_album);
			c = new Cancion(ar, titulo, metadatos, al, precio);
			Agente a = new Agente();
			String[] search = { c.getID(), titulo, al.getID(), ar.getID(), String.valueOf(precio), metadatos };
			a.modificar(search, (short) 1, (short) 2);
		}
		return c;
	}

	public static Album añadirAlbum(String nombre, Double precio, String nombre_artista) {
		Album al = null;
			if (nombre != null && nombre_artista != null) {
				Artista ar = buscarArtista(nombre_artista);
				al = new Album(ar, nombre, precio);
				Agente a = new Agente();
				String[] search = { al.getID(), nombre, ar.getID(), String.valueOf(precio) };
				a.modificar(search, (short) 2, (short) 2);
			}
		return al;
	}

	public static Artista añadirArtista(String nombre, String descripcion) {
		Artista ar = null;
		if (nombre != null) {
			ar = new Artista(nombre, descripcion);
			Agente a = new Agente();
			String[] search = { ar.getID(), nombre, descripcion };
			a.modificar(search, (short) 3, (short) 2);
		}
		return ar;
	}

	public static Cancion buscarCancion(String titulo) {
		Agente a = new Agente();
		Cancion c = null;
		if (titulo != null) {
				String[] result = a.leer(titulo, (short) 1);
				if(result != null){
				Artista ar = new Artista(result[3]);
				Album al = new Album(result[2]);
				c = new Cancion(ar, titulo, result[5], al, Double.parseDouble(result[4]));
				}
		}
		return c;
	}

	public static Album buscarAlbum(String nombre) {
		Agente a = new Agente();
		Album al = null;
			String[] result = a.leer(nombre, (short) 2);
			if(result != null){
			Artista ar = new Artista(result[2]);
			al = new Album(ar, nombre, Double.parseDouble(result[3]));
			}
		return al;
	}

	public static Artista buscarArtista(String nombre) {
		Artista ar = null;
		if (nombre != null) {
			Agente a = new Agente();
			String[] result = a.leer(nombre, (short) 3);
			if(result != null){
			ar = new Artista(nombre, result[2]);
			}
		}
		return ar;
	}

	public static void modificarCancion(Cancion c){
		Agente a = new Agente();
		if(c != null){
		String[] search = { c.getID(), c.getTitulo(), c.getAlbum().getID(), c.getAutor().getID(),
				String.valueOf(c.getPrecio()), c.getMeta() };
		a.modificar(search, (short) 1, (short) 1);
		}
	}

	public static void eliminarCancion(Cancion c){
		if(c != null){
		Agente a = new Agente();
		String[] search = { c.getID(), c.getTitulo(), c.getAlbum().getID(), c.getAutor().getID(),
				String.valueOf(c.getPrecio()), c.getMeta() };
		a.modificar(search, (short) 1, (short) 0);
		}
		
	}

	public static void eliminarAlbum(Album c){
		if(c != null){
		Agente a = new Agente();
		String[] search = { c.getID(), c.getNombre(), c.getAutor().getID(), String.valueOf(c.getPrecio()) };
		a.modificar(search, (short) 2, (short) 0);
		}
	}

	public static void eliminarArtista(Artista c) {
		if(c != null && c.getNombre() != null && c.getID() != null && c.getNombre() != null){
		Agente a = new Agente();
		String[] search = { c.getID(), c.getNombre(), c.getDescripcion() };
		a.modificar(search, (short) 3, (short) 0);
		}
	}

	public static String getMD5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes(Charset.forName(System.getProperty("file.encoding"))));
			BigInteger number = new BigInteger(messageDigest);
			return number.toString(16);
		} catch (NoSuchAlgorithmException nsae) {
			throw new RuntimeException(nsae);
		}
	}
	

}