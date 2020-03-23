package logico;

public class Partido {
	//CREAR MARCADOR PARA LA PARTE VISUAL
	private String visitante;
	private String local;
	private String estadio;
	private String hora;
	private String fecha;
	private boolean terminado = false;
	private int localRun=0;
	private int visitaRun=0;
	private int visitaHits=0;
	private int localHits=0;
	private int errorLocal=0;
	private int errorVisita=0;
	public Partido(String visitante, String local, String estadio) {
		super();
		this.visitante = visitante;
		this.local = local;
		this.estadio = estadio;
		terminado = false;
		localRun = 0;
		visitaRun = 0;
	}
	public String getVisitante() {
		return visitante;
	}
	public void setVisitante(String visitante) {
		this.visitante = visitante;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getEstadio() {
		return estadio;
	}
	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public boolean isTerminado() {
		return terminado;
	}
	public void setTerminado(boolean terminado) {
		this.terminado = terminado;
	}
	public int getLocalRun() {
		return localRun;
	}
	public void setLocalRun(int localRun) {
		this.localRun = localRun;
	}
	public int getVisitaRun() {
		return visitaRun;
	}
	public void setVisitaRun(int visitaRun) {
		this.visitaRun = visitaRun;
	}
	public int getVisitaHits() {
		return visitaHits;
	}
	public void setVisitaHits(int visitaHits) {
		this.visitaHits = visitaHits;
	}
	public int getLocalHits() {
		return localHits;
	}
	public void setLocalHits(int localHits) {
		this.localHits = localHits;
	}
	public int getErrorLocal() {
		return errorLocal;
	}
	public void setErrorLocal(int errorLocal) {
		this.errorLocal = errorLocal;
	}
	public int getErrorVisita() {
		return errorVisita;
	}
	public void setErrorVisita(int errorVisita) {
		this.errorVisita = errorVisita;
	}
}
