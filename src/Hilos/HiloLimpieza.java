 package Hilos;

import Objetos.Obstaculo;
import Principal.Logica;

public class HiloLimpieza  extends Thread{
	
	private Logica l;
	private HiloLogico hiloLogico;
	
	public  HiloLimpieza (Logica l, HiloLogico h ) {
		this.l = l;
		hiloLogico = h;
	}	
	
	
	
	public void run () {
		try {
			while (l.getObstaculos_a_Limpiar().size() > 0) {	
				Obstaculo o = l.getObstaculos_a_Limpiar().removeFirst();
				l.getMapaCombate().eliminar(o);
			}
			Thread.sleep(10);
			} catch (InterruptedException e2) {
				e2.printStackTrace();
		}
		hiloLogico.setEspera(false);
	}
	 
}