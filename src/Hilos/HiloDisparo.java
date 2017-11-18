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
			Thread.sleep(1000);
			 
			while (execute) {	
				l.soldadosBala(); 
				l.accionBalaSoldado();
				l.moverDisparo();
				l.limpiarBalasSoldado();
				execute = l.getjuegoActivo();
				Thread.sleep(1000);
			}
			
		} catch (InterruptedException e2) {
				e2.printStackTrace();
		  }
	}
	 
}