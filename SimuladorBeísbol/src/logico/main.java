package logico;

public class main {

	private static Season s1;
	private static Estadisticas e1;

	public static void main(String[] args) {
		Partido partido = new Partido(null, null, null);
		Season s1 = new Season();
		Estadisticas e1 = new Estadisticas();
		Pitcher p1 = new Pitcher("Pepe", "2", 2, 1, "Redsox", false, 2, 2, 4, 2, 2 , 9, 2, 3, 1,2);
		Pitcher p2 = new Pitcher("Elvis", "4", 2, 1, "Yankees", false, 2, 2, 1, 2, 3 , 25, 2, 5, 1,2);
		jugadorPosicion bate1 = new jugadorPosicion("Yehudy","24", 2,3,"Yankees",false,10,12,3,10,3,5,6,"2",2, 0);
		jugadorPosicion bate2 = new jugadorPosicion("Brayan","25", 5,6,"Redsox",false,10,14,3,8,3,6,10,"5",2, 0);
		Equipo redsox = new Equipo ("Redsox","2","Estadio","Hola",15,13,2);
		Equipo Yankees = new Equipo("Yankees", "NYY", "Yankee Stadium", "Aaron Boone", 10, 0, 0);
		e1.insertarSeason(s1);
        s1.insertarEquipo(Yankees);  
		s1.insertarEquipo(redsox);
		//s1.insertarJugador(bate1);
		//s1.insertarJugador(bate2);
		redsox.insertarJugador(p1);
		Yankees.insertarJugador(p2);
		Yankees.insertarJugador(bate1);
		redsox.insertarJugador(bate2);
	//	System.out.println(bate1.promBateo());
	//	System.out.println(p1.efectividad());
	// System.out.println(Yankees.totalCarreras());
	//	System.out.println(Yankees.totalGanados());
	//	System.out.println(Yankees.totalPerdidos());
	//	System.out.println(redsox.totalGanados());
	//	System.out.println(redsox.totalPerdidos());
	//	System.out.println(redsox.efectividad("4"));
	//	System.out.println(redsox.buscarJugadorByDorsal("2").getNombre());
	//	System.out.println(redsox.totalHits());
	//	System.out.println(redsox.totalInnings());
	//	System.out.println(redsox.totalHits());
	//	System.out.println(redsox.totalTurnos());
		//System.out.println(redsox.jugadorLesionado("24", "si"));
		//System.out.println(e1.promColectivo("2"));
		//System.out.println(partido.insertarEquipoLocal("NYY"));
		//System.out.println(partido.getLocal().nombreEquipo);
	  partido.setLocal(redsox);
	  System.out.println(partido.getLocal().nombreEquipo);
	}
}