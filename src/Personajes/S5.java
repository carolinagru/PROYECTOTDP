
package Personajes;

 
 
 
import Graficos.Soldado5Grafico;
import Principal.Celda;
 

public class S5 extends Soldado {
	
	protected static int precio = 25;

	
	public S5(Celda pos) {
		super(pos);
		 
		this.vida = 100;
		this.fuerza = (float) 0.0;
		grafico = new Soldado5Grafico(pos.getFila(), pos.getColumna());
	}

	public void setVida(float f) {
		vida-=f;
	}
	
	public int getVida() {
		return vida;
	}

	 
	
	


}
