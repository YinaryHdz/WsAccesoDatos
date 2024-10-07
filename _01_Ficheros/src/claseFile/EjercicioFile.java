package claseFile;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class EjercicioFile {

    private static Scanner sc = null;
    private static File elemento;

    public static void main(String[] args) throws IOException {
        sc = new Scanner(System.in);

        int opcion = 0;
        do {
            opcion = mostrarMenu();
            switch (opcion) {
                case 1:
                    existeRuta();
                    break;
                case 2:
                    crearRuta();
                    break;
                case 3:
                    comprobarSiElementoExiste();
                    break;
                case 4:
                    crearElementoEnLaRuta();
                    break;
                case 5:
                    opcion = menuPermisos();
                    switch (opcion) {
                        case 1:
                            soloLectura();
                            break;
                        case 2:
                            escritura();
                            break;
                        case 3:
                            ejecutable();
                            break;
                        default:
                            System.out.println("Opción inválida.");
                            break;
                    }
                    break;
                case 6:
                    System.out.println("Gracias por usar nuestro programa!!!! Hasta pronto");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, introduzca una opción correcta.");
                    break;
            }
        } while (opcion != 6);
    }

    private static int mostrarMenu() {
        System.out.println("---------------BIENVENIDO-------------");
        System.out.println("En este programa vamos a trabajar con ficheros");
        System.out.println("Introduzca una opción:");
        System.out.println("1- Comprobar ruta");
        System.out.println("2- Crear ruta");
        System.out.println("3- Comprobar si un elemento existe dentro de una ruta");
        System.out.println("4- Crear elemento en la ruta");
        System.out.println("5- Modificar los permisos del elemento");
        System.out.println("6- Salir del programa");

        return recogerEntero();
    }

    private static int recogerEntero() {
        while (true) {
            try {
                String sOpcion = sc.nextLine();
                return Integer.parseInt(sOpcion);
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduzca un número válido.");
            }
        }
    }

    private static boolean existeRuta() {
        System.out.println("Introduzca la ruta que desee");
        String ruta = sc.nextLine();
        elemento = new File(ruta);
        if (elemento.exists()) {
            System.out.println("Ruta: " + elemento.getAbsolutePath() + " existe");
            return true;
        } else {
            System.out.println("Ruta: " + elemento.getAbsolutePath() + " no existe");
            return false;
        }
    }

    private static void crearRuta() throws IOException {
        if (!existeRuta()) {
            System.out.println("¿Desea crearlo? [S|N]");
            char respuesta = sc.nextLine().toUpperCase().charAt(0);
            if (respuesta == 'S') {
                System.out.println("¿Fichero o Directorio? [F|D]: ");
                respuesta = sc.nextLine().toUpperCase().charAt(0);
                switch (respuesta) {
                    case 'F':
                        if (elemento.createNewFile()) {
                            System.out.println("Fichero creado correctamente en: " + elemento.getAbsolutePath());
                        } else {
                            System.out.println("No se pudo crear el fichero.");
                        }
                        break;
                    case 'D':
                        if (elemento.mkdir()) {
                            System.out.println("Directorio creado correctamente en: " + elemento.getAbsolutePath());
                        } else {
                            System.out.println("No se pudo crear el directorio.");
                        }
                        break;
                    default:
                        System.out.println("Opción no válida. Elija 'F' o 'D'.");
                        break;
                }
            } else {
                System.out.println("Ha elegido no crear la ruta.");
            }
        } else {
            System.out.println("La ruta ya existe.");
        }
    }

    private static void comprobarSiElementoExiste() {
        System.out.println("Introduzca la ruta del elemento a comprobar:");
        String ruta = sc.nextLine();
        elemento = new File(ruta);
        if (elemento.exists()) {
            System.out.println("Elemento: " + elemento.getName() + " existe.");
        } else {
            System.out.println("Elemento: " + elemento.getName() + " no existe.");
        }
    }

    private static void crearElementoEnLaRuta() throws IOException {
        if (!existeRuta()) {
            System.out.println("¿Desea crear el elemento? [S|N]");
            char respuesta = sc.nextLine().toUpperCase().charAt(0);
            if (respuesta == 'S') {
                System.out.println("¿Fichero o Directorio? [F|D]: ");
                respuesta = sc.nextLine().toUpperCase().charAt(0);
                switch (respuesta) {
                    case 'F':
                        if (elemento.createNewFile()) {
                            System.out.println("Fichero creado correctamente.");
                        } else {
                            System.out.println("No se pudo crear el fichero.");
                        }
                        break;
                    case 'D':
                        if (elemento.mkdir()) {
                            System.out.println("Directorio creado correctamente.");
                        } else {
                            System.out.println("No se pudo crear el directorio.");
                        }
                        break;
                    default:
                        System.out.println("Opción no válida. Elija 'F' o 'D'.");
                        break;
                }
            } else {
                System.out.println("Ha elegido no crear el elemento.");
            }
        } else {
            System.out.println("La ruta ya existe.");
        }
    }

    private static int menuPermisos() {
        System.out.println("Modificar permisos del elemento:");
        System.out.println("1- Lectura");
        System.out.println("2- Escritura");
        System.out.println("3- Ejecución");
        return recogerEntero();
    }

    private static void soloLectura() {
        System.out.println("Introduzca la ruta del elemento a modificar:");
        String ruta = sc.nextLine();
        elemento = new File(ruta);
        if (elemento.setReadOnly()) {
            System.out.println("El elemento ahora es solo de lectura.");
        } else {
            System.out.println("No se pudo cambiar el permiso a solo lectura.");
        }
    }

    private static void escritura() {
        System.out.println("Introduzca la ruta del elemento a modificar:");
        String ruta = sc.nextLine();
        elemento = new File(ruta);
        if (elemento.setWritable(true)) {
            System.out.println("El elemento ahora tiene permisos de escritura.");
        } else {
            System.out.println("No se pudo cambiar el permiso de escritura.");
        }
    }

    private static void ejecutable() {
        System.out.println("Introduzca la ruta del elemento a modificar:");
        String ruta = sc.nextLine();
        elemento = new File(ruta);
        if (elemento.setExecutable(true)) {
            System.out.println("El elemento ahora tiene permisos de ejecución.");
        } else {
            System.out.println("No se pudo cambiar el permiso de ejecución.");
        }
    }
}
