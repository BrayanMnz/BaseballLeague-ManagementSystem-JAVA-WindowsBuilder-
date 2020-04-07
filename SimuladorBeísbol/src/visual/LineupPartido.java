package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import logico.Equipo;
import logico.Jugador;
import logico.Liga;
import logico.Partido;
import logico.Pitcher;
import logico.jugadorPosicion;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LineupPartido extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable tablaLocal;
	private JTable tablaVisitante;
	private static DefaultTableModel model; 
	private static DefaultTableModel model1;
	private static Object[] fila1;
	private static Object[] fila; 
	private static String auxID;
	public static JComboBox<String> cbxPitcherVisitante;
	public static JComboBox<String> cbxPitcherLocal;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LineupPartido dialog = new LineupPartido(auxID);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LineupPartido(String auxID) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				cargarLocal();
				cargarVisitante();
				cargarLanzadoresEnCBX();
				
			}
		});
		this.auxID = auxID;
		setTitle("Pre - Partido");
		setBounds(100, 100, 913, 469);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panelHomeTeam = new JPanel();
			panelHomeTeam.setBorder(new TitledBorder(null, "Alineacion Equipo Local:", TitledBorder.CENTER, TitledBorder.TOP, null, null));
			panelHomeTeam.setBounds(10, 0, 422, 386);
			contentPanel.add(panelHomeTeam);
			panelHomeTeam.setOpaque(false);
			panelHomeTeam.setLayout(null);
			{
				JScrollPane scrollPaneLocal = new JScrollPane();
				scrollPaneLocal.setLocation(6, 53);
				scrollPaneLocal.setSize(410, 322);
				panelHomeTeam.add(scrollPaneLocal);
				scrollPaneLocal.setOpaque(false); 
				{
					tablaLocal = new JTable();
					tablaLocal.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					scrollPaneLocal.setViewportView(tablaLocal);
				    model = new DefaultTableModel();
				    tablaLocal.setModel(model);
				    TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
				    tablaLocal.setRowSorter(sorter);
				    String[] columnNamesLocal = {"Jugador", "TB", "Pos.","Turnos",".Prom","HR"};
				    model.setColumnIdentifiers(columnNamesLocal);
				   
				   
				    {
				    	JLabel lblPitcherLocal = new JLabel("Lanzador Local:");
				    	lblPitcherLocal.setBounds(10, 28, 93, 14);
				    	panelHomeTeam.add(lblPitcherLocal);
				    }
				    {
				    	 cbxPitcherLocal = new JComboBox();
				    	cbxPitcherLocal.setBounds(127, 24, 170, 22);
				    	panelHomeTeam.add(cbxPitcherLocal);
				    }
		
				    JComboBox<Integer> cbxSlot = new JComboBox<Integer>();
				    JComboBox<String> cbxPos = new JComboBox<String>();
				  
				  for(int i=1; i<=9 ; i++) {
				    cbxSlot.addItem(i); }
				  cbxPos.addItem("C");  cbxPos.addItem("1B");  cbxPos.addItem("2B");  cbxPos.addItem("3B"); 
				  cbxPos.addItem("SS");  cbxPos.addItem("LF");  cbxPos.addItem("CF");  cbxPos.addItem("RF"); 
				  cbxPos.addItem("DH");
				  tablaLocal.getColumnModel().getColumn(0).setPreferredWidth(120);
				    TableColumn tc1 = tablaLocal.getColumnModel().getColumn(2);
				    tc1.setPreferredWidth(62);
				    TableColumn tc = tablaLocal.getColumnModel().getColumn(1);
				    tc.setPreferredWidth(62);
				    tablaLocal.getColumnModel().getColumn(3).setPreferredWidth(62);
				    tablaLocal.getColumnModel().getColumn(5).setPreferredWidth(52);
				    tablaLocal.getColumnModel().getColumn(4).setPreferredWidth(52);
				    TableCellEditor tce = new DefaultCellEditor(cbxSlot);
				    TableCellEditor tce1 = new DefaultCellEditor(cbxPos);
				    tc.setCellEditor(tce);
				    tc1.setCellEditor(tce1);
				}
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Alineacion Equipo Visitante: ", TitledBorder.CENTER, TitledBorder.TOP, null, null));
			panel.setBounds(465, 0, 422, 386);
			contentPanel.add(panel);
			panel.setOpaque(false);
			panel.setLayout(null);
			{
				JScrollPane scrollPaneVisita = new JScrollPane();
				scrollPaneVisita.setBounds(6, 55, 410, 320);
				panel.add(scrollPaneVisita);
				scrollPaneVisita.setOpaque(false);
				{
					tablaVisitante = new JTable();
					tablaVisitante.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					model1 = new DefaultTableModel();
				    TableRowSorter<TableModel> sorter1 = new TableRowSorter<TableModel>(model1);
				    tablaVisitante.setRowSorter(sorter1);
					
					String[] columnNamesVisitante = {"Jugador", "TB", "Pos.","Turnos",".Prom","HR"};
					model1.setColumnIdentifiers(columnNamesVisitante);
					tablaVisitante.setModel(model1);
					 JComboBox<String> cbxPos = new JComboBox<String>();
					    JComboBox<Integer> cbxSlot = new JComboBox<Integer>();
					 cbxPos.addItem("C");  cbxPos.addItem("1B");  cbxPos.addItem("2B");  cbxPos.addItem("3B"); 
					  cbxPos.addItem("SS");  cbxPos.addItem("LF");  cbxPos.addItem("CF");  cbxPos.addItem("RF"); 
					  cbxPos.addItem("DH");
			
				  
				  for(int i=1; i<=9 ; i++) {
				    cbxSlot.addItem(i); }
				  tablaVisitante.getColumnModel().getColumn(0).setPreferredWidth(120);
				  tablaVisitante.getColumnModel().getColumn(1).setPreferredWidth(62);
				  tablaVisitante.getColumnModel().getColumn(2).setPreferredWidth(62);
				  tablaVisitante.getColumnModel().getColumn(3).setPreferredWidth(62);
				  tablaVisitante.getColumnModel().getColumn(4).setPreferredWidth(52);
				  tablaVisitante.getColumnModel().getColumn(5).setPreferredWidth(52);
				    TableColumn tc1 = tablaVisitante.getColumnModel().getColumn(2);
				    TableColumn tc = tablaVisitante.getColumnModel().getColumn(1);
				    TableCellEditor tce = new DefaultCellEditor(cbxSlot);
				    TableCellEditor tce1 = new DefaultCellEditor(cbxPos);
				    tc1.setCellEditor(tce1);
				    tc.setCellEditor(tce);
			
					scrollPaneVisita.setViewportView(tablaVisitante);
				}
			}
			{
				JLabel lblPitcherVisitante = new JLabel("Lanzador visitante:");
				lblPitcherVisitante.setBounds(10, 30, 131, 14);
				panel.add(lblPitcherVisitante);
			}
			{
			    cbxPitcherVisitante = new JComboBox();
				cbxPitcherVisitante.setBounds(151, 26, 159, 22);
				panel.add(cbxPitcherVisitante);
			}
		}
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(LineupPartido.class.getResource("/Imagenes/fondoLineup2.jpg")));
		lblFondo.setBounds(0, 0, 897, 401);
		contentPanel.add(lblFondo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnIniciar = new JButton("Iniciar !");
				btnIniciar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						IniciarPartido p1 = new IniciarPartido(LineupPartido.auxID);
						p1.setModal(true);
						p1.setLocationRelativeTo(null);
						p1.setVisible(true);
					}
				});
				btnIniciar.setActionCommand("OK");
				buttonPane.add(btnIniciar);
				getRootPane().setDefaultButton(btnIniciar);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
  private static void cargarLocal() { 
		 Partido auxPartido = Liga.getInstance().buscarPartidoById(auxID);
		model.setRowCount(0); fila = new Object[model.getColumnCount()];
		     
		for (Jugador auxJugador : Liga.getInstance().getMisJugadores()) {
	  if(auxJugador.getEquipo().equalsIgnoreCase(auxPartido.getLocal().getNombreEquipo())) { 
 if(auxJugador instanceof jugadorPosicion) { 
		fila[0] = auxJugador.getNombre();
		fila[1] = "Orden al bate";
		fila[2] = "Pos Def.";
		fila[3] = ((jugadorPosicion) auxJugador).getTurnos();
		fila[4] = ((jugadorPosicion) auxJugador).promBateo();
		fila[5] =  ((jugadorPosicion) auxJugador).getHr();
		model.addRow(fila);
	//	fila[4] = auxJugador.totalHR();
		}}}}
  private static void cargarVisitante() { 
	 Partido auxPartido = Liga.getInstance().buscarPartidoById(auxID);
		model1.setRowCount(0); fila1 = new Object[model1.getColumnCount()];
	     
		for (Jugador auxJugador : Liga.getInstance().getMisJugadores()) {
	      if(auxJugador.getEquipo().equalsIgnoreCase(auxPartido.getVisitante().getNombreEquipo())) { 
	          if(auxJugador instanceof jugadorPosicion) { 
		fila1[0] = auxJugador.getNombre();
		fila1[1] = "Orden al bate";
		fila1[2] = "Pos Def.";
		fila1[3] = ((jugadorPosicion) auxJugador).getTurnos();
		fila1[4] = ((jugadorPosicion) auxJugador).promBateo();
		fila1[5] =  ((jugadorPosicion) auxJugador).getHr();
		model1.addRow(fila1);
	//	fila[4] = auxJugador.totalHR();
		}}}}
  
	private void cargarLanzadoresEnCBX () {
		 Partido auxPartido = Liga.getInstance().buscarPartidoById(auxID);
		    
		
			 for (Jugador auxJugador : Liga.getInstance().getMisJugadores()) {
				 if(auxJugador instanceof Pitcher) { 
				if(auxJugador.getEquipo().equalsIgnoreCase(auxPartido.getLocal().getNombreEquipo())) { 
					cbxPitcherLocal.addItem(auxJugador.getNombre());
				} else if(auxJugador.getEquipo().equalsIgnoreCase(auxPartido.getVisitante().getNombreEquipo())) { 
					cbxPitcherVisitante.addItem(auxJugador.getNombre());
				}
				}
			}
		 }
		
	

  
}
