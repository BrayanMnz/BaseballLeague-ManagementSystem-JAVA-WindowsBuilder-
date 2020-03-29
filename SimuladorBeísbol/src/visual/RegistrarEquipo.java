package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import logico.Equipo;
import logico.Liga;


import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import java.awt.Image;

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
	private ListarEquipos listarEquipo;
	private JFormattedTextField formattedFechaFundacion;
	private static Boolean selectionFoto = false;

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
		setBounds(100, 100, 788, 348);
		
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
			
			JLabel lblEntrenadorPrincipal = new JLabel("Entrenador Principal:");
			lblEntrenadorPrincipal.setBounds(203, 195, 148, 20);
			panel.add(lblEntrenadorPrincipal);
			
			txtEntrenador = new JTextField();
			txtEntrenador.setBounds(162, 214, 205, 20);
			panel.add(txtEntrenador);
			txtEntrenador.setColumns(10);
			 
			MaskFormatter fechaFormato = null;
			try {
				fechaFormato = new MaskFormatter("##/##/####");
			} catch (ParseException e) {
			
				e.printStackTrace();
			}
			
		     formattedFechaFundacion = new JFormattedTextField(fechaFormato);
			formattedFechaFundacion.setBounds(284, 143, 205, 20);
			panel.add(formattedFechaFundacion);
		}
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(519, 10, 243, 255);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblLogoEquipo = new JLabel("");
		lblLogoEquipo.setBounds(10, 26, 223, 173);
		panel.add(lblLogoEquipo);
		
		JButton btnSeleccionarFoto = new JButton("Seleccionar");
		btnSeleccionarFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.showOpenDialog(null);
				
				BufferedImage foto;
				File fileFoto = fileChooser.getSelectedFile();
		
				String routeOfFoto=null;
				
				try {
					 routeOfFoto = fileFoto.getAbsolutePath();
					
				}catch (NullPointerException  e1) {
					e1.printStackTrace();
				}
				try {
					foto = ImageIO.read(fileFoto);
					String routetosave = "LogosEquipos/"+ txtNombreEquipo.getText() + ".png";
					ImageIO.write(foto, "png", new File(routetosave));
					/** to adjust image at size of JLabel **/
					ImageIcon fotoJugador = new ImageIcon(routeOfFoto);
					Icon fotoJ = new ImageIcon(fotoJugador.getImage().getScaledInstance(lblLogoEquipo.getWidth(), lblLogoEquipo.getHeight(), Image.SCALE_SMOOTH));
					lblLogoEquipo.setIcon(fotoJ);
					selectionFoto = true;
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}catch (IllegalArgumentException e2) {
					JOptionPane.showMessageDialog(null, "Solo se permiten fotos." , "Error:", JOptionPane.ERROR_MESSAGE);
				}	
			}
		});
		btnSeleccionarFoto.setBounds(10, 211, 223, 33);
		panel.add(btnSeleccionarFoto);
		
		JLabel lblLogo = new JLabel("            Logo");
		lblLogo.setFont(new Font("Courier New", Font.BOLD, 14));
		lblLogo.setBounds(10, 1, 223, 22);
		panel.add(lblLogo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar!");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(txtNombreEquipo.getText().isEmpty() || txtidEquipo.getText().isEmpty() || txtEntrenador.getText().isEmpty()
								|| txtEstadio.getText().isEmpty() || formattedFechaFundacion.getText().isEmpty() ) { 
							JOptionPane.showMessageDialog(null, "Debe llenar todos los campos", "Error", JOptionPane.WARNING_MESSAGE);
							} 
						else if(miEquipo == null) { 
							miEquipo = new Equipo(txtNombreEquipo.getText(),txtidEquipo.getText(),txtEstadio.getText(),txtEntrenador.getText(), formattedFechaFundacion.getText());
						     Liga.getInstance().insertarEquipo(miEquipo);
						   JOptionPane.showMessageDialog(null, "Operacion Satisfactoria", "Informacion", JOptionPane.INFORMATION_MESSAGE);
						   clean();

						} else { 
							miEquipo = new Equipo(txtNombreEquipo.getText(),txtidEquipo.getText(),txtEstadio.getText(),txtEntrenador.getText(), formattedFechaFundacion.getText());
						     Liga.getInstance().insertarEquipo(miEquipo);
							JOptionPane.showMessageDialog(null, "Operacion Satisfactoria", "Informacion", JOptionPane.INFORMATION_MESSAGE);
							clean();  }
						}
					
					private void clean() {
					txtEntrenador.setText("");
					txtNombreEquipo.setText("");
					txtidEquipo.setText("");
					txtEstadio.setText("");
					formattedFechaFundacion.setText("");
						
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


