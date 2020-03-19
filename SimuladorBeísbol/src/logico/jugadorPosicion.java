package logico;

public class jugadorPosicion extends Jugador {
private float hits; //ofensiva
private float carrerasEmpujadas;
private float basesRobadas; 
private float turnos; //turnos al bate 
private String posicion; //posicion a la defensiva.

	public jugadorPosicion(String nombre, String noDorsal, float cantJuegos, float errores, float hits,
		float carrerasEmpujadas, float basesRobadas, float turnos, String posicion, String equipo) {
	super(nombre, noDorsal, cantJuegos, errores, equipo);
	this.hits = hits;
	this.carrerasEmpujadas = carrerasEmpujadas;
	this.basesRobadas = basesRobadas;
	this.turnos = turnos;
	this.setPosicion(posicion); 
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



	public void setCarrerasEmpujadas(float carrerasEmpujadas) {
		this.carrerasEmpujadas = carrerasEmpujadas;
	}



	public void setBasesRobadas(float basesRobadas) {
		this.basesRobadas = basesRobadas;
	}



	public void setTurnos(float turnos) {
		this.turnos = turnos;
	}




	public String getPosicion() {
		return posicion;
	}




	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}




}
