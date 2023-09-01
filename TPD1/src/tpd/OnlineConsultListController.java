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
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.util.logging.Logger;
import java.util.logging.Level;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import static tpd.ShowAll_Apply_ScholarshipController.scholarshipList;

/**
 *
 * @author Gopal Saha
 */
public class OnlineConsultListController implements Initializable {

    @FXML
    private TableView<OnlineConsult> consultList;
     static ObservableList<OnlineConsult> clist = FXCollections.observableArrayList();
    @FXML
    private TextField searchBox;
    @FXML
    private ComboBox<String> searchList;
    ObservableList<String> list = FXCollections.observableArrayList("Name","UserName","Age","Problem");
    @FXML
    private TableColumn<OnlineConsult, String> name;
    @FXML
    private TableColumn<OnlineConsult, String> username;
    @FXML
    private TableColumn<OnlineConsult, String> age;
    @FXML
    private TableColumn<OnlineConsult, String> problem;
    @FXML
    private AnchorPane ConsultPane;
    public static String n;
    public static String n2;
    
 @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        searchList.setItems(list);
        consultList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
        DatabaseAction dbAction = new DatabaseAction();
        
         try {
            OnlineConsultListController.clist=dbAction.getAllConsultLsit();
         
            for (OnlineConsult oc : OnlineConsultListController.clist) {
                System.out.println(oc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OnlineConsultListController.class.getName()).log(Level.SEVERE, null, ex);
        }
       name.setCellValueFactory(new PropertyValueFactory<OnlineConsult, String>("Name"));
     username.setCellValueFactory(new PropertyValueFactory<OnlineConsult, String>("username"));
       age.setCellValueFactory(new PropertyValueFactory<OnlineConsult, String>("Age"));
       problem.setCellValueFactory(new PropertyValueFactory<OnlineConsult, String>("Problem"));
           consultList.setItems(clist);
    }
    @FXML
    private void Back_action(ActionEvent event) throws IOException {
         Parent pane=FXMLLoader.load(getClass().getResource("Patient_List.fxml"));
            ConsultPane.getChildren().setAll(pane);
    }

    @FXML
    private void searchAction(ActionEvent event) throws SQLException {
        String s1=searchList.getValue();
         String s2=searchBox.getText();
        ObservableList<OnlineConsult> oc = FXCollections.observableArrayList();
         DatabaseAction dbAction = new DatabaseAction();
         oc = dbAction.SearchPatient(s1, s2);
        consultList.setItems(oc);
    }

    @FXML
    private void Prescribe(ActionEvent event) throws IOException, SQLException {
         DatabaseAction dbAction = new DatabaseAction();
        ObservableList<OnlineConsult> selectedDonors=FXCollections.observableArrayList();
        selectedDonors=consultList.getSelectionModel().getSelectedItems();
         for (OnlineConsult dn : selectedDonors) {
            n=dn.getUsername();
            n2=dn.getProblem();
           //  System.out.println(n1);
        }
         dbAction.deletePateint(selectedDonors);
        clist.removeAll(selectedDonors);
         Parent pane=FXMLLoader.load(getClass().getResource("Prescription.fxml"));
            ConsultPane.getChildren().setAll(pane);
        
    }

   
    
}
