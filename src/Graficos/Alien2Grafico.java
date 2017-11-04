package Graficos;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Alien2Grafico extends PersonajeGrafico{

	public Alien2Grafico(int x, int y) {
			super(x, y);
			
			image = new ImageIcon(this.getClass().getResource("/Sprites/Sprite Alien/GIF 's/A2.gif"));
	}
	
	public void actualizarGrafico(int n){		
		 if ( n == 0){
			 System.out.println("Entre a actualizar");
			  ImageIcon aux =  new ImageIcon(this.getClass().getResource("/Sprites/Sprite Soldado/GIF's/muerte1.gif"));
			 // Icon icono = new ImageIcon(aux.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
			  label.setIcon(aux);
			  label.setBounds(pos.y, pos.x, 80, 80);
				
			}

	}
}
