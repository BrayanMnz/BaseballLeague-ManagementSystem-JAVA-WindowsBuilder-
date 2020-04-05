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
	private float hitsPartido; //ofensiva
	private float carrerasAnotadasPartido;
	private float carrerasEmpujadasPartido;
	private float basesRobadasPartido; 
	private float turnosPartido; //turnos al bate 
	private float hrPartido;
	private float ponchesPartido; 
	private float doblesPartido; 
	private float triplesPartido; 
	private float BBPartido;


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

public float getHitsPartido() {
	return hitsPartido;
}

public float getCarrerasAnotadasPartido() {
	return carrerasAnotadasPartido;
}

public float getCarrerasEmpujadasPartido() {
	return carrerasEmpujadasPartido;
}

public float getBasesRobadasPartido() {
	return basesRobadasPartido;
}

public float getTurnosPartido() {
	return turnosPartido;
}

public float getHrPartido() {
	return hrPartido;
}

public float getPonchesPartido() {
	return ponchesPartido;
}

public float getDoblesPartido() {
	return doblesPartido;
}

public float getTriplesPartido() {
	return triplesPartido;
}

public float getBBPartido() {
	return BBPartido;
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

public void setHitsPartido(float hitsPartido) {
	this.hitsPartido = hitsPartido;
}

public void setCarrerasAnotadasPartido(float carrerasAnotadasPartido) {
	this.carrerasAnotadasPartido = carrerasAnotadasPartido;
}

public void setCarrerasEmpujadasPartido(float carrerasEmpujadasPartido) {
	this.carrerasEmpujadasPartido = carrerasEmpujadasPartido;
}

public void setBasesRobadasPartido(float basesRobadasPartido) {
	this.basesRobadasPartido = basesRobadasPartido;
}

public void setTurnosPartido(float turnosPartido) {
	this.turnosPartido = turnosPartido;
}

public void setHrPartido(float hrPartido) {
	this.hrPartido = hrPartido;
}

public void setPonchesPartido(float ponchesPartido) {
	this.ponchesPartido = ponchesPartido;
}

public void setDoblesPartido(float doblesPartido) {
	this.doblesPartido = doblesPartido;
}

public void setTriplesPartido(float triplesPartido) {
	this.triplesPartido = triplesPartido;
}

public void setBBPartido(float bBPartido) {
	BBPartido = bBPartido;
}

public float promBateo() { 
     float avg;
	return avg = getHits()/getTurnos();
	
}
public  void insertarLesion(Lesion aux) {  
	misLesiones.add(aux);  
	lesionado = true;
}
public float totalHits() {
	float totalHits = getHits()+ getHitsPartido();
	setHits(totalHits);
	return totalHits;
} 
public float totalDobles() {
	float totalDobles = getDobles()+ getDoblesPartido();
	setDobles(totalDobles);
	return totalDobles;
} 
public float totalTriples() {
	float totalTriples = getTriples()+ getTriplesPartido();
	setTriples(totalTriples);
	return totalTriples;
} 
public float totalHR() {
	float totalHR = getHr()+ getHrPartido();
	setHr(totalHR);
	return totalHR;
} 
public float totalTurnos() {
	float totalTurnos = getTurnos()+ getTurnosPartido();
	setTurnos(totalTurnos);
	return totalTurnos;
} 
public float totalBB() {
	float totalBB = getBB()+ getBBPartido();
	setBB(totalBB);
	return totalBB;
} 


}

