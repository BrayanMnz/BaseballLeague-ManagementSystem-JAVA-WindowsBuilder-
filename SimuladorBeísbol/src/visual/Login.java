package visual;

import java.awt.EventQueue;
import logico.Season;
import logico.User;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FileInputStream temporada;
				FileOutputStream temporada2; 
				ObjectInputStream temporadaRead;
				ObjectOutputStream temporadaWrite;
				try { 
					temporada = new FileInputStream("Season.dat");
					temporadaRead = new ObjectInputStream(temporada);
					Season temp = (logico.Season) temporadaRead.readObject();
					Season.getInstance();
					Season.setSeason(temp);
					temporada.close();
					temporadaRead.close();
				} catch(FileNotFoundException e ) { 
					try { 
						temporada2 = new FileOutputStream("Season.dat");
						temporadaWrite = new ObjectOutputStream(temporada2);
						User auxUser = new User("Administrador","admin","12345");
						Season.getInstance().regUser(auxUser);
					   temporadaWrite.writeObject(Season.getInstance());
					   temporada2.close();
					   temporadaWrite.close();
					} catch(FileNotFoundException e1) {
					} catch (IOException e1) {
						// TODO Auto-generated catch block
					}
				} catch (IOException e) {
					
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace(); }
				}
			
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Iniciar Sesion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 51, 204));
		panel.setBounds(5, 5, 424, 251);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblImagenUsuario = new JLabel("");
		lblImagenUsuario.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/user.png")));
		lblImagenUsuario.setBounds(49, 48, 82, 64);
		panel.add(lblImagenUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(129, 86, 190, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 15));
		lblUsuario.setBounds(49, 109, 82, 14);
		panel.add(lblUsuario);
		
		JLabel lblKey = new JLabel("");
		lblKey.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/key.png")));
		lblKey.setBounds(49, 134, 75, 64);
		panel.add(lblKey);
		
		JLabel lblContrasena = new JLabel("Contrase\u00F1a:");
		lblContrasena.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 15));
		lblContrasena.setBounds(49, 186, 99, 14);
		panel.add(lblContrasena);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(129, 163, 190, 20);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("Iniciar sesion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Usuario = "admin";
				String contrasena = "12345";
				
				 String password = new String(passwordField.getPassword());
				 
				 if(txtUsuario.getText().equalsIgnoreCase(Usuario) && password.equals(contrasena)) {
					mainVisual p1 = new mainVisual();
					 p1.setVisible(true);
					 dispose();
				 }
				 else { 
					 JOptionPane.showMessageDialog(null, "El usuario o la contraseña no son validos");
					 clean();
				 }
			}

			private void clean() {
				txtUsuario.setText("");
				passwordField.setText("");
				
			}
		});
		btnNewButton.setBounds(193, 194, 126, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/fondologin.jpg")));
		lblNewLabel.setBounds(0, 0, 424, 251);
		panel.add(lblNewLabel);
	}
}
