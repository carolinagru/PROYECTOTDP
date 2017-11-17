package Visitor;

import Disparo.Bala;
import Estate.Estado;
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
	protected Estado myEstado;
	
	public void setAlien (Personaje a ){
		myAlien = a;
	}
	
	public void setEstado (Estado e ) {
		myEstado = e;
	}

	public void visit(Alien a) {
		 
	}

	public void visit(Soldado a) {
		//System.out.println("----VISITOR ALIEN : Fuerza alien"+myAlien.getFuerza()+" Fuerza soldado:"+a.getFuerza()+"Vida Alien :"+myAlien.getVida()+" Vida Soldado :"+a.getVida() );
		//a.disminuirVida(myAlien.getFuerza(),a);
 	}

	public void visit(ObjetoVida a) {
		 
	}
	
	public void visit(Bala b){  
		 
	}
 
	public void visit(ObjetoTemporal a) {
		 
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
