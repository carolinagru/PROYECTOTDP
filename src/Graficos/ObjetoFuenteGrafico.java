package Graficos;

import javax.swing.ImageIcon;

public class ObjetoFuenteGrafico extends PersonajeGrafico{

	public ObjetoFuenteGrafico(int fila, int columna) {
		super(fila, columna);
		
		//cambiar imagen 
		image = new ImageIcon(this.getClass().getResource("/Sprites/objetos/fuego.gif"));

	}

}
