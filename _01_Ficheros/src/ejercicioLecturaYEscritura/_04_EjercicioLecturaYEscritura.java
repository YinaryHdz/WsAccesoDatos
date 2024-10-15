package ejercicioLecturaYEscritura;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class _04_EjercicioLecturaYEscritura {

    public static void main(String[] args) {
        /*
         * Hacer un programa que modifique el fichero “texto.txt”, insertando un * delante de
         * cada vocal. Guardar el resultado en “texto_modificado.txt”.
         * Ejemplo :
         * Inicialmente Texto.txt: Voy a hacer una prueba
         * Finalmente Texto_modificado.txt: V*oy *a h*ac*er *un*a pr*u*eb*a
         */
        File archivo = new File("C:\\dir1\\texto.txt");
        File archivoModificado = new File("C:\\dir1\\texto_modificado.txt"); // Nuevo archivo para guardar resultados

        try (Scanner sc = new Scanner(archivo)) {
            String contenidoModificado = ""; 

            // Leer cada línea del archivo
            while (sc.hasNextLine()) {
                String lectura = sc.nextLine();
                String resultado = ""; 

                for (int i = 0; i < lectura.length(); i++) {
                    char letra = lectura.charAt(i);
                    // Comprobar si la letra es una vocal
                    if ("aeiouAEIOU".indexOf(letra) != -1) {
                        resultado += "*" + letra; // Agregar asterisco antes de la vocal
                    } else {
                        resultado += letra; // Agregar letra sin cambios
                    }
                }

                contenidoModificado += resultado + System.lineSeparator(); // Agregar la línea modificada
            }

            
            try (FileWriter escritor = new FileWriter(archivoModificado)) { 
                escritor.write(contenidoModificado); 
            }

            System.out.println("Contenido modificado del archivo:");
            System.out.println(contenidoModificado); 

        } catch (IOException e) {
            System.out.println("Ocurrió un error al acceder al archivo:");
            e.printStackTrace();
        }
    }
}
