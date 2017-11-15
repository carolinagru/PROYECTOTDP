package Personajes;


import Principal.Celda;
import Estate.Estado;
import Objetos.Obstaculo;

public abstract class Personaje extends Obstaculo{
	
	protected float fuerza;
	protected Estado myEstado;
	protected int cantCeldas;
	protected int distanciaAtaque;
	
	public Personaje ( Celda pos){
		this.pos = pos;
		grafico = null;
	}
	
	public void setFuerza (int f ) {
		fuerza = f;
	}
	public float getFuerza (){
		return fuerza;
	}
	
	public void setVida(float f) {
		vida -=f;
	}
	
	public int getVida() {
		return vida;
	}
	
	 
	 
	 
	 

	 
	
}
