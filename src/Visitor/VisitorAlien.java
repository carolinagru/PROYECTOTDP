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
import PowerUps.MagiaTemporal;

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
		a.setVida(a.getVida()*myAlien.getFuerza());
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
	

	@Override
	public boolean Atacar(MagiaTemporal m) {
	 
		return false;
	}

	@Override
	public void visit(MagiaTemporal m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean puedoPasar(ObjetoTemporal a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean puedoPasar(ObjetoAgua a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean puedoPasar(ObjetoFuego a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean puedoPasar(ObjetoFuente a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean puedoPasar(ObjetoPiedra a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean puedoPasar(ObjetoVida a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean puedoPasar(MagiaTemporal m) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	

	
	
	 
	public boolean Atacar(ObjetoTemporal a) {
	 
		return false;
	}

	 
	public boolean Atacar(ObjetoAgua a) {
		 
		return false;
	}

	 
	public boolean Atacar(ObjetoFuego a) {
		 
		return false;
	}

	 
	public boolean Atacar(ObjetoFuente a) {
		 
		return false;
	}

	 
	public boolean Atacar(ObjetoPiedra a) {
	 
		return false;
	}

	 
	public boolean Atacar(Bala a) {
	 
		return false;
	}

	 
	public boolean Atacar(Alien a) {
	 
		return false;
	}

	 
	public boolean Atacar(Soldado a) {
		 
		return true;
	}

	 
	public boolean Atacar(ObjetoVida a) {
		 
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
