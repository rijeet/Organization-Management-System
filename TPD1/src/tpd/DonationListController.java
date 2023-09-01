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
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import static tpd.ShowAll_Apply_ScholarshipController.scholarshipList;

/**
 * FXML Controller class
 *
 * @author Mukaffi
 */
public class DonationListController implements Initializable {

    @FXML
    private TableColumn<Donation, String> username;
    @FXML
    private TableColumn<Donation, String> bkash;
    @FXML
    private TableColumn<Donation, String> tans;
    @FXML
    private TableColumn<Donation, String> amnt;
    @FXML
    private TableView<Donation> donationTable;
     public static String n1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      ObservableList<Donation> tklist = FXCollections.observableArrayList();
         donationTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
         DatabaseAction dbAction = new DatabaseAction();
        try {
            tklist= dbAction.getAllDonatoion();
        } catch (SQLException ex) {
            Logger.getLogger(DonationListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        username.setCellValueFactory(new PropertyValueFactory<Donation, String>("Username"));
        bkash.setCellValueFactory(new PropertyValueFactory<Donation, String>("Bkashno"));
        tans.setCellValueFactory(new PropertyValueFactory<Donation, String>("TransectionID"));
        amnt.setCellValueFactory(new PropertyValueFactory<Donation, String>("ammount"));
   
       
        donationTable.setItems(tklist);
        
    }    

  
    @FXML
    private void com_action(ActionEvent event) throws IOException {
        HomePageController.stage1.close();
        Stage stage = new Stage();
        ObservableList<Donation> selectedDonors=FXCollections.observableArrayList();
        selectedDonors=donationTable.getSelectionModel().getSelectedItems();
         for (Donation dn : selectedDonors) {
            n1=dn.getUsername();
             System.out.println(n1);
        }
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("confirmdonation.fxml"));
           Parent root1 = (Parent) fxmlLoader.load();
            stage.setTitle("Confirmation");
            stage.setScene(new Scene(root1));  
            stage.show();
        }
    
}
