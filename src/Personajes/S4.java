
package Personajes;

 
 
import Graficos.Soldado4Grafico;
import Principal.Celda;
 

public class S4 extends Soldado {
	
	protected static int precio = 25;

	
	public S4(Celda pos) {
		super(pos);
		 
		this.vida = 100;
		this.fuerza = (float) 0.2;
		grafico = new Soldado4Grafico(pos.getFila(), pos.getColumna());
	}

	public void setVida(float f) {
		vida-=f;
	}
	
	public int getVida() {
		return vida;
	}

	 
	
	

}

