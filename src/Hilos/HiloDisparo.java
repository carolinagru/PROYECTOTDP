package Hilos;

import Principal.Logica;

public class HiloDisparo  extends Thread{
	
	private Logica l;
	private volatile boolean execute;
	
	public HiloDisparo (Logica l ) {
		this.l = l;
	}
	
	public void terminate () {
		this.execute = false;
	}
	
	public void run () {
		try {
			Thread.sleep(1000);

			this.execute = true;
			 
			while (execute) {		
				l.soldadosBala(); 
				l.accionBalaSoldado();
				l.moverDisparo();
				l.limpiarBalasSoldado();
				
				Thread.sleep(1000);
			}
			
		} catch (InterruptedException e2) {
				e2.printStackTrace();
		  }
	}
	 
}