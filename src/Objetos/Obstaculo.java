package Objetos;

 
import javax.swing.JLabel;
import Graficos.PersonajeGrafico;
import Principal.Celda;

import Visitor.Visitor;

public abstract class Obstaculo {

	protected PersonajeGrafico grafico;
	protected Celda pos;
	protected Visitor v;
	
	protected static int vida=100;
	
	public JLabel getGrafico() {	
		return grafico.getGrafico();
	}
	
	public Celda getCelda() {
		return pos;
	}
	
	public void actualizarGrafico() {
	  grafico.actualizarGrafico();
	}
	
	public void actualizarGrafico(int n) {
		  grafico.actualizarGrafico(n);
		}
	
	
	public void setCelda(int x, int y) {
		pos.set(x, y);
		grafico.setPoint(x,y);
	}

	
	public void setVida(float f) {
		vida-=f;
	}
	public int getVida() {
		return vida;
	}
	public Visitor getVisitor() {
		return v;
	}
	public abstract void accept(Visitor v);
	
	
	
}