package _09_nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class _01_Path {
	
	public static void operacionesNIO(String operacion) throws IOException {
		Path pathf = Paths.get("C:/dir1/nio1.txt");
		Path pathd = Paths.get("C:/dir1/NIO1/NIO2");
		Path pathdFich = Paths.get(pathd + "/fff.txt");
		Path pathOrigen = Paths.get("C:/dir1/f1.txt");
		Path pathDestino = Paths.get("C:/dir1/f1_copia.txt");
		switch (operacion) {
		case "existe":
			//El siguiente link lo que hace es impedir que se sigan los enlaces simbolicos
			boolean existe = Files.exists(pathf, new LinkOption[] {LinkOption.NOFOLLOW_LINKS});
			System.out.println("Existe: " + existe);
			break;
		case "crear":
			Path nuevoPath = Files.createDirectories(pathd);
			break;
		case "copiar":
			Files.copy(pathOrigen, pathDestino);
			break;
		case "mover":
			Files.move(pathDestino, pathdFich, new LinkOption[] {LinkOption.NOFOLLOW_LINKS});
			break;
		case "eliminar":
			Files.delete(pathdFich);
			break;
		}
	}
	
	public static void leer () throws IOException {
		Path path = Paths.get("C:/dir1/f1.txt");
		byte [] bytes = Files.readAllBytes(path);
		for (byte b : bytes) {
			System.out.print((char) b);
		}
	}
	
	public static void escribir() throws IOException {
		Path path = Paths.get("C:/dir1/f1.txt");
		String texto = "pues felis jaloguin";
		Files.write(path, texto.getBytes());
	}
	
	
	//TRABAJANDO CON CANALES
	public static void escribirPorChannel() throws IOException {
		RandomAccessFile file = new RandomAccessFile("C:/dir1/f6.txt", "rw");
		FileChannel channel = file.getChannel();
		String texto = "Ola k ase";
		ByteBuffer buf = ByteBuffer.allocate(128);
		buf.clear();
		buf.put(texto.getBytes());
		buf.flip();
		while(buf.hasRemaining()) {
			channel.write(buf);
		}
		file.close();
	}
	
	public static void leerPorChannel() throws IOException {
		RandomAccessFile file = new RandomAccessFile("C:/dir1/f6.txt", "rw");
		FileChannel channel = file.getChannel();
		long size = channel.size();
		ByteBuffer buf = ByteBuffer.allocate((int)size);
		int bytesRead = channel.read(buf);
		while(bytesRead != -1) {
			System.out.println("Leidos: " + bytesRead);
			buf.flip();
			while(buf.hasRemaining()) {
				System.out.print((char)buf.get());
			}
			buf.clear();
			bytesRead = channel.read(buf);
		}
		file.close();
	}

	public static void main(String[] args) throws IOException {
		
		//operacionesNIO("eliminar");
		//leer();
		//escribir();
		//escribirPorChannel();
		
		leerPorChannel();

	}

}
