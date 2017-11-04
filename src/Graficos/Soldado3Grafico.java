package Graficos;


import javax.swing.ImageIcon;

public class Soldado3Grafico extends PersonajeGrafico{

	public  Soldado3Grafico(int x, int y) {
			super(x, y);
			
			image = new ImageIcon(this.getClass().getResource("/Sprites/SpriteSoldado/Soldado4Disparando.png"));
		 
	}
	

}
