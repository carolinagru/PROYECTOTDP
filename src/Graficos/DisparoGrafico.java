package Graficos;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DisparoGrafico extends PersonajeGrafico {
	
	public DisparoGrafico(int fila, int columna) {
		
		super(fila,columna);
		image = new ImageIcon(this.getClass().getResource("/Sprites/Disparo/0.png"));
	
	}
	
	public void setPoint(int x, int y) {
		pos.setLocation(x*80, y*80);
	}

}
