package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Equipo;
import logico.Liga;
import logico.Season;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ListarEquipos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static 	JButton btnVerEquipo;
	private static DefaultTableModel model; 
	private static Object[] fila; 
	private VerEquipo verTeam;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarEquipos dialog = new ListarEquipos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarEquipos() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				cargarEquipos();
			}
		});
		setTitle("Equipos");
		setBounds(100, 100, 687, 439);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLUE);
		contentPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.LIGHT_GRAY);
			panel.setBorder(new TitledBorder(null, "Listado de Equipos: ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 10, 651, 346);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 25, 631, 310);
				panel.add(scrollPane);
				
				table = new JTable();
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int index = table.getSelectedRow();
						if(index >= 0) { 
							btnVerEquipo.setEnabled(true);
							
							
						}
						
					}
				});
				table.setBackground(Color.LIGHT_GRAY);
				table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				model = new DefaultTableModel(); 
				String[] columnNames = {"Nombre", "id Equipo", "Estadio", "Manager", "Fecha de Fundacion"};
				model.setColumnIdentifiers(columnNames);
				table.setModel(model);
				scrollPane.setViewportView(table);
			}
			
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnVerEquipo = new JButton("Ver Equipo");
				btnVerEquipo.setEnabled(false);
				btnVerEquipo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						VerEquipo equipo1 = new VerEquipo();
						equipo1.setModal(true);
						equipo1.setVisible(true);
					
						
						
					}
				});
				btnVerEquipo.setActionCommand("OK");
				buttonPane.add(btnVerEquipo);
				getRootPane().setDefaultButton(btnVerEquipo);
				}
			cargarEquipos();
			
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

	private static void cargarEquipos() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()]; 
		for (Equipo auxEquipo : Liga.getInstance().getMisEquipos()) {
			fila[0] = auxEquipo.getNombreEquipo();
			fila[1] = auxEquipo.getId();
			fila[2] = auxEquipo.getEstadio();
			fila[3] = auxEquipo.getTrainer();
			fila[4] = auxEquipo.getFechaFundacion();
			model.addRow(fila);
			
		}
	}
}
