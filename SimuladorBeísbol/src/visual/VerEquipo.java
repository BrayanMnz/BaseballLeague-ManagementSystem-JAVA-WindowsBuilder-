package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

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

public class VerEquipo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtBuscarEquipo;
	private JTextField txtDatosNombre;
	private JTextField txtDatosidEquipo;
	private JTextField txtDatosEstadio;
	private JTextField txtDatosFechaFundacion;
	private JTextField txtDatosTrainer;
	private Equipo team;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VerEquipo dialog = new VerEquipo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VerEquipo() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				//cargarDatosEquipo();
			}
		});
		setTitle("Informacion del equipo");
		setBounds(100, 100, 914, 446);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Buscar Equipo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 878, 56);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblBuscarEquipo = new JLabel("id Equipo: ");
		lblBuscarEquipo.setBounds(10, 26, 80, 14);
		panel.add(lblBuscarEquipo);
		
		txtBuscarEquipo = new JTextField();
		txtBuscarEquipo.setBounds(100, 23, 262, 20);
		panel.add(txtBuscarEquipo);
		txtBuscarEquipo.setColumns(10);
		
		JButton btnBuscarEquipo = new JButton("Buscar");
		btnBuscarEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			    if(team == null) { 
			    	int option = JOptionPane.showConfirmDialog(null, "Equipo no encontrado, Desea crearlo?", "Error", JOptionPane.YES_NO_OPTION, 
							JOptionPane.QUESTION_MESSAGE);
			    	if(option == JOptionPane.YES_OPTION) { 
			    		RegistrarEquipo team1 = new RegistrarEquipo();
			    		team1.setModal(true);
			    		team1.setVisible(true);
			    		txtBuscarEquipo.setText("");
			    	}
			    }
			    else if (team.equals(Liga.getInstance().buscarEquipoById(txtBuscarEquipo.getText()))) { 
			    	cargarDatosEquipo(Liga.getInstance().buscarEquipoById(txtBuscarEquipo.getText()));
			    	
			    }
			}

		public void cargarDatosEquipo(Equipo team1) {
			int i = 0; 
			while(i<Season.getInstance().getMisEquipos().size()) { 
				if(Season.getInstance().getMisEquipos().get(i).getId().equalsIgnoreCase(txtBuscarEquipo.getText())) { 
					team1 = Season.getInstance().getMisEquipos().get(i);
					break;
					} i++;
			} txtDatosNombre.setText(Season.getInstance().getMisEquipos().get(i).getNombreEquipo());
			 txtDatosidEquipo.setText(Season.getInstance().getMisEquipos().get(i).getId());
			 txtDatosEstadio.setText(Season.getInstance().getMisEquipos().get(i).getEstadio());
			 txtDatosFechaFundacion.setText(Season.getInstance().getMisEquipos().get(i).getFechaFundacion().toString());
			 txtDatosTrainer.setText(Season.getInstance().getMisEquipos().get(i).getTrainer());
				
			}
		});
		btnBuscarEquipo.setBounds(372, 22, 101, 23);
		panel.add(btnBuscarEquipo);
		
		JPanel panelDatosEquipo = new JPanel();
		panelDatosEquipo.setBorder(new TitledBorder(null, "Datos del Equipo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDatosEquipo.setBounds(10, 78, 410, 217);
		contentPanel.add(panelDatosEquipo);
		panelDatosEquipo.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre Equipo:");
		lblNewLabel.setBounds(10, 30, 87, 14);
		panelDatosEquipo.add(lblNewLabel);
		
		txtDatosNombre = new JTextField();
		txtDatosNombre.setEditable(false);
		txtDatosNombre.setBounds(10, 49, 169, 20);
		panelDatosEquipo.add(txtDatosNombre);
		txtDatosNombre.setColumns(10);
		
		JLabel lblDatosID = new JLabel("id Equipo: ");
		lblDatosID.setBounds(226, 30, 65, 14);
		panelDatosEquipo.add(lblDatosID);
		
		txtDatosidEquipo = new JTextField();
		txtDatosidEquipo.setEditable(false);
		txtDatosidEquipo.setBounds(226, 49, 169, 20);
		panelDatosEquipo.add(txtDatosidEquipo);
		txtDatosidEquipo.setColumns(10);
		
		JLabel lblDatosEstadio = new JLabel("Estadio:");
		lblDatosEstadio.setBounds(10, 94, 126, 14);
		panelDatosEquipo.add(lblDatosEstadio);
		
		txtDatosEstadio = new JTextField();
		txtDatosEstadio.setEditable(false);
		txtDatosEstadio.setBounds(10, 114, 169, 20);
		panelDatosEquipo.add(txtDatosEstadio);
		txtDatosEstadio.setColumns(10);
		
		JLabel lblDatosFecha = new JLabel("Fecha de Fundacion: ");
		lblDatosFecha.setBounds(226, 94, 150, 14);
		panelDatosEquipo.add(lblDatosFecha);
		
		txtDatosFechaFundacion = new JTextField();
		txtDatosFechaFundacion.setEditable(false);
		txtDatosFechaFundacion.setBounds(226, 114, 169, 20);
		panelDatosEquipo.add(txtDatosFechaFundacion);
		txtDatosFechaFundacion.setColumns(10);
		
		JLabel lblDatosTrainer = new JLabel("Entrenador Principal:");
		lblDatosTrainer.setBounds(10, 157, 169, 14);
		panelDatosEquipo.add(lblDatosTrainer);
		
		txtDatosTrainer = new JTextField();
		txtDatosTrainer.setEditable(false);
		txtDatosTrainer.setBounds(10, 177, 169, 20);
		panelDatosEquipo.add(txtDatosTrainer);
		txtDatosTrainer.setColumns(10);
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


}
