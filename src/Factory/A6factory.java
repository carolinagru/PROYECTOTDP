package Factory;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Personajes.A1;
import Personajes.A6;
import Personajes.Personaje;
import Personajes.S1;
import Principal.Celda;
import Principal.Logica;

public class A6factory  implements PersonajesFactoryMethod {
protected JPanel panel;
protected JLabel l;

	public A6factory(JPanel p) {
		panel= p;
	}
	public Personaje createPersonaje (Celda c) {
		Personaje p = new A6(c);
		c.setElemento(p);
		l = p.getGrafico(0);
		panel.add(l);
		l.repaint();
		
	 return p;	
	}
}
