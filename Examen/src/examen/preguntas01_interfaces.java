package examen;

//interface I1{
//	default void m() { }
//}
//
//interface I2{
//	default void m() { }
//}
//public class preguntas_interfaces implements I1, I2{
//
//	@Override
//	public void m() {
//	}
//}

//interface My{
//	void m();
//}
//
//interface Mx{
//	default void t() {}
//}
//
//class A implements My, Mx {
//	void t() {}
//}
//
//abstract class B implements My, Mx{}
//
//class C implements My, Mx{}
//
//class D implements Mx{
//	private void t(int s) {}
//}



interface I1{
	void m();
}

interface I2 extends I1{
	default void m(int a) {}
	void k();
}

class C1{
	void p() {}
}

class A extends C1 implements I2{
	public void m(int p) {}			// Sobreescritura. m se sobrecargaba en I2. 
	public void k(int s) {}			// Sobrecarga
	public int k(String g) {}		// Sobrecarga, el cambio en el tipo de devolución no se tiene en cuenta
	public void k() {}				// Sobreescritura 
	public int p(){}				// Sobreescritura con error porque cambia la devolución
	void m(){}						// Sobreescritura con error porque reduce el ámbito, era público por defecto en la interfaz y aquí es default
	public int p(String s)			// Sobrecarga, el cambio en el tipo de devolución no se tiene en cuenta
	public void p(){}				// Sobreescritura con error porque es el mismo, exacto, que el heredado
}