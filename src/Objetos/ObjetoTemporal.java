package Objetos;

import Principal.Celda;
import Visitor.Visitor;

public class ObjetoTemporal extends Obstaculo{

	public ObjetoTemporal(Celda pos) {
		this.pos = pos;
		grafico = null;	
	}

	 
	public void accept(Visitor v) {
		v.visit(this);
	}
 
	
}
