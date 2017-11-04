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
	
public void setVisitor (VisitorSoldado v) {
	miVisitor = v;
}
public void accept(Visitor v) {
 	 v.visit(this);
 	}


	
}
