package Graficos;

import javax.swing.ImageIcon;

public class ObjetoFuegoGrafico extends PersonajeGrafico{

	public ObjetoFuegoGrafico(int fila, int columna) {
		super(fila, columna);
		
		//cambiar imagen 
		image = new ImageIcon(this.getClass().getResource("/Sprites/objetos/fuego.jpg"));

	}
	
	
	
	

}
