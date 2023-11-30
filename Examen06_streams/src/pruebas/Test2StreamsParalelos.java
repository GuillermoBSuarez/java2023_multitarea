package pruebas;

import java.util.Arrays;
import java.util.stream.Stream;

public class Test2StreamsParalelos {

	public static void main(String[] args) {
		Stream<Integer> stream = Stream.of(8,1,-2,6,5,11,9,-3,5,8);
//		System.out.println(stream
//				.parallel()
//				.count());
		
//		stream.parallel().forEach(System.out::println);
		
//		stream.parallel()
//			.filter( n -> n>0 )
//			// Una vez paralelizado, todo lo que devuelven los siguientes métodos también lo son.
//			.forEach(System.out::println);
		
//		stream.parallel()
//		.sequential()  // Desparalelizado
//		.forEach(System.out::println);

		Stream<Integer> st = Stream.of(8,1,-2,6,5,11,9,-3,5,8);
		// quitar duplicados y negativos, ordenar y mostrar
		st.parallel()
			.distinct()
			.filter(n->n>0)
			.sorted()
			.sequential()
			.forEach(System.out::println);
		
		Stream<Integer> numbers=Stream.of(11,-2,6,4,3,2,6,1,3);		
		System.out.println(Arrays.binarySearch(numbers
		.parallel()
		.distinct()
		.sorted()
		.toArray(a->new Integer[a]),6));
		
		
	}

}
