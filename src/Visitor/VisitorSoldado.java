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

public class VisitorSoldado implements Visitor {
	protected Personaje mySoldado;
	
public void setSoldado (Personaje a){
	mySoldado = a;
}
public void visit(Alien a) {
	System.out.println("Vida alien"+mySoldado.getVida()+" Vida soldado:"+a.getVida());
	a.setVida(mySoldado.getFuerza()*a.getVida());
	 
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

}