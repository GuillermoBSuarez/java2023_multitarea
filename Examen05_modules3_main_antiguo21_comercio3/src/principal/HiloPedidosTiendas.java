package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Type;
import java.net.Socket;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import model.Pedido;
import service.PedidoService;
import service.PedidoServiceFactory;

public class HiloPedidosTiendas implements Runnable {
	final Socket socket;

	public HiloPedidosTiendas(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {

		try ( socket;
			  PrintStream out=new PrintStream(socket.getOutputStream());
			  BufferedReader bf=new BufferedReader(new InputStreamReader(socket.getInputStream())); ) {

			PedidoService ps = PedidoServiceFactory.getPedidoService();

			List<Pedido> pedidos = ps.pedidosTienda(bf.readLine());
			
			out.println(serializarLista(pedidos));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private static String serializarLista(List<Pedido> pedidos) {
		final Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonSerializer<LocalDate>() {

			@Override
			public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
				return new JsonPrimitive(src.format(DateTimeFormatter.ISO_LOCAL_DATE)); // "yyyy-mm-dd"
			}
		}).create();
		return gson.toJson(pedidos.toArray(new Pedido[0]), Pedido[].class);				// Pedido[0] = pedido vacío
	}
}