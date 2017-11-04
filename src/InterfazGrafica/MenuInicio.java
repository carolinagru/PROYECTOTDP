package InterfazGrafica;

import Principal.*;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuInicio extends JFrame{
	protected Container contenedor = getContentPane();
	protected MenuInicio menu;
	protected PanelImagen panelPrincipal;
	protected JButton botonIniciar;
	protected JButton botonSalir;
	protected ImageIcon imagenBotonIniciar;
	protected ImageIcon imagenBotonSalir;
	protected Icon iconoBotonIniciar;
	protected Icon iconoBotonSalir;
	
	public MenuInicio() {
		menu = this;	
		botonIniciar = new JButton("");
		botonIniciar.setBounds(790, 551, 194, 49);
		imagenBotonIniciar = new ImageIcon(Mapa_GUI2.class.getResource("/Sprites/botones/botonJugar.png"));
		iconoBotonIniciar = new ImageIcon(imagenBotonIniciar.getImage().getScaledInstance(botonIniciar.getWidth(), botonIniciar.getHeight(), Image.SCALE_SMOOTH));
		botonIniciar.setIcon(iconoBotonIniciar);
		
		botonSalir = new JButton("");
		botonSalir.setBounds(790, 611, 194, 49);
		imagenBotonSalir = new ImageIcon(Mapa_GUI2.class.getResource("/Sprites/botones/botonSalir.png"));
		iconoBotonSalir = new ImageIcon(imagenBotonSalir.getImage().getScaledInstance(botonSalir.getWidth(), botonSalir.getHeight(), Image.SCALE_SMOOTH));
		botonSalir.setIcon(iconoBotonSalir);
		iniciar();
	}
	
	public void iniciar() {
		this.setTitle("Proyecto Policias vs Aliens");
		this.setIconImage(new ImageIcon(getClass().getResource("/Sprites/fondo/IconoMenu.jpg")).getImage());
		this.setResizable(false);
		
		panelPrincipal = new PanelImagen();
		panelPrincipal.setLayout(null);
		setBounds(100,30,1000,700);
		setVisible(true);
		contenedor.add(panelPrincipal);
		
		botonIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Mapa_GUI2 imagenPanelPrincipal = new Mapa_GUI2();
				imagenPanelPrincipal.iniciar();
				setVisible(false);
			}
		});
		panelPrincipal.add(botonIniciar);
		
		botonSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
		});
		panelPrincipal.add(botonSalir);
		
	}
}