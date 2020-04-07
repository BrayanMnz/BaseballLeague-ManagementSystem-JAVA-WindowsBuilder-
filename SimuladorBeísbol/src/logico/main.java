package logico;

import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class main implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Season s1;
	private static Estadisticas e1;


	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Liga liga1 = new Liga();
		Season s1 = new Season();
		
		Equipo redsox = new Equipo ("Redsox","BOS","FenWay","Roe Roenicke",null);
		Equipo Yankees = new Equipo("Yankees", "NYY", "Yankee Stadium", "Aaron Boone",null);
	//    liga1.insertarSeason(s1);
		Date fechaFinal = new Date();
		Date fecha = new Date();
		Date fechad = new Date(120, 02, 25);
		SimpleDateFormat fechaformat = new SimpleDateFormat("dd/MM/yyyy");
	    String fechaActual = fechaformat.format(fecha);
	    String fechaFutura = fechaformat.format(fechad);
   System.out.println(fechaFutura);
	Partido partido = new Partido(Yankees, redsox, "Fenway", "");
	Partido partido1 = new Partido(Yankees, redsox, "Fenway", "");
		liga1.insertarPartido(partido);

		liga1.insertarPartido(partido1);
		liga1.insertarPartido(partido);
  //   System.out.println(liga1.getCantPartidos());
// System.out.println(Liga.isControl());
	 
		jugadorPosicion bate1 = new jugadorPosicion("Yehudy","24", "2","3","Yankees","10","12","2");
	//	jugadorPosicion bate2 = new jugadorPosicion("Brayan","25", "5","6","Redsox","10","14","5");
	//	bate1.setHits(2);
		
	bate1.setHitsPartido(4);
	bate1.setHitsPartido(10);
System.out.println(bate1.totalHits());
System.out.println(bate1.getHits());
		//s1.insertarJugador(bate1);
		//s1.insertarJugador(bate2);
	//	redsox.insertarJugador(p1);
	//	Yankees.insertarJugador(p2);
	//	Yankees.insertarJugador(bate1);
	//	redsox.insertarJugador(bate2);
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
	//  partido.setLocal(redsox);
	  //System.out.println(partido.getLocal().nombreEquipo);
	//	Lesion l1 = new Lesion( "Brayan", fechaActual, fechaFinal, "esguince 1er grado");
      //  redsox.insertarJugadorAlineacion(bate2);
//		bate2.insertarLesion(l1);
	//	System.out.println(bate2.lesionado);
		//System.out.println(l1.getFechaInicioLesion());
//		jugadorPosicion b1 = new jugadorPosicion("Elvis", "", 2, 2, "RedSox", false, 32, 43, "");
  //      jugadorPosicion b2 = new jugadorPosicion("Elvis", "", 2, 2, "RedSox", false, 32, 43, "");
	//	jugadorPosicion b3 = new jugadorPosicion("Elvis", "", 2, 2, "RedSox", false, 32, 43, "");
//		jugadorPosicion b4 = new jugadorPosicion("Elvis", "", 2, 2, "RedSox", false, 32, 43, "");
	//	jugadorPosicion b5 = new jugadorPosicion("Elvis", "", 2, 2, "RedSox", false, 32, 43, "");
	//	jugadorPosicion b6 = new jugadorPosicion("Elvis", "", 2, 2, "RedSox", false, 32, 43, "");
	//	jugadorPosicion b7 = new jugadorPosicion("Elvis", "", 2, 2, "RedSox", false, 32, 43, "");
		//jugadorPosicion b8 = new jugadorPosicion("Elvis", "", 2, 2, "RedSox", false, 32, 43, "");
		//jugadorPosicion b9 = new jugadorPosicion("Elvis", "", 2, 2, "RedSox", false, 32, 43, "");
		//redsox.insertarJugadorAlineacion(b1);
		//redsox.insertarJugador(b2);
		//redsox.insertarJugador(b3);
		//redsox.insertarJugador(b4);
		//redsox.insertarJugador(b5);
	//	redsox.insertarJugador(b6);
//		redsox.insertarJugador(b7);
//		
//		partido.setLocal(redsox);
//		partido.setVisitante(Yankees);
//	    partido.setLocalRun(5);
//	    partido.setVisitaRun(4);
//		System.out.println(l1.getFechaInicioLesion());
		//System.out.println(l1.getFechaFinalLesion());
	//	System.out.println("El equipo ganador es: " +partido.ganadorPartido().getNombreEquipo());
		//redsox.insertarJugador(b8);
		//redsox.insertarJugador(b9);
//		System.out.println(redsox.nominaEquipo());
		
   //    System.out.println(Yankees.getFechaFundacion());

		
	}
}