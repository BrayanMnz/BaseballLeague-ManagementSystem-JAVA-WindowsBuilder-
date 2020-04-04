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

import logico.Jugador;
import logico.Liga;
import logico.Partido;
import logico.jugadorPosicion;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class LineupPartido extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tablaLocal;
	private JTable tablaVisitante;
	private static DefaultTableModel model; 
	private static DefaultTableModel model1;
	private static Object[] fila1;
	private static Object[] fila; 
	private static String auxID;
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
				
			}
		});
		this.auxID = auxID;
		setTitle("Pre - Partido");
		setBounds(100, 100, 913, 448);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panelHomeTeam = new JPanel();
			panelHomeTeam.setBorder(new TitledBorder(null, "Alineacion Equipo Local:", TitledBorder.CENTER, TitledBorder.TOP, null, null));
			panelHomeTeam.setBounds(10, 11, 422, 354);
			contentPanel.add(panelHomeTeam);
			panelHomeTeam.setLayout(new BorderLayout(0, 0));
			panelHomeTeam.setOpaque(false);
			{
				JScrollPane scrollPaneLocal = new JScrollPane();
				scrollPaneLocal.setSize(422, 332);
				panelHomeTeam.add(scrollPaneLocal, BorderLayout.CENTER);
				scrollPaneLocal.setOpaque(false);
				{
					tablaLocal = new JTable();
					scrollPaneLocal.setViewportView(tablaLocal);
				    model = new DefaultTableModel();
				    String[] columnNamesLocal = {"Jugador", "Slot", "Pos.","Turnos",".Prom","HR"};
				    model.setColumnIdentifiers(columnNamesLocal);
				    tablaLocal.setModel(model);
				    JComboBox<Integer> cbxSlot = new JComboBox<Integer>();
				  for(int i =0; i<10 ; i++) {
				    cbxSlot.addItem(i); }
				    
				    TableColumn tc = tablaLocal.getColumnModel().getColumn(1);
				    TableCellEditor tce = new DefaultCellEditor(cbxSlot);
				    tc.setCellEditor(tce);
				    
				}
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Alineacion Equipo Visitante: ", TitledBorder.CENTER, TitledBorder.TOP, null, null));
			panel.setBounds(465, 11, 422, 354);
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			panel.setOpaque(false);
			{
				JScrollPane scrollPaneVisita = new JScrollPane();
				panel.add(scrollPaneVisita, BorderLayout.CENTER);
				scrollPaneVisita.setOpaque(false);
				{
					tablaVisitante = new JTable();
					model1 = new DefaultTableModel();
					String[] columnNamesVisitante = {"Jugador", "Slot", "Pos.","Turnos",".Prom","HR"};
					model1.setColumnIdentifiers(columnNamesVisitante);
					tablaVisitante.setModel(model1);
			
					
					scrollPaneVisita.setViewportView(tablaVisitante);
				}
			}
		}
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(LineupPartido.class.getResource("/Imagenes/fondoLineup2.jpg")));
		lblFondo.setBounds(0, 0, 897, 376);
		contentPanel.add(lblFondo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
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
 if(!auxJugador.getPosicion().equalsIgnoreCase("Pitcher")) { 
		fila[0] = auxJugador.getNombre();
		fila[1] = "Orden al bate";
		fila[3] = ((jugadorPosicion) auxJugador).promBateo();
		model.addRow(fila);
	//	fila[4] = auxJugador.totalHR();
		}}}}
  private static void cargarVisitante() { 
	 Partido auxPartido = Liga.getInstance().buscarPartidoById(auxID);
		model1.setRowCount(0); fila1 = new Object[model1.getColumnCount()];
	     
		for (Jugador auxJugador : Liga.getInstance().getMisJugadores()) {
	      if(auxJugador.getEquipo().equalsIgnoreCase(auxPartido.getVisitante().getNombreEquipo())) { 
	          if(!auxJugador.getPosicion().equalsIgnoreCase("Pitcher")) { 
		fila1[0] = auxJugador.getNombre();
		fila1[1] = "Orden al bate";
		fila1[3] = ((jugadorPosicion) auxJugador).promBateo();
		model1.addRow(fila1);
	//	fila[4] = auxJugador.totalHR();
		}}}}
  
  
  
}
