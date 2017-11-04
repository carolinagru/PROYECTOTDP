package Visitor;

import Disparo.Bala;
import Objetos.ObjetoAgua;
import Objetos.ObjetoFuego;
import Objetos.ObjetoFuente;
import Objetos.ObjetoPiedra;
import Objetos.ObjetoTemporal;
import Objetos.ObjetoVida;
import Personajes.*;

public interface Visitor {
	public void visit(ObjetoTemporal a);
	public void visit(ObjetoAgua a);
	public void visit(ObjetoFuego a);
	public void visit(ObjetoFuente a);
	public void visit(ObjetoPiedra a);
	public void visit(Bala a);
	public void visit (Alien a );
	public void visit (Soldado a );
	public void visit (ObjetoVida a );

	}

 
