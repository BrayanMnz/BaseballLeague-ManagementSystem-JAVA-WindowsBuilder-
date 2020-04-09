package visual;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import logico.Equipo;
import logico.Liga;

public class Grafico extends JFrame{
    JPanel panel;
    public Grafico(){
        setTitle("Comparativa de Equipos");
        setSize(731,482);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        Liga.getInstance().cargarLiga(Liga.getInstance());
        init();
    }
 
    private void init() {
        panel = new JPanel();
        getContentPane().add(panel);
        
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
        panel.setLayout(null);
 
        // Crear el Panel del Grafico con ChartPanel
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBounds(0, 0, 715, 443);
        panel.add(chartPanel);
    }
    
    public static void main(String args[]){
        new Grafico().setVisible(true);
    }
}