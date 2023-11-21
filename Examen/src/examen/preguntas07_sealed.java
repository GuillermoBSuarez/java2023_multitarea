package examen;

sealed interface I1 permits C1,I2,I3{}

class C1 implements I1{}			// Falta el modificador: sealed, non-sealed o final

sealed interface I2 extends I1{}	// Falta a qué clases permite heredar porque es sealed: permits x, y...

final interface I3 extends I1{}		// No puede ser final

final class C1 implements I1{}		// Correcta

non-sealed interface I2 extends I1{}// Correcta

interface I4 extends I1{}			// Falta el modificador y no está en la lista de permitidas

public class preguntas07_sealed {}