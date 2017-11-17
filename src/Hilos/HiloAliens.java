package Hilos;

import Principal.Logica;

public class HiloAliens extends Thread {
	private Logica l;
	private volatile boolean execute;
	
	public  HiloAliens (Logica l ) {
		this.l = l;
	}
	
	public void terminate () {
		this.execute = false;
	}
	
	
	public void run () {
		try {				
			
			this.execute = true;
			Thread.sleep(3000);
			 
			while (execute) {	
				Thread.sleep(500);
				l.inicioAtaqueAlien();;
				Thread.sleep(1000);
				 
				l.inicioMovimientoAliens();;
				 		
			}
			} catch (InterruptedException e2) {
				e2.printStackTrace();
		}
			}
	}
