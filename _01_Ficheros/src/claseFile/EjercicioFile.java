package claseFile;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class EjercicioFile {

	private static Scanner sc = null;
	private static File elemento = null;
	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int opcion = 0;
		do {
			opcion = mostrarMenu();
			switch(opcion) {
			case 1:
				existeRuta();
			}
			
		}while(opcion != 4);

	}

	private static int mostrarMenu() {
		System.out.println("---------------BIENVENIDO-------------");
		System.out.println("En este programa vamos a trabajar con ficheros");
		System.out.println("Introduzca una opcion:");
		System.out.println("1- Comprobar ruta");
		System.out.println("2- ");
		System.out.println("3- Renombrar fichero");
		System.out.println("4- Eliminar fichero");
		System.out.println("5- Salir del programa");

		int iOpcion = recogerEntero();
		return iOpcion;
	}

	private static int recogerEntero() {
		String sOpcion = sc.nextLine();
		int iOpcion = Integer.parseInt(sOpcion);
		return iOpcion;
	}

	private static boolean existeRuta() {
		System.out.println("Introduzca la ruta que desee");
		String ruta = sc.nextLine();
		elemento = new File(ruta);
		if (elemento.exists()) {
			System.out.println("Ruta: " + elemento.getName() + " existe");
			return true;
		} else {
			System.out.println("Ruta: " + elemento.getName() + " no existe");
			return false;
		}
	}

	private static void rutaNoExiste() throws IOException {
		boolean ruta = existeRuta();
		if (ruta == false) {
			System.out.println("¿Crearlo? [S|N]");
			char respuesta = 0;
			respuesta = sc.nextLine().toUpperCase().charAt(0);
			switch (respuesta) {
			case 'S':
				System.out.println("Fichero o Directorio [F|D]: ");
				respuesta = sc.nextLine().toUpperCase().charAt(0);
				switch (respuesta) {
				case 'F':
					if(elemento.createNewFile()) {
						System.out.println("Fichero: " + elemento.getAbsolutePath() + " creado correctamente");
					}else {
						System.out.println("Fichero: " + elemento.getAbsolutePath() + " no creado correctamente");
					}
					break;
				}
				break;
			}
		}
	}

	private static void pedirRuta() {

	}

	private static void pedirElemento() {

	}

	private static void crearRuta() {

	}

}
