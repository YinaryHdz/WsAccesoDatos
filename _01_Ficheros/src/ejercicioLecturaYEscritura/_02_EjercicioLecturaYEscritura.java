package ejercicioLecturaYEscritura;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class _02_EjercicioLecturaYEscritura {

	public static void main(String[] args) {
		/*Realizar un programa que muestre las n primeras líneas del fichero de texto
		“texto.txt”. El valor de n se pedirá al usuario y se tendrá en cuenta que puede ser
		mayor que el número de filas del fichero.
		*/
		
		File archivo = new File("C:\\dir1\\texto.txt");
		Scanner scanner = new Scanner(System.in);
	    System.out.print("Introduce el número de líneas a mostrar: ");
	    int n = scanner.nextInt();  // Leer el valor de n
		
		try {
			FileReader fr = new FileReader(archivo);
			int caracter = 0;
			while((caracter = fr.read()) != -1 ) {
	
                
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
		

	

}
