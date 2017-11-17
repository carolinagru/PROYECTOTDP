package Personajes;


import Principal.Celda;
import Estate.Estado;
import Objetos.Obstaculo;
import PowerUps.MagiaTemporal;

public abstract class Personaje extends Obstaculo{
	
	protected float fuerza;
	protected Estado myEstado;
	protected MagiaTemporal magiaT;
	protected int cantCeldas;
	protected int distanciaAtaque;
	
	public Personaje ( Celda pos){
		this.pos = pos;
		grafico = null;
		magiaT = null;
	}
	
	public Personaje () {
		this.pos = null;
		grafico = null;
		magiaT = null;
	}
	
	public void setPosicion (Celda pos) {
		this.pos = pos;
	}
	
	public void setMagiaTemporal (MagiaTemporal m) {
		magiaT = m;
	}
	
	public MagiaTemporal getMagiaTemporal () {
		return magiaT;
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
