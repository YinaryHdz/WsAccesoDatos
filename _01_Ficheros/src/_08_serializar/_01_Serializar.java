package _08_serializar;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class _01_Serializar {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		Administrador jefe  =new Administrador("Eduardo", 40000.0, 2012, 3, 1, 3000.0);
		
		Empleado[] personal = new Empleado[3];
		personal[0]= jefe;
		personal[1]= new Empleado("Alvaro", 20000, 2022, 4, 6);
		personal[2]= new Empleado("Estefania", 30000, 2021, 6, 7);
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\dir1\\personal.dat"));
		oos.writeObject(personal);
		
		ObjectInputStream ois= new ObjectInputStream(new FileInputStream("C:\\dir1\\personal.dat"));
		Empleado [] personalRecuperado = (Empleado[])ois.readObject();
		
		for (Empleado e : personalRecuperado) {
			System.out.println(e);
		}

	}

}


