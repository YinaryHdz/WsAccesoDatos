package lecturaYEscritura;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Lectura_03 {

	public static void main(String[] args) {
		File archivo = new File("C:\\dir1\\f1.txt");
		int caracter = 0;
		try {
			FileReader fr = new FileReader(archivo);
			while((caracter = fr.read()) != -1) {
				System.out.println((char)caracter);
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
