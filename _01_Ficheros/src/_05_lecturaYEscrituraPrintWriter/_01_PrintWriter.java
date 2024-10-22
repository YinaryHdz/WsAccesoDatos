package _05_lecturaYEscrituraPrintWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class _01_PrintWriter {

	public static void main(String[] args) {
		String rutaArchivo = "C:\\dir1\\f5.txt";
		Scanner sc  = new Scanner (System.in);
		
		try {
			PrintWriter writer = new PrintWriter(new FileWriter(rutaArchivo));
			System.out.print("Nombre: ");
			String nombre = sc.nextLine();
			System.out.print("Edad: ");
			int edad = sc.nextInt();
			System.out.print("Salario: ");
			double salario  = sc.nextDouble();
			writer.println("Datos del usuario: ");
			writer.println("Nombre: " +nombre);
			writer.println("Edad: " +edad);
			writer.println("Salario: " +salario);
			
			writer.close();
			sc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
