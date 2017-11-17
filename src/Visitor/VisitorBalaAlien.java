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
import PowerUps.MagiaTemporal;

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
	
	
	@Override
	public boolean Atacar(ObjetoTemporal a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Atacar(ObjetoAgua a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Atacar(ObjetoFuego a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Atacar(ObjetoFuente a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Atacar(ObjetoPiedra a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Atacar(Bala a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Atacar(Alien a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Atacar(Soldado a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Atacar(ObjetoVida a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Atacar(MagiaTemporal m) {
		// TODO Auto-generated method stub
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