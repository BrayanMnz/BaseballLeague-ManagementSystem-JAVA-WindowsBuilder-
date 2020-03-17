package logico;

public abstract class Jugador {
	
	protected String nombre;
	protected String noDorsal;
	protected float cantJuegos; 
	protected float errores;
	protected String equipo;
	public Jugador(String nombre, String noDorsal, float cantJuegos, float errores, String equipo) {
		this.nombre = nombre;
		this.noDorsal = noDorsal;
		this.cantJuegos = cantJuegos;
		this.errores = errores;
		this.equipo = equipo;
	}
	public String getNombre() {
		return nombre;
	}
	public String getNoDorsal() {
		return noDorsal;
	}
	public float getCantJuegos() {
		return cantJuegos;
	}
	public float getErrores() {
		return errores;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setNoDorsal(String noDorsal) {
		this.noDorsal = noDorsal;
	}
	public void setCantJuegos(float cantJuegos) {
		this.cantJuegos = cantJuegos;
	}
	public void setErrores(float errores) {
		this.errores = errores;
	}

}
