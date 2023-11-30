package model;

import java.io.Serializable;

class Empleado {
	String codigo;

	public Empleado(String codigo) {
		super();
		codigo = codigo;
	}

	public Empleado() {}

	public String getcodigo() {
		return codigo;
	}

	public void setcodigo(String codigo) {
		codigo = codigo;
	}	
}

/* OJO, clase no serializable. Persona va a heredar un atributo no serializable, código.
Por tanto, el método guardar no va a serializar ese argumento y guardará NULL.
Después, la clase TestLeer, cuando recupere un objeto serializable que hereda de una clase no serializable,
al deserializarlo LLAMARÁ AL CONSTRUCTOR DEFAULT (sin parámetros) de la serializable,
que a su vez llamará al default de la clase padre. Por tanto, deben estar los dos o peta. */

public class Persona extends Empleado implements Serializable {
	String nombre;
	transient String DNI;
	int edad;
	
	/* int trascient edad
	haría que este atributo no se guardase al serializar. En ese caso
	y en este ejemplo, al recuperar y crear un getEdad iniciaría ese campo
	con el valor por defecto de un int, es decir, 0 */


	public Persona(String nombre, String dNI, int edad, String codigo) {
		super(codigo);
		this.nombre = nombre;
		DNI = dNI;
		this.edad = edad;
	}
	
	public Persona() {}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
}
