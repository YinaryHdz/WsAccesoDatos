package ejercicioBinarios;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class _02_Ejercicio {
	static Scanner sc;
	public static void main(String[] args) {
		/**
		 * Escribir un programa Java que permita crear secuencialmente un fichero 
		 * binario que contenga la información de varias personas. Para cada persona 
		 * se almacenará: nombre, apellido1, apellido2 y año de nacimiento. El nombre 
		 * y los apellidos tendrán 20 caracteres rellenando con espacios al final para 
		 * completar la longitud.
		 */
		sc = new Scanner(System.in);
		String nombre = "";
		String apellido1 = "";
		String apellido2 = "";
		int anioNacimiento = 0;
		int opcionUsuario = 0;
		

		try {
			FileOutputStream fos = new FileOutputStream("C:/dir1/persona.dat");
			DataOutputStream dos = new DataOutputStream(fos);
			System.out.println("Vamos a introducir los datos de una persona");
			do {
				opcionUsuario = menu();
				sc.nextLine();
				switch(opcionUsuario) {
				case 1:
					System.out.println("Nombre: ");
					nombre = sc.nextLine();
					nombre = agregarCaracteres(nombre);
					dos.writeUTF(nombre);
					
					System.out.println("Apellido 1: ");
					apellido1 = sc.nextLine();
					apellido1 = agregarCaracteres(apellido1);
					dos.writeUTF(apellido1);
					
					System.out.println("Apellido 2 : ");
					apellido2 = sc.nextLine();
					apellido2 = agregarCaracteres(apellido2);
					dos.writeUTF(apellido2);
					
					System.out.println("Año de nacimiento: ");
					anioNacimiento = sc.nextInt();
					dos.writeInt(anioNacimiento);
					break;
				case 2: 
					System.out.println("Saliendo del programa ");
					break;
				default:
					System.out.println("Opcion no valida");
				}
			}while(opcionUsuario != 2);
			
			dos.close();
			fos.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static int menu () {
		int opcion = 0;
		System.out.println("Elija una opciòn: ");
		System.out.println("1. Introducir una persona");
		System.out.println("2. Salir del programa");
		opcion = sc.nextInt();
		return opcion;
		
	}
	public static String agregarCaracteres(String texto) {
		if(texto.length() < 20) {
			return String.format("%-20s", texto);
		}else if (texto.length() > 20 ) {
			return texto.substring(0, 20);
		}
		return texto;
	}

}
