package examen;

import java.util.ArrayList;
import java.util.List;

public class preguntas09_listas {

	public static void main(String[] args) {
		List<Integer> lst = new ArrayList<Integer>(List.of(2,5,7,7,1));
		System.out.println(lst.remove(2));
		System.out.println(lst.get(0));
	}
}