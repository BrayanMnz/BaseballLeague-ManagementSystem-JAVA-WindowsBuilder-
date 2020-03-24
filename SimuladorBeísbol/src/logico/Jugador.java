package logico;

import java.util.ArrayList;

public abstract class Jugador {
	
	protected String nombre;
	protected String noDorsal;
	protected float cantJuegos; 
	protected float errores;
	protected String equipo;
	protected boolean lesionado = false; 
	protected float altura;// en metros 
	protected float peso; //en libras 
	protected float juegos;
	protected ArrayList<String> misLesiones;
	
	
	public Jugador(String nombre, String noDorsal, float cantJuegos, float errores, String equipo, boolean lesionado, float altura,float peso, float juegos) {
		setMisLesiones(new ArrayList<>());
		this.nombre = nombre;
		this.noDorsal = noDorsal;
		this.cantJuegos = cantJuegos;
		this.errores = errores;
		this.equipo = equipo;
		
		this.altura = altura; 
		this.peso = peso;
		this.juegos = juegos;
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
	public ArrayList<String> getMisLesiones() {
		return misLesiones;
	}
	public void setMisLesiones(ArrayList<String> misLesiones) {
		this.misLesiones = misLesiones;
	}
	
   public abstract void insertarLesion(String auxLesion);
  
}
