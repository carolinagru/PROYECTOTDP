package Personajes;

import Principal.Celda;
import Visitor.Visitor;
import Visitor.VisitorSoldado;

public  class Soldado extends Personaje {
	protected VisitorSoldado miVisitor;
	protected int precio;
	
	
	public Soldado(Celda pos) {
 		super(pos);
 		v = new VisitorSoldado();
	}
	
	public boolean accept(Visitor v) {
		return v.visit(this);
	}
	
	public void atacar(Visitor v){
	    v.sacarVida(this);
	}
}
