package Hilos;

import Principal.Logica;

public class HiloDisparo  extends Thread{
	
	private Logica l;
	private volatile boolean execute;
	
	public HiloDisparo (Logica l ) {
		this.l = l;
		execute = l.getjuegoActivo();
	}
	
	
	public void run () {
		try {
			
			 
			while (execute) {	
				Thread.sleep(100);
				l.soldadosBala(); 
				Thread.sleep(100);
				l.accionBalaSoldado();
			//	Thread.sleep(100);
				l.moverDisparo();
				//Thread.sleep(100);
				l.limpiarBalasSoldado();
				execute = l.getjuegoActivo();
				 
			}
			
		} catch (InterruptedException e2) {
				e2.printStackTrace();
		}
	}
	 
}