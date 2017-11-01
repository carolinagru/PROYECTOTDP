package Visitor;

import Objetos.ObjetoVida;
import Personajes.*;

public interface Visitor {
	
	public boolean visit (Alien a );
	public boolean visit (Soldado a );

	public boolean visit (ObjetoVida a );
	
}
