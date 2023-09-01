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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Mukaffi
 */
public class Add_New_OrphanController implements Initializable {

    @FXML
    private TextField FirstName; 
    @FXML 
    private TextField LastName;
    @FXML
    private TextField ID;
    @FXML
    private ComboBox<String> BloodGroup;
    @FXML
    private ComboBox<String> Gender;
    ObservableList<String> genderList =FXCollections.observableArrayList("Male","Female");
    @FXML
    private DatePicker DateOfBirth;
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
    private TextField Upazila;
    ObservableList<String> Blood_Groups = FXCollections.observableArrayList("O+","O-","A+","A-","B+","B-","AB+","AB-");
    @FXML
    private AnchorPane Add_New_Orphan;
    @FXML
    private Label fnameWarning;
    @FXML
    private Label lnameWarning;
    @FXML
    private Label IdWarning;
    @FXML
    private Label upazilaWarning;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       BloodGroup.setItems(Blood_Groups);
       Gender.setItems(genderList);
       District.setItems(districtAll);
       
    }  
     public static boolean isAlpha(String s) {
        return s != null && s.matches("^[a-zA-Z ]*$");
    }

    public static boolean isDigit(String s) {
        return s != null && s.matches("^[0-9]*$");
    }
    int checker;

    @FXML
    private void Save_Button_Action(ActionEvent event) throws SQLException {
           String name = (FirstName.getText() + " " + LastName.getText());
        String fname = FirstName.getText();
        String lname = LastName.getText();
        String id = ID.getText();
        String gnder = Gender.getValue();

        LocalDate lb = DateOfBirth.getValue();
       
        String Blood_Group = BloodGroup.getValue();
        String Dis = District.getValue();
        String upzila = Upazila.getText();
        checker = 0;
        try {
            String Date_of_Birth = lb.toString();
            if (fname.equals("") || lname.equals("") || upzila.equals("") || id.equals("")) {
                Alert al = new Alert(Alert.AlertType.WARNING);
                al.setTitle("Error");
                al.setContentText("Please Fillup All Information Correctly!");
                al.showAndWait();
            } else {
                if (!isAlpha(fname)) {
                    fnameWarning.setText("Invaid First Name");
                    checker = 1;
                }
                if (!isAlpha(lname)) {
                    lnameWarning.setText("Invalid Last name");
                    checker = 1;
                }
                if (!isAlpha(upzila)) {
                    upazilaWarning.setText("Invaild upazila");
                    checker = 1;
                }
                if (!isDigit(id)) {
                    IdWarning.setText("Invalid ID ");
                    checker = 1;
                }

                if (checker == 1) {
                    throw new Exception();
                }

                //Orphanage(String id, String Name, String Date_of_Birth, String Blood_group, String Gender, String District, String Upazila)
                Orphanage orphan = new Orphanage(id, name, Date_of_Birth, Blood_Group, gnder, Dis, upzila);
                System.out.println(orphan);
                //FirstName LastName ID BloodGroup Gender  DateOfBirth District Upazila

                DatabaseAction dbAction = new DatabaseAction();
                dbAction.inserOrphan(orphan);
                FirstName.clear();
                LastName.clear();
                ID.clear();
                DateOfBirth.getEditor().clear();
                District.getSelectionModel().clearSelection();
                BloodGroup.getSelectionModel().clearSelection();
                Gender.getSelectionModel().clearSelection();
                fnameWarning.setText("");
                lnameWarning.setText("");
                IdWarning.setText("");
                upazilaWarning.setText("");
                Upazila.setText("");
                
                /*FirstName.clear();
                Phone_Number.clear();
                Donate_Times.clear();
                Upazila.clear();
                upazilaCheck.setText("");
                donateCheck.setText("");
                nameChecker.setText("");
                PhoneNumberCheck.setText("");
                Last_Donation.getEditor().clear();
                District.getSelectionModel().clearSelection();
                BloodGroup.getSelectionModel().clearSelection();*/

            }
        } catch (Exception e) {

        }

    
    }

    @FXML
    private void Reset_Button_Action(ActionEvent event) {
    }
    
}
