package DAO;

import java.util.List;

import model.Pedido;

public interface FicheroPedidoDAO {
	List<Pedido> getPedidos (String ruta);
}