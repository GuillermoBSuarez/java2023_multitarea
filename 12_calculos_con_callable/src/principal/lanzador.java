package principal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class lanzador {

	public static void main(String[] args) throws Exception {
		/* Lanzar dos tareas concurrentes. Una suma los números de 1 a 100 y la otra
		calcula el factorial de un número. Al finalizar las dos se muestran los resultados. */
		
		ExecutorService executor = Executors.newCachedThreadPool();
		
		Future<Integer> f1 = executor.submit( () -> {		// Suma
			return IntStream.rangeClosed(1, 100).sum();
		});
		Future<Integer> f2 = executor.submit( () -> {		// Factorial de 6
			return IntStream.rangeClosed(1, 6).reduce(1, (a, b) -> a * b );
												   // 1 es el valor de inicio; si no se indica,
												   // por defecto empezaría por 0, y multiplicar por 0...
		});
		
		while(!f1.isDone() || !f2.isDone()) {}
		/* Con este método del while, hasta que no terminan AMBOS callable no se imprime resultado.
		Pero si uno dura mucho más que otro no es eficiente. Hay una forma mejor, para mostrar
		cada uno según ha terminado. Ver presentación CompletableFuture. */

		System.out.println("Suma: " + f1.get());
		System.out.println("Factorial: " + f2.get());
		executor.shutdown();
	}
}