package examen;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Alumno {
	private String name;
	private int age;

	public Alumno(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }
}

public class pruebas10_listas {

	public static void main(String[] args) {
		var lst = new ArrayList<Alumno>(
				List.of(new Alumno("A", 27), new Alumno("X", 19), new Alumno("Z", 31), new Alumno("H", 22)));

		// Mostrar los nombres de alumnos ordenados inversamente:

		// Tres formas:
//		lst.sort((a,b) -> b.getAge()-a.getAge());
//		lst.sort((a,b) -> Integer.compare(b.getAge(), a.getAge()));
//		lst.sort(Comparator.comparingInt(a->((Alumno) a).getAge()).reversed());
		lst.forEach(a->System.out.println(a.getName()));
	}
}