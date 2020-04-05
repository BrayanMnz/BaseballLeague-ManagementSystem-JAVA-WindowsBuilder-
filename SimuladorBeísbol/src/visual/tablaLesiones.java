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
import logico.Jugador;
import logico.Lesion;
import logico.Season;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class tablaLesiones extends JDialog {

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
	public tablaLesiones(Jugador aux) {
		setTitle("Lesiones");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLUE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panelLesiones = new JPanel();
			panelLesiones.setBackground(Color.LIGHT_GRAY);
			panelLesiones.setBounds(10, 11, 414, 192);
			contentPanel.add(panelLesiones);
			panelLesiones.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 0, 414, 192);
				panelLesiones.add(scrollPane);
				{
					tableLesiones = new JTable();
					scrollPane.setColumnHeaderView(tableLesiones);
					String[] columnas = {"Fecha de Inicio","Tipo","Fin de Lesion","Jugador"};
					model = new DefaultTableModel();
					model.setColumnIdentifiers(columnas);
					tableLesiones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					tableLesiones.setModel(model);
					scrollPane.setViewportView(tableLesiones);
					loadLesiones(aux);
					 
				}
			}
		}
		{
			JPanel panelBotones = new JPanel();
			panelBotones.setBackground(Color.LIGHT_GRAY);
			panelBotones.setBounds(10, 214, 414, 36);
			contentPanel.add(panelBotones);
		}
	}
	
	public static void loadLesiones(logico.Jugador aux) {
		model.setRowCount(0);
		//DecimalFormat df = new DecimalFormat("#.##");
		fila = new Object[model.getColumnCount()];
			for(Lesion auxLesion : aux.getMisLesiones() ) {
					fila[0] = auxLesion.getFechaInicioLesion();
					fila[1] = auxLesion.getTipoLesion();
					fila[2] = auxLesion.getFechaFinalLesion();
					fila[3] = auxLesion.getMiJugador();
					model.addRow(fila);
		}
			
		TableColumnModel columnModel = tableLesiones.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(160);
		columnModel.getColumn(1).setPreferredWidth(180);
		columnModel.getColumn(2).setPreferredWidth(150);
		columnModel.getColumn(3).setPreferredWidth(140);	
		/*if(tableModel.getRowCount()==0){
			btnEliminar.setEnabled(false);
			btnModificar.setEnabled(false);
		}*/
		
	}
}
