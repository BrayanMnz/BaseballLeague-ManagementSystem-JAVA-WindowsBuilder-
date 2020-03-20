package logico;

public class main {

	private static Season s1;
	private static Estadisticas e1;

	public static void main(String[] args) {
		Season s1 = new Season();
		Estadisticas e1 = new Estadisticas();
		jugadorPosicion bate1 = new jugadorPosicion("Yehudy","24",10,3,"Redsox",false,10,12,5,10,3,5,6,"2");
		jugadorPosicion bate2 = new jugadorPosicion("Brayan","25", 5,6,"Redsox",false,10,14,3,8,3,6,9,"5");
		Equipo redsox = new Equipo ("Redsox","2","Estadio","Hola",15,13,2);
		
		redsox.insertarJugador(bate1);
		redsox.insertarJugador(bate2);
		s1.insertarJugador(bate1);
		s1.insertarJugador(bate2);
		s1.insertarEquipo(redsox);
		e1.insertarJugador(bate1);
		e1.insertarJugador(bate2);
		e1.setMiSeason(s1);

		System.out.println(e1.turnosAvg("Redsox"));
		System.out.println(e1.cantCarreras("Redsox"));
		System.out.println(e1.cantErrores("Redsox"));
		System.out.println(e1.cantJuegos("Redsox"));
		System.out.println(e1.carrerasJuego("Redsox"));
	}
}