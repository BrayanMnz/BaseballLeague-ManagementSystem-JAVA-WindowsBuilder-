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
import logico.Liga;
import logico.Pitcher;

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
	JRadioButton rdbtnPosicion;
	JRadioButton rbtnPitcher;
	JRadioButton rdbtnNoLesion;
	JRadioButton rdbtnLesionado;
	private static DefaultTableModel model;
	private static Object[] fila;
	static JComboBox<String> cbxEquipo;
	private static JTable tablaPlayers;
	private String playerDorsal;
	private int indexName;
	private String PlayerName;
	private Jugador jugadorAuxiliar;
	private logico.Jugador jugadorMostrar = null;
	private String cbxItem;
	private logico.Jugador miJugador;
	private JComboBox cbxSelectEquipo;




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
			loadJugadores();
			cbxEquipos();
			cbxSelectEquipo ();
			}
		});
		setTitle("Jugadores");
		setBounds(100, 100, 605, 624);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
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
		pnlAddPlayer.setBounds(10, 11, 566, 172);
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
		
		rdbtnLesionado = new JRadioButton("Si");
		rdbtnLesionado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		rdbtnLesionado.setBounds(253, 107, 46, 23);
		pnlAddPlayer.add(rdbtnLesionado);
		
		rdbtnNoLesion = new JRadioButton("No");
		rdbtnNoLesion.setBounds(301, 107, 42, 23);
		pnlAddPlayer.add(rdbtnNoLesion);
		
		//LLAMANDO FUNCION PARA CARGAR EQUIPOS EN CBX

		
		JButton btnRegistrar = new JButton("Insertar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean auxBool=false;
				miJugador = null;
				if (rdbtnLesionado.isSelected()) {
					auxBool = true;
				}
				if (rbtnPitcher.isSelected()) {
					miJugador = new Pitcher (txtNombre.getText(),txtDorsal.getText(), Float.parseFloat(txtJuegos.getText().toString()),
							Float.parseFloat(txtErrores.getText().toString()),cbxSelectEquipo.getSelectedItem().toString(),auxBool,
							Float.parseFloat(txtAltura.getText().toString()), Float.parseFloat(txtPeso.getText().toString()));
					if 	(auxBool==true) {
						Lesiones crearLesion = new Lesiones (miJugador);
						crearLesion.setModal(true);
						crearLesion.setVisible(true);
					}
					else {
						//Liga.getInstance().buscarEquipoByName(cbxSelectEquipo.getSelectedItem().toString()).insertarJugador(miJugador);
						Liga.getInstance().insertarJugador(miJugador);
						JOptionPane.showMessageDialog(null, "Operacion Satisfactoria", "Informacion", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				if (rdbtnPosicion.isSelected()) {
					miJugador = new jugadorPosicion(txtNombre.getText(),txtDorsal.getText(), Float.parseFloat(txtJuegos.getText().toString()),
							Float.parseFloat(txtErrores.getText().toString()),cbxSelectEquipo.getSelectedItem().toString(),auxBool,
							Float.parseFloat(txtAltura.getText().toString()),Float.parseFloat(txtPeso.getText().toString()),txtPosicion.getText());
					if 	(auxBool==true) {
						Lesiones crearLesionPosicion = new Lesiones (miJugador);
						crearLesionPosicion.setModal(true);
						crearLesionPosicion.setVisible(true);
					}
					else {
						//Liga.getInstance().buscarEquipoByName(cbxSelectEquipo.getSelectedItem().toString()).insertarJugador(miJugador);						
						Liga.getInstance().insertarJugador(miJugador);
						JOptionPane.showMessageDialog(null, "Operacion Satisfactoria", "Informacion", JOptionPane.INFORMATION_MESSAGE);
						
					}
				}
				for (Equipo auxTeam : Liga.getInstance().getMisEquipos()) {
					if (auxTeam.getNombreEquipo() == cbxSelectEquipo.getSelectedItem()) {
						auxTeam.insertarJugador(miJugador);
					}
				}
				loadJugadores();
				limpiarTextos();
			}
		});
		btnRegistrar.setBounds(389, 57, 89, 23);
		pnlAddPlayer.add(btnRegistrar);
		
		cbxSelectEquipo = new JComboBox();
		cbxSelectEquipo.setModel(new DefaultComboBoxModel(new String[] {"<Equipo>"}));
		cbxSelectEquipo.setBounds(253, 8, 90, 20);
		pnlAddPlayer.add(cbxSelectEquipo);
		
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
							for (logico.Jugador auxPlayer : Liga.getInstance().getMisJugadores()) {
									if (auxPlayer.getNombre() == PlayerName) {
										jugadorMostrar = auxPlayer;
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
						cbxEquipos();
					}
				});
				cbxEquipo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cbxItem = (String) cbxEquipo.getSelectedItem();
						loadJugadoresEquipo(Liga.getInstance().buscarEquipoByName(cbxItem));
					}
				});

				cbxEquipo.setBounds(10, 18, 86, 20);
				panelTabla.add(cbxEquipo);
				cbxEquipo.setModel(new DefaultComboBoxModel(new String[] {"<Equipos>"}));
				
				
				/*String[] columnas = {"#Dorsal","Nombre","Juegos", "Errores"};
				model = new DefaultTableModel();
				model.setColumnIdentifiers(columnas);
				loadJugadores();
				*/
			}
		}
		
		JButton btnVerPlayer = new JButton("Ver Jugador");
		btnVerPlayer.setBounds(106, 17, 133, 23);
		panelTabla.add(btnVerPlayer);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(249, 17, 89, 23);
		panelTabla.add(btnEliminar);
	
	} 
	private static void loadJugadores() {
		model.setRowCount(0);
		//DecimalFormat df = new DecimalFormat("#.##");
		fila = new Object[model.getColumnCount()];
		//for (Equipo aux : Liga.getInstance().getMisEquipos()) {
			for(logico.Jugador auxPlayer : Liga.getInstance().getMisJugadores()) {
					fila[0] = auxPlayer.getNoDorsal();
					fila[1] = auxPlayer.getNombre();
					fila[2] = auxPlayer.getCantJuegos();
					fila[3] = auxPlayer.getErrores();
					model.addRow(fila);
		}
	//}
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
	
	private static void loadJugadoresEquipo(Equipo equipo) {
		model.setRowCount(0);
		//DecimalFormat df = new DecimalFormat("#.##");
		fila = new Object[model.getColumnCount()];
		for (Equipo aux : Liga.getInstance().getMisEquipos()) {
			for(logico.Jugador auxPlayer : equipo.getMisJugadores()) {
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
	
	private void cbxEquipos () {
		
			for (Equipo aux : Liga.getInstance().getMisEquipos()) {
				cbxEquipo.addItem(aux.getNombreEquipo().toString());
			}
	}
	private void cbxSelectEquipo () {
		
		for (Equipo aux : Liga.getInstance().getMisEquipos()) {
			cbxSelectEquipo.addItem(aux.getNombreEquipo().toString());
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
