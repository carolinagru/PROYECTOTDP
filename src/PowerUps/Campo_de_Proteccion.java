package PowerUps;

import Graficos.Campo_Proteccion_Grafico;
import Principal.Celda;
import Visitor.Visitor;

public class Campo_de_Proteccion  extends MagiaTemporal{

	 
	public Campo_de_Proteccion (  ) {
		super( );
		this.grafico = new Campo_Proteccion_Grafico();	
	}
	
	public void accept(Visitor v) {
		 
		
	}

	 
	public boolean dejoPasar(Visitor v) {
		 
		return true;
	}

 
	public boolean puedoAtacar(Visitor v) {
		 return v.Atacar(this);
	}
	
	
	
	 

}
