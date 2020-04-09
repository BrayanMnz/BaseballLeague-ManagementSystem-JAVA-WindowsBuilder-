package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Equipo;
import logico.Jugador;
import logico.Liga;
import logico.Partido;
import logico.User;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JTextPane;
import java.awt.Toolkit;

public class mainVisual extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelPrincipal;
	private Dimension dim = null;
	private JTable tablePartidosHoy; 
	private static DefaultTableModel model; 
	private static Object[] fila; 
	private static DefaultTableModel model1; 
	private static Object[] fila1; 
	private static int index;
	private static int indice;
	private static String auxIDPartido;
	private static JButton btnReprogramar;
	private static JButton btnIniciarPartido;
	private JMenu mnJugador;
	private JMenu mnEquipos;
	private JMenu mnPartido;
	private JMenu mnUsuarios;
	private JMenuItem menuitemRegEquipos;
	private static JTable tblPartidos;
	private static JButton btnEliminar;


	//private static Season miSeason;
	/**
	 * 
	 * Launch the application.
	 */

/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainVisual frame = new mainVisual(user);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} */


	 
	public mainVisual(User userLog) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(mainVisual.class.getResource("/Imagenes/baseball_ball_128px.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Liga.getInstance().guardarDatos(Liga.getInstance());
			}
			@Override
			public void windowOpened(WindowEvent e) {
		
			cargarPartidosHoy();
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
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(UIManager.getColor("Button.background"));
		menuBar.setBounds(0, 0, 1350, 22);
		panelPrincipal.add(menuBar);
		
		mnEquipos = new JMenu("Equipos");
		mnEquipos.setForeground(Color.BLACK);
		mnEquipos.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnEquipos);
		

		
		
		menuitemRegEquipos = new JMenuItem("Registrar Equipos");
		menuitemRegEquipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (userLog.getTipo() == 0) {
					RegistrarEquipo equipo1 = new RegistrarEquipo();
					equipo1.setModal(true);
					equipo1.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Usted no es el administrador", "Error", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		mnEquipos.add(menuitemRegEquipos);
		
		JMenuItem mntmListarEquipos = new JMenuItem("Listar Equipos");
		mntmListarEquipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (userLog.getTipo() == 0) {

					ListarEquipos listar1 = new ListarEquipos();
					listar1.setModal(true);
					listar1.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Usted no es el administrador", "Error", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		mnEquipos.add(mntmListarEquipos);
		
		mnJugador = new JMenu("Jugadores");
		mnJugador.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnJugador.setForeground(Color.BLACK);
		menuBar.add(mnJugador);
		
		JMenuItem mntmRegistrarJugador = new JMenuItem("Registrar Jugadores");
		mntmRegistrarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (userLog.getTipo() == 0) {

					 ManejarJugador j1 = new ManejarJugador();
					  j1.setLocationRelativeTo(null);
					  j1.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Usted no es el administrador", "Error", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		mnJugador.add(mntmRegistrarJugador);
		
		JMenuItem mntmListarJugadores = new JMenuItem("Listar Jugadores");
		mnJugador.add(mntmListarJugadores);
		
		mnPartido = new JMenu("Partido");
		mnPartido.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnPartido.setForeground(Color.BLACK);
		menuBar.add(mnPartido);
		
		JMenuItem mntmProgramarPartido = new JMenuItem("Programar Partidos");
		mntmProgramarPartido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (userLog.getTipo() == 0) {

					ProgramarPartido p1 = new ProgramarPartido ();
					p1.setVisible(true);
					p1.setModal(true);
					p1.setLocationRelativeTo(null);
				}
				else {
					JOptionPane.showMessageDialog(null, "Usted no es el administrador", "Error", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		mnPartido.add(mntmProgramarPartido);
		
		mnUsuarios = new JMenu("Gestion de Usuarios");
		mnUsuarios.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnUsuarios.setForeground(Color.BLACK);
		menuBar.add(mnUsuarios);
		
		JMenuItem mntmAnotador = new JMenuItem("Ingresar Anotadores");
		mntmAnotador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (userLog.getTipo() == 0) {

					regUser anotador = new regUser();
					anotador.setVisible(true);
					anotador.setModal(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Usted no es el administrador", "Error", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		mnUsuarios.add(mntmAnotador);
		
		JMenu mnNewMenu = new JMenu("Posiciones");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu.setForeground(Color.BLACK);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Partidos Ganados");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GraficoTeams g1 = new GraficoTeams();
				g1.setVisible(true);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 22, 1350, 657);
		panelPrincipal.add(panel);
		panel.setOpaque(false);
		panel.setLayout(null);
		
		JPanel panelPartidos = new JPanel();
		panelPartidos.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Calendario de Partidos", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelPartidos.setBounds(36, 11, 552, 326);
		panel.add(panelPartidos);
		panelPartidos.setLayout(null);
		panelPartidos.setOpaque(false); 
		
		JScrollPane scrollPartidosHoy = new JScrollPane();
		scrollPartidosHoy.setBounds(10, 25, 532, 122);
		panelPartidos.add(scrollPartidosHoy);
		
		tablePartidosHoy = new JTable();
		model = new DefaultTableModel();
		String[] columnNames = {"ID Partido","Local", "Visitante", "Estadio", "Hora","Fecha"};
		model.setColumnIdentifiers(columnNames);
		tablePartidosHoy.setModel(model);
		tablePartidosHoy.setOpaque(false);
		tablePartidosHoy.setBorder(new CompoundBorder());
		scrollPartidosHoy.setViewportView(tablePartidosHoy);
		
	
	
		
		btnIniciarPartido = new JButton("Iniciar Partido");
		btnIniciarPartido.setEnabled(false);
		btnIniciarPartido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  Date date = Calendar.getInstance().getTime();  
			        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
			        String strDate = dateFormat.format(date);
				if(Liga.getInstance().buscarPartidoById(auxIDPartido).getFecha().equalsIgnoreCase(strDate))
				{ 
				
				LineupPartido p1 = new LineupPartido(auxIDPartido);
				
				p1.setLocationRelativeTo(null);
				p1.setModal(true);
				p1.setVisible(true);} 
				else { 
 JOptionPane.showMessageDialog(null, "Debe esperar la fecha del partido para iniciarlo!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
					 
					
				}
			}
		});
		btnIniciarPartido.setBounds(414, 292, 128, 23);
		panelPartidos.add(btnIniciarPartido);
		
		btnReprogramar = new JButton("Reprogramar Partido");
		btnReprogramar.setEnabled(false);
		btnReprogramar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 for (Partido auxPartido : Liga.getInstance().getMisPartidos()) {
					if(auxIDPartido.equalsIgnoreCase(auxPartido.getIdPartido())) { 
						int option = JOptionPane.showConfirmDialog(null, "Está seguro que desea reprogramar este partido? " ,"Información",JOptionPane.WARNING_MESSAGE);
						if(option == JOptionPane.OK_OPTION) {  
							ModificarPartido p1 = new ModificarPartido(auxPartido.getIdPartido());
							Liga.getInstance().EliminarPartido(auxPartido);
							
							p1.setModal(true);
							p1.setVisible(true);
							p1.setLocationRelativeTo(null); 
							btnReprogramar.setEnabled(false);
							btnIniciarPartido.setEnabled(false);
					
							
						}
							  
					}
				}
				
			}
		});
		btnReprogramar.setBounds(230, 292, 174, 23);
		panelPartidos.add(btnReprogramar);
		
		 btnEliminar = new JButton("Eliminar");
		 btnEliminar.setEnabled(false);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Liga.getInstance().EliminarPartido(Liga.getInstance().buscarPartidoById(auxIDPartido));
				cargarPartidosHoy();
			}
		});
		btnEliminar.setBounds(136, 292, 89, 23);
		panelPartidos.add(btnEliminar);
		
		JScrollPane scpProximosPartidos = new JScrollPane();
		scpProximosPartidos.setBounds(10, 159, 532, 122);
		panelPartidos.add(scpProximosPartidos);
		
		tblPartidos = new JTable();
		tblPartidos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				indice = tblPartidos.getSelectedRow();
				if(indice >=0) { 
					auxIDPartido = (String)tblPartidos.getModel().getValueAt(indice, 0).toString();
					btnReprogramar.setEnabled(true);
					btnIniciarPartido.setEnabled(true);
					btnEliminar.setEnabled(true);
					
					
				}
					
				
			}
		});
		model1 = new DefaultTableModel();
		String[] columnNames1 = {"ID Partido","Local", "Visitante", "Estadio", "Hora","Fecha"};
		model1.setColumnIdentifiers(columnNames1);
		tblPartidos.setModel(model1);
		tblPartidos.setOpaque(false);
		tblPartidos.setBorder(new CompoundBorder());
		scpProximosPartidos.setViewportView(tblPartidos);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(mainVisual.class.getResource("/Imagenes/ws_Baseball_Stadium_Fenway_Park_1920x1440.jpg")));
		lblNewLabel.setBounds(0, -32, 1350, 689);
		panel.add(lblNewLabel);
		tablePartidosHoy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				index = tablePartidosHoy.getSelectedRow();
				
				if(index >= 0 ) { 
					auxIDPartido = (String)tablePartidosHoy.getModel().getValueAt(index, 0).toString();
					btnReprogramar.setEnabled(true);
					btnIniciarPartido.setEnabled(true);
					btnEliminar.setEnabled(true);
					
					
				}
				
			}
		});
		 
		
	}
	
	
	
	
	public static void cargarPartidosHoy() { 
		model.setRowCount(0);
		model1.setRowCount(0);
		fila1 = new Object[model1.getColumnCount()];
		fila = new Object[model.getColumnCount()];
	for (Partido auxPartido : Liga.getInstance().getMisPartidos()) {
		  Date date = Calendar.getInstance().getTime();  
	        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
	        String strDate = dateFormat.format(date); 
		if(auxPartido.getFecha().equalsIgnoreCase(strDate)&& auxPartido.isTerminado()== false) { 
		fila[0] = auxPartido.getIdPartido();
		fila[1] = auxPartido.getLocal().getNombreEquipo();
		fila[2] = auxPartido.getVisitante().getNombreEquipo();
		fila[3] = auxPartido.getLocal().getEstadio();
		fila[4] = auxPartido.getHora();
		fila[5] = auxPartido.getFecha();
		model.addRow(fila); } 
		else { 
			fila1[0] = auxPartido.getIdPartido();
			fila1[1] = auxPartido.getLocal().getNombreEquipo();
			fila1[2] = auxPartido.getVisitante().getNombreEquipo();
			fila1[3] = auxPartido.getLocal().getEstadio();
			fila1[4] = auxPartido.getHora();
			fila1[5] = auxPartido.getFecha();
			model1.addRow(fila1);
			
		}}

		
		  
	}
	
	public static Partido partidoSeleccionadoTabla() { 
		Partido aux =null;
		for (Partido auxPartido : Liga.getInstance().getMisPartidos()) {
		 	if(auxIDPartido.equalsIgnoreCase(auxPartido.getIdPartido())) { 
		 		aux = auxPartido;
		 	}
		 		
			
		}
		return aux;
	}
}



