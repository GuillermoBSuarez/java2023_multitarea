package examen;

class Externa{
	static int n = 5;
	int p = 1;
	class Interna{
		public void print() {
			System.out.println(n+"-"+p);
		}
	}
}
public class preguntas03_clases_internas_estandares {
	/* INCORRECTO:
	Externa.Interna in = new External.Internal(); */
	Externa.Interna in = (new Externa()).new Interna();
}

// Buscar clases internas estáticas y estándares