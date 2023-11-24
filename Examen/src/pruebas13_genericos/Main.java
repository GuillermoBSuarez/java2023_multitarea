package pruebas13_genericos;

public class Main {

	public static void main(String[] args) {
		// Encapsular Integer
		pila<Integer> c1 = new pila<Integer>(50);
		System.out.println("¿Es null? " + c1.isNull());
		
		// Encapsular String
		pila<String> c2 = new pila<String>("");
		System.out.println("¿Es null? " + c2.isNull());

	}

}
