package Personajes;

import Estate.Estado;
import Premios.MagiaTemporal;
import Premios.Premio;
import Principal.Celda;
import Visitor.*;

public class Alien extends Personaje {
	
	protected int moneda;
    protected int punto;
    protected Estado myEstado;
     
     public Alien(Celda pos) {
 		super(pos);
 		myEstado = null;
 	
 	}
   
     public void setEstado (Estado e ) {
    	this.myEstado = e;
     }
     
     public Estado getEstado () {
    	 return this.myEstado;
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
	
	public int getPuntos () {
		return punto;
	}

	public boolean puedeAtacar(Visitor v) {
		return v.puedoAtacar(this);
	}
     

}
