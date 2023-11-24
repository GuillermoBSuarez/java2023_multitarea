/* Crear una clase que permita encapsular cualquier tipo de objeto Java.
-Tendrá un constructor que permita inicializar el objeto de la clase con el dato a encapsular
-Tendrá métodos setter y getter
-Tendrá un método isNull() que devolverá null si el objeto encapsulado es nulo */ 

package pruebas12_genericos;

public class capsula<X> {
	X dato;
	/* dato sólo tiene los métodos de Object, que son los únicos comunes a todos los tipos de objetos */

	public capsula(X dato) {				// CONSTRUCTOR
		this.dato = dato;
	}

	public X getDato() { return dato; }
	
	public void setDato(X dato) { this.dato = dato; }

	public boolean isNull() {
		return dato==null;
	}
}