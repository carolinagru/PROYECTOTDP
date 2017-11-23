package Personajes;


import Principal.Celda;
import Disparo.Bala;
import Estate.Estado;
import Objetos.Obstaculo;
import PowerUps.MagiaTemporal;
import PowerUps.ObjetoPrecioso;

public abstract class Personaje extends Obstaculo{
	
	protected float fuerza;
	protected Estado myEstado;
	protected MagiaTemporal magiaT;
	protected ObjetoPrecioso bomba;
	protected int cantCeldas;
	protected int distanciaAtaque;
	
	public Personaje ( Celda pos){
		this.pos = pos;
		grafico = null;
		magiaT = null;
		bomba = null;
	}
	
	public Personaje () {
		this.pos = null;
		grafico = null;
		magiaT = null;
		bomba = null;
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
	
	public ObjetoPrecioso getBomba() {
		return bomba;
	}
	
	public void setBomba(ObjetoPrecioso b) {
		bomba = b;
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
	
	public void setDistanciaAtaque(int i ) {
		distanciaAtaque = i;
	}
	
	public int getDistanciaAtaque () {
		return distanciaAtaque;
	}
	
	 
	 
	 

	 
	
}
