package view.adapters;

import java.time.LocalDate;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Pedido;
import service.PedidoServiceFactory;

public class TablaPedidosModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	List<Pedido> pedidos;
	
	// CONSTRUCTOR
	public TablaPedidosModel(String tienda) {
		pedidos = PedidoServiceFactory.getPedidoService().pedidosTienda(tienda);
	}

	@Override
	public int getRowCount() {
		return pedidos.size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public String getColumnName(int column) {
		return switch (column) {
			case 0 -> "Pedido";
			case 1 -> "Producto";
			case 2 -> "Fecha";
			case 3 -> "Precio";
			default -> "Indeterminado";
		};
	}
	
	@Override
	public Object getValueAt(int row, int column) {
		switch (column) {
			case 0: return pedidos.get(row).getIdPedido();
			case 1: return pedidos.get(row).getProducto();
			case 2: return pedidos.get(row).getFechaPedido();
			case 3: return pedidos.get(row).getPrecio();
			default: return null;
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
			case 0: return int.class;
			case 1: return String.class;
			case 2: return LocalDate.class;
			case 3: return double.class;
			default: return null;
		}
	}
}