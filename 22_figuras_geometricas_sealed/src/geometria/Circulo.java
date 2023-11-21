package geometria;

non-sealed public class Circulo extends Figura {
	private double radio;
		
	public Circulo(String color, double radio) {
		super(color);
		this.radio = radio;
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	@Override
	public double calcularArea() {
		return Math.PI*(radio*radio);
	}
}
