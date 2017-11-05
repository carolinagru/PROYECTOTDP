package Personajes;

import Principal.Celda;
 
import Visitor.Visitor;
import Visitor.VisitorSoldado;

public  class Soldado extends Personaje {
	protected int precio;
	
	
public Soldado(Celda pos) {
 		super(pos);
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


public boolean dejoPasar(Visitor v) {
	return v.puedoPasar(this);
}


	
}
