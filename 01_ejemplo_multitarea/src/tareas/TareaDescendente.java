package tareas;

public class TareaDescendente extends Thread {

	@Override
	public void run() {
		for (int i = 100; i >= 1; i--) {
			System.out.println("P'ABAJO: " + i);
			try {
				Thread.sleep(100);					// Añade 100 ms de pausa, para ver mejor el efecto.
			} catch (InterruptedException e) {		// Requiere try-catch
				e.printStackTrace();
			}
		}
	}
}