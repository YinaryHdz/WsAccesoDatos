package _02_listarFile;

import java.io.File;
import java.io.FileFilter;

public class _04_ListarFileFilter {

	public static void main(String[] args) {
		File dir = new File("C:/dir1");
		FileFilter filtroTamanio = new FileFilter() {
			
			@Override
			public boolean accept(File pathname) {
				//Muestra los elementos en los cuales su tamaño es mayor 
				return	pathname.isFile() && pathname.length() > 1024 ;
			}
		};
		
		File [] ficherosFiltrados = dir.listFiles(filtroTamanio);
		for (File fich : ficherosFiltrados) {
			System.out.println("Archivo: " + fich.getName() + " Tamaño: " + fich.length() + " bytes ");
		}

	}

}
