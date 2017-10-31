package Factory;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Personajes.A1;
import Personajes.Personaje;
import Personajes.S1;
import Personajes.S2;
import Principal.Celda;
import Principal.Logica;

public class S2factory implements PersonajesFactoryMethod {
protected JPanel panel;
protected JLabel l;
	
	public S2factory(JPanel p) {
		panel= p;
	}
	
	public Personaje createPersonaje (Celda c) {
		Personaje p = new S2(c);
		c.setElemento(p);
		System.out.println("filas y columnas de factory "+c.getFila()+" "+c.getColumna());
		l = p.getGrafico();
		panel.add(l);
		l.repaint();
		
	 return p;	
	}

}
