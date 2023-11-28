package principal;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServidorListaPedidos {

	public static void main(String[] args) throws Exception {
		try {
			ServerSocket server = new ServerSocket(8000);
			ExecutorService executor = Executors.newCachedThreadPool();

			while (true) {
				System.out.println("Esperando petición de pedidos por tienda");
				Socket socket = server.accept();
				executor.submit(new HiloPedidosTiendas(socket));
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}