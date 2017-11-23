package Hilos;

import Disparo.Bala;
import Personajes.Alien;
import Principal.Logica;

public class HiloAccionBala extends Thread {
	private Logica l;
	private volatile boolean execute;
	private HiloLogico hiloLogico;
	
	public  HiloAccionBala (Logica l, HiloLogico h ) {
		this.l = l;
		execute = l.getjuegoActivo();
		hiloLogico = h;
	}
	
	
	public void run () {
		try {				
			for (Bala b : l.getBalas()){	
				l.balaSoldado(b);
			}
			Thread.sleep(10);
			} catch (InterruptedException e2) {
				e2.printStackTrace();
			}
			hiloLogico.setEspera (false);
	}
}
