package Disparo;

import Graficos.DisparoGrafico;
import Principal.Celda;
import Visitor.Visitor;
import Visitor.VisitorDisparo;

public class DisparoSoldado extends Bala {
	protected VisitorDisparo miVisitor;
	
	public DisparoSoldado (Celda pos,float f){
		super(pos, f);
		grafico = new DisparoGrafico (pos.getFila(),pos.getColumna());
		
	}
	

	public void accept(Visitor v) {
		 v.visit(this);
	}

 
	
}
