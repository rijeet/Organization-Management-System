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
public class Show_ALL_OrphanController implements Initializable {

    @FXML
    private TableColumn<Orphanage, String> IDcol;
    @FXML
    private TableColumn<Orphanage, String> Namcol;
    @FXML
    private TableColumn<Orphanage, String> BloodCol;
    @FXML
    private TableColumn<Orphanage, String> Gencol;
    @FXML
    private TableColumn<Orphanage, String> DisCol;
    @FXML
    private TableColumn<Orphanage, String> UpazilaCol;
    @FXML
    private TableColumn<Orphanage, String> DOBcol;
    @FXML
    private TableView<Orphanage> OrphaneTable;

    static ObservableList<Orphanage> orphanList = FXCollections.observableArrayList();
    @FXML
    private ComboBox<String> ColumnType; //ID Name  BloodGroup Gender District Upazila DateofBirth
    ObservableList<String> columntpye = FXCollections.observableArrayList("ID", "Name", "BloodGroup", "Gender", "District", "Upazila", "DateofBirth");

    @FXML
    private TextField Value;
    @FXML
    private Button Search;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ColumnType.setItems(columntpye);
        OrphaneTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        DatabaseAction dbAction = new DatabaseAction();
        try {
            Show_ALL_OrphanController.orphanList = dbAction.getAllOrphan();

        } catch (SQLException ex) {
            Logger.getLogger(Show_ALL_OrphanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        IDcol.setCellValueFactory(new PropertyValueFactory<Orphanage, String>("id"));
        Namcol.setCellValueFactory(new PropertyValueFactory<Orphanage, String>("Name"));
        BloodCol.setCellValueFactory(new PropertyValueFactory<Orphanage, String>("Blood_group"));
        Gencol.setCellValueFactory(new PropertyValueFactory<Orphanage, String>("Gender"));
        DisCol.setCellValueFactory(new PropertyValueFactory<Orphanage, String>("District"));
        UpazilaCol.setCellValueFactory(new PropertyValueFactory<Orphanage, String>("Upazila"));
        DOBcol.setCellValueFactory(new PropertyValueFactory<Orphanage, String>("Date_of_Birth"));
        OrphaneTable.setItems(orphanList);
    }

    @FXML
    private void Delete(ActionEvent event) throws SQLException {
        ObservableList<Orphanage> selectedOrphan = FXCollections.observableArrayList();
        selectedOrphan = OrphaneTable.getSelectionModel().getSelectedItems();
        DatabaseAction dbAction = new DatabaseAction();
        dbAction.deleteOrphan(selectedOrphan);
        orphanList.removeAll(selectedOrphan);

    }

    @FXML
    private void Search_Action(ActionEvent event) throws SQLException {
        String Type = ColumnType.getValue();
        String value = Value.getText();
        ObservableList<Orphanage> selectedOrphan = FXCollections.observableArrayList();
        DatabaseAction dbAction = new DatabaseAction();
        selectedOrphan = dbAction.SearchOrphan(Type, value);

        OrphaneTable.setItems(selectedOrphan);

    }

}
