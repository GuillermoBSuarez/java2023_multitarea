package geometria;

public class DatosFigurasPolimorfismo {

	private Number n;
	
	public static void main(String[] args) {
		/*
		Triangulo tr = new Triangulo("amarillo", 6, 9);
		System.out.println("Color: " + tr.getColor());
		System.out.println("Superficie: " + tr.calcularArea());
		
		Circulo cr = new Circulo("azul", 7);
		System.out.println("Color: " + cr.getColor());
		System.out.println("Superficie: " + cr.calcularArea());
		*/
		
		mostrarDatos(new Triangulo("amarillo", 6, 9));
		mostrarDatos(new Circulo("azul", 7));
		
		
		/* EJEMPLO DE POLIMORFISMO: método que devuelva la parte entera de cualquier objeto numérico de envoltorio.
		   Double d=2.3;
		   Integer integ=7;
		   Float ft=3.4f;
		
		   metodo(d) -> 2
		   metodo(integ) ->7
		   metodo(ft) -> 3
		   
		   static int metodo(Number n) {
				return n.intValue();
		   }
		 */
	}

	static void mostrarDatos(Figura fr)
	{
		System.out.println("Color del " + fr.getClass().getSimpleName() + ": " + fr.getColor());
		System.out.println("Superficie del " + fr.getClass().getSimpleName() + ": " + fr.calcularArea());
	}
}
