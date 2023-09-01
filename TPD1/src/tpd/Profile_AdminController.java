/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpd;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;


/**
 * FXML Controller class
 *
 * @author User
 */
public class Profile_AdminController implements Initializable {

    @FXML
    private Label Name;
    @FXML
    private Label Phone_number;
    @FXML
    private Label Date_BIrth;
    @FXML
    private Label username;
    @FXML
    private Label DonateTimes;
    @FXML
    private Label Blood_Group;
    @FXML
    private Label upazila;
    @FXML
    private Label District;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            Name.setText("");
             Phone_number.setText("");
             Date_BIrth.setText("");;
             username.setText("");;
             DonateTimes.setText("");;
             Blood_Group.setText("");;
             upazila.setText("");;
             District.setText("");;
     ObservableList<AccountInformation> AccountList = FXCollections.observableArrayList();
      DatabaseAction dbAction = new DatabaseAction();
        try {
            AccountList = dbAction.getAllAccountinformation();
        } catch (SQLException ex) {
            Logger.getLogger(Profile_AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //LoginController.name1;
         for (AccountInformation Accnt : AccountList) {
             if(Accnt.getUsername().equals(LoginController.name1)){
             
             Name.setText(Accnt.getName());
             Phone_number.setText(Accnt.getPhoneNumber());
             Date_BIrth.setText(Accnt.getDate_of_Birth());
             username.setText(Accnt.getUsername());
             DonateTimes.setText(Accnt.getDonationTimes());
             Blood_Group.setText(Accnt.getBloodGroup());
             upazila.setText(Accnt.getUpazila());
             District.setText(Accnt.getDistrict());
             break;
             
             
             }
         
         
         }

    }    
    
}
