package examen;

class Aa{
	private static int c=2;
	static void m() {
		System.out.println(c);		// 1
	}
	static class B{
		void print() {
			c++;					// 2
			m();					// 3
		}
	}
}

public class preguntas05_clases_internas_estandares3 {
	public static void main(String[] args) {
		Aa.B obj=new Aa.B();
		obj.print();				// 4
	}
}

/* Al ejecutar:
A. muestra 3
B. muestra 2
C. error de compilación en línea 1
D. error de compilación en línea 2
E. error de compilación en línea 3
F. error de compilación en línea 4

La A.
La clase estática puede usar cualquier cosa de la clase externa.
*/ 
