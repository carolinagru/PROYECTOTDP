package Factory;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Personajes.A1;
import Personajes.A5;
import Personajes.Alien;
import Personajes.Personaje;
import Personajes.S1;
import Principal.Celda;
import Principal.Logica;

public class A5factory implements AlienFactoryMethod {
protected JPanel panel;
protected JLabel l;

	public A5factory(JPanel p) {
		panel= p;
	}
	
	public Alien createPersonaje (Celda c) {
		Alien p = new A5(c);
		c.setElemento(p);
		l = p.getGrafico(0);
		panel.add(l);
		l.repaint();
		
	 return p;	
	}

}
