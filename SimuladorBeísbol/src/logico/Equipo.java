package logico;

import java.util.ArrayList;

public class Equipo {
	private ArrayList <Jugador> misJugadores;
	public String nombreEquipo; 
	public String id; // Boston el id seria "BOS", Yankees "NYY"
    public String estadio; //Nombre del estadio 
    public String trainer;
    private float cantJuegos; 
    private float ganados; 

	private float perdidos;
    
	public Equipo(String nombreEquipo, String id, String estadio, String trainer, float cantJuegos,float ganados,float perdidos) {
		misJugadores = new ArrayList <Jugador>();
		this.nombreEquipo = nombreEquipo;
		this.id = id;
		this.estadio = estadio;
		this.trainer = trainer;
		this.cantJuegos = 0; 
		this.ganados = 0; 
		this.perdidos = 0;
		
	}
	public ArrayList<Jugador> getJugadores() {
		return misJugadores;
	}
	public String getNombreEquipo() {
		return nombreEquipo;
	}
	public String getId() {
		return id;
	}
	public String getEstadio() {
		return estadio;
	}
	public String getTrainer() {
		return trainer;
	}
	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.misJugadores = jugadores;
	}
	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}
	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}
	public float getCantJuegos() {
		return cantJuegos;
	}
	public void setCantJuegos(float cantJuegos) {
		this.cantJuegos = cantJuegos;
	} 
    public float getGanados() {
		return ganados;
	}
	public float getPerdidos() {
		return perdidos;
	}
	public void setGanados(float ganados) {
		this.ganados = ganados;
	}
	public void setPerdidos(float perdidos) {
		this.perdidos = perdidos;
	}
	public  void insertarJugador(Jugador aux) {  
		misJugadores.add(aux);  
	}
	
}

