package ficherosTexto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class _03_Lectura {

	public static void main(String[] args) {
		File archivo = new File("C:\\dir1\\f1.txt");
		//Se declara e inicializa la variable caracter para almacenar el valor de cada carácter 
		//leído del archivo en formato entero.
		int caracter = 0;
		try {
			//se crea un objeto FileReader llamado fr, que es una clase de Java diseñada para 
			//leer archivos de texto en modo carácter por carácter.
			FileReader fr = new FileReader(archivo);
			/*
			 * El bucle while usa fr.read() para leer el siguiente carácter del archivo.
			 * El método read() devuelve el valor entero del carácter o -1 si ha llegado al final del archivo.
			 */
			while((caracter = fr.read()) != -1) {
				/*
				 * (char)caracter convierte el valor entero del carácter en un carácter
				 *  ASCII, y System.out.print((char)caracter); lo imprime en la consola.
				 */
				System.out.print((char)caracter);
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
