package Personajes;
 
import javax.swing.ImageIcon;

import Graficos.Alien3Grafico;
import Graficos.Alien5Grafico;
import Principal.Celda;
import Visitor.Visitor;

public class A6 extends Alien{
	
	protected static int moneda=25;
	protected static int punto=15;

	public A6( Celda pos ) {		
		super(pos);
		grafico = new Alien5Grafico(pos.getFila(), pos.getColumna());
		
	}

	
}
