package Graficos;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Alien3Grafico extends PersonajeGrafico{

	public Alien3Grafico(int x, int y) {
			super(x, y);
			image[0] = new ImageIcon(getClass().getResource("/Sprites/Alien Caminando/3.png"));
		    image[1] = new ImageIcon(getClass().getResource("/Sprites/Alien Caminando/3.png"));
		    image[2] = new ImageIcon(getClass().getResource("/Sprites/Alien Caminando/3.png"));
		    image[3] = new ImageIcon(getClass().getResource("/Sprites/Alien Caminando/3.png"));
		 
	}
	
}
