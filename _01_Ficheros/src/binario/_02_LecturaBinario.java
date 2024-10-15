package binario;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;


public class _02_LecturaBinario {

	public static void main(String[] args) {
		FileInputStream fis;
		try {
			fis = new FileInputStream("C:/dir1/articulos.dat");
			DataInputStream dis = new DataInputStream(fis);
			while(dis.available() > 0) {
				int codigoArticulo = dis.readInt();
				double precio = dis.readDouble();
				System.out.println("Articulo: " + codigoArticulo + "\tPrecio: " + precio);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
