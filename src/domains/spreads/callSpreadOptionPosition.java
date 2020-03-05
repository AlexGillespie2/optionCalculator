/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains.spreads;

import framework.optionPosition.*;
import framework.optionPosition.optionException;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
/**
 *
 * @author alexg
 */
public class callSpreadOptionPosition extends optionPosition {
    private final callOption longCall;
    private final callOption shortCall;
    private final boolean isBearSpread;
    private final double totalCreditDebit;
    private final double shortDiffLongStrikes;
    private final double xMinVal;
    private final double xMaxVal;
    private final int numOfContracts;


    
    public callSpreadOptionPosition(callOption longCallInput, callOption shortCallInput, int numOfEachContract) {
        longCall = longCallInput;
        shortCall = shortCallInput;
        numOfContracts = numOfEachContract;
        isBearSpread = longCall.getStrike() > shortCall.getStrike();
        totalCreditDebit = shortCall.getAveragePrice() - longCall.getAveragePrice();
        shortDiffLongStrikes =  shortCall.getStrike() - longCall.getStrike();
        if(isBearSpread) {
            xMinVal = (shortCall.getStrike() - (Math.abs(shortDiffLongStrikes) /2));
            xMaxVal = (longCall.getStrike() +  (Math.abs(shortDiffLongStrikes) /2));
        } else {
            xMinVal = (longCall.getStrike() - (Math.abs(shortDiffLongStrikes) /2));
            xMaxVal = (shortCall.getStrike() +  (Math.abs(shortDiffLongStrikes) /2));
        }
        if(shortCallInput.getTicker().equals(longCallInput.getTicker())) {
            super.setTicker(shortCallInput.getTicker());   
        } else {
            throw new optionException("Call Spreads must have the same underlying.");
        }  
        if(shortCallInput.getExpiration().equals(longCallInput.getExpiration())) {
            super.setExpiration(shortCallInput.getExpiration());   
        } else {
            throw new optionException("Call Spreads must have the same Expiration");
        }  
        super.setPLChart(createPLChart(longCall, shortCall));
    }
    
    private XYChart.Series createCriticalPoints(callOption longCall, callOption shortCall) {
        XYChart.Series returnSeries = new XYChart.Series();
        
        
        
        if(isBearSpread) {
            returnSeries.getData().add(new XYChart.Data(xMinVal-1, 100 * numOfContracts * totalCreditDebit));
            returnSeries.getData().add(new XYChart.Data(shortCall.getStrike(), 100 * numOfContracts * totalCreditDebit));
            returnSeries.getData().add(new XYChart.Data(longCall.getStrike(), 100 * numOfContracts * (shortDiffLongStrikes + totalCreditDebit)));
            returnSeries.getData().add(new XYChart.Data(xMaxVal+1, 100 * numOfContracts * (shortDiffLongStrikes + totalCreditDebit)));
            returnSeries.setName(buildSpreadName());
            
        } else {
            returnSeries.getData().add(new XYChart.Data(xMinVal-1, 100 * numOfContracts * (shortDiffLongStrikes + totalCreditDebit)));
            returnSeries.getData().add(new XYChart.Data(longCall.getStrike(), 100 * numOfContracts * (shortDiffLongStrikes + totalCreditDebit) ));
            returnSeries.getData().add(new XYChart.Data(shortCall.getStrike(), 100 * numOfContracts * totalCreditDebit));
            returnSeries.getData().add(new XYChart.Data(xMaxVal+1, 100 * numOfContracts * totalCreditDebit));
            returnSeries.setName(buildSpreadName());
        }
        
        
        return returnSeries;
    }
    
    private LineChart createPLChart(callOption longCall, callOption shortCall) {
        final NumberAxis xAxis;
        final NumberAxis yAxis;
        if(isBearSpread) {
            xAxis = new NumberAxis(xMinVal, xMaxVal, 1);
            yAxis = new NumberAxis();
        } else {
            xAxis = new NumberAxis(xMinVal, xMaxVal, 1);
            yAxis = new NumberAxis();
        
        }
        yAxis.setLabel("P/L at Expiration");
        xAxis.setLabel("Share Price at Expiration (" + super.getExpiration() + ")");
        final LineChart<Number,Number> returnLineChart = new LineChart<>(xAxis,yAxis);
        returnLineChart.setTitle("P/L of the Defined Call Option Spread at expiration");
        returnLineChart.setCreateSymbols(false);
        returnLineChart.getData().add(createCriticalPoints(longCall, shortCall));
        
        return returnLineChart;
    }
    
    private String buildSpreadName() {
        String spreadName;
        if(isBearSpread) {
            spreadName = (super.getTicker() + " " + super.getExpiration() + " +1 $" + longCall.getStrike() + " -1 $" + shortCall.getStrike() + " Bear Call Spread");
        } else {
            spreadName = (super.getTicker() + " " + super.getExpiration() + " -1 $" + shortCall.getStrike() + " +1 $" + longCall.getStrike() + " Bull Call Spread");
        }
        return spreadName;
    }
    
    @Override
    public String toString() {
        return buildSpreadName();
    }
}
