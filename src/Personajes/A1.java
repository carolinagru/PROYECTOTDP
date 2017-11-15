package Personajes;
 
import javax.swing.ImageIcon;

import Graficos.Alien1Grafico;
import Graficos.Alien3Grafico;
import Principal.Celda;
import Visitor.Visitor;
import Visitor.VisitorAlien;

public class A1 extends Alien{


	public A1(Celda pos ) {
		super(pos);
		 this.moneda=25;
		 this.punto=15;
		 
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
	
	public int getPuntos () {
		return punto;
	}
	
}