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
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class User_DoctorController implements Initializable {

    @FXML
    private Button patient_List_Button;
    @FXML
    private Button DonateButton;
    @FXML
    private Button NotificationButton;
    @FXML
    private Button UserBUtton;
    @FXML
    private Button About_US_Button1;
    @FXML
    private AnchorPane Doctor_Pane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Logout_Action(ActionEvent event) throws IOException {
        Parent pane=FXMLLoader.load(getClass().getResource("Login.fxml"));
            Doctor_Pane.getChildren().setAll(pane);
    }
   @FXML
    private void patientAction(ActionEvent event) throws IOException {
        Parent pane=FXMLLoader.load(getClass().getResource("Patient_List.fxml"));
            Doctor_Pane.getChildren().setAll(pane);
    }
    @FXML
    private void Profile_action(ActionEvent event) throws IOException {
          Stage stage = new Stage();
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Profile_Admin.fxml"));
           Parent root1 = (Parent) fxmlLoader.load();
            stage.setTitle("Profile");
            stage.setScene(new Scene(root1));  
            stage.show();
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
