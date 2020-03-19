package logico;

import java.util.ArrayList;

public class Equipo {
	private ArrayList <Jugador> misJugadores;
	public String nombreEquipo; 
	public String id; // Boston el id seria "BOS", Yankees "NYY"
    public String estadio; //Nombre del estadio 
    public String trainer;
    private float cantJuegos; 
	public Equipo(String nombreEquipo, String id, String estadio, String trainer, float cantJuegos) {
		misJugadores = new ArrayList <Jugador>();
		this.nombreEquipo = nombreEquipo;
		this.id = id;
		this.estadio = estadio;
		this.trainer = trainer;
		this.setCantJuegos(0);
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
}
