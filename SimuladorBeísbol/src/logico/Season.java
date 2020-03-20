package logico;

import java.util.ArrayList;

public class Season {
	
	private ArrayList<Equipo> misEquipos;
	private Nomina miNomina;
	private ArrayList <Jugador> misJugadores;
	
	public Season() {
		super();
		this.misEquipos = new ArrayList<Equipo>();
		this.miNomina = miNomina;
		this.misJugadores = new ArrayList<Jugador>();
	}
	public  void insertarEquipo(Equipo aux) {  
		misEquipos.add(aux);  
	}
	public  void insertarJugador(Jugador aux) {  
		misJugadores.add(aux);  
	}
	public Equipo buscarEquipoNombre(String name) {
		int i=0;
		while (misEquipos.get(i).getNombreEquipo() != name) {
			i++;
		}
		return misEquipos.get(i);
	}
	public ArrayList<Jugador> buscarJugadorNombreEquipo(String name) {
		ArrayList <Jugador> teamPlayers;
		teamPlayers = new ArrayList<Jugador>();
		for (Jugador aux : misJugadores) 	{
			if (aux.getEquipo() == name) {
				teamPlayers.add(aux);
			}
		}
		return teamPlayers;
	}
	
}
