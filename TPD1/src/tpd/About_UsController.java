/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpd;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javafx.event.ActionEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author User
 */
public class About_UsController implements Initializable {
    
     private static final String FACEBOOK_1 = "http://facebook.com/swarnajit.saha.528";
     private static final String FACEBOOK_2 = "http://facebook.com/whothehellismukaffi";
     private static final String FACEBOOK_3 = "http://facebook.com/rijeet95";
     private static final String WEBSITE    = "https://sites.google.com/aust.edu/the-peoples-dream/home";
    

    @FXML
    private TextArea TEXT_FIELD;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     
    }    
     private void loadWebpage(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException e1) {
            e1.printStackTrace();
            handleWebpageLoadException(url);
        }
    } 
     
     private void handleWebpageLoadException(String url) {
        WebView browser = new WebView();
        WebEngine webEngine = browser.getEngine();
        webEngine.load(url);
      }
     
    
    @FXML
    private void loadFacebook1(ActionEvent event) {
        loadWebpage(FACEBOOK_1);
    }
    
    @FXML
    private void loadFacebook2(ActionEvent event) {
        loadWebpage(FACEBOOK_2);
    }
    
    @FXML
    private void loadFacebook3(ActionEvent event) {
        loadWebpage(FACEBOOK_3);
    }
    @FXML
    private void loadWebsite(ActionEvent event) {
        loadWebpage(WEBSITE);
    }
}
