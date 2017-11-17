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
<<<<<<< HEAD:src/Hilos/HiloAliens.java
		try {				
			
			//l.insertarEnemigos();
=======
		try {		
			int niv;
			Thread.sleep(3000);
			l.insertarEnemigos(1);
>>>>>>> 32787b521ced229c87f564e56dd02640b5a3bc1f:src/Hilos/Hilos.java
			this.execute = true;
			Thread.sleep(3000);
			 
			while (execute) {	
<<<<<<< HEAD:src/Hilos/HiloAliens.java
				Thread.sleep(500);
				l.inicioAtaqueAlien();;
=======
				niv = l.getNivel();
				l.accionBalaSoldado();
				l.moverDisparo();
				l.limpiarBalasSoldado();
				l.inicioAtaqueAlien();
				l.inicioMovimientoAliens();
				l.inicioAtaqueSoldados();
				l.limpiarMuertos();
				l.insertarEnemigos(niv);
				
>>>>>>> 32787b521ced229c87f564e56dd02640b5a3bc1f:src/Hilos/Hilos.java
				Thread.sleep(1000);
				 
				l.inicioMovimientoAliens();;
				 		
			}
		}catch (InterruptedException e2) {
		 	e2.printStackTrace();
		 }
	}
}
