package Principal;

import Hilos.HiloAliens;
import Hilos.HiloDisparo;
import Hilos.HiloInsertarAlien;
import Hilos.HiloLimpieza;
import Hilos.HiloSoldados;


public class Inicio {
	public static void main (String args[]) {
		
		Mapa_GUI2 frame = new Mapa_GUI2();
		Logica l = frame.dameLogica();
		

		HiloInsertarAlien h5 = new HiloInsertarAlien (l);
		h5.start();
		
		HiloAliens h = new HiloAliens(l);
		h.start();
		
		HiloSoldados h2 = new HiloSoldados(l);	
		HiloDisparo h3 = new HiloDisparo(l);
		h3.start();
		h2.start();
		
		
		HiloLimpieza h4 = new HiloLimpieza (l);
		h4.start();
		
		 
		
		
		
	
	}

}
