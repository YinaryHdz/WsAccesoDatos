package binario;

import java.io.DataOutputStream;           
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class _01_EscribeBinario {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int codigoArticulo = 0;
		double precio = 0.0;
		
		try {
			FileOutputStream fos = new FileOutputStream("C:/dir1/articulos.dat");
			DataOutputStream dos = new DataOutputStream(fos);
			
			System.out.println("Codigo articulo: ");
			codigoArticulo = sc.nextInt();
			
			while (codigoArticulo != 0) {
				 System.out.println("Precio: ");
	              precio = sc.nextDouble();
	              dos.writeInt(codigoArticulo);
	              dos.writeDouble(precio);
	              System.out.println("Código artículo (0 para salir): ");
	              codigoArticulo = sc.nextInt();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
