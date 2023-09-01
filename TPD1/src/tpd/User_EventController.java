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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author User
 */
public class User_EventController implements Initializable {

    @FXML
    private TableView<Event> EventTable;
    @FXML
    private TableColumn<Event,String> SL_Col;
    @FXML
    private TableColumn<Event, String> Name_col;
    @FXML
    private TableColumn<Event, String> Date_Col;
    @FXML
    private TableColumn<Event, String> Time_Col;
    @FXML
    private TableColumn<Event, String> Place_Col;
    @FXML
    private TableColumn<Event, String> Description_Col;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      ObservableList<Event> eventlist = FXCollections.observableArrayList();
        EventTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        DatabaseAction dbAction =new DatabaseAction();
        try {
           eventlist= dbAction.getAllEvent();
        } catch (SQLException ex) {
            Logger.getLogger(User_EventController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        SL_Col.setCellValueFactory(new PropertyValueFactory<Event,String>("Sl_No")); 
        Name_col.setCellValueFactory(new PropertyValueFactory<Event,String>("Event_name")); 
        Date_Col.setCellValueFactory(new PropertyValueFactory<Event,String>("Event_Date")); 
        Time_Col.setCellValueFactory(new PropertyValueFactory<Event,String>("Event_Time")); 
        Place_Col.setCellValueFactory(new PropertyValueFactory<Event,String>("Event_Place")); 
        Description_Col.setCellValueFactory(new PropertyValueFactory<Event,String>("Event_discription")); 
        EventTable.setItems(eventlist);
       /* String Sl_No;
    String Event_name;
    String Event_Date;
    String Event_Time;
    String Event_Place;
    String Event_discription;*/


    }    
    
}
