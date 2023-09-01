/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpd;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Mukaffi
 */
public class Add_NewSchoolController implements Initializable {

    @FXML
    private TextField School_Name;
    @FXML
    private TextField Student_vacancy;
    @FXML
    private ComboBox<String> School_District;
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
    private TextField School_Student_Capacity;
    @FXML
    private TextField School_upazila;
    @FXML
    private AnchorPane Add_NewSchool;
    @FXML
    private Label nameWarning;
    @FXML
    private Label upazilaWarning;
    @FXML
    private Label capacityWarning;
    @FXML
    private Label vacancyWarning;
   
    int checker;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
        School_District.setItems(districtAll);
       
    } 
    public static boolean isAlpha(String s) {
        return s != null && s.matches("^[a-zA-Z ]*$");
    }

    public static boolean isDigit(String s) {
        return s != null && s.matches("^[0-9]*$");
    }

    @FXML
    private void Save_Button_Action(ActionEvent event) throws SQLException {
        String name = School_Name.getText();
        String capacity = School_Student_Capacity.getText();
        String vacancy = Student_vacancy.getText();
        String Dis = School_District.getValue();
        String upzila = School_upazila.getText();
        checker = 0;
        if (name.equals("") || upzila.equals("") || vacancy.equals("") || capacity.equals("")) {
            Alert al = new Alert(Alert.AlertType.WARNING);
            al.setTitle("Error");
            al.setContentText("Please Fillup All Information Correctly!");
            al.showAndWait();
        } else {
            try {
                if (!isAlpha(name)) {
                    nameWarning.setText("Invalid Name");
                    checker = 1;
                }
                if (!isAlpha(upzila)) {
                    upazilaWarning.setText("Invalid Upazila");
                    checker = 1;
                }
                if (!isDigit(vacancy)) {
                    vacancyWarning.setText("Invalid DataType");
                    checker = 1;
                }
                if (!isDigit(capacity)) {
                    capacityWarning.setText("Invalid DataType");
                    checker = 1;
                }
                if (checker == 1) {
                    throw new Exception();
                }

                School Sch = new School(name, Dis, upzila, vacancy, capacity);
                System.out.println(Sch);
                DatabaseAction dbAction = new DatabaseAction();
                dbAction.insertSchool(Sch);

            } catch (Exception e) {

            }   School_Name.clear();
                Student_vacancy.clear();
                School_Student_Capacity.clear();
                vacancyWarning.setText("");
                capacityWarning.setText("");
                upazilaWarning.setText("");
                nameWarning.setText("");
        }
    
    }

    @FXML
    private void Reset_Button_Action(ActionEvent event) {
   
    }
    
}
