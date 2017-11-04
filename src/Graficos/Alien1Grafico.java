package Graficos;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Alien1Grafico extends PersonajeGrafico{

	public Alien1Grafico(int fila, int columna) {
			super(fila, columna);
			System.out.println("Entre alien grafico Fila :"+fila + " Columna :"+columna);
			image[0] = new ImageIcon(getClass().getResource("/Sprites/Alien Caminando/1.png"));
		    image[1] = new ImageIcon(getClass().getResource("/Sprites/Alien Caminando/1.png"));
		    image[2] = new ImageIcon(getClass().getResource("/Sprites/Alien Caminando/1.png"));
		    image[3] = new ImageIcon(getClass().getResource("/Sprites/Alien Caminando/1.png"));
	}
	
	

}
