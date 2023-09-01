/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpd;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Gopal Saha
 */
public class User_onlineConsultController implements Initializable {

    @FXML
    private TextField patient_Name;
    @FXML
    private TextField patient_age;
    @FXML
    private TextField Problem;
    @FXML
    private AnchorPane online_Help;
    @FXML
    private TextField username;
    @FXML
    private Label nameWarning;
    @FXML
    private Label ageWarning;
    
     public static boolean isAlpha(String s) {
        return s != null && s.matches("^[a-zA-Z ]*$");
    }

    public static boolean isDigit(String s) {
        return s != null && s.matches("^[0-9]*$");
    }
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Back_action(ActionEvent event) throws IOException {
        Parent pane=FXMLLoader.load(getClass().getResource("User_HomePage.fxml"));
            online_Help.getChildren().setAll(pane);
    }

    @FXML
    private void send_action(ActionEvent event) throws SQLException {
        String name=patient_Name.getText();
        String age=patient_age.getText();
        String UserName=username.getText();
        String prob= Problem.getText();
        if(!isAlpha(name))
        {
            nameWarning.setText("Invalid Name");
        }else
            nameWarning.setText("");
        if(!isDigit(age))
        {
            ageWarning.setText("");
        }
        
         OnlineConsult or = new  OnlineConsult(name, UserName, age, prob);
                System.out.println(or);
                DatabaseAction dbAction = new DatabaseAction();
                dbAction.insertOnlineConsult(or);
                
           nameWarning.setText("");
            ageWarning.setText("");
         patient_Name.setText("");
       patient_age.setText("");
       Problem.setText("");
       username.setText("");
    }

    @FXML
    private void Reset_action(ActionEvent event) {
        patient_Name.setText("");
       patient_age.setText("");
       Problem.setText("");
    }

   @FXML
    private void Blood_bank_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_BloodBank.fxml"));
        online_Help.getChildren().setAll(pane);
    }
    @FXML
    private void health_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_Health.fxml"));
        online_Help.getChildren().setAll(pane);
    }
    @FXML
    private void Online_consult_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("Admin_ConsultList.fxml"));
        online_Help.getChildren().setAll(pane);
    }
    @FXML
    private void Blood_request_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_Request_For_Blood.fxml"));
        online_Help.getChildren().setAll(pane);
    }
    @FXML
    private void Donor_list_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_All_donor.fxml"));
        online_Help.getChildren().setAll(pane);
    }
    
    @FXML
    private void Education_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_Education.fxml"));
        online_Help.getChildren().setAll(pane);
    }
    @FXML
    private void school_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_School_manageMent.fxml"));
        online_Help.getChildren().setAll(pane);
    }
    @FXML
    private void scholarship_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_ScholarShip_Management.fxml"));
        online_Help.getChildren().setAll(pane);
    }
    @FXML
    private void Food_cloths_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_Food_cloths.fxml"));
        online_Help.getChildren().setAll(pane);
    }
    @FXML
    private void shelter_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_Shelter.fxml"));
        online_Help.getChildren().setAll(pane);
    }@FXML
    private void Orphanage_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_Orphanage_Management.fxml"));
        online_Help.getChildren().setAll(pane);
    }@FXML
    private void Old_Age_home_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_Old_Age_home_Management.fxml"));
        online_Help.getChildren().setAll(pane);
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
