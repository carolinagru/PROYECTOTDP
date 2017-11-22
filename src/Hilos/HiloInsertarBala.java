package Hilos;

 
import Principal.Logica;

public class HiloInsertarBala extends Thread {
	private Logica l;
	private volatile boolean execute;	
		
	public HiloInsertarBala  (Logica l ) {
		this.l = l;
		this.execute = l.getjuegoActivo();  	 
	}	

	
	public void run () {
		try {
			
			Thread.sleep(150);
			 
			while (execute) {		
				l.soldadosBala(); 
				execute = l.getjuegoActivo();
				Thread.sleep(500);
				
			}
			} catch (InterruptedException e2) {
				e2.printStackTrace();
		}
	}
}