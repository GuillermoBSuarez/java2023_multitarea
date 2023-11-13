package principal;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import service.PaisService;
import service.PaisServiceFactory;

public class Lanzador {

	public static void main(String[] args) throws IOException {
		ExecutorService executor = Executors.newCachedThreadPool();
		PaisService itemsService = PaisServiceFactory.getPaisService();
		
		List<String> paises = itemsService.paises();

		// Lanzamos la tarea secundaria: cálculo del total acumulado de casos de cada país
		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(
				() -> itemsService.totalAcumulados(), executor
		);
		future.whenCompleteAsync( (r, e) -> System.out.println("El total acumulado en Europa es: " + r) );
		
		paises.forEach( p -> System.out.println("Incidencia de " + p + " es: " + itemsService.incidenciaPais(p)) );

		// Lanzamos el cálculo de cada país como tarea independiente
		paises.forEach( p -> {
			executor.submit( () -> System.out.println("Incidencia de " + p + " es: " + itemsService.incidenciaPais(p)) );
			try { Thread.sleep(50); }
			catch (InterruptedException e1) { e1.printStackTrace(); }
		});
		executor.shutdown();		
	}
}