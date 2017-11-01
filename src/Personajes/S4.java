
package Personajes;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Graficos.Soldado1Grafico;
import Principal.Celda;
import Visitor.Visitor;

public class S4 extends Soldado {
	
	protected static int precio = 25;

	
	public S4(Celda pos) {
		super(pos);
		grafico = new Soldado1Grafico(pos.getFila(), pos.getColumna());
	}

}

