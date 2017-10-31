package Principal;

import java.awt.*;
import javax.swing.*;

public class SplashScreen extends JWindow 
{
	private int duration;
	
	public SplashScreen(int d) 
	{
		duration = d;
	}

	/**
	 * Crea instancia de la clase. No recibe parámetros. Inicializa los atributos.
	 */
	public void showSplash() 
	{
		JPanel panel=new JPanel();
		getContentPane().setLayout(null);
		getContentPane().add(panel);
		JLabel label = new JLabel();
		this.setBounds(300,100, 1600, 800);
		panel.setBounds(-20, -30, 1500, 700);
		panel.add(label);
		label.setIcon(new ImageIcon(getClass().getResource("/Sprites/FondosYmenus/ImagenInicioJuego.gif")));
		label.setBounds(0,0,1000,1000);
		setVisible(true);
		
		try 
		{ 
			Thread.sleep(duration);
		}
		catch (Exception e) {}
		
		setVisible(false);
		
		 
	}
	
	/**
	 * Método que muestra el SplaashScreen
	 */
	public void showSplashAndExit() 
	{
		showSplash();	
	}

}

