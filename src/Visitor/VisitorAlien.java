package Visitor;

import Disparo.Bala;
import Objetos.ObjetoAgua;
import Objetos.ObjetoFuego;
import Objetos.ObjetoFuente;
import Objetos.ObjetoPiedra;
import Objetos.ObjetoTemporal;
import Objetos.ObjetoVida;
import Personajes.Alien;
import Personajes.Personaje;
import Personajes.Soldado;

public class VisitorAlien implements Visitor {
	protected Personaje myAlien;
	
	public void setAlien (Personaje a ){
		myAlien = a;
	}

	public void visit(Alien a) {
		 
	}

	public void visit(Soldado a) {
		System.out.println("----VISITOR ALIEN : Fuerza alien"+myAlien.getFuerza()+" Fuerza soldado:"+a.getFuerza()+"Vida Alien :"+myAlien.getVida()+" Vida Soldado :"+a.getVida() );
		a.setVida(myAlien.getFuerza()*a.getVida());
 	}

	public void visit(ObjetoVida a) {
		 
	}
	
	public void visit(Bala b){  
		 
	}
 
	public void visit(ObjetoTemporal a) {
		 
	}
	 
	public void visit(ObjetoAgua a) {
	
		
	}

	public void visit(ObjetoFuego a) {
	 
		
	}
 
	public void visit(ObjetoFuente a) {
	 a.setVida(20);
	}
 
	public void visit(ObjetoPiedra a) {
	 
	}

	public boolean puedoPasar(Bala a) {
		return false;
	}

	public boolean puedoPasar(Alien a) {
		return false;
	}

	public boolean puedoPasar(Soldado a) {
		return false;
	}

	public boolean puedoAtacar(Alien a) {
		return false;
	}

	public boolean puedoAtacar(Soldado a) {
		return true;
	}

	@Override
	public boolean puedoAtacar(ObjetoVida a) {
		// TODO Auto-generated method stub
		return true;
	}

	
}
