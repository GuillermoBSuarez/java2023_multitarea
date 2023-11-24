package examen;

import java.util.Arrays;
import java.util.Comparator;

public class preguntas12_binarySearch {

	public static void main(String[] args) {
		int[] n = {7,1,8,3,2};
		String[] m = {"abc","ab","xys","v"};
		Comparator<String> cmp = (a,b)->Integer.compare(a.length(),b.length());
		String[] x = m;		// ref. mem.
		Arrays.sort(x,cmp);	// v,ab,abc,xys
		
		System.out.println(Arrays.binarySearch(n, 3));				// impredecible
		System.out.println(Arrays.binarySearch(n, 22));				// impredecible
		System.out.println(Arrays.binarySearch(x, "ab"));			// 1
		System.out.println(Arrays.binarySearch(m, "myclass", cmp));	// -5
		/* ¿Por qué añadimos cmp? Porque si no se especifica el criterio CON EL QUE YA SE HA ORDENADO
		asumirá que es alfabéticamente, la ordenación natural de Strings, y asumirá que el lugar de myclass
		es en la cuarta posición, entre abc y xys. Especificando cmp entiende que ha sido por longitud,
		por lo que asume que myclass tendría que ir en la quinta posición, la última. */		
	}
}