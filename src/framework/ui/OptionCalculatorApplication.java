package framework.ui;

import framework.optionPosition.*;
import domains.spreads.*;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.Scene;


/**
 * application to use many types of option positions in a tabbed window
 */
public class OptionCalculatorApplication extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        TabPane tabPane = new TabPane();
        tabPane.setPrefSize(2000, 1000);
	/* Add tabs using the following */

	Tab tab0 = new Tab();
        tab0.setText("Option Position Menu");
        tab0.setContent(new MainMenuGUI());
        tabPane.getTabs().add(tab0);
        
        
        Tab tab1 = new Tab();
        tab1.setText("Put Spread");
        tab1.setContent(new OptionPositionCalculatorGUI(new putSpreadOptionPosition(new putOption(true, "SPCE", 21, "2/21/2020", 0.59), new putOption(false, "SPCE", 23, "2/21/2020", 1.35))));
        tabPane.getTabs().add(tab1);

        
        Scene scene = new Scene(tabPane);
        primaryStage.setTitle("Option Position Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}