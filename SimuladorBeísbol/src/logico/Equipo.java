package logico;

import java.util.ArrayList;

public class Equipo {
	
	private ArrayList <Jugador> jugadores;
	private float  gp; //juegos jugados
	private float carreras; //r
	private float hr; //home runs
	private float derrotas;
	private float victorias;
	private float inningsColectivo;
	private float savesColectivo;
	public Equipo(ArrayList<Jugador> jugadores, float gp, float carreras, float hr, float promedioBat,float victorias ) {
		super();
		jugadores = new ArrayList <Jugador>();
		this.gp = gp;
		this.carreras = carreras;
		this.hr = hr;
		this.derrotas = derrotas;
		this.victorias = victorias;
	}
	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}
	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	public float getGp() {
		return gp;
	}
	public void setGp(float gp) {
		this.gp = gp;
	}
	public float getCarreras() {
		return carreras;
	}
	public void setCarreras(float carreras) {
		this.carreras = carreras;
	}
	public float getHr() {
		return hr;
	}
	public void setHr(float hr) {
		this.hr = hr;
	}

	public float getDerrotas() {
		return derrotas;
	}
	public void setDerrotas(float derrotas) {
		this.derrotas = derrotas;
	}
	public float getVictorias() {
		return victorias;
	}
	public void setVictorias(float victorias) {
		this.victorias = victorias;
	}

	public float CantErrores() {
		float cantErrores = 0;
		for (Jugador aux : jugadores) {
			cantErrores = cantErrores + aux.getErrores();
		}
		return cantErrores;
	}

	public float cantHits() {
		float cantHits=0;
		for (Jugador aux : jugadores) {
			if (aux instanceof jugadorPosicion) {
				cantHits =  ((jugadorPosicion) aux).getHits() + cantHits;
			}
		}
		return cantHits;
	}
	public float cantBateo() {
		float cantBateo=0;
		for (Jugador aux : jugadores) {
			if (aux instanceof jugadorPosicion) {
				cantBateo =  ((jugadorPosicion) aux).getTurnos() + cantBateo;
			}
		}
		return cantBateo;
	}
	public float battingAvg() {
		return cantHits()/cantBateo();
	}
	public float carrerasJuego() {
		return carreras/gp;
	}
	
}
