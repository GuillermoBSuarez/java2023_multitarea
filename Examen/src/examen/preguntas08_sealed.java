package examen;

sealed interface Int1 permits Int2, R1 {
}

non-sealed interface Int2 extends Int1 {
}

record R1() implements Int1 {}					// line1

public class preguntas08_sealed {
	public static void main(String[] args) {
		Int1 i = new Int2() {};					// line2
		if (i instanceof R1) {
			System.out.println("Record");
		} else if (i instanceof Int1) {
			System.out.println("Interface");
		}
	}
}

/*
What will happen when the above program runs?
a) It prints "Record"
b) It prints "Interface"
c) It prints nothing, but it compiles ok
d) Compilation error at line1
e) Compilation error at line2

*/
