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
import logico.Pitcher;
import logico.jugadorPosicion;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class IniciarPartido extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable tblLocal;
	private static JTable tblVisita;
	private static JTable tableInnings;
	
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
	private static 	JScrollPane scpnVisitante;
	private static 	JScrollPane scpnLocal;
	private static JButton btnVisitante;
private static JButton btnLocal;

private static JTextField txtNombreVis;
private static  int  auxf =0;
private static jugadorPosicion auxJugador=null;

private static JSpinner spnOuts;
private static JSpinner spnPonches;
private static JSpinner spnBB;
private static JSpinner spnCarreras;
private static JSpinner spnCarrerasL;
private static JSpinner spnOutsVis;
private static JSpinner spnPonchesVis;
private static JSpinner spnBBVis;
private static JSpinner spnCarPerVis;
private static JSpinner spnCarrLVis;
private static JTextField txtPartido;
private static Partido auxPartido1;
private static JFormattedTextField txtCarrerasLocal;
private static JFormattedTextField txtErroresLocal;
private static JFormattedTextField txtCarrerasVisitante;
private static JFormattedTextField txtHitsVisitante;
private static JFormattedTextField txtErroresVisitante;
private static JFormattedTextField txtHitsLocal;


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
	@SuppressWarnings("deprecation")
	public IniciarPartido(String auxID) {
		setResizable(false);
		setTitle("Partido en curso ");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				HiloPizarra h1 = new HiloPizarra();
			
				h1.start(); 
			
				
				cargarLineupLocal();
				cargarLineupVisitante();
				cargarMarcador();
				cargarLanzadores();
				 Partido auxPartido = Liga.getInstance().buscarPartidoById(auxID);
				 txtPartido.setText(auxPartido.getIdPartido());
			}
			@Override
			public void windowActivated(WindowEvent e) {
			
				
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
			
			JButton btnNewButton = new JButton("Terminar Partido");
			btnNewButton.setBounds(717, 11, 155, 52);
			panelAnotacion.add(btnNewButton);
			
			JLabel lblIDPartido = new JLabel("ID del partido: ");
			lblIDPartido.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
			lblIDPartido.setBounds(350, 33, 155, 30);
			panelAnotacion.add(lblIDPartido);
			
			txtPartido = new JTextField();
			txtPartido.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			txtPartido.setEnabled(false);
			txtPartido.setEditable(false);
			txtPartido.setBounds(494, 33, 124, 28);
			panelAnotacion.add(txtPartido);
			txtPartido.setColumns(10);
			btnNewButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					cargarEstadisticasJugadoresLocal();
					cargarEstadisticasJugadoresVisitante();
					cargarStatsPitcherLocal();
					cargarStatsPitcherVis();
					cargarCarreras();
			
					if(Integer.parseInt(txtCarrerasLocal.getText().toString()) > Integer.parseInt(txtCarrerasVisitante.getText().toString())){ 
						 Partido auxPartido = Liga.getInstance().buscarPartidoById(auxID);
						 auxPartido.getLocal().setGanados(auxPartido.getLocal().getGanados() + 1);
						 auxPartido.getVisitante().setPerdidos(auxPartido.getVisitante().getPerdidos() + 1);
						  
						 PizarraFinal f1 = new PizarraFinal(IniciarPartido.auxID);
						 f1.setModal(true);
						 f1.setLocationRelativeTo(null);
						 f1.setVisible(true);
						 
						 JOptionPane.showMessageDialog(null, "El ganador del partido es: "+auxPartido.getLocal().nombreEquipo, "Partido Finalizado", JOptionPane.INFORMATION_MESSAGE);
							
					} 	else if(Integer.parseInt(txtCarrerasLocal.getText()) < Integer.parseInt(txtCarrerasVisitante.getText())){ 
						 Partido auxPartido = Liga.getInstance().buscarPartidoById(auxID);
						 auxPartido.getVisitante().setGanados(auxPartido.getVisitante().getGanados() + 1);
						 auxPartido.getLocal().setPerdidos(auxPartido.getLocal().getPerdidos() + 1);
						  
						 PizarraFinal f1 = new PizarraFinal(IniciarPartido.auxID);
						 f1.setModal(true);
						 f1.setLocationRelativeTo(null);
						 f1.setVisible(true); 
						 JOptionPane.showMessageDialog(null, "El ganador del partido es: "+auxPartido.getVisitante().nombreEquipo, "Partido Finalizado", JOptionPane.INFORMATION_MESSAGE);
							
					}
						
					dispose();
					 Partido auxPartido = Liga.getInstance().buscarPartidoById(auxID);
					 auxPartido.setTerminado(true);
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
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(69, 11, 2, 102);
		panel_1.add(separator);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(147, 11, 2, 102);
		panel_1.add(separator_3);
		
		 txtCarrerasLocal = new JFormattedTextField();
			MaskFormatter auxFormato1 = null;
			try {
				auxFormato1 = new MaskFormatter("##");
				auxFormato1.setPlaceholder("00");
				} catch (ParseException e) {
			
				e.printStackTrace();
			}
			
		     txtCarrerasLocal = new JFormattedTextField(auxFormato1);
		    
		 txtCarrerasLocal.setEditable(false);
		 txtCarrerasLocal.setOpaque(false);
		txtCarrerasLocal.setBounds(10, 49, 49, 26);
		panel_1.add(txtCarrerasLocal);
		
 txtCarrerasVisitante = new JFormattedTextField();
	MaskFormatter auxFormato2 = null;
	try {
		auxFormato2 = new MaskFormatter("##");
		auxFormato2.setPlaceholder("00");
		} catch (ParseException e) {
	
		e.printStackTrace();
	}
	
     txtCarrerasVisitante = new JFormattedTextField(auxFormato2);
		txtCarrerasVisitante.setOpaque(false);
		txtCarrerasVisitante.setEditable(false);
		txtCarrerasVisitante.setBounds(10, 87, 49, 26);
		panel_1.add(txtCarrerasVisitante);
		
		 txtHitsLocal = new JFormattedTextField();
			MaskFormatter auxFormato3 = null;
			try {
				auxFormato3 = new MaskFormatter("##");
				auxFormato3.setPlaceholder("00");
				} catch (ParseException e) {
			
				e.printStackTrace();
			}
			
		     txtHitsLocal = new JFormattedTextField(auxFormato3);
		 txtHitsLocal.setOpaque(false);
		txtHitsLocal.setEditable(false);
		txtHitsLocal.setBounds(81, 49, 49, 26);
		panel_1.add(txtHitsLocal);
		
	 txtHitsVisitante = new JFormattedTextField();
		MaskFormatter auxFormato4 = null;
		try {
			auxFormato4 = new MaskFormatter("##");
			auxFormato4.setPlaceholder("00");
			} catch (ParseException e) {
		
			e.printStackTrace();
		}
		
	     txtHitsVisitante = new JFormattedTextField(auxFormato4);
	 txtHitsVisitante.setOpaque(false);
		txtHitsVisitante.setEditable(false);
		txtHitsVisitante.setBounds(81, 87, 49, 26);
		panel_1.add(txtHitsVisitante);
		
	 txtErroresVisitante = new JFormattedTextField();
		MaskFormatter auxFormato5 = null;
		try {
			auxFormato5 = new MaskFormatter("##");
			auxFormato5.setPlaceholder("00");
			} catch (ParseException e) {
		
			e.printStackTrace();
		}
		
	     txtErroresVisitante = new JFormattedTextField(auxFormato5);	
	 txtErroresVisitante.setOpaque(false);
		txtErroresVisitante.setEditable(false);
		txtErroresVisitante.setBounds(159, 87, 49, 26);
		panel_1.add(txtErroresVisitante);
		
		 txtErroresLocal = new JFormattedTextField();
			MaskFormatter auxFormato6 = null;
			try {
				auxFormato6 = new MaskFormatter("##");
				auxFormato6.setPlaceholder("00");
				} catch (ParseException e) {
			
				e.printStackTrace();
			}
			
		     txtErroresLocal = new JFormattedTextField(auxFormato6);
		txtErroresLocal.setOpaque(false);
		txtErroresLocal.setEditable(false);
		txtErroresLocal.setBounds(159, 49, 49, 26);
		panel_1.add(txtErroresLocal);
		
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
		
		spnOuts = new JSpinner();
		spnOuts.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
		spnOuts.setBounds(263, 26, 168, 20);
		pnlLanzador.add(spnOuts);
		
		JLabel lblPonches = new JLabel("Ponches:");
		lblPonches.setBounds(263, 75, 168, 14);
		pnlLanzador.add(lblPonches);
		
		 spnPonches = new JSpinner();
		 spnPonches.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
		spnPonches.setBounds(263, 100, 168, 20);
		pnlLanzador.add(spnPonches);
		
		JLabel lblNewLabel = new JLabel("Bases por bolas: ");
		lblNewLabel.setBounds(263, 141, 168, 14);
		pnlLanzador.add(lblNewLabel);
		
		 spnBB = new JSpinner();
		 spnBB.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
		spnBB.setBounds(263, 166, 168, 20);
		pnlLanzador.add(spnBB);
		
		JLabel lblCarrerasPerm = new JLabel("Carreras Sucias Permitidas:");
		lblCarrerasPerm.setBounds(10, 75, 168, 14);
		pnlLanzador.add(lblCarrerasPerm);
		
	  spnCarreras = new JSpinner();
		spnCarreras.setBounds(10, 100, 168, 20);
		spnCarreras.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
		pnlLanzador.add(spnCarreras);
		
		JLabel lblCarrerasLimp = new JLabel("Carreras Limpias Permitidas: ");
		lblCarrerasLimp.setBounds(10, 141, 168, 14);
		pnlLanzador.add(lblCarrerasLimp);
		
		 spnCarrerasL = new JSpinner();
		 spnCarrerasL.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
		spnCarrerasL.setBounds(10, 166, 168, 20);
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
		
		JLabel lblPonchesVis = new JLabel("Ponches:");
		lblPonchesVis.setBounds(263, 75, 168, 14);
		panel_2.add(lblPonchesVis);
		
		 spnPonchesVis = new JSpinner();
		spnPonchesVis.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
		spnPonchesVis.setBounds(263, 100, 168, 20);
		panel_2.add(spnPonchesVis);
		
		JLabel lblBBVis = new JLabel("Bases por bolas: ");
		lblBBVis.setBounds(263, 141, 168, 14);
		panel_2.add(lblBBVis);
		
	 spnBBVis = new JSpinner();
		spnBBVis.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
		spnBBVis.setBounds(263, 166, 168, 20);
		panel_2.add(spnBBVis);
		
		JLabel lblOutsRVis = new JLabel("Outs Realizados:");
		lblOutsRVis.setBounds(319, 11, 112, 14);
		panel_2.add(lblOutsRVis);
		
	 spnOutsVis = new JSpinner();
		spnOutsVis.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
		spnOutsVis.setBounds(263, 26, 168, 20);
		panel_2.add(spnOutsVis);
		
		JLabel lblCarrerasPerVis = new JLabel("Carreras Sucias Permitidas:");
		lblCarrerasPerVis.setBounds(10, 75, 168, 14);
		panel_2.add(lblCarrerasPerVis);
		
	    spnCarPerVis = new JSpinner();
		spnCarPerVis.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
		spnCarPerVis.setBounds(10, 100, 168, 20);
		panel_2.add(spnCarPerVis);
		
		JLabel lblCarrLimPeVis = new JLabel("Carreras Limpias Permitidas: ");
		lblCarrLimPeVis.setBounds(10, 141, 168, 14);
		panel_2.add(lblCarrLimPeVis);
		
	    spnCarrLVis = new JSpinner();
		spnCarrLVis.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
		spnCarrLVis.setBounds(10, 166, 168, 20);
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
             
			Equipo auxEquipo = auxPartido.getLocal();
			for (Jugador auxJugador : auxEquipo.getAlineacion()) {
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
              
			Equipo auxEquipo = auxPartido.getVisitante();
			for (Jugador auxJugador : auxEquipo.getAlineacion()) {
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
			fila2[i] = 00;    }
				model2.addRow(fila2);  
			 fila2[0] = auxPartido.getVisitante().getNombreEquipo();
			 for(int i=1; i<=12 ; i++) {
					fila2[i] = 00;    }
			model2.addRow(fila2);  } 
	

public static void cargarEstadisticasJugadoresLocal() { 
	 Partido auxPartido = Liga.getInstance().buscarPartidoById(auxID);
	 Equipo auxEquipo = auxPartido.getLocal();
for(int i =0; i<auxEquipo.getAlineacion().size() ; i++) {  // i representa la fila de la tabla, j a la columna. 
String aux = (String)tblLocal.getModel().getValueAt(i, 0).toString();
 auxJugador = (jugadorPosicion) Liga.getInstance().buscarJugadorByNombre(aux);
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
	} } } 
 
}

public static void cargarEstadisticasJugadoresVisitante() { 
	 Partido auxPartido = Liga.getInstance().buscarPartidoById(auxID);
	 Equipo auxEquipo = auxPartido.getVisitante();
for(int i =0; i<auxEquipo.getAlineacion().size() ; i++) {  // i representa la fila de la tabla, j a la columna. 
String aux = (String)tblVisita.getModel().getValueAt(i, 0).toString();
 auxJugador = (jugadorPosicion) Liga.getInstance().buscarJugadorByNombre(aux);
for(int j =1; j<13; j++) { 
	int auxH= Integer.parseInt(tblVisita.getModel().getValueAt(i, j).toString());

	
	
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
	} } } 
 
}

public static void cargarCarreras() { 
for(int i =0; i<=1 ; i++) {  // i representa la fila de la tabla, j a la columna. 
	 auxPartido1 = Liga.getInstance().buscarPartidoById(auxID);

	 
String aux = (String)tableInnings.getModel().getValueAt(i, 0).toString();

 Equipo auxEquipo = (Equipo) Liga.getInstance().buscarEquipoByName(aux);
for(int j =1; j<13; j++) { 
	
	int auxH= Integer.parseInt(tableInnings.getModel().getValueAt(i, j).toString());
    if(aux.equalsIgnoreCase(auxPartido1.getLocal().getNombreEquipo())) {       
	auxPartido1.setLocalRun(auxPartido1.getLocalRun()+ auxH); } 
    else if(aux.equalsIgnoreCase(auxPartido1.getVisitante().getNombreEquipo())) { 
    	auxPartido1.setVisitaRun(auxPartido1.getVisitaRun() + auxH);
    }


} 
} 
}


public static void cargarStatsPitcherLocal() { 
	
	Jugador auxPitcher = Liga.getInstance().buscarJugadorByNombre( LineupPartido.cbxPitcherLocal.getSelectedItem().toString());
	
	
	 ((Pitcher) auxPitcher).setBB( ((Pitcher) auxPitcher).getBB()+((float)spnBB.getValue()));
	 ((Pitcher) auxPitcher).setPonches( ((Pitcher) auxPitcher).getPonches()+((float)spnPonches.getValue()));
	 ((Pitcher) auxPitcher).setCarrerasLimpias( ((Pitcher) auxPitcher).getCarrerasLimpias()+((float)spnCarrerasL.getValue()));
	 ((Pitcher) auxPitcher).setInningsLanzados((float) (((Pitcher) auxPitcher).getInningsLanzados()+((float)spnOuts.getValue()*(0.3333333333))));

   float auxCarreras = (((float)spnBB.getValue())+ (float)(spnCarreras.getValue()));
	 ((Pitcher) auxPitcher).setCarrerasPermitidas(auxCarreras + ((Pitcher) auxPitcher).getCarrerasPermitidas() );

}
public static void cargarStatsPitcherVis() { 
	 Jugador auxPitcher = Liga.getInstance().buscarJugadorByNombre( LineupPartido.cbxPitcherVisitante.getSelectedItem().toString());
     
	 
	
	 ((Pitcher) auxPitcher).setBB( ((Pitcher) auxPitcher).getBB()+((float)spnBBVis.getValue()));
	 ((Pitcher) auxPitcher).setPonches( ((Pitcher) auxPitcher).getPonches()+((float)spnPonchesVis.getValue()));
	 ((Pitcher) auxPitcher).setCarrerasLimpias( ((Pitcher) auxPitcher).getCarrerasLimpias()+((float)spnCarrLVis.getValue()));
	 ((Pitcher) auxPitcher).setInningsLanzados((float) (((Pitcher) auxPitcher).getInningsLanzados()+((float)spnOutsVis.getValue()*(0.3333333333))));

    float auxCarreras = (((float)spnBB.getValue())+ (float)(spnCarPerVis.getValue()));
	 ((Pitcher) auxPitcher).setCarrerasPermitidas(auxCarreras + ((Pitcher) auxPitcher).getCarrerasPermitidas() );

}



   public static void cargarLanzadores() { 
	
	   Jugador auxJugador = Liga.getInstance().buscarJugadorByNombre( LineupPartido.cbxPitcherLocal.getSelectedItem().toString());
	    txtNombreLanzador.setText(auxJugador.getNombre());
	    
	    Jugador auxJugadorVis = Liga.getInstance().buscarJugadorByNombre( LineupPartido.cbxPitcherVisitante.getSelectedItem().toString());
          txtNombreVis.setText(auxJugadorVis.getNombre());
   }
	public static void actualiarPizarra() { 
		txtCarrerasLocal.setText(""+Liga.getInstance().buscarPartidoById(auxID).getLocalRun());
		txtCarrerasVisitante.setText(""+Liga.getInstance().buscarPartidoById(auxID).getVisitaRun());
	}

} 
	

