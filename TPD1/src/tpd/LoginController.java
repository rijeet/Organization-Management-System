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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mukaffi
 */
public class LoginController implements Initializable {

    @FXML
    private TextField UserName;
    @FXML
   
 
    
    private BorderPane mainPane;
    @FXML
    private PasswordField password;

    /**
     * Initializes the controller class.
     */
    static String name1;
    @FXML
    private ImageView ForgetPass;
    @FXML
    private Button Forget_Password;
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loginAction(ActionEvent event) throws IOException, SQLException {
    String name=UserName.getText();
    String pass=password.getText();
    name1=UserName.getText();
       
int c=0;
    ObservableList<User> userList=FXCollections.observableArrayList(); 
     DatabaseAction dbAction = new DatabaseAction();
     userList=dbAction.getAllUser();
     for(User user:userList){
            if(user.getUsername().equals(name)&&user.getPassword().equals(pass) && user.getAccountType().equals("Admin") ){
            Parent pane=FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            mainPane.getChildren().setAll(pane);
            c=1;
            break;
          }
            else if(user.getUsername().equals(name)&&user.getPassword().equals(pass) && user.getAccountType().equals("User")){
            Parent pane=FXMLLoader.load(getClass().getResource("User_HomePage.fxml"));
            mainPane.getChildren().setAll(pane);
            c=1;
           
            }
            else if(user.getUsername().equals(name)&&user.getPassword().equals(pass) && user.getAccountType().equals("Doctor")){
            Parent pane=FXMLLoader.load(getClass().getResource("User_Doctor.fxml"));
            mainPane.getChildren().setAll(pane);
             c=1;
            }
    
    }  if(name.equals("") || pass.equals("")  ){
    Alert al= new Alert(Alert.AlertType.WARNING);
         al.setTitle("Error");
         al.setContentText("Fill-up Username & password");
         al.showAndWait();
        // c=-10;
         
   }
    else if (c==0){
     Alert al= new Alert(Alert.AlertType.WARNING);
         al.setTitle("Error");
         al.setContentText("Invalid Username & password");
         al.showAndWait();
     
     
     }
   
  
      /*  if(name.equals("a")&& pass.equals("a"))   { Parent pane=FXMLLoader.load(getClass().getResource("User_HomePage.fxml"));
            mainPane.getChildren().setAll(pane);
        }
         else if(name.equals("d")&& pass.equals("d"))   { Parent pane=FXMLLoader.load(getClass().getResource("User_Doctor.fxml"));
            mainPane.getChildren().setAll(pane);
        }
        else{ Parent pane=FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            mainPane.getChildren().setAll(pane);
        }*/
    } 

    @FXML
    private void createAction(ActionEvent event) throws IOException {
    
    Parent pane=FXMLLoader.load(getClass().getResource("Create_Page.fxml"));
            mainPane.getChildren().setAll(pane);
    
    }
 static Stage stage = new Stage();
    @FXML
    private void ForgetAction(ActionEvent event) throws IOException {
        
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Forget_Password.fxml"));
           Parent root1 = (Parent) fxmlLoader.load();
            stage.setTitle("Creating New Password");
            stage.setScene(new Scene(root1));  
            stage.show();
            
    }
    
}
