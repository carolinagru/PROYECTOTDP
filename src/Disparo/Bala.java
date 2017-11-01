package Disparo;

import Objetos.Obstaculo;
import Principal.Celda;
import Visitor.ElementoDisparo;
import Visitor.Visitor;
import Visitor.VisitorDisparo;

public class Bala extends Obstaculo{
	protected VisitorDisparo v;
	protected ElementoDisparo e;
	protected int fuerzaDeImpacto;
	
	public Bala (Celda pos, int f ){
		this.pos = pos;
		fuerzaDeImpacto = f;
				
	}
	
	public int getFuerzaImpacto (){
		return fuerzaDeImpacto;
	}
	
	

}
