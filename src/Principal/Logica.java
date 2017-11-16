package Principal;


 

import Personajes.*;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import Disparo.Bala;
 
import Estate.Estado;
 
import Estate.estadoCampo;
 
import Factory.AlienFactoryMethod;
 
import Factory.BalasFactoryMethod;
import Factory.SoldadosFactoryMethod;
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
	protected LinkedList<Alien> aliensMapa;
	protected LinkedList<Soldado> soldadosMapa;
	protected LinkedList<Bala> balasSoldado;
	protected LinkedList<Bala> balasAlien;
	protected LinkedList<Bala> balasAeliminar;
	protected JPanel panelMapa;
	protected Mapa mapaCombate;
	protected Estado estadoMagia;
	private static int tamanioCelda = 80;
	protected SoldadosFactoryMethod factorySoldado;
	protected AlienFactoryMethod factoryAlien; 
	protected BalasFactoryMethod factoryBala;
	protected static int height = 500;
	protected static int width= 1000;
	protected JLabel l;
    protected static int columnas = ((width - 80 ) / tamanioCelda)+2;
    protected static int filas = ((height - 40) / tamanioCelda)+1;

	public Logica(JPanel p){
		panelMapa=p;
		puntos=100;
		monedas = 100;
		
<<<<<<< HEAD
		aliensMapa=new LinkedList();
		soldadosMapa= new LinkedList();
		a_eliminarObstaculo= new LinkedList();
		balasSoldado = new LinkedList();
		balasAlien = new LinkedList();
		balasAeliminar = new LinkedList();
=======
		aliensMapa=new LinkedList<Alien>();
		soldadosMapa= new LinkedList<Soldado>();
		a_eliminarObstaculo= new LinkedList<Obstaculo>();
		balasSoldado = new LinkedList<Bala>();
		balasAlien = new LinkedList<Bala>();
>>>>>>> 2c62ea2ec522af508dae7d32ce479422c36973e9
		
		mapaCombate = new Mapa(filas,columnas,p);
		
		estadoMagia = new estadoCampo();
	}
	
	
	public LinkedList<Soldado> getSoldados () {
		return soldadosMapa;
	}
	public void insertarObjetos() {
		mapaCombate.insertarObjetos();
	}
	
	public void limpiarBalasSoldado() {
		while (balasAeliminar.size() > 0) {
			Bala b = balasAeliminar.removeFirst();
			balasSoldado.remove(b);
		}
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
		while ( aliensMapa.size()< 1)
			aliensMapa.addLast(mapaCombate.insertarEnemigo(factoryAlien));	 
	   	
		if ( aliensMapa.size() == 0) {
			while ( aliensMapa.size()< 1)
				aliensMapa.addLast(mapaCombate.insertarEnemigo(factoryAlien));	 
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
<<<<<<< HEAD
				VisitorAlien v = new VisitorAlien();
				v.setAlien(p);
				if (!o.dejoPasar(v)){
					if (o.puedeAtacar(v)) {
						o.accept(v);
						p.actualizarGrafico(1);
						if (o.getVida() <= 0){
							o.actualizarGrafico(2);
							a_eliminarObstaculo.addLast(o);
							mapaCombate.setCeldaMapa(o.getCelda().getFila(),o.getCelda().getColumna(), null);
							mapaCombate.eliminar(o);
							siguiente.setElemento(null);
						}
					}
=======
				if (o.getVida() > 0){
					p.actualizarGrafico(1);
					VisitorAlien v = new VisitorAlien();
					v.setAlien(p);
					v.setEstado(estadoMagia);
					o.accept(v);
				}
				else{
					o.actualizarGrafico(2);
					a_eliminarObstaculo.addLast(o);
					limpiarMuertos();
					siguiente.setElemento(null);			
>>>>>>> 2c62ea2ec522af508dae7d32ce479422c36973e9
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
<<<<<<< HEAD
				VisitorSoldado v = new VisitorSoldado();
				v.setSoldado(p);
				if (!o.dejoPasar(v)){
					if (o.puedeAtacar(v)) {
						o.accept(v);
						p.actualizarGrafico(1);
						if ( o.getVida() <= 0){
							puntos += o.getPuntos();
							o.actualizarGrafico(2); 
							a_eliminarObstaculo.addLast(o);
							mapaCombate.setCeldaMapa(o.getCelda().getFila(),o.getCelda().getColumna(), null);
							mapaCombate.eliminar(o);
							siguiente.setElemento(null);
						}
=======
				if ( o.getVida() > 0){
					p.actualizarGrafico(1);
					VisitorSoldado v = new VisitorSoldado();
					v.setSoldado(p);
					if (o.getEstado() != null) {
						v.setEstado(o.getEstado());
>>>>>>> 2c62ea2ec522af508dae7d32ce479422c36973e9
					}
					else {
						v.setEstado(estadoMagia);
					}
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
		//p.getCelda().setElemento(null);
		//mapaCombate.setCeldaMapa(p.getCelda().getFila(),p.getCelda().getColumna(), null);
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
<<<<<<< HEAD
				balasAeliminar.addLast(p);
				mapaCombate.eliminar(p);
			}
=======
			balasSoldado.remove(p);
			mapaCombate.eliminar(p);
		}
>>>>>>> 2c62ea2ec522af508dae7d32ce479422c36973e9
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
			if ( o != null){
				if ( o.getVida() > 0){ 
					VisitorBalaSoldado v = new VisitorBalaSoldado();
					v.setBala(b);
					if (!o.dejoPasar(v)) 
						o.accept(v);
					else 
						b.setCelda(siguiente.getFila(), siguiente.getColumna());
				}
				else {
						o.actualizarGrafico(2);
						a_eliminarObstaculo.add(o);
				}
<<<<<<< HEAD
				else b.setCelda(siguiente.getFila(), siguiente.getColumna());
				
				mapaCombate.setCeldaMapa(b.getCelda().getFila(),b.getCelda().getColumna(), null);
				balasAeliminar.addLast(b);
=======
				balasSoldado.remove(b);
>>>>>>> 2c62ea2ec522af508dae7d32ce479422c36973e9
				mapaCombate.eliminar(b);
			}
		}
	}
	
	public void accionBalaSoldado() {
		for (Bala p : balasSoldado) {
			balaSoldado(p);
		}
	}

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
		
		}
		return toReturn;
	}
		
	public void crearS2(int x, int y) {
		boolean toReturn = false;
		if (monedas > 25 ) {
			toReturn = true;
			Celda c = mapaCombate.getCelda(x, y);	
			factorySoldado = new S2factory(panelMapa);
			soldadosMapa.addLast(factorySoldado.createPersonaje(c));	
			VisitorSoldado v = new VisitorSoldado ();
			monedas -=25;
		}
	}
	
	public void crearS3(int x, int y) {
		Celda c = mapaCombate.getCelda(x, y);
		factorySoldado = new S3factory(panelMapa);
		soldadosMapa.addLast(factorySoldado.createPersonaje(c));
		VisitorSoldado v = new VisitorSoldado ();
		v.setSoldado(soldadosMapa.getLast());
	}
	
	public void crearS4(int x, int y) {
		Celda c = mapaCombate.getCelda(x, y);
		factorySoldado = new S4factory(panelMapa);
		soldadosMapa.addLast(factorySoldado.createPersonaje(c));
		VisitorSoldado v = new VisitorSoldado ();
		v.setSoldado(soldadosMapa.getLast());
	}
	
	public void crearS5(int x, int y) {
		Celda c = mapaCombate.getCelda(x, y);
		factorySoldado = new S5factory(panelMapa);
		soldadosMapa.addLast(factorySoldado.createPersonaje(c));
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
							monedas += p.getVida()*0.5;
						else
							monedas += p.getVida();
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
