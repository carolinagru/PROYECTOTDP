package Objetos;

import Principal.Celda;
import Visitor.Visitor;

public class ObjetoTemporal extends Obstaculo{
	protected int precio;
	public ObjetoTemporal(Celda pos) {
		this.pos = pos;
		grafico = null;	
		 
		this.precio = 0;
	}

	 public int getPrecio () {
		 return precio;
	 }
	public void accept(Visitor v) {
		v.visit(this);
	}


	public boolean dejoPasar(Visitor v) {
		return v.puedoPasar(this);
	}
	
	public boolean puedoAtacar (Visitor v) {
		return v.Atacar(this);
	}
 
	public boolean puedeAtacar(Visitor v) { // TODO Auto-generated method stub
		return false;
	}
}
