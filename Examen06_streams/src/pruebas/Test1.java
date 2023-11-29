package pruebas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Test1 {

	public static void main(String[] args) {
		String names = "Juan,Ana,Marta,Luis,Juan,Pedro,Marta,Lucas";
		// Imprimirlos sin repetidos y en mayúsculas
		Arrays.stream(names.split(","))
			.distinct()
//			.map(n -> n.toUpperCase())
			.forEach(n -> System.out.println(n.toUpperCase()));
		
		List<Integer> list = List.of(8,1,-2,6,5,11,9,-3,5,8);
		// Media de los positivos
		System.out.println(list.stream()
			.filter(n->n>0)
			.mapToInt(n->n)
			.average()
			.orElse(0));
		// Mostrar pares de mayor a menor
		list.stream()
				.filter(n->n%2==0)
				.sorted((a,b) -> b - a)
				.forEach(n -> System.out.println(n));
		// Número más alto
		System.out.println(list.stream()
				.max((a,b) -> a - b)
				.orElse(0));
		
		// peek
		list.stream().peek(System.out::println).count();
	}
}