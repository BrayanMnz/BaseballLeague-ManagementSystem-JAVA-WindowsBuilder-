package logico;

import java.util.ArrayList;



public class Season {
	
	private ArrayList<Equipo> misEquipos;

	private ArrayList <Jugador> misJugadores;
	private static Season miSeason;
	
	public Season() {
		super();
		this.setMisEquipos(new ArrayList<Equipo>());

		this.misJugadores = new ArrayList<Jugador>();
	}

public static Season getInstance() { 
	  if(miSeason == null) { 
		  miSeason = new Season(); 
	  }
	return miSeason;
}
	public  void insertarEquipo(Equipo aux) {  
		getMisEquipos().add(aux);  
	}

	 public Equipo buscarEquipoById (String idEquipo) { 
    	 boolean encontrado = false; 
    	Equipo auxEquipo =null;
    	 int i=0;
    	 while(i<getMisEquipos().size() && !encontrado) {
    		 if(getMisEquipos().get(i).getId().equalsIgnoreCase(idEquipo)) {
    			 auxEquipo = getMisEquipos().get(i);
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

	public ArrayList<Equipo> getMisEquipos() {
		return misEquipos;
	}

	public void setMisEquipos(ArrayList<Equipo> misEquipos) {
		this.misEquipos = misEquipos;
	}
	 

	
	
}
