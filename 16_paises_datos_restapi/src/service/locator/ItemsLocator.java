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
	
	static String ruta="https://restcountries.com/v2/all";
	
	public static Stream<Pais> getJsonStream(){
		Gson gson=new Gson();
		
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(ruta)).GET().build();
		HttpClient client = HttpClient.newBuilder().version(Version.HTTP_1_1).build();
		try {
			HttpResponse response = client.send(request, BodyHandlers.ofString());
			String json = response.body().toString();
			Pais[] paises = gson.fromJson(json, Pais[].class);
			return Arrays.stream(paises);
		} catch (IOException | InterruptedException ex) {
			ex.printStackTrace();
			return Stream.empty();
		}
	}
}