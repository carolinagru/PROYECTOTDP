package Hilos;

import Principal.Logica;

public class HiloSoldados  extends Thread{
	
	private Logica l;
	private volatile boolean execute;
	
	public HiloSoldados (Logica l ) {
		this.l = l;
		execute = l.getjuegoActivo();
	}
	
	
	public void run () {
		try {
			 
			while (execute) {			
				 
				l.inicioAtaqueSoldados();
				execute = l.getjuegoActivo();
				Thread.sleep(1000);
			}
			} catch (InterruptedException e2) {
				e2.printStackTrace();
		}
	}
	 
}