/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpd;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
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
public class User_ScholarShip_ManagementController implements Initializable {

    @FXML
    private AnchorPane ScholarShip_ANCHR;
    
    @FXML
    private HBox Scholarship_Hbox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
public static boolean isAlpha(String s) {
        return s != null && s.matches("^[a-zA-Z ]*$");
    }
    
    public static boolean isDigit(String s) {
        return s != null && s.matches("^[0-9]*$");
    }
     int checker;
    
    public static boolean ValidPhoneNumber(String s) {
        return Pattern.matches("^[0-9]{11}", s);
    }
    
     public static boolean ValidGpa(String s) {
        return Pattern.matches("^[2.00-5.00]", s);
    }
      public static boolean ValidClass(String s) {
        return Pattern.matches("^[1-9]{1}", s);
    }
    
       public static boolean validateEmailAddress(String emailID) {
        String regex = "^[_a-z0-9-\\+]+(\\.[_a-z0-9-]+)*@"
                + "[a-z0-9-]+(\\.[a-z0-9]+)*(\\.[a-z]{2,})$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(emailID).matches();
	}
    @FXML
    private void Show_ScholarShipList(ActionEvent event) throws IOException {
     Parent pane=FXMLLoader.load(getClass().getResource("User_Show_All_ScholarShip_Student.fxml"));
            Scholarship_Hbox.getChildren().setAll(pane);
    }

     @FXML
    private void applyScholarship(ActionEvent event) throws IOException {
    Parent pane=FXMLLoader.load(getClass().getResource("User_Apply_For_Scholarship.fxml"));
            Scholarship_Hbox.getChildren().setAll(pane);
    
    
    }

   

    @FXML
    private void Back_action(ActionEvent event) throws IOException {
    Parent pane=FXMLLoader.load(getClass().getResource("User_Education.fxml"));
            ScholarShip_ANCHR.getChildren().setAll(pane);
    }
    
    @FXML
    private void Blood_bank_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_BloodBank.fxml"));
        ScholarShip_ANCHR.getChildren().setAll(pane);
    }
    @FXML
    private void health_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_Health.fxml"));
        ScholarShip_ANCHR.getChildren().setAll(pane);
    }
    @FXML
    private void Online_consult_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_onlineConsult.fxml"));
        ScholarShip_ANCHR.getChildren().setAll(pane);
    }
    @FXML
    private void Blood_request_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_Request_For_Blood.fxml"));
        ScholarShip_ANCHR.getChildren().setAll(pane);
    }
    @FXML
    private void Donor_list_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_All_donor.fxml"));
        ScholarShip_ANCHR.getChildren().setAll(pane);
    }
    
    @FXML
    private void Education_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_Education.fxml"));
        ScholarShip_ANCHR.getChildren().setAll(pane);
    }
    @FXML
    private void school_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_School_manageMent.fxml"));
        ScholarShip_ANCHR.getChildren().setAll(pane);
    }
    @FXML
    private void scholarship_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_ScholarShip_Management.fxml"));
        ScholarShip_ANCHR.getChildren().setAll(pane);
    }
    @FXML
    private void Food_cloths_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_Food_cloths.fxml"));
        ScholarShip_ANCHR.getChildren().setAll(pane);
    }
    @FXML
    private void shelter_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_Shelter.fxml"));
        ScholarShip_ANCHR.getChildren().setAll(pane);
    }@FXML
    private void Orphanage_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_Orphanage_Management.fxml"));
        ScholarShip_ANCHR.getChildren().setAll(pane);
    }@FXML
    private void Old_Age_home_action(ActionEvent event) throws IOException {
   Parent pane=FXMLLoader.load(getClass().getResource("User_Old_Age_home_Management.fxml"));
        ScholarShip_ANCHR.getChildren().setAll(pane);
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
