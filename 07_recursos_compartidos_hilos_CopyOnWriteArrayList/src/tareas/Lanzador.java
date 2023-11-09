package tareas;

import java.util.concurrent.CopyOnWriteArrayList;

public class Lanzador {
	
	public static void main(String[] args) {
		CopyOnWriteArrayList<Integer> lista = new CopyOnWriteArrayList<>();
		new Thread (new VolcadoLista(1, 1000, lista)).start();
		new Thread (new VolcadoLista(1001, 2000, lista)).start();
		new Thread (new VolcadoLista(2001, 3000, lista)).start();
		
		try {
			Thread.sleep(1000);				// Pausa para asegurarnos de que terminan los hilos.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}System.out.println(lista.size());
	}
}
