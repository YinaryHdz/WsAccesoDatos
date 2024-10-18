package ejercicioLecturaYEscritura;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class _06_EjercicioLecturaYEscritura          {

    public static void main(String[] args) {
        // Archivo de entrada y salida
        File archivoNumeros = new File("C:\\dir1\\numeros.txt");
        File archivoEstadistica = new File("C:\\dir1\\estadistica.txt");

        // Array para contar la frecuencia de cada número (0 al 9)
        int[] frecuencias = new int[10];  // Índices de 0 a 9 para los números

        int suma = 0;
        int totalNumeros = 0;

        try {
            // Leer el archivo numeros.txt
            Scanner sc = new Scanner(archivoNumeros);
            while (sc.hasNextInt()) {
                int numero = sc.nextInt();
                if (numero >= 0 && numero <= 9) {
                    frecuencias[numero]++;  // Incrementar la frecuencia del número
                    suma += numero;         // Sumar para la media
                    totalNumeros++;         // Contar el total de números
                }
            }
            sc.close();

            // Calcular la media
            double media = (double) suma / totalNumeros;

            // Determinar la moda
            int maxFrecuencia = 0;
            String modas = "";
            for (int i = 0; i < frecuencias.length; i++) {
                if (frecuencias[i] > maxFrecuencia) {
                    maxFrecuencia = frecuencias[i];
                    modas = Integer.toString(i);
                } else if (frecuencias[i] == maxFrecuencia && maxFrecuencia > 0) {
                    modas += " y " + i;
                }
            }

            // Escribir los resultados en estadistica.txt
            FileWriter escritor = new FileWriter(archivoEstadistica);
            for (int i = 0; i < frecuencias.length; i++) {
                escritor.write("Número " + i + " – " + frecuencias[i] + " veces\n");
            }
            escritor.write("Moda: " + modas + "\n");
            escritor.write("Media: " + String.format("%.2f", media) + "\n");
            escritor.close();

            // Mostrar en consola el contenido de estadistica.txt
            System.out.println("Fichero estadistica.txt creado correctamente con los siguientes datos:");
            for (int i = 0; i < frecuencias.length; i++) {
                System.out.println("Número " + i + " – " + frecuencias[i] + " veces");
            }
            System.out.println("Moda: " + modas);
            System.out.println("Media: " + String.format("%.2f", media));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
