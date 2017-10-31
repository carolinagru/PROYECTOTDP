package Graficos;

import javax.swing.ImageIcon;

public class Alien3Grafico extends PersonajeGrafico{

	public Alien3Grafico(int x, int y) {
			super(x, y);
			
			image = new ImageIcon(this.getClass().getResource("/Sprites/Alien Caminando/3.png"));
		 
	}
	

}
