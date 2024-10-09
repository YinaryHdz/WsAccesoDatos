package lecturaYEscritura;

import java.io.IOException;

public class Lectura_01 {

	public static void main(String[] args) {
		int caracter = 0;
		while(true) {
			try {
				caracter = System.in.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.err.println((char)caracter);
		}

	}

}
