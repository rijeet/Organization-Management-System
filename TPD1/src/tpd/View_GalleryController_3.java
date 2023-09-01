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
public class View_GalleryController_3 implements Initializable {

    @FXML
    private AnchorPane gallery;
    @FXML
    private HBox gallerybox2;
    @FXML
    private Button Next;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     @FXML
    private void NextButton_Action(ActionEvent event) throws IOException {
     Parent pane=FXMLLoader.load(getClass().getResource("View_Gallery.fxml"));
            gallerybox2.getChildren().setAll(pane);
    }
}
