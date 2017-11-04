package Graficos;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Alien1Grafico extends PersonajeGrafico{

	public Alien1Grafico(int fila, int columna) {
			super(fila, columna);
			System.out.println("Entre alien grafico Fila :"+fila + " Columna :"+columna);
			image = new ImageIcon(this.getClass().getResource("/Sprites/Sprite Alien/GIF 's/A2.gif"));
	}
	
	public void actualizarGrafico (int n){
		if ( n == 0){
			  ImageIcon aux=(ImageIcon) image;
			  image = new ImageIcon(this.getClass().getResource("/Sprites/Sprite Alien/GIF 's/Amuriendo1.gif"));
			  label.setIcon(image);
			  label.setBounds(pos.y, pos.x, width, height);
				
		}
		
	}

}
