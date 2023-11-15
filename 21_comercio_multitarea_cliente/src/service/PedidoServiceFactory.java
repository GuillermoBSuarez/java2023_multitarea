package service;

public class PedidoServiceFactory {
	public static PedidoService getPedidoService() {
		return new PedidoServiceImpl();
	}
}