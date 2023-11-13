package service;

import java.util.List;

public interface PaisService {
	List<String> paises();
	double incidenciaPais(String pais);
	int totalAcumulados();
}