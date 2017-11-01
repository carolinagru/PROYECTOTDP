package Objetos;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Graficos.PersonajeGrafico;
import Principal.Celda;
import Visitor.Visitor;

public abstract class Obstaculo {

	protected PersonajeGrafico grafico;
	protected Celda pos;
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
	
	public void setCelda(int x, int y) {
		pos.set(x, y);
		grafico.setPoint(x,y);
	}
	
	public void setVida(int i) {
		vida-=i;
	}
	
	public int getVida() {
		return vida;
	}
	public abstract boolean accept(Visitor v);
}