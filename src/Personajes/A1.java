package Personajes;
 
 

 
import Graficos.Alien1Grafico;
 
import Principal.Celda;
 
public class A1 extends Alien{


	public A1(Celda pos ) {
		super(pos);
		 this.moneda=25;
		 this.punto=15;
 		this.vida = 100;
		this.fuerza = (float) 0.9;
		this.grafico = new Alien1Grafico(pos.getFila(), pos.getColumna());		
		
	}
	
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
	
	public int getVida() {
		return vida;
	}
	
	public int getPuntos () {
		return punto;
	}
	

	
}