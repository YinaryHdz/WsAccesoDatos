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
		 mostrarListaEstudiantes("C:/dir1/estudiantes.dat");
    }
    
    public static void mostrarListaEstudiantes(String archivo) {
        try {
            RandomAccessFile leer = new RandomAccessFile(archivo, "r");
            byte[] lectura = new byte[1024]; 
            int len;

            System.out.println("Lista de estudiantes y calificaciones:");
            
            while ((len = leer.read(lectura)) > 0) {
                //Convertir los bytes a cadenas para leerlos
                String contenido = new String(lectura, 0, len);
                System.out.print(contenido); 
            }
            
            leer.close(); 

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + archivo);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + archivo);
            e.printStackTrace();
        }
    }

}
