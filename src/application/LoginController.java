package application;

import java.io.IOException;

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

        if (username.isBlank() || password.isBlank()) {
            error_msg.setText("Please fill in all fields");
            return;
        }

        if (Helper.BCryptAuth(password, Helper.BCryptHash("123"))) {
            error_msg.setText("Login successful");
            
            if (username.equalsIgnoreCase("patient"))
            	Main.setRoot("PatientView");
            if (username.equalsIgnoreCase("doctor") || username.equalsIgnoreCase("nurse"))
            	Main.setRoot("OfficeMenuPage");
        }
    }

    @FXML
    private void signUp() throws IOException {
        Main.setRoot("SignUp");
    }
}
