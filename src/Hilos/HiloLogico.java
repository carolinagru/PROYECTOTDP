package Hilos;

import Principal.Logica;

public class HiloLogico extends Thread {
	private Logica l;
	private volatile boolean execute;
	private volatile boolean esperar;
	private HiloMovimientoAliens hiloMovAlien;
	private HiloAtaqueAliens hiloAtaqueAlien;
	private HiloInsertarAlien hiloInsertarAlien;
	private HiloInsertarBala hiloInsertarBalas;
	private HiloMovimientoBala hiloMovBala;
	private HiloAccionBala hiloAccionBala;
	private HiloAtaqueSoldado hiloAtaqueSoldado;
	
	public  HiloLogico (Logica l ) {
		this.l = l;
		execute = l.getjuegoActivo();
		hiloMovAlien = new HiloMovimientoAliens (l,this);
		hiloAtaqueAlien = new HiloAtaqueAliens (l,this);
		hiloInsertarAlien = new HiloInsertarAlien(l);
		hiloInsertarBalas = new HiloInsertarBala (l);
		hiloMovBala = new HiloMovimientoBala (l,this);
		hiloAccionBala = new HiloAccionBala (l,this);
		hiloAtaqueSoldado = new HiloAtaqueSoldado(l,this);
		esperar = true;
	}
	
	
	
	
	public void run () {
		try {	
			while (esperar) {
				Thread.sleep(2000);
				hiloInsertarAlien.run();
				System.out.println("Enre a hilo logico");
				Thread.sleep(2000);
				
				hiloMovAlien.start();
				System.out.println("Enre a hilo mover alien");
				while (esperar)
					Thread.sleep(200);
				this.setEspera(true);
	
				System.out.println("Enre a hilo Ataque Alien");
				hiloAtaqueAlien.start();
				while (esperar)
					Thread.sleep(200);
				this.setEspera(true);
				
				System.out.println("Enre a hilo Insertar Balas");
				hiloInsertarBalas.start();
				this.setEspera(true);
				
				System.out.println("Enre a hilo AccionBala");
				hiloAccionBala.start();
				while (esperar)
					Thread.sleep(200);
				this.setEspera(true);
				
				
				
				
				System.out.println("Enre a hilo Mover Balas");
				hiloMovBala.start();
				while (esperar)
					Thread.sleep(200);
				this.setEspera(true);
				
				
				
				System.out.println("Enre a hilo Ataque Soldado");
				hiloAtaqueSoldado.start();
				while (esperar)
					Thread.sleep(200);
				
				this.setEspera(true);
			}
			
			} catch (InterruptedException e2) {
				e2.printStackTrace();
		}
	}
	
	public void setEspera (boolean e) {
		esperar = e;
	}
	
}
