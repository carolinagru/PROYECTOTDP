package Graficos;

import javax.swing.ImageIcon;

public class Alien4Grafico extends PersonajeGrafico{

	public Alien4Grafico(int x, int y) {
			super(x, y);
			
			image = new ImageIcon(this.getClass().getResource("/Sprites/Alien Caminando/4.png"));
		 
	}
	

}
