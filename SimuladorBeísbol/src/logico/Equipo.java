package logico;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Equipo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  ArrayList <Jugador> misJugadores;
	private ArrayList <Jugador> Alineacion;
	public String nombreEquipo; 
	public String id; // Boston el id seria "BOS", Yankees "NYY"
    public String estadio; //Nombre del estadio 
    public String trainer;
    private float cantJuegos; 
    private float ganados; 
    private String fechaFundacion;
    private Season miSeason;
    private int carrerasPorPartido;
    private float carrerasLimpiasPermitidas;

	private float perdidos;
    
	public Equipo(String nombreEquipo, String id, String estadio, String trainer, String fechaFundacion) {
		misJugadores = new ArrayList <Jugador>();
		Alineacion = new ArrayList <Jugador>();
		this.nombreEquipo = nombreEquipo;
		this.fechaFundacion = fechaFundacion;
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
	public float getCarrerasLimpiasPermitidas() {
		return carrerasLimpiasPermitidas;
	}
	public void setCarrerasLimpiasPermitidas(float carrerasLimpiasPermitidas) {
		this.carrerasLimpiasPermitidas = carrerasLimpiasPermitidas;
	}
	public float getPerdidos() {
		return perdidos;
	}
	public void setGanados(float ganados) {
		this.ganados = ganados;
	}
	public String getFechaFundacion() {
		return fechaFundacion;
	}
	public void setFechaFundacion(String fechaFundacion) {
		this.fechaFundacion = fechaFundacion;
	}
	public void setPerdidos(float perdidos) {
		this.perdidos = perdidos;
	}
	public int getCarrerasPorPartido() {
		return carrerasPorPartido;
	}
	public void setCarrerasPorPartido(int carrerasPorPartido) {
		this.carrerasPorPartido = carrerasPorPartido;
	}
	public ArrayList <Jugador> getAlineacion() {
		return Alineacion;
	}
	public void setAlineacion(ArrayList <Jugador> alineacion) {
		Alineacion = alineacion;
	}
	public  void insertarJugador(Jugador aux) {  
			misJugadores.add(aux);  
	}
	
	public  void insertarJugadorAlineacion(Jugador aux) {  
		if(aux.lesionado == true) { 
			System.out.println("El jugador esta lesionado, no puede pertenecer a la alineacion");
		} else
		Alineacion.add(aux);  
	}
	//Calcular total Hits del equipo
    public float totalHits() { 
    	float cantHits = 0;
	for (Jugador auxJugador : misJugadores) {
		if(auxJugador instanceof jugadorPosicion) { 
			cantHits += ((jugadorPosicion) auxJugador).getHits();
		}
	}
	return cantHits;
} 
    
    //Calcular total de turnos del equipo
    public float totalTurnos() { 
    	float cantTurnos = 0;
	for (Jugador auxJugador : misJugadores) {
		if(auxJugador instanceof jugadorPosicion) { 
			cantTurnos += ((jugadorPosicion) auxJugador).getTurnos();
		}
	}
	return cantTurnos;
} 
    
//Calcular total Carreras del equipo
    public float totalCarreras() { 
    	float cantCarreras = 0;
	for (Jugador auxJugador : misJugadores) {
		if(auxJugador instanceof jugadorPosicion) { 
			cantCarreras += ((jugadorPosicion) auxJugador).getCarrerasAnotadas();
		}
	}
	return cantCarreras;
} 
    public float promColectivo() {
    	float auxProm=0;
    return auxProm = (totalHits()/totalTurnos());
    }
    
    //Calcular efectividad individual de un jugador del equipo.
    public float efectividad (String noJugador) {
 	   float era=0;
Jugador auxJugador = buscarJugadorByDorsal(noJugador);
 if(auxJugador instanceof Pitcher) { 
 era = ( (((Pitcher) auxJugador).getCarrerasLimpias() *9 ) / (((Pitcher) auxJugador).getInningsLanzados())  );
 } return era;  }
 
    
//Total innings lanzados del equipo    
    public float totalInnings() { 
    	float cantInnings = 0;
	for (Jugador auxJugador : misJugadores) {
		if(auxJugador instanceof Pitcher) { 
			cantInnings += ((Pitcher) auxJugador).getInningsLanzados();
		}
	}
	return cantInnings;
} 
    
       
 //BuscarJugador por # de chaqueta del equipo
	 public Jugador buscarJugadorByDorsal (String noDorsal) { 
    	 boolean encontrado = false; 
    	Jugador auxJugador =null;
    	 int i=0;
    	 while(i<misJugadores.size() && !encontrado) {
    		 if(misJugadores.get(i).getNoDorsal().equalsIgnoreCase(noDorsal)) {
    			 auxJugador = misJugadores.get(i);
    			 encontrado = true;  } 
    		 i++; }	return  auxJugador;
	 }
 //Cantidad Juegos Ganados equipo 
	 public float totalGanados() {
	    	float cantGanados = 0;
	    	for (Jugador auxJugador : misJugadores) {
	    		if(auxJugador instanceof Pitcher) { 
	    			cantGanados += ((Pitcher) auxJugador).getJuegoGanado();
	    		}
	    	}
	    	return cantGanados;
	 }
 // Cantidad Juegos perdidos equipo 
	 public float totalPerdidos() {
	    	float cantPerdidos = 0;
	    	for (Jugador auxJugador : misJugadores) {
	    		if(auxJugador instanceof Pitcher) { 
	    			cantPerdidos += ((Pitcher) auxJugador).getJuegoPerdido();
	    		}	}   
	    	return cantPerdidos;   }
	 // Cantidad Ponches por equipo 
	 public float totalPonches() {
	    	float cantPonches = 0;
	    	for (Jugador auxJugador : misJugadores) {
	    		if(auxJugador instanceof Pitcher) { 
	    			cantPonches += ((Pitcher) auxJugador).getPonches();
	    		}	}   
	    	return cantPonches;   }
	 
	 
	 public float eraColectiva() { 
		 float auxEra = 0;
		 return auxEra = getCarrerasLimpiasPermitidas()/totalInnings();
	 }
	 // Cantidad Ponches por equipo 
	 public float totalBasePorBolas() {
	    	float cantBB = 0;
	    	for (Jugador auxJugador : misJugadores) {
	    		if(auxJugador instanceof Pitcher) { 
	    			cantBB += ((Pitcher) auxJugador).getBB();
	    		}	}   
	    	return cantBB;   
	    	}
	 
	 public ArrayList<String> nominaEquipo() { 
		 ArrayList<String> listadoJugadores = new ArrayList<>();
		 for (Jugador auxJugador :misJugadores) {
             listadoJugadores.add(auxJugador.getNombre());
			 
		}
		return listadoJugadores;
	 }
	public ArrayList<Jugador> getMisJugadores() {
		return misJugadores;
	}
	public void setMisJugadores(ArrayList<Jugador> misJugadores) {
		this.misJugadores = misJugadores;
	}
	 
	/* public String jugadorLesionado(String idJugador, String tipoLesion) {
		 String aux="";
		Jugador  auxJugador = buscarJugadorByDorsal(idJugador);
			if(auxJugador.isLesionado()) { 
			 auxJugador.insertarLesion(tipoLesion);
					aux = tipoLesion;}
			
				else if (auxJugador.lesionado == false) { 
					aux = "El jugador no esta lesionado, no se puede especificar ninguna lesion";
				}
			

		
		return aux;
		
	 }*/
	 //Probando ficherossss! 
 /*	public static void guardarJugadores() {
		File fileJugadores = new File("misJugadores.dat");
		FileOutputStream fileOutput;
		ObjectOutputStream fileObjectOutput = null;

		try {
			fileOutput = new FileOutputStream(fileJugadores);
			fileObjectOutput = new ObjectOutputStream(fileOutput);
			for (Jugador auxJugador : misJugadores) {
				fileObjectOutput.writeObject(auxJugador);
			
			}

			fileOutput.close();
			fileObjectOutput.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fileObjectOutput.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	} */
	 
}



