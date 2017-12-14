package B1_06.B106_Lofify_TESTING.Servidor.Persistencia;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class Agente {
	

	public Agente() {
		System.out.println("Conexión establecida");
	}

	public String[] leer(String toSearch,short file){
		
		String[] result = null;
		File archivo = null;
		Scanner sc = null;
		
		try{
		switch (file){ //file: 1 = cancion / 2 = album / 3 = artista / 4 = usuario 
		case 1:
			archivo = new File(new File("").getAbsolutePath()+"\\B106_Lofify_TESTING-0.0.1\\src\\"
					+ "main\\java\\B1_06\\B106_Lofify_TESTING\\Servidor\\Persistencia");
			sc = new Scanner(archivo);
			break;
		case 2:
			archivo = new File(new File("").getAbsolutePath()+"\\B106_Lofify_TESTING-0.0.1\\src\\"
					+ "main\\java\\B1_06\\B106_Lofify_TESTING\\Servidor\\Persistencia");
			break;
		case 3:
			archivo = new File(new File("").getAbsolutePath()+"\\B106_Lofify_TESTING-0.0.1\\src\\"
					+ "main\\java\\B1_06\\B106_Lofify_TESTING\\Servidor\\Persistencia");
			break;
		case 4:
			archivo = new File(new File("").getAbsolutePath()+"\\B106_Lofify_TESTING-0.0.1\\src\\"
					+ "main\\java\\B1_06\\B106_Lofify_TESTING\\Servidor\\Persistencia");
			break;
		}
		
		sc.nextLine();
		while(!((result = sc.nextLine().split("/"))[1].equals(toSearch)));
		}
		catch(FileNotFoundException e){
			System.out.println("Archivo no encontrado");
		}
		return result;
	}

	public void modificar(String[] toModify, short file, short tipoMod){
		
		String[] result = null;
		File archivo = null;
		Scanner sc = null;
		
		try{
		switch (file){ //file: 1 = cancion / 2 = album / 3 = artista / 4 = usuario 
		case 1:
			archivo = new File(new File("").getAbsolutePath()+"\\B106_Lofify_TESTING-0.0.1\\src\\"
					+ "main\\java\\B1_06\\B106_Lofify_TESTING\\Servidor\\Persistencia");
			sc = new Scanner(archivo);
			break;
		case 2:
			archivo = new File(new File("").getAbsolutePath()+"\\B106_Lofify_TESTING-0.0.1\\src\\"
					+ "main\\java\\B1_06\\B106_Lofify_TESTING\\Servidor\\Persistencia");
			break;
		case 3:
			archivo = new File(new File("").getAbsolutePath()+"\\B106_Lofify_TESTING-0.0.1\\src\\"
					+ "main\\java\\B1_06\\B106_Lofify_TESTING\\Servidor\\Persistencia");
			break;
		case 4:
			archivo = new File(new File("").getAbsolutePath()+"\\B106_Lofify_TESTING-0.0.1\\src\\"
					+ "main\\java\\B1_06\\B106_Lofify_TESTING\\Servidor\\Persistencia");
			break;
		}
		
		sc.nextLine();
		while(!((result = sc.nextLine().split("/"))[1].equals(toModify[1])));
		FileWriter escribir = new FileWriter(archivo, false);
		escribir.;
		}
		catch(FileNotFoundException e){
			System.out.println("Archivo no encontrado");
		}
		
	}

}