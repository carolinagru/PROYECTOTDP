package Hilos;

import Principal.Logica;

public class Hilos extends Thread {
	private Logica l;
	private volatile boolean execute;
	
	public Hilos (Logica l ) {
		this.l = l;
	}
	
	public void terminate () {
		this.execute = false;
	}
	
	
	public void run () {
		try {				
			Thread.sleep(3000);
			l.insertarEnemigos();
			this.execute = true;
			Thread.sleep(2000);
			while (execute) {	
				
				
				l.insertarEnemigos();
				l.accionBalaSoldado();
				l.moverDisparo();
				
				l.inicioAtaqueAlien();;
				l.inicioMovimientoAliens();;
				l.inicioAtaqueSoldados();
				
				
				Thread.sleep(1000);
			}
			} catch (InterruptedException e2) {
				e2.printStackTrace();
		}
			}
	}
