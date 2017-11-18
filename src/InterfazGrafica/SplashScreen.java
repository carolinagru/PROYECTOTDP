package InterfazGrafica;

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
	 * Crea instancia de la clase. No recibe par�metros. Inicializa los atributos.
	 */
	public void showSplash() 
	{
		JPanel panel=new JPanel();
		getContentPane().setLayout(null);
		getContentPane().add(panel);
		JLabel label = new JLabel();
		this.setBounds(300,100, 980, 620);
		panel.setBounds(-20, -30, 1000, 720);
		panel.add(label);
		label.setIcon(new ImageIcon(getClass().getResource("/Sprites/fondo/ImagenMenu.gif")));
		label.setBounds(0,0,1100,1100);
		setVisible(true);
		
		try 
		{ 
			Thread.sleep(duration);
		}
		catch (Exception e) {}
		
		setVisible(false);
		
		 
	}
	
	/**
	 * M�todo que muestra el SplaashScreen
	 */
	public void showSplashAndExit() 
	{
		showSplash();	
	}

}