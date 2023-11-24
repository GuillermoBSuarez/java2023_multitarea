/* Crear una clase para apilar objetos (LIFO). Permitirá apilar cualquier tipo de objeto,
por lo que se implementará con tipos genéricos. Métodos:
- Agregar() - Recibe el dato y lo guarda.
- Sacar() - Devuelve y elimina el último elemento.
- Total() - Devuelve el total de elementos de la pila.
*/ 

package pruebas13_genericos;

import java.util.ArrayList;

public class pila<T> {
	ArrayList<T> pila = new ArrayList<T>();
	
	public pila() {
	}

	public void agregar(T dato) {
		pila.add(dato);
	}
	
	public T elimina() {
		T t = pila..size()-1
		pila.remove(pila.size()-1);
	}
}