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

public class IniciarPartido extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable tblLocal;
	private JTable tblVisita;
	private static DefaultTableModel model; 
	private static DefaultTableModel model1;
	private static DefaultTableModel model2;
	private static Object[] fila1;
	private static Object[] fila; 
	private static Object[] fila2; 
	private static String auxID;
	private static JFormattedTextField txtAux;

	private static JTextField txtNombreEquipo;
	private JTextField txtNombreLanzador;
	private JTextField txtInnings;
	private static 	JScrollPane scpnVisitante;
	private static 	JScrollPane scpnLocal;
	private static JButton btnVisitante;
private static JButton btnLocal;
private JTable tableInnings;

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
		panelAnotacion.setBounds(10, 171, 885, 292);
		contentPanel.add(panelAnotacion);
		panelAnotacion.setLayout(null);
		
		scpnLocal = new JScrollPane();
		scpnLocal.setVisible(true);
		scpnLocal.setBounds(6, 74, 869, 207);
		panelAnotacion.add(scpnLocal);
		
		tblLocal = new JTable();
		tblLocal.setVisible(true);
		model = new DefaultTableModel();
		String[] columnNamesLocal = {"Jugador","1IN","2IN","3IN","4IN","5IN","6IN","7IN","8IN","9IN","10IN","11IN","12IN"};
		model.setColumnIdentifiers(columnNamesLocal);
		tblLocal.setModel(model);
		scpnLocal.setViewportView(tblLocal);
		
		 JComboBox<Integer> cbxAux = new JComboBox<Integer>();
		 for(int i=0; i<=5; i++) { 
			 cbxAux.addItem(i);}
		 TableColumn tc1 = tblLocal.getColumnModel().getColumn(1);
		 TableColumn tc2 = tblLocal.getColumnModel().getColumn(2);
		 TableColumn tc3 = tblLocal.getColumnModel().getColumn(3);
		 TableColumn tc4 = tblLocal.getColumnModel().getColumn(4);
		 TableColumn tc5 = tblLocal.getColumnModel().getColumn(5);
		 TableColumn tc6 = tblLocal.getColumnModel().getColumn(6);
		 TableColumn tc7 = tblLocal.getColumnModel().getColumn(7);
		 TableColumn tc8 = tblLocal.getColumnModel().getColumn(8);
		 TableColumn tc9 = tblLocal.getColumnModel().getColumn(9);
		 TableColumn tc10 = tblLocal.getColumnModel().getColumn(10);
		 TableColumn tc11 = tblLocal.getColumnModel().getColumn(11);
		 TableColumn tc12 = tblLocal.getColumnModel().getColumn(12);
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
			tblVisita.setVisible(false);
			tblVisita.setModel(model1);
			TableColumn tcc1 = tblVisita.getColumnModel().getColumn(1);
			TableColumn tcc2 = tblVisita.getColumnModel().getColumn(2);
			TableColumn tcc3 = tblVisita.getColumnModel().getColumn(3);
			TableColumn tcc4 = tblVisita.getColumnModel().getColumn(4);
			TableColumn tcc5 = tblVisita.getColumnModel().getColumn(5);
			TableColumn tcc6 = tblVisita.getColumnModel().getColumn(6);
			TableColumn tcc7 = tblVisita.getColumnModel().getColumn(7);
			TableColumn tcc8 = tblVisita.getColumnModel().getColumn(8);
			TableColumn tcc9 = tblVisita.getColumnModel().getColumn(9);
			TableColumn tcc10 = tblVisita.getColumnModel().getColumn(10);
			TableColumn tcc11 = tblVisita.getColumnModel().getColumn(11);
			TableColumn tcc12 = tblVisita.getColumnModel().getColumn(12);
			
			
			scpnVisitante.setViewportView(tblVisita);
			
			 btnLocal = new JButton("Local");
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
		
		 JComboBox<Integer> cbxAux1 = new JComboBox<Integer>();
		 for(int i=0; i<=5; i++) { 
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
		panel.setBorder(new TitledBorder(null, "Marcador: ", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 885, 135);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JPanel panelinnings = new JPanel();
		panelinnings.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelinnings.setBounds(10, 23, 635, 101);
		panel.add(panelinnings);
		panelinnings.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scpInnings = new JScrollPane();
		panelinnings.add(scpInnings, BorderLayout.CENTER);
		
		tableInnings = new JTable();
		model2 = new DefaultTableModel();
		String[] columnNamesMarcador = {"Equipo","1IN","2IN","3IN","4IN","5IN","6IN","7IN","8IN","9IN","10IN","11IN","12IN"};
		model2.setColumnIdentifiers(columnNamesMarcador);
        tableInnings.setModel(model2);
        
		TableColumn tccc1 = tableInnings.getColumnModel().getColumn(1);
		TableColumn tccc2 = tableInnings.getColumnModel().getColumn(2);
		TableColumn tccc3 = tableInnings.getColumnModel().getColumn(3);
		TableColumn tccc4 = tableInnings.getColumnModel().getColumn(4);
		TableColumn tccc5 = tableInnings.getColumnModel().getColumn(5);
		TableColumn tccc6 = tableInnings.getColumnModel().getColumn(6);
		TableColumn tccc7 = tableInnings.getColumnModel().getColumn(7);
		TableColumn tccc8 = tableInnings.getColumnModel().getColumn(8);
		TableColumn tccc9 = tableInnings.getColumnModel().getColumn(9);
		TableColumn tccc10 = tableInnings.getColumnModel().getColumn(10);
		TableColumn tccc11 = tableInnings.getColumnModel().getColumn(11);
		TableColumn tccc12 = tableInnings.getColumnModel().getColumn(12);
		
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
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				cargarEstadisticasJugadores();	
			}
		});
		btnNewButton.setBounds(721, 80, 89, 23);
		panel.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(10, 157, 885, 13);
		contentPanel.add(separator);
		
		JPanel pnlLanzador = new JPanel();
		pnlLanzador.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Lanzador", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlLanzador.setBounds(10, 463, 440, 197);
		contentPanel.add(pnlLanzador);
		pnlLanzador.setLayout(null);
		
		JLabel lblNombreLanzador = new JLabel("Nombre: ");
		lblNombreLanzador.setBounds(10, 11, 168, 14);
		pnlLanzador.add(lblNombreLanzador);
		
		txtNombreLanzador = new JTextField();
		txtNombreLanzador.setEditable(false);
		txtNombreLanzador.setBounds(10, 26, 168, 20);
		pnlLanzador.add(txtNombreLanzador);
		txtNombreLanzador.setColumns(10);
		
		JLabel lblOutsRealizados = new JLabel("Outs Realizados:");
		lblOutsRealizados.setBounds(263, 11, 131, 14);
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
		
			
		
		
		

	}
	
	public static void cargarLineupLocal() { 
		 Partido auxPartido = Liga.getInstance().buscarPartidoById(auxID);
		 txtNombreEquipo.setText(auxPartido.getLocal().nombreEquipo);
			model.setRowCount(0);
			fila = new Object[model.getColumnCount()]; 
		     
			for (Jugador auxJugador : Liga.getInstance().getMisJugadores()) {
		      if(auxJugador.getEquipo().equalsIgnoreCase(auxPartido.getLocal().getNombreEquipo())) { 
		          if(auxJugador instanceof jugadorPosicion) { 
		        	
		        	  fila[0] = auxJugador.getNombre();	
		        	  for(int i=1; i<=12 ; i++) {
			         fila[i] = "<Anotar>";   }
	                model.addRow(fila);        
	                    }}}}
	
	public static void cargarLineupVisitante() { 
		 Partido auxPartido = Liga.getInstance().buscarPartidoById(auxID);
	
			model1.setRowCount(0);
			fila1 = new Object[model1.getColumnCount()];
		     
			for (Jugador auxJugador : Liga.getInstance().getMisJugadores()) {
		      if(auxJugador.getEquipo().equalsIgnoreCase(auxPartido.getVisitante().getNombreEquipo())) { 
		          if(auxJugador instanceof jugadorPosicion) { 
			fila1[0] = auxJugador.getNombre();
			 for(int i=1; i<=12 ; i++) {
			fila1[i] = "<Anotar>";    }
			model1.addRow(fila1);  
			     }}}}
	public static void cargarMarcador() { 
		 Partido auxPartido = Liga.getInstance().buscarPartidoById(auxID);
	
			model2.setRowCount(0);
			fila2 = new Object[model2.getColumnCount()];
		     	       
			fila2[0] = auxPartido.getLocal().getNombreEquipo();
			 for(int i=1; i<=12 ; i++) {
			fila2[i] = "-";    }
				model2.addRow(fila2);  
			 fila2[0] = auxPartido.getVisitante().getNombreEquipo();
			 for(int i=1; i<=12 ; i++) {
					fila2[i] = "-";    }
			model2.addRow(fila2);  } 
	

public static void cargarEstadisticasJugadores() { 
for(int i =0; i<=9 ; i++) {  // i representa la fila de la tabla, j a la columna. 
String aux = (String)tblLocal.getModel().getValueAt(i, 0).toString();
    for (Equipo auxEquipo : Liga.getInstance().getMisEquipos()) {
    	jugadorPosicion auxJugador = (jugadorPosicion) auxEquipo.buscarJugadorByNombre(aux);
    	
    	for(int j=1; j<=12; j++) { 
    	 String auxH = tblLocal.getModel().getValueAt(i, j).toString();
    		if(auxH.equalsIgnoreCase("0")) { 
                auxJugador.setTurnosPartido(1);
	  		      auxJugador.setPonchesPartido(1); }
    	 else if(auxH.equalsIgnoreCase("1")) { 
                  auxJugador.setTurnosPartido(1);
	  		      auxJugador.setHitsPartido(1); } 
    		else if(auxH.equalsIgnoreCase("2")) { 
  		      auxJugador.setHitsPartido(1);
  		      auxJugador.setDoblesPartido(1); 
  		      auxJugador.setTurnosPartido(1);}
    		else if(auxH.equalsIgnoreCase("3")) { 
    		      auxJugador.setHitsPartido(1);
    		      auxJugador.setTriplesPartido(1);

	  		      auxJugador.setTurnosPartido(1);}
    		else if(auxH.equalsIgnoreCase("4")) { 
    		      auxJugador.setHitsPartido(1);
    		      auxJugador.setHrPartido(1);
    		      auxJugador.setTurnosPartido(1);
    		      } else if(auxH.equalsIgnoreCase("5")) { 
    	  		      auxJugador.setBBPartido(1);  }
    	    		}}}}

	

} 
	

