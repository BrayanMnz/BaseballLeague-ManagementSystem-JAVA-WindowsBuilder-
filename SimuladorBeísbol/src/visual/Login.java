package visual;

import java.awt.EventQueue;
import logico.Season;
import logico.User;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Frame;

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
import javax.swing.border.EtchedBorder;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField passwordField;
	private Border emptyBorder = BorderFactory.createEmptyBorder();
	


	
	
	
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
		setUndecorated(true);
		setLocationRelativeTo(null);
		setTitle("Iniciar Sesion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 683, 428);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(324, 0, 359, 428);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(109, 205, 180, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(109, 276, 180, 20);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("INICIAR SESION");
		btnNewButton.setFont(new Font("TI-Nspire Sans", Font.BOLD, 13));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(192, 192, 192));
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
		btnNewButton.setBounds(121, 346, 139, 41);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/key_2_50px.png")));
		lblNewLabel_1.setBounds(30, 261, 52, 50);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/user_80px.png")));
		lblNewLabel_2.setBounds(10, 182, 72, 67);
		panel.add(lblNewLabel_2);
		
		JButton btnCerrar = new JButton("");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btnCerrar.setBorder(emptyBorder);
		btnCerrar.setBackground(Color.WHITE);
		btnCerrar.setForeground(Color.WHITE);
		btnCerrar.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/close_window_48px.png")));
		btnCerrar.setBounds(301, 11, 48, 48);
		panel.add(btnCerrar);
		
		JButton btnMinimizar = new JButton("");
		btnMinimizar.setForeground(Color.WHITE);
		btnMinimizar.setBackground(Color.WHITE);
		btnMinimizar.setBorder(emptyBorder);
		btnMinimizar.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/compress_48px.png")));
		btnMinimizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setState(Frame.ICONIFIED);
			}
		});
		btnMinimizar.setBounds(241, 11, 48, 48);
		panel.add(btnMinimizar);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/circled_user_128px.png")));
		lblNewLabel_3.setBounds(125, 70, 164, 134);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/horizontal_line_240px.png")));
		lblNewLabel_4.setBounds(78, 227, 211, 28);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(99, 319, 46, 14);
		panel.add(lblNewLabel_5);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/horizontal_line_240px.png")));
		label.setBounds(78, 307, 211, 29);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(0, 0, 325, 455);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Baseball");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Orator Std", Font.BOLD, 50));
		lblNewLabel_6.setBounds(10, 11, 305, 67);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel = new JLabel("Manager");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Orator Std", Font.BOLD, 50));
		lblNewLabel.setBounds(10, 53, 288, 104);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/baseball_ball_60px.png")));
		lblNewLabel_7.setBounds(10, 54, 84, 73);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/1200px-MiLB_logo.svg_.png")));
		lblNewLabel_8.setBounds(-18, 176, 369, 268);
		panel_1.add(lblNewLabel_8);
	}
}
