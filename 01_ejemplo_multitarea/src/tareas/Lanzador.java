package tareas;

public class Lanzador {

	public static void main(String[] args) {
		// Creamos las dos tareas y las ponemos en ejecución concurrente:
		TareaAscendente ta = new TareaAscendente();
		TareaDescendente td = new TareaDescendente();
		
		ta.start();			// No .run(), que sería la ejecución normal
		td.start();
	}
}