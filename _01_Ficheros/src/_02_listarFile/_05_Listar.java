package _02_listarFile;

import java.io.File;
import java.io.FileFilter;

public class _05_Listar {

	public static void main(String[] args) {
		File dir = new File("C:/dir1");
		FileFilter filtroTamanio = (File file) -> file.isFile() && file.length()< 1024;
			
		File [] ficherosFiltrados = dir.listFiles(filtroTamanio);
		for (File fich : ficherosFiltrados) {
			System.out.println("Archivo: " + fich.getName() + " Tamaño: " + fich.length() + " bytes ");
		}

	}

}
