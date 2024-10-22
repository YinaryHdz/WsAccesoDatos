package ejercicioAccesoAleatorio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class _01_Ejercicio {

	public static void main(String[] args) {
		/**
		 * Escribe un método que reciba por parámetro un ArrayList de 
		 * nombres de estudiantes (cadenas de texto) y un array de enteros
		 * que representen las calificaciones de dichos estudiantes. El método
		 * recibirá también el nombre de un fichero sobre el que se escribirá 
		 * cada nombre de estudiante seguido de su calificación.
		 * 
		 */
		
		ArrayList <String> Estudiantes  =new ArrayList<String>();
		Estudiantes.add("Luisa");
		Estudiantes.add("Mario");
		Estudiantes.add("Jose");
		int [] calificaciones = {8,5,10};
		
		escribirCalificaciones(Estudiantes, calificaciones, "C:\\dir1\\\\estudiantes.dat");

	}
	
	public static void escribirCalificaciones (ArrayList<String>Estudiantes, int[]calificaciones, String nombreFichero) {
		if(Estudiantes.size() != calificaciones.length) {
			System.out.println("La cantidad de estudiantes debe ser la misma a la "
					+ "cantidad de calificaciones");
		}
		try {
			RandomAccessFile raf = new RandomAccessFile(nombreFichero, "rw");
			for (int i = 0 ; i < Estudiantes.size() ; i++) {
				String linea = String.format("%-20s: %d\n", Estudiantes.get(i), calificaciones[i]);
				raf.writeBytes(linea);
			}
			
			System.out.println("Datos escritos correctamente en el archivo " + nombreFichero);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
