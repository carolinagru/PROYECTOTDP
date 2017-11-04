package Graficos;


import javax.swing.ImageIcon;

public class Soldado2Grafico extends PersonajeGrafico{

	public  Soldado2Grafico(int x, int y) {
			super(x, y);
			image = new ImageIcon(this.getClass().getResource("/Sprites/Sprite Soldado/GIF's/S2.gif"));
	}
	

	public void actualizarGrafico(int n){		
		 if ( n == 0){
			 
			  ImageIcon aux =  new ImageIcon(this.getClass().getResource("/Sprites/Sprite Soldado/GIF's/muerte1.gif"));
			//  Icon icono = new ImageIcon(aux.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
			  label.setIcon(aux);
			  label.setBounds(pos.y, pos.x, 80, 80);
				
			}

	}
}
