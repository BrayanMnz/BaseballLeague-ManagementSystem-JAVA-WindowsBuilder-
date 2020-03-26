package logico;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;




public class Liga implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList <Jugador> misJugadores;
	private ArrayList <Equipo> misEquipos;
	private ArrayList <Season> misSeason;
	private static Liga miLiga;
	
	public Liga() {
		misJugadores = new ArrayList<Jugador>();
		misEquipos = new ArrayList<Equipo>();
		misSeason = new ArrayList<Season>();
		
	}
	public static Liga getInstance() { 
		  if(getMiLiga() == null) { 
			  setMiLiga(new Liga()); 
		  }
		return getMiLiga();
	}
	//insertar season 
	public  void insertarSeason(Season aux) {  
		misSeason.add(aux);  
	}
	public ArrayList<Jugador> getMisJugadores() {
		return misJugadores;
	}
	public ArrayList<Equipo> getMisEquipos() {
		return misEquipos;
	}
	public static Liga getMiLiga() {
		return miLiga;
	}
	public static void setMiLiga(Liga miLiga) {
		Liga.miLiga = miLiga;
	}
	public void setMisJugadores(ArrayList<Jugador> misJugadores) {
		this.misJugadores = misJugadores;
	}
	public void setMisEquipos(ArrayList<Equipo> misEquipos) {
		this.misEquipos = misEquipos;
	}
	

	
}
