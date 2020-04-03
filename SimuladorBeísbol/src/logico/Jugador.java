package logico;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Jugador implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String nombre;
	protected String noDorsal;
	protected float cantJuegos; 
	protected float errores;
	protected String equipo;
	protected boolean lesionado = false; 
	protected String altura;// en metros 
	protected String peso; //en libras 
	protected float juegos;
	protected String batea;
	protected String lanza;
	protected ArrayList<Lesion> misLesiones; 
	protected  String posicion; //posicion a la defensiva.
	
	
	public Jugador(String nombre, String noDorsal,  String equipo, String altura,String peso,String posicion,String batea, String lanza) {
	   misLesiones = new ArrayList <Lesion>();
		this.nombre = nombre;
		this.noDorsal = noDorsal;
		this.posicion = posicion;
		this.equipo = equipo;
		this.lanza = lanza; 
		this.batea = batea;
		
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
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
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
	public String getAltura() {
		return altura;
	}
	public String getPeso() {
		return peso;
	}
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
	public void setLesionado(boolean lesionado) {
		this.lesionado = lesionado;
	}
	public void setAltura(String altura) {
		this.altura = altura;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	public ArrayList<Lesion> getMisLesiones() {
		return misLesiones;
	}
	public void setMisLesiones(ArrayList<Lesion> misLesiones) {
		this.misLesiones = misLesiones;
	}

	
  
}
