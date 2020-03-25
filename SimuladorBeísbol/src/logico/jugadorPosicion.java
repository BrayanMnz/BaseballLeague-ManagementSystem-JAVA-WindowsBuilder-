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
	private String posicion; //posicion a la defensiva.

public jugadorPosicion(String nombre, String noDorsal, float cantJuegos, float errores, String equipo,
			boolean lesionado, float altura, float peso,String posicion) {
		super(nombre, noDorsal, cantJuegos, errores, equipo, lesionado, altura, peso);

		this.posicion = posicion;
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

public String getPosicion() {
	return posicion;
}

public void setHits(float hits) {
	this.hits = hits;
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

public void setPosicion(String posicion) {
	this.posicion = posicion;
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

