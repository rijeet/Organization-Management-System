/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpd;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Mukaffi
 */
public class the_peoplesDream extends Application {
    
     @Override
    public void start(Stage primaryStage) throws IOException {
   Parent root=FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene =new Scene(root); 
        primaryStage.setScene(scene);
        primaryStage.show();
            
        };
        
        
    

    public static void main(String[] args) throws SQLException {
        launch(args);
        //DatabaseAction dbAction =new DatabaseAction();
   
      
       }
        }
    

