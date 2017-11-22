package Hilos;

import Disparo.Bala;
import Personajes.Soldado;
import Principal.Logica;

public class HiloAtaqueSoldado  extends Thread {
	private Logica l;
	private volatile boolean execute;
	private HiloLogico hiloLogico;
	
	public  HiloAtaqueSoldado (Logica l, HiloLogico h ) {
		this.l = l;
		execute = l.getjuegoActivo();
		hiloLogico = h;
	}
	
	
	public void run () {
		try {				
			for (Soldado s : l.getSoldados()){	
				l.ataqueSoldado(s);
			}
			Thread.sleep(500);
			} catch (InterruptedException e2) {
				e2.printStackTrace();
			}
			hiloLogico.setEspera (false);
			}
	}
