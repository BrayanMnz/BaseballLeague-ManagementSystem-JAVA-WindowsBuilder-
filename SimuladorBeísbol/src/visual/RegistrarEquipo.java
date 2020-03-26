package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import logico.Equipo;
import logico.Season;

import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarEquipo extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombreEquipo;
	private JTextField txtidEquipo;
	private JTextField txtEstadio;
	private JTextField txtEntrenador;
	private Equipo miEquipo;
	private JSpinner spnFechaFundacion;
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			RegistrarEquipo dialog = new RegistrarEquipo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public RegistrarEquipo() {
		
		setTitle("Registro de Equipos ");
		setBounds(100, 100, 535, 348);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLUE);
		contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.GRAY);
			panel.setBorder(new TitledBorder(null, "Informacion del equipo: ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 10, 499, 255);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNombreEquipo = new JLabel("Nombre del Equipo:");
				lblNombreEquipo.setBounds(10, 37, 128, 14);
				panel.add(lblNombreEquipo);
			}
			
			txtNombreEquipo = new JTextField();
			txtNombreEquipo.setBounds(10, 55, 205, 20);
			panel.add(txtNombreEquipo);
			txtNombreEquipo.setColumns(10);
			
			JLabel lblidEquipo = new JLabel("ID del Equipo:");
			lblidEquipo.setBounds(284, 37, 128, 14);
			panel.add(lblidEquipo);
			
			txtidEquipo = new JTextField();
			txtidEquipo.setBounds(284, 55, 205, 20);
			panel.add(txtidEquipo);
			txtidEquipo.setColumns(10);
			
			JLabel lblEstadioEquipo = new JLabel("Estadio:");
			lblEstadioEquipo.setBounds(10, 118, 155, 14);
			panel.add(lblEstadioEquipo);
			
			txtEstadio = new JTextField();
			txtEstadio.setBounds(10, 143, 205, 20);
			panel.add(txtEstadio);
			txtEstadio.setColumns(10);
			
			JLabel lblFechaFundacion = new JLabel("Fecha Fundacion: ");
			lblFechaFundacion.setBounds(284, 118, 102, 14);
			panel.add(lblFechaFundacion);
			
			spnFechaFundacion = new JSpinner();
			spnFechaFundacion.setModel(new SpinnerDateModel(new Date(1585108800000L), null, null, Calendar.YEAR));
			spnFechaFundacion.setBounds(284, 143, 205, 20);
			panel.add(spnFechaFundacion);
			
			JLabel lblEntrenadorPrincipal = new JLabel("Entrenador Principal:");
			lblEntrenadorPrincipal.setBounds(203, 195, 148, 20);
			panel.add(lblEntrenadorPrincipal);
			
			txtEntrenador = new JTextField();
			txtEntrenador.setBounds(162, 214, 205, 20);
			panel.add(txtEntrenador);
			txtEntrenador.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar!");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(txtNombreEquipo.getText().isEmpty() || txtidEquipo.getText().isEmpty() || txtEntrenador.getText().isEmpty()
								|| txtEstadio.getText().isEmpty() ) { 
							JOptionPane.showMessageDialog(null, "Debe llenar todos los campos", "Error", JOptionPane.WARNING_MESSAGE);
							} 
						else if(miEquipo == null) { 
							miEquipo = new Equipo(txtNombreEquipo.getText(),txtidEquipo.getText(),txtEstadio.getText(),txtEntrenador.getText(), (Date) spnFechaFundacion.getValue());
						   Season.getInstance().insertarEquipo(miEquipo);
						   JOptionPane.showMessageDialog(null, "Operacion Satisfactoria", "Informacion", JOptionPane.INFORMATION_MESSAGE);
						   clean();
						   dispose();
						} else { 
							miEquipo.setNombreEquipo(txtNombreEquipo.getText());
							miEquipo.setEstadio(txtEstadio.getText());
							miEquipo.setId(txtidEquipo.getText());
							miEquipo.setTrainer(txtEntrenador.getText());
							miEquipo.setFechaFundacion((Date) spnFechaFundacion.getValue());
							JOptionPane.showMessageDialog(null, "Operacion Satisfactoria", "Informacion", JOptionPane.INFORMATION_MESSAGE);
							clean();
							dispose();
								
						}

						
					}
					Date today = new Date();
					private void clean() {
					txtEntrenador.setText("");
					txtNombreEquipo.setText("");
					txtidEquipo.setText("");
					txtEstadio.setText("");
					spnFechaFundacion.setValue(today);
						
					}
				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton btnCancel = new JButton("Cancelar");
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
	}
}
