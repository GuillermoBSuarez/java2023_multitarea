package examen;

public class preguntas02_static {

}

class Test{
	static int a;
	int b;
	static void m1() {
		a++;
		b++;				// Un elemento no estático no puede acceder a uno estático.
	}
	void m2() {
		a++;
		Test.m1();
	}
	static void m3() {
		m1();
		m2();				// Un elemento no estático no puede acceder a uno estático.
	}
}



