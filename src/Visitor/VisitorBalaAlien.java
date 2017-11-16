package Visitor;

import Disparo.Bala;
import Objetos.ObjetoAgua;
import Objetos.ObjetoFuego;
import Objetos.ObjetoFuente;
import Objetos.ObjetoPiedra;
import Objetos.ObjetoTemporal;
import Objetos.ObjetoVida;
import Personajes.Alien;
import Personajes.Soldado;

public class VisitorBalaAlien implements Visitor{
	protected Bala myDisparoAlien;
	
	public void setBala (Bala b){
		  myDisparoAlien = b;
	}
	 
	public void visit(Alien a) {
		a.setVida(myDisparoAlien.getFuerzaImpacto()*a.getVida());

	}

	 
	public void visit(Soldado a) {
		
	}
	
	public void visit(Bala b){
		
	}

	 
	public void visit(ObjetoVida a) {
		
	}

	 
	public void visit(ObjetoTemporal a) {
		 
		
	}

	 
	public void visit(ObjetoAgua a) {
		 
	}

	 
	public void visit(ObjetoFuego a) {
	 
	}

	 
	public void visit(ObjetoFuente a) {
	 
	}

	 
	public void visit(ObjetoPiedra a) {
	 
	}

	public boolean puedoPasar(Bala a) {
		return true;
	}

	public boolean puedoPasar(Alien a) {
		return true;
	}

	public boolean puedoPasar(Soldado a) {
		return false;
	}

	
	

}

