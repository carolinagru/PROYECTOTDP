  package Factory;

import javax.swing.JLabel;

import Personajes.Personaje;
import Principal.Celda;

public interface PersonajesFactoryMethod {
	
	public Personaje createPersonaje (Celda c);
	
	
}
