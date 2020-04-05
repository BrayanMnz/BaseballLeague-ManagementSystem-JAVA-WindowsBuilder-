package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logico.Equipo;
import logico.Lesion;
import logico.Liga;
import logico.Season;
import logico.User;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class tablaUsuarios extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable tableLesiones;
	private static Object[] fila;
	private static DefaultTableModel model;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public tablaUsuarios() {
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(tablaUsuarios.class.getResource("/Imagenes/close_window_16px.png")));
		setTitle("Lesiones");
		setBounds(100, 100, 454, 259);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panelLesiones = new JPanel();
			panelLesiones.setBackground(Color.LIGHT_GRAY);
			panelLesiones.setBounds(24, 67, 430, 192);
			contentPanel.add(panelLesiones);
			panelLesiones.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 0, 430, 192);
				panelLesiones.add(scrollPane);
				{
					tableLesiones = new JTable();
					scrollPane.setColumnHeaderView(tableLesiones);
					String[] columnas = {"Nombre de Usuario","Contraseña"};
					model = new DefaultTableModel();
					model.setColumnIdentifiers(columnas);
					tableLesiones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					tableLesiones.setModel(model);
					scrollPane.setViewportView(tableLesiones);
					
					JLabel lblTitulo = new JLabel("USUARIOS");
					lblTitulo.setFont(new Font("Orator Std", Font.BOLD, 25));
					lblTitulo.setBounds(24, 31, 126, 25);
					contentPanel.add(lblTitulo);
					
					JButton btnNewButton = new JButton("MODIFICAR");
					btnNewButton.setBackground(Color.WHITE);
					btnNewButton.setFont(new Font("TI-Nspire Sans", Font.BOLD, 11));
					btnNewButton.setBounds(170, 31, 95, 23);
					contentPanel.add(btnNewButton);
					
					JButton btnNewButton_1 = new JButton("ELIMINAR");
					btnNewButton_1.setBackground(Color.WHITE);
					btnNewButton_1.setFont(new Font("TI-Nspire Sans", Font.BOLD, 11));
					btnNewButton_1.setBounds(275, 31, 98, 23);
					contentPanel.add(btnNewButton_1);
					
					JButton btnCerrar = new JButton("");
					btnCerrar.setIcon(new ImageIcon(tablaUsuarios.class.getResource("/Imagenes/close_window_32px.png")));
					btnCerrar.setBounds(418, 31, 26, 23);
					contentPanel.add(btnCerrar);
					
					JButton btnMinimizar = new JButton("");
					btnMinimizar.setIcon(new ImageIcon(tablaUsuarios.class.getResource("/Imagenes/minimize_window_32px.png")));
					btnMinimizar.setBounds(383, 31, 26, 23);
					contentPanel.add(btnMinimizar);
					loadUsers();
					 
				}
			}
		}
	}
	
	public static void loadUsers() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
			for(User auxUser : Liga.getInstance().getUsuarios()) {
				if (auxUser.getTipo()==1) {
					fila[0] = auxUser.getUserName();
					fila[1] = auxUser.getPass();
					model.addRow(fila);
				}
		}
			
		TableColumnModel columnModel = tableLesiones.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(315);
		columnModel.getColumn(1).setPreferredWidth(315);
		/*if(tableModel.getRowCount()==0){
			btnEliminar.setEnabled(false);
			btnModificar.setEnabled(false);
		}*/
		
	}
}
