package tareas;

import java.util.Scanner;

public class Lanzador {

	public static void main(String[] args) {
		// Pide tres números y muestra sus respectivas tablas de multiplicar
		// concurrentemente
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Primer número: ");
		int num1 = sc.nextInt();
		System.out.println("Segundo número: ");
		int num2 = sc.nextInt();
		System.out.println("Tercer número: ");
		int num3 = sc.nextInt();
		
		/*
		TablaMultiplicar tablaNum1 = new TablaMultiplicar(num1);
		Thread threadNum1 = new Thread(tablaNum1);
		TablaMultiplicar tablaNum2 = new TablaMultiplicar(num2);
		Thread threadNum2 = new Thread(tablaNum2);
		TablaMultiplicar tablaNum3 = new TablaMultiplicar(num3);
		Thread threadNum3 = new Thread(tablaNum3);
		
		threadNum1.start();
		threadNum2.start();
		threadNum3.start();
		*/
		
		new Thread(new TablaMultiplicar(num1)).start();
		new Thread(new TablaMultiplicar(num2)).start();
		new Thread(new TablaMultiplicar(num3)).start();
	}
}