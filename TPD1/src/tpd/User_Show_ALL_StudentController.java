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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Mukaffi
 */
public class User_Show_ALL_StudentController implements Initializable {

    @FXML
    private AnchorPane Student_LIst_ANCHR;
    @FXML
    private TableView<student> Student_Table;
    @FXML
    private TableColumn<student, String> ID_col;
    @FXML
    private TableColumn<student, String> Name_col;
    @FXML
    private TableColumn<student, String> Blood_groupCol;
    @FXML
    private TableColumn<student, String> DistrictCol;
    @FXML
    private TableColumn<student, String> UpazilaCol;
    @FXML
    private TableColumn<student, String> GenderCol;
    @FXML
    private TableColumn<student, String> PhoneNumberCol;
    @FXML
    private TableColumn<student, String> DAteOfBirthCol;
    @FXML
    private TableColumn<student, String> Class;

    static ObservableList<student> studentList = FXCollections.observableArrayList();
    @FXML
    private ComboBox<String> ColumnType;
    ObservableList<String> columntpye = FXCollections.observableArrayList("ID", "Name", "BloodGroup", "Class", "District", "Upazila", "Gender", "DateofBirth", "Number");
    @FXML
    private TextField Value;
    @FXML
    private Button Search;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ColumnType.setItems(columntpye);
        User_Show_ALL_StudentController.studentList.clear();
        Student_Table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        DatabaseAction dbAction = new DatabaseAction();
        try {
            User_Show_ALL_StudentController.studentList = dbAction.getAllStudent();
        } catch (SQLException ex) {
            Logger.getLogger(User_Show_ALL_StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }

        ID_col.setCellValueFactory(new PropertyValueFactory<student, String>("id"));
        Name_col.setCellValueFactory(new PropertyValueFactory<student, String>("Name"));
        Blood_groupCol.setCellValueFactory(new PropertyValueFactory<student, String>("Blood_group"));
        DistrictCol.setCellValueFactory(new PropertyValueFactory<student, String>("District"));
        UpazilaCol.setCellValueFactory(new PropertyValueFactory<student, String>("Upazila"));
        GenderCol.setCellValueFactory(new PropertyValueFactory<student, String>("gender"));
        PhoneNumberCol.setCellValueFactory(new PropertyValueFactory<student, String>("PhoneNumber"));
        DAteOfBirthCol.setCellValueFactory(new PropertyValueFactory<student, String>("Date_Of_Birth"));
        Class.setCellValueFactory(new PropertyValueFactory<student, String>("Sclass"));
        Student_Table.setItems(studentList);

    }

    

    @FXML
    private void Search_Action(ActionEvent event) throws SQLException {
        String Type = ColumnType.getValue();
        String value = Value.getText();
        ObservableList<student> selectedStudent = FXCollections.observableArrayList();
        DatabaseAction dbAction = new DatabaseAction();
        selectedStudent = dbAction.SearchStudent(Type, value);

        Student_Table.setItems(selectedStudent);
    }

}
