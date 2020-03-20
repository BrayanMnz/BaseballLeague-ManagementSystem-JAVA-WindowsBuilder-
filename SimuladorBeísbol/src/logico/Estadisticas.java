package logico;

import java.util.ArrayList;

public class Estadisticas {
	private ArrayList <Jugador> misJugadores;
	private ArrayList <Equipo> misEquipos;
	private Season miSeason;
	
	public Estadisticas() {
		misJugadores = new ArrayList <Jugador>(); 
		misEquipos = new ArrayList <Equipo>();
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
	public  void insertarJugador(Jugador aux) {  
		misJugadores.add(aux);  
	}
	public void setMiSeason(Season miSeason) {
		this.miSeason = miSeason;
	}
	public void setMisJugadores(ArrayList<Jugador> misJugadores) {
		this.misJugadores = misJugadores;
	}

	public void setMisEquipos(ArrayList<Equipo> misEquipos) {
		this.misEquipos = misEquipos;
	}
	public float cantErrores(String name) {
		float cantError=0;
		for (Jugador aux : miSeason.buscarJugadorNombreEquipo(name)) {
			cantError = cantError + aux.getErrores();
		}
		return cantError;
	}
	public float cantHits(String name) {
		float cantHits=0;
		for (Jugador aux : miSeason.buscarJugadorNombreEquipo(name)) {
			if (aux instanceof jugadorPosicion) {
				cantHits = ((jugadorPosicion) aux).getHits() + cantHits;
			}
		}
		return cantHits;
	}

	public float turnosAvg(String name) {
		return cantHits(name)/cantBateo(name);
	}
	public float cantCarreras(String name){
		float cantCarreras=0;
		for (Jugador aux : miSeason.buscarJugadorNombreEquipo(name)) {
			if (aux instanceof jugadorPosicion) {
				cantCarreras = ((jugadorPosicion) aux).getCarrerasAnotadas() + cantCarreras;
			}
		}
		return cantCarreras;
	}
	public float carrerasJuego(String name) {
		return (cantCarreras(name)/miSeason.buscarEquipoNombre(name).getCantJuegos());
	}

	public float cantHit(String name) {
		float cantHits=0;
		for (Jugador aux : miSeason.buscarJugadorNombreEquipo(name)) {
			if (aux instanceof jugadorPosicion) {
				cantHits = ((jugadorPosicion) aux).getHits() + cantHits;
			}
		}
		return cantHits;
	}
	public float cantBateo(String name) {
		float cantTurnos=0;
		for (Jugador aux : miSeason.buscarJugadorNombreEquipo(name)) {
			if (aux instanceof jugadorPosicion) {
				cantTurnos = ((jugadorPosicion) aux).getTurnos() + cantTurnos;
			}
		}
		return cantTurnos;
	}
}
