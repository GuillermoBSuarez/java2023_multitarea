package tareas;

public class TablaMultiplicar implements Runnable {
	
	private int num;
	
	public TablaMultiplicar(int num) {
		super();
		this.num = num;
	}

	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(num + " * " + i + " = " + num*i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}