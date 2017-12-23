package B1_06.B106_Lofify_TESTING.Servidor.Persistencia;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Vector;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class Agente {

	public Agente() {
	}

	public String[] leer(String toSearch, short file) {

		String[] result = null;
		String[] aux = null;
		File archivo = null;
		Scanner sc = null;

		try {
			switch (file) { // file: 1 = cancion / 2 = album / 3 = artista / 4 =
							// usuario
			case 1:
				archivo = new File(new File("").getAbsolutePath() + "\\src\\"
						+ "main\\java\\B1_06\\B106_Lofify_TESTING\\Servidor\\Persistencia\\Cancion.txt");
				break;
			case 2:
				archivo = new File(new File("").getAbsolutePath() + "\\src\\"
						+ "main\\java\\B1_06\\B106_Lofify_TESTING\\Servidor\\Persistencia\\Album.txt");
				break;
			case 3:
				archivo = new File(new File("").getAbsolutePath() + "\\src\\"
						+ "main\\java\\B1_06\\B106_Lofify_TESTING\\Servidor\\Persistencia\\Artista.txt");
				break;
			case 4:
				archivo = new File(new File("").getAbsolutePath() + "\\src\\"
						+ "main\\java\\B1_06\\B106_Lofify_TESTING\\Servidor\\Persistencia\\Usuario.txt");
				break;
			default:
				break;
			}

			sc = new Scanner(archivo, System.getProperty("file.encoding"));
			sc.nextLine();
			while (sc.hasNextLine()) {
				if (((aux = sc.nextLine().split("/"))[1].equals(toSearch))) {
					result = aux;
					break;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		} finally {
			if (sc != null)
				sc.close();
		}
		return result;
	}

	public void modificar(String[] toModify, short file, short tipoMod) {

		File archivo = null;
		String aux = "";
		Reader fr;
		BufferedReader br;
		String linea;
		Vector lineas;

		try {
			switch (file) { // file: 1 = cancion / 2 = album / 3 = artista / 4 =
							// usuario
			case 1:
				archivo = new File(new File("").getAbsolutePath() + "\\src\\"
						+ "main\\java\\B1_06\\B106_Lofify_TESTING\\Servidor\\Persistencia\\Cancion.txt");
				break;
			case 2:
				archivo = new File(new File("").getAbsolutePath() + "\\src\\"
						+ "main\\java\\B1_06\\B106_Lofify_TESTING\\Servidor\\Persistencia\\Album.txt");
				break;
			case 3:
				archivo = new File(new File("").getAbsolutePath() + "\\src\\"
						+ "main\\java\\B1_06\\B106_Lofify_TESTING\\Servidor\\Persistencia\\Artista.txt");
				break;
			case 4:
				archivo = new File(new File("").getAbsolutePath() + "\\src\\"
						+ "main\\java\\B1_06\\B106_Lofify_TESTING\\Servidor\\Persistencia\\Usuario.txt");
				break;
			default:
				break;
			}

			fr = new InputStreamReader(new FileInputStream(archivo), System.getProperty("file.encoding"));
			br = new BufferedReader(fr);
			lineas = new Vector();

			while ((linea = br.readLine()) != null) {
				if (!((linea.split("/")[1]).equals(toModify[1]))) {
					lineas.addElement(linea);
				}
			}

			if (tipoMod == 1 || tipoMod == 2) {
				for (int i = 0; i < toModify.length; i++) {
					if (i == 1)
						aux = toModify[0];
					aux = aux + "/" + toModify[i];
				}
				lineas.addElement(aux);
			}

			if (br != null)
				br.close();
			if (fr != null)
				fr.close();

			Writer fichero = new OutputStreamWriter(new FileOutputStream(archivo), System.getProperty("file.encoding"));
			PrintWriter escribe = new PrintWriter(fichero);

			for (int i = 0; i < lineas.size(); i++) {
				escribe.println(lineas.elementAt(i));
			}

			if (escribe != null)
				escribe.close();
			if (fichero != null)
				fichero.close();

		} catch (UnsupportedEncodingException usee) {
			System.err.println("Encoding no soportado");
		} catch (IOException ioe) {
			System.err.println("Error de lectura/escritura de datos");
		} catch (NoSuchElementException nsee) {
			System.err.println("Elemento no encontrado");
		}
	}

}
