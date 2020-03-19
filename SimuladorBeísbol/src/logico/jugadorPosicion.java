package logico;

public class jugadorPosicion extends Jugador {
	private float hits; //ofensiva
	private float carrerasEmpujadas;
	private float basesRobadas; 
	private float turnos; //turnos al bate 
	private String posicion; //posicion a la defensiva.

public jugadorPosicion(String nombre, String noDorsal, float cantJuegos, float errores, String equipo,
			boolean lesionado, float altura, float peso, float hits, float carrerasEmpujadas, float basesRobadas,
			float turnos, String posicion) {
		super(nombre, noDorsal, cantJuegos, errores, equipo, lesionado, altura, peso);
		this.hits = hits;
		this.carrerasEmpujadas = carrerasEmpujadas;
		this.basesRobadas = basesRobadas;
		this.turnos = turnos;
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








}
