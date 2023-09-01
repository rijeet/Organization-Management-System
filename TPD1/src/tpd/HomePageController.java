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
 * @author Mukaffi
 */
public class HomePageController implements Initializable {

    @FXML
    private AnchorPane Home_Page;
    @FXML
    private Button DonateButton;
    @FXML
    private Button NotificationButton;
    @FXML
    private Button UserBUtton;
    @FXML
    private Button About_US_Button1;

    /**
     * Initializes the controller class.
     */ static   Stage stage1 = new Stage();
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Health_Action(ActionEvent event) throws IOException {
    
   Parent pane=FXMLLoader.load(getClass().getResource("Health.fxml"));
            Home_Page.getChildren().setAll(pane);
           // System.out.println(LoginController.name1);
    }

    @FXML
    private void Education_Action(ActionEvent event) throws IOException {
     Parent pane=FXMLLoader.load(getClass().getResource("Education.fxml"));
            Home_Page.getChildren().setAll(pane);
    }

    @FXML
    private void Shelter_Action(ActionEvent event) throws IOException {
     Parent pane=FXMLLoader.load(getClass().getResource("Shelter.fxml"));
            Home_Page.getChildren().setAll(pane);
    }

    @FXML
    private void Food_Cloths_Action(ActionEvent event) throws IOException {
     Parent pane=FXMLLoader.load(getClass().getResource("Food_cloths.fxml"));
            Home_Page.getChildren().setAll(pane);
    }

    @FXML
    private void Logout_Action(ActionEvent event) throws IOException {
     Parent pane=FXMLLoader.load(getClass().getResource("Login.fxml"));
            Home_Page.getChildren().setAll(pane);
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

    @FXML
    private void Donation_button_action(ActionEvent event) throws IOException {
       stage1 = new Stage();
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DonationList.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
            stage1.setTitle("Donation");
            stage1.setScene(new Scene(root1));  
            stage1.show();
    
    }

    @FXML
    private void Notifiaction_button_Action(ActionEvent event) throws IOException {
    Stage stage = new Stage();
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Notificationbar.fxml"));
           Parent root1 = (Parent) fxmlLoader.load();
            stage.setTitle("Notifiaction");
            stage.setScene(new Scene(root1));  
            stage.show();

//Notificationbar 
    }

    @FXML
    private void Stats_action_home(ActionEvent event) throws IOException {
    Stage stage = new Stage();
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NGOstatistics.fxml"));
           Parent root1 = (Parent) fxmlLoader.load();
            stage.setTitle("Statistics ");
            stage.setScene(new Scene(root1));  
            stage.show();
    
    }
    
}
