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
import java.awt.Font;
import javax.swing.JSeparator;

public class verJugador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTextField txtDatosName;
	private static JTextField txtDatosEquipo;
	private static JTextField txtDatosAltura;
	private static JTextField txtDatosPeso;
	private Equipo team;
	private static String identificador;
	private static DefaultTableModel model; 
	private static DefaultTableModel modelEspecifico;

	private static Object[] fila2;
	private static Object[] fila1;
	private static Object[] fila; 
	private JTable tablaEspecifico;
	private JComboBox<String> cbxJugadores;

	private static Jugador playerAux=null;
	private static JTextField txtBatea;
	private static JTextField txtLanza;
	private static JTextField txtPosicion;
	private static JTextField txtDorsal;
	private JTable tblStats2;

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
				cargarTabla2(identificador);
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
		panel.setForeground(new Color(0, 255, 255));
		panel.setOpaque(false);
		panel.setBackground(new Color(204, 204, 204));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Buscar Jugador", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 722, 56);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		cbxJugadores = new JComboBox<String>();

		cbxJugadores.setModel(new DefaultComboBoxModel<String>(new String[] {"<Jugadores>"}));
		cbxJugadores.setBounds(46, 25, 163, 20);
		panel.add(cbxJugadores);
		
		JLabel lblir = new JLabel("Ir a:");
		lblir.setForeground(new Color(0, 255, 255));
		lblir.setFont(lblir.getFont().deriveFont(lblir.getFont().getStyle() | Font.BOLD | Font.ITALIC));
		lblir.setBounds(10, 28, 54, 14);
		panel.add(lblir);
		
		JButton btnBuscar = new JButton("Cargar Jugador");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarDatos();
				
				
			}
		});
		btnBuscar.setBounds(219, 24, 150, 23);
		panel.add(btnBuscar);
		


		JPanel panelDatosEquipo = new JPanel();
		panelDatosEquipo.setForeground(new Color(0, 255, 255));
		panelDatosEquipo.setOpaque(false);
		panelDatosEquipo.setBackground(new Color(204, 204, 204));
		panelDatosEquipo.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos del Jugador", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDatosEquipo.setBounds(10, 78, 197, 295);
		contentPanel.add(panelDatosEquipo);
		panelDatosEquipo.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Nombre Jugador:");
		lblNewLabel.setForeground(new Color(0, 255, 255));
		lblNewLabel.setBackground(new Color(230, 230, 250));
		lblNewLabel.setFont(lblir.getFont().deriveFont(lblir.getFont().getStyle() | Font.BOLD | Font.ITALIC));
		lblNewLabel.setBounds(10, 30, 111, 14);
		panelDatosEquipo.add(lblNewLabel); 
	
		
		txtDatosName = new JTextField();
		txtDatosName.setEditable(false);
		txtDatosName.setBounds(10, 49, 169, 20);
		panelDatosEquipo.add(txtDatosName);
		txtDatosName.setColumns(10);
		
		JLabel lblDatosID = new JLabel("Equipo: ");
		lblDatosID.setForeground(new Color(0, 255, 255));
		lblDatosID.setFont(lblir.getFont().deriveFont(lblir.getFont().getStyle() | Font.BOLD | Font.ITALIC));
		lblDatosID.setBounds(10, 80, 65, 14);
		panelDatosEquipo.add(lblDatosID);
		
		txtDatosEquipo = new JTextField();
		txtDatosEquipo.setEditable(false);
		txtDatosEquipo.setBounds(10, 99, 169, 20);
		panelDatosEquipo.add(txtDatosEquipo);
		txtDatosEquipo.setColumns(10);
		
		JLabel lblDatosFecha = new JLabel("Ver Lesiones");
		lblDatosFecha.setForeground(new Color(0, 255, 255));
		lblDatosFecha.setFont(lblir.getFont().deriveFont(lblir.getFont().getStyle() | Font.BOLD | Font.ITALIC));
		lblDatosFecha.setBounds(10, 242, 150, 14);
		panelDatosEquipo.add(lblDatosFecha);
		
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
		
		JLabel lblNewLabel_1 = new JLabel("no. Dorsal:");
		lblNewLabel_1.setForeground(new Color(0, 255, 255));
		lblNewLabel_1.setFont(lblir.getFont().deriveFont(lblir.getFont().getStyle() | Font.BOLD | Font.ITALIC));
		lblNewLabel_1.setBounds(10, 130, 65, 14);
		panelDatosEquipo.add(lblNewLabel_1);
		
		txtPosicion = new JTextField();
		txtPosicion.setEditable(false);
		txtPosicion.setBounds(10, 199, 169, 20);
		panelDatosEquipo.add(txtPosicion);
		txtPosicion.setColumns(10);
		
		JLabel lblPosicion = new JLabel("Posicion:");
		lblPosicion.setForeground(new Color(0, 255, 255));
		lblPosicion.setFont(lblir.getFont().deriveFont(lblir.getFont().getStyle() | Font.BOLD | Font.ITALIC));
		lblPosicion.setBounds(10, 180, 150, 14);
		panelDatosEquipo.add(lblPosicion);
		
		txtDorsal = new JTextField();
		txtDorsal.setBounds(10, 149, 169, 20);
		panelDatosEquipo.add(txtDorsal);
		txtDorsal.setEditable(false);
		txtDorsal.setColumns(10);
		
		JPanel pnlStatsEquipo = new JPanel();
		pnlStatsEquipo.setForeground(new Color(0, 255, 255));
		pnlStatsEquipo.setOpaque(false);
		pnlStatsEquipo.setBackground(new Color(192, 192, 192));
		pnlStatsEquipo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos Generales", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlStatsEquipo.setBounds(434, 78, 298, 138);
		contentPanel.add(pnlStatsEquipo);
		
		pnlStatsEquipo.setLayout(null);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setForeground(new Color(0, 255, 255));
		lblAltura.setFont(lblir.getFont().deriveFont(lblir.getFont().getStyle() | Font.BOLD | Font.ITALIC));
		lblAltura.setBounds(251, 82, 61, 14);
		pnlStatsEquipo.add(lblAltura);
		
		txtDatosAltura = new JTextField();
		txtDatosAltura.setBounds(180, 100, 104, 20);
		pnlStatsEquipo.add(txtDatosAltura);
		txtDatosAltura.setEditable(false);
		txtDatosAltura.setColumns(10);
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setForeground(new Color(0, 255, 255));
		lblPeso.setFont(lblir.getFont().deriveFont(lblir.getFont().getStyle() | Font.BOLD | Font.ITALIC));
		lblPeso.setBounds(251, 22, 47, 14);
		pnlStatsEquipo.add(lblPeso);
		
		txtDatosPeso = new JTextField();
		txtDatosPeso.setBounds(180, 41, 104, 20);
		pnlStatsEquipo.add(txtDatosPeso);
		txtDatosPeso.setEditable(false);
		txtDatosPeso.setColumns(10);
		
		JLabel lblBatea = new JLabel("Batea:");
		lblBatea.setForeground(new Color(0, 255, 255));
		lblBatea.setFont(lblir.getFont().deriveFont(lblir.getFont().getStyle() | Font.BOLD | Font.ITALIC));
		lblBatea.setBounds(10, 22, 46, 14);
		pnlStatsEquipo.add(lblBatea);
		
		txtBatea = new JTextField();
		txtBatea.setEditable(false);
		txtBatea.setBounds(10, 41, 104, 20);
		pnlStatsEquipo.add(txtBatea);
		txtBatea.setColumns(10);
		
		JLabel lblLanza = new JLabel("Lanza:");
		lblLanza.setForeground(new Color(0, 255, 255));
		lblLanza.setFont(lblir.getFont().deriveFont(lblir.getFont().getStyle() | Font.BOLD | Font.ITALIC));
		lblLanza.setBounds(10, 82, 46, 14);
		pnlStatsEquipo.add(lblLanza);
		
		txtLanza = new JTextField();
		txtLanza.setEditable(false);
		txtLanza.setBounds(10, 100, 104, 20);
		pnlStatsEquipo.add(txtLanza);
		txtLanza.setColumns(10);
		model = new DefaultTableModel();
		String[] columnNames = {".Prom","Turnos","Ponches","Base por bolas"};
		model.setColumnIdentifiers(columnNames);
		
		JPanel pnlListaJugadores = new JPanel();
		pnlListaJugadores.setForeground(new Color(0, 255, 255));
		pnlListaJugadores.setOpaque(false);
		pnlListaJugadores.setBackground(new Color(204, 204, 204));
		pnlListaJugadores.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Estadisticas del Jugador:", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlListaJugadores.setBounds(217, 227, 515, 146);
		contentPanel.add(pnlListaJugadores);
		pnlListaJugadores.setLayout(null);
		
		JScrollPane scrollEspecifico = new JScrollPane();
		scrollEspecifico.setBounds(6, 16, 503, 49);
		pnlListaJugadores.add(scrollEspecifico);
		
		tablaEspecifico = new JTable();
	
		modelEspecifico = new DefaultTableModel();
		String [] columnNamesPosicion = {"Hits","Dobles", "Triples", "HR"};
		String [] columnNamesPitcher = {"Juegos Ganados","Juegos Perdidos", "Carreras Limpias", "Innings Lanzados", "Ponches", "BB", "Juegos Salvados"};
		 if (identificador instanceof jugadorPosicion || (playerAux instanceof jugadorPosicion && playerAux != null)) {
				modelEspecifico.setColumnIdentifiers(columnNamesPosicion);
		 }
		 else {
			 modelEspecifico.setColumnIdentifiers(columnNamesPitcher);
		 }
		tablaEspecifico.setModel(modelEspecifico);
		scrollEspecifico.setViewportView(tablaEspecifico);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 73, 503, 2);
		pnlListaJugadores.add(separator);
		
		JScrollPane scrollStats2 = new JScrollPane();
		scrollStats2.setBounds(6, 86, 503, 49);
		pnlListaJugadores.add(scrollStats2);
		
		tblStats2 = new JTable();
		scrollStats2.setViewportView(tblStats2);
		tblStats2.setModel(model);
		
		
		
		
		
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
		txtDatosEquipo.setText(search.getEquipo());
		txtDatosPeso.setText(search.getPeso());
		txtDatosAltura.setText(search.getAltura());
		txtPosicion.setText(search.getPosicion());
		txtDorsal.setText(search.getNoDorsal());
		txtLanza.setText(search.getLanza());
		txtBatea.setText(search.getBatea());
	}
	 private static void cargarTabla2(Jugador search) { 
		 model.setRowCount(0);
		 fila = new Object[model.getColumnCount()];
		 fila[0] =  ((jugadorPosicion) search).promBateo();
		 fila[1] =  ((jugadorPosicion) search).getTurnos();
		 fila[2] =  ((jugadorPosicion) search).getPonches();
		 fila[3] =  ((jugadorPosicion) search).getBB();
		 model.addRow(fila);
	 }
	

	private static void cargarDatosEspecificos(Jugador search) { 
		modelEspecifico.setRowCount(0);
		fila1 = new Object[modelEspecifico.getColumnCount()];
			   if (search instanceof jugadorPosicion) {
				    
					 fila1[0] = ((jugadorPosicion) search).getHits();
					 fila1[1] = ((jugadorPosicion) search).getDobles();
					 fila1[2] = ((jugadorPosicion) search).getTriples();
					 fila1[3] = ((jugadorPosicion) search).getHr();
					
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
		}}
	private void cargarDatos() { 
		Jugador auxJugador =Liga.getInstance().buscarPlayerByName(cbxJugadores.getSelectedItem().toString());
		txtDatosName.setText(auxJugador.getNombre());
		txtDatosEquipo.setText(auxJugador.getEquipo());
		txtDatosPeso.setText(auxJugador.getPeso());
		txtDatosAltura.setText(auxJugador.getAltura());
		txtPosicion.setText(auxJugador.getPosicion());
		txtDorsal.setText(auxJugador.getNoDorsal());
		txtLanza.setText(auxJugador.getLanza());
		txtBatea.setText(auxJugador.getBatea());
		
		
	
	}
}
