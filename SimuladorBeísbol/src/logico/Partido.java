package logico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Partido implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//CREAR MARCADOR PARA LA PARTE VISUAL
	private ArrayList <Equipo> misEquipos;
	private String idPartido;
	private Equipo Equipovisitante;
	private Equipo Equipolocal;
	private String estadio;
	private String horaJuego;
	private String fecha;
	private int innnings;
	private boolean terminado = false;
	private int localRun=0;
	private int visitaRun=0;
	private int visitaHits=0;
	private int localHits=0;
	private int errorLocal=0;
	private int errorVisita=0;
	private Partido miPartido;
	public Partido(Equipo local, Equipo visitante, String estadio, String horaJuego) {
		super();
		this.Equipovisitante = visitante;
		this.Equipolocal = local;
		this.estadio = estadio;
		this.horaJuego = horaJuego;
		this.idPartido = Liga.getInstance().generarIDPartido();
		terminado = false;
		localRun = 0;
		visitaRun = 0;
		this.innnings = innnings;
	}
	

	public Equipo getVisitante() {
		return Equipovisitante;
	}
	public void setVisitante(Equipo visitante) {
		this.Equipovisitante = visitante;
	}
	public Equipo getLocal() {
		return Equipolocal;
	}
	public void setLocal(Equipo local) {
		this.Equipolocal = local;
	}
	public String getEstadio() {
		return estadio;
	}
	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}
	public String getHora() {
		return horaJuego;
	}
	public void setHora(String hora) {
		this.horaJuego = hora;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public boolean isTerminado() {
		return terminado;
	}
	public void setTerminado(boolean terminado) {
		this.terminado = terminado;
	}
	public int getLocalRun() {
		return localRun;
	}
	public void setLocalRun(int localRun) {
		this.localRun = localRun;
	}
	public int getVisitaRun() {
		return visitaRun;
	}
	public void setVisitaRun(int visitaRun) {
		this.visitaRun = visitaRun;
	}
	public int getVisitaHits() {
		return visitaHits;
	}
	public void setVisitaHits(int visitaHits) {
		this.visitaHits = visitaHits;
	}

	public void setIdPartido(String idPartido) {
		this.idPartido = Liga.getInstance().generarIDPartido();
	}
	public String getIdPartido() {
		return idPartido;
	}




	public int getLocalHits() {
		return localHits;
	}
	public void setLocalHits(int localHits) {
		this.localHits = localHits;
	}
	public int getErrorLocal() {
		return errorLocal;
	}
	public void setErrorLocal(int errorLocal) {
		this.errorLocal = errorLocal;
	}
	public int getErrorVisita() {
		return errorVisita;
	}
	public void setErrorVisita(int errorVisita) {
		this.errorVisita = errorVisita;
	}

	public ArrayList <Equipo> getMisEquipos() {
		return misEquipos;
	}
	public void setMisEquipos(ArrayList <Equipo> misEquipos) {
		this.misEquipos = misEquipos;
	}
	
   public int getInnnings() {
		return innnings;
	}
	public void setInnnings(int innnings) {
		this.innnings = innnings;
	}
	public void partidoTerminado() { 
		
		if(innnings < 9) { 
			System.out.println("El partido no ha terminado, debe completar las 9 entradas");
		}
	}
public String ganadorPartido() { 
	String winner = null;
	
	       if((localRun> visitaRun) && (innnings>=9)) {
		   winner = getLocal().nombreEquipo;
		   terminado = true; 
		  }
	   else if ((localRun< visitaRun) && (innnings>=9)  ) { 
		   winner = getVisitante().nombreEquipo;
		   terminado = true;
	   }   /*  else  if(innnings < 9) { 
			System.out.println("El partido no ha terminado, debe completar las 9 entradas");
       } */
	return winner;
	   }
	
 //  }
	  
	
}
