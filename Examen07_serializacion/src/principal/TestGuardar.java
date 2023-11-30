package principal;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import model.Persona;

public class TestGuardar {

	public static void main(String[] args) {
		Persona p = new Persona("nombre1", "dni1", 1, "cod1");
//		Persona p = new Persona("nombre2", "dni2", 2);
//		Persona p = new Persona("nombre3", "dni3", 3);
		
		try (FileOutputStream fos = new FileOutputStream("persona.obj");
			 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
				oos.writeObject(p);
				System.out.println("guardado");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}