package _07_aleatorio;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class _01_Ejemplo {
	static RandomAccessFile raf = null;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int entero = 0;
		try {
			raf = new RandomAccessFile("C:\\dir1\\enteros.dat", "rw");
			verDatos();
			System.out.println("Entero: " );
			entero = sc.nextInt();
			//Detecta el final del fichero
			raf.seek(raf.length());
			raf.writeInt(entero);
			verDatos();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void verDatos() {
		int numeroEntero = 0;
		try {
			raf.seek(0);
			while(true) {
				numeroEntero = raf.readInt();
				System.out.println(numeroEntero);
			}
		} catch (EOFException e) {
			System.out.println("EOF");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
