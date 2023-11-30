package pruebas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test3 {
	public static void main(String[] args) throws IOException {
		 var fro=new FileWriter("sales.txt");
	   	 try(var fri=new FileReader("com.txt");
	   	        var br=new BufferedReader(fri); fro){
	   		 fro.write(br.readLine());   	 
	   	 }
	   	 fro.write("");
	}
}
