import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClienteSaludo {

	public static void main(String[] args) throws IOException {

		/* Creamos el objeto Socket con uno de sus constructores,
		el que sólo pide la dirección del server y el puerto */
		Socket socket = new Socket("localhost", 8000);
		
		// Entrada/salida
		try (InputStream is = socket.getInputStream();) {	// accept se pone a escuchar el puerto. Devuelve un objeto socket.
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			System.out.println(br.readLine());
		}
	}
}