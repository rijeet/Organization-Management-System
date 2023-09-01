/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpd;

import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Scanner;
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
public class DonnorListController implements Initializable {
    @FXML
    private TableView<Donor> DonorTable;
    @FXML
    private TableColumn<Donor, String> NameCol;
    @FXML
    private TableColumn<Donor, String> BloodgroupCol;
    @FXML
    private TableColumn<Donor, String> PhoneNumberCol;
    @FXML
    private TableColumn<Donor, String>DistrictCol;
    @FXML
    private TableColumn<Donor, String>UpazilaCol;
    @FXML
    private TableColumn<Donor, String>DonateTimesCol;
    @FXML
    private TableColumn<Donor, String>Lastdonationcol;
    static ObservableList<Donor> Dnrlist=FXCollections.observableArrayList();
    @FXML
    private AnchorPane ListAnchor;
    @FXML
    private Button Search;
    @FXML
    private ComboBox<String> ColumnType;
      ObservableList<String> columntpye = FXCollections.observableArrayList("Name", "Blood"," Number", "District"," Upazila", "Times","Donation");
    @FXML
    private TextField Value;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ColumnType.setItems(columntpye);
        DonorTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        DatabaseAction dbAction =new DatabaseAction();
       
       // ObservableList<Donor> stdList = null;
            try {
            DonnorListController.Dnrlist= dbAction.getAllDonor();
                System.out.println(dbAction.countDonor());
           
            } catch (SQLException ex) {
            Logger.getLogger(DonnorListController.class.getName()).log(Level.SEVERE, null, ex);
            }
      
      
       
        NameCol.setCellValueFactory(new PropertyValueFactory<Donor,String>("Name")); 
        BloodgroupCol.setCellValueFactory(new PropertyValueFactory<Donor,String>("Blood_Group")); 
        PhoneNumberCol.setCellValueFactory(new PropertyValueFactory<Donor,String>("PhoneNumber")); 
        DistrictCol.setCellValueFactory(new PropertyValueFactory<Donor,String>("District")); 
        UpazilaCol.setCellValueFactory(new PropertyValueFactory<Donor,String>("Upazila")); 
        DonateTimesCol.setCellValueFactory(new PropertyValueFactory<>("DonateTimes")); 
        Lastdonationcol.setCellValueFactory(new PropertyValueFactory<Donor,String>("LastDonation")); 
        DonorTable.setItems(DonnorListController.Dnrlist);
        
        
    }    
     @FXML
    private void Delete_button_Action(ActionEvent event) throws SQLException {
   
        ObservableList<Donor> selectedDonors=FXCollections.observableArrayList();
        selectedDonors=DonorTable.getSelectionModel().getSelectedItems();
        DatabaseAction dbAction=new DatabaseAction();
        dbAction.deleteDonor(selectedDonors);
        DonnorListController.Dnrlist.removeAll(selectedDonors);
         
    
    
    }

    @FXML
    private void Search_Action(ActionEvent event) throws SQLException {
   String Type=ColumnType.getValue();
   String value=Value.getText();
   ObservableList<Donor> selectedDonors=FXCollections.observableArrayList();
    DatabaseAction dbAction=new DatabaseAction();
       selectedDonors  = dbAction.searchDonor(Type, value);
       
       
       DonorTable.setItems(selectedDonors);
       
    
    }
    
}
