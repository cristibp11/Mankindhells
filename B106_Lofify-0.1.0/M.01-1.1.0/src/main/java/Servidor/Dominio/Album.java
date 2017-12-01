package Servidor.Dominio;

import java.sql.SQLException;
import java.util.LinkedList;

public class Album {

	private LinkedList<Cancion> canciones;
	private Artista autor;
	private String nombre;
	private double precio;
	private long id;
	
	public Album(){}
	
	public Album(Artista autor, String nombre, double precio) {
		this.autor = autor;
		this.nombre = nombre;
		this.precio = precio;
		this.id = this.autor.hashCode()+this.nombre.hashCode();
	}

	public String getNombre() {
		return this.nombre;
	}

	public Artista getAutor() {
		return this.autor;
	}

	public double getPrecio() {
		return this.precio;
	}

	public long getID() {
		return this.id;
	}
	
	public void addCancion(Cancion c){
		this.canciones.add(c);
	}
	
	public static Album addAlbum(String nombre, Double precio, String nombre_artista) throws ClassNotFoundException, SQLException{
		return Servidor.Dominio.Gestor_Dominio.añadirAlbum(nombre, precio, nombre_artista);
	}

}