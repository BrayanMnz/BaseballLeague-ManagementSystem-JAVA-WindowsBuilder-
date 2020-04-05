package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Equipo;
import logico.Jugador;
import logico.Liga;
import logico.Pitcher;
import logico.jugadorPosicion;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManejarJugador extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8095065653925936203L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtDorsal;
	private JTextField txtAltura;
	private JTextField txtPeso;
	private JTable tablaJugadores;
	private static DefaultTableModel model; 
	private static Object[] fila; 
	private static String auxTeam;
	private static String auxDorsal;
	private int index;
	private JComboBox<String> cbxEquipos;
	private JComboBox<String> cbxEquipos2;
    private JComboBox<String> comboBox;
    private JComboBox<String> cbxLanza;
    private JComboBox<String> cbxBatea;
    private static Jugador miJugador;
    private JButton btnModify;
    private JButton btnEliminar;
    private JButton btnVerJugador;
    private JLabel lblPos;
    private JComboBox<String> cbxTipoJugador;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ManejarJugador dialog = new ManejarJugador();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ManejarJugador() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				cargarJugadores();
				cargarEquiposEnCBX();
           			
			}
		});
		setBounds(100, 100, 681, 529);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel pnlInfoJugador = new JPanel();
		pnlInfoJugador.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Informacion del Jugador", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlInfoJugador.setBounds(10, 11, 645, 180);
		pnlInfoJugador.setOpaque(false);
		
		contentPanel.add(pnlInfoJugador);
		pnlInfoJugador.setLayout(null);
		{
			JLabel lblNombre = new JLabel("Nombre: ");
			lblNombre.setBounds(10, 26, 138, 14);
			pnlInfoJugador.add(lblNombre);
		}
		

				
		
		txtNombre = new JTextField();
		txtNombre.setBounds(10, 45, 138, 20);
		pnlInfoJugador.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblDorsal = new JLabel("No. Dorsal");
		lblDorsal.setBounds(10, 77, 138, 14);
		pnlInfoJugador.add(lblDorsal);
		
		txtDorsal = new JTextField();
		txtDorsal.setBounds(10, 96, 138, 20);
		pnlInfoJugador.add(txtDorsal);
		txtDorsal.setColumns(10);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(212, 26, 138, 14);
		pnlInfoJugador.add(lblAltura);
		
		txtAltura = new JTextField();
		txtAltura.setBounds(212, 45, 138, 20);
		pnlInfoJugador.add(txtAltura);
		txtAltura.setColumns(10);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(212, 77, 138, 14);
		pnlInfoJugador.add(lblPeso);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(212, 96, 138, 20);
		pnlInfoJugador.add(txtPeso);
		txtPeso.setColumns(10);
		
		JLabel lblPosicion = new JLabel("Tipo de Jugador:");
		lblPosicion.setBounds(10, 127, 138, 14);
		pnlInfoJugador.add(lblPosicion);
		
		JLabel lblEquipoJugador = new JLabel("Equipo:");
		lblEquipoJugador.setBounds(212, 127, 138, 14);
		pnlInfoJugador.add(lblEquipoJugador);
		
		cbxEquipos = new JComboBox<String>();
		cbxEquipos.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>"}));
		cbxEquipos.setBounds(212, 145, 138, 22);
		pnlInfoJugador.add(cbxEquipos);
		
		JLabel lblBatea = new JLabel("Batea: ");
		lblBatea.setBounds(376, 26, 91, 14);
		pnlInfoJugador.add(lblBatea);
		
	 cbxBatea = new JComboBox<String>();
		cbxBatea.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>", "Derecho", "Izquierdo", "Switch Hitter"}));
		cbxBatea.setBounds(378, 44, 138, 20);
		pnlInfoJugador.add(cbxBatea);
		
		JLabel lblManoLanza = new JLabel("Lanza: ");
		lblManoLanza.setBounds(376, 77, 46, 14);
		pnlInfoJugador.add(lblManoLanza);
		
	 cbxLanza = new JComboBox<String>();
		cbxLanza.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>", "Derecho", "Izquierdo"}));
		cbxLanza.setBounds(376, 95, 138, 22);
		pnlInfoJugador.add(cbxLanza);
		
	 lblPos = new JLabel("Posicion defensiva:");
		lblPos.setBounds(376, 127, 138, 14);
		pnlInfoJugador.add(lblPos);
		
		 comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>", "C", "1B", "2B", "3B", "SS", "LF", "CF", "RF"}));
		comboBox.setBounds(376, 148, 140, 22);
		pnlInfoJugador.add(comboBox);
		
		JButton btnInsertarJugador = new JButton("Insertar");
		btnInsertarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtNombre.getText().isEmpty() || txtDorsal.getText().isEmpty() || txtAltura.getText().isEmpty() ||
				txtPeso.getText().isEmpty() || cbxEquipos.getSelectedItem().toString().equalsIgnoreCase("<Seleccione>") || 
				cbxBatea.getSelectedItem().toString().equalsIgnoreCase("<Seleccione>") || cbxLanza.getSelectedItem().toString().equalsIgnoreCase("<Seleccione")) {
					JOptionPane.showMessageDialog(null, "Debe completar todos los campos", "Error", JOptionPane.WARNING_MESSAGE);
				}	
				else if (miJugador == null ) { 
					if(cbxTipoJugador.getSelectedItem().toString().equalsIgnoreCase("Jugador Posicion")) { 
						miJugador = new jugadorPosicion(txtNombre.getText(), txtDorsal.getText(), cbxEquipos.getSelectedItem().toString(), txtAltura.getText(), txtPeso.getText(), 
								comboBox.getSelectedItem().toString(),cbxBatea.getSelectedItem().toString(),cbxLanza.getSelectedItem().toString());
						  Liga.getInstance().insertarJugador(miJugador);	
					}
					else if (miJugador == null && cbxTipoJugador.getSelectedItem().toString().equalsIgnoreCase("Pitcher")) {
						miJugador = new Pitcher(txtNombre.getText(), txtDorsal.getText(), cbxEquipos.getSelectedItem().toString(), txtAltura.getText(), txtPeso.getText()
								,"Pitcher", cbxBatea.getSelectedItem().toString(), cbxLanza.getSelectedItem().toString());
						  Liga.getInstance().insertarJugador(miJugador);
					} }
					else if(cbxTipoJugador.getSelectedItem().toString().equalsIgnoreCase("Pitcher")) { 
						miJugador = new Pitcher(txtNombre.getText(), txtDorsal.getText(), cbxEquipos.getSelectedItem().toString(), txtAltura.getText(), txtPeso.getText(), 
								comboBox.getSelectedItem().toString(),cbxBatea.getSelectedItem().toString(),cbxLanza.getSelectedItem().toString());
						  Liga.getInstance().insertarJugador(miJugador);	
						} 	else if(cbxTipoJugador.getSelectedItem().toString().equalsIgnoreCase("Jugador Posicion")) { 
							miJugador = new jugadorPosicion(txtNombre.getText(), txtDorsal.getText(), cbxEquipos.getSelectedItem().toString(), txtAltura.getText(), txtPeso.getText(), 
									comboBox.getSelectedItem().toString(),cbxBatea.getSelectedItem().toString(),cbxLanza.getSelectedItem().toString());
							  Liga.getInstance().insertarJugador(miJugador);	
							} 
				
			        
			          for (Equipo auxEquipo : Liga.getInstance().getMisEquipos()) {
			        	  if(auxEquipo.getNombreEquipo().equalsIgnoreCase(cbxEquipos.getSelectedItem().toString())) {  
			        		  auxEquipo.insertarJugador(miJugador);
			        		   JOptionPane.showMessageDialog(null, "Jugador Registrado ", "Informacion", JOptionPane.INFORMATION_MESSAGE);
							  cargarJugadores();
			        		   clean();
			        	  }}} 
			                    });
		
		
		btnInsertarJugador.setBounds(542, 26, 82, 141);
		pnlInfoJugador.add(btnInsertarJugador);
		
		 cbxTipoJugador = new JComboBox<String>();
		cbxTipoJugador.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>","Pitcher", "Jugador Posicion"}));
		cbxTipoJugador.setBounds(10, 145, 138, 22);
		pnlInfoJugador.add(cbxTipoJugador);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Listado de Jugadores", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 201, 645, 245);
		contentPanel.add(panel);
		panel.setOpaque(false);
		panel.setLayout(null);
		
		JScrollPane scrollPaneListar = new JScrollPane();
		scrollPaneListar.setBounds(10, 39, 625, 195);
		panel.add(scrollPaneListar);
		scrollPaneListar.setOpaque(false);
		
		tablaJugadores = new JTable();
		tablaJugadores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				index = tablaJugadores.getSelectedRow();
				if(index >= 0) { 
				//	identificador = (String)tablaJugadores.getModel().getValueAt(index, 0).toString();
				    auxTeam = (String)tablaJugadores.getModel().getValueAt(index, 3).toString();
				    auxDorsal = (String)tablaJugadores.getModel().getValueAt(index, 1).toString();
				   			    
					btnModify.setEnabled(true);
					btnEliminar.setEnabled(true);
					btnVerJugador.setEnabled(true);
					
				}
				
			}
		});
		scrollPaneListar.setViewportView(tablaJugadores);
		model = new DefaultTableModel();
		String[] columnNames = {"Nombre", "No. Dorsal", "Posicion", "Equipo"};
		model.setColumnIdentifiers(columnNames);
		tablaJugadores.setModel(model);
		
		
		JLabel lblFiltrar = new JLabel("Mostrar por:");
		lblFiltrar.setBounds(10, 14, 74, 14);
		panel.add(lblFiltrar);
		
	    cbxEquipos2 = new JComboBox<String>();
		cbxEquipos2.setModel(new DefaultComboBoxModel<String>(new String[] {"<Todos>"}));
		cbxEquipos2.setBounds(94, 10, 138, 22);
		panel.add(cbxEquipos2);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(ManejarJugador.class.getResource("/Imagenes/26639841-fondo-de-color-naranja-claro.jpg")));
		lblFondo.setBounds(0, 0, 665, 457);
		contentPanel.add(lblFondo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			 
		 btnVerJugador = new JButton("Ver Jugador");
			 buttonPane.add(btnVerJugador);
			
			 btnEliminar = new JButton("Eliminar");
			 btnEliminar.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		int option = JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar al Jugador ? " ,"Información",JOptionPane.WARNING_MESSAGE);
			 		if(option == JOptionPane.OK_OPTION) { 	
			 	Equipo aux =  Liga.getInstance().buscarEquipoByName(auxTeam);
			 	Jugador auxJ = aux.buscarJugadorByDorsal(auxDorsal); 
			 	aux.EliminarJugador(auxJ);
			 	Liga.getInstance().EliminarJugador(auxJ);
			 	cargarJugadores();
			 		}
			 	}
			 });
			buttonPane.add(btnEliminar);
			{
				 btnModify = new JButton("Modificar");
				btnModify.setActionCommand("OK");
				buttonPane.add(btnModify);
				getRootPane().setDefaultButton(btnModify);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private void cargarEquiposEnCBX () {
		
		for (Equipo aux : Liga.getInstance().getMisEquipos()) {
			cbxEquipos.addItem(aux.getNombreEquipo());
			cbxEquipos2.addItem(aux.getNombreEquipo());
			
		}
}
	
	private void cargarJugadores() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (logico.Jugador auxJugador : Liga.getInstance().getMisJugadores()) {
			fila[0] = auxJugador.getNombre();
			fila[1] = auxJugador.getNoDorsal();
			fila[2] = auxJugador.getPosicion();
			fila[3] = auxJugador.getEquipo();
			model.addRow(fila);
		}
	}
	
	private void clean() { 
		txtAltura.setText("");
		txtNombre.setText("");
		txtDorsal.setText("");
		txtPeso.setText("");
		cbxEquipos.setSelectedIndex(0);
		comboBox.setSelectedIndex(0);
		cbxBatea.setSelectedIndex(0);
		cbxLanza.setSelectedIndex(0);
		cbxTipoJugador.setSelectedIndex(0);
		
		
	}
}
