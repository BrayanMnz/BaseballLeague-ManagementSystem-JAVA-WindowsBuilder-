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
import javax.swing.text.MaskFormatter;

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
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JFormattedTextField;

public class ProgramarPartido extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox<String> comboBoxLocal;
	private JComboBox<String> comboBoxVisitante;
	private Partido miPartido;
	private JSpinner spnHora;
	private static String horaJuego;
	private JTextField txtIDPartido;
	private JSpinner spnFechaPartido;
	private JFormattedTextField formattedFechaPartido;
	private JButton btnProgramar; 

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
		setBounds(100, 100, 484, 321);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panelProgramar = new JPanel();
			panelProgramar.setOpaque(false);
			panelProgramar.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Informacion del partido", TitledBorder.RIGHT, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelProgramar.setBounds(20, 22, 437, 216);
			contentPanel.add(panelProgramar);
			panelProgramar.setLayout(null);
			{
				JLabel lblVisitante = new JLabel("Equipo Visitante: ");
				lblVisitante.setForeground(new Color(0, 0, 0));
				lblVisitante.setBackground(Color.WHITE);
				lblVisitante.setBounds(26, 141, 128, 14);
				panelProgramar.add(lblVisitante);
				lblVisitante.setFont(lblVisitante.getFont().deriveFont(lblVisitante.getFont().getStyle() | Font.BOLD | Font.ITALIC));
			}
			{
			    comboBoxVisitante = new JComboBox();
			    comboBoxVisitante.setBounds(26, 166, 132, 22);
			    panelProgramar.add(comboBoxVisitante);
				comboBoxVisitante.setModel(new DefaultComboBoxModel(new String[] {"<Visitante>"}));
			}
			{
				JLabel lblEquipoLocal = new JLabel("Equipo Local: ");
				lblEquipoLocal.setBackground(new Color(0, 0, 0));
				lblEquipoLocal.setForeground(new Color(0, 0, 0));
				lblEquipoLocal.setBounds(28, 71, 128, 14);
				panelProgramar.add(lblEquipoLocal);
				lblEquipoLocal.setFont(lblEquipoLocal.getFont().deriveFont(lblEquipoLocal.getFont().getStyle() | Font.BOLD | Font.ITALIC));
			}
			
			 comboBoxLocal = new JComboBox();	
			 comboBoxLocal.setBounds(26, 92, 132, 22);
			 panelProgramar.add(comboBoxLocal);
			 
			 comboBoxLocal.setModel(new DefaultComboBoxModel(new String[] {"<Local>"}));
			 
			 JLabel lblFecha = new JLabel("Hora del partido:  ");
			 lblFecha.setForeground(SystemColor.desktop);
			 lblFecha.setBounds(292, 100, 128, 14);
			 panelProgramar.add(lblFecha);
			 lblFecha.setFont(lblFecha.getFont().deriveFont(lblFecha.getFont().getStyle() | Font.BOLD | Font.ITALIC));
			 
			 SpinnerDateModel dateModel = new SpinnerDateModel();
			 spnHora = new JSpinner(dateModel);
			 JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(spnHora, "HH:mm:ss");
			 spnHora.setEditor(timeEditor);
         
				Time time = new Time(dateModel.getDate().getTime());
				horaJuego = time.toString();
				
			 
			 spnHora.setBounds(290, 116, 130, 22);
			 panelProgramar.add(spnHora);
			 
			 JLabel lblIDPartido = new JLabel("ID Partido:");
			 lblIDPartido.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			 lblIDPartido.setBounds(290, 33, 66, 14);
			 panelProgramar.add(lblIDPartido);
			 
			 txtIDPartido = new JTextField("MLB-00"+Liga.getInstance().getCantPartidos());
			 txtIDPartido.setEnabled(false);
			 txtIDPartido.setBounds(290, 53, 130, 20);
			 panelProgramar.add(txtIDPartido);
			 txtIDPartido.setColumns(10);
			 
			 JLabel lblFechaPartido = new JLabel("Fecha del partido:");
			 lblFechaPartido.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			 lblFechaPartido.setBounds(292, 168, 128, 14);
			 panelProgramar.add(lblFechaPartido);
			 
			  Calendar fecha = Calendar.getInstance();
		        int ano = fecha.get(Calendar.YEAR);
		        int mes = fecha.get(Calendar.MONTH) + 1;
		        int dia = fecha.get(Calendar.DAY_OF_MONTH);
		        
				MaskFormatter fechaFormato = null;
				try {
					fechaFormato = new MaskFormatter("##/##/####");
					
					
					fechaFormato.setPlaceholderCharacter((char) (dia+mes+ano));
				} catch (ParseException e) {
				
					e.printStackTrace();
				}
				
			 {
				 
			  formattedFechaPartido = new JFormattedTextField(fechaFormato);
		   
			 	formattedFechaPartido.setBounds(292, 185, 130, 20);
			 	panelProgramar.add(formattedFechaPartido);
		
			 	 
			 }
			   
	
             
			 
		}
		{
			JLabel lblFondo = new JLabel("");
			lblFondo.setIcon(new ImageIcon(ProgramarPartido.class.getResource("/Imagenes/unnamed.jpg")));
			lblFondo.setBounds(0, 0, 468, 249);
			contentPanel.add(lblFondo);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				 btnProgramar = new JButton("Programar Partido");
				btnProgramar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
				
						if(comboBoxLocal.getSelectedItem().toString().equalsIgnoreCase("<Local>")) { 
							JOptionPane.showMessageDialog(null, "Debe seleccionar un equipo como Local", "Error", JOptionPane.WARNING_MESSAGE);
							} else if (comboBoxVisitante.getSelectedItem().toString().equalsIgnoreCase("<Visitante>")) { 
								JOptionPane.showMessageDialog(null, "Debe seleccionar un equipo como Visitante", "Error", JOptionPane.WARNING_MESSAGE);
								
							}
						
					else if(miPartido == null) { 
						miPartido = new Partido(buscarEquipo(comboBoxLocal.getSelectedItem().toString()), buscarEquipo(comboBoxVisitante.getSelectedItem().toString()), 
								estadioEquipoLocal(), horaJuego,formattedFechaPartido.getText());
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
