package ajedrez;

public class ajedrez {

	public static void main(String[] args) {
		
		String[][] ajedrez = new String[8][8];
		for (int x=0; x<8; x++) {
			for (int y=0; y<8; y++) {
				if ((x+y)%2==0) {ajedrez[x][y]=" 	";}
				else {ajedrez[x][y]="█";}
			}
		}
		for (String[] fila:ajedrez) {
			for (String casilla:fila) {
				System.out.print(casilla);
			}
			System.out.println();
		}
	}
}
