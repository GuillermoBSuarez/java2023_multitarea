import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSaludo {

	public static void main(String[] args) throws Exception {

		ServerSocket ss = new ServerSocket(8000);
		/* Uno de los constructores de la clase ServerSocket, que requiere sólo un int que será
		el puerto al que atender */
		System.out.println("Esperando llamadas");
		
		try (Socket socket = ss.accept();) {	// accept se pone a escuchar el puerto. Devuelve un objeto socket.
			// Operaciones de entrada/salida
			OutputStream os = socket.getOutputStream();
			InputStream is = socket.getInputStream();
			PrintStream ps = new PrintStream(os);
			ps.println("Hola, mundo");
		}
	}
}