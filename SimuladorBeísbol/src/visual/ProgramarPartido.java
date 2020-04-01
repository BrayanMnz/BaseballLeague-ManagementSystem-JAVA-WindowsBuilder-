package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;

import logico.Equipo;
import logico.Liga;
import logico.Partido;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class ProgramarPartido extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox<String> comboBoxLocal;
	private JComboBox<String> comboBoxVisitante;
	private Partido miPartido;
	private JSpinner spnHora;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ProgramarPartido dialog = new ProgramarPartido();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ProgramarPartido() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				 cargarEquiposEnCBX();
			}
		});
		
		setModal(true);
		setTitle("Programar partidos ");
		setBounds(100, 100, 393, 267);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panelProgramar = new JPanel();
			panelProgramar.setOpaque(false);
			panelProgramar.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Informacion del partido", TitledBorder.RIGHT, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelProgramar.setBounds(10, 11, 356, 176);
			contentPanel.add(panelProgramar);
			panelProgramar.setLayout(null);
			{
				JLabel lblVisitante = new JLabel("Equipo Visitante: ");
				lblVisitante.setForeground(new Color(0, 0, 0));
				lblVisitante.setBackground(Color.WHITE);
				lblVisitante.setBounds(228, 52, 128, 14);
				panelProgramar.add(lblVisitante);
				lblVisitante.setFont(lblVisitante.getFont().deriveFont(lblVisitante.getFont().getStyle() | Font.BOLD | Font.ITALIC));
			}
			{
			    comboBoxVisitante = new JComboBox();
			    comboBoxVisitante.setBounds(218, 77, 128, 22);
			    panelProgramar.add(comboBoxVisitante);
				comboBoxVisitante.setModel(new DefaultComboBoxModel(new String[] {"<Visitante>"}));
			}
			{
				JLabel lblEquipoLocal = new JLabel("Equipo Local: ");
				lblEquipoLocal.setBackground(new Color(0, 0, 0));
				lblEquipoLocal.setForeground(new Color(0, 0, 0));
				lblEquipoLocal.setBounds(46, 52, 128, 14);
				panelProgramar.add(lblEquipoLocal);
				lblEquipoLocal.setFont(lblEquipoLocal.getFont().deriveFont(lblEquipoLocal.getFont().getStyle() | Font.BOLD | Font.ITALIC));
			}
			
			 comboBoxLocal = new JComboBox();	
			 comboBoxLocal.setBounds(33, 77, 128, 22);
			 panelProgramar.add(comboBoxLocal);
			 
			 comboBoxLocal.setModel(new DefaultComboBoxModel(new String[] {"<Local>"}));
			 
			 JLabel lblFecha = new JLabel("Fecha y Hora:  ");
			 lblFecha.setForeground(SystemColor.desktop);
			 lblFecha.setBounds(218, 118, 128, 14);
			 panelProgramar.add(lblFecha);
			 lblFecha.setFont(lblFecha.getFont().deriveFont(lblFecha.getFont().getStyle() | Font.BOLD | Font.ITALIC));
			 
			 spnHora = new JSpinner(new SpinnerDateModel());
			 spnHora.setBounds(218, 143, 128, 22);
			 panelProgramar.add(spnHora);
			 spnHora.setModel(new SpinnerDateModel(new Date(1585497600000L), null, null, Calendar.DAY_OF_YEAR));
		}
		{
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(ProgramarPartido.class.getResource("/Imagenes/unnamed.jpg")));
			lblNewLabel_1.setBounds(0, 0, 377, 195);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnProgramar = new JButton("Programar Partido");
				btnProgramar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
				
						if(comboBoxLocal.getSelectedItem().toString().equalsIgnoreCase("<Local>")) { 
							JOptionPane.showMessageDialog(null, "Debe seleccionar un equipo como Local", "Error", JOptionPane.WARNING_MESSAGE);
							} else if (comboBoxVisitante.getSelectedItem().toString().equalsIgnoreCase("<Visitante>")) { 
								JOptionPane.showMessageDialog(null, "Debe seleccionar un equipo como Visitante", "Error", JOptionPane.WARNING_MESSAGE);
								
							}
						
					else if(miPartido == null) { 
						miPartido = new Partido(buscarEquipo(comboBoxLocal.getSelectedItem().toString()), buscarEquipo(comboBoxVisitante.getSelectedItem().toString()), 
								estadioEquipoLocal(), spnHora.getValue().toString());
				        Liga.getInstance().insertarPartido(miPartido);
						    mainVisual.cargarPartidosHoy();
				        JOptionPane.showMessageDialog(null, "Operacion Satisfactoria", "Informacion", JOptionPane.INFORMATION_MESSAGE);
						   dispose();
					  }
					}

				});
				btnProgramar.setActionCommand("OK");
				buttonPane.add(btnProgramar);
				getRootPane().setDefaultButton(btnProgramar);
			}
			{
				JButton btnCancel = new JButton("Cancel");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
	}
	private void cargarEquiposEnCBX () {
		
		for (Equipo aux : Liga.getInstance().getMisEquipos()) {
			comboBoxLocal.addItem(aux.getNombreEquipo());
			comboBoxVisitante.addItem(aux.getNombreEquipo());
			
		}
}
	public String estadioEquipoLocal () { 
		String estadio = "";
		 for (Equipo auxEquipo : Liga.getInstance().getMisEquipos()) {
				if(auxEquipo.getNombreEquipo().equalsIgnoreCase(comboBoxLocal.getSelectedItem().toString())) { 
					estadio = auxEquipo.getEstadio();
				}
			}
		return estadio;
	}
	

public Equipo buscarEquipo (String nombreEquipo) { 
	Equipo aux = null;
	 for (Equipo auxEquipo : Liga.getInstance().getMisEquipos()) {
			if(auxEquipo.getNombreEquipo().equalsIgnoreCase(nombreEquipo)) { 
				aux = auxEquipo;
			}
		}
	return aux;
}
}
