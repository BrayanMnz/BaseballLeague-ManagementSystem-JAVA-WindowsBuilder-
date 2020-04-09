package visual;

public class HiloPizarra extends Thread {

	public void run() { 
		while(true) { 
		try {
			HiloPizarra.sleep(5000);
			IniciarPartido.cargarCarreras();
			IniciarPartido.actualiarPizarra();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} }
	
	
}
