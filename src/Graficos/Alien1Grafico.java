package Graficos;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Alien1Grafico extends ObstaculoGrafico{

	public Alien1Grafico(int fila, int columna) {
			super(fila, columna);
			//System.out.println("Entre alien grafico Fila :"+fila + " Columna :"+columna);
			image[0] = new ImageIcon(getClass().getResource("/Sprites/Sprite Alien/GIF 's/A1.gif"));
		    image[1] = new ImageIcon(getClass().getResource("/Sprites/Sprite Alien/Alien Atacando/A1.gif"));
		    image[2] = new ImageIcon(getClass().getResource("/Sprites/Sprite Alien/GIF 's/Alien-muriendo-1.gif"));
		    image[3] = new ImageIcon(getClass().getResource("/Sprites/Sprite Alien/GIF 's/A1.gif"));
	}
	
	public void actualizarGrafico(int dir){		
	       
		  ImageIcon aux=(ImageIcon) image[dir];
		  Icon icono = new ImageIcon(aux.getImage().getScaledInstance(label.getWidth(), label.getWidth(), Image.SCALE_DEFAULT));
		  label.setIcon(icono);
		  label.setBounds(pos.y, pos.x, width, height);
			
		}


}
