package tpd;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class Orphanage_ManagementController implements Initializable {

    @FXML
    private HBox Orphan_Hbox;
    @FXML
    private AnchorPane Orphanage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void Show_ALL_Orphanage(ActionEvent event) throws IOException {
    Parent pane=FXMLLoader.load(getClass().getResource("Show_All_Orphanage.fxml"));
            Orphan_Hbox.getChildren().setAll(pane);
            
    }

    @FXML
    private void Add_New_Orphanage(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("Add_New_Orphanage.fxml"));
            Orphan_Hbox.getChildren().setAll(pane);
    }

    @FXML
    private void ShowAll_Orphan(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("Show_ALL_Orphan.fxml"));
            Orphan_Hbox.getChildren().setAll(pane);
    
    }

    @FXML
    private void Add_new_Orphan(ActionEvent event) throws IOException {
    Parent pane=FXMLLoader.load(getClass().getResource("Add_New_Orphan.fxml"));
            Orphan_Hbox.getChildren().setAll(pane);
    
    
    }

    @FXML
    private void Back(ActionEvent event) throws IOException {
    Parent pane=FXMLLoader.load(getClass().getResource("Shelter.fxml"));
            Orphanage.getChildren().setAll(pane);
    }
    
    
    @FXML
    private void Blood_bank_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("BloodBank.fxml"));
        Orphanage.getChildren().setAll(pane);
    }
    @FXML
    private void health_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("Health.fxml"));
        Orphanage.getChildren().setAll(pane);
    }
    @FXML
    private void Online_consult_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("Admin_ConsultList.fxml"));
        Orphanage.getChildren().setAll(pane);
    }
    
    @FXML
    private void Donor_list_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("All_donor.fxml"));
        Orphanage.getChildren().setAll(pane);
    }
    @FXML
    private void request_list_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("BloodRequestManagement.fxml"));
        Orphanage.getChildren().setAll(pane);
    }
    @FXML
    private void Education_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("Education.fxml"));
        Orphanage.getChildren().setAll(pane);
    }
    @FXML
    private void school_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("School_manageMent.fxml"));
        Orphanage.getChildren().setAll(pane);
    }
    @FXML
    private void scholarship_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("ScholarShip_Management.fxml"));
        Orphanage.getChildren().setAll(pane);
    }
    @FXML
    private void Food_cloths_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("Food_cloths.fxml"));
        Orphanage.getChildren().setAll(pane);
    }
    @FXML
    private void shelter_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("Shelter.fxml"));
        Orphanage.getChildren().setAll(pane);
    }@FXML
    private void Orphanage_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("Orphanage_Management.fxml"));
        Orphanage.getChildren().setAll(pane);
    }@FXML
    private void Old_Age_home_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("Old_Age_home_Management.fxml"));
        Orphanage.getChildren().setAll(pane);
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
