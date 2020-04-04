package logico;

public class jugadorPosicion extends Jugador {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private float hits; //ofensiva
	private float carrerasAnotadas;
	private float carrerasEmpujadas;
	private float basesRobadas; 
	private float turnos; //turnos al bate 
	private float hr;


public jugadorPosicion(String nombre, String noDorsal,  String equipo,
			String altura, String peso, String posicion, String batea, String lanza) {
		super(nombre, noDorsal,  equipo, altura, peso, posicion, batea, lanza);

	
	}

public float getHits() {
	return hits;
}

public float getCarrerasEmpujadas() {
	return carrerasEmpujadas;
}

public float getBasesRobadas() {
	return basesRobadas;
}

public float getTurnos() {
	return turnos;
}


public void setHits(float hits) {
	this.hits = hits;
}

public float getHr() {
	return hr;
}

public void setHr(float hr) {
	this.hr = hr;
}

public void setCarrerasEmpujadas(float carrerasEmpujadas) {
	this.carrerasEmpujadas = carrerasEmpujadas;
}

public void setBasesRobadas(float basesRobadas) {
	this.basesRobadas = basesRobadas;
}

public void setTurnos(float turnos) {
	this.turnos = turnos;
}



public float getCarrerasAnotadas() {
	return carrerasAnotadas;
}

public void setCarrerasAnotadas(float carrerasAnotadas) {
	this.carrerasAnotadas = carrerasAnotadas;
}



public float promBateo() { 
     float avg;
	return avg = getHits()/getTurnos();
	
}
public  void insertarLesion(Lesion aux) {  
	misLesiones.add(aux);  
	lesionado = true;
}

}

