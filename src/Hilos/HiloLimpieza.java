 package Hilos;

import Objetos.Obstaculo;
import Principal.Logica;

public class HiloLimpieza  extends Thread{
	
	private Logica l;
	private volatile boolean execute;
	
	public HiloLimpieza (Logica l ) {
		this.l = l;
	}
	
	public void terminate () {
		this.execute = false;
	}
	
	public void run () {
		try {
			this.execute = true;
			while (execute) {
				
				while (l.getObstaculos_a_Limpiar().size() > 0) {
					Obstaculo o = l.getObstaculos_a_Limpiar().removeFirst();
					l.getMapaCombate().eliminar(o);
				}
				 
				 
				Thread.sleep(500);
			}
			} catch (InterruptedException e2) {
				e2.printStackTrace();
		}
	}
	 
}