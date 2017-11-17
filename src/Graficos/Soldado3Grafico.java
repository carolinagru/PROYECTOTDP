package Graficos;


import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Soldado3Grafico extends ObstaculoGrafico{

	public  Soldado3Grafico(int x, int y) {
			super(x, y);
			  image[0] = new ImageIcon(getClass().getResource("/Sprites/Sprite Soldado/Soldados Estaticos/S3.gif"));
		    image[1] = new ImageIcon(getClass().getResource("/Sprites/Sprite Soldado/GIF's/S3.gif"));
		    image[2] = new ImageIcon(getClass().getResource ("/Sprites/Sprite Soldado/GIF's/SoldadoMuriendo-5.gif"));
		    image[3] = new ImageIcon(getClass().getResource("/Sprites/Sprite Soldado/GIF's/S3.gif"));
		 
	}
	
	public void actualizarGrafico(int dir){		
		 
		  ImageIcon aux=(ImageIcon) image[dir];
		  Icon icono = new ImageIcon(aux.getImage().getScaledInstance(label.getWidth(), label.getWidth(), Image.SCALE_DEFAULT));
		  label.setIcon(icono);
		  label.setBounds(pos.y, pos.x, width, height);
			
		}
	
}
