package Objetos;

import Principal.Celda;
import Visitor.Visitor;
 

public class ObjetoVida extends Obstaculo {
	

	public ObjetoVida(Celda pos) {
		this.pos = pos;
		grafico = null;
		
	}

	 
	public void accept(Visitor v) {
		 v.visit(this);
	}

	public void setVida(float f) {
		vida-=f;
	}
	
	public int getVida() {
		return vida;
	}


	@Override
	public boolean dejoPasar(Visitor v) {
		return false;
	}

	 

}