package B1_06.B106_Lofify_TESTING.Servidor.Dominio;

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

}