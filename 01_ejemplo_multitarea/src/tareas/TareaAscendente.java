package tareas;

public class TareaAscendente extends Thread {

	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			System.out.println("P'ARRIBA: " + i);
			try {
				Thread.sleep(100);					// Añade 100 ms de pausa, para ver mejor el efecto.
			} catch (InterruptedException e) {		// Requiere try-catch
				e.printStackTrace();
			}
		}
	}
}