/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.ui;

import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
/**
 *
 * @author alexg
 */
public class MainMenuGUI extends VBox {
    
    private static final String INSTRUCTIONS_MSG = "Main menu of the options position calculator. Go the the tab with the title of the option position you are interested in.";
    
    private Label instructionsLbl;
    
    public MainMenuGUI() {
        super.setPrefSize(2000,1000);
        instructionsLbl = new Label();
        instructionsLbl.setText(INSTRUCTIONS_MSG);
        instructionsLbl.setWrapText(true);
        
        
        
        
        
        super.getChildren().addAll(instructionsLbl);
    }
}
