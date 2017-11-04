package Disparo;

import Objetos.Obstaculo;
import Principal.Celda;
import Visitor.VisitorDisparo;

public abstract class Bala extends Obstaculo{
	protected VisitorDisparo v;
	protected float fuerzaDeImpacto;
	
	public Bala (Celda pos, float f ){
		this.pos = pos;
		fuerzaDeImpacto = f;
				
	}
	
	public float getFuerzaImpacto (){
		return fuerzaDeImpacto;
	}

 

}
