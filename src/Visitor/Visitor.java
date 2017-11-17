package Visitor;

import Disparo.Bala;
import Objetos.ObjetoAgua;
import Objetos.ObjetoFuego;
import Objetos.ObjetoFuente;
import Objetos.ObjetoPiedra;
import Objetos.ObjetoTemporal;
import Objetos.ObjetoVida;
import Personajes.*;
import PowerUps.MagiaTemporal;

public interface Visitor {
<<<<<<< HEAD
	public void visit (ObjetoTemporal o);
	public void visit (MagiaTemporal m);
	public void visit (ObjetoAgua a);
	public void visit (ObjetoFuego a);
	public void visit (ObjetoFuente a);
	public void visit (ObjetoPiedra a);
=======
	public void visit (ObjetoTemporal a);
>>>>>>> 32787b521ced229c87f564e56dd02640b5a3bc1f
	public void visit (Bala a);
	public void visit (Alien a );
	public void visit (Soldado a );
	public void visit (ObjetoVida a );

	public boolean puedoPasar (ObjetoTemporal a);
	public boolean puedoPasar (ObjetoAgua a);
	public boolean puedoPasar (ObjetoFuego a);
	public boolean puedoPasar (ObjetoFuente a);
	public boolean puedoPasar (ObjetoPiedra a);
	public boolean puedoPasar (Bala a);
	public boolean puedoPasar (Alien a );
	public boolean puedoPasar (Soldado a );
	public boolean puedoPasar (ObjetoVida a );
	public boolean puedoPasar (MagiaTemporal m);

	
	public boolean Atacar (ObjetoTemporal a);
	public boolean Atacar (ObjetoAgua a);
	public boolean Atacar (ObjetoFuego a);
	public boolean Atacar (ObjetoFuente a);
	public boolean Atacar (ObjetoPiedra a);
	public boolean Atacar (Bala a);
	public boolean Atacar (Alien a );
	public boolean Atacar (Soldado a );
	public boolean Atacar (ObjetoVida a );
	public boolean Atacar (MagiaTemporal m);

	public boolean puedoAtacar(Alien a);
	public boolean puedoAtacar(Soldado a);
	public boolean puedoAtacar(ObjetoVida a);
}

 
