package ejercicioLecturaYEscritura;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class _01_EjercicioLecturaYEscritura {

	public static void main(String[] args) {
		/*Hacer un programa que lea el fichero de texto, “texto.txt”, y genere otro llamado
		“invertido.txt”, en el que se guardarán las frases del primero pero invertidas.
		Mostrar en pantalla el nuevo fichero.
		*/
		File archivo = new File("C:\\dir1\\texto.txt");
		int caracter = 0;
		try {
			FileReader fr = new FileReader(archivo);
			FileWriter fw = new FileWriter("C:\\dir1\\invertido.txt");
			//String builder es una clase para manipular cadenas de texto
			//tiene metodos utiles que permiten hacer todo tipo de modificaciones
			//en una cadena de texto. Evita la creacion de multiples objetos
			//como String( al ser una cadena inmutable)
			StringBuilder stringBuilder = new StringBuilder();
			while((caracter = fr.read()) != -1){
				System.out.print((char)caracter);
				stringBuilder.append((char)caracter);
			}
			
			String invertido  = stringBuilder.reverse().toString();
			fw.write(invertido);
			fw.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
