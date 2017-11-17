
package Personajes;

 
 
 
import Graficos.Soldado3Grafico;
import Principal.Celda;
 

public class S3 extends Soldado {
	

	
	public S3(Celda pos) {
		super(pos);
		this.precio = 30;
		this.vida = 100;
		this.fuerza = (float) 0.4;
		grafico = new Soldado3Grafico(pos.getFila(), pos.getColumna());
	}



}


