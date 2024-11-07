package ficherosTexto;

import java.io.IOException;

public class _01_Lectura {

	public static void main(String[] args) {
		/*
		 * Este código está escrito en Java y realiza la lectura de caracteres 
		 * desde la entrada estándar (System.in). 
		 */
		int caracter = 0;
		/*
		 * El bucle while(true) es un bucle infinito que seguirá ejecutándose hasta 
		 * que el programa se cierre o se interrumpa manualmente. Esto significa que 
		 * el programa leerá caracteres de forma continua.
		 */
		while(true) {
			try {
				/*
				 * Lee el próximo byte de datos desde la entrada (generalmente el teclado) y lo devuelve como un valor entero.
				 */
				caracter = System.in.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*
			 *  convierte el valor entero almacenado en caracter en un carácter usando (char)caracter 
			 *  y luego lo imprime en la salida de error estándar (también generalmente la consola).
			 *  En este caso, se usa System.err.println para imprimir cada carácter leído.
			 */
			System.err.println((char)caracter);
		}

	}

}
