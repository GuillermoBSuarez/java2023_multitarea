import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class ClienteSaludo {

	public static void main(String[] args) throws IOException {

		Socket socket = new Socket("localhost", 8000);		// Profesor: A13E100
		
		try ( InputStream is = socket.getInputStream(); ) {
			OutputStream os = socket.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			PrintStream ps = new PrintStream(os);
			ps.println("Profesor Falken");
			System.out.println(br.readLine());
		}
	}
}