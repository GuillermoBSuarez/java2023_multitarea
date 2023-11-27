/* Crear la clase PilaNumber (LIFO)
Sólo nos permitirá apilar numeros, por lo que se implementará con tipos genéricos.
Métodos:
- agregar. Recibe el número y lo guarda en la pila
- sacar. Devuelve y elimina de la pila el último número introducido
- total. Devuelve el total de número que hay en la pila
- sum(). Devuelve la suma en tipo float de todos los números. 
*/

package pruebas13_genericos;

import java.util.ArrayList;
import java.util.List;

public class PilaNumber<N extends Number> {
	ArrayList<N> pila = new ArrayList<>();

	public void agregar(N number) {
		pila.add(number);
	}
	
	public N sacar() {
		return pila.remove(pila.size()-1);
	}
	
	public int total() {
		return pila.size();
	}

	// Devuelve la suma de los números en float
	public double sum() {
		double suma = 0;
		for (N number:pila) { suma += number.doubleValue(); }
		return suma;
	}
}