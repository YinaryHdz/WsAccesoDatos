package ejercicioLecturaYEscritura;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class _03_EjercicioLecturaYEscritura {

    public static void main(String[] args) {
        /*
         * Realizar un programa que cuente el número de líneas, caracteres y palabras
         * que tiene un fichero que se pasará por teclado. Se debe comprobar que el
         * fichero existe antes de empezar a contar.
         */

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la ruta del fichero que desea visualizar:");
        String ruta = sc.nextLine();
        File fichero = new File(ruta);

        int contadorLineas = 0;
        int contadorCaracteres = 0;
        int contadorPalabras = 0;

        if (fichero.exists()) {
            try (Scanner fileScanner = new Scanner(new FileReader(fichero))) {
                while (fileScanner.hasNextLine()) {
                    String lineaActual = fileScanner.nextLine(); // Lee la línea actual
                    contadorLineas++; 

                    // Contar los caracteres de la línea
                    contadorCaracteres += lineaActual.length();

                    // Contar palabras en la línea
                    String[] palabras = lineaActual.trim().split("\\s+");
                    contadorPalabras += palabras.length; 
                }

                System.out.println("Cantidad de líneas: " + contadorLineas);
                System.out.println("Cantidad de caracteres: " + contadorCaracteres);
                System.out.println("Cantidad de palabras: " + contadorPalabras);

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("El archivo no existe.");
        }

        sc.close(); 
    }
}
