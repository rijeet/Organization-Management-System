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
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Gopal Saha
 */
public class HealthChartController implements Initializable {

    @FXML
    private PieChart healthPiChart;
    @FXML
    private AnchorPane HealthChartPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //   
        DatabaseAction dbAction = new DatabaseAction();
        
        try {
            int doc=Integer.parseInt(dbAction.countDoctor());
            int pt = Integer.parseInt(dbAction.Patientcount());
            int bd = Integer.parseInt(dbAction.countDonor());
        ObservableList<PieChart.Data> pieChartData=FXCollections.observableArrayList(
                                             new PieChart.Data("Doctors",doc),
                                             new PieChart.Data("Patient",pt),
                                             new PieChart.Data("Priscribed",pt+5) ,
                                             new PieChart.Data("Blood Donor",bd) );
        healthPiChart.setData(pieChartData);
        healthPiChart.setStartAngle(90);
        } catch (SQLException ex) {
            Logger.getLogger(HealthChartController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
}

    @FXML
    private void Back_action(ActionEvent event) throws IOException {
        Parent pane=FXMLLoader.load(getClass().getResource("Health.fxml"));
        HealthChartPane.getChildren().setAll(pane);
    }
    
}
