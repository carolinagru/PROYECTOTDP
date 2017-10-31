package Factory;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Personajes.A1;
import Personajes.Personaje;
import Personajes.S1;
import Personajes.S3;
import Principal.Celda;
import Principal.Logica;

public class S3factory implements PersonajesFactoryMethod {
protected JPanel panel;
protected JLabel l;

	public S3factory(JPanel p) {
		panel= p;
	}
	
	public Personaje createPersonaje (Celda c) {
		Personaje p = new S3(c);
		c.setElemento(p);
		l = p.getGrafico();
		panel.add(l);
		l.repaint();
		
	 return p;	
	}

}
