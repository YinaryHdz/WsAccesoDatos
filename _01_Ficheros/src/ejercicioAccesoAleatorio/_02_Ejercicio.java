package ejercicioAccesoAleatorio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class _02_Ejercicio {

	public static void main(String[] args) {
		/*
		 * Escribir un método que reciba por parámetro el 
		 * nombre de un fichero que almacena una serie de 
		 * nombres de estudiantes  y calificaciones y muestre 
		 * su contenido por pantalla.
		 */

	}
	
	public static void mostrarListaEstudiantes(String archivo) {
		try {
			RandomAccessFile leer = new RandomAccessFile(archivo, "rw");
			byte lectura [] = new byte[1024];
			int len;
			while((len = leer.read(lectura)) > 0) {
				System.out.println("");
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
