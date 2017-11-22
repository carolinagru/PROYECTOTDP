package Hilos;


import Personajes.Alien;
import Principal.Logica;

public class HiloMovimientoAliens extends Thread {
	private Logica l;
	private volatile boolean execute;
	private HiloLogico hiloLogico;
	
	public  HiloMovimientoAliens (Logica l, HiloLogico h ) {
		this.l = l;
		execute = l.getjuegoActivo();
		hiloLogico = h;
	}
	
	
	public void run () {
		try {				
			for (Alien a : l.getAliens()){	
				l.moverAlien(a);
			}
			Thread.sleep(500);
			execute = l.getjuegoActivo();		
			} catch (InterruptedException e2) {
				e2.printStackTrace();
			}
			hiloLogico.setEspera (false);
			}
	}
