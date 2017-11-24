package PowerUps;

import Graficos.BombaGrafico;
import Principal.Celda;
import Visitor.Visitor;

public class Bomba extends ObjetoPrecioso{
	
	public Bomba() {
		super();
		grafico = new BombaGrafico();
	}

	@Override
	public boolean puedoAtacar(Visitor v) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
