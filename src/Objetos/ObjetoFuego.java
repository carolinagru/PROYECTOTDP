package Objetos;

import Graficos.ObjetoFuegoGrafico;
import Principal.Celda;
import Visitor.ElementoFuego;

public class ObjetoFuego extends ObjetoTemporal{

	public ObjetoFuego(Celda c) {
		super(c);
		grafico = new ObjetoFuegoGrafico(c.getFila(), c.getColumna());
		e = new ElementoFuego();
	}
	
	
	
}
