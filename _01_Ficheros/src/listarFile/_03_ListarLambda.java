package listarFile;

import java.io.File;

public class _03_ListarLambda {     

	public static void main(String[] args) {
		File dir = new File("C:/dir1");
		File [] lista = dir.listFiles((d,name) -> name.endsWith(".txt"));
		for(File fich : lista) {
			//Muestra en una lista los elementos terminados en txt que hay en dir1     
			System.out.println("Elemento: " + fich.toString());   
		}

	}

}
