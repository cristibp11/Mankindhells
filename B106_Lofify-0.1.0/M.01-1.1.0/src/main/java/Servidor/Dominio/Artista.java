package Servidor.Dominio;

import java.sql.SQLException;

public class Artista {

	private long id;
	private String nombre;
	private String descripcion;

	public Artista(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.id = this.nombre.hashCode()+this.descripcion.hashCode();
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}
	
	public long getID(){
		return this.id;
	}
	
	public static Artista addArtista(String nombre, String descripcion) throws ClassNotFoundException, SQLException{
		return Servidor.Dominio.Gestor_Dominio.añadirArtista(nombre, descripcion);
	}
}