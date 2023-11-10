package tareas;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Lanzador {
	
	public static void main(String[] args) {
		ArrayList<Integer> lista = new ArrayList<>();
		ExecutorService executor = Executors.newCachedThreadPool();
		Future<?> t1 = executor.submit(new VolcadoLista(1, 1000, lista));
		Future<?> t2 = executor.submit(new VolcadoLista(1001, 2000, lista));
		Future<?> t3 = executor.submit(new VolcadoLista(2001, 3000, lista));
		/* Submit envía un runnable y no devuelve nada.
		Por eso Future<?>: tipo desconocido. */
		
		while(!t1.isDone() || !t2.isDone() || !t3.isDone()){}
		// While sin cuerpo: no hacer nada. Ñapa.
		
		System.out.println("El resultado de la tarea es "+ lista.size());
		
		// El programa se queda en ejecución porque el pool de threads queda abierto.
		// Forzamos el cierre.
		executor.shutdown();
	}
}
