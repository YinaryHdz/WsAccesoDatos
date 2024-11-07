package ficherosTexto;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class _04_Escritura {

	public static void main(String[] args) {
		File archivo = new File("C:\\dir1\\f5.txt");
		Scanner sc  =new Scanner(System.in);
		try {
			//Con true se evita eliminar las lineas del fichero en caso de escribir
			//nuevas lineas       
			FileWriter escritor  = new FileWriter(archivo, true);
			//Declara una variable linea para almacenar la línea ingresada por el usuario.
			String linea = "";
			while(true) {
				System.out.println("Linea: ");
				linea = sc.nextLine();
				//La condición if(linea.equalsIgnoreCase("fin")) verifica si el usuario 
				//ha ingresado "fin" (sin importar si usa mayúsculas o minúsculas). Si es así, el bucle se detiene.
				if(linea.equalsIgnoreCase("fin")) {
					break;
				}
				//añade un salto de línea (\n) al final para que cada entrada aparezca en una nueva línea en el archivo.
				escritor.write(linea + "\n");
			}
			escritor.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
