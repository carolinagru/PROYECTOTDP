	package Personajes;
	
	import Principal.Celda;
	 
	import Visitor.Visitor;
	import Visitor.VisitorSoldado;
	
	public  class Soldado extends Personaje {
		protected int precio;
		
		
	public Soldado(Celda pos) {
	 		super(pos);
	 }
		
	
	public void setVida(float f) {
		vida-=f;
	}
	
	public int getVida() {
		return vida;
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
	 
	public boolean puedoAtacar(Visitor v) {
		return v.Atacar(this);
	}
	
	
		
	}
<<<<<<< HEAD
=======

public boolean dejoPasar(Visitor v) {
	return v.puedoPasar(this);
}

public boolean puedeAtacar(Visitor v) {
	return v.puedoAtacar(this);
}

	
}
>>>>>>> 32787b521ced229c87f564e56dd02640b5a3bc1f
