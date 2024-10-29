package _09_nio;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class _02_EJemplo {

	public static void main(String[] args) throws FileNotFoundException {
		RandomAccessFile file = new RandomAccessFile("C:/dir1/f7.txt", "rw");
		FileChannel channel = file.getChannel();
		ByteBuffer miBuffer = ByteBuffer.allocate(12);
		
		miBuffer.put((byte)'H');
		miBuffer.put((byte)'o');
		miBuffer.put((byte)'l');
		miBuffer.put((byte)'a');
		
		System.out.println(miBuffer.toString());
		
		miBuffer.flip();
		System.out.println(miBuffer.toString());
		System.out.println((char)miBuffer.get());
		System.out.println((char)miBuffer.get());
		
		System.out.println(miBuffer.toString());  
		
		//Compact: Los datos que no han sido leidos 
		//los coloca en la primera posicion, con flip
		//vuelvo a la posicion '0' y luego lo leo
		//se mostraran las letras faltantes: 'l y a'
		miBuffer.compact();
		miBuffer.flip();
		System.out.println(miBuffer.toString());
		System.out.println((char)miBuffer.get());
		System.out.println((char)miBuffer.get());
		System.out.println(miBuffer.toString());  
		

	}

}
