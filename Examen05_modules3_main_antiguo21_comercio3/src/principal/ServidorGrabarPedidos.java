package principal;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServidorGrabarPedidos {

	public static void main(String[] args) throws Exception {
		try {
			ServerSocket server = new ServerSocket(8001);
			ExecutorService executor = Executors.newCachedThreadPool();

			while (true) {
				System.out.println("Esperando pedidos a grabar");
				Socket socket = server.accept();
				executor.submit(new HiloGrabarPedidos(socket));
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}