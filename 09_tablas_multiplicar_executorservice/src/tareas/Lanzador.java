package tareas;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Lanzador {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Primer número: ");
		int num1 = sc.nextInt();
		System.out.println("Segundo número: ");
		int num2 = sc.nextInt();
		System.out.println("Tercer número: ");
		int num3 = sc.nextInt();
		
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.submit(new TablaMultiplicar(num1));
		executor.submit(new TablaMultiplicar(num2));
		executor.submit(new TablaMultiplicar(num3));
	}
}