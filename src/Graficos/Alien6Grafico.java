package Graficos;

import javax.swing.ImageIcon;

public class Alien6Grafico extends PersonajeGrafico{

	public Alien6Grafico(int x, int y) {
			super(x, y);
			image[0] = new ImageIcon(getClass().getResource("/Sprites/Alien Caminando/6.png"));
		    image[1] = new ImageIcon(getClass().getResource("/Sprites/Alien Caminando/6.png"));
		    image[2] = new ImageIcon(getClass().getResource("/Sprites/Alien Caminando/6.png"));
		    image[3] = new ImageIcon(getClass().getResource("/Sprites/Alien Caminando/6.png"));
		 
	}
	

}
