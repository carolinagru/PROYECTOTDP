
package Personajes;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

 
import Graficos.Soldado1Grafico;
import Graficos.Soldado2Grafico;
import Principal.Celda;
import Visitor.Visitor;

public class S2 extends Soldado{
	
	protected static int precio = 25;
	
	
	public S2(Celda pos) {
		super(pos);  
		this.vida = 100;
		this.fuerza = (float) 0.5;
		grafico = new Soldado2Grafico(pos.getFila(), pos.getColumna());
	}

	public void setVida(float f) {
		vida-=f;
	}
	
	public int getVida() {
		return vida;
	}

}
