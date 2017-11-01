package Personajes;


import Principal.Celda;
import Visitor.*;

import javax.swing.JLabel;

import Graficos.PersonajeGrafico;
import Objetos.Obstaculo;

public abstract class Personaje extends Obstaculo{
	
	public float fuerza;
	protected int cantCeldas;
	protected int distanciaAtaque;
	protected Visitor v;

	
	public Personaje ( Celda pos){
		this.pos = pos;
		grafico = null;
		
	}
	
	public float getFuerza (){
		return fuerza;
	}
	public Visitor getVisitor() {
		return v;
	}
		
	public abstract void atacar();
}
