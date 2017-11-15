package Personajes;
 
 

 
import Graficos.Alien2Grafico;
 
import Principal.Celda;
 

public class A2 extends Alien{
	
	protected static int moneda=25;
	protected static int punto=15;

	public A2( Celda pos ) {		
		super(pos);
 
		this.vida = 100;
		grafico = new Alien2Grafico(pos.getFila(), pos.getColumna());
		
	}
	public void setVida(float f) {
		vida-=f;
	}
	
	public int getVida() {
		return vida;
	}

	 
	
	
	
}
