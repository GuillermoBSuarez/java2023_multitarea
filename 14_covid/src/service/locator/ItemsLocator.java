package service.locator;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

import com.google.gson.Gson;

import model.Pais;

public class ItemsLocator {
	
	static String ruta="c:\\temp\\covid.json";
	
	public static Stream<Pais> getJsonStream(){
		Gson gson=new Gson();
		
		try( FileReader fr = new FileReader(ruta) ) {
			Pais[] paises = gson.fromJson(fr, Pais[].class);
			return Arrays.stream(paises);
		} catch(IOException ex) {
			ex.printStackTrace();
			return Stream.empty();
		}	
	}
}