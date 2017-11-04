package Personajes;
 
import javax.swing.ImageIcon;

import Graficos.Alien1Grafico;
import Graficos.Alien3Grafico;
import Principal.Celda;
import Visitor.Visitor;
import Visitor.VisitorAlien;

public class A1 extends Alien{
	
	protected static int moneda=25;
	protected static int punto=15;
	 

	public A1(Celda pos ) {
		super(pos);
		this.vida = 100;
		this.fuerza = (float) 0.9;
		this.grafico = new Alien1Grafico(pos.getFila(), pos.getColumna());		
		
	}
	public void setVida(float f) {
		vida-=f;
	}
	
	public int getVida() {
		return vida;
	}
	
}