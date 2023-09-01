/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpd;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mukaffi
 */
public class HealthController implements Initializable {

    @FXML
    private AnchorPane Health_Pame;
    @FXML
    private Button onlineBTn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      /* onlineBTn.setOnMouseEntered(
       event->{
       Parent pane;
           try {
               profilepane.setPrefWidth(600);
               profilepane.setPrefHeight(400);
               
               pane = FXMLLoader.load(getClass().getResource("P_dash.fxml"));
            profilepane.getChildren().setAll(pane);
           } catch (IOException ex) {
               Logger.getLogger(HealthController.class.getName()).log(Level.SEVERE, null, ex);
           }
           
       
       }
       
       );
       onlineBTn.setOnMouseExited(
       
       event->{
           // pane = FXMLLoader.load(getClass().getResource("P_dash.fxml"));
           profilepane.getChildren().clear();
       }
       
       );*/
       
       
       
    }    

    @FXML
    private void BloodBank_Action(ActionEvent event) throws IOException {
     Parent pane=FXMLLoader.load(getClass().getResource("BloodBank.fxml"));
        Health_Pame.getChildren().setAll(pane);
    }
    


    @FXML
    private void Back_action(ActionEvent event) throws IOException {
     Parent pane=FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            Health_Pame.getChildren().setAll(pane);
    }

    @FXML
    private void Logout_Action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("Login.fxml"));
            Health_Pame.getChildren().setAll(pane);
    }
    @FXML
    private void Blood_bank_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("BloodBank.fxml"));
        Health_Pame.getChildren().setAll(pane);
    }
    @FXML
    private void health_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("Health.fxml"));
        Health_Pame.getChildren().setAll(pane);
    }
    @FXML
    private void Online_consult_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("Admin_ConsultList.fxml"));
        Health_Pame.getChildren().setAll(pane);
    }
    
    @FXML
    private void Donor_list_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("All_donor.fxml"));
        Health_Pame.getChildren().setAll(pane);
    }
    @FXML
    private void request_list_action(ActionEvent event) throws IOException {
  Parent pane=FXMLLoader.load(getClass().getResource("BloodRequestManagement.fxml"));
        Health_Pame.getChildren().setAll(pane);
    }
    @FXML
    private void Education_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("Education.fxml"));
        Health_Pame.getChildren().setAll(pane);
    }
    @FXML
    private void school_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("School_manageMent.fxml"));
        Health_Pame.getChildren().setAll(pane);
    }
    @FXML
    private void scholarship_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("ScholarShip_Management.fxml"));
        Health_Pame.getChildren().setAll(pane);
    }
    @FXML
    private void Food_cloths_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("Food_cloths.fxml"));
        Health_Pame.getChildren().setAll(pane);
    }
    @FXML
    private void shelter_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("Shelter.fxml"));
        Health_Pame.getChildren().setAll(pane);
    }@FXML
    private void Orphanage_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("Orphanage_Management.fxml"));
        Health_Pame.getChildren().setAll(pane);
    }@FXML
    private void Old_Age_home_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("Old_Age_home_Management.fxml"));
        Health_Pame.getChildren().setAll(pane);
    }
    @FXML
    private void Closed_action(ActionEvent event) throws IOException {
        System.exit(0);
    }

    @FXML
    private void Statistics_action(ActionEvent event) throws IOException {
    Parent pane=FXMLLoader.load(getClass().getResource("HealthChart.fxml"));
        Health_Pame.getChildren().setAll(pane);
    
    }

    

    @FXML
    private void AboutUS_action(ActionEvent event) throws IOException {
        
        Stage stage = new Stage();
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("About_Us.fxml"));
           Parent root1 = (Parent) fxmlLoader.load();
            stage.setTitle("About Us");
            stage.setScene(new Scene(root1));  
            stage.show();
    }

    

  
    
  

   
}
