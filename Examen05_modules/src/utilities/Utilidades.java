/* Nota: al crear el PROYECTO, ahora ya sí, marcamos crear el module-info, así que el nombre del proyecto
no puede empezar por número. Lo exportamos con clic derecho sobre el proyecto > Exportar > Java > jar, etc. */

package utilities;

public class Utilidades {
	
	// Dos métodos que devuelven el mayor y menor, respectivamente, de dos números
	public static int mayor(int a, int b) {
		return Math.max(a, b);
	}
	
	public static int menor(int a, int b) {
		return Math.min(a, b);
	}
}
