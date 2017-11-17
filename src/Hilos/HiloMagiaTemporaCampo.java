package Hilos;

import Estate.estadoCampo;
import Estate.estadoSinMagia;
import Principal.Logica;

public class HiloMagiaTemporaCampo  extends Thread{
	
	private Logica l;
	private volatile boolean execute;	
		
	public HiloMagiaTemporaCampo  (Logica l ) {
		this.l = l;
		 
		 
	}	
	
	public void terminate () {
		this.execute = false;
		 
	}
	
	public void run () {
		try {
			 	
			this.execute = true;
			 
			while (execute) {			
				l.setEstado_MTLogica(new estadoCampo());
				Thread.sleep(5000);
				l.setEstado_MTLogica(new estadoSinMagia());
				execute = false;
			}
			} catch (InterruptedException e2) {
				e2.printStackTrace();
		}
	}
	 
}

 
