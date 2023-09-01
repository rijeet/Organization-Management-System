/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpd;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author User
 */
public class User_BloodBankController implements Initializable {

    
    @FXML
    private AnchorPane Blood_Bank;
    @FXML
    private Button Donor_List;
    
    @FXML
    private Button Request_For_Blood;
    /**
     * Initializes the controller class.
     */ 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void Request_For_Blood_action(ActionEvent event) throws IOException {
        Parent pane=FXMLLoader.load(getClass().getResource("User_request_For_Blood.fxml"));
            Blood_Bank.getChildren().setAll(pane);
    }
    @FXML
    private void Donor_List_action(ActionEvent event) throws IOException {
    Parent pane=FXMLLoader.load(getClass().getResource("User_All_donor.fxml"));
           Blood_Bank.getChildren().setAll(pane);
        }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @FXML
    private void Back_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_HomePage.fxml"));
            Blood_Bank.getChildren().setAll(pane);
    }
    
    
       
    
    @FXML
    private void Logout_Action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("Login.fxml"));
            Blood_Bank.getChildren().setAll(pane);
    }
    
    @FXML
    private void Blood_bank_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_BloodBank.fxml"));
        Blood_Bank.getChildren().setAll(pane);
    }
    @FXML
    private void health_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_Health.fxml"));
        Blood_Bank.getChildren().setAll(pane);
    }
    @FXML
    private void Online_consult_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_onlineConsult.fxml"));
        Blood_Bank.getChildren().setAll(pane);
    }
    @FXML
    private void Blood_request_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_Request_For_Blood.fxml"));
        Blood_Bank.getChildren().setAll(pane);
    }
    @FXML
    private void Donor_list_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_All_donor.fxml"));
        Blood_Bank.getChildren().setAll(pane);
    }
   
    @FXML
    private void Education_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_Education.fxml"));
        Blood_Bank.getChildren().setAll(pane);
    }
    @FXML
    private void school_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_School_manageMent.fxml"));
        Blood_Bank.getChildren().setAll(pane);
    }
    @FXML
    private void scholarship_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_ScholarShip_Management.fxml"));
        Blood_Bank.getChildren().setAll(pane);
    }
    @FXML
    private void Food_cloths_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_Food_cloths.fxml"));
        Blood_Bank.getChildren().setAll(pane);
    }
    @FXML
    private void shelter_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_Shelter.fxml"));
        Blood_Bank.getChildren().setAll(pane);
    }@FXML
    private void Orphanage_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_Orphanage_Management.fxml"));
        Blood_Bank.getChildren().setAll(pane);
    }@FXML
    private void Old_Age_home_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_Old_Age_home_Management.fxml"));
        Blood_Bank.getChildren().setAll(pane);
    }
    @FXML
    private void Closed_action(ActionEvent event)  {
         Platform.exit();
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
