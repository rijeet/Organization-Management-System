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
import javafx.scene.control.ComboBox;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import static tpd.Show_All_ScholarShip_StudentController.scholarshipList;


public class ShowAll_Apply_ScholarshipController implements Initializable {

    @FXML
    private AnchorPane Show_ALL_SCHOLAR_List;
    @FXML
    private TableView<SchoolarShip_Student> ScolarshipTable;
    @FXML
    private TableColumn<SchoolarShip_Student, String> NameCol;
    @FXML
    private TableColumn<SchoolarShip_Student, String> ClassCol;
    @FXML
    private TableColumn<SchoolarShip_Student, String> Scholarship_Col;
    @FXML
    private TableColumn<SchoolarShip_Student, String> GPA_Col;
    @FXML
    private TableColumn<SchoolarShip_Student, String> email_col;
    @FXML
    private TableColumn<SchoolarShip_Student, String> number_col;
    @FXML
    private TextField input;
    @FXML
    private ComboBox<String> comType;
    //private ComboBox<String> comType; //Name ScholarshipType  Class Previous_Result Email Number
    ObservableList<String> columntpye = FXCollections.observableArrayList("Name", "ScholarshipType", "Class", "Previous_Result", "Email", "Number");

    static ObservableList<SchoolarShip_Student> scholarshipList = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comType.setItems(columntpye);
        scholarshipList.clear();
        ScolarshipTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        // ScolarshipTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        DatabaseAction dbAction = new DatabaseAction();
        try {
            scholarshipList = dbAction.getAllApplyScholarship();
        } catch (SQLException ex) {
            Logger.getLogger(Show_All_ScholarShip_StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }

        NameCol.setCellValueFactory(new PropertyValueFactory<SchoolarShip_Student, String>("Name"));
        ClassCol.setCellValueFactory(new PropertyValueFactory<SchoolarShip_Student, String>("StudentClass"));
        Scholarship_Col.setCellValueFactory(new PropertyValueFactory<SchoolarShip_Student, String>("ScholarShip_Type"));
        GPA_Col.setCellValueFactory(new PropertyValueFactory<SchoolarShip_Student, String>("GPA"));
        email_col.setCellValueFactory(new PropertyValueFactory<SchoolarShip_Student, String>("email"));
        number_col.setCellValueFactory(new PropertyValueFactory<SchoolarShip_Student, String>("PhoneNumber"));

        ScolarshipTable.setItems(scholarshipList);
    }


    @FXML
    private void Search_Action(ActionEvent event) throws SQLException {
        String Type = comType.getValue();
        String value = input.getText();
        ObservableList<SchoolarShip_Student> selectedperson = FXCollections.observableArrayList();
        DatabaseAction dbAction = new DatabaseAction();
        selectedperson = dbAction.SearchapplyScholarship(Type, value);

        ScolarshipTable.setItems(selectedperson);
    }

    @FXML
    private void add_scholarship(ActionEvent event) throws SQLException {
     ObservableList<SchoolarShip_Student> selectedStudent = FXCollections.observableArrayList();
        selectedStudent = ScolarshipTable.getSelectionModel().getSelectedItems();
        DatabaseAction dbAction = new DatabaseAction();
        for(SchoolarShip_Student std :selectedStudent){
        dbAction.insertScholarshipStudent(std);
        }
        dbAction.deleteApplyScholarship(selectedStudent);
        scholarshipList.removeAll(selectedStudent);
    
    }

}
