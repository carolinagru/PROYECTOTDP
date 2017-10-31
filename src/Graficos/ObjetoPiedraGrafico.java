package Graficos;

import javax.swing.ImageIcon;

public class ObjetoPiedraGrafico extends PersonajeGrafico{

	public ObjetoPiedraGrafico(int fila, int columna) {
		super(fila, columna);
		
		//cambiar imagen 
		image = new ImageIcon(this.getClass().getResource("/Sprites/Alien Caminando/2.png"));

	}

}
