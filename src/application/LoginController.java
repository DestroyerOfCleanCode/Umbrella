package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginController {

    @FXML
    private TextField username_field;
    @FXML
    private PasswordField password_field;
    @FXML
    private Text error_msg;

    @FXML
    private void exit() {
        Helper.exit();
    }

    @FXML
    private void login() throws IOException {
        String username = username_field.getText();
        String password = password_field.getText();

        error_msg.setText("Username: " + username + " Password: " + password);
    }
    
    @FXML
    private void signup() throws IOException {
    	Main.setRoot("SignUp");
    }
}