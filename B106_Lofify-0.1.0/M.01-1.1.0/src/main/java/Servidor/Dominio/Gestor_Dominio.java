package Servidor.Dominio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import Servidor.Persistencia.Agente;

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
			System.out.println("Se han introducido los datos correctamente");
		} catch (NullPointerException npe){
			//Cancion no introducida por fallos de datos
			System.out.println("error al introducir los datos");
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
			System.out.println("Se han introducido los datos correctamente");
		} catch (NullPointerException npe){
			//Cancion no introducida por fallos de datos
			System.out.println("error al introducir los datos");
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
			System.out.println("Se ha añadido correctamente");
			return ar;
		}
	}

}