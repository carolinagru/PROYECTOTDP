
package Personajes;

 
 
 
import Graficos.Soldado5Grafico;
import Principal.Celda;
 

public class S5 extends Soldado {
	
	

	
	public S5(Celda pos) {
		super(pos);
		this.precio = 25;
		this.vida = 100;
		this.fuerza = (float) 0.0;
		grafico = new Soldado5Grafico(pos.getFila(), pos.getColumna());
	}

}
