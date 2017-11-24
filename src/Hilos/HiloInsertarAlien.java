package Hilos;

import Principal.Logica;

public class HiloInsertarAlien  extends Thread{

	private Logica l;
	private volatile boolean execute;
private HiloLogico hiloLogico;
	
	public  HiloInsertarAlien (Logica l, HiloLogico h ) {
		this.l = l;
		execute = l.getjuegoActivo();
		hiloLogico = h;
	}
		
	public void run () {
		try {			 			
			l.insertarEnemigos();
				
			Thread.sleep(10);
			} catch (InterruptedException e2) {
				e2.printStackTrace();
			}
			hiloLogico.setEspera(false);
	}
}

