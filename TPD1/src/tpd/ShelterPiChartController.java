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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Gopal Saha
 */
public class ShelterPiChartController implements Initializable {

    @FXML
    private AnchorPane ShelterChartPane;
    @FXML
    private PieChart shelterPi;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         DatabaseAction dbAction = new DatabaseAction();
       
        try {  int or = Integer.parseInt(dbAction.orphancount());
            int op = Integer.parseInt(dbAction.OldPeoplecount());
             int orhome = Integer.parseInt(dbAction.orphanagecount());
            int ophome = Integer.parseInt(dbAction.oldagehomecount());
        ObservableList<PieChart.Data> pieChartData=FXCollections.observableArrayList(
                                             new PieChart.Data("Orphanage",orhome),
                                             new PieChart.Data("Old Age Home",ophome),
                                             new PieChart.Data("Old People",op),
                                             new PieChart.Data("Orphan",or) );
        
        
        shelterPi.setData(pieChartData);
        shelterPi.setStartAngle(90);} catch (SQLException ex) {
            Logger.getLogger(ShelterPiChartController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
}
   

    @FXML
    private void Back_action(ActionEvent event) throws IOException {
         Parent pane=FXMLLoader.load(getClass().getResource("Shelter.fxml"));
        ShelterChartPane.getChildren().setAll(pane);
    }
    
}
