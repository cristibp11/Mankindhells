package B1_06.B106_Lofify_TESTING.Servidor.Dominio;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.LinkedList;

import B1_06.B106_Lofify_TESTING.Servidor.Persistencia.Agente;

public class Gestor_Dominio {

	public static Cancion añadirCancion(String titulo, String metadatos, double precio, String nombre_artista,
			String nombre_album){
		Cancion c = null;
		Artista ar = buscarArtista(nombre_artista).get(0);
		Album al = buscarAlbum(nombre_album).get(0);
		c = new Cancion(ar, titulo, metadatos, al, precio);
		Agente a = new Agente();
		String[] search = {c.getID(),titulo,al.getID(),ar.getID(),String.valueOf(precio),metadatos};
		a.modificar(search, (short) 1, (short) 1);
		return c;
	}

	public static Album añadirAlbum(String nombre, Double precio, String nombre_artista){
		Album al = null;
		Artista ar = buscarArtista(nombre_artista).get(0);
		al = new Album(ar, nombre, precio);
		Agente a = new Agente();
		String[] search = {al.getID(),nombre,ar.getID(),String.valueOf(precio)};
		a.modificar(search, (short) 2, (short) 1);
		return al;
	}

	public static Artista añadirArtista(String nombre, String descripcion){
		Artista ar = new Artista(nombre, descripcion);
		Agente a = new Agente();
		String[] search = {ar.getID(),nombre,descripcion};
		a.modificar(search, (short) 3, (short) 1);
		return ar;
	}

	public static LinkedList<Cancion> buscarCancion(String titulo){
		Agente a = new Agente();
		LinkedList<Cancion> list = new LinkedList<Cancion>();
		String[] result = a.leer(titulo, (short) 1);
		try{
			Artista ar = buscarArtista(result[2]).get(0);
			Album al = buscarAlbum(result[1]).get(0);
			list.add(new Cancion(ar, titulo, result[4], al, Double.parseDouble(result[3])));
		}catch (NullPointerException npe){
			
		}
		return list;
	}

	public static LinkedList<Album> buscarAlbum(String nombre){
		Agente a = new Agente();
		LinkedList<Album> list = new LinkedList<Album>();
		String[] result = a.leer(nombre, (short) 2);
		try{
			Artista ar = buscarArtista(result[2]).get(0);
			list.add(new Album(ar, nombre, Double.parseDouble(result[3])));
		}catch (NullPointerException npe){
			
		}
		return list;
	}

	public static LinkedList<Artista> buscarArtista(String nombre){
		Agente a = new Agente();
		LinkedList<Artista> list = new LinkedList<Artista>();
		String[] result = a.leer(nombre, (short) 3);
		try{
			list.add(new Artista(nombre, result[2]));
		}catch (NullPointerException npe){
			
		}
		return list;
	}

	public static void modificarCancion(Cancion c) throws ClassNotFoundException, SQLException {
		Agente a = new Agente();
		String[] search = {c.getID(),c.getTitulo(),c.getAlbum().getID(),c.getAutor().getID(),String.valueOf(c.getPrecio()),c.getMeta()};
		a.modificar(search, (short) 1, (short) 2);
	}

	public static void eliminarCancion(Cancion c) throws SQLException {
		Agente a = new Agente();
		String[] search = {c.getID(),c.getTitulo(),c.getAlbum().getID(),c.getAutor().getID(),String.valueOf(c.getPrecio()),c.getMeta()};
		a.modificar(search, (short) 1, (short) 3);
	}

	public static void eliminarAlbum(Album c) throws SQLException {
		Agente a = new Agente();
		String[] search = {c.getID(),c.getNombre(),c.getAutor().getID(),String.valueOf(c.getPrecio())};
		a.modificar(search, (short) 2, (short) 3);
	}

	public static void eliminarArtista(Artista c) throws SQLException {
		Agente a = new Agente();
		String[] search = {c.getID(),c.getNombre(),c.getDescripcion()};
		a.modificar(search, (short) 3, (short) 3);
	}

	public Void enviarMensaje(String msj) {
		// TODO - implement Gestor_Dominio.enviarMensaje
		throw new UnsupportedOperationException();
	}
	
	public static String getMD5(String input){
		try{
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger number = new BigInteger(messageDigest);
			return number.toString(16);
		}catch (NoSuchAlgorithmException nsae){
			throw new RuntimeException(nsae);
		}
	}

}