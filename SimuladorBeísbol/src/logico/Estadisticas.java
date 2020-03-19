package logico;

import java.util.ArrayList;

public class Estadisticas {
	private ArrayList <Jugador> misJugadores;
	private ArrayList <Equipo> misEquipos;
	
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

	public void setMisJugadores(ArrayList<Jugador> misJugadores) {
		this.misJugadores = misJugadores;
	}

	public void setMisEquipos(ArrayList<Equipo> misEquipos) {
		this.misEquipos = misEquipos;
	}
}
