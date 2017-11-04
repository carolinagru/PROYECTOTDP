package Personajes;

import Premios.Premio;
import Principal.Celda;
import Visitor.*;

public  class Alien extends Personaje {
	
    protected VisitorAlien miVisitor;
	protected int moneda;
    protected int punto;
    protected Premio powerUps;
     
     public Alien(Celda pos) {
 		super(pos);
 		v = new VisitorAlien(); 
 		
 	}
     
     public void setVisitor (VisitorAlien v){
    	 miVisitor = v;
     }
     public void accept(Visitor v) {
  		 v.visit(this);
  	}

   
     
     

}
