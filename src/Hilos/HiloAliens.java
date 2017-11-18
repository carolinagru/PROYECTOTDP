package Hilos;

import Principal.Logica;

public class HiloAliens extends Thread {
	private Logica l;
	private volatile boolean execute;
	
	public  HiloAliens (Logica l ) {
		this.l = l;
		execute = l.getjuegoActivo();
	}
	
	
	
	
	public void run () {
		try {				
			
			Thread.sleep(3000);
			 
			while (execute) {	
				Thread.sleep(500);
				l.inicioAtaqueAlien();
				Thread.sleep(1000);
				 
				l.inicioMovimientoAliens();
				execute = l.getjuegoActivo();		
			}
			} catch (InterruptedException e2) {
				e2.printStackTrace();
		}
			}
	}
