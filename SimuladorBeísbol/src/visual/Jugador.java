package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logico.Equipo;
import logico.Pitcher;
import logico.Season;
import logico.jugadorPosicion;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Jugador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtJuegos;
	private JTextField txtErrores;
	private JTextField txtAltura;
	private JTextField txtPeso;
	private JTextField txtDorsal;
	private JTextField txtEquipo;
	private JTextField txtEstado;
	private JTextField txtGanados;
	private JTextField txtPerdidos;
	private JTextField txtCarrLimpias;
	private JTextField txtInnings;
	private JTextField txtPonches;
	private JTextField txtSalvados;
	private JTextField txtBB;
	private JTextField txtEmpujadas;
	private JTextField txtAnotadas;
	private JTextField txtHits;
	private JTextField txtRobadas;
	private JTextField txtHR;
	private JTextField txtTurnos;
	private JTextField txtPosicion;
	JRadioButton rdbtnPosicion;
	JRadioButton rbtnPitcher;
	JPanel panelPosicion;
	JPanel panelPitcher;
	JRadioButton rdbtnNoLesion;
	JRadioButton rdbtnLesionado;
	private Season miSeason;
	private static DefaultTableModel model;
	private static Object[] fila;
	private static JTable tablaPlayers;
	private Jugador aux = null;
	static JComboBox cbxEquipo;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Jugador dialog = new Jugador();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Jugador() {
		setBounds(100, 100, 894, 624);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
	
		//PROBANDO QUE COMBOBOX CARGARA LOS NOMBRES DE LOS EQUIPOS
		
		/*	Equipo miAux;
		miAux = new Equipo("MiEquipo","30","Estadio","Yehudy",30,25,5);
		Season.getInstance().insertarEquipo(miAux);		
		*/ 
		
		JPanel pnlAddPlayer = new JPanel();
		pnlAddPlayer.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlAddPlayer.setBounds(10, 11, 858, 172);
		contentPanel.add(pnlAddPlayer);
		pnlAddPlayer.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 11, 42, 14);
		pnlAddPlayer.add(lblNombre);
		
		JLabel lblDorsal = new JLabel("#Dorsal");
		lblDorsal.setBounds(210, 11, 46, 14);
		pnlAddPlayer.add(lblDorsal);
		
		JLabel lblCantJuegos = new JLabel("#Juegos");
		lblCantJuegos.setBounds(10, 36, 46, 14);
		pnlAddPlayer.add(lblCantJuegos);
		
		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setBounds(210, 36, 46, 14);
		pnlAddPlayer.add(lblEquipo);
		
		JLabel lblErrores = new JLabel("lblErrores");
		lblErrores.setBounds(10, 61, 46, 14);
		pnlAddPlayer.add(lblErrores);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(210, 61, 46, 14);
		pnlAddPlayer.add(lblEstado);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(10, 86, 46, 14);
		pnlAddPlayer.add(lblAltura);
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setBounds(10, 111, 46, 14);
		pnlAddPlayer.add(lblPeso);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(62, 8, 138, 20);
		pnlAddPlayer.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtJuegos = new JTextField();
		txtJuegos.setBounds(62, 33, 138, 20);
		pnlAddPlayer.add(txtJuegos);
		txtJuegos.setColumns(10);
		
		txtErrores = new JTextField();
		txtErrores.setBounds(62, 58, 138, 20);
		pnlAddPlayer.add(txtErrores);
		txtErrores.setColumns(10);
		
		txtAltura = new JTextField();
		txtAltura.setBounds(62, 83, 86, 20);
		pnlAddPlayer.add(txtAltura);
		txtAltura.setColumns(10);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(62, 108, 86, 20);
		pnlAddPlayer.add(txtPeso);
		txtPeso.setColumns(10);
		
		txtDorsal = new JTextField();
		txtDorsal.setBounds(266, 8, 86, 20);
		pnlAddPlayer.add(txtDorsal);
		txtDorsal.setColumns(10);
		
		txtEquipo = new JTextField();
		txtEquipo.setBounds(266, 33, 86, 20);
		pnlAddPlayer.add(txtEquipo);
		txtEquipo.setColumns(10);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(266, 58, 86, 20);
		pnlAddPlayer.add(txtEstado);
		txtEstado.setColumns(10);

		rbtnPitcher = new JRadioButton("Pitcher");
		rbtnPitcher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rbtnPitcher.setSelected(true);
				rdbtnPosicion.setSelected(false);
				panelPosicion.setVisible(false);
				panelPitcher.setVisible(true);
			}
		});
		rbtnPitcher.setBounds(389, 11, 109, 23);
		pnlAddPlayer.add(rbtnPitcher);
				
		rdbtnPosicion = new JRadioButton("Jugador Posicion");
		rdbtnPosicion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rbtnPitcher.setSelected(false);
				rdbtnPosicion.setSelected(true);
				panelPitcher.setVisible(false);
				panelPosicion.setVisible(true);
			}
		});
		rdbtnPosicion.setBounds(389, 32, 109, 23);
		pnlAddPlayer.add(rdbtnPosicion);
		
		panelPosicion = new JPanel();
		panelPosicion.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelPosicion.setBounds(504, 11, 344, 150);
		pnlAddPlayer.add(panelPosicion);
		panelPosicion.setLayout(null);
		
		JLabel lblHits = new JLabel("Hits");
		lblHits.setBounds(10, 11, 47, 14);
		panelPosicion.add(lblHits);
		
		JLabel lblAnotadas = new JLabel("Carreras Anotadas");
		lblAnotadas.setBounds(10, 36, 97, 14);
		panelPosicion.add(lblAnotadas);
		
		JLabel lblEmpujadas = new JLabel("Carreras Empujadas");
		lblEmpujadas.setBounds(10, 61, 110, 14);
		panelPosicion.add(lblEmpujadas);
		
		JLabel lblBasesRobadas = new JLabel("Bases Robadas");
		lblBasesRobadas.setBounds(11, 86, 96, 14);
		panelPosicion.add(lblBasesRobadas);
		
		JLabel lblTurnos = new JLabel("Turnos");
		lblTurnos.setBounds(195, 11, 66, 14);
		panelPosicion.add(lblTurnos);
		
		JLabel lblHR = new JLabel("Home Runs");
		lblHR.setBounds(195, 36, 66, 14);
		panelPosicion.add(lblHR);
		
		JLabel lblPosicion = new JLabel("Posicion");
		lblPosicion.setBounds(195, 61, 66, 14);
		panelPosicion.add(lblPosicion);
		
		txtEmpujadas = new JTextField();
		txtEmpujadas.setBounds(119, 58, 39, 20);
		panelPosicion.add(txtEmpujadas);
		txtEmpujadas.setColumns(10);
		
		txtAnotadas = new JTextField();
		txtAnotadas.setBounds(119, 33, 39, 20);
		panelPosicion.add(txtAnotadas);
		txtAnotadas.setColumns(10);
		
		txtHits = new JTextField();
		txtHits.setBounds(119, 8, 39, 20);
		panelPosicion.add(txtHits);
		txtHits.setColumns(10);
		
		txtRobadas = new JTextField();
		txtRobadas.setBounds(119, 83, 39, 20);
		panelPosicion.add(txtRobadas);
		txtRobadas.setColumns(10);
		
		txtHR = new JTextField();
		txtHR.setBounds(262, 33, 39, 20);
		panelPosicion.add(txtHR);
		txtHR.setColumns(10);
		
		txtTurnos = new JTextField();
		txtTurnos.setBounds(262, 8, 39, 20);
		panelPosicion.add(txtTurnos);
		txtTurnos.setColumns(10);
		
		txtPosicion = new JTextField();
		txtPosicion.setBounds(262, 58, 39, 20);
		panelPosicion.add(txtPosicion);
		txtPosicion.setColumns(10);
		
		panelPitcher = new JPanel();
		panelPitcher.setBounds(504, 11, 344, 150);
		pnlAddPlayer.add(panelPitcher);
		panelPitcher.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelPitcher.setLayout(null);
		
		JLabel lblJuegoGanado = new JLabel("Juegos Ganados");
		lblJuegoGanado.setBounds(10, 11, 92, 14);
		panelPitcher.add(lblJuegoGanado);
		
		JLabel lblJuegosPerdidos = new JLabel("Juegos Perdidos");
		lblJuegosPerdidos.setBounds(10, 36, 92, 14);
		panelPitcher.add(lblJuegosPerdidos);
		
		JLabel lblCarreraLimpia = new JLabel("Carreras Limpias");
		lblCarreraLimpia.setBounds(10, 61, 92, 14);
		panelPitcher.add(lblCarreraLimpia);
		
		JLabel lblInningsLanzados = new JLabel("Innings Lanzados");
		lblInningsLanzados.setBounds(10, 86, 92, 14);
		panelPitcher.add(lblInningsLanzados);
		
		JLabel lblPonches = new JLabel("Ponches");
		lblPonches.setBounds(10, 111, 79, 14);
		panelPitcher.add(lblPonches);
		
		JLabel lblBB = new JLabel("BB");
		lblBB.setBounds(163, 11, 61, 14);
		panelPitcher.add(lblBB);
		
		JLabel lblSalvados = new JLabel("Salvados");
		lblSalvados.setBounds(163, 36, 61, 14);
		panelPitcher.add(lblSalvados);
		
		txtGanados = new JTextField();
		txtGanados.setBounds(98, 8, 39, 20);
		panelPitcher.add(txtGanados);
		txtGanados.setColumns(10);
		
		txtPerdidos = new JTextField();
		txtPerdidos.setBounds(98, 33, 39, 20);
		panelPitcher.add(txtPerdidos);
		txtPerdidos.setColumns(10);
		
		txtCarrLimpias = new JTextField();
		txtCarrLimpias.setBounds(98, 58, 39, 20);
		panelPitcher.add(txtCarrLimpias);
		txtCarrLimpias.setColumns(10);
		
		txtInnings = new JTextField();
		txtInnings.setBounds(98, 83, 39, 20);
		panelPitcher.add(txtInnings);
		txtInnings.setColumns(10);
		
		txtPonches = new JTextField();
		txtPonches.setBounds(98, 108, 39, 20);
		panelPitcher.add(txtPonches);
		txtPonches.setColumns(10);
		
		txtSalvados = new JTextField();
		txtSalvados.setBounds(223, 33, 39, 20);
		panelPitcher.add(txtSalvados);
		txtSalvados.setColumns(10);
		
		txtBB = new JTextField();
		txtBB.setBounds(223, 8, 39, 20);
		panelPitcher.add(txtBB);
		txtBB.setColumns(10);
		
		JLabel lblLesion = new JLabel("Lesionado?");
		lblLesion.setBounds(210, 86, 70, 14);
		pnlAddPlayer.add(lblLesion);
		
		rdbtnLesionado = new JRadioButton("Si");
		rdbtnLesionado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		rdbtnLesionado.setBounds(210, 107, 33, 23);
		pnlAddPlayer.add(rdbtnLesionado);
		
		rdbtnNoLesion = new JRadioButton("No");
		rdbtnNoLesion.setBounds(245, 107, 42, 23);
		pnlAddPlayer.add(rdbtnNoLesion);
		
		//LLAMANDO FUNCION PARA CARGAR EQUIPOS EN CBX
		cbxEquipos();

		
		JButton btnRegistrar = new JButton("Insertar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean auxBool=false;
				Equipo miAux;
				miAux = new Equipo("MiEquipo","30","Estadio","Yehudy",30,25,5);
				Season.getInstance().insertarEquipo(miAux);
				cbxEquipos();
				if (rdbtnLesionado.isSelected()) {
					auxBool = true;
				}
				if (rbtnPitcher.isSelected() && (rdbtnNoLesion.isSelected() || rdbtnLesionado.isSelected())) {
					Pitcher aux;
					aux = new Pitcher (txtNombre.getText(),txtDorsal.getText(), Float.parseFloat(txtJuegos.getText().toString()),
							Float.parseFloat(txtErrores.getText().toString()),txtEquipo.getText().toString(),auxBool,
							Float.parseFloat(txtAltura.getText().toString()), Float.parseFloat(txtPeso.getText().toString()));
					//miSeason.buscarEquipoById(aux.getEquipo()).insertarJugador(aux);
					miAux.insertarJugador(aux);
				}
				if (rdbtnPosicion.isSelected() && (rdbtnNoLesion.isSelected() || rdbtnLesionado.isSelected())) {
					jugadorPosicion aux;
					aux = new jugadorPosicion(txtNombre.getText(),txtDorsal.getText(), Float.parseFloat(txtJuegos.getText().toString()),
							Float.parseFloat(txtErrores.getText().toString()),txtEquipo.getText().toString(),auxBool,
							Float.parseFloat(txtAltura.getText().toString()),Float.parseFloat(txtPeso.getText().toString()),txtPosicion.getText());
				}
			}
		});
		btnRegistrar.setBounds(389, 57, 89, 23);
		pnlAddPlayer.add(btnRegistrar);
		
		cbxEquipo = new JComboBox();
		cbxEquipo.setModel(new DefaultComboBoxModel(new String[] {"<Equipos>"}));
		cbxEquipo.setBounds(20, 136, 86, 20);
		pnlAddPlayer.add(cbxEquipo);
		
		JPanel panelTabla = new JPanel();
		panelTabla.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelTabla.setBounds(10, 194, 566, 380);
		contentPanel.add(panelTabla);
		panelTabla.setLayout(null);
		
		JPanel listaPlayers = new JPanel();
		listaPlayers.setBounds(10, 67, 546, 302);
		panelTabla.add(listaPlayers);
		listaPlayers.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 0, 546, 2);
			listaPlayers.add(scrollPane);
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			{
				tablaPlayers = new JTable();
				tablaPlayers.setBounds(0, 302, 546, 0);
				//listaPlayers.add(tablaPlayers);
				scrollPane.setColumnHeaderView(tablaPlayers);
				String[] columnas = {"#Dorsal","Nombre","Juegos", "Equipo"};
				model = new DefaultTableModel();
				model.setColumnIdentifiers(columnas);
				tablaPlayers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				tablaPlayers.setModel(model);
				scrollPane.setViewportView(tablaPlayers);
			}
		}
	} 
	public static void loadJugadores(int selection) {
		model.setRowCount(0);
		DecimalFormat df = new DecimalFormat("#.##");
		fila = new Object[model.getColumnCount()];
		for (Equipo auxTeam : Season.getInstance().getMisEquipos()) {
			switch (selection) {
			case 0:
				for (logico.Jugador aux : auxTeam.getJugadores()) {
					fila[0] = aux.getNoDorsal();
					fila[1] = aux.getNombre();
					fila[2] = aux.getCantJuegos();
					fila[3] = aux.getEquipo();
					model.addRow(fila);
				}
				break;
			case 1:
				for (Queso aux : Quesera.getInstance().getAllQuesos()) {
					if(aux instanceof QuesoEf){
					fila[0] = aux.getId();
					fila[1] = aux.getTipo();
					fila[2] = df.format(aux.Volumen());
					fila[3] = df.format(aux.Precio());
					model.addRow(fila);
					}
				}
				break;	
			}
		}
		tablaPlayers.setModel(model);
		tablaPlayers.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tablaPlayers.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = tablaPlayers.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(60);
		columnModel.getColumn(1).setPreferredWidth(180);
		columnModel.getColumn(2).setPreferredWidth(150);
		columnModel.getColumn(3).setPreferredWidth(140);		/*if(tableModel.getRowCount()==0){
			btnEliminar.setEnabled(false);
			btnModificar.setEnabled(false);
		}*/
		
	}
	
	//FUNCION DE CARGAR EQUIPOS EN COMBOBOX 
	
	public static void cbxEquipos () {
		
			for (Equipo aux : Season.getInstance().getMisEquipos()) {
				cbxEquipo.addItem(aux.getNombreEquipo());
			}
	}
}
