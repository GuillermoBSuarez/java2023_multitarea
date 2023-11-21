package examen;

record Course(String name, int duration){
	Course{duration=duration*10;}
}

enum Option{
	ONE(1), TWO(2), THREE(3);
 	int r;
	Option(int r){
		this.r=r;
	}
}
record Process(Option... ops){}


public class preguntas06_enumerados {

	public static void main(String[] args) {
		
		enum Dias{LUNES,MARTES,MIERCOLES,JUEVES,VIERNES;}
		Dias d=Dias.JUEVES;
		String result=switch (d) {
			case LUNES,MARTES,MIERCOLES -> "pronto";
			case JUEVES -> "correcto";
			case VIERNES -> "tarde";
		};
		// No necesita default porque se contemplan todos los posibles casos.
		System.out.println(result);
		
		Process p1=new Process(Option.ONE);
		Process p2=new Process(Option.TWO);
		System.out.print(p1==p2);
		System.out.print(p1.ops()[0]);
		System.out.print(p2.ops()[0]);

	}
}