package service;

// El import static hay que escribirlo, Eclipse no lo añade con Ctrl+Supr+O
import static service.locator.ItemsLocator.getJsonStream;
import static utilities.Utilidades.convertirTextoFecha;

import java.util.List;
import java.util.stream.Collectors;

import model.Pais;

public class PaisServiceImpl implements PaisService {

	@Override
	public List<String> paises() {
		return getJsonStream()					// Stream<Pais>
				.map( p -> p.getNombrePais())	// Stream<String>
				.distinct()
				.toList();
	}

	@Override
	public double incidenciaPais(String pais) {
		return getJsonStream()																		// Stream<Pais>
				.filter( p -> p.getNombrePais().equals(pais) && p.getIndicador().equals("cases"))
				.max( (p1, p2) -> convertirTextoFecha(p1.getFecha())
						.compareTo(convertirTextoFecha(p2.getFecha())))								// Optional<Pais>
				.orElse(new Pais())
				.getIncidencia();
		/* En vez de orElse debería haber .get(), porque sabemos que siempre habrá un resultado,
		pero si por lo que sea no hay objeto -que es un Optional- y hacemos get sobre un Optional vacío
		saltará una excepción, por eso ponemos orElse para evitarlo, creando un objeto vacío. Y si
		éste es el caso, la hacer getIncidencia sobre un double vacío devolverá 0, evitando la excepción. */
	}

	@Override
	public int totalAcumulados() {
		return getJsonStream()																// Stream<Pais>
				.filter( it->it.getIndicador().equals("cases") )
				.collect(Collectors.groupingBy( it -> it.getNombrePais(), Collectors.maxBy(
						(it1,it2) -> convertirTextoFecha(it1.getFecha())
										.compareTo(convertirTextoFecha(it2.getFecha())))))	// Map<String,Item>
				.values()																	// Collection<Item>
				.stream()																	// Stream<Item>
				.collect(Collectors.summingInt( op -> op.get().getAcumulados() ));
	}

/*	
	public int totalAcumulados() {
		LocalDate fechaMax=fechaMasReciente();
		return locator.getJsonStream()
				.filter(it->it.getIndicador().equals("cases")&&convertirTextoFecha(it.getFecha()).equals(fechaMax))
				.collect(Collectors.summingInt(it->it.getAcumulados()));
	}

	private LocalDate fechaMasReciente() {
		return locator.getJsonStream()
				.map(it->convertirTextoFecha(it.getFecha())) //Stream<LocalDate>
				.max((f1,f2)->f1.compareTo(f2))
				.orElse(LocalDate.now());
	}
*/
}