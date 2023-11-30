package model;

import java.io.Serializable;

public class Persona extends Empleado implements Serializable {
	String nombre;
	transient String DNI;
	int edad;
	Empleado emp;
	/* Error. La clase Empleado no es serializable. Si creamos un objeto Persona que tiene de atributo un objeto Empleado,
	que no es serializable, al tratar de serializarlo para guardarlo da una NotSerializableException. Si se marca como transient
	no hay problema. */
	
	public Persona() {}
	
	public Persona(String nombre, String DNI, int edad, Empleado emp) {
		super();
		this.nombre = nombre;
		this.DNI = DNI;
		this.edad = edad;
		this.emp = emp;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String DNI) {
		DNI = DNI;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Empleado getEmp() {
		return emp;
	}

	public void setEmp(Empleado emp) {
		this.emp = emp;
	}	
}