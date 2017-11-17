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
			 
			this.execute = true;
			 
			while (execute) {			
			 
				l.accionBalaSoldado();
				l.moverDisparo(); 
				Thread.sleep(100);
			}
			} catch (InterruptedException e2) {
				e2.printStackTrace();
		}
	}
	 
}