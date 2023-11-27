package service;

import exceptions.SaldoNegativoException;

public class Cuenta {

	private String codigoCuenta;
	private double saldo;

	public Cuenta(String codigoCuenta, double saldo) {
		this.codigoCuenta = codigoCuenta;
		this.saldo = saldo;
	}

	public Cuenta(String codigoCuenta) {
		this.codigoCuenta = codigoCuenta;
		this.saldo = 50;
	}

	public void ingresar(double cantidad) {
		saldo += cantidad;
	}

	/* Modificación: si se intenta extraer más dinero del que se dispone no hará la
	operación e informará con una SaldoNegativoException a la capa de presentación
	con el mensaje pertinente */
	public void extraer(double cantidad) throws SaldoNegativoException {
		if (saldo < cantidad) {
			throw new SaldoNegativoException();
		} else {saldo -= cantidad;}
	}

	public double getSaldo() {
		return saldo;
	}
}