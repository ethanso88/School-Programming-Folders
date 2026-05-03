package View;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.Color;

import javax.swing.JPanel;

public class ImportExportPanel extends JPanel {

    public ImportExportPanel() {
    	setSize(1186, 628);
		setLayout(null);
		
		setBackground(Color.red);
		
        // Create dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Add data for "Sales"
        dataset.addValue(254.2, "Live Animals", "2009");
        dataset.addValue(243.6, "Live Animals", "2010");
        dataset.addValue(208.0, "Live Animals", "2011");
        dataset.addValue(218.4, "Live Animals", "2012");

        // Add data for "Profit"
        dataset.addValue(576.2, "Red Meats", "2009");
        dataset.addValue(718.7, "Red Meats", "2010");
        dataset.addValue(645.3, "Red Meats", "2011");
        dataset.addValue(547.2, "Red Meats", "2012");

        // Create chart
        JFreeChart chart = ChartFactory.createLineChart(
                "Live Animals vs Red Meat",            // Chart title
                "Year",                       // X-axis label
                "CAD",                     // Y-axis label
                dataset,                      // Data
                PlotOrientation.VERTICAL,     // Orientation (vertical)
                true,                         // Show legend
                true,                         // Show tooltips
                false                         // No URLs
        );

        // Create ChartPanel and set it as the content pane
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setDisplayToolTips(true);
        chartPanel.setBounds(0, 0, 800, 600);
        add(chartPanel);

        // Ensure proper resizing
        revalidate();
        repaint();
    }

}
