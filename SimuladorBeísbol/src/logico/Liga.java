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
import java.util.Locale.Category;







public class Liga implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList <Jugador> misJugadores;
	private ArrayList <Equipo> misEquipos;
	private ArrayList <Partido> misPartidos; 
	private static Liga miLiga; 
	private int cantPartidos;
	private static boolean control = true;
	private ArrayList <User> usuarios;
	private  User loginUser;

	
	public Liga() {
		misJugadores = new ArrayList<Jugador>();
		misEquipos = new ArrayList<Equipo>();
	    usuarios = new ArrayList<User>();
		setMisPartidos(new ArrayList<Partido>());
	    
		
	}
	public static Liga getInstance() { 
		  if(miLiga==null) { 
			  miLiga = new Liga();
		  }
		return miLiga;
	}

	public ArrayList<Jugador> getMisJugadores() {
		return misJugadores;
	}
	public ArrayList<Equipo> getMisEquipos() {
		return misEquipos;
	}
	public ArrayList <Partido> getMisPartidos() {
		return misPartidos;
	}
	public void setMisPartidos(ArrayList <Partido> misPartidos) {
		this.misPartidos = misPartidos;
	}
	public static Liga getMiLiga() {
		return miLiga;
	}
	public static boolean isControl() {
		return control;
	}
	public static void setControl(boolean control) {
		Liga.control = control;
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
	

	//Metodos para insertar
	public  void insertarEquipo(Equipo aux) {  
		getMisEquipos().add(aux);  
	}
	public void insertarJugador(Jugador aux) { 
		getMisJugadores().add(aux);
	} 
	public void insertarPartido(Partido aux) { 
	getMisPartidos().add(aux);
	cantPartidos++;
	
	}
	
	//Metodos para eliminar 
	public void EliminarJugador(Jugador aux) {
		getMisJugadores().remove(aux);
		}
	public void EliminarEquipo(Equipo aux) {
		getMisEquipos().remove(aux);
		}
	public void EliminarPartido(Partido aux) { 
		getMisPartidos().remove(aux);
		cantPartidos = cantPartidos - 1; 
	}
	public int getCantPartidos() {
		return cantPartidos;
	}
	public  void setCantPartidos(int cantPartidos) {
	   this.cantPartidos = cantPartidos;
	}
	
	//Buscar Equipo 
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
	 public Equipo buscarEquipoByName (String NameEquipo) { 
    	 boolean encontrado = false; 
    	Equipo auxEquipo =null;
    	 int i=0;
    	while(i<getMisEquipos().size() && !encontrado) {
    		 if(getMisEquipos().get(i).getNombreEquipo().equalsIgnoreCase(NameEquipo)) {
    			 auxEquipo = getMisEquipos().get(i);
    			 encontrado = true; 
    			
    		 } i++;  
    		
	
	 }
    	return  auxEquipo;
}
	 

	 
	 //BuscarPartidoByID
	 public Partido buscarPartidoById (String idPartido) { 
	   	 boolean encontrado = false; 
	   	Partido auxPartido =null;
	   	 int i=0;
	   	 while(i<getMisPartidos().size() && !encontrado) {
	   		 if(misPartidos.get(i).getIdPartido().equalsIgnoreCase(idPartido)) {
	   			 auxPartido = getMisPartidos().get(i);
	   			 encontrado = true; 
	   			
	   		 } i++;  
	   		 } 
			return  auxPartido;
		 }
	
	   public String generarIDPartido() { 
		   String auxID="";
		   return auxID = "MLB-00"+cantPartidos;
		   }
	 
	// para guardar los datos de la clase controladora
	public void guardarDatos(Liga miLiga) {
		File file = new File("DatosLiga.dat");
		FileOutputStream fileOutput;
		ObjectOutputStream fileObjectOutput = null;

		try {
			fileOutput = new FileOutputStream(file);
			fileObjectOutput = new ObjectOutputStream(fileOutput);
			fileObjectOutput.writeObject(miLiga);

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

	
	public void cargarLiga(Liga miLiga) {

		File file = new File("DatosLiga.dat");
		FileInputStream fileInput;
		ObjectInputStream fileObjectInput;

		try {
			fileInput = new FileInputStream (file);
			fileObjectInput = new ObjectInputStream(fileInput);

			Liga mlb = (Liga) fileObjectInput.readObject();
			Liga.setMiLiga(mlb);
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
	//AGREGAR USUARIO
	public ArrayList <User> getUsuarios() {
		return usuarios;
	}
	public void regUser (User aux) {
		getUsuarios().add(aux);
	}
	public  void setLoginUser(User loginUser) {
		this.loginUser = loginUser;
	}
	//VERIFICAR USUARIO
	public boolean confirmLogin(String text, String text2) {
		boolean login = false;
		for (User user : getUsuarios()) {
			if(user.getUserName().equals(text)){
				setLoginUser(user);
				login = true;
			}
		}
		return login;
	}

	public void setUsuarios(ArrayList <User> usuarios) {
		this.usuarios = usuarios;
	}
	//BUSCAR USER POR NOMBRE
	public User buscarUser(String aux) {
		User retorno=null;
		for (User auxUser : usuarios) {
			if (auxUser.getUserName() == aux) {
				retorno = auxUser;
			}
		}
		return retorno;
	}
	public  User getLoginUser() {
		return loginUser;
	}
	 public Jugador buscarJugadorByNombre (String Nombre) { 
    	 boolean encontrado = false; 
    	Jugador auxJugador =null;
    	 int i=0;
    	 while(i<misJugadores.size() && !encontrado) {
    		 if(misJugadores.get(i).getNombre().equalsIgnoreCase(Nombre)) {
    			 auxJugador = misJugadores.get(i);
    			 encontrado = true;  } 
    		 i++; }	return  auxJugador;
	 }
	public Jugador buscarDorsalTeamName (String dorsal, String team, String name) {
		Jugador player=null;
		for (Jugador aux : misJugadores) {
			if (aux.noDorsal.equals(dorsal) && aux.getEquipo().equalsIgnoreCase(team) && aux.getNombre().equalsIgnoreCase(name)) {
				player = aux;
			}
		}
		return player;
	}
}
