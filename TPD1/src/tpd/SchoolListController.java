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
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Mukaffi
 */
public class SchoolListController implements Initializable {

    @FXML
    private AnchorPane All_schoolAnchr;
    @FXML
    private TableView<?> School_Table;
    @FXML
    private TableColumn<?, ?> School_name;
    @FXML
    private TableColumn<?, ?> School_zila;
    @FXML
    private TableColumn<?, ?> School_upazila;
    @FXML
    private TableColumn<?, ?> School_capacity;
    @FXML
    private TableColumn<?, ?> School_vacancy;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void DeleteButton_Action(ActionEvent event) {
    }
    
}
