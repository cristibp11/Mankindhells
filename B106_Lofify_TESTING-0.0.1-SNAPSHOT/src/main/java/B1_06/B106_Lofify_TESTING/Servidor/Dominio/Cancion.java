package B1_06.B106_Lofify_TESTING.Servidor.Dominio;

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

	public void setPrecio(double p) {
		this.precio = p;
	}

	public void setMetadatos(String s) {
		this.metadatos = s;
	}

}