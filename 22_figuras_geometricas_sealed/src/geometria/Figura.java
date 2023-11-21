package geometria;

sealed public abstract class Figura permits Circulo, Triangulo {
	
	private String color;

	public Figura(String color) {
		super();
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public abstract double calcularArea();
		// método abstract sólo sirve para que lo hereden las subclases, de momento es imposible
		// calcular un área sin saber qué figura geométrica es.
		// Info: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/AbstractList.html
}
