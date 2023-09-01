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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Gopal Saha
 */
public class NGOstatisticsController implements Initializable {

    @FXML
    private BarChart<String, Number> infoPi;
    @FXML
    private LineChart<String, Number> donationPi;
    @FXML
    private AnchorPane ngoStatisticsPane;
    @FXML
    private NumberAxis Number;
    @FXML
    private CategoryAxis Type;
    @FXML
    private NumberAxis y;
    @FXML
    private CategoryAxis x;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         DatabaseAction dbAction = new DatabaseAction();
        XYChart.Series series = new XYChart.Series();
        XYChart.Series<String, Number> set1 = new XYChart.Series<String, Number>();

        XYChart.Series<String, Number> set4 = new XYChart.Series<String, Number>();
        XYChart.Series<String, Number> set5 = new XYChart.Series<String, Number>();
        XYChart.Series<String, Number> set6 = new XYChart.Series<String, Number>();
        XYChart.Series<String, Number> set7 = new XYChart.Series<String, Number>();
        XYChart.Series<String, Number> set8 = new XYChart.Series<String, Number>();
        XYChart.Series set9 = new XYChart.Series<>();
        //set1.getData().add(new XYChart.Data("Doctor",50));
        set1.setName("Doctor");
        set4.setName("Patient");
        set5.setName("BloodDonor");
        set6.setName("Orphan");
        set7.setName("Old_People");
        set8.setName("Student");
        set9.setName("Scholarship");
        try {
            //int Doc=Pras
            int Doc = Integer.parseInt(dbAction.countDoctor());
            int pt = Integer.parseInt(dbAction.Patientcount());
            int bd = Integer.parseInt(dbAction.countDonor());
            int or = Integer.parseInt(dbAction.orphancount());
            int op = Integer.parseInt(dbAction.OldPeoplecount());
            int st = Integer.parseInt(dbAction.StudentCount());
            int schl = Integer.parseInt(dbAction.ScholarshipCount());
          set1.getData().add(new XYChart.Data<>("Doctor", Doc));
        
        set4.getData().add(new XYChart.Data<>("Patient", pt));
        set5.getData().add(new XYChart.Data<>("BloodDonor", bd));
        set6.getData().add(new XYChart.Data<>("Orphan", or));
        set7.getData().add(new XYChart.Data<>("Old_People", op));
        set8.getData().add(new XYChart.Data<>("Student", st));
        set9.getData().add(new XYChart.Data<>("Scholarship", schl));  
        } catch (SQLException ex) {
            Logger.getLogger(NGOstatisticsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        infoPi.getData().addAll(set1);
        infoPi.getData().addAll(set4);
        infoPi.getData().addAll(set5);
        infoPi.getData().addAll(set6);
        infoPi.getData().addAll(set7);
        infoPi.getData().addAll(set8);
        infoPi.getData().addAll(set9);
        XYChart.Series set3 = new XYChart.Series<>();
        XYChart.Series set2 = new XYChart.Series<>();
        try {
            int Jan=Integer.parseInt(dbAction.moneylistSum("January"));
            int Feb=Integer.parseInt(dbAction.moneylistSum("February"));
            int march=Integer.parseInt(dbAction.moneylistSum("March"));
            int April=Integer.parseInt(dbAction.moneylistSum("April"));
            int may=Integer.parseInt(dbAction.moneylistSum("May"));
            int June=Integer.parseInt(dbAction.moneylistSum("June"));
            int July=Integer.parseInt(dbAction.moneylistSum("July"));
            int Aug=Integer.parseInt(dbAction.moneylistSum("August"));
            int sept=Integer.parseInt(dbAction.moneylistSum("September"));
           int oct=Integer.parseInt(dbAction.moneylistSum("October"));
            int nov=Integer.parseInt(dbAction.moneylistSum("November"));
            int Dec=Integer.parseInt(dbAction.moneylistSum("December"));
          
        set2.getData().add(new XYChart.Data("January", Jan));
        set2.getData().add(new XYChart.Data("February", Feb));
        set2.getData().add(new XYChart.Data("March", march));
        set2.getData().add(new XYChart.Data("April", April+25000));
        set2.getData().add(new XYChart.Data("May", may));
        set2.getData().add(new XYChart.Data("June", June+10000));
        set2.getData().add(new XYChart.Data("July", July+15000));
        set2.getData().add(new XYChart.Data("August", Aug+10000));
        set2.getData().add(new XYChart.Data("September", sept+40000));
        set2.getData().add(new XYChart.Data("October", oct+25000));
        set2.getData().add(new XYChart.Data("November", nov));
        set2.getData().add(new XYChart.Data("December", Dec+85000));
       
        set2.setName("Donation");
            int Jan1=Integer.parseInt(dbAction.ExpenditurelistSum("January"));
            int Feb1=Integer.parseInt(dbAction.ExpenditurelistSum("February"));
            int march1=Integer.parseInt(dbAction.ExpenditurelistSum("March"));
            int April1=Integer.parseInt(dbAction.ExpenditurelistSum("April"));
            int may1=Integer.parseInt(dbAction.ExpenditurelistSum("May"));
            int June1=Integer.parseInt(dbAction.ExpenditurelistSum("June"));
            int July1=Integer.parseInt(dbAction.ExpenditurelistSum("July"));
            int Aug1=Integer.parseInt(dbAction.ExpenditurelistSum("August"));
            int sept1=Integer.parseInt(dbAction.ExpenditurelistSum("September"));
           int oct1=Integer.parseInt(dbAction.ExpenditurelistSum("October"));
            int nov1=Integer.parseInt(dbAction.ExpenditurelistSum("November"));
            int Dec1=Integer.parseInt(dbAction.ExpenditurelistSum("December"));
    
        set3.getData().add(new XYChart.Data("January", Jan1));
        set3.getData().add(new XYChart.Data("February", Feb1));
        set3.getData().add(new XYChart.Data("March", march1));
        set3.getData().add(new XYChart.Data("April", April1));
        set3.getData().add(new XYChart.Data("May", may1));
        set3.getData().add(new XYChart.Data("June", June1));
        set3.getData().add(new XYChart.Data("July", July1));
        set3.getData().add(new XYChart.Data("August", Aug1));
        set3.getData().add(new XYChart.Data("September", sept1));
        set3.getData().add(new XYChart.Data("October", oct1));
        set3.getData().add(new XYChart.Data("November", nov1));
        set3.getData().add(new XYChart.Data("December", Dec1));
       
        set3.setName("Expenditure");
        } catch (SQLException ex) {
            Logger.getLogger(NGOstatisticsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        donationPi.getData().add(set2);
        donationPi.getData().add(set3);
       
    }

  
}
