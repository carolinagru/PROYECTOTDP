
package Personajes;

 
 
 
import Disparo.Bala;
import Graficos.Soldado5Grafico;
import Principal.Celda;
 

public class S5 extends Soldado {
	
		
	public S5(Celda pos) {
		super(pos);
		this.precio = 60;
		this.vida = 100;
		this.fuerza = (float) 0.6;
		grafico = new Soldado5Grafico(pos.getFila(), pos.getColumna());
	}

	
}
