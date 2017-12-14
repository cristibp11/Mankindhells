package B1_06.B106_Lofify_TESTING.Servidor.Persistencia;
import java.util.Scanner;
import java.util.Vector;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
		
		File archivo = null;
		String aux= "";
		FileReader fr;
		BufferedReader br;
		String linea;
	    Vector lineas;
		
		try{
		switch (file){ //file: 1 = cancion / 2 = album / 3 = artista / 4 = usuario 
		case 1:
			archivo = new File(new File("").getAbsolutePath()+"\\B106_Lofify_TESTING-0.0.1\\src\\"
					+ "main\\java\\B1_06\\B106_Lofify_TESTING\\Servidor\\Persistencia\\Cancion");
			break;
		case 2:
			archivo = new File(new File("").getAbsolutePath()+"\\B106_Lofify_TESTING-0.0.1\\src\\"
					+ "main\\java\\B1_06\\B106_Lofify_TESTING\\Servidor\\Persistencia\\Album");
			break;
		case 3:
			archivo = new File(new File("").getAbsolutePath()+"\\B106_Lofify_TESTING-0.0.1\\src\\"
					+ "main\\java\\B1_06\\B106_Lofify_TESTING\\Servidor\\Persistencia\\Artista");
			break;
		case 4:
			archivo = new File(new File("").getAbsolutePath()+"\\B106_Lofify_TESTING-0.0.1\\src\\"
					+ "main\\java\\B1_06\\B106_Lofify_TESTING\\Servidor\\Persistencia\\Usuario");
			break;
		}
		
		fr = new FileReader (archivo);
		br = new BufferedReader(fr);
		lineas=new Vector();
		
		while((linea=br.readLine())!=null){
		    if(!((linea.split("/")[1]).equals(toModify[1]))){
		    lineas.addElement(linea);
		}
		}
		
		if(tipoMod == 1 || tipoMod == 2){
			for(int i=0;i<toModify.length;i++) aux += toModify[i];
			lineas.addElement(aux);
		}
		
			br.close();  
			fr.close();
			
		FileWriter fichero = new FileWriter(archivo); 
		PrintWriter escribe = new PrintWriter(fichero);
		 
		 for(int i=0;i<lineas.size();i++){ 
		 escribe.println(lineas.elementAt(i)); 
		 } 
		 
		 fichero.close();
		
		}catch(Exception e){
			System.out.println("Error en modificación de fichero");
			}
		}

}
