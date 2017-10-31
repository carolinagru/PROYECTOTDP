package Visitor;

import Personajes.*;

public interface Visitor {
	
	public boolean puedoPasar (ElementoAlien a );
	public boolean puedoPasar (ElementoSoldado a );
	public boolean puedoPasar (ElementoAgua a );
	public boolean puedoPasar (ElementoFuego a );
	public boolean puedoPasar (ElementoFuente a );
	public boolean puedoPasar (ElementoPiedra a );
	
	public boolean puedoAtacar (ElementoSoldado a);
	public boolean puedoAtacar (ElementoAlien a);
	public boolean puedoAtacar (ElementoFuente a);
	public boolean puedoAtacar (ElementoPiedra a);

	
	
}
