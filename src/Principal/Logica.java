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
		puntos=0;
		
		aliensMapa=new LinkedList();
		soldadosMapa= new LinkedList();
		a_eliminarObstaculo= new LinkedList();
		a_eliminarBala= new LinkedList();
		balasSoldado = new LinkedList();
		balasAlien = new LinkedList();
		
	    columnas = ((width - 80 ) / tamanioCelda)+2;
	    filas = ((height - 40) / tamanioCelda)+1;
	    
	    mapaCombate = new Mapa(filas,columnas,p);
	    insertarObjetos();
	}
	
	public void insertarObjetos() {
		mapaCombate.insertarObjetos();
		activarMenu();
	}
	
	public void activarMenu() {
	   inicioJuego();
	}
	
	public void inicioJuego () {
		insertarEnemigos();
		t2 = new Timer (1000,new ActionListener (){
			public void actionPerformed(ActionEvent e){
				inicioMovimientoAliens();
				inicioAtaqueSoldados();
				inicioAtaqueAlien();
				limpiarMuertos();
			}
		});
		t2.start();
	}
	
	public void limpiarMuertos (){
		if ( a_eliminarObstaculo != null){
			while (a_eliminarObstaculo.size() > 0){
				Obstaculo o = a_eliminarObstaculo.removeFirst();
				aliensMapa.remove(o);
				soldadosMapa.remove(o);
				mapaCombate.getLista().remove(o);
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
		Celda c = p.getCelda();	
		Celda siguiente = mapaCombate.siguienteCeldaIzq(c);
		if (siguiente != null) {
			Obstaculo o = siguiente.getElemento();
			if (o == null ){
				c = siguiente;
				p.setCelda(c.getFila(), c.getColumna());
				c.setElemento(p);
				p.actualizarGrafico(0);
			}	
		}
	}
	
	public void inicioAtaqueAlien (){
		for (Personaje p : aliensMapa){
			ataqueAlien(p);
		}
	}
	//Ver tema de buscar a eliminar
	public void ataqueAlien (Personaje p){
		Celda c = p.getCelda();	
		Celda siguiente = mapaCombate.siguienteCeldaIzq(c);
		if (siguiente != null ){
			Obstaculo o = siguiente.getElemento();
			if (o != null){
				if (o.getVida() > 0){
					VisitorAlien v = new VisitorAlien();
					v.setAlien(p);
					o.accept(v);
				}
				else{
					o.actualizarGrafico(2);
					a_eliminarObstaculo.addLast(o);
					mapaCombate.eliminar(o);
				}
			}
		}
	}
 
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
					VisitorSoldado v = new VisitorSoldado();
					v.setSoldado(p);
					o.accept(v);
				}
				else{
					//eliminar obstaculo del
					o.actualizarGrafico(2); 
					a_eliminarObstaculo.addLast(o);
					mapaCombate.eliminar(o);
				}
			}
		}
	}
	
	public void moverDisparoSoldado(Bala p){
		Celda c = p.getCelda();	
		Celda siguiente = mapaCombate.siguienteCeldaDer(c);
		if (siguiente != null) {
			Obstaculo o = siguiente.getElemento();
			if (o == null ) {
				c = siguiente;
				p.setCelda(c.getFila(), c.getColumna());
				c.setElemento(p);
				p.actualizarGrafico(0);
			}
		}
		else {
				mapaCombate.eliminar(p);
				a_eliminarBala.addLast(p);
			 }
	}
	 
	public void moverDisparo() {
		for (Bala p :balasSoldado){				
			moverDisparoSoldado(p);	
		}
	}
	
	public void balaDestruirSoldado(Bala b) {
		Celda c = b.getCelda();	
		Celda siguiente = mapaCombate.siguienteCeldaDer(c);
		if (siguiente != null ){
			Obstaculo o = siguiente.getElemento();
			if ( o != null) {
				if ( o.getVida() > 0){ 
					VisitorBalaSoldado v = new VisitorBalaSoldado();
					v.setBala(b);
					if (!o.dejoPasar(v)){ //si el obstaculo que hay en frente de la bala no lo deja pasar, entonces le sacamos vida al obstaculo y eliminamos la bala
						o.accept(v);
						mapaCombate.eliminar(b);
						a_eliminarBala.addLast(b);
					}
				}
				else{	//eliminamos el grafico del obstaculo del panel
						o.actualizarGrafico(2); 
						mapaCombate.eliminar(o);
						a_eliminarObstaculo.addLast(b); //lo agregamos a la lista de eliminados de obstaculos
						//eliminamos el grafico de la bala
						mapaCombate.eliminar(b);
						a_eliminarBala.addLast(b); //lo agregamos a la lista de eliminamos de balas
					}
			}
		}
	}
		
	public void destruirSoldado() {
		for (Bala p : balasSoldado) {
			balaDestruirSoldado(p);
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
	
	public void iniciarDisparoSoldado() {
		t3 = new Timer (1000,new ActionListener (){
			public void actionPerformed(ActionEvent e){
				moverDisparo();
				destruirSoldado();
				limpiarBalas();
			}
		});
		t3.start();
	}
	
	public void crearBalasSoldados(Personaje s) {
		factoryBala = new BalaSoldadoFactory(panelMapa);
		Celda celdaDisparo = mapaCombate.siguienteCeldaDer(s.getCelda());
		balasSoldado.addLast(factoryBala.crearBalas(celdaDisparo, s));
	}
	
	public void crearS1(int x, int y) {
		Celda c = mapaCombate.getCelda(x, y);
		factory = new S1factory(panelMapa);
		soldadosMapa.addLast(factory.createPersonaje(c));
		VisitorSoldado v = new VisitorSoldado ();
		v.setSoldado(soldadosMapa.getLast());
	}
		
	public void crearS2(int x, int y) {
		Celda c = mapaCombate.getCelda(x, y);	
		factory = new S2factory(panelMapa);
		soldadosMapa.addLast(factory.createPersonaje(c));	
		VisitorSoldado v = new VisitorSoldado ();
		v.setSoldado(soldadosMapa.getLast());
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
		VisitorSoldado v = new VisitorSoldado ();
		v.setSoldado(soldadosMapa.getLast());
		crearBalasSoldados(soldadosMapa.getLast());
		iniciarDisparoSoldado();	
	}
	
	public void verificarPosicion(int x, int y) {
		Celda c= mapaCombate.getCelda(x, y);
		
		for (Personaje p: soldadosMapa) {
			if (p.getCelda().equals(c)) {
				mapaCombate.eliminar(p);
				soldadosMapa.remove(p);
			}
		}
	  
	}
}
