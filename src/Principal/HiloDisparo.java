package Principal;

import Objetos.Obstaculo;

public class HiloDisparo extends Thread  {
	protected int x;
	protected int y;
	protected Celda c;
	protected Obstaculo p;
	protected Mapa map;
	public HiloDisparo (Celda c, Mapa m){
		super();
		this.c = c;
		p = c.elemento;
		x = c.getColumna();
		y = c.getFila();
		map = m;
	}
	public void run (){
		Celda cel = map.getCelda(x++,y );
		for ( int i = x; cel != null ; i++ ){
			
			
		}
	}
	

}
