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
public class Add_New_OrphanageController implements Initializable {

    @FXML
    private AnchorPane ADD_Orphange;
    @FXML
    private TextField Name;
    @FXML
    private TextField Vacancy;
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
    private TextField Capacity;
    @FXML
    private Label nameWarning;
    @FXML
    private Label upazilaWarning;
    @FXML
    private Label capacityWarning;
    @FXML
    private Label vacancyWarning;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
    private void Save(ActionEvent event) throws SQLException {
        String name = Name.getText();
        String capacity = Capacity.getText();
        String vacancy = Vacancy.getText();
        String Dis = District.getValue();
        String upzila = Upazila.getText();
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
                    vacancyWarning.setText("Invalid Data Type");
                    checker = 1;
                }
                if (!isDigit(capacity)) {
                    capacityWarning.setText("Invalid Data Type");
                    checker = 1;
                }
                if (checker == 1) {
                    throw new Exception();
                }
                Orphanage_houses or = new Orphanage_houses(name, Dis, upzila, vacancy, capacity);
                System.out.println(or);
                DatabaseAction dbAction = new DatabaseAction();
                dbAction.insertOrphanage(or);
                Name.clear();
                Vacancy.clear();
                Capacity.clear();
                vacancyWarning.setText("");
                capacityWarning.setText("");
                upazilaWarning.setText("");
                nameWarning.setText("");
            } catch (Exception e) {

            }
        }

    }

    @FXML
    private void Reset(ActionEvent event) {
        Name.clear();
        Vacancy.clear();
        Capacity.clear();
        vacancyWarning.setText("");
        capacityWarning.setText("");
        upazilaWarning.setText("");
        nameWarning.setText("");
    }

}
