package Graficos;

import javax.swing.ImageIcon;

public class Alien4Grafico extends PersonajeGrafico{

	public Alien4Grafico(int x, int y) {
			super(x, y);
			image[0] = new ImageIcon(getClass().getResource("/Sprites/Alien Caminando/4.png"));
		    image[1] = new ImageIcon(getClass().getResource("/Sprites/Alien Caminando/4.png"));
		    image[2] = new ImageIcon(getClass().getResource("/Sprites/Alien Caminando/4.png"));
		    image[3] = new ImageIcon(getClass().getResource("/Sprites/Alien Caminando/4.png"));
		 
	}
	

}
