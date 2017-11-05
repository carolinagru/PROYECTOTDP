package Disparo;

import Graficos.DisparoGrafico;
import Principal.Celda;
import Visitor.Visitor;

public class BalaSoldado extends Bala {
	
	public BalaSoldado (Celda pos,float f){
		super(pos, f);
		grafico = new DisparoGrafico (pos.getFila(),pos.getColumna());
		
	}
	

	public void accept(Visitor v) {
		 v.visit(this);
	}


	public boolean dejoPasar(Visitor v) {
		return true;
	}

 
	
}
