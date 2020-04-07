package logico;

import java.io.Serializable;
import java.util.Date;

public class Lesion implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String miJugador;
	private String fechaInicioLesion;
	private String tipoLesion;
	private String fechaFinalLesion;
	public Lesion( String miJugador, String fechaInicioLesion,String fechaFinalLesion, String tipoLesion) {
		//this.miEquipo = miEquipo;
		this.setMiJugador(miJugador);
		this.fechaInicioLesion = fechaInicioLesion;
		this.fechaFinalLesion= fechaFinalLesion;
		this.tipoLesion = tipoLesion;
	}
//	public Equipo getmiEquipo() {
	//	return miEquipo;
	//}

	public String getMiJugador() {
		return miJugador;
	}
	public void setMiJugador(String miJugador) {
		this.miJugador = miJugador;
	}
	public String getFechaInicioLesion() {
		return fechaInicioLesion;
	}
	public String getTipoLesion() {
		return tipoLesion;
	}
//	public void setEquipo(Equipo equipo) {
	//	this.miEquipo = equipo;
	//}
	public void setFechaInicioLesion(String fechaInicioLesion) {
		this.fechaInicioLesion = fechaInicioLesion;
	}
	public void setTipoLesion(String tipoLesion) {
		this.tipoLesion = tipoLesion;
	}
	public String getFechaFinalLesion() {
		return fechaFinalLesion;
	}
	public void setFechaFinalLesion(String fechaFinalLesion) {
		this.fechaFinalLesion = fechaFinalLesion;
	}
}
