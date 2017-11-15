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


	public boolean dejoPasar(Visitor v) {
		return true;
	}


	@Override
	public boolean puedeAtacar(Visitor v) {
		// TODO Auto-generated method stub
		return false;
	}
 
	
}
