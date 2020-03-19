package logico;

public class Lesion {
	
	private String equipo;
	private String nombreJugador;
	private String fechaInicioLesion;
	private String tipoLesion;
	public Lesion(String equipo, String nombreJugador, String fechaInicioLesion, String tipoLesion) {
		this.equipo = equipo;
		this.nombreJugador = nombreJugador;
		this.fechaInicioLesion = fechaInicioLesion;
		this.tipoLesion = tipoLesion;
	}
	public String getEquipo() {
		return equipo;
	}
	public String getNombreJugador() {
		return nombreJugador;
	}
	public String getFechaInicioLesion() {
		return fechaInicioLesion;
	}
	public String getTipoLesion() {
		return tipoLesion;
	}
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}
	public void setFechaInicioLesion(String fechaInicioLesion) {
		this.fechaInicioLesion = fechaInicioLesion;
	}
	public void setTipoLesion(String tipoLesion) {
		this.tipoLesion = tipoLesion;
	}
}
