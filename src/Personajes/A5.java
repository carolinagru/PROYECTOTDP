package Personajes;
 
import javax.swing.ImageIcon;

import Graficos.Alien3Grafico;
import Graficos.Alien5Grafico;
import Principal.Celda;
import Visitor.Visitor;

public class A5 extends Alien{
	
	protected static int moneda=25;
	protected static int punto=15;

	public A5( Celda pos ) {		
		super(pos);
		grafico = new Alien5Grafico(pos.getFila(), pos.getColumna());
		
	}

	
	
	
}
