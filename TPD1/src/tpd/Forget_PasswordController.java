/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpd;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import static tpd.Create_PageController.validatePassword;

/**
 * FXML Controller class
 *
 * @author User
 */
public class Forget_PasswordController implements Initializable {

    @FXML
    private Button SubmitButton;
    @FXML
    private TextField username;
    @FXML
    private ComboBox<String> Ques2;
    ObservableList<String> ques = FXCollections.observableArrayList("Yes", "No");
    @FXML
    private TextField password;
    @FXML
    private TextField ques1;
    @FXML
    private TextField ques3;
    @FXML
    private Label UserNameCheck;
    @FXML
    private Label PasswordCheack;
    @FXML
    private Label warningValidPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Ques2.setItems(ques);
    }
    
    
    int checker=0;
   public static boolean isAlpha(String s) {
        return s != null && s.matches("^[a-zA-Z ]*$");
    }
    public static boolean validatePassword(String PassW) {
        String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";
         
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(PassW ).matches();
    }
    

    @FXML
    private void Submit_on__Action(ActionEvent event) throws SQLException, Exception {
        ObservableList<User> userList = FXCollections.observableArrayList();
        ObservableList<AccountInformation> AccountList = FXCollections.observableArrayList();
        String userName = username.getText();
        String Question1 = ques1.getText();
        String Question2 = Ques2.getValue();
        String Question3 = ques3.getText();
        String Password = password.getText();
        
        checker = 0;
    if ( userName.equals("")|| Password.equals("")|| Question1.equals("") || Question2.equals("") ||Question3.equals("")) {
            Alert al = new Alert(Alert.AlertType.WARNING);
            al.setTitle("Error");
            al.setContentText("Please Fillup All Information Correctly!");
            al.showAndWait();
        }
    try {
     
     if (!validatePassword(Password)) {
                PasswordCheack.setText("Invalid Password. Example: 134@aBgW");
                        //Password must be at least 8 characters,at least one digit,one upper case,one lower case alphabet, one special character which includes (!@#$%&*()-+=^) but can't contain any white space.");
                checker = 1;
            }else {
            
           PasswordCheack.setText("");
            }
    if (checker == 1) {
                throw new Exception();
    } else if (checker == 0)
    {   DatabaseAction dbAction = new DatabaseAction();
        AccountList = dbAction.getAllAccountinformation();
        int a = 0;
        for (AccountInformation Accnt : AccountList) {
            if (Accnt.getUsername().equals(userName) && Accnt.getSequirity_ques1().equals(Question1) && Accnt.getSequirity_ques2().equals(Question2) && Accnt.getSequirity_ques3().equals(Question3)) {
                dbAction.Passloginifo(Password, userName);
                dbAction.updatePass(Password, userName);
                Alert al = new Alert(Alert.AlertType.INFORMATION);
                al.setTitle("Password Change");
                al.setContentText(" password Successfully Updated ");
                al.showAndWait();
                username.clear();
                password.clear();
                ques1.clear();
                Ques2.getSelectionModel().clearSelection();
                ques3.clear();
                a = 1;
                LoginController.stage.close();

            }

        }
        if (a == 0) {
            Alert al = new Alert(Alert.AlertType.WARNING);
            al.setTitle("Wrong");
            al.setContentText("Wrong Answer");
            al.showAndWait();
            LoginController.stage.close();
            //        if(user.getUsername().equals(name)&&user.getPassword().equals(pass) && user.getAccountType().equals("Admin") ){
            //      Parent pane=FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            //    mainPane.getChildren().setAll(pane);
            //  c=1;  
            //break;

            /*Alert al= new Alert(Alert.AlertType.WARNING);
         al.setTitle("Error");
         al.setContentText("Fill-up Username & password");
         al.showAndWait();*/
        }

        
        }
    
    } catch (Exception e) {

        } 
        
        
            
    }
    
    @FXML
    private void passcheck(KeyEvent event) {
   String pass=password.getText();
    if (!validatePassword(pass)) {
   warningValidPassword.setText("Atleast One Uppercase,One Number and One special characters & atleast 8 characters");
    
    }
    else {
    warningValidPassword.setText("");
    }
    }

}
