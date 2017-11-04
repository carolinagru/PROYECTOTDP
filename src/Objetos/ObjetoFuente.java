package Objetos;

import Graficos.ObjetoFuenteGrafico;
import Principal.Celda;
import Visitor.Visitor;


public class ObjetoFuente extends ObjetoVida{

	public ObjetoFuente(Celda c) {
		super(c);
		grafico = new ObjetoFuenteGrafico(c.getFila(), c.getColumna());
	}
	
	public void accept(Visitor v) {
		v.visit(this);
	}

}
