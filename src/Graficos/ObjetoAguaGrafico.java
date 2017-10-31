package Graficos;

import javax.swing.ImageIcon;

public class ObjetoAguaGrafico extends PersonajeGrafico{

	public ObjetoAguaGrafico(int fila, int columna) {
		super(fila, columna);
		
		//cambiar imagen 
		image = new ImageIcon(this.getClass().getResource("/Sprites/Alien Caminando/2.png"));

	}

}
