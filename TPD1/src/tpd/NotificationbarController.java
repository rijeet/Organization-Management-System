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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Mukaffi
 */
public class NotificationbarController implements Initializable {

    @FXML
    private TableColumn<Notification, String> Noticol;
    @FXML
    private TableView<Notification> notificationTable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ObservableList<Notification> notificationlist = FXCollections.observableArrayList();
          ObservableList<Notification> notinew = FXCollections.observableArrayList();
         DatabaseAction dbAction = new DatabaseAction();
        try {
            notificationlist=dbAction.GetAllNotification();
        } catch (SQLException ex) {
            Logger.getLogger(NotificationbarController.class.getName()).log(Level.SEVERE, null, ex);
        }
       int a=0;
       for (Notification nt : notificationlist) {
             if(nt.getUsername().equals(LoginController.name1)){
                 
              notinew.add(nt);
               
               a=1;
             }
       }
       if(a==0){
       ObservableList<Notification> noti = FXCollections.observableArrayList();
           Notification noti1 =new Notification(" ","No Notification");
           noti.add(noti1);
          // notificationTable.setItems(
       notificationTable.setItems(noti);
       Noticol.setCellValueFactory(new PropertyValueFactory<Notification,String>("Notifcation"));
       /* Noticol.setCellValueFactory(new PropertyValueFactory<Notification,String>("Notifcation")); 
               notificationTable.setItems(notificationlist);
               */
       
       }
       if(a==1){Noticol.setCellValueFactory(new PropertyValueFactory<Notification,String>("Notifcation")); 
               notificationTable.setItems(notinew);
       }
    }    
    
}
