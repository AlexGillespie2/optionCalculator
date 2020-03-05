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
public class putSpreadOptionPosition extends optionPosition {
    private final putOption longPut;
    private final putOption shortPut;
    private final boolean isBearSpread;
    private final double totalCreditDebit;
    private final double longDiffShortStrikes;
    private final double xMinVal;
    private final double xMaxVal;
    private final int numOfContracts;


    
    public putSpreadOptionPosition(putOption longPutInput, putOption shortPutInput, int numOfEachContract) {
        longPut = longPutInput;
        shortPut = shortPutInput;
        numOfContracts = numOfEachContract;
        isBearSpread = longPut.getStrike() > shortPut.getStrike();
        totalCreditDebit = shortPut.getAveragePrice() - longPut.getAveragePrice();
        longDiffShortStrikes = longPut.getStrike() - shortPut.getStrike();
        if(isBearSpread) {
            xMinVal = (shortPut.getStrike() - (Math.abs(longDiffShortStrikes) /2));
            xMaxVal = (longPut.getStrike() +  (Math.abs(longDiffShortStrikes) /2));
        } else {
            xMinVal = (longPut.getStrike() - (Math.abs(longDiffShortStrikes) /2));
            xMaxVal = (shortPut.getStrike() +  (Math.abs(longDiffShortStrikes) /2));
        }
        if(shortPutInput.getTicker().equals(longPutInput.getTicker())) {
            super.setTicker(shortPutInput.getTicker());   
        } else {
            throw new optionException("Put Spreads must have the same underlying.");
        }  
        if(shortPutInput.getExpiration().equals(longPutInput.getExpiration())) {
            super.setExpiration(shortPutInput.getExpiration());   
        } else {
            throw new optionException("Put Spreads must have the same Expiration");
        }  
        super.setPLChart(createPLChart(longPut, shortPut));
    }
    
    private XYChart.Series createCriticalPoints(putOption longPut, putOption shortPut) {
        XYChart.Series returnSeries = new XYChart.Series();
        
        
        
        if(isBearSpread) {
            returnSeries.getData().add(new XYChart.Data(xMinVal-1, 100 * numOfContracts * (longDiffShortStrikes + totalCreditDebit)));
            returnSeries.getData().add(new XYChart.Data(shortPut.getStrike(), 100 * numOfContracts * (longDiffShortStrikes + totalCreditDebit) ));
            returnSeries.getData().add(new XYChart.Data(longPut.getStrike(), 100 * numOfContracts * totalCreditDebit));
            returnSeries.getData().add(new XYChart.Data(xMaxVal+1, 100 * numOfContracts * totalCreditDebit));
            returnSeries.setName(buildSpreadName());
            
        } else {
            returnSeries.getData().add(new XYChart.Data(xMinVal-1, 100 * numOfContracts * (longDiffShortStrikes + totalCreditDebit)));
            returnSeries.getData().add(new XYChart.Data(longPut.getStrike(), 100 * numOfContracts * (longDiffShortStrikes + totalCreditDebit) ));
            returnSeries.getData().add(new XYChart.Data(shortPut.getStrike(), 100 * numOfContracts * totalCreditDebit));
            returnSeries.getData().add(new XYChart.Data(xMaxVal+1, 100 * numOfContracts * totalCreditDebit));
            returnSeries.setName(buildSpreadName());
        }
        
        
        return returnSeries;
    }
    
    private LineChart createPLChart(putOption longPut, putOption shortPut) {
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
        returnLineChart.setTitle("P/L of the Defined Put Option Spread at expiration");
        returnLineChart.setCreateSymbols(false);
        returnLineChart.getData().add(createCriticalPoints(longPut, shortPut));
        
        return returnLineChart;
    }
    
    private String buildSpreadName() {
        String spreadName;
        if(isBearSpread) {
            spreadName = (super.getTicker() + " " + super.getExpiration() + " +1 $" + longPut.getStrike() + " -1 $" + shortPut.getStrike() + " Bear Put Spread");
        } else {
            spreadName = (super.getTicker() + " " + super.getExpiration() + " -1 $" + shortPut.getStrike() + " +1 $" + longPut.getStrike() + " Bull Put Spread");
        }
        return spreadName;
    }
}
