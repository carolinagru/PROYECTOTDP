package Graficos;

import javax.swing.ImageIcon;

public class Alien1Grafico extends PersonajeGrafico{

	public Alien1Grafico(int fila, int columna) {
			super(fila, columna);
			System.out.println("Entre alien grafico Fila :"+fila + " Columna :"+columna);
			//image = new ImageIcon(this.getClass().getResource("/Sprites/Sprite Alien/Alien Caminando/0.png"));
			image = new ImageIcon(this.getClass().getResource("/Sprites/Sprite Alien/GIF 's/A2.gif"));
	}

}
