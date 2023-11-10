package tareas;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import model.Pedido;
import service.PedidosService;
import service.PedidosServiceFactory;

public class TareaPedidos implements Runnable {
	
	String ruta;
	String tienda;
	
	public void run() {
		var ps = PedidosServiceFactory.getPedidosService();
		List<Pedido> pedidos = ps.pedidosTienda(ruta, tienda);
		ps.guardarPedidos(pedidos);
	}

	static String ruta1 = "c:\\temp\\pedidos\\tienda1.json";
	static String ruta2 = "c:\\temp\\pedidos\\tienda2.json";
	static String ruta3 = "c:\\temp\\pedidos\\tienda3.json";
	
	public static void main(String[] args) {
		
		PedidosService ps = PedidosServiceFactory.getPedidosService();
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.submit( () -> {
			 List<Pedido> pedidos = ps.pedidosTienda(ruta1, "tienda1");
			 ps.guardarPedidos(pedidos); });
		executor.submit( () -> {
			 List<Pedido> pedidos = ps.pedidosTienda(ruta2, "tienda2");
			 ps.guardarPedidos(pedidos); });
		executor.submit( () -> {
			 List<Pedido> pedidos = ps.pedidosTienda(ruta3, "tienda3");
			 ps.guardarPedidos(pedidos); });
	}		
}