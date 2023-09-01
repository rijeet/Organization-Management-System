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
import java.util.regex.Pattern;
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

/**
 * FXML Controller class
 *
 * @author Mukaffi
 */
public class Add_new_StudentController implements Initializable {

    @FXML
    private TextField Student_FirstName;
    @FXML
    private TextField Student_LastName;
    @FXML
    private ComboBox<String> BloodGroup;
    ObservableList<String> Blood_Groups = FXCollections.observableArrayList("O+", "O-", "A+", "A-", "B+", "B-", "AB+", "AB-");
    @FXML
    private ComboBox<String> Gender;
    ObservableList<String> genderList = FXCollections.observableArrayList("Male", "Female");
    @FXML
    private DatePicker DateOfBirth;
    @FXML
    private TextField Phone_Number;
    @FXML
    private TextField Student_ID;
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
            "Noakhali",
            "Rangamati",
            "Dhaka",
            "Faridpur",
            "Gazipur",
            "Gopalganj ",
            "Jamalpur ",
            "Kishoreganj ",
            "Madaripur ",
            "Manikganj",
            "Munshiganj ",
            "Mymensingh ",
            "Narayanganj ",
            "Narsingdi ",
            "Netrakona ",
            "Rajbari ",
            "Shariatpur ",
            "Sherpur ",
            "Tangail ",
            "Bagerhat ",
            "Chuadanga ",
            "Jessore ",
            "Jhenaidah ",
            "Khulna",
            "Kushtia",
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
    
    @FXML
    private TextField Student_Class;
    @FXML
    private Label fnameWarning;
    @FXML
    private Label lnameWarning;
    @FXML
    private Label upazilaWarning;
    @FXML
    private Label phoneWarning;
    @FXML
    private Label idWarning;
    @FXML
    private Label classWarning;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        BloodGroup.setItems(Blood_Groups);
        District.setItems(districtAll);
        //Upazila.setItems(upazilaAll);
        Gender.setItems(genderList);
    }
    int checker;

    public static boolean isAlpha(String s) {
        return s != null && s.matches("^[a-zA-Z ]*$");
    }

    public static boolean isDigit(String s) {
        return s != null && s.matches("^[0-9]*$");
    }
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
    private void Save_Button_Action(ActionEvent event) throws SQLException {
        //student(String id, String Name, String Blood_group, String Sclass, String District, String Upazila, String Date_Of_Birth, String PhoneNumber, String SchoolName)
        String name = (Student_FirstName.getText() + " " + Student_LastName.getText());
        String fname = Student_FirstName.getText();
        String lname = Student_LastName.getText();
        String id = Student_ID.getText();
        String phn = Phone_Number.getText();

        String gnder = Gender.getValue();
        LocalDate lb = DateOfBirth.getValue();
        // String DateOfBirth= lb.toString();
        String Blood_Group = BloodGroup.getValue();
        String Dis = District.getValue();
        String upzila = Upazila.getText();
        String Class = Student_Class.getText();
        
        checker = 0;

        if (fname.equals("") || lname.equals("") || id.equals("") || phn.equals("") || upzila.equals("") || Class.equals("")) {
            Alert al = new Alert(Alert.AlertType.WARNING);
            al.setTitle("Error");
            al.setContentText("Please Fillup All Information Correctly!");
            al.showAndWait();
        } else {
            try {
                String DateOfBirth = lb.toString();
                if (!isAlpha(fname)) {
                    fnameWarning.setText("Invalid");
                    checker = 1;
                }
                if (!isAlpha(lname)) {
                    lnameWarning.setText("Invalid");
                    checker = 1;
                }
                if (!isAlpha(upzila)) {
                    upazilaWarning.setText("Invalid");
                    checker = 1;
                }
                if (!isDigit(id)) {
                    idWarning.setText("Invalid");
                    checker = 1;
                }
                if (!ValidPhoneNumber(phn)) {
                    phoneWarning.setText("Invalid");
                    checker = 1;
                }
                if (!ValidClass(Class)) {
                    classWarning.setText("Invalid");
                    checker = 1;
                }
                
                if (checker == 1) {
                    throw new Exception();
                }
                student st = new student(id, name, Blood_Group, Class, Dis, upzila, gnder, DateOfBirth, phn);
                //student(String id, String Name, String Blood_group, String District, String Upazila, String Date_Of_Birth, String PhoneNumber)
                System.out.println(st);
                DatabaseAction dbAction = new DatabaseAction();
                dbAction.insertStudent(st);
               
                Upazila.clear();
                Student_ID.clear();
                Phone_Number.clear();
                Student_LastName.clear();
                Student_FirstName.clear();
                District.getSelectionModel().clearSelection();
                Gender.getSelectionModel().clearSelection();
                
                 //DateOfBirth.getEditor().clear();
                
                BloodGroup.getSelectionModel().clearSelection();
                phoneWarning.setText("");
                upazilaWarning.setText("");
                lnameWarning.setText("");
                fnameWarning.setText("");
                idWarning.setText("");
                classWarning.setText("");
                Student_Class.setText("");
            } catch (Exception e) {

            }
        }
    }

    @FXML
    private void Reset_Button_Action(ActionEvent event) {
        Upazila.clear();
        Student_ID.clear();
        Phone_Number.clear();
        Student_LastName.clear();
        Student_FirstName.clear();
        phoneWarning.setText("");
        upazilaWarning.setText("");
        lnameWarning.setText("");
        fnameWarning.setText("");
        idWarning.setText("");
        classWarning.setText("");
        District.getSelectionModel().clearSelection();
        Gender.getSelectionModel().clearSelection();
        BloodGroup.getSelectionModel().clearSelection();
        Student_Class.setText("");
        DateOfBirth.getEditor().clear();
    }

}
