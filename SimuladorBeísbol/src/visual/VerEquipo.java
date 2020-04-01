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

public class VerEquipo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTextField txtBuscarEquipo;
	private static JTextField txtDatosNombre;
	private static JTextField txtDatosidEquipo;
	private static JTextField txtDatosEstadio;
	private static JTextField txtDatosFechaFundacion;
	private static JTextField txtDatosTrainer;
	private Equipo team;
	private static String identificador;
	private JTable tableEstadisticasEquipo;
	private static DefaultTableModel model; 
	private static Object[] fila; 

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
			
				cargarEstadisticasEquipos();
			}
		});
		setTitle("Informacion del equipo");
		setBounds(100, 100, 799, 460);
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
		
		JLabel lblBuscarEquipo = new JLabel("ID Equipo: ");
		lblBuscarEquipo.setBackground(new Color(230, 230, 250));
		lblBuscarEquipo.setBounds(10, 26, 80, 14);
		panel.add(lblBuscarEquipo);
		
		txtBuscarEquipo = new JTextField();
		txtBuscarEquipo.setBounds(100, 23, 262, 20);
		panel.add(txtBuscarEquipo);
		txtBuscarEquipo.setColumns(10);
		
		JButton btnBuscarEquipo = new JButton("Buscar");
		btnBuscarEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Equipo auxEquipo = Liga.getInstance().buscarEquipoById(txtBuscarEquipo.getText());
			    if(auxEquipo == null) { 
			    	int option = JOptionPane.showConfirmDialog(null, "Equipo no encontrado, Desea crearlo?", "Error", JOptionPane.YES_NO_OPTION, 
							JOptionPane.QUESTION_MESSAGE);
			    	if(option == JOptionPane.YES_OPTION) { 
			    		RegistrarEquipo team1 = new RegistrarEquipo();
			    		team1.setModal(true);
			    		team1.setVisible(true);
			    		txtBuscarEquipo.setText("");
			    		informacionEquipo();
			    	}
			    }
			    else if (auxEquipo.equals(Liga.getInstance().buscarEquipoById(txtBuscarEquipo.getText()))) { 
			    informacionEquipo();
			    	
			    }
			}


		});
		btnBuscarEquipo.setBounds(372, 22, 101, 23);
		panel.add(btnBuscarEquipo);
		
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBorder(new TitledBorder(null, "Estadisticas del equipo", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_1.setBounds(217, 78, 515, 93);
		contentPanel.add(panel_1);
		panel_1.setOpaque(true);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		tableEstadisticasEquipo = new JTable();
		model = new DefaultTableModel();
		String[] columnNames = {"Juegos","Ganados","Perdidos","Prom","ERA","Hits","Carreras"};
		model.setColumnIdentifiers(columnNames);
        tableEstadisticasEquipo.setModel(model);
		scrollPane.setViewportView(tableEstadisticasEquipo);
		
		JLabel lblFondoPrincipal = new JLabel("");
		lblFondoPrincipal.setIcon(new ImageIcon(VerEquipo.class.getResource("/Imagenes/616629-sand-baseball-ball-ground-748x499.jpg")));
		lblFondoPrincipal.setBounds(0, 0, 783, 384);
		contentPanel.add(lblFondoPrincipal);
		panel_1.setVisible(true);
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
			fila[1] = auxEquipo.getGanados();
			fila[2] = auxEquipo.getPerdidos();
		//	fila[3] = auxEquipo.promColectivo();
		//	fila[4] = auxEquipo.eraColectiva();
		//	fila[5] = auxEquipo.totalHits(); 
		//	fila[6] = auxEquipo.totalCarreras();
			model.addRow(fila);
			
		}
	

	
	
}
