package pruebas12_genericos;

public class Main {

	public static void main(String[] args) {
		// Encapsular Integer
		capsula<Integer> c1 = new capsula<Integer>(50);
		System.out.println("¿Es null? " + c1.isNull());
		
		// Encapsular String
		capsula<String> c2 = new capsula<String>("");
		System.out.println("¿Es null? " + c2.isNull());

	}

}
