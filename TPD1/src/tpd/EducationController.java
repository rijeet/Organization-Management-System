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
public class EducationController implements Initializable {

    @FXML
    private AnchorPane Educationpane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void School_Action(ActionEvent event) throws IOException {
     Parent pane=FXMLLoader.load(getClass().getResource("School_manageMent.fxml"));
            Educationpane.getChildren().setAll(pane);
        
    }

    @FXML
    private void Scholarship_action(ActionEvent event) throws IOException {
    Parent pane=FXMLLoader.load(getClass().getResource("ScholarShip_Management.fxml"));
            Educationpane.getChildren().setAll(pane);
    
    }

    @FXML
    private void Back_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            Educationpane.getChildren().setAll(pane);
    }

    @FXML
    private void Logout_Action(ActionEvent event) throws IOException {
      Parent pane=FXMLLoader.load(getClass().getResource("Login.fxml"));
            Educationpane.getChildren().setAll(pane);
    }
    
     @FXML
    private void Blood_bank_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("BloodBank.fxml"));
        Educationpane.getChildren().setAll(pane);
    }
    @FXML
    private void health_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("Health.fxml"));
        Educationpane.getChildren().setAll(pane);
    }
    @FXML
    private void Online_consult_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("Admin_ConsultList.fxml"));
        Educationpane.getChildren().setAll(pane);
    }
   
    @FXML
    private void Donor_list_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("All_donor.fxml"));
        Educationpane.getChildren().setAll(pane);
    }
    @FXML
    private void request_list_action(ActionEvent event) throws IOException {
    Parent pane=FXMLLoader.load(getClass().getResource("BloodRequestManagement.fxml"));
        Educationpane.getChildren().setAll(pane);
    }
    @FXML
    private void Education_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("Education.fxml"));
        Educationpane.getChildren().setAll(pane);
    }
    @FXML
    private void school_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("School_manageMent.fxml"));
        Educationpane.getChildren().setAll(pane);
    }
    @FXML
    private void scholarship_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("ScholarShip_Management.fxml"));
        Educationpane.getChildren().setAll(pane);
    }
    @FXML
    private void Food_cloths_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("Food_cloths.fxml"));
        Educationpane.getChildren().setAll(pane);
    }
    @FXML
    private void shelter_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("Shelter.fxml"));
        Educationpane.getChildren().setAll(pane);
    }@FXML
    private void Orphanage_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("Orphanage_Management.fxml"));
        Educationpane.getChildren().setAll(pane);
    }@FXML
    private void Old_Age_home_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("Old_Age_home_Management.fxml"));
        Educationpane.getChildren().setAll(pane);
    }
    @FXML
    private void Closed_action(ActionEvent event) throws IOException {
        System.exit(0);
    }
     @FXML
    private void EducationStatistics_Action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("EducationPiChart.fxml"));
        Educationpane.getChildren().setAll(pane);
    
    
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
