package applicationEnsei;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {	
			Parent root = FXMLLoader.load(getClass().getResource("PTUTGRP5Ens.fxml"));
            Scene scene = new Scene(root);            
            primaryStage.setScene(scene);
            primaryStage.setFullScreen(false);
	        primaryStage.setMaximized(false);
	        primaryStage.setResizable(false);
            primaryStage.show();
            
	        primaryStage.setTitle("Version enseignante");
	        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("logoappens.png")));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
