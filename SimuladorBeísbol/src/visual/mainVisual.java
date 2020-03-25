package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class mainVisual extends JFrame {

	private JPanel panelPrincipal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainVisual frame = new mainVisual();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public mainVisual() {
		setTitle("Simlador de Be\u00EDsbol");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 557);
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		JButton btnJugadores = new JButton("Jugadores");
		btnJugadores.setBounds(10, 11, 89, 23);
		panelPrincipal.add(btnJugadores);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(109, 11, 89, 23);
		panelPrincipal.add(btnNewButton_1);
	}
}
