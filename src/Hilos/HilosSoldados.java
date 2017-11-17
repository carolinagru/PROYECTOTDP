package Hilos;
/***
import Principal.Logica;

public class HilosSoldados  extends Thread{
	
	private Logica l;
	private volatile boolean execute;
	
	public HilosSoldados (Logica l ) {
		this.l = l;
	}
	
	public void terminate () {
		this.execute = false;
	}
	
	public void run () {
		try {
			//Thread.sleep(3000);
			this.execute = true;
			
			while (execute) {			
				l.inicioAtaqueSoldados();
				l.limpiarMuertos();
				Thread.sleep(300);
			}
			} catch (InterruptedException e2) {
				e2.printStackTrace();
		}
	}
	 
}**/