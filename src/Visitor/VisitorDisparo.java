package Visitor;

import Disparo.Bala;
import Disparo.DisparoSoldado;
import Objetos.ObjetoAgua;
import Objetos.ObjetoFuego;
import Objetos.ObjetoFuente;
import Objetos.ObjetoPiedra;
import Objetos.ObjetoTemporal;
import Objetos.ObjetoVida;
import Personajes.Alien;
import Personajes.Soldado;

public class VisitorDisparo implements Visitor{
	protected DisparoSoldado myDisparoSoldado;
	
	public void setBala (DisparoSoldado b){
		  myDisparoSoldado = b;
	}
	 
	public void visit(Alien a) {
		System.out.println("-------VISIT DISPARO  Fuerza de impacto: "+myDisparoSoldado.getFuerzaImpacto()+" Alien vida :"+a.getVida());
		a.setVida(myDisparoSoldado.getFuerzaImpacto()*a.getVida());
		System.out.println("-----------VISIT DISPARO   Alien vida :"+a.getVida());

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
	
	

}
