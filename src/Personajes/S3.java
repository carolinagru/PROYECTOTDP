
package Personajes;

 
import Graficos.Soldado1Grafico;
import Principal.Celda;
 

public class S3 extends Soldado {
	
	protected static int precio = 25;

	
	public S3(Celda pos) {
		super(pos);
		grafico = new Soldado1Grafico(pos.getFila(), pos.getColumna());
	}


	 
	


}


