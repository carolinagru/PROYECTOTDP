package Hilos;

 
import Principal.Logica;

public class HiloInsertarBala extends Thread {
	private Logica l;
private HiloLogico hiloLogico;
	
	public  HiloInsertarBala (Logica l, HiloLogico h ) {
		this.l = l;
		
		hiloLogico = h;
	}
	
	public void run () {
		try {
			
			l.soldadosBala(); 
			Thread.sleep(500);
				
			} catch (InterruptedException e2) {
				e2.printStackTrace();
		}
	}
}