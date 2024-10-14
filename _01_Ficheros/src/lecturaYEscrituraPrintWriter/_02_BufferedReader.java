package lecturaYEscrituraPrintWriter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class _02_BufferedReader {

	public static void main(String[] args) {
		String rutaArchivo = "C:\\dir1\\f5.txt";
		try {
			BufferedReader lecturaBuffer = new BufferedReader (new FileReader(rutaArchivo));
			String linea = "";
			while((linea = lecturaBuffer.readLine()) != null) {
				System.out.println(linea);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
