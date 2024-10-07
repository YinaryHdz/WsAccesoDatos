package listarFile;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class EjercicioListar {
	private static File file;
	private static Scanner sc = null;
	public static void main(String[] args) throws IOException {
		   sc = new Scanner(System.in);
		   int opcion = 0;
	        do {
	            opcion = mostrarMenu();
	            switch (opcion) {
	                case 1:
	                    crearElemento();
	                    break;
	                case 2:
	                    buscarFicheroTxt();
	                    break;
	                case 3:
	                    buscarFicheroDocx();
	                    break;
	                case 4:
	                	buscarFicheroXlsx();
	                    break;
	                case 5:
	                	buscarTamañoMayor1Kb();
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
	 private static void buscarTamañoMayor1Kb() {
		// TODO Auto-generated method stub
		
	}
	private static void buscarFicheroXlsx() throws IOException {
		File file  = new File(crearElemento());
		File [] lista = file.listFiles((d,name) -> name.endsWith(".xlsx"));
		for(File fich : lista) {
			//Muestra en una lista los elementos terminados en txt que hay en dir1     
			System.out.println("Elemento: " + fich.toString());
		}
		
	}
	private static void buscarFicheroDocx() throws IOException {
		File file  = new File(crearElemento());
		File [] lista = file.listFiles((d,name) -> name.endsWith(".docx"));
		for(File fich : lista) {
			//Muestra en una lista los elementos terminados en txt que hay en dir1     
			System.out.println("Elemento: " + fich.toString());
		}
		
	}
	private static void buscarFicheroTxt() throws IOException {
		File file  = new File(crearElemento());
		File [] lista = file.listFiles((d,name) -> name.endsWith(".txt"));
		for(File fich : lista) {
			//Muestra en una lista los elementos terminados en txt que hay en dir1     
			System.out.println("Elemento: " + fich.toString());
		}
	}
	private static int mostrarMenu() {
	        System.out.println("---------------BIENVENIDO-------------");
	        System.out.println("En este programa vamos a trabajar con elementos de un fichero");
	        System.out.println("Introduzca una opción:");
	        System.out.println("1- Crear elemento");
	        System.out.println("2- Buscar elementos txt");
	        System.out.println("3- Buscar elementos docx");
	        System.out.println("4- Buscar elementos xlsx");
	        System.out.println("5- Tamaño mayor a 1kb");
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
	    
	    private static String crearElemento() throws IOException {
	        System.out.println("Introduzca la ruta donde se va a crear");
	        String ruta = sc.nextLine();
	        file = new File(ruta);
	        System.out.println("¿Desea crearlo? [S|N]");
            char respuesta = sc.nextLine().toUpperCase().charAt(0);
            if (respuesta == 'S') {
                System.out.println("¿Fichero o Directorio? [F|D]: ");
                respuesta = sc.nextLine().toUpperCase().charAt(0);
                switch (respuesta) {
                    case 'F':
                        if (file.createNewFile()) {
                            System.out.println("Fichero creado correctamente en: " + file.getAbsolutePath());
                        } else {
                            System.out.println("No se pudo crear el fichero.");
                        }
                        break;
                    case 'D':
                        if (file.mkdir()) {
                            System.out.println("Directorio creado correctamente en: " + file.getAbsolutePath());
                        } else {
                            System.out.println("No se pudo crear el directorio.");
                        }
                        break;
                    default:
                        System.out.println("Opción no válida. Elija 'F' o 'D'.");
                        break;
                }
            }
            return ruta;
	    }

}
