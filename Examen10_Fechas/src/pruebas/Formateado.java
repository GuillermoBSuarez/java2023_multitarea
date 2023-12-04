package pruebas;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class Formateado {
	public static void main(String[] args) {
		double salario = 2345.45;
		Locale ld = new Locale("es", "ES");
		Locale ldUS = Locale.US;
		Locale ldJP = Locale.JAPAN;
		NumberFormat nf = NumberFormat.getCurrencyInstance(ld);
		System.out.println(nf.format(salario));
		nf = NumberFormat.getCurrencyInstance(ldUS);
		System.out.println(nf.format(salario));
		nf = NumberFormat.getCurrencyInstance(ldJP);
		System.out.println(nf.format(salario));
		
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, ldJP);
		System.out.println(df.format(new Date()));
		df = DateFormat.getDateInstance(DateFormat.FULL, ldUS);
		System.out.println(df.format(new Date()));
		df = DateFormat.getDateInstance(DateFormat.FULL, ld);
		System.out.println(df.format(new Date()));
	}
}