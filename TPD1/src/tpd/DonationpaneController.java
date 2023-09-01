package tpd;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Mukaffi
 */
public class DonationpaneController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private TextField bkashNo;
    @FXML
    private TextField Transection;
    @FXML
    private Button sendAction;
    @FXML
    private TextField ammountNo;
    @FXML
    private TextField month;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void sendbuttion(ActionEvent event) {
        String Username = username.getText();
        String Bkashno = bkashNo.getText();
        String ammount = ammountNo.getText();
        String TransectionID = Transection.getText();
        String m = month.getText();
        Donation dona = new Donation(Username, Bkashno, ammount, TransectionID, m);
        DatabaseAction dbAction = new DatabaseAction();
        try {
            dbAction.insertdonation(dona);
        } catch (SQLException ex) {
            Logger.getLogger(DonationpaneController.class.getName()).log(Level.SEVERE, null, ex);
        }

        username.clear();
        bkashNo.clear();

        Transection.clear();

        ammountNo.clear();
        month.clear();

    }
}
