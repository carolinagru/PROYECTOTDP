package Principal;


import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Personajes.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import Disparo.Bala;
import Disparo.DisparoSoldado;
import Factory.A1factory;
import Factory.PersonajesFactoryMethod;
import Factory.S1factory;
import Factory.S2factory;
import Factory.S3factory;
import Factory.S4factory;
import Factory.S5factory;

import Objetos.Obstaculo;
import Visitor.Visitor;
import Visitor.VisitorAlien;
import Visitor.VisitorDisparo;
import Visitor.VisitorSoldado;
import Personajes.*;


public class Logica {
	
	protected int monedas;
	protected int puntos;
	protected Timer t1,t2,t3;
	protected LinkedList<Obstaculo> a_eliminar;
	protected LinkedList<Personaje> aliensMapa;
	protected LinkedList<Personaje> soldadosMapa;
	protected JPanel panelMapa;
	protected Mapa mapaCombate;
	private static int tamanioCelda = 80;
	protected PersonajesFactoryMethod factory;
	protected static int height = 500;
	protected static int width= 1000;
	protected JLabel l;
    protected int columnas;

	public Logica(JPanel p){
		
		panelMapa=p;
		puntos=0;
		
		aliensMapa=new LinkedList();
		soldadosMapa= new LinkedList();
		a_eliminar= new LinkedList();
	    columnas = ((width - 80 ) / tamanioCelda)+2;
	    int filas = ((height - 40) / tamanioCelda)+1;
	    
	    System.out.println("columnas de constructor de logica "+columnas+" filas de constructor de logica "+filas);

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
		if ( a_eliminar != null){
			while (a_eliminar.size() > 0){
				Obstaculo o = a_eliminar.removeFirst();
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
				c.setElemento(null);
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
			if ( o != null){
				if ( o.getVida() > 0){
					VisitorAlien v = new VisitorAlien();
					v.setAlien(p);
					o.accept(v);
				}
				else{
					o.actualizarGrafico(2);
					a_eliminar.addLast(o);
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
					mapaCombate.eliminar(o);
					a_eliminar.addLast(o);
				}
			}
		}
	}
	
	public boolean moverDisparo(DisparoSoldado p ){
		boolean toReturn = true;  
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
			else {	
				toReturn = false;
				//Hay que eliminar el objeto grafico
				if ( o.getVida()>0){
					VisitorDisparo v = new VisitorDisparo();
					v.setBala(p);
					o.accept(v);
				}
			}
		}
		return toReturn;
	}
	 
	
	public void iniciarDisparo(DisparoSoldado p ) {
			t3 = new Timer (200, new ActionListener (){
				public void actionPerformed(ActionEvent e){
					if (!moverDisparo(p))
						t3.stop();
					else
						moverDisparo(p);
				}     
			});
		  t3.start();	
		}
		
	
	public void crearS1(int x, int y) {
		Celda c = mapaCombate.getCelda(x, y);
		factory = new S1factory(panelMapa);
		soldadosMapa.addLast(factory.createPersonaje(c));
		VisitorSoldado v = new VisitorSoldado ();
		v.setSoldado(soldadosMapa.getLast());
		Celda celdaDisparo = mapaCombate.siguienteCeldaDer(c);
		DisparoSoldado disp = crearDisparo(celdaDisparo,soldadosMapa.getLast());
		iniciarDisparo(disp);
	}
	
	public DisparoSoldado crearDisparo (Celda c, Personaje p){
		DisparoSoldado disparo = new DisparoSoldado(c,p.getFuerza());
		c.setElemento(disparo);
		l = disparo.getGrafico(0);
		panelMapa.add(l);
		l.repaint();
	  return disparo;
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
	}
	
	public void crearS4(int x, int y) {
		Celda c = mapaCombate.getCelda(x, y);
		factory = new S4factory(panelMapa);
		soldadosMapa.addLast(factory.createPersonaje(c));
	}
	
	public void crearS5(int x, int y) {
		Celda c = mapaCombate.getCelda(x, y);
		factory = new S5factory(panelMapa);
		soldadosMapa.addLast(factory.createPersonaje(c));
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
