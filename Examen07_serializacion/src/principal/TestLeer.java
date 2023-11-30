package principal;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import model.Persona;

public class TestLeer {

	public static void main(String[] args) {
		try (FileInputStream fis = new FileInputStream("persona.obj");
			 ObjectInputStream ois = new ObjectInputStream(fis)) {
			Persona p = (Persona) ois.readObject();
			System.out.println(p.getNombre());
			System.out.println(p.getDNI());
			System.out.println(p.getEdad());
			System.out.println(p.getcodigo());
		} catch (IOException | ClassNotFoundException ex) {
			/* ClassNotFound es OBLIGATORIO capturarla.
			ClassCastException no es obligatorio, es runtime. */
			ex.printStackTrace();
		}
	}
}