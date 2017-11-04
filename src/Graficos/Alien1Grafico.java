package Graficos;

import javax.swing.ImageIcon;

public class Alien1Grafico extends PersonajeGrafico{

	public Alien1Grafico(int fila, int columna) {
			super(fila, columna);
			image = new ImageIcon(this.getClass().getResource("/Sprites/Sprite Alien/GIF 's/A2.gif"));
	}
//nn
}
