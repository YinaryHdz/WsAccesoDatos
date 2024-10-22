package _03_listar02;

import java.io.File;
import java.io.FilenameFilter;

public class TxtFileFilter implements FilenameFilter{

	@Override
	public boolean accept(File dir, String name) {
		return name.endsWith(".txt");
	}

}
