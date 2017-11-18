package Visitor;

import Disparo.Bala;
import Disparo.BalaSoldado;
import Objetos.ObjetoAgua;
import Objetos.ObjetoFuego;
import Objetos.ObjetoFuente;
import Objetos.ObjetoPiedra;
import Objetos.ObjetoTemporal;
import Objetos.ObjetoVida;
import Personajes.Alien;
import Personajes.Soldado;
import PowerUps.MagiaTemporal;

public class VisitorBalaSoldado implements Visitor{
	protected Bala myDisparoSoldado;
	
	
	public void setBala (Bala b){
		  myDisparoSoldado = b;
	}
	 
	public void visit(Alien a) {
		a.setVida(20);
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
		return false;
	}

	public boolean puedoPasar(Soldado a) {
		return true;
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
		 
		return true;
	}

	 
	public boolean Atacar(Soldado a) {
		 
		return false;
	}

	 
	public boolean Atacar(ObjetoVida a) {
	 
		return false;
	}

	 
	public boolean Atacar(MagiaTemporal m) {
	 
		return false;
	}


	
	

	
	

}