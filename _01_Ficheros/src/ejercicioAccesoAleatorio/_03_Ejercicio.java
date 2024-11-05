package ejercicioAccesoAleatorio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class _03_Ejercicio {

	public static void main(String[] args) throws FileNotFoundException {
		/*
		 * Realizar un método que reciba por parámetro el nombre de un fichero 
		 * que almacena una serie de nombres de estudiantes  y calificaciones y actualice
		 * las calificaciones de forma que las superiores a 8 se incrementen en un punto 
		 * (hasta 10 como máximo) y las inferiores a 5 se incrementen en medio punto. 
		 * El método capturará y tratará todas las excepciones que puedan producirse.
		 */
		
		modificarCalificaciones("C:/dir1/estudiantes.dat");
		

	}
	
	public static void modificarCalificaciones(String archivo) {
		 try {
			RandomAccessFile archivoEstudiantes = new RandomAccessFile(archivo, "rw");
			String linea;
			long posicionInicio=0;
			
	        while ((linea = archivoEstudiantes.readLine()) != null) {
	            String[]partes = linea.split(",");
	            if(partes.length<2) {
	            	continue;
	            }
	            
	            String nombre = partes[0].trim();
                double calificacion;
                
                try {
                    calificacion = Double.parseDouble(partes[1].trim());
                } catch (NumberFormatException e) {
                    System.out.println("Error al convertir la calificación de " + nombre);
                    continue;
                }
	            
                if(calificacion > 8) {
                	calificacion = Math.min(calificacion + 1, 10);
                }else if(calificacion < 5) {
                	calificacion = Math.min(calificacion + 0.5, 10); 	
                }
                
                archivoEstudiantes.seek(posicionInicio);
                archivoEstudiantes.writeBytes(nombre + "," + calificacion + "\n");

                posicionInicio = archivoEstudiantes.getFilePointer();
                
                archivoEstudiantes.close();
                System.out.println("Calificaciones actualizadas...");
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
