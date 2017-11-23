package PowerUps;

import Objetos.Obstaculo;
import Principal.Celda;
import Visitor.Visitor;



public abstract class ObjetoPrecioso extends Obstaculo {
		
		 
		
		public ObjetoPrecioso () {
			this.pos = null;
			grafico =null;

		}

		 
		public void  setCeldaMagia (Celda c) {
			this.pos = c;
			
		}
		
		public void accept(Visitor v) {			
		}

		 
		public boolean dejoPasar(Visitor v) {
			 
			return false;
		}
		
		 
		


	
}
