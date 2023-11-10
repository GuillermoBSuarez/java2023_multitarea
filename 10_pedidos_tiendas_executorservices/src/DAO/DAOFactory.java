package DAO;

public class DAOFactory {
	
	public static FicheroPedidoDAO getFicheroPedidoDAO() {
		return new FicheroPedidoDAOImpl();		
	}
	
	public static PedidoDAO getPedidoDAO() {
		return new PedidoDAOImpl();
	}
}