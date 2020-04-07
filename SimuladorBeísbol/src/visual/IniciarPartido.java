package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.text.MaskFormatter;

import logico.Equipo;
import logico.Jugador;
import logico.Liga;
import logico.Partido;
import logico.jugadorPosicion;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class IniciarPartido extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable tblLocal;
	private static JTable tblVisita;
	
	private static DefaultTableModel model; 
	private static DefaultTableModel model1;
	private static DefaultTableModel model2;
	private static Object[] fila1;
	private static Object[] fila; 
	private static Object[] fila2; 
	private static String auxID;
	private static JFormattedTextField txtAux;

	private static JTextField txtNombreEquipo;
	private static  JTextField txtNombreLanzador;
	private JTextField txtInnings;
	private static 	JScrollPane scpnVisitante;
	private static 	JScrollPane scpnLocal;
	private static JButton btnVisitante;
private static JButton btnLocal;
private static JTable tableInnings;
private static JTextField txtNombreVis;
private JTextField txtinningsVis;
private JTextField txtCarrerasLocal;
private JTextField txtHitsLocal;
private JTextField txtErroresLocal;
private JTextField txtCarrerasVisitante;
private JTextField txtHitsVisitante;
private JTextField txtErroresVisitante;
private static  int  auxf =0;
private static jugadorPosicion auxJugador=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IniciarPartido dialog = new IniciarPartido(auxID);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public IniciarPartido(String auxID) {
		setResizable(false);
		setTitle("Partido en curso ");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				cargarLineupLocal();
				cargarLineupVisitante();
				cargarMarcador();
				cargarLanzadores();
			}
		});
		this.auxID = auxID;
		setBounds(100, 100, 921, 700);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panelAnotacion = new JPanel();
		panelAnotacion.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Alineacion", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelAnotacion.setBounds(10, 147, 885, 292);
		contentPanel.add(panelAnotacion);
		panelAnotacion.setLayout(null);
		panelAnotacion.setOpaque(false);
		
		scpnLocal = new JScrollPane();
		scpnLocal.setVisible(true);
		scpnLocal.setBounds(6, 74, 869, 207);
		panelAnotacion.add(scpnLocal);
		
		tblLocal = new JTable();
		tblLocal.setAutoResizeMode(tblLocal.AUTO_RESIZE_OFF);
		tblLocal.setVisible(true);
		model = new DefaultTableModel();
		String[] columnNamesLocal = {"Jugador","1IN","2IN","3IN","4IN","5IN","6IN","7IN","8IN","9IN","10IN","11IN","12IN"};
		model.setColumnIdentifiers(columnNamesLocal);
		tblLocal.setModel(model);
		scpnLocal.setViewportView(tblLocal);
		
		 JComboBox<Integer> cbxAux = new JComboBox<Integer>();
		 for(int i=1; i<=6; i++) { 
			 cbxAux.addItem(i);}
		 TableColumn tc0 = tblLocal.getColumnModel().getColumn(0);
		 tc0.setPreferredWidth(140);
		 TableColumn tc1 = tblLocal.getColumnModel().getColumn(1);
		 tc1.setPreferredWidth(65);
		 TableColumn tc2 = tblLocal.getColumnModel().getColumn(2);
		 tc2.setPreferredWidth(65);
		 TableColumn tc3 = tblLocal.getColumnModel().getColumn(3);
		 tc3.setPreferredWidth(65);
		 TableColumn tc4 = tblLocal.getColumnModel().getColumn(4);
		 tc4.setPreferredWidth(65);
		 TableColumn tc5 = tblLocal.getColumnModel().getColumn(5);
		 tc5.setPreferredWidth(65);
		 TableColumn tc6 = tblLocal.getColumnModel().getColumn(6);
		 tc6.setPreferredWidth(65);
		 TableColumn tc7 = tblLocal.getColumnModel().getColumn(7);
		 tc7.setPreferredWidth(65);
		 TableColumn tc8 = tblLocal.getColumnModel().getColumn(8);
		 tc8.setPreferredWidth(65);
		 TableColumn tc9 = tblLocal.getColumnModel().getColumn(9);
		 tc9.setPreferredWidth(65);
		 TableColumn tc10 = tblLocal.getColumnModel().getColumn(10);
		 tc10.setPreferredWidth(65);
		 TableColumn tc11 = tblLocal.getColumnModel().getColumn(11);
		 tc11.setPreferredWidth(65);
		 TableColumn tc12 = tblLocal.getColumnModel().getColumn(12);
		 tc12.setPreferredWidth(65);
		    TableCellEditor tce1 = new DefaultCellEditor(cbxAux);
		    tc1.setCellEditor(tce1);
		    TableCellEditor tce2 = new DefaultCellEditor(cbxAux);
		    tc2.setCellEditor(tce2);
		    TableCellEditor tce3 = new DefaultCellEditor(cbxAux);
		    tc3.setCellEditor(tce3);
		    TableCellEditor tce4 = new DefaultCellEditor(cbxAux);
		    tc4.setCellEditor(tce4);
		    TableCellEditor tce5 = new DefaultCellEditor(cbxAux);
		    tc5.setCellEditor(tce5);
		    TableCellEditor tce6 = new DefaultCellEditor(cbxAux);
		    tc6.setCellEditor(tce6);
		    TableCellEditor tce7 = new DefaultCellEditor(cbxAux);
		    tc7.setCellEditor(tce7);
		    TableCellEditor tce8 = new DefaultCellEditor(cbxAux);
		    tc8.setCellEditor(tce8);
		    TableCellEditor tce9 = new DefaultCellEditor(cbxAux);
		    tc9.setCellEditor(tce9);
		    TableCellEditor tce10 = new DefaultCellEditor(cbxAux);
		    tc10.setCellEditor(tce10);
		    TableCellEditor tce11 = new DefaultCellEditor(cbxAux);
		    tc11.setCellEditor(tce11);
		    TableCellEditor tce12 = new DefaultCellEditor(cbxAux);
		    tc12.setCellEditor(tce12);
		
	
		

		
		model1 = new DefaultTableModel();
		String[] columnNamesVisita = {"Jugador","1IN","2IN","3IN","4IN","5IN","6IN","7IN","8IN","9IN","10IN","11IN","12IN"};
		model1.setColumnIdentifiers(columnNamesVisita);
		scpnLocal.setViewportView(tblLocal);
		
		JLabel lblNombreEquipo = new JLabel(" Equipo: ");
		lblNombreEquipo.setBounds(6, 49, 87, 14);
		panelAnotacion.add(lblNombreEquipo);
		
		txtNombreEquipo = new JTextField();
		txtNombreEquipo.setEnabled(true);
		txtNombreEquipo.setEditable(false);
		txtNombreEquipo.setBounds(62, 46, 169, 20);
		panelAnotacion.add(txtNombreEquipo);
		txtNombreEquipo.setColumns(10);
		
			scpnVisitante = new JScrollPane();
			scpnVisitante.setVisible(false);
			scpnVisitante.setBounds(6, 74, 869, 207);
			panelAnotacion.add(scpnVisitante);
			
			tblVisita = new JTable();
		    tblVisita.setAutoResizeMode(tblVisita.AUTO_RESIZE_OFF);
			tblVisita.setVisible(false);
			tblVisita.setModel(model1);
			TableColumn tcc0 = tblVisita.getColumnModel().getColumn(0);
			tcc0.setPreferredWidth(140);
			TableColumn tcc1 = tblVisita.getColumnModel().getColumn(1);
			tcc1.setPreferredWidth(65);
			TableColumn tcc2 = tblVisita.getColumnModel().getColumn(2);
			tcc2.setPreferredWidth(65);
			TableColumn tcc3 = tblVisita.getColumnModel().getColumn(3);
			tcc3.setPreferredWidth(65);
			TableColumn tcc4 = tblVisita.getColumnModel().getColumn(4);
			tcc4.setPreferredWidth(65);
			TableColumn tcc5 = tblVisita.getColumnModel().getColumn(5);
			tcc5.setPreferredWidth(65);
			TableColumn tcc6 = tblVisita.getColumnModel().getColumn(6);
			tcc6.setPreferredWidth(65);
			TableColumn tcc7 = tblVisita.getColumnModel().getColumn(7);
			tcc7.setPreferredWidth(65);
			TableColumn tcc8 = tblVisita.getColumnModel().getColumn(8);
			tcc8.setPreferredWidth(65);
			TableColumn tcc9 = tblVisita.getColumnModel().getColumn(9);
			tcc9.setPreferredWidth(65);
			TableColumn tcc10 = tblVisita.getColumnModel().getColumn(10);
			tcc10.setPreferredWidth(65);
			TableColumn tcc11 = tblVisita.getColumnModel().getColumn(11);
			tcc11.setPreferredWidth(65);
			TableColumn tcc12 = tblVisita.getColumnModel().getColumn(12);
			tcc12.setPreferredWidth(65);
			
			
			scpnVisitante.setViewportView(tblVisita);
			
			 btnLocal = new JButton("Local");
			 btnLocal.setOpaque(false);
			 btnLocal.setFont(btnLocal.getFont().deriveFont(btnLocal.getFont().getStyle() | Font.BOLD ));
			btnLocal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					scpnVisitante.setVisible(false);
					tblVisita.setVisible(false);
					scpnLocal.setVisible(true);
					tblLocal.setVisible(true);
				
					 Partido auxPartido = Liga.getInstance().buscarPartidoById(auxID);
					 txtNombreEquipo.setText(auxPartido.getLocal().nombreEquipo);
					
					
					
				}
			});
			btnLocal.setBounds(6, 11, 93, 23);
			panelAnotacion.add(btnLocal);
			
			btnVisitante = new JButton("Visitante");
			btnVisitante.setOpaque(false);
			 btnVisitante.setFont(btnVisitante.getFont().deriveFont(btnVisitante.getFont().getStyle() | Font.BOLD ));
			btnVisitante.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					scpnVisitante.setVisible(true);
					tblVisita.setVisible(true);
	             	scpnLocal.setVisible(false);
					tblLocal.setVisible(false);
				
					 Partido auxPartido = Liga.getInstance().buscarPartidoById(auxID);
					 txtNombreEquipo.setText(auxPartido.getVisitante().nombreEquipo);
					
					
				}
			});
			
			btnVisitante.setBounds(101, 11, 93, 23);
			panelAnotacion.add(btnVisitante);
			
			JButton btnNewButton = new JButton("New button");
			btnNewButton.setBounds(704, 24, 89, 23);
			panelAnotacion.add(btnNewButton);
			btnNewButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					cargarEstadisticasJugadores();	
					
				}
			});
		
		 JComboBox<Integer> cbxAux1 = new JComboBox<Integer>();
		 for(int i=1; i<=6; i++) { 
			 cbxAux1.addItem(i);}
		    TableCellEditor tcce1 = new DefaultCellEditor(cbxAux1);
		    tcc1.setCellEditor(tcce1);
		    TableCellEditor tcce2 = new DefaultCellEditor(cbxAux1);
		    tcc2.setCellEditor(tcce2);
		    TableCellEditor tcce3 = new DefaultCellEditor(cbxAux1);
		    tcc3.setCellEditor(tcce3);
		    TableCellEditor tcce4 = new DefaultCellEditor(cbxAux1);
		    tcc4.setCellEditor(tcce4);
		    TableCellEditor tcce5 = new DefaultCellEditor(cbxAux1);
		    tcc5.setCellEditor(tcce5);
		    TableCellEditor tcce6 = new DefaultCellEditor(cbxAux1);
		    tcc6.setCellEditor(tcce6);
		    TableCellEditor tcce7 = new DefaultCellEditor(cbxAux1);
		    tcc7.setCellEditor(tcce7);
		    TableCellEditor tcce8 = new DefaultCellEditor(cbxAux1);
		    tcc8.setCellEditor(tcce8);
		    TableCellEditor tcce9 = new DefaultCellEditor(cbxAux1);
		    tcc9.setCellEditor(tcce9);
		    TableCellEditor tcce10 = new DefaultCellEditor(cbxAux1);
		    tcc10.setCellEditor(tcce10);
		    TableCellEditor tcce11 = new DefaultCellEditor(cbxAux1);
		    tcc11.setCellEditor(tcce11);
		    TableCellEditor tcce12 = new DefaultCellEditor(cbxAux1);
		    tcc12.setCellEditor(tcce12);
		

		
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBorder(new TitledBorder(null, "Marcador: ", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBounds(10, 0, 885, 146);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JPanel panelinnings = new JPanel();
		panelinnings.setOpaque(false);
		panelinnings.setBorder(new TitledBorder(null, "Innings", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panelinnings.setBounds(10, 23, 634, 112);
		panel.add(panelinnings);
		panelinnings.setLayout(null);
		
		JScrollPane scpInnings = new JScrollPane();
		scpInnings.setBounds(6, 16, 623, 85);
		panelinnings.add(scpInnings);
		
		tableInnings = new JTable();
		model2 = new DefaultTableModel();
		String[] columnNamesMarcador = {"Equipo","1IN","2IN","3IN","4IN","5IN","6IN","7IN","8IN","9IN","10IN","11IN","12IN"};
		model2.setColumnIdentifiers(columnNamesMarcador);
        tableInnings.setModel(model2);
         
        tableInnings.setRowHeight(0, 15);
        tableInnings.setRowHeight(1, 35);
        tableInnings.setRowHeight(2, 35);
        tableInnings.getColumnModel().getColumn(0).setPreferredWidth(119);;
		TableColumn tccc1 = tableInnings.getColumnModel().getColumn(1);
		tccc1.setPreferredWidth(42);
		TableColumn tccc2 = tableInnings.getColumnModel().getColumn(2);
		tccc2.setPreferredWidth(42);
		TableColumn tccc3 = tableInnings.getColumnModel().getColumn(3);
		tccc3.setPreferredWidth(42);
		TableColumn tccc4 = tableInnings.getColumnModel().getColumn(4);
		tccc4.setPreferredWidth(42);
		TableColumn tccc5 = tableInnings.getColumnModel().getColumn(5);
		tccc5.setPreferredWidth(42);
		TableColumn tccc6 = tableInnings.getColumnModel().getColumn(6);
		tccc6.setPreferredWidth(42);
		TableColumn tccc7 = tableInnings.getColumnModel().getColumn(7);
		tccc7.setPreferredWidth(42);
		TableColumn tccc8 = tableInnings.getColumnModel().getColumn(8);
		tccc8.setPreferredWidth(42);
		TableColumn tccc9 = tableInnings.getColumnModel().getColumn(9);
		tccc9.setPreferredWidth(42);
		TableColumn tccc10 = tableInnings.getColumnModel().getColumn(10);
		tccc10.setPreferredWidth(42);
		TableColumn tccc11 = tableInnings.getColumnModel().getColumn(11);
		tccc11.setPreferredWidth(42);
		TableColumn tccc12 = tableInnings.getColumnModel().getColumn(12);
		tccc12.setPreferredWidth(42);
		
		 JTextField txtAux = new JTextField();
			MaskFormatter auxFormato = null;
			try {
				auxFormato = new MaskFormatter("##");
				auxFormato.setPlaceholder("00");
				} catch (ParseException e) {
			
				e.printStackTrace();
			}
			
		     txtAux = new JFormattedTextField(auxFormato);
		    
        JComboBox<Integer> cbxAux2 = new JComboBox<Integer>();
		 for(int i=0; i<=5; i++) { 
			 cbxAux2.addItem(i);}
		    TableCellEditor tccce1 =new DefaultCellEditor(txtAux);
		    tccc1.setCellEditor(tccce1);
		    TableCellEditor tccce2 = new DefaultCellEditor(txtAux);
		    tccc2.setCellEditor(tccce2);
		    TableCellEditor tccce3 = new DefaultCellEditor(txtAux);
		    tccc3.setCellEditor(tccce3);
		    TableCellEditor tccce4 = new DefaultCellEditor(txtAux);
		    tccc4.setCellEditor(tccce4);
		    TableCellEditor tccce5 = new DefaultCellEditor(txtAux);
		    tccc5.setCellEditor(tccce5);
		    TableCellEditor tccce6 = new DefaultCellEditor(txtAux);
		    tccc6.setCellEditor(tccce6);
		    TableCellEditor tccce7 = new DefaultCellEditor(txtAux);
		    tccc7.setCellEditor(tccce7);
		    TableCellEditor tccce8 = new DefaultCellEditor(txtAux);
		    tccc8.setCellEditor(tccce8);
		    TableCellEditor tccce9 = new DefaultCellEditor(txtAux);
		    tccc9.setCellEditor(tccce9);
		    TableCellEditor tccce10 = new DefaultCellEditor(txtAux);
		    tccc10.setCellEditor(tccce10);
		    TableCellEditor tccce11 = new DefaultCellEditor(txtAux);
		    tccc11.setCellEditor(tccce11);
		    TableCellEditor tccce12 = new DefaultCellEditor(txtAux);
		    tccc12.setCellEditor(tccce12);
		
        
		scpInnings.setViewportView(tableInnings);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Pizarra:", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(654, 11, 221, 124);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("C");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1.setBounds(25, 11, 24, 32);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblH = new JLabel("H");
		lblH.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblH.setBounds(96, 11, 24, 32);
		panel_1.add(lblH);
		
		JLabel lblE = new JLabel("E");
		lblE.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblE.setBounds(169, 11, 24, 32);
		panel_1.add(lblE);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(10, 40, 201, 2);
		panel_1.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(10, 80, 201, 2);
		panel_1.add(separator_2);
		
		txtCarrerasLocal = new JTextField();
		txtCarrerasLocal.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtCarrerasLocal.setOpaque(false);
		txtCarrerasLocal.setEditable(false);
		txtCarrerasLocal.setBounds(25, 49, 24, 26);
		panel_1.add(txtCarrerasLocal);
		txtCarrerasLocal.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(69, 11, 2, 102);
		panel_1.add(separator);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(147, 11, 2, 102);
		panel_1.add(separator_3);
		
		txtHitsLocal = new JTextField();
		txtHitsLocal.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtHitsLocal.setOpaque(false);
		txtHitsLocal.setEditable(false);
		txtHitsLocal.setBounds(96, 49, 24, 26);
		panel_1.add(txtHitsLocal);
		txtHitsLocal.setColumns(10);
		
		txtErroresLocal = new JTextField();
		txtErroresLocal.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtErroresLocal.setOpaque(false);
		txtErroresLocal.setEditable(false);
		txtErroresLocal.setBounds(169, 49, 24, 26);
		panel_1.add(txtErroresLocal);
		txtErroresLocal.setColumns(10);
		
		txtCarrerasVisitante = new JTextField();
		txtCarrerasVisitante.setOpaque(false);
		txtCarrerasVisitante.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtCarrerasLocal.setOpaque(false);
		txtCarrerasVisitante.setEditable(false);
		txtCarrerasVisitante.setColumns(10);
		txtCarrerasVisitante.setBounds(25, 87, 24, 26);
		panel_1.add(txtCarrerasVisitante);
		
		txtHitsVisitante = new JTextField();
		txtHitsVisitante.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtHitsVisitante.setOpaque(false);
		txtHitsVisitante.setEditable(false);
		txtHitsVisitante.setColumns(10);
		txtHitsVisitante.setBounds(96, 87, 24, 26);
		panel_1.add(txtHitsVisitante);
		
		txtErroresVisitante = new JTextField();
		txtErroresVisitante.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtErroresVisitante.setOpaque(false);
		txtErroresVisitante.setEditable(false);
		txtErroresVisitante.setColumns(10);
		txtErroresVisitante.setBounds(169, 87, 24, 26);
		panel_1.add(txtErroresVisitante);
		
		JPanel pnlLanzador = new JPanel();
		pnlLanzador.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "  Lanzador Equipo Local:   ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlLanzador.setBounds(10, 443, 440, 197);
		contentPanel.add(pnlLanzador);
		pnlLanzador.setLayout(null);
		pnlLanzador.setOpaque(false);
		
		JLabel lblNombreLanzador = new JLabel("Nombre: ");
		lblNombreLanzador.setBounds(10, 11, 168, 14);
		pnlLanzador.add(lblNombreLanzador);
		
		txtNombreLanzador = new JTextField();
		txtNombreLanzador.setEditable(false);
		txtNombreLanzador.setBounds(10, 26, 168, 20);
		pnlLanzador.add(txtNombreLanzador);
		txtNombreLanzador.setColumns(10);
		
		JLabel lblOutsRealizados = new JLabel("Outs Realizados:");
		lblOutsRealizados.setBounds(322, 11, 109, 14);
		pnlLanzador.add(lblOutsRealizados);
		
		JSpinner spnOuts = new JSpinner();
		spnOuts.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spnOuts.setBounds(263, 26, 168, 20);
		pnlLanzador.add(spnOuts);
		
		JLabel lblInnings = new JLabel("Innings Lanzados:");
		lblInnings.setBounds(10, 57, 168, 14);
		pnlLanzador.add(lblInnings);
		
		txtInnings = new JTextField();
		txtInnings.setEditable(false);
		txtInnings.setBounds(10, 76, 168, 20);
		pnlLanzador.add(txtInnings);
		txtInnings.setColumns(10);
		
		JLabel lblPonches = new JLabel("Ponches:");
		lblPonches.setBounds(10, 107, 168, 14);
		pnlLanzador.add(lblPonches);
		
		JSpinner spnPonches = new JSpinner();
		spnPonches.setBounds(10, 122, 168, 20);
		pnlLanzador.add(spnPonches);
		
		JLabel lblNewLabel = new JLabel("Bases por bolas: ");
		lblNewLabel.setBounds(10, 147, 168, 14);
		pnlLanzador.add(lblNewLabel);
		
		JSpinner spnBB = new JSpinner();
		spnBB.setBounds(10, 166, 168, 20);
		pnlLanzador.add(spnBB);
		
		JLabel lblCarrerasPerm = new JLabel("Carreras Permitidas:");
		lblCarrerasPerm.setBounds(263, 57, 168, 14);
		pnlLanzador.add(lblCarrerasPerm);
		
		JSpinner spnCarreras = new JSpinner();
		spnCarreras.setBounds(263, 76, 168, 20);
		pnlLanzador.add(spnCarreras);
		
		JLabel lblCarrerasLimp = new JLabel("Carreras Limpias Permitidas: ");
		lblCarrerasLimp.setBounds(263, 107, 168, 14);
		pnlLanzador.add(lblCarrerasLimp);
		
		JSpinner spnCarrerasL = new JSpinner();
		spnCarrerasL.setBounds(263, 122, 168, 20);
		pnlLanzador.add(spnCarrerasL);
		
		JLabel lblFondo2 = new JLabel("");
		lblFondo2.setIcon(new ImageIcon(IniciarPartido.class.getResource("/Imagenes/fondo2.jpg")));
		lblFondo2.setBounds(0, 645, 915, 26);
		contentPanel.add(lblFondo2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "  Lanzador Equipo Visitante  ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(460, 443, 440, 197);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNombreVis = new JLabel("Nombre: ");
		lblNombreVis.setBounds(10, 11, 168, 14);
		panel_2.add(lblNombreVis);
		
		txtNombreVis = new JTextField();
		txtNombreVis.setEditable(false);
		txtNombreVis.setColumns(10);
		txtNombreVis.setBounds(10, 26, 168, 20);
		panel_2.add(txtNombreVis);
		
		JLabel lblInningsVis = new JLabel("Innings Lanzados:");
		lblInningsVis.setBounds(10, 57, 168, 14);
		panel_2.add(lblInningsVis);
		
		txtinningsVis = new JTextField();
		txtinningsVis.setEditable(false);
		txtinningsVis.setColumns(10);
		txtinningsVis.setBounds(10, 76, 168, 20);
		panel_2.add(txtinningsVis);
		
		JLabel lblPonchesVis = new JLabel("Ponches:");
		lblPonchesVis.setBounds(10, 107, 168, 14);
		panel_2.add(lblPonchesVis);
		
		JSpinner spnPonchesVis = new JSpinner();
		spnPonchesVis.setBounds(10, 122, 168, 20);
		panel_2.add(spnPonchesVis);
		
		JLabel lblBBVis = new JLabel("Bases por bolas: ");
		lblBBVis.setBounds(10, 147, 168, 14);
		panel_2.add(lblBBVis);
		
		JSpinner spnBBVis = new JSpinner();
		spnBBVis.setBounds(10, 166, 168, 20);
		panel_2.add(spnBBVis);
		
		JLabel lblOutsRVis = new JLabel("Outs Realizados:");
		lblOutsRVis.setBounds(319, 11, 112, 14);
		panel_2.add(lblOutsRVis);
		
		JSpinner spnOutsVis = new JSpinner();
		spnOutsVis.setBounds(263, 26, 168, 20);
		panel_2.add(spnOutsVis);
		
		JLabel lblCarrerasPerVis = new JLabel("Carreras Permitidas:");
		lblCarrerasPerVis.setBounds(263, 57, 168, 14);
		panel_2.add(lblCarrerasPerVis);
		
		JSpinner SpnCarPerVis = new JSpinner();
		SpnCarPerVis.setBounds(263, 76, 168, 20);
		panel_2.add(SpnCarPerVis);
		
		JLabel lblCarrLimPeVis = new JLabel("Carreras Limpias Permitidas: ");
		lblCarrLimPeVis.setBounds(263, 107, 168, 14);
		panel_2.add(lblCarrLimPeVis);
		
		JSpinner spnCarrLVis = new JSpinner();
		spnCarrLVis.setBounds(263, 122, 168, 20);
		panel_2.add(spnCarrLVis);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(IniciarPartido.class.getResource("/Imagenes/fondosss.jpg")));
		lblNewLabel_2.setBounds(0, -13, 915, 673);
		contentPanel.add(lblNewLabel_2);
		
			
		
		
		

	}
	
	public static void cargarLineupLocal() { 

		 Partido auxPartido = Liga.getInstance().buscarPartidoById(auxID);
			
			model.setRowCount(0);
			fila = new Object[model.getColumnCount()];
             
			
			for (Jugador auxJugador : Liga.getInstance().getMisJugadores()) {
		      if(auxJugador.getEquipo().equalsIgnoreCase(auxPartido.getLocal().getNombreEquipo())) { 
		          if(auxJugador instanceof jugadorPosicion) { 
			fila[0] = auxJugador.getNombre();
			 for(int i=1; i<=12 ; i++) {
			fila[i] = 0;    }
			model.addRow(fila);  
			     }}}
	
	}
		
	
	public static void cargarLineupVisitante() { 
		 Partido auxPartido = Liga.getInstance().buscarPartidoById(auxID);
	
			model1.setRowCount(0);
			fila1 = new Object[model1.getColumnCount()];
              
			
			for (Jugador auxJugador : Liga.getInstance().getMisJugadores()) {
		      if(auxJugador.getEquipo().equalsIgnoreCase(auxPartido.getVisitante().getNombreEquipo())) { 
		          if(auxJugador instanceof jugadorPosicion) { 
			fila1[0] = auxJugador.getNombre();
			 for(int i=1; i<=12 ; i++) {
			fila1[i] = 0;    }
			model1.addRow(fila1);  
			     }}}}
	
	
	
	public static void cargarMarcador() { 
		 Partido auxPartido = Liga.getInstance().buscarPartidoById(auxID);
	
			model2.setRowCount(0);
			fila2 = new Object[model2.getColumnCount()];
		     	       
			fila2[0] = auxPartido.getLocal().getNombreEquipo();
			 for(int i=1; i<=12 ; i++) {
			fila2[i] = "  -  ";    }
				model2.addRow(fila2);  
			 fila2[0] = auxPartido.getVisitante().getNombreEquipo();
			 for(int i=1; i<=12 ; i++) {
					fila2[i] = "  -  ";    }
			model2.addRow(fila2);  } 
	

public static void cargarEstadisticasJugadores() { 
for(int i =0; i<=2 ; i++) {  // i representa la fila de la tabla, j a la columna. 
String aux = (String)tblLocal.getModel().getValueAt(i, 0).toString();
 auxJugador = (jugadorPosicion) Liga.getInstance().buscarPlayerByName(aux);
for(int j =1; j<13; j++) { 
	int auxH= Integer.parseInt(tblLocal.getModel().getValueAt(i, j).toString());

	
	
	//System.out.println(auxH);
	 if(auxH == 1) { 

	   auxJugador.setHits(auxJugador.getHits()+1);
	   auxJugador.setTurnos(auxJugador.getTurnos()+1);
	} else if (auxH ==2 ) { 
		auxJugador.setDobles(auxJugador.getDobles()+1);
		 auxJugador.setTurnos(auxJugador.getTurnos()+1);
	} else if (auxH ==3 ) { 
		auxJugador.setTriples(auxJugador.getTriples()+1);
		 auxJugador.setTurnos(auxJugador.getTurnos()+1);
	} else if (auxH ==4 ) { 
		auxJugador.setHr(auxJugador.getHr()+1);
		 auxJugador.setTurnos(auxJugador.getTurnos()+1);
	} else if (auxH ==5 ) { 
		auxJugador.setBB(auxJugador.getBB()+1);
		
	} else if (auxH ==6 ) { 
		 auxJugador.setTurnos(auxJugador.getTurnos()+1);
		auxJugador.setPonches(auxJugador.getPonches()+1);
	} 
	 
} } 
 
 //System.out.println(auxf);
// System.out.println(auxJugador.totalHits());

 
    	
    	
    
} 

   public static void cargarLanzadores() { 
	
	   Jugador auxJugador = Liga.getInstance().buscarPlayerByName( LineupPartido.cbxPitcherLocal.getSelectedItem().toString());
	    txtNombreLanzador.setText(auxJugador.getNombre());
	    
	    Jugador auxJugadorVis = Liga.getInstance().buscarPlayerByName( LineupPartido.cbxPitcherVisitante.getSelectedItem().toString());
          txtNombreVis.setText(auxJugadorVis.getNombre());
   }
} 
	

