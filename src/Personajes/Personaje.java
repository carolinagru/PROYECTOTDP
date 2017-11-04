package Personajes;


import Principal.Celda;
import Visitor.*;

import javax.swing.JLabel;

import Graficos.ObstaculoGrafico;
import Objetos.Obstaculo;

public abstract class Personaje extends Obstaculo{
	
	public float fuerza;
	protected int cantCeldas;
	protected int distanciaAtaque;
	 

	public void setVisitor (Visitor v ){
		this.v = v;
	}
	public Personaje ( Celda pos){
		this.pos = pos;
		grafico = null;
		
	}
	
	public float getFuerza (){
		return fuerza;
	}
	
	public void setVida(float f) {
		vida-=f;
	}
	
	public int getVida() {
		return vida;
	}
	 

	 
	
}
