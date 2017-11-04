package Graficos;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DisparoGrafico extends PersonajeGrafico {
	
	public DisparoGrafico(int fila, int columna) {
		
		super(fila,columna);
		this.width=80;
		this.height=80;
		image = new ImageIcon(this.getClass().getResource("/Sprites/Disparo/0.png"));
	
}
	public void setPoint(int x, int y) {
		pos.setLocation(x*80, y*80);
	}
	
	public JLabel getGrafico() {
		label= new JLabel(image);
		label.setBounds(pos.y, pos.x, width, height); 
		ImageIcon aux = (ImageIcon)image;
		Icon icono = new ImageIcon(aux.getImage().getScaledInstance(10,10, Image.SCALE_DEFAULT));
		label.setIcon(icono);
		return label;
		
	}
	
	public void actualizarGrafico(){		
	
	  ImageIcon aux=(ImageIcon) image;
	  Icon icono = new ImageIcon(aux.getImage().getScaledInstance(10, 10, Image.SCALE_DEFAULT));
	  label.setIcon(icono);
	  label.setBounds(pos.y, pos.x, width, height);
		
	}

}
