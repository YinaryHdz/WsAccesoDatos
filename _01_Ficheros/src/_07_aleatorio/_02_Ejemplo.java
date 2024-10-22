package _07_aleatorio;


import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class _02_Ejemplo {

	public static void main(String[] args) {
		long tamanio = 0;
		int posicion = 0;
		int entero = 0;
		Scanner sc = new Scanner(System.in);
		try {
			RandomAccessFile raf = new RandomAccessFile("C:\\dir1\\enteros.dat", "rw");
			tamanio = raf.length() / 4;
			System.out.println("Tamaño: " + tamanio);
			do {
				System.out.println("Posicion a modificar: ");
				posicion = sc.nextInt();
			}while(posicion < 1 || posicion > tamanio);
			posicion --;
			//En java se manejan 4 bytes, en la siguiente linea
			//se lee la posicion ingresada por el usuario y 
			//se le multiplican los cuatro bytes necesarios
			raf.seek(posicion * 4);
			
			System.out.println("Valor actual: " + raf.readInt());
			System.err.println("Nuevo valor: ");
			entero = sc.nextInt();
			//Sobreescribe el valor de la posicion:
			raf.seek(posicion * 4);
			raf.writeInt(entero);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
