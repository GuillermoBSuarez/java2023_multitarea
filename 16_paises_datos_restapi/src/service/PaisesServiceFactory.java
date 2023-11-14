package service;

public class PaisesServiceFactory {
	
	public static PedidoServiceFactory getPaisesService() {
		return new PaisesServiceImpl();
	}
}