package _04_lecturaYEscritura;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _02_Lectura {

	public static void main(String[] args) {
		File archivo = new File("C:\\dir1\\f1.txt");
		try {
			Scanner sc = new Scanner(archivo);
			while(sc.hasNextLine()) {
				String linea = sc.nextLine();
				System.out.println(linea);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
