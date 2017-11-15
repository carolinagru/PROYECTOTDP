package Factory;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Personajes.S3;
import Personajes.Soldado;
import Principal.Celda;

public class S3factory implements SoldadosFactoryMethod {
protected JPanel panel;
protected JLabel l;

	public S3factory(JPanel p) {
		panel= p;
	}
	
	public Soldado createPersonaje (Celda c) {
		Soldado p = new S3(c);
		c.setElemento(p);
		l = p.getGrafico(0);
		panel.add(l);
		l.repaint();
		
	 return p;	
	}

}
