package Personajes;
 
 

 
import Graficos.Alien1Grafico;
 
import Principal.Celda;
 
public class A1 extends Alien{


	public A1(Celda pos ) {
		super(pos);
<<<<<<< HEAD
		 this.moneda=25;
		 this.punto=15;
 		this.vida = 100;
=======
		this.moneda=25;
		this.punto=15;
		this.vida = 100;
>>>>>>> 32787b521ced229c87f564e56dd02640b5a3bc1f
		this.fuerza = (float) 0.9;
		this.grafico = new Alien1Grafico(pos.getFila(), pos.getColumna());		
		
	}
<<<<<<< HEAD
	
	public A1 () {
		this.moneda=25;
		 this.punto=15;
		this.vida = 100;
		this.fuerza = (float) 0.9;
		//this.grafico = new Alien1Grafico(pos.getFila(), pos.getColumna());	
		
	}
	
	
	
	
	public void setVida(float f) {
		vida-=f;
	}
=======
>>>>>>> 32787b521ced229c87f564e56dd02640b5a3bc1f
	
	

	
}