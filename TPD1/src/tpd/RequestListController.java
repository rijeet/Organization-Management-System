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


public class RequestListController implements Initializable {

    @FXML
    private TableColumn<RequestBlood, String> Namecol;
    @FXML
    private TableColumn<RequestBlood, String> NumberCol;
    @FXML
    private TableColumn<RequestBlood, String> BloodCol;
    @FXML
    private TableColumn<RequestBlood, String> DistrictCol;
    @FXML
    private TableColumn<RequestBlood, String> UpazilaCOl;
    @FXML
    private TableColumn<RequestBlood, String>OthersInfoCol;
    @FXML
    private TextField Value;
    @FXML
    private ComboBox<String> Type;
    @FXML
    private Button Search;
    @FXML
    private Button Donate;
    @FXML
    private TableView<RequestBlood> RequestTable;
     static ObservableList<RequestBlood> reqlist=FXCollections.observableArrayList();

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      //othersInformation Upazila District BloodGroup Number Name
      /*String patientName;
    String Number;
    String BloodGroup;
    String District;
    String Upazila;
    String othersInformation;*/
      RequestTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
       DatabaseAction dbAction =new DatabaseAction();
        try {
            reqlist=dbAction.GetAllRequest();
            
        } catch (SQLException ex) {
            Logger.getLogger(RequestListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Namecol.setCellValueFactory(new PropertyValueFactory<RequestBlood,String>("patientName")); 
        NumberCol.setCellValueFactory(new PropertyValueFactory<RequestBlood,String>("Number")); 
        BloodCol.setCellValueFactory(new PropertyValueFactory<RequestBlood,String>("BloodGroup")); 
        DistrictCol.setCellValueFactory(new PropertyValueFactory<RequestBlood,String>("District")); 
        UpazilaCOl.setCellValueFactory(new PropertyValueFactory<RequestBlood,String>("Upazila")); 
        OthersInfoCol.setCellValueFactory(new PropertyValueFactory<RequestBlood,String>("othersInformation")); 
        RequestTable.setItems(reqlist);
        
    }    

    @FXML
    private void delete(ActionEvent event) {
    
    
    }

    @FXML
    private void Search_action(ActionEvent event) {
    }

    @FXML
    private void blood_DonateAction(ActionEvent event) {
    
    }
    
}
