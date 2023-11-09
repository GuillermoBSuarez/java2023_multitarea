package tareas;

public class Lanzador {

	public static void main(String[] args) {
		// Como las tareas implementan Runnable, no heredan Thread,
		// no tienen método start, así que a partir de ellas creamos sendos
		// objetos Thread.
		TareaAscendente ta = new TareaAscendente();
		Thread t1 = new Thread(ta);
		TareaDescendente td = new TareaDescendente();
		Thread t2 = new Thread(td);
		
		t1.start();
		t2.start();
	}
}