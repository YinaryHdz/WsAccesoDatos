package ficherosTexto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _02_Lectura {

	public static void main(String[] args) {
		//Este archivo debe existir, no se creara automaticamente
		File archivo = new File("C:\\dir1\\f1.txt");
		try {
			Scanner sc = new Scanner(archivo);
			/*
			 * El bucle while utiliza sc.hasNextLine() para verificar si hay más líneas que 
			 * leer en el archivo. Mientras haya líneas, el bucle continuará.
			 */
			while(sc.hasNextLine()) {
				//Dentro del bucle, sc.nextLine() lee la siguiente línea del archivo y la guarda en la variable linea.
				String linea = sc.nextLine();
				//Luego, System.out.println(linea); imprime esa línea en la consola.
				System.out.println(linea);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
