package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Liga;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;

import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PizarraFinal extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCarrerasL;
	private JTextField txtCarrerasV;
	private JTextField txtHitsL;
	private JTextField txtHitsV;
	private JTextField txtErrV;
	private JTextField txtErrL;
	private static String auxID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PizarraFinal dialog = new PizarraFinal(auxID);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PizarraFinal(String auxID) {
		this.auxID = auxID;
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				txtCarrerasL.setText(""+Liga.getInstance().buscarPartidoById(auxID).getLocalRun());
				txtCarrerasV.setText(""+Liga.getInstance().buscarPartidoById(auxID).getVisitaRun());
				txtHitsL.setText(""+Liga.getInstance().buscarPartidoById(auxID).getLocalHits());
				txtHitsL.setText(""+Liga.getInstance().buscarPartidoById(auxID).getVisitaHits());
				
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(PizarraFinal.class.getResource("/Imagenes/baseball_ball_128px.png")));
		setTitle("Pizarra Final!");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		
		panel.setLayout(null);
		panel.setOpaque(false);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Pizarra:", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(85, 34, 221, 124);
		contentPanel.add(panel);
		
		JLabel label = new JLabel("C");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 21));
		label.setBounds(25, 11, 24, 32);
		panel.add(label);
		
		JLabel label_1 = new JLabel("H");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		label_1.setBounds(96, 11, 24, 32);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("E");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 21));
		label_2.setBounds(169, 11, 24, 32);
		panel.add(label_2);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(10, 40, 201, 2);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(10, 80, 201, 2);
		panel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(69, 11, 2, 102);
		panel.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(147, 11, 2, 102);
		panel.add(separator_3);
		
		txtCarrerasL = new JTextField();
		txtCarrerasL.setEditable(false);
		txtCarrerasL.setOpaque(false);
		txtCarrerasL.setBounds(10, 49, 49, 26);
		panel.add(txtCarrerasL);
		txtCarrerasL.setColumns(10);
		
		txtCarrerasV = new JTextField();
		txtCarrerasV.setEditable(false);
		txtCarrerasV.setOpaque(false);
		txtCarrerasV.setColumns(10);
		txtCarrerasV.setBounds(10, 87, 49, 26);
		panel.add(txtCarrerasV);
		
		txtHitsL = new JTextField();
		txtHitsL.setEditable(false);
		txtHitsL.setOpaque(false);
		txtHitsL.setColumns(10);
		txtHitsL.setBounds(83, 48, 49, 26);
		panel.add(txtHitsL);
		
		txtHitsV = new JTextField();
		txtHitsV.setEditable(false);
		txtHitsV.setOpaque(false);
		txtHitsV.setColumns(10);
		txtHitsV.setBounds(83, 87, 49, 26);
		panel.add(txtHitsV);
		
		txtErrV = new JTextField();
		txtErrV.setEditable(false);
		txtErrV.setOpaque(false);
		txtErrV.setColumns(10);
		txtErrV.setBounds(160, 87, 49, 26);
		panel.add(txtErrV);
		
		txtErrL = new JTextField();
		txtErrL.setEditable(false);
		txtErrL.setOpaque(false);
		txtErrL.setColumns(10);
		txtErrL.setBounds(160, 48, 49, 26);
		panel.add(txtErrL);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PizarraFinal.class.getResource("/Imagenes/baseball-field-background.jpg")));
		lblNewLabel.setBounds(0, 0, 434, 228);
		contentPanel.add(lblNewLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
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
