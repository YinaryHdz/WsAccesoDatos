package _03_listar02;

import java.io.File;

public class ListarMain {

	public static void main(String[] args) {
		File dir = new File("C:/dir1");
		TxtFileFilter txtFilter = new TxtFileFilter();
		File [] txtFiles = dir.listFiles(txtFilter);
		
		FilePrinter printer = new FilePrinter();
		printer.printFiles(txtFiles);
	}

}
