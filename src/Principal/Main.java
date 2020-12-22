/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author linux
 */
public class Main extends Application{
    
    public void start(Stage stage) throws Exception{
        
        Parent root = FXMLLoader.load(getClass().getResource("../Vista/Principal.fxml"));
        
        Scene scene = new Scene(root, 1280, 720);
        
        stage.setTitle("BGIN-OFFICE");
        stage.setScene(scene);
        stage.show();
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
