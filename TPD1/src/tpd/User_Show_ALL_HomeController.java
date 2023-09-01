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
public class User_Show_ALL_HomeController implements Initializable {
    
    @FXML
    private TableColumn<OldAgeHome_Houses, String> NamCol;
    @FXML
    private TableColumn<OldAgeHome_Houses, String> DisCol;
    @FXML
    private TableColumn<OldAgeHome_Houses, String> UpazilaCOl;
    @FXML
    private TableColumn<OldAgeHome_Houses, String> CapacityCol;
    @FXML
    private TableColumn<OldAgeHome_Houses, String> VacancyCOl;
    @FXML
    private TableView<OldAgeHome_Houses> HomeTable;
    
    static ObservableList<OldAgeHome_Houses> HomeList = FXCollections.observableArrayList();
    @FXML
    private ComboBox<String> ColumnType;
    ObservableList<String> columntpye = FXCollections.observableArrayList("Name","District","Upazila","Capacity","Vaccancy"); 
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
        
        HomeTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        DatabaseAction dbAction = new DatabaseAction();
        
        try {
            User_Show_ALL_HomeController.HomeList = dbAction.getAllOldAgeHome();
        } catch (SQLException ex) {
            Logger.getLogger(User_Show_ALL_HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (OldAgeHome_Houses old : User_Show_ALL_HomeController.HomeList) {
            System.out.println(old);
            
        }
        NamCol.setCellValueFactory(new PropertyValueFactory<OldAgeHome_Houses, String>("Name"));
        DisCol.setCellValueFactory(new PropertyValueFactory<OldAgeHome_Houses, String>("District"));
        UpazilaCOl.setCellValueFactory(new PropertyValueFactory<OldAgeHome_Houses, String>("Upazila"));
        CapacityCol.setCellValueFactory(new PropertyValueFactory<OldAgeHome_Houses, String>("Capacity"));
        VacancyCOl.setCellValueFactory(new PropertyValueFactory<OldAgeHome_Houses, String>("Vacancy"));
        
        HomeTable.setItems(HomeList);
        
    }    
    
    

    @FXML
    private void Search_Action(ActionEvent event) throws SQLException {
   String Type=ColumnType.getValue();
   String value=Value.getText();
   ObservableList<OldAgeHome_Houses> selectedHomes=FXCollections.observableArrayList();
    DatabaseAction dbAction=new DatabaseAction();
       selectedHomes  = dbAction.searchHomes(Type, value);
       
       
       HomeTable.setItems(selectedHomes);
    
    }
    
}
