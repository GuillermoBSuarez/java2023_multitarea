package pruebas13_genericos;

public class Main {

	public static void main(String[] args) {
		Pila<Integer> pila = new Pila<>();
		pila.agregar(10);
		pila.agregar(6);
		System.out.println(pila.sacar());
		
		Pila<String> pila2 = new Pila<String>();
		pila2.agregar("h");
		pila2.agregar("o");
		pila2.agregar("l");
		pila2.agregar("a");
		
//		No es posible
//		Pila<Number> p = new Pila<Integer>();
		
		mostrar(pila);
		mostrar(pila2);
	}
	
	// mostrar tamaño pila
	static void mostrar (Pila<?> p) {
		/* La interrogación significa que se acepta cualquier
		clase de tipo Pila.
		Restricción de objetos. Ejemplo:
		<? extends Number>
		Cualquier objeto que herede de Number
		*
		*/
		System.out.println(p.total());
	}
}