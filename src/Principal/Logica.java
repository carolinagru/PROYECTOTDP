package Principal;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Personajes.*;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import Disparo.Bala;
import Disparo.BalaSoldado;
import Factory.A1factory;
import Factory.BalaSoldadoFactory;
import Factory.BalasFactoryMethod;
import Factory.PersonajesFactoryMethod;
import Factory.S1factory;
import Factory.S2factory;
import Factory.S3factory;
import Factory.S4factory;
import Factory.S5factory;

import Objetos.Obstaculo;
import Visitor.VisitorAlien;
import Visitor.VisitorBalaSoldado;
import Visitor.VisitorSoldado;


public class Logica {
	
	protected int monedas;
	protected int puntos;
	protected Timer t1,t2,t3;
	protected LinkedList<Obstaculo> a_eliminarObstaculo;
	protected LinkedList<Obstaculo> a_eliminarBala;
	protected LinkedList<Personaje> aliensMapa;
	protected LinkedList<Personaje> soldadosMapa;
	protected LinkedList<Bala> balasSoldado;
	protected LinkedList<Bala> balasAlien;
	protected JPanel panelMapa;
	protected Mapa mapaCombate;
	private static int tamanioCelda = 80;
	protected PersonajesFactoryMethod factory;
	protected BalasFactoryMethod factoryBala;
	protected static int height = 500;
	protected static int width= 1000;
	protected JLabel l;
    protected int columnas;
    protected int filas;

	public Logica(JPanel p){
		panelMapa=p;
		puntos=100;
		monedas = 100;
		
		aliensMapa=new LinkedList();
		soldadosMapa= new LinkedList();
		a_eliminarObstaculo= new LinkedList();
		a_eliminarBala= new LinkedList();
		balasSoldado = new LinkedList();
		balasAlien = new LinkedList();
		
	    columnas = ((width - 80 ) / tamanioCelda)+2;
	    filas = ((height - 40) / tamanioCelda)+1;
	    
	    mapaCombate = new Mapa(filas,columnas,p);
	}
	
	public void insertarObjetos() {
		mapaCombate.insertarObjetos();
		
	}
	
	public void limpiarMuertos (){
		if ( a_eliminarObstaculo != null){
			while (a_eliminarObstaculo.size() > 0){
				Obstaculo o = a_eliminarObstaculo.removeFirst();
				aliensMapa.remove(o);
				soldadosMapa.remove(o);
				mapaCombate.getLista().remove(o);
				//balasSoldado.remove(o);
				//mapaCombate.eliminar(o);
			}
		}
	}
			
	public void insertarEnemigos() {
	   	while(aliensMapa.size() < 4){
	   		aliensMapa.addLast(mapaCombate.insertarEnemigo(factory));	 
	   	}
	}
	
	public void inicioMovimientoAliens() {
		for (Personaje p :aliensMapa){				
			moverAlien(p);	
		}
	}
	 	
	public void moverAlien(Personaje p) {	
		Celda siguiente = mapaCombate.siguienteCeldaIzq(p.getCelda());
		p.getCelda().setElemento(null);
		
		if (siguiente != null) {
			Obstaculo o = siguiente.getElemento();
			if (o == null ){
				mapaCombate.setCeldaMapa(p.getCelda().getFila(),p.getCelda().getColumna(), null);
				siguiente.setElemento(p);
				p.setCelda(siguiente.getFila(), siguiente.getColumna());
				p.actualizarGrafico(0);				
			}	
			
		}
		else
			System.out.println("Entre manao");
	}
	
	public void inicioAtaqueAlien (){
		for (Personaje p : aliensMapa){
			ataqueAlien(p);
		}
	}
	

	public void ataqueAlien (Personaje p){
		Celda c = p.getCelda();	
		Celda siguiente = mapaCombate.siguienteCeldaIzq(c);
		if (siguiente != null ){
			Obstaculo o = siguiente.getElemento();
			if (o != null){
				if (o.getVida() > 0){
					p.actualizarGrafico(1);
					VisitorAlien v = new VisitorAlien();
					v.setAlien(p);
					o.accept(v);
				}
				else{
					o.actualizarGrafico(2);
					a_eliminarObstaculo.addLast(o);
					limpiarMuertos();
					siguiente.setElemento(null);			
				}
			}
		}
	}
	
	/**Ataque de soldado cuerpo a cuerpo **/
	public void inicioAtaqueSoldados () {
		
		for (Personaje p : soldadosMapa){
			ataqueSoldado(p);
		}
	}
	
	
	public void ataqueSoldado (Personaje p ) {
		Celda c = p.getCelda();	
		Celda siguiente = mapaCombate.siguienteCeldaDer(c);
		if (siguiente != null ){
			Obstaculo o = siguiente.getElemento();
			if ( o != null){
				
				if ( o.getVida() > 0){
					p.actualizarGrafico(1);
					VisitorSoldado v = new VisitorSoldado();
					v.setSoldado(p);
					o.accept(v);
				}
				else{
					puntos += o.getPuntos();
					o.actualizarGrafico(2); 
					a_eliminarObstaculo.addLast(o);
					siguiente.setElemento(null);
					limpiarMuertos();
					 
				}
			}
		}
	}
	
 
	public void moverDisparoSoldado(Bala p){
		System.out.println("Sigo moviendo disparo ------------");
		
		Celda siguiente = mapaCombate.siguienteCeldaDer(p.getCelda());
		p.getCelda().setElemento(null);
		mapaCombate.setCeldaMapa(p.getCelda().getFila(),p.getCelda().getColumna(), null);
		if (siguiente != null) {
			Obstaculo o = siguiente.getElemento();
			if (o == null ){
				mapaCombate.setCeldaMapa(p.getCelda().getFila(),p.getCelda().getColumna(), null);
				siguiente.setElemento(p);
				p.setCelda(siguiente.getFila(), siguiente.getColumna());
				p.actualizarGrafico(1);
				
				
			}	
		}
		else {
			balasSoldado.removeLast();
			mapaCombate.eliminar(p);
		}
	}
	
	 
	public void moverDisparo() {
		
		for (Bala p :balasSoldado){	
			System.out.println("Entre a mover disparo");
			moverDisparoSoldado(p);	
		}
	}
	 
 
	public void balaSoldado(Bala b) {
		Celda c = b.getCelda();	
		Celda siguiente = mapaCombate.siguienteCeldaDer(c);
		
		if (siguiente != null ){
			Obstaculo o = siguiente.getElemento();
			if ( o != null) {
				if ( o.getVida() > 0){ 
					VisitorBalaSoldado v = new VisitorBalaSoldado();
					v.setBala(b);
					if (!o.dejoPasar(v)){
						o.accept(v);
						//a_eliminarBala.addLast(b);
						
					}
					else {
						b.setCelda(siguiente.getFila(), siguiente.getColumna());
						}						 
				}
				else{	//eliminamos el grafico del obstaculo del panel
						o.actualizarGrafico(2); 
						//mapaCombate.eliminar(o);
						a_eliminarObstaculo.addLast(b); //lo agregamos a la lista de eliminados de obstaculos
						//eliminamos el grafico de la bala
						//mapaCombate.eliminar(b);
						//a_eliminarBala.addLast(b); //lo agregamos a la lista de eliminamos de balas
					}
				balasSoldado.remove(b);
				mapaCombate.eliminar(b);
			}
		}
	}
	
 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void accionBalaSoldado() {
		for (Bala p : balasSoldado) {
			balaSoldado(p);
		}
	}
	
	public void limpiarBalas() {
		if ( a_eliminarBala != null){
			while (a_eliminarBala.size() > 0){
				Obstaculo o = a_eliminarBala.removeFirst();
				balasSoldado.remove(o);
			}
		}	
	}
	 
	 /*
	public void iniciarDisparoSoldado() {
		t2 = new Timer (1000,new ActionListener (){
			public void actionPerformed(ActionEvent e){
				moverDisparo();
				accionBalaSoldado();
				limpiarBalas();
			}
		});
		t2.start();
	}
	 
	/**
	public void crearBalasSoldados(Personaje s) {
		factoryBala = new BalaSoldadoFactory(panelMapa);
		Celda celdaDisparo = mapaCombate.siguienteCeldaDer(s.getCelda());
		balasSoldado.addLast(factoryBala.crearBalas(celdaDisparo, s));
	}
	**/
	
 
	public void crearBalasSoldados(Personaje s) {
		Celda celdaDisparo = mapaCombate.siguienteCeldaDer(s.getCelda());
		balasSoldado.addLast(mapaCombate.insertarBalasMapa(factoryBala,celdaDisparo,s));	
	}
 
	
	
	public boolean crearS1(int x, int y) {
		boolean toReturn = false;
		if ( monedas >= 25) {
			toReturn = true;
			Celda c = mapaCombate.getCelda(x, y);
			S1factory sf = new S1factory(panelMapa);
			Soldado s = sf.createPersonaje(c);
			soldadosMapa.addLast(s);
			monedas-=25;
			//crearBalasSoldados(soldadosMapa.getLast());
		}
		return toReturn;
	}
		
	public void crearS2(int x, int y) {
		boolean toReturn = false;
		if (monedas > 25 ) {
			toReturn = true;
			Celda c = mapaCombate.getCelda(x, y);	
			factory = new S2factory(panelMapa);
			soldadosMapa.addLast(factory.createPersonaje(c));	
			VisitorSoldado v = new VisitorSoldado ();
			monedas -=25;
		}
	}
	
	public void crearS3(int x, int y) {
		Celda c = mapaCombate.getCelda(x, y);
		factory = new S3factory(panelMapa);
		soldadosMapa.addLast(factory.createPersonaje(c));
		VisitorSoldado v = new VisitorSoldado ();
		v.setSoldado(soldadosMapa.getLast());
	}
	
	public void crearS4(int x, int y) {
		Celda c = mapaCombate.getCelda(x, y);
		factory = new S4factory(panelMapa);
		soldadosMapa.addLast(factory.createPersonaje(c));
		VisitorSoldado v = new VisitorSoldado ();
		v.setSoldado(soldadosMapa.getLast());
	}
	
	public void crearS5(int x, int y) {
		Celda c = mapaCombate.getCelda(x, y);
		factory = new S5factory(panelMapa);
		soldadosMapa.addLast(factory.createPersonaje(c));
		//VisitorSoldado v = new VisitorSoldado ();
		//v.setSoldado(soldadosMapa.getLast());
		crearBalasSoldados(soldadosMapa.getLast());
		//iniciarDisparoSoldado();	
	}
	

	
	/**Verifica si la posicion corresonde al panel de combate 
	 * 
	 * @param x Fila del elemento a verificar
	 * @param y Columna del elemento a verificar
	 * @return Verdadero en caso de encontrar un Soldado , Falso en caso que haya seleccionado un objeto no correspondiente a un soldado, o un casillero vacio
	 */
	public boolean verificarPosicion(int x, int y) {
		boolean toReturn = false;
		Celda c= mapaCombate.getCelda(x, y);
		if ( c.getElemento() != null) {
			if ( soldadosMapa.size() > 0) {
				Personaje p = soldadosMapa.getFirst();
				int i = 0;
				boolean corte = true;
				while ( p != null && corte ) {
					if (p.getCelda().equals(c)) {
						if ( p.getVida() != 100)
							puntos += p.getVida()*0.5;
						else
							puntos += p.getVida();
						mapaCombate.eliminar(p);
						soldadosMapa.remove(p);
						toReturn = true;
						corte = false;
					}
					else {
						i++;
						if ( i < soldadosMapa.size())
							p = soldadosMapa.get(i);
						else
							corte = false;
					}
				}
			}
		}
			System.out.println("Resultado verificar posicion  : "+toReturn);
			return toReturn;
  }

	public void setPanel(JPanel frame) {
		panelMapa = frame;		
	}
	
	
	
	
	
	
}
