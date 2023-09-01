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

/**
 * FXML Controller class
 *
 * @author Mukaffi
 */
public class User_Show_All_OrphanageController implements Initializable {

    @FXML
    private TableColumn<Orphanage_houses, String> Namcol;
    @FXML
    private TableColumn<Orphanage_houses, String> Discol;
    @FXML
    private TableColumn<Orphanage_houses, String> Upazilacol;
    @FXML
    private TableColumn<Orphanage_houses, String> CapacityCol;
    @FXML
    private TableColumn<Orphanage_houses, String> VacancyCol;
    @FXML
    private TableView<Orphanage_houses> OrphanageTable;
    static ObservableList<Orphanage_houses> orphanageList = FXCollections.observableArrayList();
    @FXML
    private ComboBox<String> ColumnType;
    ObservableList<String> columntpye = FXCollections.observableArrayList("Name", "District", "Upazila", "Capacity", "Vaccancy");
    @FXML
    private TextField Value;
    @FXML
    private Button Search;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ColumnType.setItems(columntpye);
        OrphanageTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        DatabaseAction dbAction = new DatabaseAction();

        try {
            User_Show_All_OrphanageController.orphanageList = dbAction.getAllOrphanage();
            for (Orphanage_houses orphan : User_Show_All_OrphanageController.orphanageList) {
                System.out.println(orphan);
            }
        } catch (SQLException ex) {
            Logger.getLogger(User_Show_All_OrphanageController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Namcol.setCellValueFactory(new PropertyValueFactory<Orphanage_houses, String>("Name"));
        Discol.setCellValueFactory(new PropertyValueFactory<Orphanage_houses, String>("District"));
        Upazilacol.setCellValueFactory(new PropertyValueFactory<Orphanage_houses, String>("Upazila"));
        CapacityCol.setCellValueFactory(new PropertyValueFactory<Orphanage_houses, String>("Capacity"));
        VacancyCol.setCellValueFactory(new PropertyValueFactory<Orphanage_houses, String>("Vacancy"));
        OrphanageTable.setItems(orphanageList);

        /*String Name;
    String District;
    String Upazila;
    String Vacancy;
    String Capacity;*/
    }

   

    @FXML
    private void Search_Action(ActionEvent event) throws SQLException {
        String Type = ColumnType.getValue();
        String value = Value.getText();
        ObservableList<Orphanage_houses> selectedHomes = FXCollections.observableArrayList();
        DatabaseAction dbAction = new DatabaseAction();
        selectedHomes = dbAction.SearchOrphanage(Type, value);

        OrphanageTable.setItems(selectedHomes);

    }

}
