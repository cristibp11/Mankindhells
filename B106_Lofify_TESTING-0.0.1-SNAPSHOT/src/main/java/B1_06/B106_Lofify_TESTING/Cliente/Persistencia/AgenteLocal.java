package B1_06.B106_Lofify_TESTING.Cliente.Persistencia;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class AgenteLocal {
	

	public AgenteLocal() {
		System.out.println("Conexión establecida");
	}

	public String[] leer(String toSearch,short file){
		
		String[] result = null;
		File archivo = null;
		Scanner sc = null;
		
		try{
		switch (file){ //file: 1 = cancion / 2 = lista
		case 1:
			archivo = new File(new File("").getAbsolutePath()+"\\B106_Lofify_TESTING-0.0.1\\src\\"
					+ "main\\java\\B1_06\\B106_Lofify_TESTING\\Cliente\\Persistencia");
			sc = new Scanner(archivo);
			break;
		case 2:
			archivo = new File(new File("").getAbsolutePath()+"\\B106_Lofify_TESTING-0.0.1\\src\\"
					+ "main\\java\\B1_06\\B106_Lofify_TESTING\\Cliente\\Persistencia");
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
		switch (file){ //file: 1 = cancion / 2 = lista
		case 1:
			archivo = new File(new File("").getAbsolutePath()+"\\B106_Lofify_TESTING-0.0.1\\src\\"
					+ "main\\java\\B1_06\\B106_Lofify_TESTING\\Cliente\\Persistencia");
			sc = new Scanner(archivo);
			break;
		case 2:
			archivo = new File(new File("").getAbsolutePath()+"\\B106_Lofify_TESTING-0.0.1\\src\\"
					+ "main\\java\\B1_06\\B106_Lofify_TESTING\\Cliente\\Persistencia");
			break;
		}
		
		sc.nextLine();
		while(!((result = sc.nextLine().split("/"))[1].equals(toModify[1])));
		try {
			FileWriter escribir = new FileWriter(archivo, false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		catch(FileNotFoundException e){
			System.out.println("Archivo no encontrado");
		}
		
	}

}