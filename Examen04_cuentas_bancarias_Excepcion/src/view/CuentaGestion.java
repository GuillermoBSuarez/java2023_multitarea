package view;

import java.util.Scanner;

import exceptions.SaldoNegativoException;
import model.Mov;
import service.CuentaMovimientos;

public class CuentaGestion {

	static service.CuentaMovimientos service;
	
	public static void main(String[] args) {
		
		Scanner scNum = new Scanner(System.in);
		Scanner scStr = new Scanner(System.in);
		
		System.out.print("Cuenta: ");
		String cuenta = scStr.nextLine();
		System.out.print("Saldo: ");
		double saldo = scNum.nextDouble();
		System.out.print("Límite: ");
		double limite = scNum.nextDouble();
		
		CuentaMovimientos cuentaMovimientos = new CuentaMovimientos(cuenta, saldo, limite);
		
		int op = 0;
		do {
			System.out.println();
			System.out.println("1. Ingresar");
			System.out.println("2. Extraer");
			System.out.println("3. Saldo y movimientos");
			System.out.println("4. Salir");
			System.out.print("INTRODUZCA UNA OPCIÓN: ");
			
			op = scNum.nextInt();
			
			switch (op) {
				case 1:
					System.out.print("Cantidad a ingresar: ");
					cuentaMovimientos.ingresar(Double.parseDouble(scStr.nextLine()));
					break;
				case 2:
					System.out.print("Cantidad a extraer: ");
					try {
						cuentaMovimientos.extraer(Double.parseDouble(scStr.nextLine()));
					} catch ( SaldoNegativoException ex ) {
						System.out.println("No hay saldo suficiente.");
					}					
					break;
				case 3:
					System.out.println("Movimientos: ");
					for (Mov mov:cuentaMovimientos.obtenerMovimientos()) {
						System.out.println("Cantidad: " + mov.getCantidad()
										 + " - Fecha y hora: " + mov.getFechaHora()
										 + " - Tipo de movimiento: " + mov.getTipoMov());
					}
					System.out.println("Saldo: " + cuentaMovimientos.getSaldo());
					break;
				case 4:
					System.out.println("Chao, pescao.");
					break;
				default:
					op = 0;
			}	
		} while (op != 4);
	}
}