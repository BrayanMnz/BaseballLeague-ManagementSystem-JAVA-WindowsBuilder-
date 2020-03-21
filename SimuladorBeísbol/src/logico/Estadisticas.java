package logico;

import java.util.ArrayList;

public class Estadisticas {
	private ArrayList <Jugador> misJugadores;
	private ArrayList <Equipo> misEquipos;
	private ArrayList<Season> miSeason;
	
	public Estadisticas() {
		misJugadores = new ArrayList <Jugador>(); 
		misEquipos = new ArrayList <Equipo>();
        miSeason = new ArrayList<Season>();
	}
	
	public ArrayList<Jugador> getMisJugadores() {
		return misJugadores;
	}

	public ArrayList<Equipo> getMisEquipos() {
		return misEquipos;
	}
	public  void insertarEquipo(Equipo aux) {  
		misEquipos.add(aux);  
	}
	public  void insertarSeason(Season aux) {  
		miSeason.add(aux);  
	}

	public void setMisJugadores(ArrayList<Jugador> misJugadores) {
		this.misJugadores = misJugadores;
	}

	public void setMisEquipos(ArrayList<Equipo> misEquipos) {
		this.misEquipos = misEquipos;
	}
	/*public float cantErrores(String name) {
		float cantError=0;
		for (Jugador aux : miSeason.buscarJugadorNombreEquipo(name)) {
			cantError = cantError + aux.getErrores();
		}
		return cantError;
	} */
	
	/* public float cantHits(String name) {
		float cantHits=0;
		for (Jugador aux : miSeason.buscarJugadorNombreEquipo(name)) {
			if (aux instanceof jugadorPosicion) {
				cantHits = ((jugadorPosicion) aux).getHits() + cantHits;
			}
		}
		return cantHits;
	} */

public float promColectivo(String idEquipo) { 
	float avg = 0; 
	for (Season auxSeason : miSeason) {
		Equipo auxEquipo = auxSeason.buscarEquipoById(idEquipo);
	 avg = ( (auxEquipo.totalHits())/(auxEquipo.totalTurnos()) );

	}
		return avg; }
	/* Efectividad individual del lanzado*/

	//public float carrerasJuego(String name) {
	//	return (cantCarreras(name)/miSeason.buscarEquipoById(name).getCantJuegos());
//	}

	
}
