package logico;

public class jugadorPosicion extends Jugador {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private float hits=0; //ofensiva
	private float carrerasAnotadas=0;
	private float carrerasEmpujadas=0;
	private float basesRobadas=0; 
	private float turnos=0; //turnos al bate 
	private float hr=0;
	private float ponches=0; 
	private float dobles=0; 
	private float triples=0; 
	private float BB=0;



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



public float getPonches() {
	return ponches;
}

public float getDobles() {
	return dobles;
}

public float getTriples() {
	return triples;
}

public float getBB() {
	return BB;
}



public void setPonches(float ponches) {
	this.ponches = ponches;
}

public void setDobles(float dobles) {
	this.dobles = dobles;
}

public void setTriples(float triples) {
	this.triples = triples;
}

public void setBB(float bB) {
	BB = bB;
}


public float promBateo() { 
     float avg=.000f;
	return avg = ((getHits())/(getTurnos()));
	
}
public  void insertarLesion(Lesion aux) {  
	misLesiones.add(aux);  
	lesionado = true;
}



}

