package Component;

import Utility.chart.BlankPlotChart;
import Utility.chart.BlankPlotChatRender;
import Utility.chart.LegendItem;
import Utility.chart.ModelChart;
import Utility.chart.ModelLegend;
import Utility.chart.SeriesSize;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class BarChart extends javax.swing.JPanel {

    private List<ModelLegend> legends = new ArrayList<>();
    private List<ModelChart> model = new ArrayList<>();
    private final int seriesSize = 12;
    private final int seriesSpace = 6;

    public BarChart() {
        initComponents();
        blankPlotChart.setBlankPlotChatRender(new BlankPlotChatRender() {
            @Override
            public String getLabelText(int index) {
                return model.get(index).getLabel();
            }

            @Override
            public void renderSeries(BlankPlotChart chart, Graphics2D g2, SeriesSize size, int index) {
                double totalSeriesWidth = (seriesSize * legends.size()) + (seriesSpace * (legends.size() - 1));
                double x = (size.getWidth() - totalSeriesWidth) / 2;
                for (int i = 0; i < legends.size(); i++) {
                    ModelLegend legend = legends.get(i);
                    g2.setColor(legend.getColor());
                    double seriesValues = chart.getSeriesValuesOf(model.get(index).getValues()[i], size.getHeight());
                    g2.fillRect((int) (size.getX() + x), (int) (size.getY() + size.getHeight() - seriesValues), seriesSize, (int) seriesValues);
                    x += seriesSpace + seriesSize;
                }
            }
        });
    }

    public void addLegend(String name, Color color) {
        ModelLegend data = new ModelLegend(name, color);
        legends.add(data);
        panelLegend.add(new LegendItem(data));
        panelLegend.repaint();
        panelLegend.revalidate();
    }

    public void addData(ModelChart data) {
        model.add(data);
        blankPlotChart.setLabelCount(model.size());
        double max = data.getMaxValues();
        if (max > blankPlotChart.getMaxValues()) {
            blankPlotChart.setMaxValues(max);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelLegend = new javax.swing.JPanel();
        blankPlotChart = new Utility.chart.BlankPlotChart();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());

        panelLegend.setMinimumSize(new java.awt.Dimension(10, 50));
        panelLegend.setOpaque(false);
        panelLegend.setPreferredSize(new java.awt.Dimension(10, 50));
        panelLegend.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(panelLegend, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(blankPlotChart, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Utility.chart.BlankPlotChart blankPlotChart;
    private javax.swing.JPanel panelLegend;
    // End of variables declaration//GEN-END:variables
}
