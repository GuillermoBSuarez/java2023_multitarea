package view.adapters;

import java.time.LocalDate;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Pedido;
import service.PedidoServiceFactory;

public class TablaPedidosModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	List<Pedido> pedidos;

	public TablaPedidosModel(String tienda) {
		pedidos = PedidoServiceFactory.getPedidoService().pedidosTienda(tienda);
	}

	@Override
	public int getRowCount() {
		return pedidos.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
			case 0 -> { return "Producto"; }
			case 1 -> { return "Precio"; }
			case 2 -> { return "Fecha pedido"; }
			default -> { return "Indeterminada"; }
		}
	}

	@Override
	public Object getValueAt(int row, int column) {
		switch (column) {
			case 0 -> { return pedidos.get(row).getProducto(); }
			case 1 -> { return pedidos.get(row).getPrecio(); }
			case 2 -> { return pedidos.get(row).getFechaPedido(); }
			default -> { return null; }
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
			case 0 -> { return String.class; }
			case 1 -> { return Double.class; }
			case 2 -> { return LocalDate.class; }
			default -> { return null; }
		}
	}
}