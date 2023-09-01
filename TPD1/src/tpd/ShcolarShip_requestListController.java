/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpd;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;

/**
 * FXML Controller class
 *
 * @author Mukaffi
 */
public class ShcolarShip_requestListController implements Initializable {

    @FXML
    private TableColumn<?, ?> NameCol;
    @FXML
    private TableColumn<?, ?> ClassCol;
    @FXML
    private TableColumn<?, ?> Scholarship_Col;
    @FXML
    private TableColumn<?, ?> GPA_Col;
    @FXML
    private TableColumn<?, ?> email_col;
    @FXML
    private TableColumn<?, ?> number_col;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Add_button(ActionEvent event) {
    }

    @FXML
    private void Remove_button(ActionEvent event) {
    }
    
}
