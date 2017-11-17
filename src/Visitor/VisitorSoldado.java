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
	
	public class VisitorSoldado implements Visitor {
		protected Personaje mySoldado;
		protected Estado myEstado;
		
	public void setSoldado (Personaje a){
		mySoldado = a;
	}
	public void visit(Alien a) {
		//System.out.println("VISITOR SOLDADO : Fuerza Soldado"+mySoldado.getFuerza()+" Fuerza Alien:"+a.getFuerza()+" Vida Alien :"+a.getVida()+ " Vida Soldado :"+mySoldado.getVida());
		myEstado.disminuirVida(mySoldado.getFuerza(),a);
		 
	}
	public void setEstado (Estado e) {
		myEstado = e;
	}
	public void visit(Soldado a) {
		
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