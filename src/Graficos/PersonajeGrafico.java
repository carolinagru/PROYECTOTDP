package Graficos;
import java.awt.Image;
import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
public class PersonajeGrafico {



	protected JLabel label; 
	protected Icon image;
	protected int width=80;
	protected int height=80;
	protected Point pos;

	public PersonajeGrafico( int fila, int columna ) {
		pos = new Point(fila * this.width, columna * this.height);
	}
		
	public void setPoint(int x, int y) {
		pos.setLocation(x*width, y*height);
	}
	
	public JLabel getGrafico() {
		label= new JLabel(image);
		label.setBounds(pos.y, pos.x, width, height); 
		ImageIcon aux = (ImageIcon)image;
		Icon icono = new ImageIcon(aux.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(icono);
		return label;
		
	}
	
	public void actualizarGrafico(){		
	
	  ImageIcon aux=(ImageIcon) image;
	  Icon icono = new ImageIcon(aux.getImage().getScaledInstance(label.getWidth(), label.getWidth(), Image.SCALE_DEFAULT));
	  label.setIcon(icono);
	  label.setBounds(pos.y, pos.x, width, height);
		
	}
}

 
