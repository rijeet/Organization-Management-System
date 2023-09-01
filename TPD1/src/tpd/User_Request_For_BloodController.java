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
import javafx.scene.layout.AnchorPane;
import javafx.collections.FXCollections;
import javafx.scene.control.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.regex.Pattern;
import javafx.collections.*;
import javafx.fxml.*;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class User_Request_For_BloodController implements Initializable {

    @FXML
    private AnchorPane Request_For_Blood;

    @FXML
    public ComboBox<String> blood_group;
    ObservableList<String> Blood_Group = FXCollections.observableArrayList("O+", "O-", "A+", "A-", "B+", "B-", "AB+", "AB-");
    @FXML
    public ComboBox<String> district;
    ObservableList<String> District = FXCollections.observableArrayList(
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
    private Button Request;
    @FXML
    private ImageView ImageView;
    @FXML
    private TextField upzila;
    @FXML
    private TextField FirstName;
    @FXML
    private TextField LastName;
    @FXML
    private TextField PhoneNumber;
    @FXML
    private TextArea Information;
    @FXML
    private Label firstNameWarning;
    @FXML
    private Label lastNameWarning;
    @FXML
    private Label numberCheack;
    @FXML
    private Label upazilaCheck;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        blood_group.setItems(Blood_Group);
        district.setItems(District);
        //upazila.setItems(Upazila);
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
    private void Request_action(ActionEvent event) throws IOException, SQLException, Exception {
        String patientName = (FirstName.getText()+ " " + LastName.getText());
        String Number = PhoneNumber.getText();
        String BloodGroup = blood_group.getValue();
        String Dis = district.getValue();
        String Upazila = upzila.getText();
        String othersInformation = Information.getText();
       
         checker = 0;
        if (patientName.equals("") || Upazila.equals("") || Number.equals("")|| Dis.equals("")|| othersInformation.equals("")) {
            Alert al = new Alert(Alert.AlertType.WARNING);
            al.setTitle("Error");
            al.setContentText("Please Fillup All Information Correctly!");
            al.showAndWait();
        }
        try {
           
            if (!isAlpha(patientName)) {
                firstNameWarning.setText("Invalid Input");
                checker = 1;
            }else {
                firstNameWarning.setText("");
            
            }
            if (!isAlpha(Upazila)) {
                upazilaCheck.setText("Invalid Input");
                checker = 1;
            }else 
            {    upazilaCheck.setText("");       }
            
            if (!ValidPhoneNumber(Number)) {
                numberCheack.setText("Invalid Input");
                checker = 1;
            }else {
            numberCheack.setText("");
            
            }
            if (!isAlpha(LastName.getText())) {
                lastNameWarning.setText("Invalid Input");
                checker = 1;
            }else {
            
            lastNameWarning.setText("");
            }

            if (checker == 1) {
                throw new Exception();
            }
        
        else if (checker == 0) {
        RequestBlood rb = new RequestBlood(patientName, Number, BloodGroup, Dis, Upazila, othersInformation);
        DatabaseAction dbAction = new DatabaseAction();
        dbAction.inserRequest(rb);

        FirstName.clear();
        LastName.clear();
        PhoneNumber.clear();
        blood_group.getSelectionModel().clearSelection();
        district.getSelectionModel().clearSelection();
        upzila.clear();
        Information.clear();
 }

        } catch (Exception e) {

        }
    }

    @FXML
    private void Back_action(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("User_BloodBank.fxml"));
        Request_For_Blood.getChildren().setAll(pane);
    }

    @FXML
    private void Logout_Action(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Request_For_Blood.getChildren().setAll(pane);
    }

    @FXML
    private void Blood_bank_action(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("User_BloodBank.fxml"));
        Request_For_Blood.getChildren().setAll(pane);
    }

    @FXML
    private void health_action(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("User_Health.fxml"));
        Request_For_Blood.getChildren().setAll(pane);
    }

    @FXML
    private void Online_consult_action(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("User_onlineConsult.fxml"));
        Request_For_Blood.getChildren().setAll(pane);
    }

    @FXML
    private void Blood_request_action(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("User_Request_For_Blood.fxml"));
        Request_For_Blood.getChildren().setAll(pane);
    }

    @FXML
    private void Donor_list_action(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("User_All_donor.fxml"));
        Request_For_Blood.getChildren().setAll(pane);
    }

    @FXML
    private void Education_action(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("User_Education.fxml"));
        Request_For_Blood.getChildren().setAll(pane);
    }

    @FXML
    private void school_action(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("User_School_manageMent.fxml"));
        Request_For_Blood.getChildren().setAll(pane);
    }

    @FXML
    private void scholarship_action(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("User_ScholarShip_Management.fxml"));
        Request_For_Blood.getChildren().setAll(pane);
    }

    @FXML
    private void Food_cloths_action(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("User_Food_cloths.fxml"));
        Request_For_Blood.getChildren().setAll(pane);
    }

    @FXML
    private void shelter_action(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("User_Shelter.fxml"));
        Request_For_Blood.getChildren().setAll(pane);
    }

    @FXML
    private void Orphanage_action(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("User_Orphanage_Management.fxml"));
        Request_For_Blood.getChildren().setAll(pane);
    }

    @FXML
    private void Old_Age_home_action(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("User_Old_Age_home_Management.fxml"));
        Request_For_Blood.getChildren().setAll(pane);
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
