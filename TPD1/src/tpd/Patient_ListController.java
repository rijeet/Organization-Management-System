/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpd;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author User
 */
public class Patient_ListController implements Initializable {

    @FXML
    private AnchorPane Patient_List_Pane;
    @FXML
    private Button BackButton;
    @FXML
    private Button Patient_List_Button;
    @FXML
    private HBox Patient_List_Hbox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    

    @FXML
    private void Back_Button_action(ActionEvent event) throws IOException {
        Parent pane=FXMLLoader.load(getClass().getResource("User_Doctor.fxml"));
        Patient_List_Pane.getChildren().setAll(pane);
    }

    @FXML
    private void Show_ALL_patient(ActionEvent event) throws IOException {
    Parent pane=FXMLLoader.load(getClass().getResource("OnlineConsultList.fxml"));
        Patient_List_Pane.getChildren().setAll(pane);
   }
    
}
