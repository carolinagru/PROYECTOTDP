package Graficos;


import javax.swing.ImageIcon;

public class Soldado3Grafico extends ObstaculoGrafico{

	public  Soldado3Grafico(int x, int y) {
			super(x, y);
			image[0] = new ImageIcon(getClass().getResource("/Sprites/Sprite Soldado/GIF's/S3.gif"));
		    image[1] = new ImageIcon(getClass().getResource("/Sprites/Sprite Soldado/GIF's/S3.gif"));
		    image[2] = new ImageIcon(getClass().getResource("/Sprites/Sprite Soldado/GIF's/S3.gif"));
		    image[3] = new ImageIcon(getClass().getResource("/Sprites/Sprite Soldado/GIF's/S3.gif"));
		 
	}
	
}
