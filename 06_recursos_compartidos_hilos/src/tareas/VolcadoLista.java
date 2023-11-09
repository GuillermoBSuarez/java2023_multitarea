package tareas;

import java.util.ArrayList;
import java.util.List;

public class VolcadoLista implements Runnable {
	int a, b;
	ArrayList<Integer> list;

	/*
	PROBLEMA DE SINCRONIZACIÓN DE HILOS: con vectores no pasa, todos sus métodos ya están sincronizados
	Vector<Integer> list;
	Pero vector casi no se usa porque pierde mucho tiempo usar una clase con todos sus métodos sincronizados.
	Hay clases ya implementadas sin usar bloques synchronized, que penalizan uso de microprocesador,
	y que ya son thread safe: java/util/concurrent
	https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/concurrent/package-summary.html
	Clases de colección para entornos de thread safe, hay una clsae de colección por cada una que conocemos:
	CopyOnWriteArrayList<E> -> ArrayList<E> - https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/concurrent/CopyOnWriteArrayList.html
	*/
	
	public VolcadoLista(int a, int b, ArrayList<Integer> list) {
		super();
		this.a = a;
		this.b = b;
		this.list = list;
	}

	@Override
	public void run() {
		/*
		for (int i = a; i <= b; i++) {
			list.add(i);
		}
		*/
		
		// SOLUCIÓN AL PROBLEMA DE CONCURRENCIA		
		for (int i = a; i <= b; i++) {
			synchronized (list) {				// Thread safe
				list.add(i);
			}			
		}
	}
}
