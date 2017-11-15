
package Personajes;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Graficos.Soldado1Grafico;
import Principal.Celda;
import Visitor.Visitor;

public class S1 extends Soldado {
	
	public S1(Celda pos) {
		super(pos);
		this.precio = 25;
		this.vida = 100;
		this.fuerza = (float) 0.5;
		this.grafico = new Soldado1Grafico(pos.getFila(), pos.getColumna());
	}

	public void setVida(float f) {
		vida-=f;
	}
	
	public int getVida() {
		return vida;
	}
	
	public int getPrecio () {
		return precio;
	}

 
	
	


}
