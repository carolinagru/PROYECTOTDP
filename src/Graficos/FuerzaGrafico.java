package Graficos;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class FuerzaGrafico extends ObstaculoGrafico {
	public FuerzaGrafico( ) {
		super( );
		 
		image[0] = new ImageIcon(getClass().getResource("/Sprites/PowerUps/0.gif"));
		 
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
	
	
	
	
	
	
	
	
	
	
	
	

 
