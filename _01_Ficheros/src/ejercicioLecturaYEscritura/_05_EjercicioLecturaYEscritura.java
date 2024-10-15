package ejercicioLecturaYEscritura;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _05_EjercicioLecturaYEscritura {

    public static void main(String[] args) {
        /*
         * Hacer un programa que pida al usuario una palabra por teclado y diga cuántas
         * veces aparece esa palabra en el fichero "lista_palabras.txt".
         */
        
        // Ruta del archivo de texto con la lista de palabras
        File archivo = new File("C:\\dir1\\parrafo.txt");
        
        // Pedir palabra al usuario
        Scanner entradaUsuario = new Scanner(System.in);
        System.out.println("Introduce la palabra que deseas contar:");
        String palabra = entradaUsuario.nextLine();
        entradaUsuario.close();
        
        int contador = 0;

        // Leer el archivo y contar las veces que aparece la palabra
        try {
            Scanner sc = new Scanner(archivo);
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] palabras = linea.toLowerCase().split("\\s+"); 
                for (String p : palabras) {
                    if (p.equalsIgnoreCase(palabra)) { // Ignorar mayúsculas/minúsculas
                        contador++;
                    }
                }
            }
            sc.close();

            System.out.println("La palabra '" + palabra + "' aparece: " + contador + " veces");

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + archivo.getAbsolutePath());
            e.printStackTrace();
        }
    }
}

