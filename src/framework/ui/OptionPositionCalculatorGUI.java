/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.ui;

import framework.optionPosition.*;

import javafx.scene.layout.VBox;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
/**
 *
 * @author alexg
 */
public class OptionPositionCalculatorGUI extends VBox {
    
    private LineChart PLChart;
    
    public OptionPositionCalculatorGUI() {
        
    }
    
    public OptionPositionCalculatorGUI(optionPosition optionPosition) {
        PLChart = optionPosition.getPLChart();
        super.setPrefSize(2000,1000);
        PLChart.setPrefSize(1800, 600);
        super.getChildren().addAll(PLChart);
    }
    
    
    
}
