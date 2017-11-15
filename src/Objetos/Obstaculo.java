package Objetos;

 
import javax.swing.JLabel;
import Graficos.ObstaculoGrafico;
import Principal.Celda;

import Visitor.Visitor;

public abstract class Obstaculo {

	protected ObstaculoGrafico grafico;
	protected Celda pos;
	protected int vida;
	protected int puntos ;

	
	public JLabel getGrafico(int n) {	
		return grafico.getGrafico(n);
	}
	
	public Celda getCelda() {
		return pos;
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
	
	public int getPuntos () {
		return puntos;
	}

	public abstract void accept(Visitor v);
	
	public abstract boolean dejoPasar(Visitor v);
	
	public abstract boolean puedeAtacar(Visitor v);
	
}