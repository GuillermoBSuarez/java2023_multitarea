package tareas;

import java.util.ArrayList;
import java.util.Vector;

public class Lanzador {
	
	public static void main(String[] args) {
		ArrayList<Integer> lista = new ArrayList<>();

		/*
		PROBLEMA DE SINCRONIZACIÓN DE HILOS: con vectores no pasa, todos sus métodos ya están sincronizados
		Vector<Integer> list;
		Pero vector casi no se usa porque pierde mucho tiempo usar una clase con todos sus métodos sincronizados.
		*/
		
		new Thread (new VolcadoLista(1, 1000, lista)).start();
		new Thread (new VolcadoLista(1001, 2000, lista)).start();
		new Thread (new VolcadoLista(2001, 3000, lista)).start();
		
		try {
			Thread.sleep(4000);				// Pausa para asegurarnos de que terminan los hilos.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(lista.size());
		
		/*
		Cada hilo añade 1000. Lógicamente, al final el ArrayList tendrá un tamaño de 3000, ¿no?
		Pues no: al primer intento 1590, a otros 1700.
		Problemas de concurrencias de hilos. Ver "Condiciones de carrera" en 03_multitarea clasica.pdf
		*/		
	}
}
