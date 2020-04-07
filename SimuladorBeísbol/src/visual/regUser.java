package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.User;
import logico.Liga;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class regUser extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	User auxiliar=null;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			regUser dialog = new regUser();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public regUser() {
		setResizable(false);
		setBounds(100, 100, 367, 189);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setUndecorated(true);

		contentPanel.setLayout(null);

		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(20, 29, 347,160);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("TI-Nspire Sans", Font.BOLD, 11));
		lblPassword.setBounds(192, 11, 78, 14);
		panel.add(lblPassword);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("TI-Nspire Sans", Font.BOLD, 11));
		textField_1.setBounds(192, 33, 147, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField.setBounds(10, 33, 127, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNombreUsuario = new JLabel("Nombre Usuario:");
		lblNombreUsuario.setFont(new Font("TI-Nspire Sans", Font.BOLD, 11));
		lblNombreUsuario.setBounds(10, 11, 97, 14);
		panel.add(lblNombreUsuario);

		{
			JButton cancelButton = new JButton("CANCELAR");
			cancelButton.setBounds(10, 126, 114, 23);
			panel.add(cancelButton);
			cancelButton.setFont(new Font("TI-Nspire Sans", Font.BOLD, 11));
			cancelButton.setBackground(Color.LIGHT_GRAY);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelButton.setActionCommand("Cancel");
		}
		{

			JButton okButton = new JButton("REGISTRAR");
			okButton.setBounds(10, 87, 114, 23);
			panel.add(okButton);
			okButton.setFont(new Font("TI-Nspire Sans", Font.BOLD, 11));
			okButton.setBackground(Color.LIGHT_GRAY);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					User user = null;
					for (User u1 : Liga.getInstance().getUsuarios()) {
						if (u1.getUserName() == textField.getText()) {
							auxiliar = u1;
						}
					}
					if (textField.getText().isEmpty() || textField_1.getText().isEmpty() || textField_2.getText().isEmpty()) {
										JOptionPane.showMessageDialog(null, "Debe llenar todos los campos!" , "Error:", JOptionPane.WARNING_MESSAGE);
									} 
									 else if(Liga.getInstance().getUsuarios().size()==0) {
											 user = new User(0,textField.getText(),textField_1.getText());
										    Liga.getInstance().regUser(user);
										    Liga.getInstance().guardarDatos(Liga.getInstance());
											JOptionPane.showMessageDialog(null, "Operacion satisfactoria" , "Aviso:", JOptionPane.INFORMATION_MESSAGE);

										    dispose();
									} 
									 else if (Liga.getInstance().buscarUser(textField.getText() ) == null && auxiliar == null){
										 user = new User(1,textField.getText(),textField_1.getText());
									    Liga.getInstance().regUser(user);
									    Liga.getInstance().guardarDatos(Liga.getInstance());
										JOptionPane.showMessageDialog(null, "Operacion satisfactoria" , "Aviso:", JOptionPane.INFORMATION_MESSAGE);
									    dispose();
												}
									 if (auxiliar != null){
										JOptionPane.showMessageDialog(null, "Ya existe un usuario con este nombre" , "Error:", JOptionPane.WARNING_MESSAGE);
									}
								
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		
		JLabel lblConfirmarPassword = new JLabel("Confirmar Password:");
		lblConfirmarPassword.setFont(new Font("TI-Nspire Sans", Font.BOLD, 11));
		lblConfirmarPassword.setBounds(192, 64, 167, 14);
		panel.add(lblConfirmarPassword);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("TI-Nspire Sans", Font.BOLD, 11));
		textField_2.setBounds(192, 88, 147, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("REGISTRAR");
		lblNewLabel.setFont(new Font("TI-Nspire Sans", Font.BOLD, 16));
		lblNewLabel.setBounds(20, 4, 139, 25);
		contentPanel.add(lblNewLabel);
	}
}
