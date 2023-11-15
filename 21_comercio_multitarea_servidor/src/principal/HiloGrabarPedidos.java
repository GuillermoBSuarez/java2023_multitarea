package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.time.LocalDate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.Pedido;
import serialización.DeserializadorFecha;
import service.PedidoService;
import service.PedidoServiceFactory;

public class HiloGrabarPedidos implements Runnable {
	final Socket socket;

	public HiloGrabarPedidos(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		Gson gson = new GsonBuilder()
						.registerTypeAdapter(LocalDate.class, new DeserializadorFecha())	// GsonBuilder
						.create();
		PedidoService ps = PedidoServiceFactory.getPedidoService();

		try ( socket;
			  BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {

			String pedidoStr = br.readLine();
			Pedido pedido = gson.fromJson(pedidoStr, Pedido.class);
			ps.guardarPedido(pedido);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}