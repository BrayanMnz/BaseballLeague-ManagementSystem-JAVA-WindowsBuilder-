package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GradientPaint;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Equipo;
import logico.Jugador;
import logico.Liga;
import logico.Season;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.DefaultComboBoxModel;

public class VerEquipo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTextField txtDatosNombre;
	private static JTextField txtDatosidEquipo;
	private static JTextField txtDatosEstadio;
	private static JTextField txtDatosFechaFundacion;
	private static JTextField txtDatosTrainer;
	private Equipo team;
	private static String identificador;
	private JTable tableEstadisticasEquipo;
	private static DefaultTableModel model; 
	private static DefaultTableModel model1;
	private static Object[] fila1;
	private static Object[] fila; 
	private JTable tablaNomina;
	private static JComboBox<String> comboBox;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		try {
			VerEquipo dialog = new VerEquipo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} */

	/**
	 * Create the dialog.
	 */
	public VerEquipo(String identificador) {
		this.identificador = identificador;
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				//cargarDatosEquipo();
			}
			@Override
			public void windowOpened(WindowEvent e) {
				informacionEquipo();
				cargarEquiposEnCBX();
			
				cargarEstadisticasEquipos();
				cargarNomina();
			}
		});
		setTitle("Informacion del equipo");
		setBounds(100, 100, 756, 460);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		panel.setBorder(new TitledBorder(null, "Buscar Equipo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 722, 56);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JButton btnBuscarEquipo = new JButton("Buscar");
		btnBuscarEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		 
	
			    	cargarEstadisticasEquipos1();
			    	cargarNomina1();
			    		informacionEquipo1();
		
			}


		});
		btnBuscarEquipo.setBounds(372, 22, 101, 23);
		panel.add(btnBuscarEquipo);
		
		 comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>"}));
		comboBox.setBounds(99, 22, 246, 22);
		panel.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Ir a :");
		lblNewLabel_1.setBounds(22, 26, 46, 14);
		panel.add(lblNewLabel_1);
		
		JPanel panelDatosEquipo = new JPanel();
		panelDatosEquipo.setBackground(new Color(204, 204, 204));
		panelDatosEquipo.setBorder(new TitledBorder(null, "Datos del Equipo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDatosEquipo.setBounds(10, 78, 197, 295);
		contentPanel.add(panelDatosEquipo);
		panelDatosEquipo.setLayout(null);
		panelDatosEquipo.setOpaque(true);
		
		JLabel lblNewLabel = new JLabel("Nombre Equipo:");
		lblNewLabel.setBounds(10, 30, 111, 14);
		panelDatosEquipo.add(lblNewLabel); 
	
		
		txtDatosNombre = new JTextField();
		txtDatosNombre.setEditable(false);
		txtDatosNombre.setBounds(10, 49, 169, 20);
		panelDatosEquipo.add(txtDatosNombre);
		txtDatosNombre.setColumns(10);
		
		JLabel lblDatosID = new JLabel("ID Equipo: ");
		lblDatosID.setBounds(10, 80, 65, 14);
		panelDatosEquipo.add(lblDatosID);
		
		txtDatosidEquipo = new JTextField();
		txtDatosidEquipo.setEditable(false);
		txtDatosidEquipo.setBounds(10, 96, 169, 20);
		panelDatosEquipo.add(txtDatosidEquipo);
		txtDatosidEquipo.setColumns(10);
		
		JLabel lblDatosEstadio = new JLabel("Estadio:");
		lblDatosEstadio.setBounds(10, 127, 126, 14);
		panelDatosEquipo.add(lblDatosEstadio);
		
		txtDatosEstadio = new JTextField();
		txtDatosEstadio.setEditable(false);
		txtDatosEstadio.setBounds(10, 152, 169, 20);
		panelDatosEquipo.add(txtDatosEstadio);
		txtDatosEstadio.setColumns(10);
		
		JLabel lblDatosFecha = new JLabel("Fecha de Fundacion: ");
		lblDatosFecha.setBounds(10, 242, 150, 14);
		panelDatosEquipo.add(lblDatosFecha);
		
		txtDatosFechaFundacion = new JTextField();
		txtDatosFechaFundacion.setEditable(false);
		txtDatosFechaFundacion.setBounds(10, 264, 169, 20);
		panelDatosEquipo.add(txtDatosFechaFundacion);
		txtDatosFechaFundacion.setColumns(10);
		
		JLabel lblDatosTrainer = new JLabel("Entrenador Principal:");
		lblDatosTrainer.setBounds(10, 183, 169, 14);
		panelDatosEquipo.add(lblDatosTrainer);
		
		txtDatosTrainer = new JTextField();
		txtDatosTrainer.setEditable(false);
		txtDatosTrainer.setBounds(10, 208, 169, 20);
		panelDatosEquipo.add(txtDatosTrainer);
		txtDatosTrainer.setColumns(10);
		
		JPanel pnlStatsEquipo = new JPanel();
		pnlStatsEquipo.setBackground(new Color(192, 192, 192));
		pnlStatsEquipo.setBorder(new TitledBorder(null, "Estadisticas del equipo", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		pnlStatsEquipo.setBounds(217, 78, 515, 93);
		contentPanel.add(pnlStatsEquipo);
		pnlStatsEquipo.setOpaque(true);
		pnlStatsEquipo.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		pnlStatsEquipo.add(scrollPane, BorderLayout.CENTER);
		
		tableEstadisticasEquipo = new JTable();
		model = new DefaultTableModel();
		String[] columnNames = {"Ganados","Perdidos",".Prom",".PCL","Hits","HR","Carreras"};
		model.setColumnIdentifiers(columnNames);
        tableEstadisticasEquipo.setModel(model);
		scrollPane.setViewportView(tableEstadisticasEquipo);
		
		JPanel pnlListaJugadores = new JPanel();
		pnlListaJugadores.setBackground(new Color(204, 204, 204));
		pnlListaJugadores.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Nomina del equipo: ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlListaJugadores.setBounds(217, 229, 515, 144);
		contentPanel.add(pnlListaJugadores);
		pnlListaJugadores.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPaneNomina = new JScrollPane();
		pnlListaJugadores.add(scrollPaneNomina, BorderLayout.CENTER);
		
		tablaNomina = new JTable();
	
		model1 = new DefaultTableModel();
		String[] columnNamesNomina = {"Nombre","No. Dorsal", "Posicion"};
		model1.setColumnIdentifiers(columnNamesNomina);
		tablaNomina.setModel(model1);
		scrollPaneNomina.setViewportView(tablaNomina);
		
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(VerEquipo.class.getResource("/Imagenes/616629-sand-baseball-ball-ground-748x499.jpg")));
		lblFondo.setBounds(0, 0, 740, 388);
		contentPanel.add(lblFondo);
		pnlListaJugadores.setVisible(true);
		pnlStatsEquipo.setVisible(true);
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

	private static void informacionEquipo() { 
		Equipo auxEquipo = Liga.getInstance().buscarEquipoByName(identificador);
		txtDatosNombre.setText(auxEquipo.getNombreEquipo());
		txtDatosidEquipo.setText(auxEquipo.getId());
		txtDatosFechaFundacion.setText(auxEquipo.getFechaFundacion());
		txtDatosTrainer.setText(auxEquipo.getTrainer());
		txtDatosEstadio.setText(auxEquipo.getEstadio());
	}
	private static void cargarEstadisticasEquipos() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()]; 
		Equipo auxEquipo = Liga.getInstance().buscarEquipoByName(identificador);
			//fila[0] = auxEquipo.getCantJuegos();
			fila[0] = auxEquipo.getGanados();
			fila[1] = auxEquipo.getPerdidos();
		    fila[2] = auxEquipo.promColectivo();
			fila[3] = auxEquipo.eraColectiva();
			fila[4] = auxEquipo.totalHits(); 
			fila[5] = auxEquipo.totalHR();
			fila[6] = auxEquipo.totalCarreras();
			model.addRow(fila);
			
		}
	private static void cargarNomina() { 
		model1.setRowCount(0);
		fila1 = new Object[model1.getColumnCount()];
		Equipo auxEquipo = Liga.getInstance().buscarEquipoByName(identificador);
		 for (Jugador auxJugador : Liga.getInstance().getMisJugadores()) {
			 if(auxJugador.getEquipo().equalsIgnoreCase(auxEquipo.getNombreEquipo()))
			 {   
			
				 fila1[0] = auxJugador.getNombre();
				 fila1[1] = auxJugador.getNoDorsal(); 
				 fila1[2] = auxJugador.getPosicion();
				 model1.addRow(fila1);
			 } 
			 
			
		}
	}
	
	private void cargarEquiposEnCBX () {
		
		for (Equipo aux : Liga.getInstance().getMisEquipos()) {
			comboBox.addItem(aux.getNombreEquipo());
			
			
		} }
	private static void informacionEquipo1() { 
		Equipo auxEquipo = Liga.getInstance().buscarEquipoByName(comboBox.getSelectedItem().toString());
		txtDatosNombre.setText(auxEquipo.getNombreEquipo());
		txtDatosidEquipo.setText(auxEquipo.getId());
		txtDatosFechaFundacion.setText(auxEquipo.getFechaFundacion());
		txtDatosTrainer.setText(auxEquipo.getTrainer());
		txtDatosEstadio.setText(auxEquipo.getEstadio());
	}
	private static void cargarEstadisticasEquipos1() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()]; 
		Equipo auxEquipo = Liga.getInstance().buscarEquipoByName(comboBox.getSelectedItem().toString());
			//fila[0] = auxEquipo.getCantJuegos();
			fila[0] = auxEquipo.getGanados();
			fila[1] = auxEquipo.getPerdidos();
		    fila[2] = auxEquipo.promColectivo();
			fila[3] = auxEquipo.eraColectiva();
			fila[4] = auxEquipo.totalHits(); 
			fila[5] = auxEquipo.totalHR();
			fila[6] = auxEquipo.totalCarreras();
			model.addRow(fila);
			
		}
	private static void cargarNomina1() { 
		model1.setRowCount(0);
		fila1 = new Object[model1.getColumnCount()];
		Equipo auxEquipo = Liga.getInstance().buscarEquipoByName(comboBox.getSelectedItem().toString());
		 for (Jugador auxJugador : Liga.getInstance().getMisJugadores()) {
			 if(auxJugador.getEquipo().equalsIgnoreCase(auxEquipo.getNombreEquipo()))
			 {   
			
				 fila1[0] = auxJugador.getNombre();
				 fila1[1] = auxJugador.getNoDorsal(); 
				 fila1[2] = auxJugador.getPosicion();
				 model1.addRow(fila1);
			 } 
			 
			
		}
	}
	
}
