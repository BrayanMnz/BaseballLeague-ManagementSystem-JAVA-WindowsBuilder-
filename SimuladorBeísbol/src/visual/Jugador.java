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
import javax.swing.JOptionPane;
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
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Jugador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtJuegos;
	private JTextField txtErrores;
	private JTextField txtAltura;
	private JTextField txtPeso;
	private JTextField txtDorsal;
	private JTextField txtEquipo;
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
	private static DefaultTableModel model;
	private static Object[] fila;
	static JComboBox<String> cbxEquipo;
	private static JTable tablaPlayers;
	private JPanel panelCaracteristicas;
	private JLabel lblPesoNew;
	private JLabel lblAlturaNew;
	private JLabel lblPosicionNew;
	private JTextField txtPesoNew;
	private JTextField txtAlturaNew;
	private JTextField txtPosicionNew;
	private JButton btnVerLesiones;
	private String playerDorsal;
	private int indexName;
	private String PlayerName;
	private Jugador jugadorAuxiliar;
	private logico.Jugador jugadorMostrar = null;
	private JLabel lblNewLabel;
	private JLabel lblEjemplo;
	private JLabel lblEjemplo_1;
	private JLabel lblEjemplo_2;
	private JLabel lblEjemplo_3;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_3;




	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			Jugador dialog = new Jugador();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/
	/**
	 * Create the dialog.
	 */
	public Jugador() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				cbxEquipos();
			}
		});
		setTitle("Jugadores");
		setBounds(100, 100, 894, 624);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLUE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
	
		//PROBANDO QUE COMBOBOX CARGARA LOS NOMBRES DE LOS EQUIPOS
		
		/*	Equipo miAux;
		miAux = new Equipo("MiEquipo","30","Estadio","Yehudy",30,25,5);
		Season.getInstance().insertarEquipo(miAux);		
		*/ 
		contentPanel.setLayout(null);
		
		JPanel pnlAddPlayer = new JPanel();
		pnlAddPlayer.setBackground(Color.LIGHT_GRAY);
		pnlAddPlayer.setBounds(10, 11, 858, 172);
		pnlAddPlayer.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPanel.add(pnlAddPlayer);
		pnlAddPlayer.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 11, 42, 14);
		pnlAddPlayer.add(lblNombre);
		
		JLabel lblDorsal = new JLabel("#Dorsal");
		lblDorsal.setBounds(10, 136, 46, 14);
		pnlAddPlayer.add(lblDorsal);
		
		JLabel lblCantJuegos = new JLabel("#Juegos");
		lblCantJuegos.setBounds(10, 36, 52, 14);
		pnlAddPlayer.add(lblCantJuegos);
		
		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setBounds(210, 11, 46, 14);
		pnlAddPlayer.add(lblEquipo);
		
		JLabel lblErrores = new JLabel("Errores");
		lblErrores.setBounds(10, 61, 52, 14);
		pnlAddPlayer.add(lblErrores);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(10, 86, 46, 14);
		pnlAddPlayer.add(lblAltura);
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setBounds(10, 111, 46, 14);
		pnlAddPlayer.add(lblPeso);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(72, 8, 128, 20);
		pnlAddPlayer.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtJuegos = new JTextField();
		txtJuegos.setBounds(72, 33, 42, 20);
		pnlAddPlayer.add(txtJuegos);
		txtJuegos.setColumns(10);
		
		txtErrores = new JTextField();
		txtErrores.setBounds(72, 58, 42, 20);
		pnlAddPlayer.add(txtErrores);
		txtErrores.setColumns(10);
		
		txtAltura = new JTextField();
		txtAltura.setBounds(72, 83, 42, 20);
		pnlAddPlayer.add(txtAltura);
		txtAltura.setColumns(10);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(72, 108, 42, 20);
		pnlAddPlayer.add(txtPeso);
		txtPeso.setColumns(10);
		
		txtDorsal = new JTextField();
		txtDorsal.setBounds(72, 133, 42, 20);
		pnlAddPlayer.add(txtDorsal);
		txtDorsal.setColumns(10);
		
		txtEquipo = new JTextField();
		txtEquipo.setBounds(253, 8, 130, 20);
		pnlAddPlayer.add(txtEquipo);
		txtEquipo.setColumns(10);

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
		panelPosicion.setBackground(Color.LIGHT_GRAY);
		panelPosicion.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelPosicion.setBounds(504, 11, 344, 150);
		pnlAddPlayer.add(panelPosicion);
		panelPosicion.setLayout(null);
		
		JLabel lblHits = new JLabel("Hits");
		lblHits.setBounds(10, 11, 47, 14);
		panelPosicion.add(lblHits);
		
		JLabel lblAnotadas = new JLabel("Carreras Anotadas");
		lblAnotadas.setBounds(10, 36, 120, 14);
		panelPosicion.add(lblAnotadas);
		
		JLabel lblEmpujadas = new JLabel("Carreras Empujadas");
		lblEmpujadas.setBounds(10, 61, 120, 14);
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
		txtEmpujadas.setEditable(false);
		txtEmpujadas.setBounds(130, 58, 39, 20);
		panelPosicion.add(txtEmpujadas);
		txtEmpujadas.setColumns(10);
		
		txtAnotadas = new JTextField();
		txtAnotadas.setEditable(false);
		txtAnotadas.setBounds(130, 33, 39, 20);
		panelPosicion.add(txtAnotadas);
		txtAnotadas.setColumns(10);
		
		txtHits = new JTextField();
		txtHits.setEditable(false);
		txtHits.setBounds(130, 8, 39, 20);
		panelPosicion.add(txtHits);
		txtHits.setColumns(10);
		
		txtRobadas = new JTextField();
		txtRobadas.setEditable(false);
		txtRobadas.setBounds(130, 83, 39, 20);
		panelPosicion.add(txtRobadas);
		txtRobadas.setColumns(10);
		
		txtHR = new JTextField();
		txtHR.setEditable(false);
		txtHR.setBounds(272, 33, 39, 20);
		panelPosicion.add(txtHR);
		txtHR.setColumns(10);
		
		txtTurnos = new JTextField();
		txtTurnos.setEditable(false);
		txtTurnos.setBounds(272, 8, 39, 20);
		panelPosicion.add(txtTurnos);
		txtTurnos.setColumns(10);
		
		txtPosicion = new JTextField();
		txtPosicion.setEditable(false);
		txtPosicion.setBounds(272, 58, 39, 20);
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
		lblBB.setHorizontalAlignment(SwingConstants.LEFT);
		lblBB.setBounds(195, 11, 61, 14);
		panelPitcher.add(lblBB);
		
		JLabel lblSalvados = new JLabel("Salvados");
		lblSalvados.setBounds(195, 36, 61, 14);
		panelPitcher.add(lblSalvados);
		
		txtGanados = new JTextField();
		txtGanados.setBounds(130, 8, 39, 20);
		panelPitcher.add(txtGanados);
		txtGanados.setColumns(10);
		
		txtPerdidos = new JTextField();
		txtPerdidos.setBounds(130, 33, 39, 20);
		panelPitcher.add(txtPerdidos);
		txtPerdidos.setColumns(10);
		
		txtCarrLimpias = new JTextField();
		txtCarrLimpias.setBounds(130, 58, 39, 20);
		panelPitcher.add(txtCarrLimpias);
		txtCarrLimpias.setColumns(10);
		
		txtInnings = new JTextField();
		txtInnings.setBounds(130, 83, 39, 20);
		panelPitcher.add(txtInnings);
		txtInnings.setColumns(10);
		
		txtPonches = new JTextField();
		txtPonches.setBounds(130, 108, 39, 20);
		panelPitcher.add(txtPonches);
		txtPonches.setColumns(10);
		
		txtSalvados = new JTextField();
		txtSalvados.setBounds(272, 33, 39, 20);
		panelPitcher.add(txtSalvados);
		txtSalvados.setColumns(10);
		
		txtBB = new JTextField();
		txtBB.setBounds(272, 8, 39, 20);
		panelPitcher.add(txtBB);
		txtBB.setColumns(10);
		
		JLabel lblLesion = new JLabel("Lesionado?");
		lblLesion.setBounds(253, 61, 70, 14);
		pnlAddPlayer.add(lblLesion);
		
		rdbtnLesionado = new JRadioButton("Si");
		rdbtnLesionado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		rdbtnLesionado.setBounds(253, 82, 46, 23);
		pnlAddPlayer.add(rdbtnLesionado);
		
		rdbtnNoLesion = new JRadioButton("No");
		rdbtnNoLesion.setBounds(301, 82, 42, 23);
		pnlAddPlayer.add(rdbtnNoLesion);
		
		//LLAMANDO FUNCION PARA CARGAR EQUIPOS EN CBX

		
		JButton btnRegistrar = new JButton("Insertar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean auxBool=false;
				logico.Jugador aux=null;
				if (rdbtnLesionado.isSelected()) {
					auxBool = true;
				}
				if (rbtnPitcher.isSelected() && (rdbtnNoLesion.isSelected() || rdbtnLesionado.isSelected())) {
					aux = new Pitcher (txtNombre.getText(),txtDorsal.getText(), Float.parseFloat(txtJuegos.getText().toString()),
							Float.parseFloat(txtErrores.getText().toString()),txtEquipo.getText().toString(),auxBool,
							Float.parseFloat(txtAltura.getText().toString()), Float.parseFloat(txtPeso.getText().toString()));
					if 	(auxBool==true) {
						Lesiones crearLesion = new Lesiones (aux, Season.getInstance().buscarEquipoByName(aux.getEquipo()));
						crearLesion.setModal(true);
						crearLesion.setVisible(true);
					}
					else {
						Season.getInstance().buscarEquipoByName(aux.getEquipo()).insertarJugador(aux);
						JOptionPane.showMessageDialog(null, "Operacion Satisfactoria", "Informacion", JOptionPane.INFORMATION_MESSAGE);

					}
				}
				if (rdbtnPosicion.isSelected() && (rdbtnNoLesion.isSelected() || rdbtnLesionado.isSelected())) {
					aux = new jugadorPosicion(txtNombre.getText(),txtDorsal.getText(), Float.parseFloat(txtJuegos.getText().toString()),
							Float.parseFloat(txtErrores.getText().toString()),txtEquipo.getText().toString(),auxBool,
							Float.parseFloat(txtAltura.getText().toString()),Float.parseFloat(txtPeso.getText().toString()),txtPosicion.getText());
					if 	(auxBool==true) {
						Lesiones crearLesionPosicion = new Lesiones (aux, Season.getInstance().buscarEquipoByName(aux.getEquipo()));
						crearLesionPosicion.setModal(true);
						crearLesionPosicion.setVisible(true);
					}
					else {
						Season.getInstance().buscarEquipoByName(aux.getEquipo()).insertarJugador(aux);
						JOptionPane.showMessageDialog(null, "Operacion Satisfactoria", "Informacion", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				loadJugadores();
				limpiarTextos();
			}
		});
		btnRegistrar.setBounds(389, 57, 89, 23);
		pnlAddPlayer.add(btnRegistrar);
		
		lblNewLabel = new JLabel("Ejemplo: 5");
		lblNewLabel.setBounds(124, 36, 64, 14);
		pnlAddPlayer.add(lblNewLabel);
		
		lblEjemplo = new JLabel("Ejemplo: 7");
		lblEjemplo.setBounds(124, 61, 64, 14);
		pnlAddPlayer.add(lblEjemplo);
		
		lblEjemplo_1 = new JLabel("Ejemplo: 1.70");
		lblEjemplo_1.setBounds(124, 86, 76, 14);
		pnlAddPlayer.add(lblEjemplo_1);
		
		lblEjemplo_2 = new JLabel("Ejemplo: 60");
		lblEjemplo_2.setBounds(124, 111, 64, 14);
		pnlAddPlayer.add(lblEjemplo_2);
		
		lblEjemplo_3 = new JLabel("Ejemplo: 23");
		lblEjemplo_3.setBounds(124, 136, 64, 14);
		pnlAddPlayer.add(lblEjemplo_3);
		
		lblNewLabel_1 = new JLabel("Ejemplo: Red Sox");
		lblNewLabel_1.setBounds(253, 36, 90, 14);
		pnlAddPlayer.add(lblNewLabel_1);
		
		lblNewLabel_3 = new JLabel("NOMBRE, EJEMPLO: JUAN DE PENA");
		lblNewLabel_3.setBounds(253, 136, 214, 14);
		pnlAddPlayer.add(lblNewLabel_3);
		
		JPanel panelTabla = new JPanel();
		panelTabla.setBackground(Color.LIGHT_GRAY);
		panelTabla.setBounds(10, 194, 566, 380);
		panelTabla.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPanel.add(panelTabla);
		panelTabla.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(2, 49, 562, 329);
		panelTabla.add(scrollPane);
		{
			{
				
				
				tablaPlayers = new JTable();
				tablaPlayers.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (tablaPlayers.getSelectedRow()>-1) {
							int indexPlayer = tablaPlayers.getSelectedRow();
							playerDorsal = tablaPlayers.getValueAt(indexPlayer, 0).toString();
							PlayerName = tablaPlayers.getValueAt(indexPlayer, 1).toString();
							for (Equipo auxEquipoTable : Season.getInstance().getMisEquipos()) {
								for(logico.Jugador auxJugadorTable : auxEquipoTable.getMisJugadores()) {
									if (auxJugadorTable.getNombre() == PlayerName) {
										jugadorMostrar = auxJugadorTable;
									}
								}
							}
							
							txtPesoNew.setText(String.valueOf(jugadorMostrar.getPeso()));
							txtAlturaNew.setText(String.valueOf(jugadorMostrar.getAltura()));
							if (jugadorMostrar instanceof jugadorPosicion) {
								txtPosicionNew.setText(((jugadorPosicion) jugadorMostrar).getPosicion());
							}
							else {
								txtPosicionNew.setText("Pitcher");
							}
						}
					}
				});
				//tablaPlayers.setBounds(0, 302, 546, 0);
				//listaPlayers.add(tablaPlayers);
				scrollPane.setColumnHeaderView(tablaPlayers);
				String[] columnas = {"#Dorsal","Nombre","Juegos", "Errores"};
				model = new DefaultTableModel();
				model.setColumnIdentifiers(columnas);
				tablaPlayers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				tablaPlayers.setModel(model);
				scrollPane.setViewportView(tablaPlayers);
				
				cbxEquipo = new JComboBox();
				cbxEquipo.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
					}
				});
				cbxEquipo.setBounds(10, 18, 86, 20);
				panelTabla.add(cbxEquipo);
				cbxEquipo.setModel(new DefaultComboBoxModel(new String[] {"<Equipos>"}));
				
				panelCaracteristicas = new JPanel();
				panelCaracteristicas.setBackground(Color.LIGHT_GRAY);
				panelCaracteristicas.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				panelCaracteristicas.setBounds(586, 194, 282, 380);
				contentPanel.add(panelCaracteristicas);
				panelCaracteristicas.setLayout(null);
				
				lblPesoNew = new JLabel("Peso");
				lblPesoNew.setBounds(10, 256, 46, 14);
				panelCaracteristicas.add(lblPesoNew);
				
				lblAlturaNew = new JLabel("Altura");
				lblAlturaNew.setBounds(10, 281, 46, 14);
				panelCaracteristicas.add(lblAlturaNew);
				
				lblPosicionNew = new JLabel("Posicion");
				lblPosicionNew.setBounds(10, 306, 46, 14);
				panelCaracteristicas.add(lblPosicionNew);
				
				txtPesoNew = new JTextField();
				txtPesoNew.setEditable(false);
				txtPesoNew.setBounds(78, 253, 86, 20);
				panelCaracteristicas.add(txtPesoNew);
				txtPesoNew.setColumns(10);
				
				txtAlturaNew = new JTextField();
				txtAlturaNew.setEditable(false);
				txtAlturaNew.setBounds(78, 278, 86, 20);
				panelCaracteristicas.add(txtAlturaNew);
				txtAlturaNew.setColumns(10);
				
				txtPosicionNew = new JTextField();
				txtPosicionNew.setEditable(false);
				txtPosicionNew.setBounds(78, 303, 86, 20);
				panelCaracteristicas.add(txtPosicionNew);
				txtPosicionNew.setColumns(10);
				
				btnVerLesiones = new JButton("Ver Lesiones");
				btnVerLesiones.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						tablaLesiones misLesiones = new tablaLesiones(jugadorMostrar);
						misLesiones.setModal(true);
						misLesiones.setVisible(true);
					}
				});
				btnVerLesiones.setBounds(60, 334, 117, 23);
				panelCaracteristicas.add(btnVerLesiones);
				loadJugadores();
				
				
				/*String[] columnas = {"#Dorsal","Nombre","Juegos", "Errores"};
				model = new DefaultTableModel();
				model.setColumnIdentifiers(columnas);
				loadJugadores();
				*/
			}
		}
	
	} 
	public static void loadJugadores() {
		model.setRowCount(0);
		//DecimalFormat df = new DecimalFormat("#.##");
		fila = new Object[model.getColumnCount()];
		for (Equipo aux : Season.getInstance().getMisEquipos()) {
			for(logico.Jugador auxPlayer : aux.getMisJugadores()) {
					fila[0] = auxPlayer.getNoDorsal();
					fila[1] = auxPlayer.getNombre();
					fila[2] = auxPlayer.getCantJuegos();
					fila[3] = auxPlayer.getErrores();
					model.addRow(fila);
		}
	}
		TableColumnModel columnModel = tablaPlayers.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(160);
		columnModel.getColumn(1).setPreferredWidth(180);
		columnModel.getColumn(2).setPreferredWidth(150);
		columnModel.getColumn(3).setPreferredWidth(140);	
		/*if(tableModel.getRowCount()==0){
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
	public void limpiarTextos() {
		txtNombre.setText("");
		txtNombre.setText("");
		txtJuegos.setText("");
		txtErrores.setText("");
		txtAltura.setText("");
		txtPeso.setText("");
		txtDorsal.setText("");
		txtEquipo.setText("");
		txtGanados.setText("");
		txtPerdidos.setText("");
		txtCarrLimpias.setText("");
		txtInnings.setText("");
		txtPonches.setText("");
		txtSalvados.setText("");
		txtBB.setText("");
		txtEmpujadas.setText("");
		txtAnotadas.setText("");
		txtHits.setText("");
		txtRobadas.setText("");
		txtHR.setText("");
		txtTurnos.setText("");
		txtPosicion.setText("");
	}
}
