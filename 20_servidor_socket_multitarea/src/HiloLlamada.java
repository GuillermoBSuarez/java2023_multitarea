import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class HiloLlamada implements Runnable {
	final Socket socket;
	public HiloLlamada (Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		// Recoge el nombre enviado por el cliente y le envía un saludo personalizado
		// Atención: usado con el cliente del 19
		
		try (	socket;		/* Para que cierre el socket al terminal el bloque try.
							Y en este orden, pues se ejecutan en el orden inverso al que se abren. */
				PrintStream out = new PrintStream(socket.getOutputStream());
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream())); ) {
			out.println("Hola, " + br.readLine() + ", ¿una partidita de ajedrez?");				
		} catch (IOException ex) {
			ex.printStackTrace();
		}			
	}
}