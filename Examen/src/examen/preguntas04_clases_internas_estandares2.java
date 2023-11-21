package examen;

class Externa{
	static int n = 2;
	int p = 10;
	public void pr() {
		int w = 1;
		class Interna {
			int s = 1;
			// w++;
			public void print() {
				System.out.println(s+"-"+n+"-"+p+"-"+w);
			}
		}
	}
}

/* Accede a todas las variables: de clase externa, del método
y de la propia clase. Pero a las locales del método sólo puede acceder
si se tratan como constanes, si nunca cambia su valor.
No es necesario poner final pero si se altera su valor peta.
Ejemplo: si ponemos un w++ después de declarar e instanciar w.

Dentro del método pr se podría crear un objeto de clase Interna,
pero no fuera. Es una clase para uso exclusivo del método donde está.
Fuera del método, la clase interna no existe.

*/

public class preguntas_clases_internas_estandares {
}