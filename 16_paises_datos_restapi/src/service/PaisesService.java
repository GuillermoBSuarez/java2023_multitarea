package service;

import java.util.List;

import model.Pais;

public interface PaisesService {
	List<String> continentes();
	List<Pais> paises();
	List<Pais> paises(String continente);
}