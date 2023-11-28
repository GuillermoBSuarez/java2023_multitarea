package service;

import utilities.Utilidades;

public class Operaciones {
	private int n1, n2;

	public Operaciones(int n1, int n2) {
		super();
		this.n1 = n1;
		this.n2 = n2;
	}

	public int sumar() {
		return n1 + n2;
	}

	public int restar() {
		return Utilidades.mayor(n2, n1) - Utilidades.menor(n2, n1);
	}

	public int multiplicar() {
		return n1 * n2;
	}
	
	public int dividir() {
		return Utilidades.mayor(n2, n1) / Utilidades.menor(n2, n1);
	}
}
