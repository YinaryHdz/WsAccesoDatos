package lecturaYEscrituraPrintWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class _03_BufferedWriter {

	public static void main(String[] args) {
		String rutaArchivo = "C:\\dir1\\f5.txt";
		try {
			BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaArchivo, true));
			escritor.write("ola k ase \n");
			escritor.write("na de na \n ");
			escritor.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
