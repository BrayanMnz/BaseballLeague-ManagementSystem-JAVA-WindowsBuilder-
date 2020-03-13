package logico;

import java.util.ArrayList;

public class Controladora {
	
	private ArrayList<Equipo> misEquipos;
	private Nomina miNomina;
	private ArrayList <Jugador> misJugadores;
	
	public  void insertarEquipo(Equipo aux) {  
		misEquipos.add(aux);  
	}
	public  void insertarJugador(Jugador aux) {  
		misJugadores.add(aux);  
	}

}
