package Personajes;
 
import javax.swing.ImageIcon;

import Graficos.Alien2Grafico;
import Graficos.Alien3Grafico;
import Principal.Celda;
import Visitor.Visitor;

public class A2 extends Alien{
	
	protected static int moneda=25;
	protected static int punto=15;

	public A2( Celda pos ) {		
		super(pos);
		grafico = new Alien2Grafico(pos.getFila(), pos.getColumna());
		
	}
	
	
}
