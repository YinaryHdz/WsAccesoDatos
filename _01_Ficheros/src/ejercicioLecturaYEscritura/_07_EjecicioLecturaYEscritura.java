package ejercicioLecturaYEscritura;

import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
public class _07_EjecicioLecturaYEscritura {

	/*
	 * Escribir un programa que encripte el fichero de texto “texto.txt” generando un
	fichero de salida con los datos encriptados.
	
	La encriptación consiste en reemplazar cada carácter por el tercero siguiente en el
	alfabeto (ej. a -> d). Si el carácter es la x/y/z entonces se sustituirá por la a/b/c.
	Mostrar el fichero resultante.

	 */
	public static void main(String[] args) {
		File archivo = new File ("C:\\dir1\\texto.txt");
		String archivoSalida = "C:\\dir1\\texto_encriptado.txt";
		int caracter = 0;
		try (FileReader fr  = new FileReader(archivo);
			PrintWriter pw = new PrintWriter(archivoSalida)) {
			
		while((caracter = fr.read()) != -1) {
			 char letra = (char) caracter; 
			 pw.print(encriptarCaracter(letra));
		}
		System.out.println("Archivo encriptado creado: " + archivoSalida);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

	private static char encriptarCaracter(char caracter) {
		if(Character.isLetter(caracter)) {
			char desplazado = (char) (caracter + 3);
			if (caracter >= 'a' && caracter <= 'z') {
                if (desplazado > 'z') {
                    desplazado -= 26; 
                }
            } else if (caracter >= 'A' && caracter <= 'Z') {
                if (desplazado > 'Z') {
                    desplazado -= 26; 
                }
            }
            return desplazado;
        }
        return caracter; 

	}

}
