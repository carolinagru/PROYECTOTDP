package Visitor;


import Objetos.ObjetoVida;
import Personajes.Alien;
import Personajes.Soldado;

public class VisitorSoldado implements Visitor {

	public boolean visit(Alien a) {
		return false;
	}

	public boolean visit(Soldado a) {
		return false;
	}

	public boolean visit(ObjetoVida a) {
		return false;
	}

}
