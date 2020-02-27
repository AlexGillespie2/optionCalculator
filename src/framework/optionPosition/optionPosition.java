/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.optionPosition;

import framework.optionPosition.*;
import domains.spreads.*;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
/**
 *
 * @author alexg
 */
public class optionPosition {
    
    private String ticker;
    private String expiration;
    private LineChart PLChart;
    

    
    public void setPLChart(LineChart chart) {
        PLChart = chart;
    }
    
    public LineChart getPLChart() {
        return PLChart;
    }
    
    public void setExpiration(String exp) {
        expiration = exp;
    }
    
    public String getExpiration() {
        return expiration;
    }
    
    public void setTicker(String tickerInput) {
        ticker = tickerInput;
    }
    
    public String getTicker() {
        return ticker;
    }
}
