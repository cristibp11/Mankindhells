package B1_06.B106_Lofify_TESTING.Servidor.Dominio;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import B1_06.B106_Lofify_TESTING.Servidor.Persistencia.Agente;

public class Gestor_Dominio {

	public static Cancion añadirCancion(String titulo, String metadatos, double precio, String nombre_artista,
			String nombre_album) throws NumberFormatException, SQLException, ClassNotFoundException {
		Agente a = new Agente();
		ResultSet rs = a.leer("SELECT * FROM ALBUMES WHERE nombre=\"" + nombre_album + "\"");
		Album al = null;
		Artista ar = null;
		Cancion c = null;
		while (rs.next()) {
			String autor_id = rs.getString(0);
			Double al_precio = Double.parseDouble(rs.getString(2));
			ResultSet rs2 = a.leer("SELECT * FROM ARTISTAS WHERE id=" + autor_id + "");
			if (nombre_artista.equals(rs2.getString(1)))
				continue;
			ar = new Artista(nombre_artista, rs2.getString(2));
			al = new Album(ar, nombre_album, al_precio);
		}
		try {
			if (ar != null && al != null) {
				c = new Cancion(ar, titulo, metadatos, al, precio);
				a.modificar("INSERT INTO CANCIONES (id, autor, album, titulo, metadatos, precio)" + "VALUES ("
						+ c.getID() + ", " + ar.getID() + ", " + al.getID() + ", \"" + titulo + "\", " + "\""
						+ metadatos + "\", " + precio + ")");
			}
		} catch (NullPointerException npe) {
			// Cancion no introducida por fallos de datos
		}
		return c;
	}

	public static Album añadirAlbum(String nombre, Double precio, String nombre_artista) throws SQLException{
		Agente a = null;
		try {
			a = new Agente();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = a.leer("SELECT * FROM ARTISTAS WHERE nombre=\"" + nombre_artista + "\"");
		Album al = null;
		Artista ar = null;
		while (rs.next()) {
			ar = new Artista(nombre_artista, rs.getString(2));
			al = new Album(ar, nombre, precio);
		}
		try {
			if (ar != null && al != null) {
				a.modificar("INSERT INTO ALBUMES (id, autor, nombre, precio)" + "VALUES (" + al.getID() + ", "
						+ ar.getID() + ", \"" + nombre + "\", " + precio + ")");
			}
		} catch (NullPointerException npe) {
			// Cancion no introducida por fallos de datos
		}
		return al;
	}

	public static Artista añadirArtista(String nombre, String descripcion) throws ClassNotFoundException, SQLException {
		Agente a = new Agente();
		Artista ar = new Artista(nombre, descripcion);
		int result = a.modificar("INSERT INTO ARTISTAS (id, nombre, descripcion)" + "VALUES (" + ar.getID() + ", \""
				+ ar.getNombre() + "\", \"" + ar.getDescripcion() + "\")");
		if (result != 1) {
			throw new SQLException();
		} else {
			return ar;
		}
	}

	public static LinkedList<Cancion> buscarCancion(String titulo) throws SQLException, ClassNotFoundException {
		Agente a = new Agente();
		LinkedList<Cancion> busqueda = new LinkedList<Cancion>();

		ResultSet result = a.leer("SELECT FROM CANCIONES WHERE titulo=\"" + titulo + "\"");
		ResultSet resultArtista = a.leer("SELECT FROM ARTISTAS WHERE id=" + result.getLong(1));
		resultArtista.next();
		ResultSet resultAlbum = a.leer("SELECT FROM ALBUMES WHERE id=" + result.getLong(2));
		resultAlbum.next();

		while (result.next()) {
			Artista autor = new Artista(resultArtista.getString(0), resultArtista.getString(1));
			Album album = new Album(autor, resultAlbum.getString(1), resultAlbum.getDouble(2));
			busqueda.add(new Cancion(autor, result.getString(3), result.getString(4), album, result.getDouble(5)));
		}

		return busqueda;
	}

	public static LinkedList<Album> buscarAlbum(String nombre) throws SQLException {
		Agente a = null;
		try {
			a = new Agente();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LinkedList<Album> busqueda = new LinkedList<Album>();

		ResultSet resultAlbum = a.leer("SELECT FROM ALBUMES WHERE nombre=\"" + nombre + "\"");
		resultAlbum.next();
		ResultSet resultArtista = a.leer("SELECT FROM ARTISTAS WHERE id=" + resultAlbum.getLong(1));
		resultArtista.next();

		while (resultAlbum.next()) {
			Artista autor = new Artista(resultArtista.getString(0), resultArtista.getString(1));
			busqueda.add(new Album(autor, resultAlbum.getString(1), resultAlbum.getDouble(2)));
		}

		return busqueda;
	}

	public static LinkedList<Artista> buscarArtista(String nombre) throws SQLException {
		Agente a = null;
		try {
			a = new Agente();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LinkedList<Artista> busqueda = new LinkedList<Artista>();

		ResultSet resultArtista = a.leer("SELECT FROM ARTISTAS WHERE nombre=\"" + nombre + "\"");
		resultArtista.next();

		while (resultArtista.next()) {
			busqueda.add(new Artista(resultArtista.getString(0), resultArtista.getString(1)));
		}

		return busqueda;
	}

	public static Cancion modificarCancion(Cancion c) throws ClassNotFoundException, SQLException {
		Agente a = new Agente();
		int result = a.modificar("UPDATE CANCIONES SET metadatos=\"" + c.getMeta() + "\", precio=" + c.getPrecio()
				+ " WHERE id=" + c.getID());
		if (result == 1) {
			return c;
		} else {
			return null;
		}
	}

	public static void eliminarCancion(Cancion c) throws SQLException {
		Agente a = null;
		try {
			a = new Agente();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		a.modificar("DELETE FROM CANCIONES WHERE id=" + c.getID());
	}

	public static void eliminarAlbum(Album c) throws SQLException {
		Agente a = null;
		try {
			a = new Agente();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		a.modificar("DELETE FROM ALBUMES WHERE id=" + c.getID());
	}

	public static void eliminarArtista(Artista c) throws SQLException {
		Agente a = null;
		try {
			a = new Agente();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		a.modificar("DELETE FROM ARTISTA WHERE id=" + c.getID());
	}

	public Void enviarMensaje(Usuario u, String msj) {
		// TODO - implement Gestor_Dominio.enviarMensaje
		throw new UnsupportedOperationException();
	}

	public Void eliminarElemento(long id) {
		// TODO - implement Gestor_Dominio.eliminarElemento
		throw new UnsupportedOperationException();
	}
	
	private static String getMD5(String input){
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