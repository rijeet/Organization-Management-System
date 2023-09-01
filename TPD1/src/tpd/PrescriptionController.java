/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpd;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Gopal Saha
 */
public class PrescriptionController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private TextField solution;
    @FXML
    private AnchorPane prescribePane;
    @FXML
    private TextField problem;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      username.setText(OnlineConsultListController.n);
      problem.setText(OnlineConsultListController.n2);
    }    

    @FXML
    private void SaveAction(ActionEvent event) throws SQLException {
        String uname=username.getText();
        String prob=problem.getText();
        String sol=solution.getText();
        prescribe p=new prescribe(uname,prob,sol);
        Notification no =new Notification(uname,"Your Problem was "+prob+" Solution is : "+sol);
          DatabaseAction dbAction = new DatabaseAction();
          dbAction.insertPrescription(p);
          dbAction.insertNotification(no);
          problem.setText("");
        username.setText("");
        solution.setText("");

    }

    @FXML
    private void Reset_Action(ActionEvent event) {
        problem.setText("");
        username.setText("");
        solution.setText("");

    }

    @FXML
    private void BackAction(ActionEvent event) throws IOException {
           Parent pane=FXMLLoader.load(getClass().getResource("OnlineConsultList.fxml"));
            prescribePane.getChildren().setAll(pane);
    }
    
}
