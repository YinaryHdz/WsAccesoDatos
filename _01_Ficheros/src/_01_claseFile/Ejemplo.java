package _01_claseFile;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ejemplo {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		char respuesta= 0;
		File elemento = new File("C:\\dir1\\fich1");
		if(elemento.exists()) {
			System.out.println("Elemento: " +elemento.getName() + " existe");
		}else {
			System.out.println("Elemento: " +elemento.getName() + " no existe");
			System.out.println("¿Crearlo? [S|N]");
			respuesta = sc.nextLine().toUpperCase().charAt(0);
			switch(respuesta) {
			case 'S':
				System.out.println("Fichero o Directorio [F|D]: ");
				respuesta = sc.nextLine().toUpperCase().charAt(0);
				switch(respuesta) {
				case 'F':
					if(elemento.createNewFile()) {
						System.out.println("Fichero: " + elemento.getAbsolutePath() + " creado correctamente");
					}else {
						System.out.println("Fichero: " + elemento.getAbsolutePath() + " no creado correctamente");
					}
					break;
				}
				break;
			case 'N':
				break;
			}
			             
		}

	}

}
