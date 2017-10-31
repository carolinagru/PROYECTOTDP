package Graficos;

import javax.swing.ImageIcon;

public class Alien5Grafico extends PersonajeGrafico{

	public Alien5Grafico(int x, int y) {
			super(x, y);
			
			image = new ImageIcon(this.getClass().getResource("/Sprites/Alien Caminando/4.png"));
		 
	}
	

}
