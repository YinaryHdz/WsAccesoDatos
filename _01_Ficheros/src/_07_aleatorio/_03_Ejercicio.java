package _07_aleatorio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class _03_Ejercicio {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String linea = "";
		String palabra = "";
		RandomAccessFile raf = new RandomAccessFile("C:\\dir1\\f5.txt", "rw");
		System.out.println("Palabra: ");
		palabra = sc.nextLine();
		while ((linea = raf.readLine()) != null){
			raf.seek(raf.getFilePointer() - linea.length() -1);
			raf.writeBytes(cambiaLinea( linea, palabra) + "\n");
		}

	}

	private static String cambiaLinea(String linea, String palabra) {
		StringBuilder auxSB = new StringBuilder(linea);
		int indice = 0;
		indice  =auxSB.indexOf(palabra);
		while ( indice != -1) {
			//Desde indice, hasta el inidice mas la longitud de la palabra y
			//lo reemplaza por la palabra en mayuscula 
			auxSB.replace(indice, indice + palabra.length(), palabra.toUpperCase());
			indice =auxSB.indexOf(palabra);
		}
		return auxSB.toString();
		
		
	}

}
