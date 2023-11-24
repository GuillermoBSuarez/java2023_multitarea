package examen;

public class pruebas11_operadores {

	public static void main(String[] args) {
		int a=2, b=2;
		int c=b++>a?--a:b++;
		/* Primero compara b y a. b no es mayor que a.
		Después incrementa b, que ya vale 3.
		Como la comparación es false se va a :b++.
		Primero asigna b a c, por lo que ambos valen 3.
		Por último incrementa b, que pasa a valer 4.*/
		System.out.println(c);
		System.out.println(b);
		
	}
}