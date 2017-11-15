
package Personajes;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
 
import Graficos.Soldado4Grafico;
import Principal.Celda;
import Visitor.Visitor;

public class S4 extends Soldado {

	public S4(Celda pos) {
		super(pos);
		this.vida = 100;
		this.precio = 25;
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

