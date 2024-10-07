package listarFile;

import java.io.File;
import java.io.FilenameFilter;

public class _01_ListarFilenameFilter implements FilenameFilter{

	public static void main(String[] args) {
		File dir = new File("C:/dir1");
		File [] lista = dir.listFiles();
		for(File fich : lista) {
			//Muestra en una lista los elementos que hay en dir1     
			System.out.println("Elemento: " + fich.toString());
		}
		System.out.println("------------------");
		_01_ListarFilenameFilter objetoListar = new _01_ListarFilenameFilter();
		lista = dir.listFiles(objetoListar);
		for(File fich : lista) {
			//Mediante la interfaz funcional FilenameFilter
			//filtramos los elementos de dir1 que terminen en.txt
			System.out.println("Elemento: " + fich.toString());
		}

	}

	@Override
	public boolean accept(File dir, String name) {
		//Devuelve 'true' si el elemento tiene extension txt
		return name.endsWith(".txt");
	}

}
