package Principal;


 

import Personajes.*;
 
import PowerUps.MagiaTemporal;

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
import Hilos.HiloMagiaTemporaCampo;
import Hilos.HiloMagiaTemporalFuerza;
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
	protected LinkedList<Obstaculo> a_eliminarObstaculoGrafica;
	protected LinkedList<Alien> aliensMapa;
	protected LinkedList<Soldado> soldadosMapa;
	protected LinkedList<Bala> balasSoldado;
	protected LinkedList<Bala> balasAlien;
	protected LinkedList<MagiaTemporal> listaMagia;
	protected int cantFuerza;
	protected int cantCampo;
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
    protected int cantOrdas;

	public Logica(JPanel p){
		panelMapa=p;
		puntos=100;
		monedas = 100;
		
		aliensMapa=new LinkedList<Alien>();
		soldadosMapa= new LinkedList<Soldado>();
		a_eliminarObstaculo= new LinkedList<Obstaculo>();
		a_eliminarObstaculoGrafica= new LinkedList<Obstaculo>();
		balasSoldado = new LinkedList<Bala>();
		balasAlien = new LinkedList<Bala>();
		listaMagia = new LinkedList<MagiaTemporal>();
		cantFuerza = 0;
		cantCampo = 0;
	 
		mapaCombate = new Mapa(filas,columnas,p);
		
		estadoMagia = new estadoCampo();
		cantOrdas = 4;
	}
	
	
	public LinkedList<Soldado> getSoldados () {
		return soldadosMapa;
	}
	
	
	public void insertarObjetos() {
			mapaCombate.insertarObjetos();
	}
	
	public void limpiarMuertos (){
		if ( a_eliminarObstaculo != null){
			while (a_eliminarObstaculo.size() > 0){
				Obstaculo o = a_eliminarObstaculo.removeFirst();
				a_eliminarObstaculoGrafica.addLast(o);
				aliensMapa.remove(o);
				soldadosMapa.remove(o);
				mapaCombate.getLista().remove(o);
				
			}
		}
	}
	
	
	
	public void insertarEnemigos() {
			aliensMapa.addLast(mapaCombate.insertarEnemigo(factoryAlien));;
		 
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
			System.out.println("Muevo alien------------------");
			VisitorAlien v = new VisitorAlien();
			v.setAlien(p);
			v.setEstado(null);
			Obstaculo o = siguiente.getElemento();
			if ( o == null) {
				mapaCombate.setCeldaMapa(p.getCelda().getFila(),p.getCelda().getColumna(), null);
				siguiente.setElemento(p);
				p.setCelda(siguiente.getFila(), siguiente.getColumna());
				p.actualizarGrafico(0);	
			}
			else {
			if (o.dejoPasar(v)) {
				mapaCombate.setCeldaMapa(p.getCelda().getFila(),p.getCelda().getColumna(), null);
				siguiente.setElemento(p);
				p.setCelda(siguiente.getFila(), siguiente.getColumna());
				p.actualizarGrafico(0);								
			}	
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
				VisitorAlien v = new VisitorAlien();
				v.setAlien(p);
				v.setEstado(estadoMagia);
				if ( o.puedoAtacar(v)) {
					if (o.getVida() > 0){
						p.actualizarGrafico(1);
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
	}
	
	/**Ataque de soldado cuerpo a cuerpo **/
	public void inicioAtaqueSoldados () {
		for (Personaje p : soldadosMapa){
			ataqueSoldado(p);
		}
	}
	
	public void setEstado_MTLogica (Estado e) {
		estadoMagia = e;
	}
	
	public void ataqueSoldado (Personaje p ) {
		Celda c = p.getCelda();	
		Celda siguiente = mapaCombate.siguienteCeldaDer(c);
		if (siguiente != null ){
			Obstaculo o = siguiente.getElemento();
			if ( o != null){
				VisitorSoldado v = new VisitorSoldado();
				v.setSoldado(p);
				v.setEstado(estadoMagia);
				if(o.puedoAtacar(v)) {				 
					if ( o.getVida() > 0){
						p.actualizarGrafico(1);
					 	o.accept(v);
					}
					else{
						if ( o.getMagiaTemporal() != null) {
							listaMagia.addLast(o.getMagiaTemporal());
							mapaCombate.setCeldaMapa(siguiente.getFila(), siguiente.getColumna(), o.getMagiaTemporal());
							siguiente.setElemento(o.getMagiaTemporal());
							o.getMagiaTemporal().getObstaculoGrafico().setPoint(siguiente.getFila(), siguiente.getColumna());
							panelMapa.add(o.getMagiaTemporal().getGrafico(0));	
							panelMapa.repaint();
						}
						else {
							mapaCombate.setCeldaMapa(siguiente.getFila(),siguiente.getColumna(), null);
							siguiente.setElemento(null);
						}
						puntos += o.getPuntos();
						o.actualizarGrafico(2); 
						a_eliminarObstaculo.addLast(o);
						limpiarMuertos();
				  }   
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
			balasSoldado.remove(p);
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

	public void crearBalasSoldados(Personaje s) {
		Celda celdaDisparo = mapaCombate.siguienteCeldaDer(s.getCelda());
		balasSoldado.addLast(mapaCombate.insertarBalasMapa(factoryBala,celdaDisparo,s));	
	}
 	
	public boolean puedoInsertar ( int x,int y ) {
		Celda c = mapaCombate.getCelda(x, y);
		//System.out.println("celda pulsada :"+c);
		if ( c.getElemento() == null)
			return true;
		else
			return false;
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
	
	
	public void activarMagia_Fuerza () {
		 
		HiloMagiaTemporalFuerza h1 = new HiloMagiaTemporalFuerza (this);
		h1.start();	
	}
	
	public boolean puedeActivarFuerza () {
		if ( cantFuerza > 0) {
			cantFuerza--;
			return true;
		}
		else
			return false;
	}
	

	
	public void activarMagia_Campo () {
		HiloMagiaTemporaCampo h1 = new HiloMagiaTemporaCampo (this);
		h1.start();	
	}
	
	public boolean puedeActivarCampo () {
		if ( cantCampo > 0) {
			cantCampo--;
			return true;
		}
		else
			return false;
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
	
	public boolean verificarMagiaFuerza(int x, int y) {
		boolean toReturn = false;
		Celda c= mapaCombate.getCelda(x, y);
		if ( c.getElemento() != null) {
			if ( listaMagia.size() > 0) {
				MagiaTemporal m = listaMagia.getFirst();
				int i = 0;
				boolean corte = true;
				while ( m != null && corte ) {
					
					if (m.equals(c.getElemento())) {
						cantFuerza++;
						mapaCombate.eliminarMagia(m);
						mapaCombate.setCeldaMapa(x, y, null);
						listaMagia.remove(m);
						toReturn = true;
						corte = false;
					}
					else {
						i++;
						if ( i < listaMagia.size())
							m = listaMagia.get(i);
						else
							corte = false;
					}
				}
			}
		}
			System.out.println("Resultado verificar MAGIA TEMPORAL : "+toReturn);
			return toReturn;
  }
	
	public boolean verificarMagiaCampo(int x, int y) {
		boolean toReturn = false;
		Celda c= mapaCombate.getCelda(x, y);
		if ( c.getElemento() != null) {
			if ( listaMagia.size() > 0) {
				MagiaTemporal m = listaMagia.getFirst();
				int i = 0;
				boolean corte = true;
				while ( m != null && corte ) {
					
					if (m.equals(c.getElemento())) {
						cantCampo++;
						mapaCombate.eliminarMagia(m);
						mapaCombate.setCeldaMapa(x, y, null);
						listaMagia.remove(m);
						toReturn = true;
						corte = false;
					}
					else {
						i++;
						if ( i < listaMagia.size())
							m = listaMagia.get(i);
						else
							corte = false;
					}
				}
			}
		}
			System.out.println("Resultado verificar MAGIA TEMPORAL Campo : "+toReturn);
			return toReturn;
  }


	public void setPanel(JPanel frame) {
		panelMapa = frame;		
	}	
	
	public LinkedList<Obstaculo> getObstaculos_a_Limpiar(){
		return a_eliminarObstaculoGrafica;
	}
	
	public Mapa getMapaCombate () {
		return mapaCombate;
	}
	
}
