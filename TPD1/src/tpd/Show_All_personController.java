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
public class Show_All_personController implements Initializable {

    @FXML
    private AnchorPane ALL_person;
    @FXML
    private TableView<Oldagehome> PersonTable;
    @FXML
    private TableColumn<Oldagehome, String> ID_col;
    @FXML
    private TableColumn<Oldagehome, String> NameCol;
    @FXML
    private TableColumn<Oldagehome, String> AgeCol;
    @FXML
    private TableColumn<Oldagehome, String> GenderCol;
    @FXML
    private TableColumn<Oldagehome, String> DisCol;
    @FXML
    private TableColumn<Oldagehome, String> UpazilaCol;
    @FXML
    private TableColumn<Oldagehome, String> PhoneNumberCOl;
    @FXML
    private TableColumn<Oldagehome, String> BloodGroup_col;
    static ObservableList<Oldagehome> personList = FXCollections.observableArrayList();
    @FXML
    private ComboBox<String> ColumnType; //ID Name District Upazila Age BloodGroup Number 
    ObservableList<String> columntpye = FXCollections.observableArrayList("ID", "Name", "BloodGroup", "District", "Upazila", "Age", "Number");

    @FXML
    private TextField Value;
    @FXML
    private Button Search;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ColumnType.setItems(columntpye);
        PersonTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        DatabaseAction dbAction = new DatabaseAction();
        try {
            Show_All_personController.personList = dbAction.getAllOldAgePerson();
            for (Oldagehome old : Show_All_personController.personList) {
                System.out.println(old);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Show_All_OrphanageController.class.getName()).log(Level.SEVERE, null, ex);
        }

        ID_col.setCellValueFactory(new PropertyValueFactory<Oldagehome, String>("id"));
        NameCol.setCellValueFactory(new PropertyValueFactory<Oldagehome, String>("Name"));
        AgeCol.setCellValueFactory(new PropertyValueFactory<Oldagehome, String>("age"));
        GenderCol.setCellValueFactory(new PropertyValueFactory<Oldagehome, String>("Gender"));
        DisCol.setCellValueFactory(new PropertyValueFactory<Oldagehome, String>("District"));
        UpazilaCol.setCellValueFactory(new PropertyValueFactory<Oldagehome, String>("Upazila"));
        PhoneNumberCOl.setCellValueFactory(new PropertyValueFactory<Oldagehome, String>("PhoneNumber"));
        BloodGroup_col.setCellValueFactory(new PropertyValueFactory<Oldagehome, String>("Blood_group"));

        PersonTable.setItems(personList);
    }

    @FXML
    private void Delete(ActionEvent event) throws SQLException {
        ObservableList<Oldagehome> selectedperson = FXCollections.observableArrayList();
        selectedperson = PersonTable.getSelectionModel().getSelectedItems();
        DatabaseAction dbAction = new DatabaseAction();
        dbAction.deleteperson(selectedperson);
        personList.removeAll(selectedperson);

    }

    @FXML
    private void Search_Action(ActionEvent event) throws SQLException {
        String Type = ColumnType.getValue();
        String value = Value.getText();
        ObservableList<Oldagehome> selectedperson = FXCollections.observableArrayList();
        DatabaseAction dbAction = new DatabaseAction();
        selectedperson = dbAction.SearchPerson(Type, value);

        PersonTable.setItems(selectedperson);

    }

}
