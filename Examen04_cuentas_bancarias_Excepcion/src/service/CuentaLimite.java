package service;

import exceptions.SaldoNegativoException;

public class CuentaLimite extends Cuenta {
	
	private double limite;
	
	public CuentaLimite(String codigoCuenta, double saldo, double limite) {
		super(codigoCuenta, saldo);
		this.limite = limite;
	}
	
	public void ajustarLimite(double limite) {
		this.limite = getSaldo()/2;
	}
	
	@Override
	public void ingresar(double cantidad) {
		if (cantidad > limite) cantidad = limite;
		super.ingresar(cantidad);
	}

	@Override
	public void extraer(double cantidad) throws SaldoNegativoException {
		if (cantidad > limite) cantidad = limite;
		super.extraer(cantidad);
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}
}