package Graficos;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Alien3Grafico extends PersonajeGrafico{

	public Alien3Grafico(int x, int y) {
			super(x, y);
			
			image = new ImageIcon(this.getClass().getResource("/Sprites/Alien Caminando/3.png"));
		 
	}
	public void actualizarGrafico(int n){		
		 if ( n == 0){
			  ImageIcon aux =  new ImageIcon(this.getClass().getResource("/Sprites/Sprite Soldado/GIF's/muerte1.gif"));
			//  Icon icono = new ImageIcon(aux.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
			  label.setIcon(aux);
			  label.setBounds(pos.y, pos.x, 80, 80);
				
			}

	}

}
