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
			StringBuilder lineaActual = new StringBuilder();
			int caracter = 0;
			int contador = 0;
			while((caracter = fr.read()) != -1 ) {
				// Si se encuentra un salto de línea, se considera que se ha leído una línea completa
                if (caracter == '\n') {
                    // Mostrar la línea actual si el contador es menor que n
                    if (contador < n) {
                        System.out.println(lineaActual.toString());
                        contador++;
                    } else {
                        break; // Salir si ya se han mostrado n líneas
                    }
                    lineaActual.setLength(0); // Reiniciar para la siguiente línea
                } else {
                    lineaActual.append((char) caracter); // Agregar carácter a la línea actual
                }
            }

            // Mostrar la última línea si no termina con un salto de línea
            if (lineaActual.length() > 0 && contador < n) {
                System.out.println(lineaActual.toString());
                contador++;
            }
            if (contador < n) {
                System.out.println("El archivo tiene solo " + contador + " líneas.");
            }

            fr.close(); 
                
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
		

	

}
