package Graficos;


import javax.swing.ImageIcon;

public class Soldado2Grafico extends PersonajeGrafico{

	public  Soldado2Grafico(int x, int y) {
			super(x, y);
			
			image = new ImageIcon(this.getClass().getResource("/Sprites/SpriteSoldado/Soldado-Disparando-2.png"));
		 
	}
	

}
