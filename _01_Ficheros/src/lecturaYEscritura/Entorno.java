package lecturaYEscritura;

import java.util.Map;

public class Entorno {

	public static void main(String[] args) {
		Map <String, String> mapa = System.getenv();
		for (Map.Entry<String, String> entry : mapa.entrySet()) {
			System.out.println("Clave: " + entry.getKey() + "\tValor: " + entry.getValue());
		}
			

	}

}
