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
public class EducationPiChartController implements Initializable {

    @FXML
    private AnchorPane Educationchartpane;
    @FXML
    private PieChart educationPiChart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        DatabaseAction dbAction = new DatabaseAction();

        try {

            int st = Integer.parseInt(dbAction.StudentCount());
            int schl = Integer.parseInt(dbAction.ScholarshipCount());
            int school = Integer.parseInt(dbAction.SchoolCount());
            ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                    new PieChart.Data("Student", st),
                    new PieChart.Data("School", school),
                    new PieChart.Data("Scholarship", schl));
            educationPiChart.setData(pieChartData);
            educationPiChart.setStartAngle(90);
        } catch (SQLException ex) {
            Logger.getLogger(EducationPiChartController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void Back_action(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("Education.fxml"));
        Educationchartpane.getChildren().setAll(pane);
    }

}
