package Graficos;

import javax.swing.ImageIcon;

public class DisparoGrafico extends PersonajeGrafico {
	public DisparoGrafico(int fila, int columna) {
		super(fila,columna);
		image = new ImageIcon(this.getClass().getResource("/Sprites.Disparo/0.png"));

}

}
