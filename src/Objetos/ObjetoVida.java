package Objetos;

import Principal.Celda;
import Visitor.Visitor;

public class ObjetoVida extends Obstaculo {
	
	
	public ObjetoVida(Celda pos) {
		this.pos = pos;
		grafico = null;
		
	}

	@Override
	public boolean accept(Visitor v) {
		return v.visit(this);
	}

	public void atacar(Visitor v) {
		v.sacarVida(this);
	}

}
