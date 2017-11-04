package Graficos;


import javax.swing.ImageIcon;

public class Soldado2Grafico extends PersonajeGrafico{

	public  Soldado2Grafico(int x, int y) {
			super(x, y);
			image[0] = new ImageIcon(getClass().getResource("/Sprites/Sprite Soldado/GIF's/S2.gif"));
		    image[1] = new ImageIcon(getClass().getResource("/Sprites/Sprite Soldado/GIF's/S2.gif"));
		    image[2] = new ImageIcon(getClass().getResource("/Sprites/Sprite Soldado/GIF's/S2.gif"));
		    image[3] = new ImageIcon(getClass().getResource("/Sprites/Sprite Soldado/GIF's/S2.gif"));
	}
	
}
