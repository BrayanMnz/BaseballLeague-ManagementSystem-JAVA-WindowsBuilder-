package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import logico.Equipo;
import logico.Liga;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GraficoTeams extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	
	public GraficoTeams() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				Liga.getInstance().cargarLiga(Liga.getInstance());
			}
		});
		setBounds(100, 100, 731, 512);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
        
        DefaultPieDataset data = new DefaultPieDataset();
        for (Equipo aux : Liga.getInstance().getMisEquipos()) {
        	data.setValue(aux.getNombreEquipo()+" ; "+aux.getGanados(), aux.getGanados());
        }
 
        JFreeChart chart = ChartFactory.createPieChart(
         "Juegos ganados", 
         data, 
         true, 
         true, 
         false);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBounds(0, 0, 715, 443);
        getContentPane().add(chartPanel);
	}

}
