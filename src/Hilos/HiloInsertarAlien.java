package Hilos;

import Principal.Logica;

public class HiloInsertarAlien  extends Thread{

	private Logica l;
	private volatile boolean execute;
		
	public  HiloInsertarAlien (Logica l ) {
		this.l = l;
		this.execute = l.getjuegoActivo(); 
	}
		
	public void run () {
		try {	
			
			Thread.sleep(1500);
			System.out.println("Entre a insertar");
			 
			while (execute) {	
				System.out.println("Entre a insertar");
			
				l.insertarEnemigos();
				execute = l.getjuegoActivo();
				Thread.sleep(5000);
			}
			} catch (InterruptedException e2) {
				e2.printStackTrace();
				}
	}
}

