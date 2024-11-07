package Serializar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Funcionalidad {

	static List<Serializar>nadadores = new ArrayList<Serializar>();
	public static void main(String[] args) {
	     Scanner scanner = new Scanner(System.in);

	        System.out.println("Bienvenido al gestor de club de natación.");

	        String directorio;
	        System.out.println("Ruta absoluta del directorio: ");
	        directorio = scanner.nextLine();

	        // Preguntar al usuario de dónde cargar los datos
	        System.out.println("Seleccione de dónde cargar los datos:");
	        System.out.println("1. Cargar desde archivo de texto (nadadores.txt)");
	        System.out.println("2. Cargar desde archivo de objetos (nadadores.obj)");
	        System.out.println("3. Cargar desde archivo binario (nadadores.dat)");
	        System.out.println("4. Cargar desde archivo NIO (nadadores.nio)");
	        System.out.println("5. Salir");
	        System.out.print("Elija una opción (1/2/3/4/5): ");
	        int opcion = scanner.nextInt();
	        scanner.nextLine(); // Consumir el salto de línea

	        switch (opcion) {
	            case 1:
	                cargarNadadoresDeFicheroTexto(directorio);
	                break;
	            case 2:
	                cargarNadadoresDeFicheroObjetos(directorio);
	                break;
	            case 3:
	                cargarNadadoresDeFicheroBinario(directorio);
	                break;
	            case 4:
	                cargarNadadoresDeFicheroNIO(directorio);
	                break;
	            case 5:
	                System.out.println("Saliendo del programa.");
	                scanner.close();
	                System.exit(0);
	            default:
	                System.out.println("Opción no válida. Saliendo del programa.");
	                scanner.close();
	                System.exit(1);
	        }

	        while (true) {
	            System.out.println("Menú:");
	            System.out.println("1. Agregar nadador");
	            System.out.println("2. Ver nadadores");
	            System.out.println("3. Modificar nadador");
	            System.out.println("4. Guardar datos en archivo");
	            System.out.println("5. Salir");
	            System.out.print("Seleccione una opción (1/2/3/4/5): ");
	            opcion = scanner.nextInt();
	            scanner.nextLine(); // Consumir el salto de línea

	            switch (opcion) {
	                case 1:
	                    System.out.println("Nombre: ");
	                    String nombre = scanner.nextLine();
	                    System.out.println("NIF: ");
	                    String nif = scanner.nextLine();
	                    System.out.println("Fecha de nacimiento (dd-mm-aaaa): ");
	                    String fechaNacimiento = scanner.nextLine();
	                    System.out.println("Peso (kg): ");
	                    double peso = scanner.nextDouble();
	                    System.out.println("Altura (cm): ");
	                    int altura = scanner.nextInt();
	                    scanner.nextLine(); // Consumir el salto de línea

	                    Serializar nuevoNadador = new Serializar(nombre, nif, fechaNacimiento, peso, altura);
	                    nadadores.add(nuevoNadador);
	                    System.out.println("Nadador agregado con éxito.");
	                    break;
	                case 2:
	                    System.out.println("Lista de nadadores:");
	                    for (Serializar nadador : nadadores) {
	                        System.out.println(nadador);
	                    }
	                    break;
	                case 3:
	                    System.out.println("Ingrese el NIF del nadador que desea modificar: ");
	                    String nifModificar = scanner.nextLine();
	                    modificarNadador(nifModificar);
	                    break;
	                case 4:
	                    System.out.println("Ruta absoluta del directorio: ");
	                    directorio = scanner.nextLine();
	                    // Preguntar al usuario dónde guardar los datos
	                    System.out.println("Seleccione dónde guardar los datos:");
	                    System.out.println("1. Guardar en archivo de texto (nadadores.txt)");
	                    System.out.println("2. Guardar en archivo de objetos (nadadores.obj)");
	                    System.out.println("3. Guardar en archivo binario (nadadores.dat)");
	                    System.out.println("4. Guardar en archivo con NIO (nadadores.nio)");
	                    System.out.println("5. Salir");
	                    System.out.print("Elija una opción (1/2/3/4/5): ");
	                    int opcionGuardar = scanner.nextInt();
	                    scanner.nextLine(); // Consumir el salto de línea

	                    switch (opcionGuardar) {
	                        case 1:
	                            guardarNadadoresAFicheroTexto(directorio);
	                            break;
	                        case 2:
	                            guardarNadadoresAFicheroObjetos(directorio);
	                            break;
	                        case 3:
	                            guardarNadadoresAFicheroBinario(directorio);
	                            break;
	                        case 4:
	                            guardarNadadoresAFicheroNIO(directorio);
	                            break;
	                        case 5:
	                            System.out.println("Saliendo del programa.");
	                            scanner.close();
	                            System.exit(0);
	                        default:
	                            System.out.println("Opción no válida.");
	                    }
	                    System.out.println("Datos guardados en archivo.");
	                    break;
	                case 5:
	                    System.out.println("Saliendo del programa.");
	                    scanner.close();
	                    System.exit(0);
	                default:
	                    System.out.println("Opción no válida.");
	            }
	        }
	        
	    }

	private static void guardarNadadoresAFicheroNIO(String directorio) {
		Path rutaArchivo = Paths.get(directorio, "nadadores.nio");

        // Usar Files.newBufferedWriter para escribir los datos
        try (BufferedWriter writer = Files.newBufferedWriter(rutaArchivo)) {  // No especificamos codificación
            // Escribir la cabecera (opcional, dependiendo de cómo quieras estructurar el archivo)
            writer.write("Nombre,NIF,FechaNacimiento,Peso,Altura");
            writer.newLine();  // Nueva línea después de la cabecera
            
            // Recorrer la lista de nadadores y escribir sus atributos en el archivo
            for (Serializar nadador : nadadores) {
                // Escribir los datos de cada nadador en formato CSV
                writer.write(nadador.toCsv());
                writer.newLine();  // Nueva línea después de cada nadador
            }
            System.out.println("Nadadores guardados con éxito en el archivo NIO.");
        } catch (IOException e) {
            System.out.println("Error al guardar los nadadores en el archivo NIO: " + e.getMessage());
        }
		
	}

	private static void guardarNadadoresAFicheroBinario(String directorio) {
		// Definir la ruta del archivo binario
        String rutaArchivo = directorio + "/nadadores.dat";  // Ruta completa del archivo

        // Intentar guardar los datos en el archivo binario
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(rutaArchivo))) {
            // Recorrer la lista de nadadores y escribir sus datos
            for (Serializar nadador : nadadores) {
                dos.writeUTF(nadador.getNombre());           // Escribir el nombre como cadena
                dos.writeUTF(nadador.getNif());              // Escribir el NIF como cadena
                dos.writeUTF(nadador.getFechaNacimiento());  // Escribir la fecha de nacimiento como cadena
                dos.writeDouble(nadador.getPeso());          // Escribir el peso como valor double
                dos.writeInt(nadador.getAltura());           // Escribir la altura como valor entero
            }
            System.out.println("Nadadores guardados con éxito en el archivo binario.");
        } catch (IOException e) {
            System.out.println("Error al guardar los nadadores en el archivo binario: " + e.getMessage());
        }

		
	}

	private static void guardarNadadoresAFicheroObjetos(String directorio) {
		// Definir la ruta del archivo donde se guardarán los objetos
        String rutaArchivo = directorio + "/nadadores.obj";  // Ruta completa del archivo

        // Intentar guardar los objetos en el archivo
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            // Escribir la lista de nadadores en el archivo
            oos.writeObject(nadadores);  // Guardar la lista completa de nadadores
            System.out.println("Nadadores guardados con éxito en el archivo de objetos.");
        } catch (IOException e) {
            System.out.println("Error al guardar los nadadores en el archivo de objetos: " + e.getMessage());
        }
		
	}

	private static void guardarNadadoresAFicheroTexto(String directorio) {
		 // Definir el archivo completo con su ruta
        String rutaArchivo = directorio + "/nadadores.txt";  // Ruta absoluta o relativa dependiendo del directorio

        // Usar BufferedWriter para escribir en el archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            // Recorrer la lista de nadadores y escribir sus datos en el archivo
            for (Serializar nadador : nadadores) {
                writer.write(nadador.toCsv());  // Escribir los datos del nadador en formato CSV
                writer.newLine();  // Añadir un salto de línea después de cada nadador
            }
            System.out.println("Nadadores guardados con éxito en el archivo de texto.");
        } catch (IOException e) {
            System.out.println("Error al guardar los nadadores en el archivo de texto: " + e.getMessage());
        }
		
	}

	private static void modificarNadador(String nifModificar) {
		// Buscar el nadador en la lista por su NIF
        Serializar nadadorEncontrado = null;
        for (Serializar nadador : nadadores) {
            if (nadador.getNif().equals(nifModificar)) {
                nadadorEncontrado = nadador;
                break;
            }
        }

        if (nadadorEncontrado == null) {
            System.out.println("No se encontró un nadador con el NIF: " + nifModificar);
            return;
        }

        // Si el nadador fue encontrado, pedir nuevos datos al usuario
        Scanner scanner = new Scanner(System.in);

        System.out.println("Modificar datos del nadador: " + nadadorEncontrado.getNombre());

        // Pedir nuevos datos al usuario
        System.out.print("Nuevo nombre (actual: " + nadadorEncontrado.getNombre() + "): ");
        String nuevoNombre = scanner.nextLine();

        System.out.print("Nuevo NIF (actual: " + nadadorEncontrado.getNif() + "): ");
        String nuevoNif = scanner.nextLine();

        System.out.print("Nueva fecha de nacimiento (actual: " + nadadorEncontrado.getFechaNacimiento() + "): ");
        String nuevaFechaNacimiento = scanner.nextLine();

        System.out.print("Nuevo peso (actual: " + nadadorEncontrado.getPeso() + " kg): ");
        double nuevoPeso = scanner.nextDouble();

        System.out.print("Nueva altura (actual: " + nadadorEncontrado.getAltura() + " cm): ");
        int nuevaAltura = scanner.nextInt();

        // Actualizar los datos del nadador
        nadadorEncontrado.setNombre(nuevoNombre);
        nadadorEncontrado.setNif(nuevoNif);
        nadadorEncontrado.setFechaNacimiento(nuevaFechaNacimiento);
        nadadorEncontrado.setPeso(nuevoPeso);
        nadadorEncontrado.setAltura(nuevaAltura);

        System.out.println("Datos del nadador modificados con éxito.");
		
	}

	private static void cargarNadadoresDeFicheroNIO(String directorio) {
		Path rutaArchivo = Paths.get(directorio, "nadadores.nio");  // Ruta del archivo

        // Verificar si el archivo existe
        if (Files.notExists(rutaArchivo)) {
            System.out.println("El archivo no existe: " + rutaArchivo.toString());
            return;
        }

        try {
            // Leer todas las líneas del archivo
            List<String> lineas = Files.readAllLines(rutaArchivo);
            
            // Procesar cada línea del archivo
            for (String linea : lineas) {
                // Dividir la línea en partes utilizando la coma como delimitador
                String[] partes = linea.split(",");
                
                if (partes.length == 5) {  // Asegurarnos de que haya exactamente 5 campos
                    String nombre = partes[0].trim();
                    String nif = partes[1].trim();
                    String fechaNacimiento = partes[2].trim();
                    double peso = Double.parseDouble(partes[3].trim());
                    int altura = Integer.parseInt(partes[4].trim());

                    // Crear un objeto Nadador y agregarlo a la lista
                    Serializar nadador = new Serializar(nombre, nif, fechaNacimiento, peso, altura);
                    nadadores.add(nadador);
                } else {
                    System.out.println("Error en el formato de la línea: " + linea);
                }
            }
            System.out.println("Nadadores cargados exitosamente desde el archivo NIO.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo NIO: " + e.getMessage());
        }
		
	}

	private static void cargarNadadoresDeFicheroBinario(String directorio) {
		File archivo = new File(directorio, "nadadores.dat");  // Ruta del archivo binario

        if (!archivo.exists()) {
            System.out.println("El archivo no existe: " + archivo.getAbsolutePath());
            return;
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream(archivo))) {
            // Leer el archivo binario
            while (dis.available() > 0) {
                // Leer los datos del nadador de forma secuencial
                String nombre = dis.readUTF();  // Lee una cadena de texto (UTF-8)
                String nif = dis.readUTF();     // Lee una cadena de texto (UTF-8)
                String fechaNacimiento = dis.readUTF();  // Lee una cadena de texto (UTF-8)
                double peso = dis.readDouble();  // Lee un valor de tipo double
                int altura = dis.readInt();     // Lee un valor de tipo int

                // Crear el objeto Nadador y agregarlo a la lista
                Serializar nadador = new Serializar(nombre, nif, fechaNacimiento, peso, altura);
                nadadores.add(nadador);
            }
            System.out.println("Nadadores cargados exitosamente desde el archivo binario.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo binario: " + e.getMessage());
        }
    }
		
	

	private static void cargarNadadoresDeFicheroObjetos(String directorio) {
		 File archivo = new File(directorio, "nadadores.obj"); 

	        if (!archivo.exists()) {
	            System.out.println("El archivo no existe: " + archivo.getAbsolutePath());
	            return;
	        }

	        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
	            // Leer hasta que se terminen los objetos en el archivo
	            while (true) {
	                try {
	                    Serializar nadador = (Serializar) ois.readObject();  // Leer un objeto Nadador
	                    nadadores.add(nadador);  // Añadir el nadador a la lista
	                } catch (IOException e) {
	                    // Fin de archivo alcanzado
	                    break;
	                }
	            }
	            System.out.println("Nadadores cargados exitosamente desde el archivo de objetos.");

	        } catch (IOException | ClassNotFoundException e) {
	            System.out.println("Error al leer el archivo de objetos: " + e.getMessage());
	        }
		
	}

	private static void cargarNadadoresDeFicheroTexto(String directorio) {

		File archivo = new File(directorio, "nadadores.txt");
        if (!archivo.exists()) {
            System.out.println("El archivo no existe: " + archivo.getAbsolutePath());
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            
            // Leer línea por línea
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                
                if (partes.length == 5) {
                    String nombre = partes[0].trim();
                    String nif = partes[1].trim();
                    String fechaNacimiento = partes[2].trim();
                    double peso = Double.parseDouble(partes[3].trim());
                    int altura = Integer.parseInt(partes[4].trim());

                    Serializar nadador = new Serializar(nombre, nif, fechaNacimiento, peso, altura);
                    nadadores.add(nadador);
                } else {
                    System.out.println("Formato incorrecto en línea: " + linea);
                }
            }
            
            System.out.println("Nadadores cargados exitosamente desde el archivo de texto.");
            
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error en el formato de datos numéricos: " + e.getMessage());
        }
		
	}

	

}
