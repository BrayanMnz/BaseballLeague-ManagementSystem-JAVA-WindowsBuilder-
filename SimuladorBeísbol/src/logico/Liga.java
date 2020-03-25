package logico;

import java.io.FileInputStream;
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
		  if(miLiga == null) { 
			  miLiga = new Liga(); 
		  }
		return miLiga;
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
	public void setMisJugadores(ArrayList<Jugador> misJugadores) {
		this.misJugadores = misJugadores;
	}
	public void setMisEquipos(ArrayList<Equipo> misEquipos) {
		this.misEquipos = misEquipos;
	}
	
	
	public void guardar() throws IOException{ 
		
		FileOutputStream Equipos = new FileOutputStream("MisEquipos.dat");
		ObjectOutputStream oos = new ObjectOutputStream(Equipos);
          oos.writeInt(misEquipos.size());
          for (Equipo auxEquipo : misEquipos) {
			oos.writeObject(auxEquipo);
		} 
          FileOutputStream Jugadores = new FileOutputStream("MisJugadores.dat");
          ObjectOutputStream oos1 = new ObjectOutputStream(Jugadores);
          oos1.writeInt(misJugadores.size());
          for (Jugador auxJugador : misJugadores) {
        	  oos1.writeObject(auxJugador); }
      Equipos.close();
      Jugadores.close();
	
	}
	
	
	public void Load() throws IOException, ClassNotFoundException{
	FileInputStream Equipos = new FileInputStream("MisEquipos.dat");
	ObjectInputStream oos = new ObjectInputStream(Equipos);
	 
	int size = oos.readInt();
	for(int i =0; i < size; i++) { 
		misEquipos.add((Equipo) oos.readObject());
	} 
	Equipos.close();
	
	FileInputStream Jugadores = new FileInputStream("MisJugadores.dat");
	ObjectInputStream oos1 = new ObjectInputStream(Jugadores);
	 
	int size1 = oos.readInt();
	for(int i =0; i < size1; i++) { 
		misJugadores.add((Jugador) oos1.readObject());
	} 
	Jugadores.close();
	
	}

}
