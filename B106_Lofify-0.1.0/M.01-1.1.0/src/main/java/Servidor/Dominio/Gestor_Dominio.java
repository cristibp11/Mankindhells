package Servidor.Dominio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import Servidor.Persistencia.Agente;
import Servidor.Presentacion.IU_Servidor;

public class Gestor_Dominio {

	public static Cancion añadirCancion(String titulo, String metadatos, double precio, String nombre_artista,
			String nombre_album) throws NumberFormatException, SQLException, ClassNotFoundException {
		Agente a = new Agente();
		ResultSet rs =  a.leer("SELECT * FROM albumes WHERE nombre=\""+nombre_album+"\"");
		Album al = null;
		Artista ar = null;
		Cancion c = null;
		while(rs.next()){
			String autor_id = rs.getString(0);
			Double al_precio = Double.parseDouble(rs.getString(2));
			ResultSet rs2 = a.leer("SELECT * FROM artistas WHERE id_artista="+autor_id+"");
			if(nombre_artista.equals(rs2.getString(1)))
				continue;
			ar = new Artista(nombre_artista, rs2.getString(2));
			al = new Album(ar, nombre_album, al_precio);
		}
		try{
			if(ar!=null && al!= null){
				c = new Cancion(ar, titulo, metadatos, al, precio);
				a.modificar("INSERT INTO canciones (idCanciones, titulo, album, precio, metadatos)"
						+ "VALUES ("+c.getID()+", "+titulo+", "+al.getID()+", \""+precio+"\", "
						+ "\""+metadatos+")");
			}
		} catch (NullPointerException npe){
			//Cancion no introducida por fallos de datos
		}
		return c;
	}

	public static Album añadirAlbum(String nombre, Double precio, String nombre_artista) throws SQLException, ClassNotFoundException {
		Agente a = new Agente();
		ResultSet rs =  a.leer("SELECT * FROM ARTISTAS WHERE nombre=\""+nombre_artista+"\"");
		Album al = null;
		Artista ar = null;
		while(rs.next()){
			ar = new Artista(nombre_artista, rs.getString(2));
			al = new Album(ar, nombre, precio);
		}
		try{
			if(ar!=null && al!= null){
				a.modificar("INSERT INTO albumes (idAlbum, nombre, precio, artista)"
						+ "VALUES ("+al.getID()+", \""+nombre+"\", \""+precio+"\", \""+nombre_artista+"\")");
			}
		} catch (NullPointerException npe){
			//Cancion no introducida por fallos de datos
		}
		return al;
	}
	
	public static Artista añadirArtista(String nombre, String descripcion) throws ClassNotFoundException, SQLException{
		Agente a = new Agente();
		Artista ar = new Artista(nombre, descripcion);
		int result = a.modificar("INSERT INTO artistas (id_artista,Nombre,Descripcion)"
				+ "VALUES ("+ar.getID()+ ", \""+ar.getNombre()+"\", \""+ar.getDescripcion()+"\")");
		if(result!=1){
			throw new SQLException();
		}else{
			return ar;
		}
	}

	public static LinkedList<Cancion> buscarCancion(String titulo) throws SQLException, ClassNotFoundException{
		Agente a = new Agente();
		LinkedList<Cancion> busqueda = new LinkedList<Cancion>();
		
		ResultSet result = a.leer("SELECT * FROM canciones WHERE titulo=\""+titulo+"\"");
		ResultSet resultArtista = a.leer("SELECT * FROM artistas WHERE id_artista="+result.getInt(5));
		resultArtista.next();
		ResultSet resultAlbum = a.leer("SELECT * FROM albumes WHERE album="+result.getInt(2));
		resultAlbum.next();
		
		while(result.next()){
			Artista autor = new Artista(resultArtista.getString(0),resultArtista.getString(1));
			Album album = new Album(autor,resultAlbum.getString(1),resultAlbum.getDouble(2));
			busqueda.add(new Cancion(autor,result.getString(1),result.getString(4),album,result.getDouble(3)));
		}
		
		return busqueda;
	}
	
	public static LinkedList<Album> buscarAlbum(String nombre) throws SQLException{
		Agente a = new Agente();
		LinkedList<Album> busqueda = new LinkedList<Album>();

		ResultSet resultAlbum = a.leer("SELECT * FROM ALBUMES WHERE nombre=\""+nombre+"\"");
		resultAlbum.next();
		ResultSet resultArtista = a.leer("SELECT * FROM ARTISTAS WHERE id_artista="+resultAlbum.getInt(3));
		resultArtista.next();
		
		while(resultAlbum.next()){
			Artista autor = new Artista(resultArtista.getString(0),resultArtista.getString(1));
			busqueda.add(new Album(autor,resultAlbum.getString(1),resultAlbum.getDouble(2)));
		}
		
		return busqueda;
	}
	
	public static LinkedList<Artista> buscarArtista(String nombre) throws SQLException{
		Agente a = new Agente();
		LinkedList<Artista> busqueda = new LinkedList<Artista>();
		
		ResultSet resultArtista = a.leer("SELECT * FROM ARTISTAS WHERE Nombre=\""+nombre+"\"");
		resultArtista.next();
		
		while(resultArtista.next()){
			busqueda.add(new Artista(resultArtista.getString(0),resultArtista.getString(1)));
		}
		
		return busqueda;
	}

}