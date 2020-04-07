package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import logico.Equipo;
import logico.Jugador;
import logico.Lesion;
import logico.Liga;
import logico.Pitcher;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Lesiones extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtEquipo;
	private JTextField txtNombre;
	private JTextField txtFechaInicio;
	private JTextField txtTipo;
	private JFormattedTextField formattedFechaInicio;
	private JFormattedTextField formattedFechaFinal;

	private JTextField txtFechaFinal;


	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public Lesiones(logico.Jugador aux) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
			}
		});
		
		MaskFormatter fechaFormato = null;
		try {
			fechaFormato = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
		
		setTitle("Insertar Lesion");
		setBounds(100, 100, 385, 249);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLUE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 11, 350, 188);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblEqupo = new JLabel("Equipo:");
		lblEqupo.setBounds(10, 21, 80, 14);
		panel.add(lblEqupo);
		
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 59, 80, 14);
		panel.add(lblNombre);
		
		JLabel lblFechaInicio = new JLabel("Fecha de Inicio:");
		lblFechaInicio.setBounds(10, 96, 111, 14);
		panel.add(lblFechaInicio);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(10, 128, 46, 14);
		panel.add(lblTipo);
		
		txtEquipo = new JTextField();
		txtEquipo.setEditable(false);
		txtEquipo.setBounds(10, 36, 186, 20);
		panel.add(txtEquipo);
		txtEquipo.setColumns(10);
		txtEquipo.setText(aux.getEquipo());
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(10, 74, 186, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		txtNombre.setText(aux.getNombre());
		
		formattedFechaInicio = new JFormattedTextField(fechaFormato);
		formattedFechaInicio.setBounds(10, 109, 86, 20);
		panel.add(formattedFechaInicio);
		//txtFechaInicio.setColumns(10);
		
		formattedFechaFinal = new JFormattedTextField(fechaFormato);
		formattedFechaFinal.setBounds(106, 109, 86, 20);
		panel.add(formattedFechaFinal);
		
		
		txtTipo = new JTextField();
		txtTipo.setBounds(10, 143, 86, 20);
		panel.add(txtTipo);
		txtTipo.setColumns(10);
		
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Lesion auxLesion=null;
				auxLesion = new Lesion(aux.getNombre(),formattedFechaInicio.getText(),formattedFechaFinal.getText(),txtTipo.getText());
				aux.getMisLesiones().add(auxLesion);
				JOptionPane.showMessageDialog(null, "Operacion Satisfactoria", "Informacion", JOptionPane.INFORMATION_MESSAGE);
				limpiarTexto();
			}
		});
		btnInsertar.setBounds(107, 142, 89, 23);
		panel.add(btnInsertar);
		
		
		JButton btnTerminado = new JButton("Terminado");
		btnTerminado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						dispose();
			}
		});
		btnTerminado.setBounds(211, 142, 89, 23);
		panel.add(btnTerminado);
		
		JLabel lblFechaFinal = new JLabel("Fecha de Finalizacion:");
		lblFechaFinal.setBounds(106, 96, 141, 14);
		panel.add(lblFechaFinal);
		

		
		
	}
	private void limpiarTexto() {
		formattedFechaInicio.setText("");
		formattedFechaFinal.setText("");
		txtTipo.setText("");
	}
	private static String fechaActual() {
		Date fecha = new Date();
		SimpleDateFormat formatoFecha = new SimpleDateFormat ("dd/MM/YYYY");
		return formatoFecha.format(fecha);
	}
}
