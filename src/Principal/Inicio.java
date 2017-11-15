package Principal;

import Hilos.Hilos;


public class Inicio {
	public static void main (String args[]) {
		
		Mapa_GUI2 frame = new Mapa_GUI2();
		Logica l = frame.dameLogica();
		
		
		Hilos h = new Hilos(l);
		h.run();
	
	}

}
