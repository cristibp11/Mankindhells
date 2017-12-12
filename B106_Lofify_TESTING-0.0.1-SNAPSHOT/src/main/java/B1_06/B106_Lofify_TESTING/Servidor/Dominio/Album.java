package B1_06.B106_Lofify_TESTING.Servidor.Dominio;

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

}