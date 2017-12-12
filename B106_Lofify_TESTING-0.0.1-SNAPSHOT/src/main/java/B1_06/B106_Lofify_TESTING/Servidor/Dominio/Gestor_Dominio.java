package B1_06.B106_Lofify_TESTING.Servidor.Dominio;

import java.sql.ResultSet;
import java.sql.SQLException;

import B1_06.B106_Lofify_TESTING.Servidor.Persistencia.Agente;

public class Gestor_Dominio {

	public Cancion añadirCancion(String titulo, String metadatos, double precio, String nombre_artista,
			String nombre_album) throws NumberFormatException, SQLException, ClassNotFoundException {
		Agente a = new Agente();
		ResultSet rs =  a.leer("SELECT * FROM ALBUMES WHERE nombre=\""+nombre_album+"\"");
		Album al = null;
		Artista ar = null;
		Cancion c = null;
		while(rs.next()){
			String autor_id = rs.getString(0);
			Double al_precio = Double.parseDouble(rs.getString(2));
			ResultSet rs2 = a.leer("SELECT * FROM ARTISTAS WHERE id="+autor_id+"");
			if(nombre_artista.equals(rs2.getString(1)))
				continue;
			ar = new Artista(nombre_artista, rs2.getString(2));
			al = new Album(ar, nombre_album, al_precio);
		}
		try{
			if(ar!=null && al!= null){
				c = new Cancion(ar, titulo, metadatos, al, precio);
				a.modificar("INSERT INTO CANCIONES (autor, album, titulo, metadatos, precio)"
						+ "VALUES ("+ar.getID()+", "+al.getID()+", \""+titulo+"\", "
								+ "\""+metadatos+"\", "+precio+")");
			}
		} catch (NullPointerException npe){
			//Cancion no introducida por fallos de datos
		}
		return c;
	}

	public Album añadirAlbum(String nombre, Double precio, String nombre_artista) throws SQLException, ClassNotFoundException {
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
				a.modificar("INSERT INTO ALBUMES (autor, nombre, precio)"
						+ "VALUES ("+ar.getID()+", \""+nombre+"\", "+precio+")");
			}
		} catch (NullPointerException npe){
			//Cancion no introducida por fallos de datos
		}
		return al;
	}

	public Cancion modificarCancion(Cancion c) {
		// TODO - implement Gestor_Dominio.modificarCancion
		throw new UnsupportedOperationException();
	}


	public Void enviarMensaje(Usuario u, String msj) {
		// TODO - implement Gestor_Dominio.enviarMensaje
		throw new UnsupportedOperationException();
	}


	public Void eliminarElemento(long id) {
		// TODO - implement Gestor_Dominio.eliminarElemento
		throw new UnsupportedOperationException();
	}

}