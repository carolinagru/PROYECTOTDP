package Objetos;

import Graficos.ObjetoPiedraGrafico;
import Principal.Celda;
import Visitor.Visitor;


public class ObjetoPiedra extends ObjetoVida{

	
	public ObjetoPiedra(Celda c) {
		super(c);
		grafico = new ObjetoPiedraGrafico(c.getFila(), c.getColumna());
	}
	
	public void accept(Visitor v) {
		v.visit(this);
	}


}
