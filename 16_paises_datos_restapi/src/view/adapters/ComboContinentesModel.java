package view.adapters;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

import service.PaisesServiceFactory;

public class ComboContinentesModel extends DefaultComboBoxModel<String> {

	private static final long serialVersionUID = 1L;
	List<String> continentes;
	
	// CONSTRUCTOR
	public ComboContinentesModel() {
		continentes = new ArrayList<>(PaisesServiceFactory.getPaisesService().continentes());
		continentes.add(0, "-Todos-");
	}
	
	@Override
	public int getSize() {
		return continentes.size();
	}

	@Override
	public String getElementAt(int index) {
		return continentes.get(index);
	}
}