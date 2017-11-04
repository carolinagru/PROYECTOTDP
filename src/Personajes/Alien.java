package Personajes;

import Premios.Premio;
import Principal.Celda;
import Visitor.*;

public  class Alien extends Personaje {
	
	protected int moneda;
    protected int punto;
    protected Premio powerUps;
     
     public Alien(Celda pos) {
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

   
     
     

}
