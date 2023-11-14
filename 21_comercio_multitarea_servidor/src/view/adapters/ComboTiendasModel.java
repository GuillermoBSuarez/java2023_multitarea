package view.adapters;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

import service.PedidoServiceFactory;

public class ComboTiendasModel extends DefaultComboBoxModel<String> {

	private static final long serialVersionUID = 1L;
	List<String> tiendas;
	
	// CONSTRUCTOR
	public ComboTiendasModel() {
		tiendas = new ArrayList<>(PedidoServiceFactory.getPedidoService().tiendas());
	}
	
	@Override
	public int getSize() {
		return tiendas.size();
	}

	@Override
	public String getElementAt(int index) {
		return tiendas.get(index);
	}
}