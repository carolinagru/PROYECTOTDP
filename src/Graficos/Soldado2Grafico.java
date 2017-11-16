package Graficos;


import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Soldado2Grafico extends ObstaculoGrafico{

	public  Soldado2Grafico(int x, int y) {
			super(x, y);
			System.out.println("Entre soldado grafico 2");
		    image[0] = new ImageIcon(getClass().getResource("/Sprites/Sprite Soldado/Soldados Estaticos/S2.gif"));
		    image[1] = new ImageIcon(getClass().getResource("/Sprites/Sprite Soldado/GIF's/S2.gif"));
		    image[2] = new ImageIcon(getClass().getResource ("/Sprites/Sprite Soldado/GIF's/SoldadoMuriendo-5.gif"));
		    image[3] = new ImageIcon(getClass().getResource("/Sprites/Sprite Soldado/GIF's/S2.gif"));
	}
	public void actualizarGrafico(int dir){		
		System.out.println("Entre a actualizar Grafico Muerte---------------------------------");
		  ImageIcon aux=(ImageIcon) image[dir];
		  Icon icono = new ImageIcon(aux.getImage().getScaledInstance(label.getWidth(), label.getWidth(), Image.SCALE_DEFAULT));
		  label.setIcon(icono);
		  label.setBounds(pos.y, pos.x, width, height);
			
		}
	
}
