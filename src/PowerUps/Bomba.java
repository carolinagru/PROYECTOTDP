package PowerUps;

import Graficos.BombaGrafico;
import Visitor.Visitor;

public class Bomba extends ObjetoPrecioso{
	
	public Bomba() {
		super();
		grafico = new BombaGrafico();
	}

<<<<<<< HEAD
	@Override
	public boolean puedoAtacar(Visitor v) {
		// TODO Auto-generated method stub
		return false;
	}
=======
	public void accept(Visitor v) {
		System.out.println("Etre aacep Bomba");
	  v.visit(this);
	}
		
	
>>>>>>> 9f2c3c5cfd7e54c0fe39e2b489671a8bc99aef7b
	
	

}
