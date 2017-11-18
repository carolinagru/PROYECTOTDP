package Principal;



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
 
import java.awt.Color;
 
import java.awt.Image;

 
import java.awt.Font;
import java.awt.Graphics;

 
import javax.swing.SwingConstants;


public class Mapa_GUI2 extends JFrame {
	
	//private cambiarGUI c;
	private Logica logica;
	protected JPanel contentPane;
	protected Image image;
	protected Image image2;
	protected Image image3;
	protected Image image4;
	private ImageIcon imagenBotonGuardarBomba;
	private ImageIcon imagenBotonGuardarFuerza;
	private ImageIcon imagenBotonGuardarCampo;
	private ImageIcon imagenBotonSalirJuego;
	private ImageIcon imagenBotonPunio;
	private ImageIcon imagenBotonFuerza;
	private ImageIcon imagenTanque;
	private ImageIcon imagenCampo;
	private ImageIcon imagenBoton;
	private ImageIcon imagenBomba;
	private Icon iconoBotonGuardarBomba;
	private Icon iconoBotonGuardarFuerza;
	private Icon iconoBotonGuardarCampo;
	private Icon iconoBotonSalirJuego;
	private Icon iconoBotonFuerza;
	private Icon iconoBotonPunio;
	private Icon iconoBomba;
	private Icon iconoTanque;
	private Icon iconoCampo;
	private Icon iconoBoton;
	protected JPanel panel;
	protected JPanel panel_1;
	protected JPanel panel_2;
	protected JPanel panel_3;
	protected JLabel lblMonedas = new JLabel("0");
	protected  JLabel lblPuntaje = new JLabel("0");
	private int cantFuerza = 0;
	private int cantCampo = 0;

	
	public void iniciar() {
		try {
			Mapa_GUI2 frame = new Mapa_GUI2();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}

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
		
		JButton botonTanque = new JButton("");
		botonTanque.setBounds(10, 0, 151, 76);
		imagenTanque = new ImageIcon(Mapa_GUI2.class.getResource("/Sprites/botones/botonTanque.png"));
		iconoTanque = new ImageIcon(imagenTanque.getImage().getScaledInstance(botonTanque.getWidth(), botonTanque.getHeight(), Image.SCALE_SMOOTH));
		botonTanque.setIcon(iconoTanque);
		panel.add(botonTanque);
		ActionListener a51 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_3.addMouseListener(new java.awt.event.MouseAdapter() {
					boolean estadoBoton1 = true;
					public void mousePressed(MouseEvent e) {
						if (estadoBoton1) {
							int x=e.getX() ;
							int y=e.getY() ;
							int filas = y / 80;
							int columnas = x  / 80;
							if (!logica.comprarTanque(filas,columnas)) {
								System.out.println("No pudo comprar jugador 1 ");
							}
						  estadoBoton1 = false;
						}

					}});
			}};
			botonTanque.addActionListener(a51);
		
		
		
		
		JButton botonCampo = new JButton("");		 
		botonCampo.setBounds(186, 0, 151, 76);
		imagenCampo = new ImageIcon(Mapa_GUI2.class.getResource("/Sprites/botones/botonCampo.png"));
		iconoCampo = new ImageIcon(imagenCampo.getImage().getScaledInstance(botonTanque.getWidth(), botonTanque.getHeight(), Image.SCALE_SMOOTH));
		botonCampo.setIcon(iconoCampo);
		panel.add(botonCampo);
		ActionListener a5 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_3.addMouseListener(new java.awt.event.MouseAdapter() {
					boolean estadoBoton1 = true;
					public void mousePressed(MouseEvent e) {
						if (estadoBoton1) {
							int x=e.getX() ;
							int y=e.getY() ;
							int filas = y / 80;
							int columnas = x  / 80;
							if (!logica.comprarPared(filas,columnas)) {
								System.out.println("No pudo comprar jugador 1 ");
							}
						  estadoBoton1 = false;
						}

					}});
			}};
			botonCampo.addActionListener(a5);
	 


			
			
			
			
			
		
		JButton botonRobot = new JButton("");
		 
			botonRobot.setBounds(365, 0, 151, 76);
		imagenBomba = new ImageIcon(Mapa_GUI2.class.getResource("/Sprites/botones/botonBomba.png"));
		iconoBomba = new ImageIcon(imagenBomba.getImage().getScaledInstance(botonRobot.getWidth(), botonRobot.getHeight(), Image.SCALE_SMOOTH));
		botonRobot.setIcon(iconoBomba);
		panel.add(botonRobot);
		ActionListener a52 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_3.addMouseListener(new java.awt.event.MouseAdapter() {
					boolean estadoBoton1 = true;
					public void mousePressed(MouseEvent e) {
						if (estadoBoton1) {
							int x=e.getX() ;
							int y=e.getY() ;
							int filas = y / 80;
							int columnas = x  / 80;
							if (!logica.comprarRobot(filas,columnas)) {
								System.out.println("No pudo comprar jugador 1 ");
							}
						  estadoBoton1 = false;
						}

					}});
			}};
			botonRobot.addActionListener(a52);
		
		
		
		
		
		
		
		
		
		JButton button_2 = new JButton("");
		button_2.setBounds(809, 11, 181, 54);
		imagenBotonSalirJuego = new ImageIcon(getClass().getResource("/Sprites/botones/botonSalirJuego.png"));
		iconoBotonSalirJuego = new ImageIcon(imagenBotonSalirJuego.getImage().getScaledInstance(button_2.getWidth(), button_2.getHeight(), Image.SCALE_SMOOTH));
		button_2.setIcon(iconoBotonSalirJuego);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel.add(button_2);
		
		image2 = new ImageIcon(getClass().getResource("/Sprites/fondo/baseMapa.png")).getImage();
		panel_1 = new JPanel() {
			public void paint(Graphics g){
		        g.drawImage(image2, 0, 0, panel_1.getWidth(), panel_1.getHeight(), this);
		        setOpaque(false);
		        super.paint(g);
		    }
		};
		panel_1.setBorder(null);
		panel_1.setBounds(10, 11, 325, 649);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		
		JLabel lblCantFuerza = new JLabel("0");
		lblCantFuerza.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCantFuerza.setEnabled(false);
		lblCantFuerza.setBounds(10, 455, 46, 14);
		panel_1.add(lblCantFuerza);
		
		JLabel lblCantCampo = new JLabel("0");
		lblCantCampo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCantCampo.setBounds(166, 455, 46, 14);
		panel_1.add(lblCantCampo);
		
		//------- Boton activar campo
		JButton button = new JButton();
		button.setBounds(106, 480, 106, 90);
		imagenBotonPunio = new ImageIcon(getClass().getResource("/Sprites/botones/botonPuño.jpg"));
		iconoBotonPunio = new ImageIcon(imagenBotonPunio.getImage().getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_SMOOTH));
		button.setIcon(iconoBotonPunio);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cantCampo > 0) {
					System.out.println("Puede activar fuerza");
					cantCampo--;
					lblCantCampo.setText(""+cantCampo);
					logica.activarMagia_Campo();
				}
			}
		});
		panel_1.add(button);
		
		
		// ------ Boton guardar Fuerza
		JButton button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cantFuerza > 0) {
					System.out.println("Puede activar fuerza");
					cantFuerza--;
					lblCantFuerza.setText(""+cantFuerza);
					logica.activarMagia_Fuerza();
				}
			}
		});
		button_1.setBounds(0, 480, 106, 90);
		imagenBotonFuerza = new ImageIcon(getClass().getResource("/Sprites/botones/botonFuerza.jpg"));
		iconoBotonFuerza = new ImageIcon(imagenBotonFuerza.getImage().getScaledInstance(button_1.getWidth(), button_1.getHeight(), Image.SCALE_SMOOTH));
		button_1.setIcon(iconoBotonFuerza);
		panel_1.add(button_1);
		 
	
		
		
		
		
		
		
		
		JButton button_3 = new JButton("");
		button_3.setBounds(0, 571, 106, 78);
		imagenBotonGuardarFuerza = new ImageIcon(getClass().getResource("/Sprites/botones/botonGuardarFuerza.png"));
		iconoBotonGuardarFuerza = new ImageIcon(imagenBotonGuardarFuerza.getImage().getScaledInstance(button_3.getWidth(), button_3.getHeight(), Image.SCALE_SMOOTH));
		button_3.setIcon(iconoBotonGuardarFuerza);
		button_3.addActionListener(new ActionListener() {
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
							if (logica.verificarMagiaFuerza(filas, columnas)) {
								cantFuerza++;
								lblCantFuerza.setText(""+cantFuerza);
								System.out.println("Encontre magia a eliminar y elimino ");
							}
							
						}
					 
					}});
			}});
 
		
		
		
		panel_1.add(button_3);
		
		// ---------- Boton guardar campo 
		JButton button_4 = new JButton("");
		button_4.setBounds(106, 571, 106, 78);
		imagenBotonGuardarCampo = new ImageIcon(getClass().getResource("/Sprites/botones/botonGuardarCampo.png"));
		iconoBotonGuardarCampo = new ImageIcon(imagenBotonGuardarCampo.getImage().getScaledInstance(button_4.getWidth(), button_4.getHeight(), Image.SCALE_SMOOTH));
		button_4.setIcon(iconoBotonGuardarCampo);
		button_4.addActionListener(new ActionListener() {
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
							if (logica.verificarMagiaCampo(filas, columnas)) {
								cantCampo++;
								lblCantCampo.setText(""+cantCampo);
								System.out.println("Encontre magia Campo a eliminar y elimino ");
							}
							
						}
					 
					}});
}});
		
		
		 
		
		
		panel_1.add(button_4);
		
		JButton button_5 = new JButton("");
		button_5.setBounds(211, 571, 104, 78);
		imagenBotonGuardarBomba = new ImageIcon(getClass().getResource("/Sprites/botones/botonGuardarBomba.png"));
		iconoBotonGuardarBomba = new ImageIcon(imagenBotonGuardarBomba.getImage().getScaledInstance(button_5.getWidth(), button_5.getHeight(), Image.SCALE_SMOOTH));
		button_5.setIcon(iconoBotonGuardarBomba);
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.add(button_5);
		
		JButton button_6 = new JButton("");
		button_6.setBounds(211, 480, 104, 90);
		panel_1.add(button_6);
		ImageIcon imagen = new ImageIcon(getClass().getResource("/Sprites/FondosYmenus/puntaje.png"));
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
		
		logica = new Logica(panel_3,this);
		imagenBoton = new ImageIcon(Mapa_GUI2.class.getResource("/Sprites/botones/boton.png"));
		imagenBoton = new ImageIcon(Mapa_GUI2.class.getResource("/Sprites/botones/boton.png"));
		imagenBoton = new ImageIcon(Mapa_GUI2.class.getResource("/Sprites/botones/boton.png"));
		
		 
		
		lblPuntaje.setForeground(Color.WHITE);
		lblPuntaje.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPuntaje.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		lblPuntaje.setBounds(148, 27, 156, 24);
		panel_1.add(lblPuntaje);
		
		
		lblMonedas.setForeground(Color.WHITE);
		lblMonedas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMonedas.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		lblMonedas.setBounds(94, 71, 210, 24);
		panel_1.add(lblMonedas);
		
		
		// B O T O N E S    S O L D A D O S--------------------------------------------------------------------------------------------------------------------------------------------------------------

		JButton botonSoldado1 = new JButton();
		botonSoldado1.setBounds(10, 0, 132, 76);
		imagenBoton = new ImageIcon(Mapa_GUI2.class.getResource("/Sprites/botones/botSold1.png"));
		iconoBoton = new ImageIcon(imagenBoton.getImage().getScaledInstance(botonSoldado1.getWidth(), botonSoldado1.getHeight(), Image.SCALE_SMOOTH));
		botonSoldado1.setIcon(iconoBoton);
		botonSoldado1.setOpaque(true);
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
		botonSoldado2.setBounds(143, 0, 132, 76);
		botonSoldado2.setBackground(Color.WHITE);
		imagenBoton = new ImageIcon(Mapa_GUI2.class.getResource("/Sprites/botones/botSold2.png"));
		iconoBoton = new ImageIcon(imagenBoton.getImage().getScaledInstance(botonSoldado2.getWidth(), botonSoldado2.getHeight(), Image.SCALE_SMOOTH));
		botonSoldado2.setIcon(iconoBoton);
		panel_2.add(botonSoldado2);
		ActionListener a23 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					panel_3.addMouseListener(new java.awt.event.MouseAdapter() {
						boolean estadoBoton2 = true;
						public void mousePressed(MouseEvent e) {
							if (estadoBoton2) {
								int x=e.getX() ;
								int y=e.getY() ;
								int filas = y / 80;
								int columnas = x  / 80;
								if (!logica.crearS2(filas,columnas)) {
									System.out.println("No pudo comprar jugador 2 ");
								}
							  estadoBoton2 = false;
							}

						}});
				}};
			botonSoldado2.addActionListener(a23);
		
		JButton botonSoldado3 = new JButton();
		botonSoldado3.setBounds(276, 0, 132, 76);
		botonSoldado3.setBackground(Color.WHITE);
		imagenBoton = new ImageIcon(Mapa_GUI2.class.getResource("/Sprites/botones/botSold3.png"));
		iconoBoton = new ImageIcon(imagenBoton.getImage().getScaledInstance(botonSoldado3.getWidth(), botonSoldado3.getHeight(), Image.SCALE_SMOOTH));
		botonSoldado3.setIcon(iconoBoton);
		panel_2.add(botonSoldado3);
		ActionListener a3 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					panel_3.addMouseListener(new java.awt.event.MouseAdapter() {
						boolean estadoBoton3 = true;
						public void mousePressed(MouseEvent e) {
							if (estadoBoton3) {
								int x=e.getX() ;
								int y=e.getY() ;
								int filas = y / 80;
								int columnas = x  / 80;
								if (!logica.crearS3(filas,columnas)) {
									System.out.println("No pudo comprar jugador 3 ");
								}
							  estadoBoton3 = false;
							}

						}});
				}};
		botonSoldado3.addActionListener(a3);
		
		
		
		
		JButton botonSoldado4 = new JButton();
		botonSoldado4.setBounds(409, 0, 132, 76);
		botonSoldado4.setBackground(Color.WHITE);
		imagenBoton = new ImageIcon(Mapa_GUI2.class.getResource("/Sprites/botones/botSold4.png"));
		iconoBoton = new ImageIcon(imagenBoton.getImage().getScaledInstance(botonSoldado4.getWidth(), botonSoldado4.getHeight(), Image.SCALE_SMOOTH));
		botonSoldado4.setIcon(iconoBoton);
		botonSoldado4.setEnabled(false);
		panel_2.add(botonSoldado4);
		ActionListener a4= new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					panel_3.addMouseListener(new java.awt.event.MouseAdapter() {
						boolean estadoBoton4 = true;
						public void mousePressed(MouseEvent e) {
							if (estadoBoton4) {
								int x=e.getX() ;
								int y=e.getY() ;
								int filas = y / 80;
								int columnas = x  / 80;
								if (!logica.crearS4(filas,columnas)) {
									System.out.println("No pudo comprar jugador 4 ");
								}
							  estadoBoton4 = false;
							}

						}});
				}};
		botonSoldado4.addActionListener(a4);
		
		
		
		
		JButton botonSoldado5 = new JButton();
		botonSoldado5.setBounds(542, 0, 132, 76);
		botonSoldado5.setBackground(Color.WHITE);
		botonSoldado5.setContentAreaFilled(false);
		imagenBoton = new ImageIcon(Mapa_GUI2.class.getResource("/Sprites/botones/botSold5.png"));
		iconoBoton = new ImageIcon(imagenBoton.getImage().getScaledInstance(botonSoldado5.getWidth(), botonSoldado5.getHeight(), Image.SCALE_SMOOTH));
		botonSoldado5.setIcon(iconoBoton);
		botonSoldado5.setEnabled(false);
		panel_2.add(botonSoldado5);
		ActionListener a75 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					panel_3.addMouseListener(new java.awt.event.MouseAdapter() {
						boolean estadoBoton5 = true;
						public void mousePressed(MouseEvent e) {
							if (estadoBoton5) {
								int x=e.getX() ;
								int y=e.getY() ;
								int filas = y / 80;
								int columnas = x  / 80;
								if (!logica.crearS5(filas,columnas)) {
									System.out.println("No pudo comprar jugador 5 ");
								}
								estadoBoton5 = false;
								
							}

						}});
				}};
			botonSoldado5.addActionListener(a75);
		
			
			
			
			JButton botonVender = new JButton();
			botonVender.setBounds(684, 11, 306, 54);
			botonVender.setContentAreaFilled(false);
			imagenBoton = new ImageIcon(Mapa_GUI2.class.getResource("/Sprites/botones/botonVenderSoldado.png"));
			iconoBoton = new ImageIcon(imagenBoton.getImage().getScaledInstance(botonVender.getWidth(), botonVender.getHeight(), Image.SCALE_SMOOTH));
			botonVender.setIcon(iconoBoton);
			panel_2.add(botonVender);
			botonVender.addActionListener(new ActionListener() {
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
			
			
			 
	}
	
	public void setMonedasGUI(int m ) {
		lblMonedas.setText(""+m);
	}
	
	public void setPuntosGUI(int m ) {
		lblPuntaje.setText(""+m);
	}
}