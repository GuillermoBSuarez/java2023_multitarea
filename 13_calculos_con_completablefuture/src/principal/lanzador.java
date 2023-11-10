package principal;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class lanzador {

	public static void main(String[] args) throws Exception {
		/* Lanzar dos tareas concurrentes. Una suma los números de 1 a 100 y la otra
		calcula el factorial de un número. Que muestren resultados SEGÚN TERMINAN. */
		
		ExecutorService executor = Executors.newCachedThreadPool();
		
		// Suma
		CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync( () -> {		// Supplier, ningún parámetro
			return IntStream.rangeClosed(1, 100).sum();
		}, executor);
		
		// Factorial de 6
		CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync( () -> {
			return IntStream.rangeClosed(1, 6).reduce(1, (a, b) -> a * b );
		}, executor);
		
		f1.whenCompleteAsync( (r, e) -> System.out.println("Suma: " + r) );
					  // Biconsumer, dos parámetros
		f2.whenCompleteAsync( (r, e) -> System.out.println("Factorial: " + r) );

		executor.shutdown();
		System.in.read();
	}
}