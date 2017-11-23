package Hilos;

import Personajes.Alien;
import Principal.Logica;

public class HiloAtaqueAliens extends Thread {
	private Logica l;
	private volatile boolean execute;
	private HiloLogico hiloLogico;
	
	public  HiloAtaqueAliens (Logica l, HiloLogico h ) {
		this.l = l;
		execute = l.getjuegoActivo();
		hiloLogico = h;
	}
	
	
	public void run () {
		try {				
			for (Alien a : l.getAliens()){	
				l.ataqueAlien(a);
			}
			Thread.sleep(10);
			} catch (InterruptedException e2) {
				e2.printStackTrace();
			}
			hiloLogico.setEspera (false);
			}
	}
