package Servidor.Dominio;

import java.sql.SQLException;
import java.util.LinkedList;

public class Cancion {

	private Artista autor;
	private String titulo;
	private String metadatos;
	private Album album;
	private double precio;
	private long id;

	public Cancion(Artista autor, String titulo, String metadatos, Album album, double precio) {
		this.autor = autor;
		this.titulo = titulo;
		this.metadatos = metadatos;
		this.album = album;
		this.precio = precio;
		this.id = this.album.getID()+this.titulo.hashCode();
	}

	public String getTitulo() {
		return this.titulo;
	}

	public Artista getAutor() {
		return this.autor;
	}

	public String getMeta() {
		return this.metadatos;
	}

	public Album getAlbum() {
		return this.album;
	}

	public double getPrecio() {
		return this.precio;
	}

	public long getID() {
		return this.id;
	}
	
	public static Cancion addCancion(String titulo, String metadatos, Double precio, String nombre_artista, String nombre_album) throws NumberFormatException, ClassNotFoundException, SQLException{
		return Servidor.Dominio.Gestor_Dominio.añadirCancion(titulo, metadatos, precio, nombre_artista, nombre_album);
	}

	public void setPrecio(double p) {
		this.precio = p;
	}

	public void setMetadatos(String s) {
		this.metadatos = s;
	}

}