package logico;

import java.util.ArrayList;

public class Equipo {
	
	private ArrayList <Jugador> jugadores;
	private float  gp; //juegos jugados
	private float carreras; //r
	private float hr; //home runs
	private float promedioBat; //batting average
	private float porcBase; //en base porcentaje
	private float porcSlugging; //% de slugging  ([Hits] + [Doubles] + [Triples x 2] + [Home Runs x 3])/At Bats
	private float derrotas;
	private float victorias;
	private float promCarreras; //promedio carreras
	private float inningPit; //innings pitchados
	private float strike; //strikes 
	private float errores; 
	private float outs; //putouts
	private float chances;
	private String manager;
	public Equipo(ArrayList<Jugador> jugadores, float gp, float carreras, float hr, float promedioBat, float porcBase,
			float porcSlugging, float derrotas, float victorias, float promCarreras, float inningPit, float strike,
			float errores, float outs, float chances, String manager) {
		super();
		jugadores = new ArrayList <Jugador>();
		this.gp = gp;
		this.carreras = carreras;
		this.hr = hr;
		this.promedioBat = promedioBat;
		this.porcBase = porcBase;
		this.porcSlugging = porcSlugging;
		this.derrotas = derrotas;
		this.victorias = victorias;
		this.promCarreras = promCarreras;
		this.inningPit = inningPit;
		this.strike = strike;
		this.errores = errores;
		this.outs = outs;
		this.chances = chances;
		this.manager = manager;
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
	public float getPromedioBat() {
		return promedioBat;
	}
	public void setPromedioBat(float promedioBat) {
		this.promedioBat = promedioBat;
	}
	public float getPorcBase() {
		return porcBase;
	}
	public void setPorcBase(float porcBase) {
		this.porcBase = porcBase;
	}
	public float getPorcSlugging() {
		return porcSlugging;
	}
	public void setPorcSlugging(float porcSlugging) {
		this.porcSlugging = porcSlugging;
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
	public float getPromCarreras() {
		return promCarreras;
	}
	public void setPromCarreras(float promCarreras) {
		this.promCarreras = promCarreras;
	}
	public float getInningPit() {
		return inningPit;
	}
	public void setInningPit(float inningPit) {
		this.inningPit = inningPit;
	}
	public float getStrike() {
		return strike;
	}
	public void setStrike(float strike) {
		this.strike = strike;
	}
	public float getErrores() {
		return errores;
	}
	public void setErrores(float errores) {
		this.errores = errores;
	}
	public float getOuts() {
		return outs;
	}
	public void setOuts(float outs) {
		this.outs = outs;
	}
	public float getChances() {
		return chances;
	}
	public void setChances(float chances) {
		this.chances = chances;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}

//	private float ab; //at bat
//	private float hits; //hits
//	private float dobles; //dobles
	//private float triples; //triples
	//private float tb; //bases totales
	//private float carrerasBateadas; //runs batted in

	//private float ops; //on base plus slugging 
	//private float cierres; //shutouts, un pitcher no deja que el equipo haga ni una carrera


	//private float salvados; //saves
	//ivate float juegoCompleto; //partidas completas con un solo pitcher
	//private float inicioCalidad; //Inicios de calidadd
	//private float bola; //bb o walk

	//private float fctp; //fildeo por jugador
	//private float asis; //asistencias
}
