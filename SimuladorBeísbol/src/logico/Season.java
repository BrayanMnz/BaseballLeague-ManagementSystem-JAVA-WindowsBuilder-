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







public class Season implements Serializable {
	
	private ArrayList<User> misUsers;
	private static User loginUser;
	private static boolean firstTime;
	private static ArrayList<Equipo> misEquipos;
	private static Season Season;


	
	public Season() {
		super();
		misUsers = new ArrayList<>();
		this.setMisEquipos(new ArrayList<Equipo>());

		this.misJugadores = new ArrayList<Jugador>();
	}

public static Season getMiSeason() {
		return miSeason;
	}

	public static void setMiSeason(Season miSeason) {
		getSeason().miSeason = miSeason;
	}

public static Season getInstance() { 
	  if(getMiSeason() == null) { 
		  setMiSeason(new Season()); 
	  }
	return getMiSeason();
}
public void regUser(User user) {
	misUsers.add(user);
	
}
public ArrayList<User> getMisUsers() {
	return misUsers;
}

public static User getLoginUser() {
	return loginUser;
}

public static Season getSeason() {
	return Season;
}

public static void setSeason(Season season) {
	Season = season;
}

public static boolean isFirstTime() {
	return firstTime;
}

public ArrayList<Jugador> getMisJugadores() {
	return misJugadores;
}

public void setMisUsers(ArrayList<User> misUsers) {
	this.misUsers = misUsers;
}

public static void setLoginUser(User loginUser) {
	getSeason().loginUser = loginUser;
}

public static void setFirstTime(boolean firstTime) {
	getSeason().firstTime = firstTime;
}

public void setMisJugadores(ArrayList<Jugador> misJugadores) {
	this.misJugadores = misJugadores;
}

private ArrayList <Jugador> misJugadores;
private static Season miSeason;

	

	 

	 
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
		getSeason().misEquipos = misEquipos;
	}
/*	public static void GuardarEquipos()  throws FileNotFoundException, IOException, ClassNotFoundException { 
		FileOutputStream guardarEquipos = new FileOutputStream("MisEquipos.dat");
		ObjectOutputStream ObjectEquipos = new ObjectOutputStream(guardarEquipos);
		   
		ObjectEquipos.writeInt(misEquipos.size());
		
		for (Equipo auxEquipos : misEquipos) {
			ObjectEquipos.writeObject(auxEquipos);
			
		}
		ObjectEquipos.close();
	} */

	public boolean confirmLogin(String userName, String Password) {
		boolean login = false;
		for (User user : misUsers) {
			if(user.getUserName().equals(userName)){
				loginUser = user;
				login = true;
			}
		}
		return login;
	}
	
	public void guardarSeason(Season miSeason) {
		File file = new File("DatosTemporada.dat");
		FileOutputStream fileOutput;
		ObjectOutputStream fileObjectOutput = null;

		try {
			fileOutput = new FileOutputStream(file);
			fileObjectOutput = new ObjectOutputStream(fileOutput);
			fileObjectOutput.writeObject(miSeason);

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
	}
	
	public void cargarSeason(Season miTemporada) {

		File file = new File("DatosTemporada.dat");
		FileInputStream fileInput;
		ObjectInputStream fileObjectInput;

		try {
			fileInput = new FileInputStream (file);
			fileObjectInput = new ObjectInputStream(fileInput);
            Season sea = (Season) fileObjectInput.readObject();
            setMiSeason(miTemporada);
			fileInput.close();
			fileObjectInput.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
