package view;

import java.util.Arrays;
import java.util.Scanner;

import service.TiemposService;

public class Main {

	static TiemposService service = new TiemposService();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce tiempo (m.ss): ");
		double tiempo = sc.nextDouble();
		
		double[] tiempos = service.tiempos();
		Arrays.sort(tiempos);
		int r = Arrays.binarySearch(tiempos, tiempo);					// -pos-1
		System.out.println("Con un tiempo de " + tiempo
						+ " habría quedado en " + r*-1 + "ª posición.");
	}
}