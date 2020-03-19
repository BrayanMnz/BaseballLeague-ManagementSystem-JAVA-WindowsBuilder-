package logico;

public abstract class Jugador {
	
	protected String nombre;
	protected String noDorsal;
	protected float cantJuegos; 
	protected float errores;
	protected String equipo;
	protected boolean lesionado; 
	protected float altura;// en metros 
	protected float peso; //en libras 
	
	public Jugador(String nombre, String noDorsal, float cantJuegos, float errores, String equipo, boolean lesionado, float altura,float peso) {
		this.nombre = nombre;
		this.noDorsal = noDorsal;
		this.cantJuegos = cantJuegos;
		this.errores = errores;
		this.equipo = equipo;
		lesionado = false; 
		this.altura = altura; 
		this.peso = peso;
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
	public String getEquipo() {
		return equipo;
	}
	public boolean isLesionado() {
		return lesionado;
	}
	public float getAltura() {
		return altura;
	}
	public float getPeso() {
		return peso;
	}
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
	public void setLesionado(boolean lesionado) {
		this.lesionado = lesionado;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}

}
