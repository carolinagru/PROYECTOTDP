package Hilos;

 
import Principal.Logica;

public class HiloInsertarEnemigos extends Thread {
	private Logica l;
	private volatile boolean execute;	
		
	public HiloInsertarEnemigos  (Logica l ) {
		this.l = l;
 	 
	}	
	
	public void terminate () {
		this.execute = false;
		 
	}
	
	public void run () {
		try {
			 	
			this.execute = true;
			 
			while (execute) {			
				l.insertarEnemigos();
				Thread.sleep(3000);
				execute = false;
			}
			} catch (InterruptedException e2) {
				e2.printStackTrace();
		}
	}
}
	 
	 

 
