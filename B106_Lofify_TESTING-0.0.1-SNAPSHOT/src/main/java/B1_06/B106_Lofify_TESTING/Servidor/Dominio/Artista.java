package B1_06.B106_Lofify_TESTING.Servidor.Dominio;

public class Artista {

	private String id;
	private String nombre;
	private String descripcion;

	public Artista(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.id = Gestor_Dominio.getMD5(nombre+""+descripcion);
	}
	
	public Artista(String id){
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}
	
	public String getID(){
		return this.id;
	}

}
