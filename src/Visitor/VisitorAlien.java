package Visitor;

import Personajes.Alien;
import Personajes.Personaje;
import Personajes.Soldado;

public class VisitorAlien implements Visitor {

	@Override
	public boolean puedoPasar(ElementoAlien a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean puedoPasar(ElementoSoldado a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean puedoPasar(ElementoAgua a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean puedoPasar(ElementoFuego a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean puedoPasar(ElementoFuente a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean puedoPasar(ElementoPiedra a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean puedoAtacar(ElementoSoldado a) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean puedoAtacar(ElementoAlien a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean puedoAtacar(ElementoFuente a) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean puedoAtacar(ElementoPiedra a) {
		// TODO Auto-generated method stub
		return true;
	}

		

}
