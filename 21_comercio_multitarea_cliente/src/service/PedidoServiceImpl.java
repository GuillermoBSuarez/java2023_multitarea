package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Type;
import java.net.Socket;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import model.Pedido;
import serialización.DeserializadorFecha;

public class PedidoServiceImpl implements PedidoService {
	String server = "localhost";
	int port = 8000;
	int portAlta = 8001;

	@Override
	public List<Pedido> pedidosTienda(String tienda) {
		Gson gson = new GsonBuilder()
						.registerTypeAdapter(LocalDate.class, new DeserializadorFecha())
						.create();
		
		try ( Socket socket = new Socket(server, port);
			  PrintStream out = new PrintStream(socket.getOutputStream());
			  BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

			out.println(tienda);			// Enviamos al servidor de sockets la tienda seleccionada.
			String json = bf.readLine();	// Recibimos JSON de pedidos.

			return Arrays.asList(gson.fromJson(json, Pedido[].class));
		} catch (IOException ex) {
			ex.printStackTrace();
			return List.of();
		}
	}
	
	public void altaPedido(Pedido pedido) {
		try ( Socket socket = new Socket(server, portAlta);
			  PrintStream out = new PrintStream(socket.getOutputStream()); ) {

			out.println(serializarPedido(pedido));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	// Transforma el pedido en una cadena JSON
	private static String serializarPedido(Pedido pedido) {
		final Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonSerializer<LocalDate>() {
			@Override
			public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
				return new JsonPrimitive(src.format(DateTimeFormatter.ISO_LOCAL_DATE)); // "yyyy-mm-dd"
			}
		}).create();
		return gson.toJson(pedido, Pedido.class);
	}
}