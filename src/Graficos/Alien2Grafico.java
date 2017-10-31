package Graficos;

import javax.swing.ImageIcon;

public class Alien2Grafico extends PersonajeGrafico{

	public Alien2Grafico(int x, int y) {
			super(x, y);
			
			image = new ImageIcon(this.getClass().getResource("/Sprites/Alien Caminando/2.png"));
		 
	}
	

}
