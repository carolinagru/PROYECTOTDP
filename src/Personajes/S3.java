
package Personajes;

 
 
import Graficos.Soldado3Grafico;
import Principal.Celda;
 

public class S3 extends Soldado {
	
	protected static int precio = 25;

	
	public S3(Celda pos) {
		super(pos);
		this.vida = 100;
		this.fuerza = (float) 0.3;
		grafico = new Soldado3Grafico(pos.getFila(), pos.getColumna());
	}


	public void setVida(float f) {
		vida-=f;
	}
	
	public int getVida() {
		return vida;
	}

	


}


