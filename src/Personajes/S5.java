
package Personajes;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Graficos.Soldado1Grafico;
import Graficos.Soldado5Grafico;
import Principal.Celda;
import Visitor.Visitor;

public class S5 extends Soldado {
	
	
	public S5(Celda pos) {
		super(pos);
		this.vida = 100;
		this.precio = 25;
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
