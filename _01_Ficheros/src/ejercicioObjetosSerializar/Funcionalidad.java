package ejercicioObjetosSerializar;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Funcionalidad {

	static Scanner sc = new Scanner(System.in);
	static ArrayList<AgendaTelefonica>RegistroAgenda = new ArrayList<AgendaTelefonica>();
	public static void main(String[] args) {
		int opcion = 0;
		cargarAgenda();
		do {
			opcion = mostrarMenu();
			switch (opcion){
			case 1:
				darDeAlta();
				break;
			case 2:
				buscarPersona();
				break;
			case 3:
				modificarDatos();
				break;
			case 4:
				eliminarPersona();
				break;
			default:
				System.out.println("Elija una opcion valida");
				break;
			}
			
		}while (opcion != 5);

		 guardarAgenda(); // Guardar agenda completa al salir
	     System.out.println("Programa finalizado. Agenda guardada.");
	}
	
	private static void eliminarPersona() {
		System.out.println("Ingrese el nombre de la persona a eliminar:");
        String nombre = sc.nextLine();
        
        System.out.println("Ingrese los apellidos de la persona a eliminar:");
        String apellidos = sc.nextLine();

        boolean encontrado = false;
        Iterator<AgendaTelefonica> iterator = RegistroAgenda.iterator();
        
        while (iterator.hasNext()) {
            AgendaTelefonica contacto = iterator.next();
            if (contacto.getNombre().equalsIgnoreCase(nombre) && contacto.getApellidos().equalsIgnoreCase(apellidos)) {
                encontrado = true;
                iterator.remove();  
                guardarEnEliminados(contacto);  // Guarda el contacto en Eliminados.txt
                System.out.println("Contacto eliminado exitosamente.");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró ningún contacto con ese nombre y apellidos.");
        }
		
	}
	
	private static void guardarEnEliminados(AgendaTelefonica contacto) {
		 try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\dir1\\eliminados.txt", true))) {  // Modo de adición activado
		        // Escribir el contacto en una línea en Eliminados.txt
		        bw.write(contacto.getNombre() + " " + contacto.getApellidos() + " - Teléfono: " +
		                contacto.getNumeroTelefono() + ", Correo: " + contacto.getCorreoElectronico());
		        bw.newLine();
		    } catch (IOException e) {
		        System.out.println("Error al escribir en el archivo de eliminados: " + e.getMessage());
		        e.printStackTrace();
		    }
    }

	private static void modificarDatos() {
		System.out.println("Ingrese el nombre:");
		String nombre = sc.nextLine();
		
		System.out.println("Ingrese los apellidos:");
		String apellidos = sc.nextLine();
		
		boolean encontrado = false;
		
		for (AgendaTelefonica contacto : RegistroAgenda) {
			if(contacto.getNombre().equalsIgnoreCase(nombre) && contacto.getApellidos().equalsIgnoreCase(apellidos)) {
				System.out.println("Contacto encontrado");
				System.out.println("¿Desea modificar el numero de telefono [N], el correo [C] o ambos [A]?");
				String opcion = sc.nextLine().toUpperCase();
				switch (opcion) {
				case "N":
					System.out.println("Ingrese el telefono nuevo");
					int nTelefono = sc.nextInt();
					sc.nextLine();
					contacto.setNumeroTelefono(nTelefono);
					break;
				case "C":
					System.out.println("Ingrese el correo electronico nuevo");
					String nCorreo = sc.nextLine();
					contacto.setCorreoElectronico(nCorreo);
					break;
				case "A":
					System.out.println("Ingrese el telefono nuevo");
					int telefono = sc.nextInt();
					sc.nextLine();
					contacto.setNumeroTelefono(telefono);
					System.out.println("Ingrese el correo electronico nuevo");
					String correo = sc.nextLine();
					contacto.setCorreoElectronico(correo);
					break;
				default:
					System.out.println("Ingrese una opcion valida");
				}
				System.out.println("Datos modificados exitosamente.");
				encontrado = true;
                break;
			}
		}
		if (!encontrado) {
	        System.out.println("No se encontró ningún contacto con ese nombre y apellidos.");
	    }
	}

	private static void buscarPersona() {
		System.out.println("Ingrese el nombre:");
		String nombre = sc.nextLine();
		
		System.out.println("Ingrese los apellidos:");
		String apellidos = sc.nextLine();
		
		boolean encontrado = false;
		for (AgendaTelefonica contacto : RegistroAgenda) {
			if (contacto.getNombre().equalsIgnoreCase(nombre) && contacto.getApellidos().equalsIgnoreCase(apellidos)) {
				System.out.println("Contacto encontrado:");
				System.out.println("Nombre: " + contacto.getNombre());
				System.out.println("Apellidos: " + contacto.getApellidos());
				System.out.println("Número de Teléfono: " + contacto.getNumeroTelefono());
				System.out.println("Correo Electrónico: " + contacto.getCorreoElectronico());
				encontrado = true;
				break;
			}
		}

		if (!encontrado) {
			System.out.println("No se encontró ningún contacto con ese nombre y apellidos.");
		}
		
	}

	private static void darDeAlta() {
		System.out.println("Ingrese el nombre:");
		String nombre = sc.nextLine();
		
		System.out.println("Ingrese los apellidos:");
		String apellidos = sc.nextLine();
		
		System.out.println("Ingrese el número de teléfono:");
		int numeroTelefono = sc.nextInt();
		sc.nextLine(); 
		
		System.out.println("Ingrese el correo electrónico:");
		String correo = sc.nextLine();
		AgendaTelefonica agenda = new AgendaTelefonica(nombre, apellidos, numeroTelefono, correo);
		
			
		RegistroAgenda.add(agenda);
		guardarAgenda();
		System.out.println("Registro guardado exitosamente");
	}

	public static int mostrarMenu() {
		int opcion = 0;
		System.out.println("BIENVENIDO AL PROGRAMA AGENDA TELEFONICA");
		System.out.println("1. Dar de alta un nuevo registro");
		System.out.println("2. Buscar persona");
		System.out.println("3. Modificar telefono o correo electronico");
		System.out.println("4. Eliminar registro");
		System.out.println("5. Salir del programa");
		opcion = sc.nextInt();
		sc.nextLine();
		return opcion;
	}

	  @SuppressWarnings("unchecked")
	private static void cargarAgenda() {
	        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\dir1\\agenda.dat"))) {
	            RegistroAgenda = (ArrayList<AgendaTelefonica>) ois.readObject();
	            System.out.println("Agenda cargada con éxito.");
	        } catch (IOException | ClassNotFoundException e) {
	            System.out.println("No se pudo cargar la agenda, comenzando con una agenda vacía.");
	        }
	    }

	    private static void guardarAgenda() {
	        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\dir1\\agenda.dat"))) {
	            oos.writeObject(RegistroAgenda);
	        } catch (IOException e) {
	            System.out.println("Error al guardar la agenda: " + e.getMessage());
	        }
	    }
}

