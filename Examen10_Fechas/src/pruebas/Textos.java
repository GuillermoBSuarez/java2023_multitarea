package pruebas;

import java.util.Locale;
import java.util.ResourceBundle;

public class Textos {

	public static void main(String[] args) {
		ResourceBundle rb = ResourceBundle.getBundle("textos", Locale.ENGLISH);
		System.out.println(rb.getString("t1"));
		System.out.println(rb.getString("t2"));

		rb = ResourceBundle.getBundle("textos", Locale.JAPAN);
		System.out.println(rb.getString("t1"));
		System.out.println(rb.getString("t2"));
		
		// cambiamos la localización por defecto
		Locale.setDefault(Locale.ENGLISH);
		rb = ResourceBundle.getBundle("textos", Locale.JAPAN);
		System.out.println(rb.getString("t1"));
		System.out.println(rb.getString("t2"));
	}
}