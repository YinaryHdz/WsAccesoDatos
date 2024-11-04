package ejerciciosNio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Ejercicio_01 {

	public static void main(String[] args) throws IOException {
		//Realizar mediante el uso de canales y buffers en Java NIO un programa para copiar el contenido 
		//de un archivo de origen a un archivo de destino:
		//Se usará un buffer de bytes de tamaño 1024 y se copiará un fichero de un tamaño mayor.

		RandomAccessFile file = new RandomAccessFile("C:/dir1/canal.txt", "r");
		RandomAccessFile fileCopy = new RandomAccessFile("C:/dir1/copiaCanal.txt", "rw");
		FileChannel channel = file.getChannel();
		ByteBuffer buf = ByteBuffer.allocate(1024);
		
		int bytesRead = 0;
		while((bytesRead = channel.read(buf)) != -1) {
			System.out.println("Leidos: " + bytesRead);
			buf.flip();
			while(buf.hasRemaining()) {
				 fileCopy.getChannel().write(buf);
			}
			buf.clear();
		}
		file.close();
        fileCopy.close();
	}

}
