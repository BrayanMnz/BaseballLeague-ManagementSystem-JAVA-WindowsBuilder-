package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GradientPaint;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Equipo;
import logico.Jugador;
import logico.Liga;
import logico.Pitcher;
import logico.Season;
import logico.jugadorPosicion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.DefaultComboBoxModel;

public class verJugador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTextField txtDatosName;
	private static JTextField txtDatosEquipo;
	private static JTextField txtDatosAltura;
	private static JTextField txtDatosPeso;
	private Equipo team;
	private static String identificador;
	private JTable tableDatosGenerales;
	private static DefaultTableModel model; 
	private static DefaultTableModel modelEspecifico;

	private static Object[] fila2;
	private static Object[] fila1;
	private static Object[] fila; 
	private JTable tablaEspecifico;
	private JComboBox cbxJugadores;
	private JComboBox cbxTeams;
	//private static Jugador search;
	private JTextField txtBuscarDorsal;
	private JTextField txtBuscarEquipo;
	private static Jugador playerAux=null;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		try {
			VerEquipo dialog = new VerEquipo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} */

	/**
	 * Create the dialog.
	 */
	public verJugador(Jugador identificador) {
		//this.columnNamesPosicion = columnNamesPosicion;
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
			}
			@Override
			public void windowOpened(WindowEvent e) {
				cargarJugadoresCBX ();
				datosGenerales(identificador);
				cargarDatosGenerales(identificador);
				cargarDatosEspecificos(identificador);
			}
		});
		setTitle("Informacion del equipo");
		setBounds(100, 100, 756, 460);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Buscar Jugador", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 722, 56);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblBuscarDorsal = new JLabel("#Dorsal");
		lblBuscarDorsal.setBackground(new Color(230, 230, 250));
		lblBuscarDorsal.setBounds(10, 26, 53, 14);
		panel.add(lblBuscarDorsal);
		
		JButton btnBuscarJugador = new JButton("Buscar");
		btnBuscarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerAux = Liga.getInstance().buscarDorsalTeamName(txtBuscarDorsal.getText().toString(), cbxTeams.getSelectedItem().toString(), cbxJugadores.getSelectedItem().toString());
			    	if(playerAux == null) { 
			    	int option = JOptionPane.showConfirmDialog(null, "Jugador no encontrado, desea crearlo?", "Error", JOptionPane.YES_NO_OPTION, 
							JOptionPane.QUESTION_MESSAGE);
			    	if(option == JOptionPane.YES_OPTION) { 
			    		ManejarJugador player1 = new ManejarJugador();
			    		player1.setModal(true);
			    		player1.setVisible(true);
			    		txtBuscarDorsal.setText("");
			    		txtBuscarEquipo.setText("");
			    		datosGenerales(playerAux);
			    		cargarDatosGenerales(playerAux);
			    		cargarDatosEspecificos(playerAux);
			    	}
			    }
			    if (playerAux != null) {
					datosGenerales(playerAux);
					cargarDatosGenerales(playerAux);
					cargarDatosEspecificos(playerAux);
			    }
			}


		});
		btnBuscarJugador.setBounds(536, 22, 101, 23);
		panel.add(btnBuscarJugador);
		
		cbxJugadores = new JComboBox();

		cbxJugadores.setModel(new DefaultComboBoxModel(new String[] {"<Jugadores>"}));
		cbxJugadores.setBounds(363, 23, 163, 20);
		panel.add(cbxJugadores);
		
		txtBuscarDorsal = new JTextField();
		txtBuscarDorsal.setBounds(58, 23, 86, 20);
		panel.add(txtBuscarDorsal);
		txtBuscarDorsal.setColumns(10);
		
		JLabel lblBuscarEquipo = new JLabel("Equipo");
		lblBuscarEquipo.setBounds(169, 26, 50, 14);
		panel.add(lblBuscarEquipo);
		
		cbxTeams = new JComboBox();
		cbxTeams.setModel(new DefaultComboBoxModel(new String[] {"<Equipos>"}));
		cbxTeams.setBounds(217, 23, 124, 20);
		panel.add(cbxTeams);
		
	/*	txtBuscarEquipo = new JTextField();
		txtBuscarEquipo.setBounds(213, 23, 86, 20);
		panel.add(txtBuscarEquipo);
		txtBuscarEquipo.setColumns(10);
		*/

		JPanel panelDatosEquipo = new JPanel();
		panelDatosEquipo.setBackground(new Color(204, 204, 204));
		panelDatosEquipo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos del Jugador", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDatosEquipo.setBounds(10, 78, 197, 295);
		contentPanel.add(panelDatosEquipo);
		panelDatosEquipo.setLayout(null);
		panelDatosEquipo.setOpaque(true);
		
		JLabel lblNewLabel = new JLabel("Nombre Jugador:");
		lblNewLabel.setBounds(10, 30, 111, 14);
		panelDatosEquipo.add(lblNewLabel); 
	
		
		txtDatosName = new JTextField();
		txtDatosName.setEditable(false);
		txtDatosName.setBounds(10, 49, 169, 20);
		panelDatosEquipo.add(txtDatosName);
		txtDatosName.setColumns(10);
		
		JLabel lblDatosID = new JLabel("Equipo: ");
		lblDatosID.setBounds(10, 80, 65, 14);
		panelDatosEquipo.add(lblDatosID);
		
		txtDatosEquipo = new JTextField();
		txtDatosEquipo.setEditable(false);
		txtDatosEquipo.setBounds(10, 96, 169, 20);
		panelDatosEquipo.add(txtDatosEquipo);
		txtDatosEquipo.setColumns(10);
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setBounds(10, 127, 126, 14);
		panelDatosEquipo.add(lblAltura);
		
		txtDatosAltura = new JTextField();
		txtDatosAltura.setEditable(false);
		txtDatosAltura.setBounds(10, 152, 169, 20);
		panelDatosEquipo.add(txtDatosAltura);
		txtDatosAltura.setColumns(10);
		
		JLabel lblDatosFecha = new JLabel("Ver Lesiones");
		lblDatosFecha.setBounds(10, 242, 150, 14);
		panelDatosEquipo.add(lblDatosFecha);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(10, 183, 169, 14);
		panelDatosEquipo.add(lblPeso);
		
		txtDatosPeso = new JTextField();
		txtDatosPeso.setEditable(false);
		txtDatosPeso.setBounds(10, 208, 169, 20);
		panelDatosEquipo.add(txtDatosPeso);
		txtDatosPeso.setColumns(10);
		
		JButton btnLesiones = new JButton("Ver Lesiones");
		btnLesiones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (playerAux == null) {
					tablaLesiones lesiones = new tablaLesiones(identificador);
					lesiones.setVisible(true);
				}
				else {
					tablaLesiones lesiones = new tablaLesiones(playerAux);
					lesiones.setVisible(true);
				}

			}
		});
		btnLesiones.setBounds(10, 261, 169, 23);
		panelDatosEquipo.add(btnLesiones);
		
		JPanel pnlStatsEquipo = new JPanel();
		pnlStatsEquipo.setBackground(new Color(192, 192, 192));
		pnlStatsEquipo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos Generales", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlStatsEquipo.setBounds(217, 78, 515, 93);
		contentPanel.add(pnlStatsEquipo);
		pnlStatsEquipo.setOpaque(true);
		pnlStatsEquipo.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		pnlStatsEquipo.add(scrollPane, BorderLayout.CENTER);
		
		tableDatosGenerales = new JTable();
		model = new DefaultTableModel();
		String[] columnNames = {"#Dorsal","#Juegos","Errores","Posicion"};
		model.setColumnIdentifiers(columnNames);
        tableDatosGenerales.setModel(model);
		scrollPane.setViewportView(tableDatosGenerales);
		
		JPanel pnlListaJugadores = new JPanel();
		pnlListaJugadores.setBackground(new Color(204, 204, 204));
		pnlListaJugadores.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Nomina del equipo: ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlListaJugadores.setBounds(217, 229, 515, 144);
		contentPanel.add(pnlListaJugadores);
		pnlListaJugadores.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollEspecifico = new JScrollPane();
		pnlListaJugadores.add(scrollEspecifico, BorderLayout.CENTER);
		
		tablaEspecifico = new JTable();
	
		modelEspecifico = new DefaultTableModel();
		String [] columnNamesPosicion = {"Hits","Carreras Anotadas", "Carreras Empujadas", "Bases Robadas", "Turnos", "Home Runs"};
		String [] columnNamesPitcher = {"Juegos Ganados","Juegos Perdidos", "Carreras Limpias", "Innings Lanzados", "Ponches", "BB", "Juegos Salvados"};
		 if (identificador instanceof jugadorPosicion || (playerAux instanceof jugadorPosicion && playerAux != null)) {
				modelEspecifico.setColumnIdentifiers(columnNamesPosicion);
		 }
		 else {
			 modelEspecifico.setColumnIdentifiers(columnNamesPitcher);
		 }
		tablaEspecifico.setModel(modelEspecifico);
		scrollEspecifico.setViewportView(tablaEspecifico);
		
		
		
		
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(verJugador.class.getResource("/Imagenes/616629-sand-baseball-ball-ground-748x499.jpg")));
		lblFondo.setBounds(0, 0, 740, 388);
		contentPanel.add(lblFondo);
		pnlListaJugadores.setVisible(true);
		pnlStatsEquipo.setVisible(true);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private static void datosGenerales(Jugador search) { 
		txtDatosName.setText(search.getNombre());
		txtDatosEquipo.setText(search.getEquipo().toString());
		txtDatosPeso.setText(search.getPeso());
		txtDatosAltura.setText(search.getAltura());
	}
	private static void cargarDatosGenerales(Jugador search) {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()]; 
			fila[0] = search.getNoDorsal().toString();
			fila[1] = search.getCantJuegos();
			fila[2] = search.getErrores();
			fila[3] = search.getPosicion();

			model.addRow(fila);
			
		}
	private static void cargarDatosEspecificos(Jugador search) { 
		modelEspecifico.setRowCount(0);
		fila1 = new Object[modelEspecifico.getColumnCount()];
			   if (search instanceof jugadorPosicion) {
				
					 fila1[0] = ((jugadorPosicion) search).getHits();
					 fila1[1] = ((jugadorPosicion) search).getCarrerasAnotadas(); 
					 fila1[2] = ((jugadorPosicion) search).getCarrerasEmpujadas();
					 fila1[3] = ((jugadorPosicion) search).getBasesRobadas();
					 fila1[4] = ((jugadorPosicion) search).getTurnos();
					 fila1[5] = ((jugadorPosicion) search).getHr();
					 modelEspecifico.addRow(fila1);
			   }
			   else {
					 fila1[0] = ((Pitcher) search).getJuegoGanado();
					 fila1[1] =  ((Pitcher) search).getJuegoPerdido();
					 fila1[2] = ((Pitcher) search).getCarrerasLimpias();
					 fila1[3] = ((Pitcher) search).getInningsLanzados();
					 fila1[4] =((Pitcher) search).getPonches();
					 fila1[5] = ((Pitcher) search).getBB();
					 fila1[6] = ((Pitcher) search).getJuegosSalvados();
					 modelEspecifico.addRow(fila1);
			   }

			 
			
		
	}
	private void cargarJugadoresCBX () {
		
		for (Jugador aux : Liga.getInstance().getMisJugadores()) {
			cbxJugadores.addItem(aux.getNombre().toString());		
		}
		for (Equipo auxTeam : Liga.getInstance().getMisEquipos()) {
			cbxTeams.addItem(auxTeam.getNombreEquipo().toString());
		}
			
	}
}
