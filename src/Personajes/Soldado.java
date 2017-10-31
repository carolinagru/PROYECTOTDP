package Personajes;

import Principal.Celda;
import Visitor.ElementoSoldado;
import Visitor.Visitor;
import Visitor.VisitorSoldado;

public  class Soldado extends Personaje {
	protected VisitorSoldado miVisitor;
	protected int precio;
	
	
	public Soldado(Celda pos) {
 		super(pos);
 		v = new VisitorSoldado();
 		e = new ElementoSoldado();
 		
	
 }

	
}
