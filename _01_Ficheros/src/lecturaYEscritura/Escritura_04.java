package lecturaYEscritura;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Escritura_04 {

	public static void main(String[] args) {
		File archivo = new File("C:\\dir1\\f5.txt");
		Scanner sc  =new Scanner(System.in);
		try {
			//Con true se evita eliminar las lineas del fichero en caso de escribir
			//nuevas lineas 
			FileWriter escritor  = new FileWriter(archivo, true);
			String linea = "";
			while(true) {
				System.out.println("Linea: ");
				linea = sc.nextLine();
				if(linea.equalsIgnoreCase("fin")) {
					break;
				}
				escritor.write(linea + "\n");
			}
			escritor.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
