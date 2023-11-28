/* Importar jar, clic derecho en el proyecto > Properties > Java Build Path > pestaña Libraries > Add external jar... */

package pruebas;

import service.Operaciones;

public class TestAritmetica {

	public static void main(String[] args) {
		Operaciones op = new Operaciones(3, 9);
		/* Tras escribir y añadir imports sigue dando error...
		hasta que se incluya el modules en el module-info del proyecto origen */
		System.out.println(op.sumar());
		System.out.println(op.restar());
	}
}