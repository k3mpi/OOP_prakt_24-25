package main;

import gui.BuergeraemterAnwendersystem;
import gui.BuergeramtControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		
	
	
		BuergeramtControl control = new BuergeramtControl(primaryStage);

	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
