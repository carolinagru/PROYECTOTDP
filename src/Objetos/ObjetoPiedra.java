package Objetos;

import Graficos.ObjetoPiedraGrafico;
import Principal.Celda;
import Visitor.ElementoPiedra;

public class ObjetoPiedra extends ObjetoVida{

	
	public ObjetoPiedra(Celda c) {
		super(c);
		grafico = new ObjetoPiedraGrafico(c.getFila(), c.getColumna());
		e = new ElementoPiedra();
	
	}

	
	
	
}
