package service;

import java.util.List;

import DAO.DAOFactory;
import DAO.FicheroPedidoDAO;
import model.Pedido;

public class PedidosServiceImpl implements PedidosService {
	
	@Override
	public List<Pedido> pedidosTienda(String ruta, String tienda) {
		FicheroPedidoDAO fpd = DAOFactory.getFicheroPedidoDAO();
		List<Pedido> pedidos = fpd.getPedidos(ruta);	// Los pedidos vienen sin tienda en el fichero. 
		pedidos.forEach( p -> p.setTienda(tienda));		// Se la añadimos.
		return pedidos;
	}
	
	@Override
	public void guardarPedidos(List<Pedido> pedidos) {
		var pd = DAOFactory.getPedidoDAO();
		pedidos.forEach( p -> pd.guardarPedido(p) );
	}
}