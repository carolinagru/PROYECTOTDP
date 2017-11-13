
package Personajes;

 
import Graficos.Soldado1Grafico;
import Principal.Celda;
 

public class S3 extends Soldado {
	
	protected static int precio = 25;

	
	public S3(Celda pos) {
		super(pos);
		this.vida = 100;
		this.fuerza = (float) 0.5;
		grafico = new Soldado1Grafico(pos.getFila(), pos.getColumna());
	}


	public void setVida(float f) {
		vida-=f;
	}
	
	public int getVida() {
		return vida;
	}

	


}


