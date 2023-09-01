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
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mukaffi
 */
public class BloodRequestManagementController implements Initializable {

    @FXML
    private AnchorPane requestAnchor;
    @FXML
    private HBox tableHbox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void RequestList(ActionEvent event) throws IOException {
    Parent pane=FXMLLoader.load(getClass().getResource("RequestList.fxml"));
            tableHbox.getChildren().setAll(pane);
    
    }

    @FXML
    private void Back_action(ActionEvent event) throws IOException {
         Parent pane=FXMLLoader.load(getClass().getResource("BloodBank.fxml"));
            requestAnchor.getChildren().setAll(pane);
    }

    @FXML
    private void Donor_list_action(ActionEvent event) throws IOException {
         Parent pane=FXMLLoader.load(getClass().getResource("All_donor.fxml"));
        requestAnchor.getChildren().setAll(pane);
    }

    @FXML
    private void request_list_action(ActionEvent event) throws IOException {
     Parent pane=FXMLLoader.load(getClass().getResource("BloodRequestManagement.fxml"));
        requestAnchor.getChildren().setAll(pane);
    }

    @FXML
    private void Blood_bank_action(ActionEvent event) throws IOException {
         Parent pane=FXMLLoader.load(getClass().getResource("BloodBank.fxml"));
        requestAnchor.getChildren().setAll(pane);
    }

    @FXML
    private void Online_consult_action(ActionEvent event) throws IOException {
         Parent pane=FXMLLoader.load(getClass().getResource("Admin_ConsultList.fxml"));
        requestAnchor.getChildren().setAll(pane);
    }

    @FXML
   private void health_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("Health.fxml"));
        requestAnchor.getChildren().setAll(pane);
    }

    @FXML
    private void Orphanage_action(ActionEvent event) throws IOException {
         Parent pane=FXMLLoader.load(getClass().getResource("Orphanage_Management.fxml"));
        requestAnchor.getChildren().setAll(pane);
    }

    @FXML
    private void Old_Age_home_action(ActionEvent event) throws IOException {
         Parent pane=FXMLLoader.load(getClass().getResource("Old_Age_home_Management.fxml"));
        requestAnchor.getChildren().setAll(pane);
    }

    @FXML
    private void shelter_action(ActionEvent event) throws IOException {
        Parent pane=FXMLLoader.load(getClass().getResource("Shelter.fxml"));
        requestAnchor.getChildren().setAll(pane);
    }

    @FXML
    private void school_action(ActionEvent event) throws IOException {
         Parent pane=FXMLLoader.load(getClass().getResource("School_manageMent.fxml"));
        requestAnchor.getChildren().setAll(pane);
    }

    @FXML
    private void scholarship_action(ActionEvent event) throws IOException {
        Parent pane=FXMLLoader.load(getClass().getResource("ScholarShip_Management.fxml"));
        requestAnchor.getChildren().setAll(pane);
    }

    @FXML
    private void Education_action(ActionEvent event) {
    }

    @FXML
    private void Food_cloths_action(ActionEvent event) throws IOException {
        Parent pane=FXMLLoader.load(getClass().getResource("Food_cloths.fxml"));
            requestAnchor.getChildren().setAll(pane);
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

    @FXML
    private void Closed_action(ActionEvent event) {
         System.exit(0);
    }
    
}
