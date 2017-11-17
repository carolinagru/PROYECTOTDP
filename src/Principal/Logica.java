package Principal;


 

import Personajes.*;
 
import PowerUps.MagiaTemporal;

import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import Disparo.Bala;
 
import Estate.Estado;
 
import Estate.EstadoCampo;
 
import Factory.AlienFactoryMethod;
 
import Factory.BalasFactoryMethod;
import Factory.SoldadosFactoryMethod;
import Hilos.HiloAliens;
import Hilos.HiloDisparo;
import Hilos.HiloInsertarAlien;
import Hilos.HiloLimpieza;
import Hilos.HiloMagiaTemporaCampo;
import Hilos.HiloMagiaTemporalFuerza;
import Hilos.HiloSoldados;
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
	protected LinkedList<Obstaculo> a_eliminarObstaculo;
	protected LinkedList<Obstaculo> a_eliminarObstaculoGrafica;
	protected LinkedList<Alien> aliensMapa;
	protected LinkedList<Soldado> soldadosMapa;
	protected LinkedList<Bala> balasSoldado;
	protected LinkedList<Bala> balasAlien;
	protected LinkedList<MagiaTemporal> listaMagia;
	protected int cantFuerza;
	protected int cantCampo;
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
    protected static int columnas = ((width - 80 ) / tamanioCelda)+2;
    protected static int filas = ((height - 40) / tamanioCelda)+1;
    protected int cantOrdas;
    protected int nivel;
    protected int cantEnemigos;
    protected boolean juegoActivo;
    

	public Logica(JPanel p){
		panelMapa=p;
		puntos = 100;
		monedas = 100;
		nivel = 1;
		cantEnemigos = 12;
		juegoActivo = true;
		
		aliensMapa=new LinkedList<Alien>();
		soldadosMapa= new LinkedList<Soldado>();
		a_eliminarObstaculo= new LinkedList<Obstaculo>();
		a_eliminarObstaculoGrafica= new LinkedList<Obstaculo>();
		balasSoldado = new LinkedList<Bala>();
		balasAlien = new LinkedList<Bala>();
		listaMagia = new LinkedList<MagiaTemporal>();
		balasAeliminar = new LinkedList<Bala>();

		cantFuerza = 0;
		cantCampo = 0;
	 
		mapaCombate = new Mapa(filas,columnas,p);
		
		estadoMagia = new EstadoCampo();
		cantOrdas = 1;
		
		ejecutarHilos(juegoActivo);
	
	}
	
	public void ejecutarHilos(boolean resultado) {
		
		if (resultado) {
			HiloInsertarAlien h5 = new HiloInsertarAlien (this);
			h5.start();
			
			HiloAliens h = new HiloAliens(this);
			h.start();
			
			HiloSoldados h2 = new HiloSoldados(this);	
			HiloDisparo h3 = new HiloDisparo(this);
			h3.start();
			h2.start();
			
			
			HiloLimpieza h4 = new HiloLimpieza (this);
			h4.start();
		}
	}
	
	public boolean getjuegoActivo() {
		return juegoActivo;
	}
	
	public int getNivel() {
		return nivel;
	}
	
	public void setNivel(int n) {
		this.nivel = n;
		this.cantOrdas = 0;
		this.cantEnemigos = 12;
		this.juegoActivo = true;
		ejecutarHilos(true);
		
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
				a_eliminarObstaculoGrafica.addLast(o);
				aliensMapa.remove(o);
				soldadosMapa.remove(o);
				mapaCombate.getLista().remove(o);
			}
		}
	}
	public void insertarEnemigos() {
	 if (cantEnemigos != 0) {
		if ( aliensMapa.size() == 0) {
			while ( aliensMapa.size() < 4)
				aliensMapa.addLast(mapaCombate.insertarEnemigo(factoryAlien,nivel,cantOrdas));	 
			cantEnemigos-= 4;
			cantOrdas++;
		  }
	 }
	 else { juegoActivo = false;
	 		if (nivel == 1)
	 			setNivel(2);
	 		else gano();
	 	  }
	}
	
	public void inicioMovimientoAliens() {
		for (Alien p :aliensMapa){				
			moverAlien(p);	
		}
	}
	
	public void gano() {
		
		
	}
	
	public void gameOver() {
		
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
			if ( o == null  || o.dejoPasar(v)) {
				mapaCombate.setCeldaMapa(p.getCelda().getFila(),p.getCelda().getColumna(), null);
				siguiente.setElemento(p);
				p.setCelda(siguiente.getFila(), siguiente.getColumna());
				p.actualizarGrafico(0);	
			}
		}else gameOver();
			 
	}
	
	public void inicioAtaqueAlien (){
		for (Alien p : aliensMapa){
			ataqueAlien(p);
		}
	}
	
	public void ataqueAlien (Alien p){
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
		for (Soldado p : soldadosMapa){
			ataqueSoldado(p);
		}
	}
	
	public void setEstado_MTLogica (Estado e) {
		estadoMagia = e;
	}
	
	public LinkedList<Alien> getAliens() {
		return aliensMapa;
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
		
		Celda siguiente = mapaCombate.siguienteCeldaDer(p.getCelda());
		mapaCombate.setCeldaMapa(p.getCelda().getFila(),p.getCelda().getColumna(), null);

		if (siguiente != null) {
			Obstaculo o = siguiente.getElemento();
			if (o == null ){
				siguiente.setElemento(p);
				p.setCelda(siguiente.getFila(), siguiente.getColumna());
				p.actualizarGrafico(1);
			}	
		}
		else {
				balasAeliminar.addLast(p);
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
				VisitorBalaSoldado v = new VisitorBalaSoldado();
				v.setBala(b);
				if (!o.dejoPasar(v)) {
					o.accept(v);
					if (o.getVida() <= 0){
						o.actualizarGrafico(2);
						a_eliminarObstaculo.add(o);
						mapaCombate.setCeldaMapa(o.getCelda().getFila(),o.getCelda().getColumna(), null);
						mapaCombate.eliminar(o);
					}
				}
				else b.setCelda(siguiente.getFila(), siguiente.getColumna());
				
				mapaCombate.setCeldaMapa(b.getCelda().getFila(),b.getCelda().getColumna(), null);
				balasAeliminar.addLast(b);
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
		Celda c = mapaCombate.getCelda(x, y);	
		if ( monedas >= 25) {
			if (c.getElemento() == null) {
				toReturn = true;
				factorySoldado = new S1factory(panelMapa);
				soldadosMapa.addLast(factorySoldado.createPersonaje(c));
				monedas-=25;
			}
		}
		return toReturn;
	}
		
	public boolean crearS2(int x, int y) {
		boolean toReturn = false;
		Celda c = mapaCombate.getCelda(x, y);	
		if (monedas >= 25 ) {
			if (c.getElemento() == null) {
				toReturn = true;
				factorySoldado = new S2factory(panelMapa);
				soldadosMapa.addLast(factorySoldado.createPersonaje(c));	
				monedas -=25;
			}
		}
	 return toReturn;
	}
	
	public boolean crearS3(int x, int y) {
		boolean toReturn = false;
		Celda c = mapaCombate.getCelda(x, y);	
		if (monedas >= 25 ) {
			if (c.getElemento() == null) {
				toReturn = true;
				factorySoldado = new S3factory(panelMapa);
				soldadosMapa.addLast(factorySoldado.createPersonaje(c));	
				monedas -=25;
			}
		}
	 return toReturn;
	}
	
	public boolean crearS4(int x, int y) {
		boolean toReturn = false;
		Celda c = mapaCombate.getCelda(x, y);	
		if (monedas >= 25 ) {
			if (c.getElemento() == null) {
				toReturn = true;
				factorySoldado = new S4factory(panelMapa);
				soldadosMapa.addLast(factorySoldado.createPersonaje(c));	
				monedas -=25;
			}
		}
	 return toReturn;
	}
	
	public boolean crearS5(int x, int y) {
		boolean toReturn = false;
		Celda c = mapaCombate.getCelda(x, y);	
		if (monedas >= 25 ) {
			if (c.getElemento() == null) {
				toReturn = true;
				factorySoldado = new S5factory(panelMapa);
				soldadosMapa.addLast(factorySoldado.createPersonaje(c));	
				crearBalasSoldados(soldadosMapa.getLast());
				monedas -=25;
			}
		}
	 return toReturn;
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
						mapaCombate.eliminar(m);
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
						mapaCombate.eliminar(m);
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
