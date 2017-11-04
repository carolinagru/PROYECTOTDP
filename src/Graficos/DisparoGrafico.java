package Graficos;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DisparoGrafico extends ObstaculoGrafico {
	
	public DisparoGrafico(int fila, int columna) {
		
		super(fila,columna);
		image[0] = new ImageIcon(getClass().getResource("/Sprites/Disparo/0.png"));
	    image[1] = new ImageIcon(getClass().getResource("/Sprites/Disparo/0.png"));
	    image[2] = new ImageIcon(getClass().getResource("/Sprites/Disparo/0.png"));
	    image[3] = new ImageIcon(getClass().getResource("/Sprites/Disparo/0.png"));
	}
	
}
//dis