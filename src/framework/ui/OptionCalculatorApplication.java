package framework.ui;

import framework.optionPosition.*;
import domains.spreads.*;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.Scene;
import java.time.*;


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
        tab1.setContent(new OptionPositionCalculatorGUI(new putSpreadOptionPosition(new putOption(true, "SPCE", 21, LocalDate.of(2020,5,15), 0.59), new putOption(false, "SPCE", 23, LocalDate.of(2020,5,15), 1.35), 1)));
        tabPane.getTabs().add(tab1);
        
        Tab tab2 = new Tab();
        tab2.setText("Call Spread");
        tab2.setContent(new OptionPositionCalculatorGUI(new callSpreadOptionPosition(new callOption(true, "SPCE", 23, LocalDate.of(2020,5,15), 0.5), new callOption(false, "SPCE", 21, LocalDate.of(2020,5,15), 1.5), 100)));
        tabPane.getTabs().add(tab2);

        
        Scene scene = new Scene(tabPane);
        primaryStage.setTitle("Option Position Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}