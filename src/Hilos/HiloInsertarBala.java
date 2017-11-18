package Hilos;

 
import Principal.Logica;

public class HiloInsertarBala extends Thread {
	private Logica l;
	private volatile boolean execute;	
		
	public HiloInsertarBala  (Logica l ) {
		this.l = l;
 	 
	}	
	
	public void terminate () {
		this.execute = false;
		 
	}
	
	public void run () {
		try {
			
			//Thread.sleep(150);
			this.execute = true;
			 
			while (execute) {			
				Thread.sleep(3000);
				
			}
			} catch (InterruptedException e2) {
				e2.printStackTrace();
		}
	}
}