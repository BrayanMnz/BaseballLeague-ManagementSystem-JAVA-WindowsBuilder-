package logico;

public class Pitcher extends Jugador {
	private float juegoGanado;
	private float juegoPerdido;
	private float efectividad; //ERA EARNED RUNS ALLOWED
	private float innings; 
	private float ponches; 
	

	public Pitcher(String nombre, String noDorsal, float cantJuegos, float errores, float juegoGanado,
			float juegoPerdido, float efectividad, float innings, float ponches) {
		super(nombre, noDorsal, cantJuegos, errores);
		this.juegoGanado = 0;
		this.juegoPerdido = 0;
		this.efectividad = 0;
		this.innings =0;
		this.ponches = 0;
	}


	public float getJuegoGanado() {
		return juegoGanado;
	}


	public float getJuegoPerdido() {
		return juegoPerdido;
	}


	public float getEfectividad() {
		return efectividad;
	}


	public float getInnings() {
		return innings;
	}


	public float getPonches() {
		return ponches;
	}


	public void setJuegoGanado(float juegoGanado) {
		this.juegoGanado = juegoGanado;
	}


	public void setJuegoPerdido(float juegoPerdido) {
		this.juegoPerdido = juegoPerdido;
	}


	public void setEfectividad(float efectividad) {
		this.efectividad = efectividad;
	}


	public void setInnings(float innings) {
		this.innings = innings;
	}


	public void setPonches(float ponches) {
		this.ponches = ponches;
	}


	

}
