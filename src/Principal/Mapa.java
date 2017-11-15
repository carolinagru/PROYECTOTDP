package Principal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Disparo.Bala;
import Factory.A1factory;
import Factory.AlienFactoryMethod;
import Factory.BalaSoldadoFactory;
import Factory.BalasFactoryMethod;
import Objetos.ObjetoAgua;
import Objetos.ObjetoFuego;
import Objetos.ObjetoFuente;
import Objetos.ObjetoPiedra;
import Objetos.Obstaculo;
import Personajes.Alien;
import Personajes.Personaje;

public class Mapa {
	private Celda mapa[][];
	private int columnas, filas;
	protected LinkedList<Obstaculo> objetosMapa;
	protected Obstaculo obs;
	protected JPanel panel;

	public Mapa(int f, int c, JPanel p){
		this.filas = f;
		this.columnas = c;
		panel = p;
		this.mapa = new Celda[filas][columnas];
		
		for(int i = 0; i < filas; i++){
			for(int j = 0; j < columnas; j++){
				this.mapa[i][j] = new Celda( i, j);
				this.mapa[i][j].setElemento(null);
			}
		}
		objetosMapa= new LinkedList();
	}
	
	public Celda getCelda(int x, int y){
		if((x < this.filas) && (x >= 0) && (y < this.columnas) && (y >= 0))
			return this.mapa[x][y];
		return null;
	}
	
	public Celda[][] getMapa() {
		return mapa;
	}

	public int getColumna() {
		return columnas;
	}

	public int getFila() {
		return filas;
	}
	
	public void setCeldaMapa(int x , int y , Obstaculo o) {
		mapa[x][y].setElemento(o);
	}
	
	public void insertarObjetos() {
		 try {	
			FileReader f = new FileReader(getClass().getResource("/Archivos/mapa1.txt").getFile());
	        BufferedReader b = new BufferedReader(f);
	        String cadena = "";
	        char d;
	        int y = 0;
	        
	        	while ((cadena = b.readLine()) != null) {
	        		int x = 0;
		        	for (int i = 0; i < cadena.length(); i++){
		      		   d = cadena.charAt(i);
		      		   Celda c = getCelda(y,x);
		                if (d == 'f')
		                  obs= new ObjetoFuego(c);
		                	else if (d == 'a')
		                	   obs=new ObjetoAgua(c);
		                	      else if(d == 'u')
		                		       obs= new ObjetoFuente(c);
		                		       else if(d == 'p')
		                				     obs= new ObjetoPiedra(c);
		             if (obs != null){
		            	 objetosMapa.addLast(obs); 
		            	 obs.getCelda().setElemento(obs);
		            	 insertar(obs.getGrafico(0));
		             }
		             obs=null;
		             x++; 
		          }
		          y++;
		        }
		        
		 b.close();
	 }
   catch (IOException e) {
	 System.out.println("Error en objeto - leerArchivo. ");
   }	 
}
	
	public void insertar(JLabel l) {
		panel.add(l);
		panel.repaint();
	}
	
	public Alien insertarEnemigo(AlienFactoryMethod factory) {
		Random r = new Random();
		int x = (int ) (Math.random() * 5);
		Celda c = getCelda(x,11);
		while (c.getElemento() != null) {
			x = (int ) (Math.random() * 5);
			c = getCelda(x,11);
		}
		factory = new A1factory(panel);
		Alien p = factory.createPersonaje(c);
		
	  return p;
	}
	
	public Bala insertarBalasMapa(BalasFactoryMethod factory,Celda c, Personaje p) {
		factory = new BalaSoldadoFactory(panel);
		Bala b = factory.crearBalas(c, p);
		return b;
	}

	public Celda siguienteCeldaIzq(Celda c) {
		int col = c.getColumna()-1;		
		return getCelda(c.getFila(),col);
	}
	
	public Celda siguienteCeldaDer(Celda c) {
		int col = c.getColumna()+1;		
		return getCelda(c.getFila(),col);
	}
	
	public void eliminar(Obstaculo o) {
		o.getCelda().setElemento(null);
		panel.remove(o.getGrafico(2));
		panel.revalidate();
		panel.repaint();
	}

	public LinkedList<Obstaculo> getLista() {
		return objetosMapa;
	}
}

