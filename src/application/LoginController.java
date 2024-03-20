package application;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField username_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private void login() {
        String username = username_field.getText();
        String password = password_field.getText();

        System.out.println("Username: " + username + " Password: " + password);
    }

    @FXML
    public void exit() {
        System.exit(0);
    }
}
