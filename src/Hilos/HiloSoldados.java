package Hilos;

import Principal.Logica;

public class HiloSoldados  extends Thread{
	
	private Logica l;
	private volatile boolean execute;
	
	public HiloSoldados (Logica l ) {
		this.l = l;
	}
	
	public void terminate () {
		this.execute = false;
	}
	
	public void run () {
		try {
			this.execute = true;
			 
			while (execute) {			
				 
				l.inicioAtaqueSoldados();
				 
				Thread.sleep(1000);
			}
			} catch (InterruptedException e2) {
				e2.printStackTrace();
		}
	}
	 
}