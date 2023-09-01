/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpd;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mukaffi
 */
public class User_ShelterController implements Initializable {

    @FXML
    private AnchorPane Shelter_Pane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    

    @FXML
    private void Back_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_HomePage.fxml"));
            Shelter_Pane.getChildren().setAll(pane);
    }

    @FXML
    private void Logout_Action(ActionEvent event) throws IOException {
    Parent pane=FXMLLoader.load(getClass().getResource("Login.fxml"));
            Shelter_Pane.getChildren().setAll(pane);
    }

    @FXML
    private void Old_Age_Home(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_Old_Age_home_Management.fxml"));
            Shelter_Pane.getChildren().setAll(pane);
    }

    @FXML
    private void Orphanage(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_Orphanage_Management.fxml"));
            Shelter_Pane.getChildren().setAll(pane);
    
    }
    @FXML
    private void Blood_bank_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_BloodBank.fxml"));
        Shelter_Pane.getChildren().setAll(pane);
    }
    @FXML
    private void health_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_Health.fxml"));
        Shelter_Pane.getChildren().setAll(pane);
    }
    @FXML
    private void Online_consult_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_onlineConsult.fxml"));
        Shelter_Pane.getChildren().setAll(pane);
    }
    @FXML
    private void Blood_request_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_Request_For_Blood.fxml"));
        Shelter_Pane.getChildren().setAll(pane);
    }
    @FXML
    private void Donor_list_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_All_donor.fxml"));
        Shelter_Pane.getChildren().setAll(pane);
    }
    
    @FXML
    private void Education_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_Education.fxml"));
        Shelter_Pane.getChildren().setAll(pane);
    }
    @FXML
    private void school_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_School_manageMent.fxml"));
        Shelter_Pane.getChildren().setAll(pane);
    }
    @FXML
    private void scholarship_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_ScholarShip_Management.fxml"));
        Shelter_Pane.getChildren().setAll(pane);
    }
    @FXML
    private void Food_cloths_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_Food_cloths.fxml"));
        Shelter_Pane.getChildren().setAll(pane);
    }
    @FXML
    private void shelter_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_Shelter.fxml"));
        Shelter_Pane.getChildren().setAll(pane);
    }@FXML
    private void Orphanage_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_Orphanage_Management.fxml"));
        Shelter_Pane.getChildren().setAll(pane);
    }@FXML
    private void Old_Age_home_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_Old_Age_home_Management.fxml"));
        Shelter_Pane.getChildren().setAll(pane);
    }
    @FXML
    private void Closed_action(ActionEvent event) throws IOException {
        System.exit(0);
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
