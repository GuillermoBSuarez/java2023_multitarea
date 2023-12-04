import java.nio.file.Path;

public class Test {

	public static void main(String[] arg) {
		Path p1 = Path.of("/temp/data/file.txt");
		Path p2 = Path.of("temp/./frames/one.txt");
		System.out.println(p1.relativize(p2));

	}

}
