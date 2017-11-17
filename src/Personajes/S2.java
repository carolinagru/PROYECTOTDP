
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
	
	
	
	public S2(Celda pos) {
		super(pos); 
		this.precio = 25;
		this.vida = 100;
		this.fuerza = (float) 0.5;
		grafico = new Soldado2Grafico(pos.getFila(), pos.getColumna());
	}

}
