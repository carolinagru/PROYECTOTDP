package Graficos;

import java.awt.Point;

import javax.swing.ImageIcon;

public class BombaGrafico extends ObstaculoGrafico{
	
	public BombaGrafico() {
		super();
		this.pos = new Point();
		image[0] = new ImageIcon(getClass().getResource("/Sprites/botones/bomba.png"));
		image[1] = new ImageIcon(getClass().getResource("/Sprites/botones/bomba.png"));
		image[2] = new ImageIcon(getClass().getResource("/Sprites/botones/bomba.png"));
		image[3] = new ImageIcon(getClass().getResource("/Sprites/botones/bomba.png"));
		
	}

}
