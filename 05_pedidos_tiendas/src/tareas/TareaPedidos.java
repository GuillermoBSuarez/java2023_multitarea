package tareas;

import java.util.List;

import model.Pedido;
import service.PedidosService;
import service.PedidosServiceFactory;

public class TareaPedidos implements Runnable {
	
	String ruta;
	String tienda;
	
	/*
	DESAPARECE POR LA FORMA DE IMPLEMENTAR RUNNABLE (THREAD) EN MAIN,
	QUE AL SER UNA INTERFAZ FUNCIONAL PODEMOS HACERLO CON LAMBDAS.
	
	public TareaPedidos(String ruta, String tienda) {
		super();
		this.ruta = ruta;
		this.tienda = tienda;
	}
	*/

	public void run() {
		var ps = PedidosServiceFactory.getPedidosService();
		List<Pedido> pedidos = ps.pedidosTienda(ruta, tienda);
		ps.guardarPedidos(pedidos);
	}

	static String ruta1 = "c:\\temp\\pedidos\\tienda1.json";
	static String ruta2 = "c:\\temp\\pedidos\\tienda2.json";
	static String ruta3 = "c:\\temp\\pedidos\\tienda3.json";
	
	public static void main(String[] args) {
		/*
		new Thread(new TareaPedidos("c:\\temp\\pedidos\\tienda1.json", "tienda1")).start();
		new Thread(new TareaPedidos("c:\\temp\\pedidos\\tienda2.json", "tienda2")).start();
		new Thread(new TareaPedidos("c:\\temp\\pedidos\\tienda3.json", "tienda3")).start();
		*/
		
		PedidosService ps = PedidosServiceFactory.getPedidosService();
		new Thread( () -> {
			 List<Pedido> pedidos = ps.pedidosTienda(ruta1, "tienda1");
			 ps.guardarPedidos(pedidos); }).start();
		new Thread( () -> {
			 List<Pedido> pedidos = ps.pedidosTienda(ruta2, "tienda2");
			 ps.guardarPedidos(pedidos); }).start();
		new Thread( () -> {
			 List<Pedido> pedidos = ps.pedidosTienda(ruta3, "tienda3");
			 ps.guardarPedidos(pedidos); }).start();
		/* O TAMBIÉN:
		new Thread( () -> ps.guardarPedidos(ps.pedidosTienda(ruta1, "tienda1")) ).start();
		*/
	}		
}