/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpd;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author User
 */
public class Event_AnnoucementController implements Initializable {

    @FXML
    private HBox EventNotification;
    @FXML
    private TextField SL_NO;
    @FXML
    private TextField Event_Name;
    @FXML
    private DatePicker Date_Picker;
    @FXML
    private TextField Time;
    @FXML
    private TextField Event_Place;
    @FXML
    private TextField Event_Description;
    @FXML
    private Button Annoucement;
    @FXML
    private Label SL;
    @FXML
    private Label Event_nameL;
    @FXML
    private Label Event_DescripL;
    int checker;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    
    }    
public static boolean isDigit(String s) {
        return s != null && s.matches("^[0-9]*$");
    }
public static boolean isAlpha(String s) {
        return s != null && s.matches("^[a-zA-Z ]*$");
    }
 
    @FXML
    private void announcementAction(ActionEvent event) throws Exception {
    
       String Sl_No=SL_NO.getText();
       String Event_name=Event_Name.getText();
    //LocalDate lb = Last_Donation.getValue();
       LocalDate ld =Date_Picker.getValue();
       String Event_Time=Time.getText();
       String event_Place=Event_Place.getText();
       String event_discription=Event_Description.getText();
    
     checker = 0;
   
    if (Sl_No.equals("") || Event_name.equals("") || event_Place.equals("") || Event_Time.equals("") || event_discription.equals("")){
            Alert al = new Alert(Alert.AlertType.WARNING);
            al.setTitle("Error");
            al.setContentText("Please Fillup All Information Correctly!");
            al.showAndWait();
    } else {
             try {
                  String Event_Date=ld.toString();
             
                
                  if (!isAlpha(Event_name)) {
                    Event_nameL.setText("Invalid");
                    checker = 1;
                  }
                 if (!isAlpha(event_discription)) {
                    Event_DescripL.setText("Invalid");
                    checker = 1;
                 }
                
                 if (!isDigit(Sl_No)) {
                    SL.setText("Invalid");
                    checker = 1;
                 }
             
                 if (checker == 1) {
                    throw new Exception();
                 }
    
                  Event ev =new Event(Sl_No,Event_name,Event_Date,Event_Time,event_Place,event_discription);
                  DatabaseAction dbAction = new DatabaseAction();
                  System.out.println(ev);
                  dbAction.insertEvent(ev);
                  SL_NO.clear();
                   Event_Name.clear();
                   Date_Picker.getEditor().clear();;
                   Time.clear();
                   Event_Place.clear();
                   Event_Description.clear();
    
     
    
               } catch (Exception e) {
        
                    }
           }
       }
}
