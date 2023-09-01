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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Mukaffi
 */
public class Add_New_PersonController implements Initializable {

    @FXML
    private AnchorPane New_person;
    @FXML
    private TextField FirstName;
    @FXML
    private TextField LastName;
    @FXML
    private ComboBox<String> BloodGroup;
    @FXML
    private ComboBox<String> Gender;
    ObservableList<String> genderList = FXCollections.observableArrayList("Male", "Female");
    ObservableList<String> Blood_Groups = FXCollections.observableArrayList("O+", "O-", "A+", "A-", "B+", "B-", "AB+", "AB-");
    @FXML
    private TextField PhoneNumber;
    @FXML
    private TextField Age;
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
    private TextField ID;
    @FXML
    private Label fnameWarning;
    @FXML
    private Label lnameWarning;
    @FXML
    private Label ageWarning;
    @FXML
    private Label idWarning;
    @FXML
    private Label phoneWarning;
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
    public static boolean ValidPhoneNumber(String s) {
        return Pattern.matches("^[0-9]{11}", s);
    }
    int checker;

    @FXML
    private void Save(ActionEvent event) throws SQLException {
        String name = (FirstName.getText() + " " + LastName.getText());
        String fname = FirstName.getText();
        String lname = LastName.getText();
        String id = ID.getText();
        String phn = PhoneNumber.getText();
        String age = Age.getText();
        String gnder = Gender.getValue();

        //LocalDate lb= DateOfBirth.getValue();
        //  String Date_of_Birth= lb.toString();
        String Blood_Group = BloodGroup.getValue();
        String Dis = District.getValue();
        String upzila = Upazila.getText();
        checker = 0;

        if (fname.equals("") || lname.equals("") || id.equals("") || phn.equals("") || age.equals("") || upzila.equals("")) {
            Alert al = new Alert(Alert.AlertType.WARNING);
            al.setTitle("Error");
            al.setContentText("Please Fillup All Information Correctly!");
            al.showAndWait();
        } else {
            try {
                if (!isAlpha(fname)) {
                    fnameWarning.setText("Invalid Name");
                    checker = 1;
                }
                if (!isAlpha(lname)) {
                    lnameWarning.setText("Invalid Name");
                    checker = 1;
                }
                if (!isDigit(id)) {
                    idWarning.setText("Invalid Id");
                    checker = 1;
                }
                if (!ValidPhoneNumber(phn)) {
                    phoneWarning.setText("Invalid Number");
                    checker = 1;
                }
                if (!isDigit(age)) {
                    ageWarning.setText("Invalid Age");
                    checker = 1;
                }
                if (!isAlpha(upzila)) {
                    upazilaWarning.setText("Invalid Upazila");
                    checker = 1;
                }
                if (checker == 1) {
                    throw new Exception();
                }

                //Oldagehome(String id, String Name, String age, String Gender, String District, String Upazila, String PhoneNumber, String Blood_group)
                Oldagehome old = new Oldagehome(id, name, age, gnder, Dis, upzila, phn, Blood_Group);

                System.out.println(old);
                DatabaseAction dbAction = new DatabaseAction();
                dbAction.insertPerson(old);
                FirstName.clear();
                LastName.clear();
                ID.clear();
                Age.clear();
                PhoneNumber.clear();
                BloodGroup.setItems(Blood_Groups);
                Gender.setItems(genderList);
                fnameWarning.setText("");
                lnameWarning.setText("");
                upazilaWarning.setText("");
                idWarning.setText("");
                ageWarning.setText("");
                phoneWarning.setText("");

            } catch (Exception e) {

            }
        }

    }

    @FXML
    private void Reset(ActionEvent event) {
        FirstName.clear();
        LastName.clear();
        ID.clear();
        Age.clear();
        PhoneNumber.clear();
        BloodGroup.setItems(Blood_Groups);
        Gender.setItems(genderList);
        fnameWarning.setText("");
        lnameWarning.setText("");
        upazilaWarning.setText("");
        idWarning.setText("");
        ageWarning.setText("");
        phoneWarning.setText("");
    }

}
