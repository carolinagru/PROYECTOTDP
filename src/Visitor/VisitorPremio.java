package Visitor;

import Disparo.Bala;
import Objetos.ObjetoAgua;
import Objetos.ObjetoFuego;
import Objetos.ObjetoFuente;
import Objetos.ObjetoPiedra;
import Objetos.ObjetoTemporal;
import Objetos.ObjetoVida;
import Objetos.ObjetoVidaComprar;
import Personajes.Alien;
import Personajes.Soldado;
import PowerUps.Bomba;
import PowerUps.Campo_de_Proteccion;
import PowerUps.Fuerza;
import PowerUps.MagiaTemporal;
import PowerUps.Piedra;
import Principal.Logica;

public class VisitorPremio  implements Visitor{
	private Logica l;
	
	public VisitorPremio (Logica l) {
		this.l = l;
	}
	 
	public void visit(ObjetoTemporal o) {
		
		
	}

	 
	public void visit(MagiaTemporal m) {
		 

	}
	
	public void visit (Bomba b) {
<<<<<<< HEAD
 
		System.out.println("Entre a visitar BOMBA ");
<<<<<<< HEAD
		l.getMapaCombate().eliminar(b);
		b.getCelda().setElemento(null);
=======
		l.getBombas().addLast(b);
=======
<<<<<<< HEAD
		System.out.println("Entre a visitar BOMBA "+l.getListaObjetosPrecioso().size());
		l.getGui().setBombas();
		
=======
>>>>>>> 1fccf882b4f605290218d231c34e3c8fcae79048
>>>>>>> c504cfefd8dd27c3500dc19d21875aad56075010
		l.getGui().incrementarBomba();
>>>>>>> 82bc74337f48638211395da67ee779e7b3075a08
	}
	
	public void visit (Fuerza f) {
		System.out.println("Entre a visitar FUERZA");
		l.activarMagia_Fuerza();
	}
	
	public void visit (Campo_de_Proteccion c ) {
		System.out.println("Entre a visitar CAMPO PROTECCION");
		l.activarMagia_Campo();
	}
 
	public void visit(ObjetoAgua a) {
	 
		
	}

	 
	public void visit(ObjetoFuego a) {
		 
		
	}

	@Override
	public void visit(ObjetoFuente a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ObjetoPiedra a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Bala a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Alien a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Soldado a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ObjetoVida a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ObjetoVidaComprar a) {
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
	public boolean puedoPasar(Bala a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean puedoPasar(Alien a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean puedoPasar(Soldado a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean puedoPasar(ObjetoVida a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean puedoPasar(ObjetoVidaComprar a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean puedoPasar(MagiaTemporal m) {
		// TODO Auto-generated method stub
		return false;
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
	public boolean Atacar(ObjetoVidaComprar a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Atacar(MagiaTemporal m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void visit(Piedra p) {
		// TODO Auto-generated method stub
		l.getPiedras().addLast(p);
		l.getGui().incrementarPiedra();
	}

	@Override
	public boolean puedoPasar(Piedra p) {
		// TODO Auto-generated method stub
		return false;
	}

}
