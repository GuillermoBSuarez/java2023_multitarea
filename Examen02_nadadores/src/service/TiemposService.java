package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TiemposService {
	
	public double[] tiempos() {
		String dir = "c:\\temp\\tiempos.txt";
		
		Path path = Path.of(dir);
		try {
			return Files.lines(path)										// Stream<String>
					.mapToDouble( s -> Double.parseDouble(s.split(",")[1]))	// DoubleStream
					.toArray();												// Array<double>
		} catch (IOException ex) {
			return new double[0];
		}
	}
}