// Clase para crear y tratar nuestra excepción personalizada del método EmpleadoService.actualizarSalario()

package exceptions;

public class ModificacionException extends Exception {			// Debe heredar Exception
	String message;
	
	public ModificacionException (String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
