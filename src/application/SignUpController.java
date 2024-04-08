package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class SignUpController {

    @FXML
    private TextField username_field;
    @FXML
    private TextField firstname_field;
    @FXML
    private TextField lastname_field;
    @FXML
    private DatePicker dob_field;
    @FXML
    private PasswordField password_field;
    @FXML
    private PasswordField confirmpassword_field;
    @FXML
    private Text error_msg;

    @FXML
    private void exit() {
        Helper.exit();
    }
    
    @FXML
    private void goBack() throws IOException {
        Main.setRoot("Login");
    }

}
