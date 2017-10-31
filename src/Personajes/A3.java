package Personajes;
 
import javax.swing.ImageIcon;

import Graficos.Alien3Grafico;
import Principal.Celda;
import Visitor.Visitor;

public class A3 extends Alien{
	
	protected static int moneda=25;
	protected static int punto=15;

	public A3( Celda pos ) {		
		super(pos);
		grafico = new Alien3Grafico(pos.getFila(), pos.getColumna());
		
	}

	
	
	
}
