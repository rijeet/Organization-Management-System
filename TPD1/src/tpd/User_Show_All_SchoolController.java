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
import static tpd.Show_ALL_OrphanController.orphanList;

public class User_Show_All_SchoolController implements Initializable {

    @FXML
    private AnchorPane All_schoolAnchr;
    @FXML
    private TableView<School> School_Table;
    @FXML
    private TableColumn<School, String> School_name;
    @FXML
    private TableColumn<School, String> School_zila;
    @FXML
    private TableColumn<School, String> School_upazila;
    @FXML
    private TableColumn<School, String> School_capacity;
    @FXML
    private TableColumn<School, String> School_vacancy;

    static ObservableList<School> schoolList = FXCollections.observableArrayList();
    @FXML
    private ComboBox<String> ColumnType;
    ObservableList<String> columntpye = FXCollections.observableArrayList("Name", "District", "Upazila", "Capacity", "Vaccancy");
    @FXML
    private TextField Value;
    @FXML
    private Button Search;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ColumnType.setItems(columntpye);
        School_Table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        DatabaseAction dbAction = new DatabaseAction();
        try {
            User_Show_All_SchoolController.schoolList = dbAction.getAllSchool();
        } catch (SQLException ex) {
            Logger.getLogger(User_Show_All_SchoolController.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (School old : User_Show_All_SchoolController.schoolList) {
            System.out.println(old);

        }

        School_name.setCellValueFactory(new PropertyValueFactory<School, String>("Name"));
        School_zila.setCellValueFactory(new PropertyValueFactory<School, String>("District"));
        School_upazila.setCellValueFactory(new PropertyValueFactory<School, String>("Upazila"));
        School_capacity.setCellValueFactory(new PropertyValueFactory<School, String>("Capacity"));
        School_vacancy.setCellValueFactory(new PropertyValueFactory<School, String>("Vacancy"));
        School_Table.setItems(schoolList);

    }

   

    @FXML
    private void Search_Action(ActionEvent event) throws SQLException {
        String Type = ColumnType.getValue();
        String value = Value.getText();
        ObservableList<School> selectedschool = FXCollections.observableArrayList();
        DatabaseAction dbAction = new DatabaseAction();
        selectedschool = dbAction.SearchSchool(Type, value);

        School_Table.setItems(selectedschool);

    }

}
