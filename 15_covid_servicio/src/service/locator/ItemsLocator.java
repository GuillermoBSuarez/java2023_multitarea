package service.locator;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Arrays;
import java.util.stream.Stream;

import com.google.gson.Gson;

import model.Pais;

public class ItemsLocator {
	
	// Cambiamos el origen de los datos a una url, una restful API
	
	static String ruta="https://opendata.ecdc.europa.eu/covid19/nationalcasedeath/json/";
	
	public static Stream<Pais> getJsonStream(){
		Gson gson=new Gson();
		
		// Creamos el request
		HttpRequest request = HttpRequest.newBuilder()				// Devuelve un builder que vamos a ir configurando, al estilo streams
										 .uri(URI.create(ruta))		// Devuelve un builder con la ruta
										 .GET()						// Devuelve un builder con ruta y tipo de llamada, get
										 .build();					// Ahora ya me devuelve el HttpRequest
		// Creamos el cliente
		HttpClient client = HttpClient.newBuilder()					// Devuelve un builder que vamos a ir configurando.
									  .version(Version.HTTP_1_1)	// Devuelve un builder con la versión de HTTP
									  .build();						// Devuelve un HttpClient
		try {
			// Lanzamos la petición
			HttpResponse response = client.send(request, BodyHandlers.ofString());
			/* Ver método send: https://docs.oracle.com/en/java/javase/17/docs/api/java.net.http/java/net/http/HttpClient.html
			Devuelve un httpresponse tras enviarle un request y la forma en que queremos la respuesta.
			Lo definimos con una interfaz bodyhandler, que definimos con una clase BodyHandlers y su método estático ofX. En nuestro
			casi ofString porque lo queremos en cadena. */
			
			String json = response.body().toString();
			/* Aquí ya tenemos un string con todos los datos. Ahora se lo pasamos al Gson. */
			Pais[] paises = gson.fromJson(json, Pais[].class);
			return Arrays.stream(paises);
		} catch (IOException | InterruptedException ex) {
			ex.printStackTrace();
			return Stream.empty();
		}
	}
}