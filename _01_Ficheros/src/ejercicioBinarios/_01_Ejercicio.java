package ejercicioBinarios;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class _01_Ejercicio {

	public static void main(String[] args) {
		/**
		 * Escribir un programa Java que realice la copia de un fichero (por ejemplo un fichero imagen). 
		 * Se pide al usuario el fichero de entrada y el nombre del fichero de salida.
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el fichero de entrada");
		String entrada = sc.nextLine();
		System.out.println("Ahora introduce el fichero de salida");
		String salida = sc.nextLine();
		
		//Introduzco los recursos en el try para que los flujos se cierren 
		//automaticamente al finalizar los procesos 
		try(FileInputStream lectura  = new FileInputStream(entrada);
			FileOutputStream escritura = new FileOutputStream(salida);) {
			
			//Este buffer se usa para  almacenar temporalmente  los datos de entrada
			//antes de escribirlos en la salida 
			byte buf [] = new byte[1024];
			int len;
			//Se almacenan los datos leidos en el array
			// read retorna -1 cuando llega al final
			while((len = lectura.read(buf)) > 0) {
				escritura.write(buf, 0, len);//Escribe solo los bytes validos 
			}
			
			System.out.println("El archivo ha sido copiado correctamente.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
	         sc.close();  // Cerrar el scanner
	     }
		

	}

}
