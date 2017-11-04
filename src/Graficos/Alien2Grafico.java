package Graficos;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Alien2Grafico extends PersonajeGrafico{

	public Alien2Grafico(int x, int y) {
			super(x, y);
			image[0] = new ImageIcon(getClass().getResource("/Sprites/Alien Caminando/2.png"));
		    image[1] = new ImageIcon(getClass().getResource("/Sprites/Alien Caminando/2.png"));
		    image[2] = new ImageIcon(getClass().getResource("/Sprites/Alien Caminando/2.png"));
		    image[3] = new ImageIcon(getClass().getResource("/Sprites/Alien Caminando/2.png"));
	}
	
}
