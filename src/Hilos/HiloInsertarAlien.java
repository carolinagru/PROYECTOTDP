package Hilos;

import Principal.Logica;

public class HiloInsertarAlien  extends Thread{

	private Logica l;
	private volatile boolean execute;
		
	public  HiloInsertarAlien (Logica l ) {
		this.l = l;
	}
	
	public void terminate () {
		this.execute = false;
	}
	
	
	public void run () {
		try {	
			execute = true;
			Thread.sleep(1500);
			System.out.println("Entre a insertar");
			 
			while (execute) {	
				System.out.println("Entre a insertar");
			
				l.insertarEnemigos();
				Thread.sleep(5000);
			}
			} catch (InterruptedException e2) {
				e2.printStackTrace();
		}
			}
	}

