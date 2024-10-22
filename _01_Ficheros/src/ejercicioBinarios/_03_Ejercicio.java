package ejercicioBinarios;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _03_Ejercicio {

	public static void main(String[] args) {
		/**
		 * Leer el fichero del ejercicio2
		 * El nombre y los apellidos tendrán 20 caracteres rellenando con 
		 * espacios al final para completar la longitud
		 */
		FileInputStream fis;
		
		try {
			fis = new FileInputStream("C:/dir1/persona.dat");
			DataInputStream dis = new DataInputStream(fis);
			while(dis.available() > 0) {
				String nombre = dis.readUTF();
                nombre = agregarCaracteres(nombre);
                
                String apellido1 = dis.readUTF();
                apellido1 = agregarCaracteres(apellido1);
                
                String apellido2 = dis.readUTF();
                apellido2 = agregarCaracteres(apellido2);
                
                int anioNacimiento = dis.readInt();
                
				System.out.println("Nombre: " +nombre + "-----");
				System.out.println("Apellido 1 : " +apellido1+ "-----");
				System.out.println("Apellido 2 : " +apellido2+ "-----");
				System.out.println("Año de nacimiento: " + anioNacimiento+ "-----");
				
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String agregarCaracteres(String texto) {
		if(texto.length() < 20) {
			return String.format("%-20s", texto);
		}else if (texto.length() > 20 ) {
			return texto.substring(0, 20);
		}
		return texto;
	}

}
