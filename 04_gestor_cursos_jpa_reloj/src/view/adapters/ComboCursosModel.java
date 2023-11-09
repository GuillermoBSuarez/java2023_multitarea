package view.adapters;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

import model.Pedido;
import service.FormacionServiceFactory;

public class ComboCursosModel extends DefaultComboBoxModel<Pedido> {

	private static final long serialVersionUID = 1L;
	List<Pedido> cursos;
	
	// CONSTRUCTOR
	public ComboCursosModel() {
		// cursos = new ArrayList<>(new FormacionService().listadoCursos());
		cursos = new ArrayList<>(FormacionServiceFactory.getFormacionService().listadoCursos());
		cursos.add(0, new Pedido(0, "-Todos-", 0, 0, null, null));
	}
	
	@Override
	public int getSize() {
		return cursos.size();
	}

	@Override
	public Pedido getElementAt(int index) {
		return cursos.get(index);
	}
}