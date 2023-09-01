package tpd;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import static tpd.Add_New_PersonController.isAlpha;
import static tpd.Add_New_PersonController.isDigit;

public class Add_Student_ForScholarShipController implements Initializable {
    
    @FXML
    private TextField First_Name;
    @FXML
    private TextField Last_Name;
    @FXML
    private TextField Shcolarship_Type;
    @FXML
    private TextField Class;
    @FXML
    private TextField gpa;
    @FXML
    private TextField Email;
    @FXML
    private TextField Phone_Number;
    @FXML
    private Label Fname;
    @FXML
    private Label phnnumber;
    @FXML
    private Label Prevgp;
    @FXML
    private Label Sch_type;
    @FXML
    private Label Lname;
    @FXML
    private Label email;
    @FXML
    private Label sClass;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    public static boolean isAlpha(String s) {
        return s != null && s.matches("^[a-zA-Z ]*$");
    }
    
    public static boolean isDigit(String s) {
        return s != null && s.matches("^[0.00-9.00]*$");
    }
    int checker;
    
    public static boolean ValidPhoneNumber(String s) {
        return Pattern.matches("^[0-9]{11}", s);
    }
    
    
      public static boolean ValidClass(String s) {
        return Pattern.matches("^[1-9]{1}", s);
    }
    
       public static boolean validateEmailAddress(String emailID) {
        String regex = "^[_a-z0-9-\\+]+(\\.[_a-z0-9-]+)*@"
                + "[a-z0-9-]+(\\.[a-z0-9]+)*(\\.[a-z]{2,})$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(emailID).matches();
	}
      
    @FXML
    private void Apply_button(ActionEvent event) throws SQLException {
        String name = (First_Name.getText() + " " + Last_Name.getText());
        String Shcolarship_type = Shcolarship_Type.getText();
        String phn = Phone_Number.getText();
        String sclass = Class.getText();
        String GPA = gpa.getText();
        String mail = Email.getText();
        checker = 0;
          if (name.equals("") || phn.equals("") || sclass.equals("") || GPA.equals("") || mail.equals("") || Shcolarship_type.equals("")) {
            Alert al = new Alert(Alert.AlertType.WARNING);
            al.setTitle("Error");
            al.setContentText("Please Fillup All Information Correctly!");
            al.showAndWait();
        } else {
        try {
            if (!isAlpha(name)) {
                Fname.setText("Invalid Name");
                checker = 1;
            }
            if (!isAlpha(Last_Name.getText())) {
                Lname.setText("Invalid Name");
                checker = 1;
            }
            if (!isDigit(GPA)) {
                Prevgp.setText("Invalid Input");
                checker = 1;
            }
            if (!ValidPhoneNumber(phn)) {
                phnnumber.setText("Invalid Number");
                checker = 1;
            }
            if (!isAlpha(Shcolarship_type)) {
                Sch_type.setText("Invalid Input");
                checker = 1;
            }
            if (!ValidClass(sclass)) {
                sClass.setText("Invalid Class(1 to 9)");
                checker = 1;
            }
            if (!validateEmailAddress(mail)) {
                email.setText("Invalid Email");
                checker = 1;
            }
            if (checker == 1) {
                throw new Exception();
            }

            
            SchoolarShip_Student schst = new SchoolarShip_Student(name, Shcolarship_type, sclass, GPA, mail, phn);
            System.out.println(schst);
            DatabaseAction dbAction = new DatabaseAction();
            dbAction.insertScholarshipStudent(schst);
            First_Name.clear();
            Last_Name.clear();
            Shcolarship_Type.clear();
            Class.clear();
            gpa.clear();
            Email.clear();
            Phone_Number.clear();
            sClass.setText("");
            Sch_type.setText("");
            Prevgp.setText("");
            phnnumber.setText("");
            Fname.setText("");
            email.setText("");
            Lname.setText("");
            
            
        } catch (Exception e) {
            
        }
    }
    }
    //SchoolarShip_Student(String Name, String ScholarShip_Type, String StudentClass, String GPA, String email, String PhoneNumber) 
    @FXML
    private void Reset_button(ActionEvent event) {
   First_Name.clear();
            Last_Name.clear();
            Shcolarship_Type.clear();
            Class.clear();
            gpa.clear();
            Email.clear();
            Phone_Number.clear();
            sClass.setText("");
            Sch_type.setText("");
            Prevgp.setText("");
            phnnumber.setText("");
            Fname.setText("");
            email.setText("");
            Lname.setText("");
    
    
    }
    
}


