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

	 public Equipo buscarEquipoById (String idEquipo) { 
    	 boolean encontrado = false; 
    	Equipo auxEquipo =null;
    	 int i=0;
    	 while(i<misEquipos.size() && !encontrado) {
    		 if(misEquipos.get(i).getId().equalsIgnoreCase(idEquipo)) {
    			 auxEquipo = misEquipos.get(i);
    			 encontrado = true; 
    			
    		 } i++;  
    		 }
		return  auxEquipo;
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
