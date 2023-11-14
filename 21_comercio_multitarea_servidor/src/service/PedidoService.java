package service;

import java.util.List;

import model.Pedido;

public interface PedidoService {
	public List<Pedido> pedidosTienda(String tienda);
	public List<String> tiendas();
	public void guardarPedido(Pedido pedido);
}