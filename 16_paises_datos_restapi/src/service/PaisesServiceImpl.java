package service;

// El import static hay que escribirlo, Eclipse no lo añade con Ctrl+Supr+O
import static service.locator.ItemsLocator.getJsonStream;

import java.util.List;

import model.Pais;

public class PaisesServiceImpl implements PaisesService {

	@Override
	public List<String> continentes() {
		return getJsonStream()
				.map( p -> p.getContinente() )
				.distinct()
				.toList();
	}
	
	@Override
	public List<Pais> paises() {
		return getJsonStream().toList();
	}
	
	@Override
	public List<Pais> paises(String continente) {
		return getJsonStream()
				.filter( p -> p.getContinente().equals(continente) )
				.toList();
	}
}