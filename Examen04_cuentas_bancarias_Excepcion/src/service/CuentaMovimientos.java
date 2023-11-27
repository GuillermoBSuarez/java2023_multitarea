package service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import exceptions.SaldoNegativoException;
import model.Mov;

public class CuentaMovimientos extends CuentaLimite {
	
	ArrayList<Mov> movs = new ArrayList<>();

	public CuentaMovimientos(String codigoCuenta, double saldo, double limite) {
		super(codigoCuenta, saldo, limite);
	}

	public ArrayList<Mov> obtenerMovimientos(){
		return movs;
	}

	@Override
	public void ingresar(double cantidad) {
		Mov mov = new Mov(cantidad, LocalDateTime.now(), "Ingreso");
		movs.add(mov); 
		super.ingresar(cantidad);
	}

	@Override
	public void extraer(double cantidad) throws SaldoNegativoException {
		Mov mov = new Mov(cantidad, LocalDateTime.now(), "Extracción");
		movs.add(mov); 
		super.extraer(cantidad);
	}	
}