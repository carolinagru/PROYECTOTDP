package Disparo;

import Graficos.DisparoGrafico;
import Principal.Celda;
import Visitor.ElementoDisparo;
import Visitor.Visitor;
import Visitor.VisitorDisparo;

public class DisparoSoldado extends Bala {
	protected VisitorDisparo miVisitor;
	
	public DisparoSoldado (Celda pos,int f){
		super(pos, f);
		v = new VisitorDisparo();
		e = new ElementoDisparo();
		grafico = new DisparoGrafico (pos.getFila(),pos.getColumna());
	}

}
