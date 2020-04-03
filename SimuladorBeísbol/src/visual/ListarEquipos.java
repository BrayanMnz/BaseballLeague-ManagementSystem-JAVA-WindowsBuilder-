package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
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
	private static 	JButton btnModify;
	private static JButton btnEliminar;
	private static DefaultTableModel model; 
	private static Object[] fila; 
	private static String identificador;
	private VerEquipo verTeam;
	private int index;
    private static JButton btnVerEquipo;

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
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				cargarEquipos();
			}
		});
		setTitle("Equipos");
		setBounds(100, 100, 687, 439);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(102, 204, 255));
		contentPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.LIGHT_GRAY);
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Listado de Equipos: ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
						index = table.getSelectedRow();
						if(index >= 0) { 
							identificador = (String)table.getModel().getValueAt(index, 0).toString();
							btnModify.setEnabled(true);
							btnEliminar.setEnabled(true);
							btnVerEquipo.setEnabled(true);
							
						}
						
					}
				});
				table.setBackground(Color.WHITE);
				table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				model = new DefaultTableModel(); 
				String[] columnNames = { "Nombre","ID Equipo", "Estadio", "Manager", "Fecha de Fundacion"};
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
				btnModify = new JButton("Modificar");
				btnModify.setEnabled(false);
				btnModify.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						  for(Equipo auxEquipo : Liga.getInstance().getMisEquipos()) {
								if(identificador.equalsIgnoreCase(auxEquipo.getNombreEquipo())) { 
	int option = JOptionPane.showConfirmDialog(null, "Está seguro que desea modificar este equipo: " ,"Información",JOptionPane.WARNING_MESSAGE);
		if(option == JOptionPane.OK_OPTION) { 
		   RegistrarEquipo e1 = new RegistrarEquipo();
		   e1.setModal(true);
		   e1.setLocationRelativeTo(null);
		   e1.setVisible(true);
			cargarEquipos();
			btnEliminar.setEnabled(false);
			btnModify.setEnabled(false);
			btnVerEquipo.setEnabled(false);
		}}}
						
						
					}
				});
				{
					 btnEliminar = new JButton("Eliminar");
					btnEliminar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
						   for(Equipo auxEquipo : Liga.getInstance().getMisEquipos()) {
							if(identificador.equalsIgnoreCase(auxEquipo.getNombreEquipo())) { 
int option = JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar este equipo: " ,"Información",JOptionPane.WARNING_MESSAGE);
	if(option == JOptionPane.OK_OPTION) { 
		Liga.getInstance().EliminarEquipo(auxEquipo);
		cargarEquipos();
		btnEliminar.setEnabled(false);
		btnModify.setEnabled(false);
		btnVerEquipo.setEnabled(false);
	}}}}
	 });
					
					 btnVerEquipo = new JButton("Ver Equipo");
					btnVerEquipo.setEnabled(false);
					btnVerEquipo.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							insertarEstadisticas();
							VerEquipo v1 = new VerEquipo(identificador);
							v1.setModal(true);
							v1.setVisible(true);
							v1.setLocationRelativeTo(null);
							
						}
					});
					buttonPane.add(btnVerEquipo);
					btnEliminar.setEnabled(false);
					buttonPane.add(btnEliminar);
				}
				btnModify.setActionCommand("OK");
				buttonPane.add(btnModify);
				getRootPane().setDefaultButton(btnModify);
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
	
	private static void insertarEstadisticas() { 
		for (Equipo auxEquipo : Liga.getInstance().getMisEquipos()) {
			if(auxEquipo.nombreEquipo.equalsIgnoreCase(Liga.getInstance().buscarEquipoByName(identificador).nombreEquipo));
			auxEquipo.setCarrerasLimpiasPermitidas(5);
			auxEquipo.setGanados(10);
			auxEquipo.setPerdidos(3);
		
		}
		
	}
	
}
