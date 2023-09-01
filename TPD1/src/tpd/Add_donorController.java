/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;




public class Add_donorController implements Initializable {

    @FXML
    private AnchorPane ADD_Donor_Anchor;
    @FXML
    private TextField FirstName;
    @FXML
    private TextField Phone_Number;
    @FXML
    private TextField Donate_Times;
    @FXML
    private DatePicker Last_Donation;
    @FXML
    private TextField Upazila;
    

    @FXML
    private ComboBox<String> District;
    ObservableList<String> districtAll = FXCollections.observableArrayList(
"Barguna",
"Barisal",
"Bhola",
"Jhalokati",
"Patuakhali", 
"Pirojpur", 
"Bandarban", 
"Brahmanbaria", 
"Chandpur", 
"Chittagong", 
"Comilla", 
"Cox's Bazar", 
"Feni",
"Khagrachhari", 
"Lakshmipur", 
"Noakhali" ,
"Rangamati" ,
"Dhaka" ,
"Faridpur" ,
"Gazipur" ,
"Gopalganj ",
"Jamalpur " ,
"Kishoreganj " ,
"Madaripur " ,
"Manikganj" ,
"Munshiganj " ,
"Mymensingh " ,
"Narayanganj " ,
"Narsingdi " ,
"Netrakona " ,
"Rajbari " ,
"Shariatpur ",
"Sherpur " ,
"Tangail " ,
"Bagerhat ",
"Chuadanga ",
"Jessore ",
"Jhenaidah ",
"Khulna",
"Kushtia" ,
"Magura ",
"Meherpur ",
"Narail ",
"Satkhira ",
"Bogra ",
"Joypurhat ",
"Naogaon ",
"Natore ",
"Nawabganj",
"Pabna ",
"Rajshahi ",
"Sirajganj ",
"Dinajpur ",
"Gaibandha ",
"Kurigram ",
"Lalmonirhat ",
"Nilphamari",
"Panchagarh ",
"Rangpur ",
"Thakurgaon ",
"Habiganj ",
"Moulvibazar ",
"Sunamganj ",
"Sylhet ");
    @FXML
    private ComboBox<String> BloodGroup;
   
   ObservableList<String> Blood_Groups = FXCollections.observableArrayList("O+","O-","A+","A-","B+","B-","AB+","AB-");
    @FXML
    private Label PhoneNumberCheck;
    @FXML
    private Label nameChecker;
    @FXML
    private Label donateCheck;
    @FXML
    private Label upazilaCheck;
  

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        BloodGroup.setItems(Blood_Groups);
        District.setItems(districtAll);
        DatabaseAction dbAction= new DatabaseAction();
        try {
            DonnorListController.Dnrlist=dbAction.getAllDonor();
        } catch (SQLException ex) {
            Logger.getLogger(Add_donorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    int checker = 0;
     public static boolean isAlpha(String s) {
        return s != null && s.matches("^[a-zA-Z ]*$");
    }

    public static boolean isDigit(String s) {
        return s != null && s.matches("^[0-9]*$");
    }
    public static boolean ValidPhoneNumber(String s) {
        return Pattern.matches("^[0-9]{11}", s);
    }
    
    @FXML
    private void Save_Button_Action(ActionEvent event) throws SQLException {
        String name = FirstName.getText();
        String PhoneNumber = Phone_Number.getText();
        String DonateTimes = Donate_Times.getText();
        LocalDate lb = Last_Donation.getValue();

        String Blood_Group = BloodGroup.getValue();
        String Dis = District.getValue();
        String upzila = Upazila.getText();
       DatabaseAction dbAction = new DatabaseAction();
        checker = 0;
        if (name.equals("") || upzila.equals("") || PhoneNumber.equals("")) {
            Alert al = new Alert(Alert.AlertType.WARNING);
            al.setTitle("Error");
            al.setContentText("Please Fillup All Information Correctly!");
            al.showAndWait();
        }

        try {
            String LastDonation = lb.toString();
            if (!isAlpha(name)) {
                nameChecker.setText("Invalid Input");
                checker = 1;
            }else {
                nameChecker.setText("");
            
            }
            if (!isAlpha(upzila)) {
                upazilaCheck.setText("Invalid Input");
                checker = 1;
            }else 
            {    upazilaCheck.setText("");       }
            
            if (!ValidPhoneNumber(PhoneNumber)) {
                PhoneNumberCheck.setText("Invalid Input");
                checker = 1;
            }else {
            PhoneNumberCheck.setText("");
            
            }
            if (!isDigit(DonateTimes)) {
                donateCheck.setText("Invalid Input");
                checker = 1;
            }else {
            
            donateCheck.setText("");
            }

            if (checker == 1) {
                throw new Exception();
            } else if (checker == 0) {
                Donor Dnr = new Donor(name, Blood_Group, PhoneNumber, Dis, upzila, DonateTimes, LastDonation);
                System.out.println(Dnr);
                
                dbAction.insertDonor(Dnr);
                FirstName.clear();
                Phone_Number.clear();
                Donate_Times.clear();
                Upazila.clear();
                upazilaCheck.setText("");
                donateCheck.setText("");
                nameChecker.setText("");
                PhoneNumberCheck.setText("");
                Last_Donation.getEditor().clear();
                District.getSelectionModel().clearSelection();
                BloodGroup.getSelectionModel().clearSelection();
            }

        } catch (Exception e) {

        }
    
   
    }

    @FXML
    private void Reset_Button_Action(ActionEvent event) {
                FirstName.clear();
                Phone_Number.clear();
                Donate_Times.clear();
                Upazila.clear();
                upazilaCheck.setText("");
                donateCheck.setText("");
                nameChecker.setText("");
                PhoneNumberCheck.setText("");
                Last_Donation.getEditor().clear();
                District.getSelectionModel().clearSelection();
                BloodGroup.getSelectionModel().clearSelection();
    }

    @FXML
    private void Number_Key_Action(KeyEvent event) {
        PhoneNumberCheck.setText("");
        String Number=Phone_Number.getText();
        for(Donor dnr:DonnorListController.Dnrlist){
            if(dnr.getPhoneNumber().equals(Number)){
            PhoneNumberCheck.setText("This PhoneNumber is Already exists");
            break;
            
            }
        }
    
    
     }

   
    
}
    

