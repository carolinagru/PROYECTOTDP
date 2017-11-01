package Objetos;

import Principal.Celda;
import Visitor.Visitor;

public class ObjetoTemporal extends Obstaculo{

	public ObjetoTemporal(Celda pos) {
		this.pos = pos;
		grafico = null;	
	}

	@Override
	public boolean accept(Visitor v) {
		return false;
	}
	
	public void atacar(Visitor v) {
		
	}
}
