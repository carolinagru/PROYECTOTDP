package Visitor;

import Disparo.Bala;

public class VisitorDisparo implements Visitor{
	protected Bala myBala;
	
	public void setBala (Bala b){
		myBala = b;
	}
	 
	public boolean puedoPasar(ElementoDisparo a) {
		 
		return true;
	}

	 
	public boolean puedoPasar(ElementoSoldado a) {
		 
		return true;
	}

	 
	public boolean puedoPasar(ElementoAgua a) {
		 
		return true;
	}

	 
	public boolean puedoPasar(ElementoFuego a) {
		  
		return true;
	}

	 
	public boolean puedoPasar(ElementoFuente a) {
		 
		return true;
	}

	 
	public boolean puedoPasar(ElementoPiedra a) {
		 
		return true;
	}

	 
	public boolean puedoAtacar(ElementoSoldado a) {
		 
		return false;
	}

	 
	public boolean puedoAtacar(ElementoAlien a) {
	 
		return true;
	}

	 
	public boolean puedoAtacar(ElementoFuente a) {
		 
		return false;
	}

	 
	public boolean puedoAtacar(ElementoPiedra a) {
		 
		return false;
	}

	 
	public int sacameVida(ElementoFuente a) {
	 
		return 0;
	}

	 
	public int sacameVida(ElementoSoldado a) {
		 
		return 0;
	}

	 
	public int sacameVida(ElementoAlien a) {
		 
		return 0;
	}

 
	public int sacameVida(ElementoPiedra a) {
		 
		return 0;
	}

}
