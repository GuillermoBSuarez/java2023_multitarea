package view.adapters;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Pais;
import service.PaisesService;
import service.PaisesServiceImpl;

public class TablaPaisesModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	PaisesService ps = new PaisesServiceImpl();
	List<Pais> paises;
	
	// CONSTRUCTOR
	public TablaPaisesModel(String continente) {
		if (continente == "-Todos-") { paises = ps.paises(); }
		else { paises = ps.paises(continente); }
	}

	@Override
	public int getRowCount() {
		return paises.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public String getColumnName(int column) {
		return switch (column) {
			case 0 -> "Pais";
			case 1 -> "Capital";
			case 2 -> "Población";
			default -> "Indeterminado";
		};
	}

	@Override
	public Object getValueAt(int row, int column) {
		switch (column) {
			case 0: return paises.get(row).getNombrePais();
			case 1: return paises.get(row).getCapital();
			case 2: return paises.get(row).getPoblacion();
			default: return null;
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
			case 0: return String.class;
			case 1: return String.class;
			case 2: return int.class;
			default: return null;
		}
	}
}