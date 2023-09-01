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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Mukaffi
 */
public class ConfirmdonationController implements Initializable {

    @FXML
    private TextField Username;
    @FXML
    private TextArea Message;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Username.setText(DonationListController.n1);
        Message.setText("Congratulations Your Donation is Confirm ");
}

    @FXML
    private void send(ActionEvent event) {
       // System.out.println(DonationListController.n1);
    
    String username=Username.getText();
    String message=Message.getText();
    Notification noti =new Notification(username,message);
    DatabaseAction dbAction = new DatabaseAction();
        try {
            dbAction.insertNotification(noti);
        } catch (SQLException ex) {
            Logger.getLogger(ConfirmdonationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Username.clear();
        Message.clear();
    } 
    
    
    }
