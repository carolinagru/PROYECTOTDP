package Graficos;


import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Soldado1Grafico extends PersonajeGrafico{

	public  Soldado1Grafico(int x, int y) {
			super(x, y);
			image = new ImageIcon(this.getClass().getResource("/Sprites/Sprite Soldado/GIF's/S6.gif"));
	}
	
	public void actualizarGrafico(){		
		
		  ImageIcon aux=(ImageIcon) image;
		  Icon icono = new ImageIcon(aux.getImage().getScaledInstance(label.getWidth(), label.getWidth(), Image.SCALE_DEFAULT));
		  label.setIcon(icono);
		  label.setBounds(pos.y, pos.x, width, height);
			
		}

	public void actualizarGrafico(int n){		
		 if ( n == 0){
			 System.out.println("-------------Entre a actualizar");
			 ImageIcon aux =  new ImageIcon(this.getClass().getResource("/Sprites/Sprite Soldado/GIF's/muerte1.gif"));
			  label.setIcon(aux);
			  label.setBounds(pos.y, pos.x, 80, 80);
			}
		 else
			 if ( n == 1){
				 label.setIcon(null);
				 
			 }

	}
	

}
