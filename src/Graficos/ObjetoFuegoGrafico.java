package Graficos;

import javax.swing.ImageIcon;

public class ObjetoFuegoGrafico extends ObstaculoGrafico{

	public ObjetoFuegoGrafico(int fila, int columna) {
		super(fila, columna);
		//cambiar imagen y
		image[0] = new ImageIcon(getClass().getResource("/Sprites/objetos/fuego.gif"));
	    image[1] = new ImageIcon(getClass().getResource("/Sprites/objetos/fuego.gif"));
	    image[2] = new ImageIcon(getClass().getResource("/Sprites/objetos/fuego.gif"));
	    image[3] = new ImageIcon(getClass().getResource("/Sprites/objetos/fuego.gif"));
	}
}
