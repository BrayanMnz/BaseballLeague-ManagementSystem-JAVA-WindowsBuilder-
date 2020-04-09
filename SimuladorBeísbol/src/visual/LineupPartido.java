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
import javax.swing.JMenuBar;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LineupPartido extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable tablaLocal;
	private JTable tablaVisitante;
	private static DefaultTableModel model; 
	private static DefaultTableModel model1;
	private static Object[] fila1;
	private static Object[] fila; 
	private static DefaultTableModel modelLineup; 
	private static DefaultTableModel model1Lineup;
	private static Object[] fila1Lineup;
	private static Object[] filaLineup;
	private static String auxID;
	public static JComboBox<String> cbxPitcherVisitante;
	public static JComboBox<String> cbxPitcherLocal;
	private static JScrollPane scrollPaneVisita;
	private static JScrollPane scrollPaneLocal;
	private static JScrollPane scrollPaneLineupL;
    private static JScrollPane scrollPaneLineupV;
	private JTable tblLineupL;
	private  static int index;
	private  static int index1;
	private  static String identificador1;
	private static String identificador;
	private static String identificadorVisitante;
	private static String identificadorVisitante1;
	private static int indexVis;
	

	private static JButton btnanadirLineup;
	private static JButton btnRemoverLineup;
	private static JPanel panelAlHome;
	private static JPanel panelHomeTeam;
	private static JPanel panelVisita;
	private static JPanel panelAlVisita;
	private JButton btnLocal_1;
	private JTable table;

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
				cargarLineupLocal();
				cargarLineupVisitante();
				
			}
		});
		this.auxID = auxID;
		setTitle("Pre - Partido");
		setBounds(100, 100, 913, 462);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			 panelHomeTeam = new JPanel();
			panelHomeTeam.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Roster Equipo Local:", TitledBorder.RIGHT, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelHomeTeam.setBounds(10, 32, 413, 355);
			contentPanel.add(panelHomeTeam);
			panelHomeTeam.setOpaque(false);
			panelHomeTeam.setLayout(null);
			{
			 scrollPaneLocal = new JScrollPane();
			 scrollPaneLocal.setVisible(true);
				scrollPaneLocal.setLocation(6, 53);
				scrollPaneLocal.setSize(397, 291);
				panelHomeTeam.add(scrollPaneLocal);
				scrollPaneLocal.setOpaque(false); 
				{
					tablaLocal = new JTable();
			
					
					tablaLocal.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							
							index = tablaLocal.getSelectedRow();
							if(index >= 0) { 
								identificador = (String)tablaLocal.getModel().getValueAt(index, 0).toString();
								System.out.println(identificador);
							//	btnModify.setEnabled(true);
								//btnEliminar.setEnabled(true);
							//	btnVerEquipo.setEnabled(true);
								btnanadirLineup.setEnabled(true);
								btnRemoverLineup.setEnabled(false);
							}
						}
					});
					tablaLocal.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					scrollPaneLocal.setViewportView(tablaLocal);
				    model = new DefaultTableModel();
				    tablaLocal.setModel(model);
				    TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
				    tablaLocal.setRowSorter(sorter);
				    String[] columnNamesLocal = {"Jugador", "Pos.","Turnos",".Prom","HR"};
				    model.setColumnIdentifiers(columnNamesLocal);
				   
				   
				    {
				    	JLabel lblPitcherLocal = new JLabel("Lanzador Local:");
				    	lblPitcherLocal.setBounds(10, 28, 93, 14);
				    	panelHomeTeam.add(lblPitcherLocal);
				    }
				    {
				    	 cbxPitcherLocal = new JComboBox();
				    	cbxPitcherLocal.setBounds(151, 26, 170, 22);
				    	panelHomeTeam.add(cbxPitcherLocal);
				    }
				    
				    
				    
				    
	
				    
				    
				    
				    
				    
	   panelAlHome = new JPanel();
	   panelAlHome.setOpaque(false);
	   panelAlHome.setBounds(474, 32, 413, 355);
	   contentPanel.add(panelAlHome);
	   panelAlHome.setBorder(new TitledBorder(null, "Alineacion Equipo Local", TitledBorder.CENTER, TitledBorder.TOP, null, null));
	   panelAlHome.setLayout(null);
	   
	   scrollPaneLineupL = new JScrollPane();
	   scrollPaneLineupL.setBounds(10, 53, 393, 291);
	   panelAlHome.add(scrollPaneLineupL);
	   
	   tblLineupL = new JTable();
	   tblLineupL.addMouseListener(new MouseAdapter() {
	   	@Override
	   	public void mouseClicked(MouseEvent e) {
	   		int indice = tblLineupL.getSelectedRow();
	   		if(indice >= 0) { 
	   			identificador1 = (String)tblLineupL.getModel().getValueAt(indice, 0).toString();
	   			
	   		//	btnModify.setEnabled(true);
	   			//btnEliminar.setEnabled(true);
	   		//	btnVerEquipo.setEnabled(true);
	   			btnanadirLineup.setEnabled(false);
	   			btnRemoverLineup.setEnabled(true);
	   		}
	   		
	   	}
	   });
	   modelLineup = new DefaultTableModel();
	    TableRowSorter<TableModel> sorter1 = new TableRowSorter<TableModel>(modelLineup);
	    String[] columnNamesLineup = {"Jugador", "Hits","Turnos",".Prom","HR"};
	    modelLineup.setColumnIdentifiers(columnNamesLineup);
	   
	   tblLineupL.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	   scrollPaneLineupL.setViewportView(tblLineupL);
	   tblLineupL.setModel(modelLineup);
	   tblLineupL.setRowSorter(sorter1);
	   scrollPaneLineupL.setViewportView(tblLineupL);
	   
		  tblLineupL.getColumnModel().getColumn(0).setPreferredWidth(130);
		    TableColumn tc1 = tblLineupL.getColumnModel().getColumn(2);
		    tc1.setPreferredWidth(70);
		    TableColumn tc = tblLineupL.getColumnModel().getColumn(1);
		    tc.setPreferredWidth(70);
		    tblLineupL.getColumnModel().getColumn(3).setPreferredWidth(70);
	
		    tblLineupL.getColumnModel().getColumn(4).setPreferredWidth(70);
	   
		
				
				    JComboBox<String> cbxPos = new JComboBox<String>();
				  
				
				  cbxPos.addItem("C");  cbxPos.addItem("1B");  cbxPos.addItem("2B");  cbxPos.addItem("3B"); 
				  cbxPos.addItem("SS");  cbxPos.addItem("LF");  cbxPos.addItem("CF");  cbxPos.addItem("RF"); 
				  cbxPos.addItem("DH");
				  tablaLocal.getColumnModel().getColumn(0).setPreferredWidth(130);
				    TableColumn tc10 = tablaLocal.getColumnModel().getColumn(2);
				    tc10.setPreferredWidth(70);
				    TableColumn tc11 = tablaLocal.getColumnModel().getColumn(1);
				    tc.setPreferredWidth(70);
				    tablaLocal.getColumnModel().getColumn(3).setPreferredWidth(70);
			
				    tablaLocal.getColumnModel().getColumn(4).setPreferredWidth(70);
				  
				    TableCellEditor tce1 = new DefaultCellEditor(cbxPos);
				 
				    tc11.setCellEditor(tce1);
				}
			}
		}
		{
			 panelVisita = new JPanel();
			panelVisita.setVisible(false);
			panelVisita.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Roster Equipo Visitante: ", TitledBorder.RIGHT, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelVisita.setBounds(10, 32, 413, 355);
			contentPanel.add(panelVisita);
			panelVisita.setOpaque(false);
			panelVisita.setLayout(null);
			{
				scrollPaneVisita = new JScrollPane();
				scrollPaneVisita.setVisible(false);
				scrollPaneVisita.setBounds(6, 53, 397, 291);
				panelVisita.add(scrollPaneVisita);
				scrollPaneVisita.setOpaque(false);
				{
					tablaVisitante = new JTable();
					tablaVisitante.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							
							
							index1 = tablaVisitante.getSelectedRow();
							if(index1 >= 0) { 
								identificadorVisitante = (String)tablaVisitante.getModel().getValueAt(index1, 0).toString();
						
							//	btnModify.setEnabled(true);
								//btnEliminar.setEnabled(true);
							//	btnVerEquipo.setEnabled(true);
								btnanadirLineup.setEnabled(true);
								btnRemoverLineup.setEnabled(false);
							}
							
						}
					});
					tablaVisitante.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					model1 = new DefaultTableModel();
				    TableRowSorter<TableModel> sorter1 = new TableRowSorter<TableModel>(model1);
				    tablaVisitante.setRowSorter(sorter1);
					
					String[] columnNamesVisitante = {"Jugador", "Pos.","Turnos",".Prom","HR"};
					model1.setColumnIdentifiers(columnNamesVisitante);
					tablaVisitante.setModel(model1);
					 JComboBox<String> cbxPos = new JComboBox<String>();
					    JComboBox<Integer> cbxSlot = new JComboBox<Integer>();
					 cbxPos.addItem("C");  cbxPos.addItem("1B");  cbxPos.addItem("2B");  cbxPos.addItem("3B"); 
					  cbxPos.addItem("SS");  cbxPos.addItem("LF");  cbxPos.addItem("CF");  cbxPos.addItem("RF"); 
					  cbxPos.addItem("DH");
			
				  
				  for(int i=1; i<=9 ; i++) {
				    cbxSlot.addItem(i); }
				  tablaVisitante.getColumnModel().getColumn(0).setPreferredWidth(130);
				  tablaVisitante.getColumnModel().getColumn(1).setPreferredWidth(70);
				  tablaVisitante.getColumnModel().getColumn(2).setPreferredWidth(70);
				  tablaVisitante.getColumnModel().getColumn(3).setPreferredWidth(70);
				  tablaVisitante.getColumnModel().getColumn(4).setPreferredWidth(70);
				
				   
				    TableColumn tc = tablaVisitante.getColumnModel().getColumn(1);
				  
				    TableCellEditor tce1 = new DefaultCellEditor(cbxPos);
				    tc.setCellEditor(tce1);
				
			
					scrollPaneVisita.setViewportView(tablaVisitante);
				}
			}
			{
				JLabel lblPitcherVisitante = new JLabel("Lanzador visitante:");
				lblPitcherVisitante.setBounds(10, 28, 131, 14);
				panelVisita.add(lblPitcherVisitante);
			}
			{
			    cbxPitcherVisitante = new JComboBox();
				cbxPitcherVisitante.setBounds(151, 26, 159, 22);
				panelVisita.add(cbxPitcherVisitante);
			}
		}
	   
		
		 btnanadirLineup = new JButton("");
		 btnanadirLineup.setIcon(new ImageIcon(LineupPartido.class.getResource("/Imagenes/arrowhead_right_add.png")));
		 btnanadirLineup.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if( Liga.getInstance().buscarJugadorByNombre(identificador) != null) { 
		 		jugadorPosicion auxJugador = (jugadorPosicion) Liga.getInstance().buscarJugadorByNombre(identificador);
		
		 		Partido auxPartido = Liga.getInstance().buscarPartidoById(auxID); 
		 		auxPartido.getLocal().insertarJugadorAlineacion(auxJugador); } 
		 		else if( Liga.getInstance().buscarJugadorByNombre(identificador)== null) { 
		 		jugadorPosicion auxJugador =	 (jugadorPosicion) Liga.getInstance().buscarJugadorByNombre(identificadorVisitante) ;
		 		Partido auxPartido = Liga.getInstance().buscarPartidoById(auxID); 
		 		auxPartido.getVisitante().insertarJugadorAlineacion(auxJugador);
		 		}
		 		
		 	cargarLineupLocal();
		 	cargarLineupVisitante();

			 	
		 	
		 	}
		 });
		 btnanadirLineup.setEnabled(false);
		btnanadirLineup.setBounds(425, 139, 44, 36);
		contentPanel.add(btnanadirLineup);
		
		 btnRemoverLineup = new JButton("New button");
		 btnRemoverLineup.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		if( Liga.getInstance().buscarJugadorByNombre(identificador1) != null) { 
			 		jugadorPosicion auxJugador = (jugadorPosicion) Liga.getInstance().buscarJugadorByNombre(identificador1);
			
			 		Partido auxPartido = Liga.getInstance().buscarPartidoById(auxID); 
			 		auxPartido.getLocal().EliminarJugadorAlineacion(auxJugador); } 
			 		else if( Liga.getInstance().buscarJugadorByNombre(identificador1)== null) { 
			 		jugadorPosicion auxJugador =	 (jugadorPosicion) Liga.getInstance().buscarJugadorByNombre(identificadorVisitante1) ;
			 		Partido auxPartido = Liga.getInstance().buscarPartidoById(auxID); 
			 		auxPartido.getVisitante().EliminarJugadorAlineacion(auxJugador);
			 		}
			 	
		 		
		 	cargarLineupLocal();
		 	cargarLineupVisitante();
		 		
		 	}
		 });
		 btnRemoverLineup.setEnabled(false);
		btnRemoverLineup.setBounds(425, 186, 44, 36);
		contentPanel.add(btnRemoverLineup);
		{
			btnLocal_1 = new JButton("Local ");
			btnLocal_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelAlHome.setVisible(true);
					panelHomeTeam.setVisible(true);
					panelVisita.setVisible(false);
					panelAlVisita.setVisible(false);
					scrollPaneVisita.setVisible(false);
					tablaVisitante.setVisible(false);
					tablaLocal.setVisible(true);
					scrollPaneLocal.setVisible(true);
					tblLineupL.setVisible(true);
					table.setVisible(false);
					
					
				}
			});
			btnLocal_1.setBounds(10, 11, 89, 23);
			contentPanel.add(btnLocal_1);
		}
		{
			JButton btnVisita = new JButton("Visitante");
			btnVisita.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelAlHome.setVisible(false);
					panelHomeTeam.setVisible(false);
					panelVisita.setVisible(true);
					panelAlVisita.setVisible(true);
					scrollPaneVisita.setVisible(true);
					tablaVisitante.setVisible(true);
					tablaLocal.setVisible(false);
					scrollPaneLocal.setVisible(false);
					tblLineupL.setVisible(false);
					table.setVisible(true);
					
					
					
				}
			});
			
			btnVisita.setBounds(109, 11, 89, 23);
			contentPanel.add(btnVisita);
		}
		{
			panelAlVisita = new JPanel();
			panelAlVisita.setOpaque(false);
			panelAlVisita.setVisible(false);
			panelAlVisita.setBorder(new TitledBorder(null, "Alineacion Equipo Visitante", TitledBorder.CENTER, TitledBorder.TOP, null, null));
			panelAlVisita.setBounds(474, 32, 413, 355);
			contentPanel.add(panelAlVisita);
			panelAlVisita.setLayout(null);
			
			
			scrollPaneLineupV = new JScrollPane();
			scrollPaneLineupV.setBounds(10, 53, 393, 291);
			panelAlVisita.add(scrollPaneLineupV);
			
			table = new JTable();
	
			model1Lineup = new DefaultTableModel(); 
			String[] columnLineup = {"Jugador","Hits","Turnos",".Prom","HR"};
			model1Lineup.setColumnIdentifiers(columnLineup);
			table.setModel(model1Lineup);
			  
			table.getColumnModel().getColumn(0).setPreferredWidth(130);

			table.getColumnModel().getColumn(1).setPreferredWidth(70);

			table.getColumnModel().getColumn(2).setPreferredWidth(70);

			table.getColumnModel().getColumn(3).setPreferredWidth(70);
            table.getColumnModel().getColumn(4).setPreferredWidth(70);
			
			  tablaVisitante.getColumnModel().getColumn(0).setPreferredWidth(130);
			  tablaVisitante.getColumnModel().getColumn(1).setPreferredWidth(70);
			  tablaVisitante.getColumnModel().getColumn(2).setPreferredWidth(70);
			  tablaVisitante.getColumnModel().getColumn(3).setPreferredWidth(70);
			  tablaVisitante.getColumnModel().getColumn(4).setPreferredWidth(70);
			 
			
			  
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						indexVis = table.getSelectedRow();
						if(indexVis >= 0) { 
							identificadorVisitante1 = (String)table.getModel().getValueAt(indexVis, 0).toString();
					
						//	btnModify.setEnabled(true);
							//btnEliminar.setEnabled(true);
						//	btnVerEquipo.setEnabled(true);
							btnanadirLineup.setEnabled(false);
							btnRemoverLineup.setEnabled(true);
						}
					}
				});
	
			
			
		
		
			scrollPaneLineupV.setViewportView(table);
			panelAlVisita.setBounds(474, 32, 413, 355);
			contentPanel.add(panelAlVisita);
			panelAlVisita.setLayout(null);
			
			
			scrollPaneLineupV = new JScrollPane();
			scrollPaneLineupV.setBounds(10, 53, 393, 291);
			panelAlVisita.add(scrollPaneLineupV);
			
		}
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LineupPartido.class.getResource("/Imagenes/fondoLineup2.jpg")));
		lblNewLabel.setBounds(0, 0, 897, 387);
		contentPanel.add(lblNewLabel);
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
	//	fila[1] = "Orden al bate";
		fila[1] = "Pos Def.";
		fila[2] = ((jugadorPosicion) auxJugador).getTurnos();
		fila[3] = ((jugadorPosicion) auxJugador).promBateo();
		fila[4] =  ((jugadorPosicion) auxJugador).getHr();
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
	//	fila1[1] = "Orden al bate";
		fila1[1] = "Pos Def.";
		fila1[2] = ((jugadorPosicion) auxJugador).getTurnos();
		fila1[3] = ((jugadorPosicion) auxJugador).promBateo();
		fila1[4] =  ((jugadorPosicion) auxJugador).getHr();
		model1.addRow(fila1);
	//	fila[4] = auxJugador.totalHR();
		}}}}
  
  private static void cargarLineupLocal() { 
		 Partido auxPartido = Liga.getInstance().buscarPartidoById(auxID);
		modelLineup.setRowCount(0); 
		filaLineup = new Object[modelLineup.getColumnCount()];
	for (Equipo auxEquipo : Liga.getInstance().getMisEquipos()) {
		for(Jugador auxJugador: auxEquipo.getAlineacion()) { 
		
       if(auxJugador.getEquipo().equalsIgnoreCase(auxPartido.getLocal().getNombreEquipo())) { 
       if(auxJugador instanceof jugadorPosicion) { 
		filaLineup[0] = auxJugador.getNombre();
	//	filaLineup[1] = "Orden al bate";
		filaLineup[1] = ((jugadorPosicion) auxJugador).getHits();
		filaLineup[2] = ((jugadorPosicion) auxJugador).getTurnos();
		filaLineup[3] = ((jugadorPosicion) auxJugador).promBateo();
		filaLineup[4] =  ((jugadorPosicion) auxJugador).getHr();
		modelLineup.addRow(filaLineup);
	//	fila[4] = auxJugador.totalHR();
		}}}} }
  
  private static void cargarLineupVisitante() { 
		 Partido auxPartido = Liga.getInstance().buscarPartidoById(auxID);
		model1Lineup.setRowCount(0); 
		fila1Lineup = new Object[model1Lineup.getColumnCount()];
	for (Equipo auxEquipo : Liga.getInstance().getMisEquipos()) {
		for(Jugador auxJugador: auxEquipo.getAlineacion()) { 
		
    if(auxJugador.getEquipo().equalsIgnoreCase(auxPartido.getVisitante().getNombreEquipo())) { 
    if(auxJugador instanceof jugadorPosicion) { 
		fila1Lineup[0] = auxJugador.getNombre();
	//	filaLineup[1] = "Orden al bate";
		fila1Lineup[1] = ((jugadorPosicion) auxJugador).getHits();
		fila1Lineup[2] = ((jugadorPosicion) auxJugador).getTurnos();
		fila1Lineup[3] = ((jugadorPosicion) auxJugador).promBateo();
		fila1Lineup[4] =  ((jugadorPosicion) auxJugador).getHr();
		model1Lineup.addRow(fila1Lineup);
	//	fila[4] = auxJugador.totalHR();
		}}}} }
  
  
  
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


