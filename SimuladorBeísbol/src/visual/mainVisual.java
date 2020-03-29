package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Equipo;
import logico.Liga;
import logico.Season;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class mainVisual extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelPrincipal;
	private Dimension dim = null;
	private static Season miSeason;
	/**
	 * 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainVisual frame = new mainVisual();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public mainVisual() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Liga.getInstance().guardarDatos(Liga.getInstance());
			}
		});
	

		setTitle("Simulador de Be\u00EDsbol");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 557);
		dim = super.getToolkit().getScreenSize();
		super.setSize(dim.width, (dim.height-50));
		setLocationRelativeTo(null);
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(Color.WHITE);
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);
		Liga.getInstance().cargarLiga(Liga.getInstance());

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 132, 1330, 536);
		panelPrincipal.add(panel);
		panel.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(10, -141, 1468, 803);
		lblLogo.setBackground(Color.WHITE);
		lblLogo.setIcon(new ImageIcon(mainVisual.class.getResource("/Imagenes/5391__major_league_baseball-alternate-2019-1.jpg")));
		panel.add(lblLogo);
		
		JButton button = new JButton("Jugadores");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jugador misJugadores = new Jugador();
				misJugadores.setModal(true);
				misJugadores.setVisible(true);
			}
		});
		button.setBounds(10, 36, 151, 85);
		panelPrincipal.add(button);
		
		JButton button_1 = new JButton("New button");
		button_1.setBounds(179, 36, 151, 85);
		panelPrincipal.add(button_1);
		
		JButton btnRegEquipos = new JButton("Registrar\r\n Equipos");
		btnRegEquipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarEquipo equipo1 = new RegistrarEquipo();
				equipo1.setModal(true);
				equipo1.setVisible(true);
			}
		});
		btnRegEquipos.setBounds(346, 36, 151, 85);
		panelPrincipal.add(btnRegEquipos);
		
		JButton btnVerEquipos = new JButton("Equipos");
		btnVerEquipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarEquipos listar1 = new ListarEquipos();
				listar1.setModal(true);
				listar1.setVisible(true);
			}
		});
		btnVerEquipos.setBounds(515, 36, 151, 85);
		panelPrincipal.add(btnVerEquipos);
	}


}



