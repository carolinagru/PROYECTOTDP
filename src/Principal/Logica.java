package Principal;

import Personajes.*;
import PowerUps.Bomba;
<<<<<<< HEAD
import PowerUps.Campo_de_Proteccion;
import PowerUps.Fuerza;
=======
>>>>>>> 9f2c3c5cfd7e54c0fe39e2b489671a8bc99aef7b
import PowerUps.MagiaTemporal;
import PowerUps.ObjetoPrecioso;

import java.util.LinkedList;

import javax.swing.JPanel;

import Disparo.Bala;
 
import Estate.Estado;
import Estate.EstadoCampo;
import Estate.EstadosinMagia;
import Factory.AlienFactoryMethod;
 
import Factory.BalasFactoryMethod;
import Factory.FactoryRobot;
import Factory.ObjTemporalFactoryMethod;
import Factory.ObjVidaComprarFactoryMethod;
import Factory.ParedFactory;
import Factory.SoldadosFactoryMethod;
import Factory.TanqueFactory;
import Hilos.HiloActivarObjetoTemporal;
 
 
import Hilos.HiloLogico;
import Hilos.HiloMagiaTemporaCampo;
import Hilos.HiloMagiaTemporalFuerza;
import InterfazGrafica.PanelGano;
import InterfazGrafica.PanelNivel2;
import InterfazGrafica.panelGameOver;
import Factory.S1factory;
import Factory.S2factory;
import Factory.S3FactoryMethod;
import Factory.S3factory;
import Factory.S4factory;
import Factory.S5factory;
import Objetos.ObjetoTemporal;
import Objetos.ObjetoVidaComprar;
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
	protected LinkedList<S3> soldadosMapaS3;
	protected LinkedList<Soldado> soldados45;
	protected LinkedList<Alien> alien35;
	protected LinkedList<Bala> balasSoldado;
<<<<<<< HEAD
	protected LinkedList<ObjetoPrecioso> listaBomba;
	protected LinkedList<MagiaTemporal> listaMagia;
=======
>>>>>>> 9f2c3c5cfd7e54c0fe39e2b489671a8bc99aef7b
	protected LinkedList<Bala> balasAlien;
	protected LinkedList<ObjetoPrecioso> bombas;
	protected LinkedList<ObjetoPrecioso> piedras;
	protected LinkedList<ObjetoTemporal> listaObjetosTemporales;
	protected LinkedList<ObjetoVidaComprar> listaObjetosComprarVida;
	protected int cantBomba;
	protected int cantCampo;
	protected LinkedList<Bala> balasAeliminar;
	protected JPanel panelMapa;
	protected Mapa mapaCombate;
	protected Estado estadoMagia;
	private static int tamanioCelda = 80;
	protected SoldadosFactoryMethod factorySoldado;
	protected S3FactoryMethod factorySoldadoS3;
	protected AlienFactoryMethod factoryAlien; 
	protected BalasFactoryMethod factoryBala;
	protected ObjTemporalFactoryMethod fabricaObjetoTemporales;
	protected ObjVidaComprarFactoryMethod fabricaObjetoVidaComprar;
	protected static int height = 500;
	protected static int width= 1000;
    protected static int columnas = ((width - 80) / tamanioCelda)+2;
    protected static int filas = ((height - 40) / tamanioCelda)+1;
    protected int cantOrdas;
    protected int nivel;
    protected int cantEnemigos;
    protected boolean juegoActivo;
    protected Mapa_GUI2 gui;
    

	public Logica(JPanel p, Mapa_GUI2 gui){
		this.gui = gui;
		panelMapa=p;
		puntos = 100;
		monedas = 500;
		nivel = 1;
		cantEnemigos = 12;
		juegoActivo = true;
		gui.setMonedasGUI(monedas);
		
		
		bombas = new LinkedList<ObjetoPrecioso>();
		piedras = new LinkedList<ObjetoPrecioso>();
		aliensMapa=new LinkedList<Alien>();
		soldadosMapa= new LinkedList<Soldado>();
		soldadosMapaS3= new LinkedList<S3>();
		soldados45= new LinkedList<Soldado>();
		a_eliminarObstaculo= new LinkedList<Obstaculo>();
		a_eliminarObstaculoGrafica= new LinkedList<Obstaculo>();
		balasSoldado = new LinkedList<Bala>();
		balasAlien = new LinkedList<Bala>();
<<<<<<< HEAD
		listaBomba = new LinkedList<ObjetoPrecioso>();
		balasAeliminar = new LinkedList<Bala>();
		listaObjetosTemporales = new LinkedList<ObjetoTemporal>();
		listaObjetosComprarVida = new LinkedList<ObjetoVidaComprar>();
		listaMagia = new LinkedList<MagiaTemporal>();

=======
		balasAeliminar = new LinkedList<Bala>();
		listaObjetosTemporales = new LinkedList<ObjetoTemporal>();
		listaObjetosComprarVida = new LinkedList<ObjetoVidaComprar>();
		
		nivel = 1;
>>>>>>> 9f2c3c5cfd7e54c0fe39e2b489671a8bc99aef7b
		cantBomba = 0;
		cantCampo = 0;
	 
		mapaCombate = new Mapa(filas,columnas,p);
		
		estadoMagia = new EstadoCampo();
		cantOrdas = 1;
		ejecutarHilos(juegoActivo);
	
	}
	
<<<<<<< HEAD
	public LinkedList<ObjetoPrecioso> getBombas() {
		return bombas;
	}
	 
	public LinkedList<ObjetoPrecioso> getPiedras() {
		return piedras;
	}
	 
=======
	public Mapa_GUI2 getGui() {
		return gui;
	}
	
>>>>>>> 1fccf882b4f605290218d231c34e3c8fcae79048
	public void ejecutarHilos(boolean resultado) {
		insertarObjetos();	
		HiloLogico h = new HiloLogico(this);
		h.start();
	}

	public boolean getjuegoActivo() {
		return juegoActivo;
	}
	
	public int getNivel() {
		return nivel;
	}
	
	public void setNivel(int n) {
<<<<<<< HEAD
=======
		aliensMapa.clear();
		soldadosMapa.clear();
		soldadosMapaS3.clear();
		soldados45.clear();
		a_eliminarObstaculo.clear();
		a_eliminarObstaculoGrafica.clear();
		balasSoldado.clear();
		balasAlien.clear();
		balasAeliminar.clear();
		listaObjetosTemporales.clear();
		listaObjetosComprarVida.clear();
		
		gui.fondo(n);
>>>>>>> 9f2c3c5cfd7e54c0fe39e2b489671a8bc99aef7b
		this.nivel = n;
		this.cantOrdas = 0;
		this.cantEnemigos = 12;
		this.juegoActivo = true;
		ejecutarHilos(true);
	}

	public LinkedList<Soldado> getSoldados () {
		return soldadosMapa;
	}
<<<<<<< HEAD
=======
	
>>>>>>> 9f2c3c5cfd7e54c0fe39e2b489671a8bc99aef7b

	public void insertarObjetos() {
		mapaCombate.insertarObjetos(this);
	}
		
	public void limpiarBalasSoldado() {
		 if ( balasAeliminar != null){
			while (balasAeliminar.size() > 0) {
				Bala b = balasAeliminar.removeFirst();
				balasSoldado.remove(b);
			}
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
				listaObjetosComprarVida.remove(o);
			}
		}
	}
	
	public void insertarEnemigos() {
		 if(cantEnemigos != 0) {
			if ( aliensMapa.size() == 0) {
				while ( aliensMapa.size() < 4)
					aliensMapa.addLast(mapaCombate.insertarEnemigo(factoryAlien,nivel,cantOrdas));	 
				cantEnemigos-= 4;
				cantOrdas++;
			}
		 }
		 else{ 
		 	juegoActivo = false;
	 		if (nivel == 1) {
	 			setNivel(2);
	 			PanelNivel2 panel = new PanelNivel2();
	 			panel.setLocationRelativeTo(null);
	 			panel.setVisible(true);
	 			gui.setVisible(false);
	 		}
	 		else gano();
	 	  }
	}
	
	public void inicioMovimientoAliens() {
		for (Alien p :aliensMapa){				
			moverAlien(p);	
		}
	}
	
	public void gano() {
		if(nivel == 2) {
			if(cantEnemigos == 0) { 
				juegoActivo = false;
				PanelGano p = new PanelGano();
				p.setLocationRelativeTo(null);
				p.setVisible(true);
				gui.setVisible(false);
			}
		}
	}
	
	public void gameOver() {
		juegoActivo = false;
		panelGameOver panelPerdio = new panelGameOver();
		panelPerdio.setVisible(true);
		gui.setVisible(false);
	}
	
	public void moverAlien(Personaje p) {	
		Celda siguiente = mapaCombate.siguienteCeldaIzq(p.getCelda());
		p.getCelda().setElemento(null);
		
		if (siguiente != null) {
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
				if (o.puedoAtacar(v)) {
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
	public LinkedList<S3> getS3(){
		return soldadosMapaS3;
	}
	
	public void setEstado_MTLogica (Estado e) {
		estadoMagia = e;
	}
	
	public LinkedList<Alien> getAliens() {
		return aliensMapa;
	}
	
	public LinkedList<Bala> getBalas() {
		return balasSoldado;
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
<<<<<<< HEAD
						System.out.println("Encontre magia temporal ------"+o.getMagiaTemporal()+"Celda :"+siguiente.getFila()+ " - "+siguiente.getColumna());
						listaMagia.addLast(o.getMagiaTemporal());
=======
>>>>>>> 82bc74337f48638211395da67ee779e7b3075a08
						mapaCombate.setCeldaMapa(siguiente.getFila(), siguiente.getColumna(), o.getMagiaTemporal());
						siguiente.setElemento(o.getMagiaTemporal());
						o.getMagiaTemporal().getObstaculoGrafico().setPoint(siguiente.getFila(), siguiente.getColumna());
						mapaCombate.insertar(o.getMagiaTemporal().getGrafico(0));
						System.out.println("Se inserto magia en celda siguiente ."+siguiente.getElemento());
						
					}
<<<<<<< HEAD
=======
					if (o.getObjetoPrecioso() != null) {
						mapaCombate.setCeldaMapa(siguiente.getFila(), siguiente.getColumna(), o.getObjetoPrecioso());
						siguiente.setElemento(o.getObjetoPrecioso());
						o.getObjetoPrecioso().getObstaculoGrafico().setPoint(siguiente.getFila(), siguiente.getColumna());
						mapaCombate.insertar(o.getObjetoPrecioso().getGrafico(0));
					}
				
>>>>>>> 82bc74337f48638211395da67ee779e7b3075a08
					else {
<<<<<<< HEAD
							if (o.getBomba() != null) {
								listaBomba.addLast(o.getBomba());
								mapaCombate.setCeldaMapa(siguiente.getFila(), siguiente.getColumna(), o.getBomba());
								siguiente.setElemento(o.getBomba());
								o.getBomba().getObstaculoGrafico().setPoint(siguiente.getFila(), siguiente.getColumna());
								mapaCombate.insertar(o.getBomba().getGrafico(0));
							}
						
							else {
									mapaCombate.setCeldaMapa(siguiente.getFila(),siguiente.getColumna(), null);
									siguiente.setElemento(null);
								 }
						 }
						puntos += o.getPuntos();
						monedas += o.getMonedas();
						gui.setMonedasGUI(monedas);
						gui.setPuntosGUI(puntos);
						o.actualizarGrafico(2); 
						a_eliminarObstaculo.addLast(o);
						limpiarMuertos();
					}	   
				}
=======
						if (o.getObjetoPrecioso() != null) {
							System.out.println("Encontre un objeto Precioso ------");
							listaObjetoPrecioso.addLast(o.getObjetoPrecioso());
							mapaCombate.setCeldaMapa(siguiente.getFila(), siguiente.getColumna(), o.getObjetoPrecioso());
							siguiente.setElemento(o.getObjetoPrecioso());
							o.getObjetoPrecioso().getObstaculoGrafico().setPoint(siguiente.getFila(), siguiente.getColumna());
							mapaCombate.insertar(o.getObjetoPrecioso().getGrafico(0));
						}
					
						else {
								mapaCombate.setCeldaMapa(siguiente.getFila(),siguiente.getColumna(), null);
								siguiente.setElemento(null);
						 }	
					}
					cantEnemigos--;
					puntos += o.getPuntos();
					monedas += o.getMonedas();
					gui.setMonedasGUI(monedas);
					gui.setPuntosGUI(puntos);
					o.actualizarGrafico(2); 
					a_eliminarObstaculo.addLast(o);
					//limpiarMuertos();
					System.out.println("Se inserto magia en celda siguiente ultimo ."+siguiente.getElemento());

				}	   
>>>>>>> 9f2c3c5cfd7e54c0fe39e2b489671a8bc99aef7b
			}
		}
	}
	
	public void ataqueSoldadoS3 (S3 p ) {
		Celda c = p.getCelda();	
		Celda cv = p.getCeldaVecina();
		Celda siguiente = mapaCombate.siguienteCeldaDer(c);
		Celda siguienteVecina = mapaCombate.siguienteCeldaDer(cv);
		if (siguiente != null){
			Obstaculo o = siguiente.getElemento();
			Obstaculo ov = siguienteVecina.getElemento();
			if ( o != null ){
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
							mapaCombate.setCeldaMapa(siguiente.getFila(), siguiente.getColumna(), o.getMagiaTemporal());
							siguiente.setElemento(o.getMagiaTemporal());
							o.getMagiaTemporal().getObstaculoGrafico().setPoint(siguiente.getFila(), siguiente.getColumna());
							mapaCombate.insertar(o.getMagiaTemporal().getGrafico(0));
						}
<<<<<<< HEAD
						else {
							if (o.getObjetoPrecioso() != null) {
								mapaCombate.setCeldaMapa(siguiente.getFila(), siguiente.getColumna(), o.getObjetoPrecioso());
								siguiente.setElemento(o.getObjetoPrecioso());
								o.getObjetoPrecioso().getObstaculoGrafico().setPoint(siguiente.getFila(), siguiente.getColumna());
								mapaCombate.insertar(o.getObjetoPrecioso().getGrafico(0));
								}
							else {
									mapaCombate.setCeldaMapa(siguiente.getFila(),siguiente.getColumna(), null);
									siguiente.setElemento(null);
								 }
						}
						cantEnemigos--;
						puntos += o.getPuntos();
						monedas += o.getMonedas();
						gui.setMonedasGUI(monedas);
						gui.setPuntosGUI(puntos);
						System.out.println("Despues -Puntos :"+puntos + " Monedas :"+monedas);
						o.actualizarGrafico(2); 
						a_eliminarObstaculo.addLast(o);
						//limpiarMuertos();
					}	   
=======
<<<<<<< HEAD
=======
						if (o.getObjetoPrecioso() != null) {
							mapaCombate.setCeldaMapa(siguiente.getFila(), siguiente.getColumna(), o.getObjetoPrecioso());
							siguiente.setElemento(o.getObjetoPrecioso());
							o.getObjetoPrecioso().getObstaculoGrafico().setPoint(siguiente.getFila(), siguiente.getColumna());
							mapaCombate.insertar(o.getObjetoPrecioso().getGrafico(0));
						}
>>>>>>> 9f2c3c5cfd7e54c0fe39e2b489671a8bc99aef7b
						else {
								if (o.getBomba() != null) {
									listaBomba.addLast(o.getBomba());
									mapaCombate.setCeldaMapa(siguiente.getFila(), siguiente.getColumna(), o.getBomba());
									siguiente.setElemento(o.getBomba());
									o.getBomba().getObstaculoGrafico().setPoint(siguiente.getFila(), siguiente.getColumna());
									mapaCombate.insertar(o.getBomba().getGrafico(0));
								}
							
								else {
										mapaCombate.setCeldaMapa(siguiente.getFila(),siguiente.getColumna(), null);
										siguiente.setElemento(null);
									 }
							}
							puntos += o.getPuntos();
							monedas += o.getMonedas();
							gui.setMonedasGUI(monedas);
							gui.setPuntosGUI(puntos);
							System.out.println("Despues -Puntos :"+puntos + " Monedas :"+monedas);
							o.actualizarGrafico(2); 
							a_eliminarObstaculo.addLast(o);
							limpiarMuertos();
						}	   
>>>>>>> 1fccf882b4f605290218d231c34e3c8fcae79048
				}
			}
			if (ov != null) {
				VisitorSoldado v = new VisitorSoldado();
				v.setSoldado(p);
				v.setEstado(estadoMagia);
				if(ov.puedoAtacar(v)) {				 
					if ( ov.getVida() > 0){
						p.actualizarGrafico(1);
					 	ov.accept(v);
					}
					else{
						if ( ov.getMagiaTemporal() != null) {
							mapaCombate.setCeldaMapa(siguienteVecina.getFila(), siguienteVecina.getColumna(), ov.getMagiaTemporal());
							siguienteVecina.setElemento(ov.getMagiaTemporal());
							ov.getMagiaTemporal().getObstaculoGrafico().setPoint(siguienteVecina.getFila(), siguienteVecina.getColumna());
							mapaCombate.insertar(ov.getMagiaTemporal().getGrafico(0));
						}
<<<<<<< HEAD
=======
						
						if (ov.getObjetoPrecioso() != null) {
							mapaCombate.setCeldaMapa(siguienteVecina.getFila(), siguienteVecina.getColumna(), ov.getObjetoPrecioso());
							siguienteVecina.setElemento(ov.getObjetoPrecioso());
							ov.getObjetoPrecioso().getObstaculoGrafico().setPoint(siguienteVecina.getFila(), siguienteVecina.getColumna());
							mapaCombate.insertar(ov.getObjetoPrecioso().getGrafico(0));
						}
					
>>>>>>> 9f2c3c5cfd7e54c0fe39e2b489671a8bc99aef7b
						else {
								if (ov.getBomba() != null) {
									listaBomba.addLast(ov.getBomba());
									mapaCombate.setCeldaMapa(siguienteVecina.getFila(), siguienteVecina.getColumna(), ov.getBomba());
									siguienteVecina.setElemento(ov.getBomba());
									ov.getBomba().getObstaculoGrafico().setPoint(siguienteVecina.getFila(), siguienteVecina.getColumna());
									mapaCombate.insertar(ov.getBomba().getGrafico(0));
								}
							
								else {
										mapaCombate.setCeldaMapa(siguienteVecina.getFila(),siguienteVecina.getColumna(), null);
										siguienteVecina.setElemento(null);
									 }
						}
							puntos += ov.getPuntos();
							monedas += ov.getMonedas();
							gui.setMonedasGUI(monedas);
							gui.setPuntosGUI(puntos);
							ov.actualizarGrafico(2); 
							a_eliminarObstaculo.addLast(ov);
							limpiarMuertos();
							}
					}
				}
			}
		}
	
	public void moverDisparoSoldado(Bala p){
		Celda siguiente = mapaCombate.siguienteCeldaDer(p.getCelda());
		p.getCelda().setElemento(null);
		  
		if (siguiente != null) {
			VisitorBalaSoldado v = new VisitorBalaSoldado();
			v.setBala(p);
			Obstaculo o = siguiente.getElemento();
			if (o == null || o.dejoPasar(v)){
				mapaCombate.setCeldaMapa(p.getCelda().getFila(),p.getCelda().getColumna(), null);
				siguiente.setElemento(p);
				p.setCelda(siguiente.getFila(), siguiente.getColumna());
				p.actualizarGrafico(0);	
			}
			else {
				balasAeliminar.addLast(p);
				mapaCombate.eliminar(p);
			}
		}
		else {
			balasAeliminar.addLast(p);
			mapaCombate.eliminar(p);
		}
	 
	}
	
	public void soldadosBala() {
		for (Soldado p: soldados45){
			if (mapaCombate.puedeDisparar(p)) {
				Bala b = mapaCombate.insertarBalasMapa(factoryBala, p);	
				balasSoldado.addLast(b);
			}
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
					balasAeliminar.addLast(b);
					mapaCombate.eliminar(b);
					b.getCelda().setElemento(null);
					if (o.getVida() <= 0){
						o.actualizarGrafico(2);
						a_eliminarObstaculo.add(o);
						siguiente.setElemento(null);
						mapaCombate.eliminar(b);
						limpiarMuertos();

					}
				}
			}
		}
	}
	
 
	public boolean crearS1(int x, int y) {
		boolean toReturn = false;
		Celda c = mapaCombate.getCelda(x, y);	
		if ( monedas >= 25) {
			if (c.getElemento() == null) {
				toReturn = true;
				factorySoldado = new S1factory(panelMapa);
				soldados45.addLast(factorySoldado.createPersonaje(c));
				monedas-=25;
				gui.setMonedasGUI(monedas);
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
				gui.setMonedasGUI(monedas);
			}
		}
	 return toReturn;
	}
	
	public boolean crearS3(int x, int y) {
		boolean toReturn = false;
		Celda c = mapaCombate.getCelda(x, y);	
		if (monedas >= 25 ) {
			if (c.getElemento() == null) {
				Celda v = mapaCombate.puedeInsertar(c); 
				if (v != null){
					toReturn = true;
					factorySoldadoS3 = new S3factory(panelMapa);
					soldadosMapaS3.addLast(factorySoldadoS3.createPersonaje(c,v));	
					monedas -=25;
					gui.setMonedasGUI(monedas);
				}
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
				Soldado s =  factorySoldado.createPersonaje(c);
				soldados45.addLast(s);
				monedas -=45;
				gui.setMonedasGUI(monedas);
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
				Soldado s =  factorySoldado.createPersonaje(c);
				soldados45.addLast(s);
				monedas -=60;
				gui.setMonedasGUI(monedas);
			}
		}
	 return toReturn;
	}
	
	public void activarMagia_Fuerza () {
		 
		HiloMagiaTemporalFuerza h1 = new HiloMagiaTemporalFuerza (this);
		h1.start();	
	}
	
	public void activarMagia_Campo () {
		HiloMagiaTemporaCampo h1 = new HiloMagiaTemporaCampo (this);
		h1.start();	
	}
	
	/**Verifica si la posicion corresonde al panel de combate 
	 * 
	 * @param x Fila del elemento a verificar
	 * @param y Columna del elemento a verificar
	 * @return Verdadero en caso de encontrar un Soldado , Falso en caso que haya seleccionado un objeto no correspondiente a un soldado, o un casillero vacio
	 */
	public boolean verificarPosicion(int x, int y) {
		Celda c= mapaCombate.getCelda(x, y);
		if ( c.getElemento() != null) {
			for(Soldado p: soldadosMapa) {
				if (p.getCelda().equals(c)) {
					if ( p.getVida() != 100) {
						monedas += p.getVida()*0.5;
						gui.setMonedasGUI(monedas);
					}
					else {
						monedas += p.getVida();
						gui.setMonedasGUI(monedas);
					}
					mapaCombate.eliminar(p);
					soldadosMapa.remove(p);
					return true;
				}
			}
			for(Soldado p: soldados45) {
				if (p.getCelda().equals(c)) {
					if ( p.getVida() != 100) {
						monedas += p.getVida()*0.5;
						gui.setMonedasGUI(monedas);
					}
					else {
						monedas += p.getVida();
						gui.setMonedasGUI(monedas);
					}
					mapaCombate.eliminar(p);
					soldados45.remove(p);
					return true;
				}
			}
		}
	   return false;
	}
	
	public boolean verificarBomba(int x, int y) {
		boolean toReturn = false;
		Celda c= mapaCombate.getCelda(x, y);
		if ( c.getElemento() != null) {
			if ( listaBomba.size() > 0) {
				ObjetoPrecioso m = listaBomba.getFirst();
				int i = 0;
				boolean corte = true;
				while ( m != null && corte ) {
					
					if (m.equals(c.getElemento())) {
						cantBomba++;
						mapaCombate.eliminar(m);
						//mapaCombate.setCeldaMapa(x, y, null);
						//listaMagia.remove(m);
						toReturn = true;
						corte = false;
					}
					else {
						i++;
						if ( i < listaBomba.size())
							m = listaBomba.get(i);
						else
							corte = false;
					}
				}
			}
		}
			return toReturn;
  }
	
	public void activarBomba(int x, int y) {
<<<<<<< HEAD
		LinkedList<Obstaculo> l = mapaCombate.activarBomba(x,y,listaBomba.getLast());
		
		while (l.size() > 0) {
			Obstaculo o = l.removeFirst();
			a_eliminarObstaculo.add(o);
		}
		
	  limpiarMuertos();
		
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
						cantCampo++;
						mapaCombate.eliminar(m);
						//mapaCombate.setCeldaMapa(x, y, null);
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
		if (toReturn)
			activarMagia_Fuerza();
			return toReturn;
  }
=======
		Celda celda = mapaCombate.getCelda(x, y);
		if (celda.getElemento() != null) {
			System.out.println("entro a activarbombaaaaaaaaaaaaaaaaa");
			ObjetoPrecioso b = bombas.getLast();
			LinkedList<Obstaculo> l = mapaCombate.activarBomba(celda,b);
			while (l.size() > 0) {
				Obstaculo o = l.removeFirst();
				a_eliminarObstaculo.add(o);
			}
			mapaCombate.eliminar(b);
			celda.setElemento(null);
		}
	}
	
	public void activarPiedra(int x, int y) {
		Piedra p = new Piedra();
		p.setCelda(x, y);
		mapaCombate.setCeldaMapa(x, y, p);
		p.getCelda().setElemento(p);
		mapaCombate.insertar(p.getGrafico(0));
		HilosObjetoPreciosoPiedra op = new HilosObjetoPreciosoPiedra(this);
		op.start();
		mapaCombate.eliminar(p);
	}
>>>>>>> 9f2c3c5cfd7e54c0fe39e2b489671a8bc99aef7b
	
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
						//mapaCombate.setCeldaMapa(x, y, null);
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
		if (toReturn)
			activarMagia_Campo();
		return toReturn;
  }


	public boolean comprarPared (int x, int y) {
		boolean toReturn = false;
		Celda c = mapaCombate.getCelda(x, y);	
		if (monedas >= 50 ) {
			if (c.getElemento() == null) {
				toReturn = true;
				fabricaObjetoVidaComprar = new ParedFactory(panelMapa);
				listaObjetosComprarVida.addLast(fabricaObjetoVidaComprar.createObjeto(c));	
				monedas -=50;
				gui.setMonedasGUI(monedas);
			}
		}
	 return toReturn;
	}
	
	
	public boolean comprarRobot(int x, int y) {
		boolean toReturn = false;
		Celda c = mapaCombate.getCelda(x, y);	
		if (monedas >= 50 ) {
			if (c.getElemento() == null) {
				toReturn = true;
				fabricaObjetoVidaComprar = new FactoryRobot(panelMapa);
				listaObjetosComprarVida.addLast(fabricaObjetoVidaComprar.createObjeto(c));	
				monedas -=200;
				gui.setMonedasGUI(monedas);
			}
		}
	 return toReturn;
	}
	
	
	public boolean comprarTanque (int x, int y) {
		boolean toReturn = false;
		Celda c = mapaCombate.getCelda(x, y);	
		if (monedas >= 100 ) {
			if (c.getElemento() == null) {
				toReturn = true;
				fabricaObjetoTemporales = new TanqueFactory(panelMapa);
				listaObjetosTemporales.addLast(fabricaObjetoTemporales.createObjetoTemporal(c));	
				monedas -=100;
				gui.setMonedasGUI(monedas);
				HiloActivarObjetoTemporal h = new HiloActivarObjetoTemporal (this,listaObjetosTemporales.getLast());
				h.start();
				
			}
		}
	 return toReturn;
	}
	
	
	public boolean puedeComprar(ObjetoTemporal o) {
	   return (o.getPrecio() > monedas);
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
	
	public int getMonedas () {
		return monedas;
	}
	
	public int getPuntos () {
		return puntos;
	}
	
<<<<<<< HEAD
=======
	public Mapa_GUI2 getGui () {
		return gui;
	}
	
	public void accionMagia (int x, int y) {
		
		Celda c = mapaCombate.getCelda(x,y);
		System.out.println(c.getElemento()+" acicona magia");
		VisitorPremio v = new VisitorPremio (this);
		if (c.getElemento()!=null) {
			c.getElemento().accept(v);
			
		}
		
	}
	
>>>>>>> 9f2c3c5cfd7e54c0fe39e2b489671a8bc99aef7b
}
