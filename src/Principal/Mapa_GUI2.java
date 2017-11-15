package Principal;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import javax.swing.AbstractAction;
import javax.swing.Action;


public class Mapa_GUI2 extends JFrame {
	
	private Logica logica;
	private JPanel contentPane;
	private Image image;
	private Image image2;
	private Image image3;
	private Image image4;
	private ImageIcon imagenBoton;
	private Icon iconoBoton;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3; 
	private final Action action = new SwingAction();
	/**
	 * Launch the application.
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					SplashScreen splash = new SplashScreen(2000);
					splash.showSplash();
					Mapa_GUI2 frame = new Mapa_GUI2();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 */
	/**
	 * Create the frame.
	 */
	public Mapa_GUI2() {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1350, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// P A N E L E S --------------------------------------------------------------------------------------------------------------------------------------------------------------
		image4 = new ImageIcon(getClass().getResource("/Sprites/fondo/botoneraArriba.png")).getImage();
		panel = new JPanel(){
			public void paint(Graphics g){
				g.drawImage(image4, 0, 0, panel.getWidth(), panel.getHeight(), this);
				setOpaque(false);
				super.paint(g);
			}
		};
		panel.setBorder(null);
		panel.setBounds(334, 11, 1000, 76);
		contentPane.add(panel);
		panel.setLayout(null);
		
		image2 = new ImageIcon(getClass().getResource("/Sprites/fondo/baseMapa.png")).getImage();
		panel_1 = new JPanel() {
			public void paint(Graphics g){
		        g.drawImage(image2, 0, 0, panel_1.getWidth(), panel_1.getHeight(), this);
		        setOpaque(false);
		        super.paint(g);
		    }
		};
		panel_1.setLayout(null);
		panel_1.setBorder(null);
		panel_1.setBounds(10, 11, 325, 649);
		contentPane.add(panel_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 11, 305, 62);
		panel_4.setOpaque(false);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		
		/**
		 * Etiqueta de puntaje-------------------------------------------------------------------------------------------------------
		 */
		JLabel label = new JLabel();
		label.setBounds(0, 11, 150, 40);
		ImageIcon imagen = new ImageIcon(getClass().getResource("/Sprites/FondosYmenus/puntaje.png"));
		Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(icono); 
		panel_4.add(label);
		JLabel label_1 = new JLabel();
		label_1.setBounds(151, 0, 154, 62);
		panel_4.add(label_1);
		/**
		 * --------------------------------------------------------------------------------------------------------------------------
		 */
		
		image3 = new ImageIcon(getClass().getResource("/Sprites/fondo/botoneraBajo.png")).getImage();
		panel_2 = new JPanel(){
			public void paint(Graphics g){
				g.drawImage(image3, 0, 0, panel_2.getWidth(), panel_2.getHeight(), this);
				setOpaque(false);
				super.paint(g);
			}
		};
		panel_2.setBorder(null);
		panel_2.setBounds(334, 584, 1000, 76);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		image = new ImageIcon(getClass().getResource("/Sprites/fondo/piso.png")).getImage();

		panel_3 = new JPanel() {
		public void paint(Graphics g){
	        g.drawImage(image, 0, 0, panel_3.getWidth(), panel_3.getHeight(), this);
	        setOpaque(false);
	        super.paint(g);
	    }
		};
		panel_3.setLayout(null);
		panel_3.setBorder(null);
		panel_3.setBounds(334, 84, 1000, 500);
		contentPane.add(panel_3);
		
		logica = new Logica (panel_3);
		 //l.setPanel(panel_3);
		//Hilos h = new Hilos(logica);
		//h.run();

		
		// B O T O N E S     O B J E T O S--------------------------------------------------------------------------------------------------------------------------------------------------------------
		JButton botonObjeto1 = new JButton();
		botonObjeto1.setBounds(24, 11, 267, 54);
		botonObjeto1.setContentAreaFilled(false);
		imagenBoton = new ImageIcon(Mapa_GUI2.class.getResource("/Sprites/botones/boton.png"));
		iconoBoton = new ImageIcon(imagenBoton.getImage().getScaledInstance(botonObjeto1.getWidth(), botonObjeto1.getHeight(), Image.SCALE_SMOOTH));
		botonObjeto1.setIcon(iconoBoton);
		panel.add(botonObjeto1);
		botonObjeto1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		
		JButton botonObjeto2 = new JButton();
		botonObjeto2.setBounds(363, 11, 267, 54);
		botonObjeto2.setContentAreaFilled(false);
		imagenBoton = new ImageIcon(Mapa_GUI2.class.getResource("/Sprites/botones/boton.png"));
		iconoBoton = new ImageIcon(imagenBoton.getImage().getScaledInstance(botonObjeto2.getWidth(), botonObjeto2.getHeight(), Image.SCALE_SMOOTH));
		botonObjeto2.setIcon(iconoBoton);
		panel.add(botonObjeto2);
		botonObjeto2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton botonObjeto3 = new JButton();
		botonObjeto3.setBounds(700, 11, 267, 54);
		botonObjeto3.setContentAreaFilled(false);
		imagenBoton = new ImageIcon(Mapa_GUI2.class.getResource("/Sprites/botones/boton.png"));
		iconoBoton = new ImageIcon(imagenBoton.getImage().getScaledInstance(botonObjeto3.getWidth(), botonObjeto3.getHeight(), Image.SCALE_SMOOTH));
		botonObjeto3.setIcon(iconoBoton);
		panel.add(botonObjeto3);
		botonObjeto3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		// B O T O N E S    S O L D A D O S--------------------------------------------------------------------------------------------------------------------------------------------------------------

		JButton botonSoldado1 = new JButton();
		botonSoldado1.setBounds(10, 0, 106, 76);
		botonSoldado1.setBackground(Color.WHITE);
		imagenBoton = new ImageIcon(Mapa_GUI2.class.getResource("/Sprites/botones/botSold1.png"));
		iconoBoton = new ImageIcon(imagenBoton.getImage().getScaledInstance(botonSoldado1.getWidth(), botonSoldado1.getHeight(), Image.SCALE_SMOOTH));
		botonSoldado1.setIcon(iconoBoton);
		panel_2.add(botonSoldado1);
		ActionListener a1 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			panel_3.addMouseListener(new java.awt.event.MouseAdapter() {
				boolean estadoBoton1 = true;
				public void mousePressed(MouseEvent e) {
					if (estadoBoton1) {
						int x=e.getX() ;
						int y=e.getY() ;
						int filas = y / 80;
						int columnas = x  / 80;
					  if (!logica.crearS1(filas,columnas)) {
						  System.out.println("No pudo comprar jugador 1 ");
					  }
					  estadoBoton1 = false;
					}

				}});
		}};
		botonSoldado1.addActionListener(a1);
		
		JButton botonSoldado2 = new JButton();
		botonSoldado2.setBounds(152, 0, 106, 76);
		botonSoldado2.setBackground(Color.WHITE);
		imagenBoton = new ImageIcon(Mapa_GUI2.class.getResource("/Sprites/botones/botSold2.png"));
		iconoBoton = new ImageIcon(imagenBoton.getImage().getScaledInstance(botonSoldado2.getWidth(), botonSoldado2.getHeight(), Image.SCALE_SMOOTH));
		botonSoldado2.setIcon(iconoBoton);
		panel_2.add(botonSoldado2);
		 
		ActionListener a2 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				panel_3.addMouseListener(new java.awt.event.MouseAdapter() {
					boolean estadoBoton2 = true;
					public void mousePressed(MouseEvent e) {
						if (estadoBoton2) {
							int x=e.getX() ;
							int y=e.getY() ;
							int filas = y / 80;
							int columnas = x  / 80;
						  logica.crearS2(filas,columnas);
						  estadoBoton2 = false;
						}

					}});
			}};
		botonSoldado2.addActionListener(a2);
			
			
		JButton botonSoldado3 = new JButton();
		botonSoldado3.setBounds(295, 0, 106, 76);
		botonSoldado3.setBackground(Color.WHITE);
		imagenBoton = new ImageIcon(Mapa_GUI2.class.getResource("/Sprites/botones/botSold3.png"));
		iconoBoton = new ImageIcon(imagenBoton.getImage().getScaledInstance(botonSoldado3.getWidth(), botonSoldado3.getHeight(), Image.SCALE_SMOOTH));
		botonSoldado3.setIcon(iconoBoton);
		panel_2.add(botonSoldado3);
		ActionListener a3 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					panel_3.addMouseListener(new java.awt.event.MouseAdapter() {
						boolean estadoBoton2 = true;
						public void mousePressed(MouseEvent e) {
							if (estadoBoton2) {
								int x=e.getX() ;
								int y=e.getY() ;
								int filas = y / 80;
								int columnas = x  / 80;
							  logica.crearS3(filas,columnas);
							  estadoBoton2 = false;
							}

						}});
				}};
		botonSoldado3.addActionListener(a3);
		
		JButton botonSoldado4 = new JButton();
		botonSoldado4.setBounds(436, 0, 106, 76);
		botonSoldado4.setBackground(Color.WHITE);
		imagenBoton = new ImageIcon(Mapa_GUI2.class.getResource("/Sprites/botones/botSold4.png"));
		iconoBoton = new ImageIcon(imagenBoton.getImage().getScaledInstance(botonSoldado4.getWidth(), botonSoldado4.getHeight(), Image.SCALE_SMOOTH));
		botonSoldado4.setIcon(iconoBoton);
		panel_2.add(botonSoldado4);
		ActionListener a4= new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					panel_3.addMouseListener(new java.awt.event.MouseAdapter() {
						boolean estadoBoton2 = true;
						public void mousePressed(MouseEvent e) {
							if (estadoBoton2) {
								int x=e.getX() ;
								int y=e.getY() ;
								int filas = y / 80;
								int columnas = x  / 80;
							  logica.crearS4(filas,columnas);
							  estadoBoton2 = false;
							}

						}});
				}};
		botonSoldado4.addActionListener(a4);
		
		
		JButton botonSoldado5 = new JButton();
		botonSoldado5.setBounds(573, 0, 106, 76);
		botonSoldado5.setBackground(Color.WHITE);
		botonSoldado5.setContentAreaFilled(false);
		imagenBoton = new ImageIcon(Mapa_GUI2.class.getResource("/Sprites/botones/botSold5.png"));
		iconoBoton = new ImageIcon(imagenBoton.getImage().getScaledInstance(botonSoldado5.getWidth(), botonSoldado5.getHeight(), Image.SCALE_SMOOTH));
		botonSoldado5.setIcon(iconoBoton);
		panel_2.add(botonSoldado5);
		ActionListener a5 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					panel_3.addMouseListener(new java.awt.event.MouseAdapter() {
						boolean estadoBoton2 = true;
						public void mousePressed(MouseEvent e) {
							if (estadoBoton2) {
								int x=e.getX() ;
								int y=e.getY() ;
								int filas = y / 80;
								int columnas = x  / 80;
							  logica.crearS5(filas,columnas);
							  estadoBoton2 = false;
							}

						}});
				}};
		botonSoldado5.addActionListener(a5);
		
		// B O T O N BORRAR
			JButton botonBorrar = new JButton();
			botonBorrar.setAction(action);
			botonBorrar.setBounds(689, 0, 301, 76);
			botonBorrar.setContentAreaFilled(false);
			imagenBoton = new ImageIcon(Mapa_GUI2.class.getResource("/Sprites/botones/botonBorrar.png"));
			iconoBoton = new ImageIcon(imagenBoton.getImage().getScaledInstance(botonBorrar.getWidth(), botonBorrar.getHeight(), Image.SCALE_SMOOTH));
			botonBorrar.setIcon(iconoBoton);
			panel_2.add(botonBorrar);
				botonBorrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panel_3.addMouseListener(new java.awt.event.MouseAdapter() {
							boolean estadoBoton = true;
							public void mousePressed(MouseEvent e) {
								if ( estadoBoton) {
									estadoBoton = false;
									int x=e.getX() ;
									int y=e.getY() ;
									int filas = y / 80;
									int columnas = x  / 80;
									if (logica.verificarPosicion(filas, columnas)) {
										
										System.out.println("Encontre soldado a eliminar y elimino ");
									}
									
								}
							 
							}});
					}});
		
				this.setVisible(true);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	public Logica dameLogica() {
		return logica;
	}
}