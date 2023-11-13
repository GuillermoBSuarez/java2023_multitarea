import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSaludo {

	public static void main(String[] args) throws Exception {

		ServerSocket ss = new ServerSocket(8000);
		System.out.println("¿Una partidita de ajedrez?");
		
		try ( Socket socket = ss.accept(); ) {
			PrintStream ps = new PrintStream(socket.getOutputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			ps.println("Saludos, " + br.readLine());
		}
	}
}