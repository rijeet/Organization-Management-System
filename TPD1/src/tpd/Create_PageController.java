/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpd;

import java.io.IOException;
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

/**
 * FXML Controller class
 *
 * @author Mukaffi
 */
public class Create_PageController implements Initializable {

    @FXML
    private AnchorPane Create_Action;
    @FXML
    private ComboBox<String> District;
    ObservableList<String> district = FXCollections.observableArrayList(
            "Bagerhat",
            "Bandarban",
            "Barisal",
            "Bogra",
            "Bhola",
            "Brahmanbaria",
            "Barguna",
            "Chandpur",
            "Chuadanga",
            "Chittagong",
            "Cox’sBazar",
            "Cumilla",
            "Dhaka",
            "Dinajpur",
            "Faridpur",
            "Feni",
            "Gaibandha",
            "Gazipur",
            "Gopalganj",
            "Habiganj",
            "Jamalpur",
            "Jessore",
            "Jhenaidah",
            "Khulna",
            "Kishoregonj",
            "Kushtia",
            "Lalmonirhat",
            "Mymensingh",
            "Madaripur",
            "Narsingdi",
            "Narayanganj",
            "Pabna",
            "Patuakhali",
            "Rajshahi",
            "Rangpur",
            "Sylhet",
            "Sirajgonj",
            "Tangail",
            "Thakurgaon");

    @FXML
    private ComboBox<String> Blood_Group;
    ObservableList<String> bloodGroup = FXCollections.observableArrayList("O+", "O-", "A+", "A-", "B+", "B-", "AB+", "AB-");
    @FXML
    private TextField First_Name;
    @FXML
    private TextField Phone_number;
    @FXML
    private TextField Last_Name;
    @FXML
    private DatePicker userDateofBirth;
    @FXML
    private TextField username;
    @FXML
    private TextField DonateTimes;
    @FXML
    private Label Username_Check;

    @FXML
    private ComboBox<String> Ques2;
    ObservableList<String> ques = FXCollections.observableArrayList("Yes", "No");
    @FXML
    private Label PhoneNumber_Check1;
    @FXML
    private TextField password;
    @FXML
    private TextField upazila;
    @FXML
    private TextField ques1;
    @FXML
    private TextField ques3;
    @FXML
    private ComboBox<String> AccountType;
    ObservableList<String> accountype = FXCollections.observableArrayList("User", "Doctor");
    @FXML
    private Label warningFirstName;
    @FXML
    private Label warningLastName;
    @FXML
    private Label warningUserNameException;
    @FXML
    private Label warningBloodDonationTime;
    @FXML
    private Label warningValidPassword;
    @FXML
    private Label warningPalidPhonNumber;
    @FXML
    private Label warningUpazila;

    ObservableList<AccountInformation> accountList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Blood_Group.setItems(bloodGroup);
        District.setItems(district);

        Ques2.setItems(ques);
        AccountType.setItems(accountype);

        District.setEditable(true);
        DatabaseAction dbAction1 = new DatabaseAction();
        try {
            accountList = dbAction1.getAllAccountinformation();
        } catch (SQLException ex) {
            Logger.getLogger(Create_PageController.class.getName()).log(Level.SEVERE, null, ex);
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

    public static boolean validatePassword(String PassW) {
        String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";

        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(PassW).matches();
    }

    @FXML
    private void CreateAccount(ActionEvent event) throws SQLException, Exception {

        String Name = First_Name.getText() + " " + Last_Name.getText();
        String Username = username.getText();
        LocalDate lb = userDateofBirth.getValue();

        String district = District.getValue();
        String Upazila = upazila.getText();
        String PhoneNumber = Phone_number.getText();
        String DonationTime = DonateTimes.getText();
        String BloodGroup = Blood_Group.getValue();
        String Password = password.getText();
        String Sequirity_ques1 = ques1.getText();
        String Sequirity_ques2 = Ques2.getValue();
        String Sequirity_ques3 = ques3.getText();
        String accountType = AccountType.getValue();
        DatabaseAction dbAction = new DatabaseAction();

        checker = 0;
        if (Name.equals("") || Upazila.equals("") || PhoneNumber.equals("") || Username.equals("") || district.equals("") || DonationTime.equals("") || Password.equals("") || Sequirity_ques1.equals("") || BloodGroup.equals("") || Sequirity_ques2.equals("") || Sequirity_ques3.equals("") || accountType.equals("")) {
            Alert al = new Alert(Alert.AlertType.WARNING);
            al.setTitle("Error");
            al.setContentText("Please Fillup All Information Correctly!");
            al.showAndWait();
        }

        try {
            String Date_of_Birth = lb.toString();
            String LastDonation = lb.toString();
            if (!isAlpha(Name)) {
                warningFirstName.setText("Invalid Input");
                checker = 1;
            } else {
                warningFirstName.setText("");

            }
            if (!isAlpha(Last_Name.getText())) {
                warningLastName.setText("Invalid Input");
                checker = 1;
            } else {
                warningLastName.setText("");
            }

            if (!ValidPhoneNumber(PhoneNumber)) {
                warningPalidPhonNumber.setText("Invalid PhoneNumber");
                checker = 1;
            } else {
                warningPalidPhonNumber.setText("");

            }
            if (!isDigit(DonationTime)) {
                warningBloodDonationTime.setText("Invalid Input");
                checker = 1;
            } else {

                warningBloodDonationTime.setText("");
            }

            if (!isAlpha(Upazila)) {
                warningUpazila.setText("Invalid Input");
                checker = 1;
            } else {

                warningUpazila.setText("");
            }

            if (!validatePassword(Password)) {
                warningValidPassword.setText("Invalid Password. Example: 134@aBgW");
                //Password must be at least 8 characters,at least one digit,one upper case,one lower case alphabet, one special character which includes (!@#$%&*()-+=^) but can't contain any white space.");
                checker = 1;
            } else {

                warningValidPassword.setText("");
            }
            if (checker == 1) {
                throw new Exception();
            } else if (checker == 0) {
                AccountInformation accountInformation = new AccountInformation(Name, Username, Date_of_Birth, district, Upazila, PhoneNumber, DonationTime, BloodGroup, Password, Sequirity_ques1, Sequirity_ques2, Sequirity_ques3, accountType);
                User user = new User(Username, Password, accountType);

                dbAction.insertAccount(accountInformation);
                dbAction.insertUser(user);

                First_Name.clear();
                Phone_number.clear();
                Last_Name.clear();
                userDateofBirth.getEditor().clear();
                username.clear();
                DonateTimes.clear();
                Ques2.getSelectionModel().clearSelection();
                password.clear();
                upazila.clear();
                ques1.clear();
                ques3.clear();
                AccountType.getSelectionModel().clearSelection();
                District.getSelectionModel().clearSelection();
                Blood_Group.getSelectionModel().clearSelection();

            }

        } catch (Exception e) {

        }

    }

    @FXML
    private void Back_action(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Create_Action.getChildren().setAll(pane);

    }

    @FXML
    private void namekeyAction(KeyEvent event) {
        Username_Check.setText("");
        String Number = username.getText();
        for (AccountInformation accountInformation : accountList) {
            if (accountInformation.getUsername().equals(Number)) {
                Username_Check.setText("This Username is Already exists");
                break;

            }
        }

    }

    @FXML
    private void passcheck(KeyEvent event) {
        String pass = password.getText();
        if (!validatePassword(pass)) {
            warningValidPassword.setText("Atleast One Uppercase,One Number and One special characters & atleast 8 characters");

        } else {
            warningValidPassword.setText("");
        }
    }

    @FXML
    private void Reset_Button_Action(ActionEvent event) {
        First_Name.clear();
        Phone_number.clear();
        Last_Name.clear();
        userDateofBirth.getEditor().clear();
        username.clear();
        DonateTimes.clear();
        Ques2.getSelectionModel().clearSelection();
        password.clear();
        upazila.clear();
        ques1.clear();
        ques3.clear();
        AccountType.getSelectionModel().clearSelection();
        District.getSelectionModel().clearSelection();
        Blood_Group.getSelectionModel().clearSelection();
        warningValidPassword.setText("");
        warningPalidPhonNumber.setText("");
        warningUpazila.setText("");
        warningBloodDonationTime.setText("");
        warningUserNameException.setText("");
        warningLastName.setText("");
        warningFirstName.setText("");

    }
}
