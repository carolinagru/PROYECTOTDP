package Graficos;

import java.awt.Image;
import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Campo_Proteccion_Grafico extends ObstaculoGrafico {
	
	public Campo_Proteccion_Grafico() {
		super( );
		this.pos = new Point();
		image[0] = new ImageIcon(getClass().getResource("/Sprites/PowerUps/campo.gif"));
		image[1] = new ImageIcon(getClass().getResource("/Sprites/PowerUps/campo.gif"));
		image[2] = new ImageIcon(getClass().getResource("/Sprites/PowerUps/campo.gif"));
		image[3] = new ImageIcon(getClass().getResource("/Sprites/PowerUps/campo.gif"));
	}
 
	
public void setPoint(int x, int y) {
		pos.setLocation(x*width, y*height);
	}
	
public void actualizarGrafico(int dir){		
       
	  ImageIcon aux=(ImageIcon) image[dir];
	  Icon icono = new ImageIcon(aux.getImage().getScaledInstance(label.getWidth(), label.getWidth(), Image.SCALE_DEFAULT));
	  label.setIcon(icono);
	  label.setBounds(pos.y, pos.x, width, height);
		
	}


}
	
	
	
 
